package com.ssafy.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.dao.UserDaoImpl;
import com.ssafy.util.MyBatisUtil;
import com.ssafy.vo.User;

public class RegistController implements Controller {
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
		
		// 모델연결
		System.out.println(id + " : " + pw  + " : " + name + " : " + addr + " : " + tel);
		System.out.println(Arrays.toString(aller));
		
		StringBuilder sb = new StringBuilder();
		for (String a : aller) {
			sb.append(a).append(',');
		}
		
		User user = new User(id, pw, name, addr, tel, sb.toString());
		
		
		HttpSession session = request.getSession();
		SqlSession sqlSession = util.getSession();
		try {
			
			UserDaoImpl dao = UserDaoImpl.getDao();
			dao.insertUser(user, sqlSession);
			session.setAttribute("user", user);
			session.setAttribute("msg", "회원가입이 되었습니다.");
//			memberService.update(member);
			return "redirect:main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "회원가입이 실패했습니다.");
			return "/member/signup.jsp";
		}
	}
}
