package com.dao;
import com.pojo.Product;

public interface ProductDAO {

		boolean addProduct(Product product);

		boolean updateProductPrice(int productId, double price);

		boolean updateProductQuantity(int productId, int quantity);

		boolean findById(int productId);

		boolean findAll();

		boolean findAllByCategory(String category);
	}


