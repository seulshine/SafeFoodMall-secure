package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.FoodService;
import com.ssafy.service.HistoryService;
import com.ssafy.vo.Food;
import com.ssafy.vo.History;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/history")
@Slf4j
public class HistoryRestController {
	
	
	@Autowired
	HistoryService hservice;
	
	
	@PostMapping("/insertHistory")
	public Object insertHistory(@RequestBody History history) {
		log.trace("insertHistory is called");
		try {
			
			int result = hservice.insertHistory(history);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("getAllFoods", e);
			throw e;		// 얘를 호출한놈은 spring. 이걸 톰캣이 클라이언트한테 에러로 보낸다.
		}
		
	}
}
