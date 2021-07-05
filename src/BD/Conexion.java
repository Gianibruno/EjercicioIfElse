/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;

/**
 *
 * @author giani
 */
public class Conexion {

    //Atributos
    private String DBname,
            ip,
            port,
            user,
            pass,
            driver = "org.mariadb.jdbc.Driver",
            url;

    private java.sql.Connection conexion;
    private Exception ex;

    public Conexion() {
        DBname = "bdifelse";
        ip = "localhost";
        port = "3306";
        user = "root";
        pass = "";
        url = "jdbc:mariadb://" + this.ip + ":" + this.port + "/" + this.DBname + "";
        registrarDriver();
    }

    public Conexion(String DBname, String ip, String port, String user, String pass, String url) {
        this.DBname = DBname;
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.url = "jdbc:mariadb://" + this.ip + ":" + this.port + "/" + this.DBname + "";
        registrarDriver();
    }

    // <editor-fold defaultstate="collapsed" desc=" Metodos Setters y Getters">
    public String getDBname() {
        return DBname;
    }

    public void setDBname(String DBname) {
        this.DBname = DBname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }
    //</editor-fold>

    public void Conectar() {
        registrarDriver();
        this.url = "jdbc:mariadb://" + this.ip + ":" + this.port + "/" + this.DBname + "";
        try {
            conexion = java.sql.DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC", user, pass);
            System.out.println("Conexion con exito");
        } catch (java.sql.SQLException ex) {
            System.out.println("Fallo de conexion");
            this.setEx(ex);
            conexion = null;
        }
    }
    
    public void actualizarUrl(){
        this.url = "jdbc:mariadb://" + this.ip + ":" + this.port + "/" + this.DBname + "";
    }

    private void registrarDriver() {
        try {
            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            System.out.println(("Error al registrar Driver: " + ex.getMessage()));
            this.setEx(ex);
        }
    }
    public boolean esValida(){
        try {
            return (conexion != null) ? conexion.isValid(1000) : false;
        } catch (java.sql.SQLException ex) {
            this.setEx(ex);
            return false;
        }
    }

}
