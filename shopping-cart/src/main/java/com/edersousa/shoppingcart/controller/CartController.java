package com.edersousa.shoppingcart.controller;

import com.edersousa.shoppingcart.model.Cart;
import com.edersousa.shoppingcart.model.Item;
import com.edersousa.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private CartRepository cartRepository;

    @Autowired
    public CartController(CartRepository repository) {
        this.cartRepository = repository;
    }

    @PostMapping(value = "/{id}")
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        } else {
            cart = savedCart.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping(value = "/{id}")
    public Optional<Cart> findById(@PathVariable("id") Long id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void clear(@PathVariable("id") Long id) {
        cartRepository.deleteById(id);
    }
}
