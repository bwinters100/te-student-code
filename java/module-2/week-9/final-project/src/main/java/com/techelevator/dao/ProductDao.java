package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    Product getProductById(int id);

    Product getProductBySku(int sku);
}
