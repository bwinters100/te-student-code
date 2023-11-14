package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductDao dao;

    public ProductController(ProductDao dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return dao.getProducts();
    }
    
}
