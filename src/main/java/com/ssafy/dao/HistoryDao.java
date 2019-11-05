package com.ssafy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.History;

@Repository
public class HistoryDao {
	
	@Autowired
	SqlSession session;
	
	private final String namespace = "com.ssafy.HistoryMapper.";
	
	
//	private static HistoryDao instance = new HistoryDao();
//	private HistoryDao() {}
//	public static HistoryDao getInstance() {
//		return instance;
//	}
	
	public int insertHistory(History history) {
		String stmt = namespace + "insertHistory";
		return session.insert(stmt, history);
	}
}