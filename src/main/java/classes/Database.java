/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jonas
 */
public class Database {

    private static String dbURL = "jdbc:derby://localhost:1527/AntonsSkafferi";
    private static String user = "anton";
    private static String pw = "anton";

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, user, pw);
    }

}
