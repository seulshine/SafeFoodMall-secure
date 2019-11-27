package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.OrderService;
import com.ssafy.vo.Diary;
import com.ssafy.vo.Order;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
@CrossOrigin({"*"})
public class OrderRestController {

	@Autowired
	OrderService service;
	
	
	
	@PostMapping("/insertOrder") 
	@ApiOperation(value="새로운 다이어리 글 등록") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> insertOrder(@RequestBody Order order) {
		//System.out.println(order);
		log.trace("insertOrder: {}", order);
		
		try {
			int result = service.insertOrder(order);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("insertOrder", e);
			throw e; 
		}
		
	}
	
	
	
	
	@PostMapping("/searchOrder") 
	@ApiOperation(value="다이어리 상세페이지") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> searchOrder(@RequestBody Order order) {
		log.trace("searchOrder: {}", order);
		
		try {
			Order result = service.searchOrder(order);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("searchOrder", e);
			throw e; 
		}
		
	}
	
	
	@GetMapping("/searchOrders/{id}") 
	@ApiOperation(value="다이어리 상세페이지") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> searchOrders(@PathVariable String id) {
		log.trace("searchOrders: {}", id);
		
		try {
			List<Order> result = service.searchOrdersByUser(id);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("searchOrders", e);
			throw e; 
		}
	}
	
	
	@DeleteMapping("/deleteOrder") 
	@ApiOperation(value="다이어리 상세페이지") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> deleteOrder(@RequestBody Order order) {
		log.trace("deleteOrder: {}", order);
		
		try {
			int result = service.deleteOrder(order);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("deleteOrder", e);
			throw e; 
		}
	}
	
	
	
	@PutMapping("/updateInstock") 
	@ApiOperation(value="재고 수정") // response 는 담고 있는 객체 타입
	public ResponseEntity<Object> updateInstock(@RequestBody Order order) {
		log.trace("updateInstock: {}", order);
		
		try {
			int result = service.updateInstock(order);	
			return new ResponseEntity<Object>(result, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("updateInstock", e);
			throw e; 
		}
		
	}
	
	
	
}
