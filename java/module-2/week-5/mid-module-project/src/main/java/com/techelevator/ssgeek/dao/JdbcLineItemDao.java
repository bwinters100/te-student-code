package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.exception.DaoException;
import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.LineItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao{

    private static JdbcTemplate template;

    public JdbcLineItemDao(DataSource datasource) {
        this.template = new JdbcTemplate(datasource);
    }

    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        List<LineItem> lineItems = new ArrayList<>();
        String sql = "SELECT * FROM line_item JOIN sale on sale.sale_id = line_item.sale_id where sale_id = ?";
        try {
            SqlRowSet rs = template.queryForRowSet(sql, saleId);
            while(rs.next()){
                LineItem lineItemResult = mapRowToLineItem(rs);
                lineItems.add(lineItemResult);
            }
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return lineItems;
        }

    private static LineItem mapRowToLineItem(SqlRowSet rs){
    int id = rs.getInt("line_item_id");
    int salesId = rs.getInt("sale_id");
    int productId = rs.getInt("product_id");
    int quantity = rs.getInt("quantity");
    String productName = rs.getString("product_name");
    BigDecimal price = rs.getBigDecimal("price");
    LineItem lineItem = new LineItem(id, salesId, productId, quantity, productName, price);
    return lineItem;
    }
}
