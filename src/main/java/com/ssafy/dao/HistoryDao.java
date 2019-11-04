package com.ssafy.dao;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.vo.History;

public class HistoryDao {
	private final String namespace = "com.ssafy.HistoryMapper.";
	private static HistoryDao instance = new HistoryDao();
	private HistoryDao() {}
	public static HistoryDao getInstance() {
		return instance;
	}
	
	public void insertHistory(SqlSession session, History history) {
		String stmt = namespace + "insertHistory";
		session.insert(stmt, history);
		session.commit();
	}
}