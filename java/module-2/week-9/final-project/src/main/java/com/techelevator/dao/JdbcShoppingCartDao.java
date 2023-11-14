package com.techelevator.dao;

import com.techelevator.model.ShoppingCart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public class JdbcShoppingCartDao implements ShoppingCartDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcShoppingCartDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate((dataSource));
    }
    @Override
    public ShoppingCart getCartByUserId(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from cart_item where cart_item_id = ?", id);
        if(rs.next()){
            ShoppingCart shoppingCart = mapCollection(rs);
            return shoppingCart;
        }
        return null;
    }
    @Override
    public ShoppingCart updateAddToShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart updateRemoveFromShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart deleteAllFromShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }
    private static ShoppingCart mapCollection(SqlRowSet rs){
        int id = rs.getInt("cart_item_id");
        int quantity = rs.getInt("quantity");
        ShoppingCart shoppingCart = new ShoppingCart(id, quantity);
        //shoppingCart.setCartItemID(id);
        //shoppingCart.setQuantity(quantity);
        return shoppingCart;
    }
}
