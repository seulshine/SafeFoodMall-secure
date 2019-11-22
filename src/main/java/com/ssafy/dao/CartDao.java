package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Cart;
import com.ssafy.vo.History;
import com.ssafy.vo.User;

@Repository
public class CartDao {

	@Autowired
	SqlSession session;

	private final String namespace = "com.ssafy.CartMapper.";

	public int insertCart(Cart cart) {
		System.out.println(cart.getQty() + " : " + cart.getCode() + " :  hey");
		String stmt = namespace + "insertCart";
		return session.insert(stmt, cart);
	}

	public int updateCart(Cart cart) {
		String stmt = namespace + "updateCart";
		return session.update(stmt, cart);
	}

	public Cart searchCart(Cart cart) {
		System.out.println("hey");
		String stmt = namespace + "selectCart";
		return session.selectOne(stmt, cart);


	}
	
	public List<Cart> searchAllByUser(String id) {
		String stmt = namespace + "searchAllByUser";
		return session.selectList(stmt, id);
	}
	
	
	public int deleteCart(Cart cart) {
		String stmt = namespace + "deleteCart";
		return session.delete(stmt, cart);
	}
	
	public int searchInStock(int code) {
		String stmt = namespace + "searchInStock";
		return session.selectOne(stmt, code);
	}

}