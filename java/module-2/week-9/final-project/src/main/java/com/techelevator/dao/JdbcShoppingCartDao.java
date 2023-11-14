package com.techelevator.dao;

import com.techelevator.model.ShoppingCart;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcShoppingCartDao implements ShoppingCartDao {

    @Override
    public ShoppingCart getCartByUserId(int id) {
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
