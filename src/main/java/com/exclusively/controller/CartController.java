package com.exclusively.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exclusively.entity.Cart;
import com.exclusively.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	private String status;

	@Autowired
	CartService cartService;

	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

	@RequestMapping(value = "/addProduct/productId/{productId}/quantity/{quantity}", method = RequestMethod.GET)
	@ResponseBody
	public String addCartItem(@PathVariable String productId, @PathVariable Integer quantity) {
		boolean isGuest = true;
		cartService.addItemToCart("123", productId, quantity, isGuest);
		return new ResponseEntity(HttpStatus.CREATED).getStatusCode().toString();
	}

	@RequestMapping(value = "/removeProduct/productId/{productId}")
	public String removeCartItem(@PathVariable String productId) {
		boolean isGuest = true;
		cartService.removeItemFromCart("123", productId, isGuest);
		return new ResponseEntity(HttpStatus.OK).getStatusCode().toString();
	}

	@RequestMapping(value = "/getCart")
	@ResponseBody
	public Cart getCart() {
		boolean isGuest = true;
		return cartService.getCart("123", isGuest);
	}

	@RequestMapping(value = "/clearCart")
	@ResponseBody
	public String clearCart() {
		boolean isGuest = true;
		cartService.clearCart("123", isGuest);
		return new ResponseEntity(HttpStatus.OK).getStatusCode().toString();
	}
}