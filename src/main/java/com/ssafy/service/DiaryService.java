package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.Diary;

public interface DiaryService {
	public int insertDiary(Diary diary);
	public int updateDiary(Diary diary);
	public int deleteDiary(int no);
	public List<Diary> searchDiary(Diary diary);
}
