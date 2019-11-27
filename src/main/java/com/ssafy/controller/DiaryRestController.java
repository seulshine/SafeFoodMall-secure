package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.DiaryService;
import com.ssafy.vo.Board;
import com.ssafy.vo.Diary;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/diary")
@Slf4j
public class DiaryRestController {
	
	@Autowired
	DiaryService service;
	
	
	
	@PostMapping("/insertDiary") 
	@ApiOperation(value="새로운 다이어리 글 등록") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> insertDiary(@RequestBody Diary diary) {
		log.trace("insertDiary: {}", diary);
		
		try {
			int result = service.insertDiary(diary);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("insertDiary", e);
			throw e; 
		}
		
	}
	
	
	@PutMapping("/updateDiary") 
	@ApiOperation(value="다이어리 글 수정") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> updateDiary(@RequestBody Diary diary) {
		log.trace("updateDiary: {}", diary);
		
		try {
			int result = service.updateDiary(diary);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("updateDiary", e);
			throw e; 
		}
		
	}
	
	@DeleteMapping("/deleteDiary/{no}") 
	@ApiOperation(value="다이어리 글 삭제") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> deleteDiary(@PathVariable int no) {
		log.trace("deleteDiary: {}", no);
		
		try {
			int result = service.deleteDiary(no);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("deleteDiary", e);
			throw e; 
		}
		
	}
	
	

	
	@PostMapping("/searchDiary")
	@ApiOperation(value="날짜에 맞는 다이어리를 반환한다.", response=List.class) // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> searchDiary(@RequestBody Diary diary) {
		log.trace("searchDiary");
		
		try {
			List<Diary> diarys = service.searchDiary(diary);
			return new ResponseEntity<Object>(diarys, HttpStatus.OK);
		} catch(RuntimeException e) {
			log.error("searchDiary", e);
			throw e; 
		}
	
	}
}
