package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.service.CartService;
import com.ssafy.service.UserServiceImpl;
import com.ssafy.vo.Cart;
import com.ssafy.vo.User;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@CrossOrigin({"*"})
public class CartController {

	@Autowired
	CartService service;
	
	@GetMapping("cart/{id}")
	@ApiOperation("id에 해당하는 장바구니 정보 확인")
	public ResponseEntity<Object> searchAllCart(@PathVariable String id) {
		try {
			List<Cart> carts = service.searchAllByUser(id);
			
			return new ResponseEntity<Object>(carts, HttpStatus.OK);

		} catch(RuntimeException e) {
			log.error("카트 정보 가져오기 실패", e);
			throw e; 
			
		}
		
	}
	
}
