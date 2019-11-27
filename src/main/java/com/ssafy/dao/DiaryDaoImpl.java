package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.Board;
import com.ssafy.vo.Comment;
import com.ssafy.vo.Diary;

@Repository
public class DiaryDaoImpl implements DiaryDao {
	
	private final String ns = "com.ssafy.mapper.DiaryMapper.";
	@Autowired
	SqlSession session;
	
	@Override
	public int insertDiary(Diary diary) {
		return session.insert(ns+"insertDiary", diary);
	}

	@Override
	public int updateDiary(Diary diary) {
		return session.update(ns+"updateDiary", diary);
	}

	@Override
	public int deleteDiary(int no) {
		return session.delete(ns+"deleteDiary", no);
	}

	@Override
	public List<Diary> searchDiary(Diary diary) {
		return session.selectList(ns+"searchDiary", diary);
	}




}
