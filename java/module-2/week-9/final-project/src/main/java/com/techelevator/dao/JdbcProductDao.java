package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcProductDao implements ProductDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate((dataSource));
    }
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * from product");
        while(rs.next()){
            Product product = mapProduct(rs);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from product where product_id = ?", id);
        if(rs.next()){
            Product product = mapProduct(rs);
            return product;
        }
        return null;
    }

    @Override
    public Product getProductBySku(int sku) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from product where product_sku = ?",sku);
        if(rs.next()){
            Product product = mapProduct(rs);
            return product;
        }
        return null;
    }
    private static Product mapProduct(SqlRowSet rs){
        int id = rs.getInt("product_id");
        String sku = rs.getString("product_sku");
        String description = rs.getString("description");
        String name = rs.getString("name");
        BigDecimal price = rs.getBigDecimal("price");
        String imageName = rs.getString("image_name");
        Product product = new Product();
        product.setProductId(id);
        product.setProductSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setImageName(imageName);
        product.setPrice(price);
        return product;
    }
}
