package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcProductDaoTest extends BaseDaoTests {

    private JdbcProductDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new JdbcProductDao(dataSource);
    }

    @Test
    public void getProductById() {
        

    }

    @Test
    public void getProducts() {
    }

    @Test
    public void getProductsWithNoSales() {
    }

    @Test
    public void createProduct() {
    }

    @Test
    public void updateProduct() {
    }

    @Test
    public void deleteProductById() {
    }
}