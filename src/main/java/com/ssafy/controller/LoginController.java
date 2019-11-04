package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.dao.UserDaoImpl;
import com.ssafy.util.MyBatisUtil;
import com.ssafy.vo.User;

public class LoginController implements Controller {
	private MyBatisUtil util = MyBatisUtil.getUtil();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 파라미터 확인
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 모델 연동
		System.out.println(id + " : " + pw);
		
		
		// 뷰 연결 > 페이지 리턴
		HttpSession session = request.getSession();
		SqlSession sqlSession = util.getSession();
		try {
			UserDaoImpl dao = UserDaoImpl.getDao();
			User user = dao.searchUser(id);
			if (user != null) {
				System.out.println(user.getAllergy());
				if (user.getPassword().equals(pw)) {
					session.setAttribute("LoginUser", user);
					session.setAttribute("msg", "로그인이 되었습니다.");
					return "redirect:main.jsp";
				} else {
					session.setAttribute("msg", "비밀번호가 틀렸습니다.");
				}
			} else {
				throw new RuntimeException("지정된 사용자가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "main.jsp";
		}
		
		return "main.jsp";
	}

}
