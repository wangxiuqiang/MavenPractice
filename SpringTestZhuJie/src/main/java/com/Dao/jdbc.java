package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.remoting.RemoteTimeoutException;

public class jdbc {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/test";
    static Connection conn  = null;
    static {
		try {
            Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  static Connection getConn() throws Exception {
		if(conn == null){
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;

	}
}
