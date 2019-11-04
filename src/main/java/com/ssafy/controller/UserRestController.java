package com.ssafy.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dao.UserDaoImpl;
<<<<<<< HEAD
=======
//import com.ssafy.pms.Phone;
>>>>>>> branch 'master' of https://lab.ssafy.com/yeseul/safefood_spring.git
import com.ssafy.vo.User;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("*.do")
@CrossOrigin(value="*") // 어디서 들어오는거든 (외부에서) 다 허용 하겠다.
@Slf4j
public class UserRestController {
//	@Autowired
//	UserDaoImpl dao;
	
<<<<<<< HEAD
	@GetMapping("login.do")
	public String getLoginForm() {
		return "main";
	}
	
	@PostMapping("login.do")
	public String doLogin(@PathVariable String id, @PathVariable String pw, HttpSession session, Model model, HttpServletRequest request) {
		try {
			User user = dao.searchUser(id);
			if (user != null) {
				if (user.getPassword().equals(pw)) {
					session.setAttribute("loginUser", user);
					session.setAttribute("msg", "로그인이 되었습니다.");
					return "redirect:main.jsp";
				} else {
					session.setAttribute("msg", "비밀번호가 틀렸습니다.");
				}
			} else {
				throw new RuntimeException("지정된 사용자가 없습니다.");
			}
			return "main";
			
		} catch(RuntimeException e) {
			log.error("지정된 사용자가 없습니다.", e);
			request.setAttribute("msg", e.getMessage());
			return "main";
			
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
	
	@GetMapping("update.do")
	public String getUpdate() {
		return "member/modify";
	}
//	
//	@PostMapping("update.do")
//	@ApiOperation("사융자 정보 업데이트")
//	public ResponseEntity<Map<String, Object>> update(@RequestBody User user) { // 파라미터가 json 으로 올거다 그 녀석을 Phone 으로 바꿔 쓰겠다.
//		try {
//			int result =dao.updateUser(user);	
//			if(result > 0) {
//				return response(result, HttpStatus.CREATED, true);
//			} else {
//				throw new RuntimeException("업데이트에 실패했습니다.");
//			}
//			
//		} catch(RuntimeException e) {
//			log.error("업데이트 실패", e);
//			return response(e.getMessage(), HttpStatus.CONFLICT, false);
//			
//		}
//		
//	}
//	
//	
//	
//	@GetMapping("delete.do")
//	@ApiOperation("id에 해당하는 고객 삭제")
//	public ResponseEntity<Map<String, Object>> delete( HttpSession session) { // , @PathVariable String id
//		try {
//			User user = (User)session.getAttribute("LoginUser");
//			int result = dao.deleteUser(user.getId());
//			if(result > 0) {
//				return response(result, HttpStatus.OK, true);
//			} else {
//				throw new RuntimeException("업데이트에 실패했습니다.");
//			}
//
//		} catch(RuntimeException e) {
//			log.error("삭제 실패", e);
//			return response(e.getMessage(), HttpStatus.CONFLICT, false);
//			
//		}
//		
//	}
//	
//	
//	
//
//	@GetMapping("regist.do")
//	public String getRegist() {
//		return "member/signup";
//	}
//	
//	@PostMapping("regist.do")
//	@ApiOperation("고객 회원가입")
//	public ResponseEntity<Map<String, Object>> regist(@RequestBody User user) { // 파라미터가 json 으로 올거다 그 녀석을 Phone 으로 바꿔 쓰겠다.
//		try {
//			int result =dao.insertUser(user);	
//			if(result > 0) {
//				return response(result, HttpStatus.CREATED, true);
//			} else {
//				throw new RuntimeException("회원가입에 실패했습니다.");
//			}
//			
//		} catch(RuntimeException e) {
//			log.error("회원가입 실패", e);
//			return response(e.getMessage(), HttpStatus.CONFLICT, false);
//			
//		}
//		
//		//"redirect:main.jsp";
//	}
//	
//	
//	
	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpStatus, boolean status) { 

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", status);
		resultMap.put("data", data);
		
		// 상태와 함께 Map 반환
		return new ResponseEntity<>(resultMap, httpStatus);
		
	}
	
	
=======
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
>>>>>>> branch 'master' of https://lab.ssafy.com/yeseul/safefood_spring.git
}
