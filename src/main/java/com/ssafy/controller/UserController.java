package com.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dao.UserDaoImpl;
import com.ssafy.service.UserServiceImpl;
import com.ssafy.vo.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("*.do")
@CrossOrigin(value="*") // 어디서 들어오는거든 (외부에서) 다 허용 하겠다.
@Slf4j
public class UserController {
	@Autowired
	UserServiceImpl service;
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "redirect:main.jsp";
	}
	
	// @PathVariable String id, @PathVariable String pw,
	@PostMapping("login.do")
	public String doLogin(User user, HttpSession session, Model model, HttpServletRequest request) {
		try {
			User selected = service.searchUser(user.getId());
		
			if (selected != null) {
				//.System.out.println(selected.toString());
				
				if (selected.getPassword().equals(user.getPassword())) {
					session.setAttribute("LoginUser", selected);
					session.setAttribute("msg", "로그인이 되었습니다.");
					
//					String jwtString = Jwts.builder()
//										.setHeaderParam("typ", "JWT")
//										.setSubject(selected.getId())
//										.signWith(SignatureAlgorithm.HS512, "ssafy")
//										.compact();
					
					return "redirect:main.jsp";
				} else {
					session.setAttribute("msg", "비밀번호가 틀렸습니다.");
				}
			} else {
				throw new RuntimeException("지정된 사용자가 없습니다.");
			}
			return "redirect:main.jsp";
			
		} catch(RuntimeException e) {
			log.error("지정된 사용자가 없습니다.", e);
			request.setAttribute("msg", e.getMessage());
			return "main";
			
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:main.jsp";
	}
	
	
	@GetMapping("update.do")
	public String getUpdate() {

		return "modify";
	}
	
	@PostMapping("update.do")
	public String update(User user, HttpSession session) { // 파라미터가 json 으로 올거다 그 녀석을 Phone 으로 바꿔 쓰겠다.
		//System.out.println(user.toString());
		try {
			
			StringBuilder sb = new StringBuilder();
			for(String s: user.getAller()) {
				sb.append(s + ",");
			}
					
			//user.setAllergy(target);
			
			user.setAllergy(sb.toString());
			
			
			int result = service.updateUser(user);	
			if(result > 0) {
				
				session.setAttribute("LoginUser", user);
				session.setAttribute("msg", "정보가 수정되었습니다.");
				return "redirect:modify.jsp";
			} else {
				throw new RuntimeException("업데이트에 실패했습니다.");
			}
		
		} catch(RuntimeException e) {
			log.error("업데이트 실패", e);
			return "modify";
			
		}
		
	}
	
	
	
	@GetMapping("delete.do")
	@ApiOperation("id에 해당하는 고객 삭제")
	public String delete(HttpSession session) { // , @PathVariable String id
		try {
			User user = (User)session.getAttribute("LoginUser");
			int result = service.deleteUser(user.getId());
			if(result > 0) {
				return "redirect:logout.do";
			} else {
				throw new RuntimeException("업데이트에 실패했습니다.");
			}

		} catch(RuntimeException e) {
			log.error("삭제 실패", e);
			return "main";
			
		}
		
	}
	
	
	

	@GetMapping("regist.do")
	public String getRegist() {
		return "redirect:signup.jsp";
	}
	
	@PostMapping("regist.do")
	public String regist(User user) { // 파라미터가 json 으로 올거다 그 녀석을 Phone 으로 바꿔 쓰겠다.
		try {
			StringBuilder sb = new StringBuilder();
			for(String s: user.getAller()) {
				sb.append(s + ",");
			}
			
			
			//user.setAllergy(target);
			
			user.setAllergy(sb.toString());
			
			
			int result = service.insertUser(user);	
			if(result > 0) {
				return "redirect:main.jsp";
			} else {
				throw new RuntimeException("회원가입에 실패했습니다.");
			}
			
		} catch(RuntimeException e) {
			log.error("회원가입 실패", e);
			return "signup";
			
		}
		
		//"redirect:main.jsp";
	}
	
	
	
	
	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpStatus, boolean status) { 

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", status);
		resultMap.put("data", data);
		
		// 상태와 함께 Map 반환
		return new ResponseEntity<>(resultMap, httpStatus);
		
	}
	
	
}
