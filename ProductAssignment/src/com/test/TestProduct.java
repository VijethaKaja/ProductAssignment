package com.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dao.ProductDAO;
import com.dao.ProductDaoImpl;
import com.io.ProductIO;
import com.io.ProductIOImpl;
public class TestProduct {

	public static void main(String[] args) {
				// TODO Auto-generated method stub

				BufferedReader br = null;
				ProductIO productIOImpl = new ProductIOImpl();
				ProductDAO productDAOImpl = new ProductDaoImpl();
				try {
					while (true) {
						br = new BufferedReader(new InputStreamReader(System.in));
						System.out.println(
								"\n 1. Add new Product \n 2. Update product price \n 3. Update product quantity  \n 4. Find product by id \n 5. List all products \n 6. List all products by categories \n 7. Exit");
						System.out.println("Enter your choice");
						int no = Integer.parseInt(br.readLine());
						switch (no) {

						case 1:
							if (productDAOImpl.addProduct(productIOImpl.getProduct())) {
								System.out.println("Product added");
							} else {
								System.out.println("No product added");
							}
							break;

						case 2:
							System.out.println("Enter product id to update price");
							System.out.println("Enter the id");
							int id = Integer.parseInt(br.readLine());
							System.out.println("Enter the price");
							double price = Double.parseDouble(br.readLine());
							if (!productDAOImpl.updateProductPrice(id, price)) {
								System.out.println("Product with id " + id + " not found");
							} else {
								System.out.println("Product price updated");
							}

							break;

						case 3:
							System.out.println("Enter product id to update quantity");
							System.out.println("Enter the id");
							id = Integer.parseInt(br.readLine());
							System.out.println("Enter the quantity");
							int quantity = Integer.parseInt(br.readLine());
							if (!productDAOImpl.updateProductQuantity(id, quantity)) {
								System.out.println("Product with id " + id + " not found");
							} else {
								System.out.println("Product quantity  updated");
							}
							break;

						case 4:
							System.out.println("Enter the id");
							id = Integer.parseInt(br.readLine());
							if (!productDAOImpl.findById(id)) {
								System.out.println("Product with id " + id + " not found");
							}
							break;

						case 5:
							if (!productDAOImpl.findAll()) {
								System.out.println("No products found");
							}
							break;
						case 6:
							System.out.println("Enter the category to list products");
							String category = br.readLine();
							if (!productDAOImpl.findAllByCategory(category)) {
								System.out.println("No products found with category " + category);
							}

							break;
						case 7:
							System.out.println("Exited...");
							System.exit(0);
							break;
						default:
							System.out.println("Entered invalid choice");
							break;
						}
					}

				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}

		
	}


