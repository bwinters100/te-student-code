package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Product;
import com.techelevator.ssgeek.model.Sale;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao {

    private static JdbcTemplate template;

    public JdbcSaleDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Sale getSaleById(int saleId) {
        try {
            String sql = "SELECT * from sale where sale_id = ?";
            SqlRowSet rs = template.queryForRowSet(sql, saleId);
            if (rs.next()) {
                Sale sale = mapRowToSale(rs);
                return sale;
            }
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Sale> getUnshippedSales() {
        List<Sale> noShipSales = new ArrayList<>();
        String sql = "Select * from sale where ship_date IS NULL;";
        try {
            SqlRowSet rs = template.queryForRowSet(sql);
            while(rs.next()){
                Sale saleResult = mapRowToSale(rs);
                noShipSales.add(saleResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        }
        return noShipSales;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        List<Sale> allSales = new ArrayList<>();
        String sql =  "Select * from Sale WHERE customer_id = ?;";

        try {
            SqlRowSet rs = template.queryForRowSet(sql, customerId);
            while (rs.next()) {
                Sale saleResult = mapRowToSale(rs);
                allSales.add(saleResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        }

        return allSales;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId){
        List<Sale> allSales = new ArrayList<>();
        String sql =  "Select * from Sale JOIN product ON product.product_id = line_item.product_id JOIN line_item on line_item.sale_id = sale.sale_id WHERE product_id = ?;";

        try {
            SqlRowSet rs = template.queryForRowSet(sql, productId);
            while (rs.next()) {
                Sale saleResult = mapRowToSale(rs);
                allSales.add(saleResult);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        }

        return allSales;
    }

    @Override
    public Sale createSale(Sale newSale) {
        try {
            String sql = "INSERT INTO sale(customer_id, sale_date, ship_date) VALUES(?,?,?) RETURNING sale_id";
            SqlRowSet rs = template.queryForRowSet(sql, int.class, newSale.getCustomerId(), newSale.getSaleDate(), newSale.getShipDate());
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return newSale;
    }

    @Override
    public Sale updateSale(Sale updatedSale){
        Sale newUpdatedSale = null;
        try {
            Integer numRow = template.update("Update product set ship_date = ? where sale_id = ?;", updatedSale.getShipDate(), updatedSale.getSaleId());
            if (numRow == 0) {
                throw new DaoException("No Rows have been changed");
            } else {
                newUpdatedSale = getSaleById(updatedSale.getSaleId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException(e.getMessage());
        }
        return updatedSale;
    }

    @Override
    public int deleteSaleById(int saleId){
        int numOfRows = 0;
        try{
            numOfRows = template.update("Delete from sale where sale_id = ?", saleId);
        }
        catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch(DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return numOfRows;
    }

    private static Sale mapRowToSale(SqlRowSet rs) {
        int id = rs.getInt("sale_id");
        int customerId = rs.getInt("customer_id");
        LocalDate saleDate = rs.getDate("sale_date").toLocalDate();
        LocalDate shipDate = rs.getDate("ship_date").toLocalDate();
        String customerName = rs.getString("customerName");
        Sale sale = new Sale(id, customerId, saleDate, shipDate, customerName);
        return sale;
    }
}