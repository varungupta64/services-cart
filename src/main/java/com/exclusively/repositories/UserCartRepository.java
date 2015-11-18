package com.exclusively.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.exclusively.entity.Cart;
import com.exclusively.entity.Item;

public interface UserCartRepository extends CrudRepository<Cart, String> {
}
