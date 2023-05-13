/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Halaili
 */
public class Connexion {
public static String driver = "com.mysql.cj.jdbc.Driver";
public static String url = "jdbc:mysql://localhost/bd_tuto";
public static String user = "root";
public static String password = "";

public static Connection getConnect() {
    Connection con = null;
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        if (con != null) {
            System.out.println("Connected to database!");
            return con;
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return null;
}    
}
