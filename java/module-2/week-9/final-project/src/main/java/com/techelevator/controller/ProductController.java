package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductDao dao;

    public ProductController(ProductDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> list(@RequestParam(defaultValue = "") String product_sku, @RequestParam(defaultValue = " ") String product_name){
        if (!product_sku.equals("")) {
            return dao.getProductBySku(product_sku);
        }
        if (product_name.equals("")) {
            return dao.getProductByName(product_name);
        }
        return dao.getProducts();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable int id) {
        Product product = dao.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        } else {
            return dao.getProductById(id);
        }
    }
    
}
