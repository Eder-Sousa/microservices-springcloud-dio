package com.edersousa.shoppingcart.repository;

import com.edersousa.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
