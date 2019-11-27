package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Order;

public interface OrderService {
	public int insertOrder(Order order);
	public Order searchOrder(Order order);
	public List<Order> searchOrdersByUser(String id);
	public int deleteOrder (Order order);
	
	public int updateInstock(Order order);
}
