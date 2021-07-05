/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author giani
 */
public class ControlNumeros {

    private BD.Conexion con;
    private Exception ex;

    public ControlNumeros(BD.Conexion con) {
        this.con = con;
        this.ex = null;
    }

    public ControlNumeros() {
        this.con = null;
        this.ex = null;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    //Verifica si el numero es primo
    public boolean esPrimo(int x) {
        int numero = Math.abs(x); //Saca el valor absoluto del numero ingresado
        if (numero == 1 || numero == 0 || numero == 4) {// Los numero 1,2 y 4 no son primos
            return false;
        }
        for (int i = 2; i < (numero / 2); i++) {//Determina si el numero es primo
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Verifica si el numero es primo circular
    public boolean esPrimoCircular(int n) {
        boolean result = false;
        if(n<10&&this.esPrimo(n)){
            return true;
        }
        String cadenaNum = String.valueOf(n); //Guarda el numero como string para poder rotarlos
        if (this.esPrimo(n)) { //Verifica si el numero original es primo, en caso de que si, procede verificando el resto de conjuntos
            char j;
            for (int i = 0; i < cadenaNum.length() - 1; i++) {
                j = cadenaNum.charAt(i);
                cadenaNum = cadenaNum.charAt(cadenaNum.length() - 1) + cadenaNum.substring(0, cadenaNum.length() - 1);//Rota los numeros dentro del string
                int ver = Integer.parseInt(cadenaNum);
                if (this.esPrimo(ver)) {//Verifica si el nuevo orden numerico es primo
                    result = true;
                } else {
                    return false;
                }
            }
        }
        if (result == true) {
            return result;
        } else {
            return false;
        }
    }

    //Obtiene todos los numeros primos circulares entre 0 y 1000000
    public ArrayList<Integer> obtenerPrimosCirculares() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            if (this.esPrimoCircular(i)) {
                System.out.println("El numero " + i + " es primo circular");
                lista.add(i);
            }
        }
        return lista;
    }

    public boolean cargarNumeros(ArrayList<Integer> numeros) {
        this.setEx(null);
        String sql = "INSERT INTO numerosprimos (numero) VALUES (?);";
        try {
            for (int i = 0; i < numeros.size(); i++) {
                java.sql.PreparedStatement ps = con.getConexion().prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, numeros.get(i));
                ps.executeUpdate();
                ps.close();
            }
        } catch (java.sql.SQLException exeption) {
            System.out.println("ERROR EN CARGA A DB");
            this.setEx(exeption);
            System.out.println(exeption);
        }
        if (this.getEx() == null) {
            System.out.println("¡Carga de datos con exito!");
            return true;
        } else {
            return false;
        }
    }

}
