/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioifelse;

import GUI.Principal;
import java.util.ArrayList;

/**
 *
 * @author giani
 */
public class EjercicioIfElse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        BD.Conexion con = new BD.Conexion();
//        con.Conectar();
//        System.out.println(con.esValida());
//        Entidades.ControlNumeros  cn = new Entidades.ControlNumeros(con);
//        ArrayList<Integer> numeros = new ArrayList<>();
//        numeros.add(1);
//        numeros.add(10);
//        numeros.add(5123);
//        numeros.add(10000);
//        cn.cargarNumeros(numeros);
        
//        for (int i = 0; i < 1000000; i++) {
//            if (cn.esPrimoCircular(i)) {
//                System.out.println("El numero " + i + " es primo circular");
//            }
        Principal principal = new GUI.Principal();
        principal.setVisible(true);
    }
}
