package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pojo.Product;

public class ProductDaoImpl implements ProductDAO {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String insert = "insert into product values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, product.getpID());
			ps.setString(2, product.getpName().toUpperCase());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getCategory().toUpperCase());
			int update = ps.executeUpdate();
			if (update > 0) {
				flag = true;
				System.out.println("Query executed successfully");
			} else {
				System.out.println("Error in executing query");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean updateProductPrice(int id, double price) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String insert = "update product set price=? where pid=?";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			int update = ps.executeUpdate();
			if (update > 0) {
				flag = true;
				System.out.println("Query executed successfully");
			} else {
				System.out.println("Error in executing query");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean updateProductQuantity(int id, int quantity) {
		// TODO Auto-generated method stub
		boolean flag = true;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String insert = "update product set quantity=? where pid=?";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			int update = ps.executeUpdate();
			if (update > 0) {
				flag = true;
				System.out.println("Query executed successfully");
			} else {
				System.out.println("Error in executing query");
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public boolean findById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String data = "select * from product where pid=?";
			PreparedStatement ps = con.prepareStatement(data);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + "," + resultSet.getInt(3) + ","
						+ resultSet.getInt(4) + "," + resultSet.getString(5));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean findAll() {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");

			String data = "select * from product";
			Statement st = con.createStatement();

			ResultSet resultSet = st.executeQuery(data);

			while (resultSet.next()) {
				flag = true;
				System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + "," + resultSet.getInt(3) + ","
						+ resultSet.getInt(4) + "," + resultSet.getString(5));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean findAllByCategory(String category) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott1", "tiger1");
			String data = "select *  from product where category=?";
			PreparedStatement ps = con.prepareStatement(data);
			ps.setString(1, category.toUpperCase());
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				flag = true;
				System.out.println(resultSet.getInt(1) + "," + resultSet.getString(2) + "," + resultSet.getInt(3) + ","
						+ resultSet.getInt(4) + "," + resultSet.getString(5));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

}