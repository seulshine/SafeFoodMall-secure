package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.CartDao;
import com.ssafy.vo.Cart;


@Service
public class CartService {

	@Autowired
	CartDao dao;
	
	
	public int insertCart(Cart cart) {
		return dao.insertCart(cart);
	}
	
	public int updateCart(Cart cart) {
		return dao.updateCart(cart);
	}
	
	public Cart searchCart(Cart cart) {
		return dao.searchCart(cart);
	}
	
	
	public List<Cart> searchAllByUser(String id) {
		return dao.searchAllByUser(id);
	}
	
	
	public int deleteCart(Cart cart) {
		return dao.deleteCart(cart);
	}

	
	public int searchInStock(int code) {
		return dao.searchInStock(code);
	}
	
}
