/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Felix
 */
public class DataConnect {
    private static String dbURL = "jdbc:derby://localhost:1527/AntonsSkafferi;create=true;user=anton;password=anton";

	public static Connection getConnection() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
                        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			/*Connection con = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/AntondsSkafferi", "anton", "anton");*/
                        Connection con = DriverManager.getConnection(dbURL); 
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}