package com.exclusively.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exclusively.entity.Cart;
import com.exclusively.repositories.UserCartRepository;

@Service("CartService")
public class CartServiceImpl implements CartService {

	@Autowired
	UserCartRepository userCartRepository;



	@Override
	public Cart getCart(String id, boolean isGuest) {
		if (!isGuest)
			return userCartRepository.findOne(id);
		else
			return userCartRepository.findOne(id);
	}

	@Override
	public void mergeCarts(String sessionId, String userId) {
		Cart guestCart = userCartRepository.findOne(sessionId);
		if (guestCart != null) {
			Cart userCart = userCartRepository.findOne(userId);
			if (userCart != null) {
				userCart.getProductQuantityMapping().putAll(guestCart.getProductQuantityMapping());
			}
		}
	}

	@Override
	public void addItemToCart(String id, String productId, int quantity, boolean isGuest) {
			Cart cart = userCartRepository.findOne(id);
			if (cart == null) {
				cart = new Cart();
				cart.setGuest(isGuest);
				cart.setCreated(new Date().toString());
			}
			cart.setUpdated(new Date().toString());
			cart.getProductQuantityMapping().put(productId, quantity);
			userCartRepository.save(cart);
	}

	@Override
	public void clearCart(String id, boolean isGuest) {
			Cart cart = userCartRepository.findOne(id);
			if (cart == null) {
				cart = new Cart();
				cart.setGuest(isGuest);
				cart.setCreated(new Date().toString());
			}
			cart.setUpdated(new Date().toString());
			cart.getProductQuantityMapping().clear();
			userCartRepository.save(cart);

	}

	@Override
	public void removeItemFromCart(String id,String productId, boolean isGuest) {
			Cart cart = userCartRepository.findOne(id);
			cart.setUpdated(new Date().toString());
			cart.getProductQuantityMapping().remove(productId);
			userCartRepository.save(cart);

		}

	}

