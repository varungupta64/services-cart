package com.exclusively.service;

import com.exclusively.entity.Cart;

public interface CartService {

	public Cart getCart(String id,boolean isGuest);

	public void addItemToCart(String id,String productId,int quantity, boolean isGuest);

	public void clearCart(String id, boolean isGuest);

	public void removeItemFromCart(String id, String productId, boolean isGuest);

	public void mergeCarts(String sessionId,String userId);

}
