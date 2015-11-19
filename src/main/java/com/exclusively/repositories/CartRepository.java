package com.exclusively.repositories;


import org.springframework.data.repository.CrudRepository;

import com.exclusively.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, String> {
}
