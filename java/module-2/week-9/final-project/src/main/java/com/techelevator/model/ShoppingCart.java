package com.techelevator.model;

public class ShoppingCart {

    private int cartItemID;

    private int quantity;

    public ShoppingCart(int cartItemID, int quantity) {
        this.cartItemID = cartItemID;
        this.quantity = quantity;
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public java.lang.String toString() {
        return "Cart Item{" + "id=" + cartItemID + ", quantity='" + quantity + '}';
    }
}
