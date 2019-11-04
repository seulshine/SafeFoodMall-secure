package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.util.DBUtil;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.User;

public class UserDaoImpl {

	private static UserDaoImpl dao = new UserDaoImpl();
	public static UserDaoImpl getDao() {
		return dao;
	}
	private UserDaoImpl() {
//		loadData(session);
	}

	DBUtil util = DBUtil.getUtil();
	List<User> userlist = new ArrayList<User>();
	private final String namespace = "com.ssafy.mapper.UserMapper.";
	
	/**
	 * 사용자 데이터를 DB에서 읽어온다.
	 */
	public void loadData(SqlSession session) {
		String stmt = namespace + "selectAll";
		userlist = session.selectList(stmt);
		
	}

	public void insertUser(User user, SqlSession session){
		String stmt = namespace + "insert";
		session.insert(stmt, user);
		session.commit();

	}
	
	public void updateUser(User user, SqlSession session) {
		String stmt = namespace + "updateUser";
		session.update(stmt, user);
		session.commit();
		
	}

	/**
	 * user id에 해당하는 user정보를 검색해서 반환.
	 * 
	 * @param code 검색할 user 코드
	 * @return user 코드에 해당하는 user 정보, 없으면 null이 리턴됨
	 */
	public User searchUser(String id, SqlSession session) {
		String stmt = namespace + "selectByBean";
		return session.selectOne(stmt, id);
		
	}

	public void deleteUser(String id, SqlSession session) {
		String stmt = namespace + "delete";
		session.delete(stmt, id);
		session.commit();
	}

	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
//		dao.loadData();
//		System.out.println(dao.search(1));
//		System.out.println("===========================material로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
//		System.out.println("===========================maker로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
//		System.out.println("===========================name으로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
//		System.out.println("============================================================");
//		print(dao.searchAll(null));
//		System.out.println("============================================================");
	}

	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
}
