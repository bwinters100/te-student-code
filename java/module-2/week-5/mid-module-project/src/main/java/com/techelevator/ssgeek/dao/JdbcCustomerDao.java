package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate template;

    public JdbcCustomerDao(DataSource datasource) {
        this.template = new JdbcTemplate(datasource);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        SqlRowSet rs = template.queryForRowSet(sql,customerId);
        if(rs.next()){
            Customer customer = mapRowToCustomer(rs);
            return customer;

        }
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        SqlRowSet rs = template.queryForRowSet(sql);
        while(rs.next()){
            Customer customer = mapRowToCustomer(rs);
            customers.add(customer);

        }
        return customers;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        try {
            Integer cusId = template.queryForObject("Insert into customer (name, street_address1, street_address2, city, state, zip_code) Values (?,?,?,?,?,?) " +
                    "RETURNING customer_id;", int.class, newCustomer.getName(), newCustomer.getStreetAddress2(), newCustomer.getStreetAddress2(), newCustomer.getCity(), newCustomer.getState(), newCustomer.getZipCode());
            newCustomer.setCustomerId(cusId);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return newCustomer;
    }


    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        Customer newUpdatedCustomer = null;
        try {
            Integer numRow = template.update("Update customer set name = ? where customer_id = ?;", updatedCustomer.getName(), updatedCustomer.getCustomerId());
            if (numRow == 0) {
                throw new DaoException("No Rows have been changed");
            } else {
                newUpdatedCustomer = getCustomerById(updatedCustomer.getCustomerId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException(e.getMessage());
        }
        return updatedCustomer;
    }

    private static Customer mapRowToCustomer(SqlRowSet rs) {
        int id = rs.getInt("customer_id");
        String name = rs.getString("name");
        String streetAddress1 = rs.getString("street_address1");
        String streetAddress2 = rs.getString("street_address2");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String zipCode = rs.getString("zip_code");
        Customer customer =new Customer(id, name, streetAddress1, streetAddress2, city, state, zipCode);
        return customer;
    }

}
