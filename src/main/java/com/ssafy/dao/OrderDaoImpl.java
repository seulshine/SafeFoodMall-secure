package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Order;

@Repository
public class OrderDaoImpl implements OrderDao{


	private final String ns = "com.ssafy.mapper.OrderMapper.";
	
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insertOrder(Order order) {
		System.out.println("dao : " + order);
		return session.insert(ns+"insertOrder", order);
	}

	@Override
	public Order searchOrder(Order order) {
		return session.selectOne(ns+"searchOrder", order);
	}

	@Override
	public List<Order> searchOrdersByUser(String id) {
		return session.selectList(ns+"searchOrdersByUser", id);
	}

	@Override
	public int deleteOrder(Order order) {
		return session.delete(ns+"deleteOrder", order);
	}

	@Override
	public int updateInstock(Order order) {
		return session.update(ns+"updateInstock", order);
	}
	
	

}
