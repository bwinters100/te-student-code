package com.techelevator.controller;

import ch.qos.logback.core.hook.ShutdownHook;
import com.techelevator.dao.ProductDao;
import com.techelevator.dao.ShoppingCartDao;
import com.techelevator.model.Product;
import com.techelevator.model.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class ShoppingCartController {
    private final ShoppingCartDao dao;

    public ShoppingCartController(ShoppingCartDao dao) {
        this.dao = dao;
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ShoppingCart get(@PathVariable int id) {
        ShoppingCart shoppingCart = dao.getCartByUserId(id);
        if (shoppingCart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shopping Cart Not Found");
        } else {
            return dao.getCartByUserId(id);
        }
    }


}
