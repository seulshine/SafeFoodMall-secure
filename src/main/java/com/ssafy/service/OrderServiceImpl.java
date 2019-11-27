package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.OrderDao;
import com.ssafy.vo.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao dao;
	
	
	@Override
	public int insertOrder(Order order) {
		return dao.insertOrder(order);
	}

	@Override
	public Order searchOrder(Order order) {
		return dao.searchOrder(order);
	}

	@Override
	public List<Order> searchOrdersByUser(String id) {
		return dao.searchOrdersByUser(id);
	}

	@Override
	public int deleteOrder(Order order) {
		return dao.deleteOrder(order);
	}

	@Override
	public int updateInstock(Order order) {
		return dao.updateInstock(order);
	}

}
