package com.exclusively.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.exclusively.entity.Item;
//import com.exclusively.repository.UserItemRepository;

@Service("UserItemService")
public class UserItemServiceImpl implements UserItemService {

	@Autowired
	UserItemRepository useritemrepository;
	
	@Override
	public Iterable<Item> getAll() 
	{
		// TODO Auto-generated method stub
		return useritemrepository.findAll();
	}

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		useritemrepository.save(item);
		return item;
	}

	
	@Override
	public List<Item> findCartByUserId(String userId) {
		// TODO Auto-generated method stub
		 Query query = new Query();
		query.setKey(ComplexKey.of(userId));
		List <Item> allItems = useritemrepository.findCartByUserId(query);
		return allItems;
	}

	@Override
	public String removeitem(String userId, String itemId) {
		// TODO Auto-generated method stub
		try
		{
		Object[] idArr = new Object[2];
		idArr[0] = userId;
		idArr[1] = itemId;
		Query query = new Query();
		query.setKey(ComplexKey.of(idArr));
		//System.out.println(useritemrepository.findByUserIdAndItemId(query));
		useritemrepository.delete(useritemrepository.findByUserIdAndItemId(query));
		return "Success";
		}
		catch(Exception e)
		{
		return "Not Found"	;
		}
	}

}