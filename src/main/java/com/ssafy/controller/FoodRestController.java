package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.FoodService;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/food")
@Slf4j
public class FoodRestController {

	@Autowired
	FoodService fservice;
	
	@GetMapping("/getAllFoods")
	public Object getAllFoods() {
		log.trace("getAllFoods is called");
		try {
			FoodPageBean fpb = new FoodPageBean("all", "", "", 0);
			List<Food> foods = fservice.searchAll(fpb);
			return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
		} catch (Exception e) {
			log.error("getAllFoods", e);
			throw e;		// 얘를 호출한놈은 spring. 이걸 톰캣이 클라이언트한테 에러로 보낸다.
		}
	}
	
}
