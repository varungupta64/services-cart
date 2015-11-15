package com.exclusively.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exclusively.entity.Item;
import com.exclusively.service.UserItemService;

@RestController
@RequestMapping("/api/cart")
public class ItemController {
	
	private String status;
	
	@Autowired
	UserItemService userItemService;

	@RequestMapping("/")
    String home() {
        return "Hello World";
    }
	
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	@ResponseBody
	public Iterable <Item> getAllCart()
	{
		System.out.println("Response:"+userItemService.getAll());
		return userItemService.getAll();
	}
	
	@RequestMapping(value="/addItem",method= RequestMethod.POST)
	@ResponseBody
	public String addCartItem(@RequestBody Item item)
	{	
		userItemService.addItem(item);
		return new ResponseEntity(HttpStatus.CREATED).getStatusCode().toString();
	}
	@RequestMapping(value="/removeItem/userId/{userid}/itemId/{itemid}")
	public String RemoveCartItem(@PathVariable String userid,@PathVariable String itemid)
	{
		status = userItemService.removeitem(userid, itemid);
		return status;
	}
	
	@RequestMapping(value="/findCartByUserId/{userId}")
	@ResponseBody
	public List <Item> findCartByUserId(@PathVariable String userId)
	{	
		return userItemService.findCartByUserId(userId);
	}	
}
