package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.HistoryDao;
import com.ssafy.vo.History;

@Service
public class HistoryService {

	@Autowired
	HistoryDao dao;
	
	public int insertHistory(History history) {
		return dao.insertHistory(history);
	}
}