/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioifelse;

import GUI.Principal;

/**
 *
 * @author giani
 */
public class EjercicioIfElse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BD.Conexion con = new BD.Conexion();
        con.Conectar();
        Entidades.ControlNumeros cn = new Entidades.ControlNumeros();
//        for (int i = 0; i < 1000000; i++) {
//            if (cn.esPrimoCircular(i)) {
//                System.out.println("El numero " + i + " es primo circular");
//            }
        GUI.Principal principal = new GUI.Principal();
        principal.setVisible(true);
    }
}
