package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dao.UserDaoImpl;
//import com.ssafy.pms.Phone;
import com.ssafy.vo.User;

import io.swagger.annotations.ApiOperation;

@RestController // 응답  : json 으로 갈거다 
@RequestMapping("*.do")
@CrossOrigin(value="*") // 어디서 들어오는거든 (외부에서) 다 허용 하겠다.
public class UserRestController {
//	@Autowired
//	UserDaoImpl dao;
	
//	
//	@PostMapping("/login")
//	@ApiOperation("사용자 로그인")
//	public ResponseEntity<Map<String, Object>> login(@PathVariable String id, @PathVariable String pw) {
//		try {
//			User user = dao.searchUser(id);
//			
//			return response(phones, HttpStatus.OK, true);
//			
//		} catch(RuntimeException e) {
//			logger.error("조회 실패", e);
//			return response(e.getMessage(), HttpStatus.CONFLICT, false);
//			
//		}
//		
//	}
}
