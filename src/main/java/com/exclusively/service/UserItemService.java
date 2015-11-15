package com.exclusively.service;

import java.util.List;

import com.exclusively.entity.Item;

public interface UserItemService {

	public Iterable <Item> getAll();
	public Item addItem(Item item);
	public String removeitem(String userId,String itemId);
	public List <Item> findCartByUserId(String userId);
}
