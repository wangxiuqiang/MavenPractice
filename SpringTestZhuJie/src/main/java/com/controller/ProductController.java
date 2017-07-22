package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dao.jdbc;
import com.domain.Product;
import com.form.ProductForm;

@Controller
public class ProductController {
	private final static Log logger = LogFactory.getLog(ProductController.class);

	@RequestMapping("/product_input")
	public String inputProduct() {
		logger.info("inputProduct called");

		return "ProductForm";
	}

	@RequestMapping("/product_save")
	public String saveProduct(ProductForm productForm, Model model) {
		logger.info("SavaProduct called");

		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setPrice(Float.parseFloat(productForm.getPrice()));
//		String driver = "com.mysql.jdbc.Driver";
//		String user = "root";
//		String password = "root";
//		String url = "jdbc:mysql://localhost:3306/test";
//		Connection conn = null;
//		try {
//			if (conn == null) {
//				conn = DriverManager.getConnection(url, user, password);
//			}
//
//			String sql = "insert into product(name,description,price) values(?,?,?)";
//			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setString(1, "d");
//			statement.setString(2, "d");
//			statement.setFloat(3, 3);
//			statement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		model.addAttribute("product", product);
		return "ProductDetails";
	}

}
