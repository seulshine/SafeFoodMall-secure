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

public class UpdateController implements Controller {
	private MyBatisUtil util = MyBatisUtil.getUtil();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String[] aller = request.getParameterValues("aller");
		
		System.out.println("id");
		
		StringBuilder sb = new StringBuilder();
		for (String a : aller) 
			sb.append(a).append(',');
		
		User user = new User(id, pw, name, addr, tel, sb.toString());
		
		try {
			SqlSession sqlSession = util.getSession();
			UserDaoImpl dao = UserDaoImpl.getDao();
			dao.updateUser(user, sqlSession);					
			HttpSession session = request.getSession();
			session.setAttribute("msg", "정보가 수정되었습니다.");
			session.setAttribute("LoginUser", user);
//			memberService.update(member);
			return "redirect:main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/member/modify.jsp";
		}
	}

}
