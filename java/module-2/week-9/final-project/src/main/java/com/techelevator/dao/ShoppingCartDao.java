package com.techelevator.dao;

import com.techelevator.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {

    ShoppingCart getCartByUserId(int userId);

    ShoppingCart updateAddToShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart updateRemoveFromShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart deleteAllFromShoppingCart(ShoppingCart shoppingCart);
}
