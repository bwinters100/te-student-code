package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcCustomerDaoTest extends BaseDaoTests {


    private static final Customer CUSTOMER1 = new Customer(1, "Customer 1", "Addr 1-1", "Addr 1-2", "City 1", "S1", "11111");
    private static final Customer CUSTOMER2 = new Customer(2, "Customer 2", "Addr 2-1", "Addr 2-2", "City 2", "S2", "22222");

    private JdbcCustomerDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new JdbcCustomerDao(dataSource);
    }

    @Test
    public void getCustomerById() {
        Customer customer = dao.getCustomerById(1);
        Assert.assertEquals(CUSTOMER1, customer);

        customer = dao.getCustomerById(2);
        Assert.assertEquals(CUSTOMER2, customer);

    }

    @Test
    public void getCustomers() {
        List<Customer> customers = dao.getCustomers();

        Assert.assertEquals(4, customers.size());
        Assert.assertNotNull(customers);
        Assert.assertEquals(CUSTOMER1, customers.get(0));
        Assert.assertEquals(CUSTOMER2, customers.get(1));
    }

    @Test
    public void createCustomer() {
        Customer customer = dao.createCustomer(CUSTOMER1);

        Assert.assertEquals(CUSTOMER1, customer);
        Assert.assertNotNull(customer);

    }

    @Test
    public void updateCustomer() {
        Customer customerToUpdate = dao.getCustomerById(1);
        Assert.assertNotNull(customerToUpdate);

        customerToUpdate.setName("Updated Name");
        Customer updatedCustomer = dao.updateCustomer(customerToUpdate);

        Customer customer = dao.getCustomerById(1);
        Assert.assertEquals(updatedCustomer.getName(), customer.getName());


    }
}