package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;

import com.domain.Product;

@Service
public class jdbc implements jdbcImplement{
    public int test(Product product){
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = null;
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, password);
			    System.out.println("Yes");
			}

			String sql = "insert into product(name,description,price) values(?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setFloat(3, product.getPrice());
			int i = statement.executeUpdate();
			System.out.println("\n "+i +"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
    }
	
}
