package com.exclusively.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.exclusively.entity.Item;

public interface UserItemRepository extends CrudRepository<Item,String>{
	List <Item> findCartByUserId(Query query);
	List <Item> findByUserId(Query query);
	
}
