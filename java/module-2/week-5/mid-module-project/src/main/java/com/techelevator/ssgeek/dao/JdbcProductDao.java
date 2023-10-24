package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao{

    private static JdbcTemplate template;

    public JdbcProductDao(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }



    @Override
    public Product getProductById(int productId) {
        try {
            String sql = "SELECT * from product where product_id = ?";
            SqlRowSet rs = template.queryForRowSet(sql, productId);
            if(rs.next()){
                Product product = mapRowToProduct(rs);
                return product;
            }
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products";
            SqlRowSet rs = template.queryForRowSet(sql);
            while(rs.next()){
                Product product = mapRowToProduct(rs);
                products.add(product);
            }
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product JOIN sale on sale.sale_id = line_item.sale_id JOIN line_item on line_item.product_id = product.product_id WHERE sale_id IS NULL;";
        SqlRowSet rs = template.queryForRowSet(sql);
        while(rs.next()){
            Product product = mapRowToProduct(rs);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(Product newProduct) {
        try {
            String sql = "INSERT INTO product(name, description, price, image_name) VALUES(?,?,?,?) RETURNING product_id";
            SqlRowSet rs = template.queryForRowSet(sql, int.class, newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getImageName());
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return newProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        Product newUpdatedProduct = null;
        try {
            Integer numRow = template.update("Update product set name = ? where product_id = ?;", updatedProduct.getName(), updatedProduct.getProductId());
            if (numRow == 0) {
                throw new DaoException("No Rows have been changed");
            } else {
                newUpdatedProduct = getProductById(updatedProduct.getProductId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException(e.getMessage());
        }
        return updatedProduct;
    }

    @Override
    public int deleteProductById(int productId) {
        int numOfRows = 0;
        try{
        numOfRows = template.update("Delete from product where product_id = ?", productId);
        }
        catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch(DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return numOfRows;
    }

    private static Product mapRowToProduct(SqlRowSet rs) {
        int id = rs.getInt("product_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        String imageName = rs.getString("image_name");
        Product product =new Product(id, name, description, price, imageName);
        return product;
    }
}
