package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.DiaryDao;
import com.ssafy.vo.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

	
	@Autowired
	DiaryDao dao;
	
	@Override
	public int insertDiary(Diary diary) {
		return dao.insertDiary(diary);
	}

	@Override
	public int updateDiary(Diary diary) {
		return dao.updateDiary(diary);
	}

	@Override
	public int deleteDiary(int no) {
		return dao.deleteDiary(no);
	}

	@Override
	public List<Diary> searchDiary(Diary diary) {
		return dao.searchDiary(diary);
	}

}
