package com.ssafy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.History;
import com.ssafy.vo.User;

@Repository
public class HistoryDao {
	
	@Autowired
	SqlSession session;
	
	private final String namespace = "com.ssafy.HistoryMapper.";
	
	
	public int insertHistory(History history) {
		String stmt = namespace + "insertHistory";
		return session.insert(stmt, history);
	}
	
	public int updateHistory(History history) {
		String stmt = namespace + "updateHistory";
		return session.update(stmt, history);
	}
	
	public int searchHistory(History history) {
		String stmt = namespace + "selectHistory";
		return session.selectOne(stmt, history);
		
	}
	
}