/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author giani
 */
public class ControlNumeros {

    public ControlNumeros() {
    }

    //Verifica si el numero es primo
    public boolean esPrimo(int x) {
        int numero = Math.abs(x); //Saca el valor absoluto del numero ingresado
        if (numero == 1 || numero == 0 || numero == 4) {// Los numero 1,2 y 4 no son primos
            return false;
        }
        for (int i = 2; i < (numero/2); i++) {//Determina si el numero es primo
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Verifica si el numero es primo circular
    public boolean esPrimoCircular(int n) {
        boolean result = false;
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
}
