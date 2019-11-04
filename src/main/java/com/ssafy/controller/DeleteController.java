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

public class DeleteController implements Controller {
	private MyBatisUtil util = MyBatisUtil.getUtil();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		SqlSession sqlSession = util.getSession();
		User user = (User)session.getAttribute("LoginUser");
		System.out.println("id " + user.getId());
		
		try {
			UserDaoImpl dao = UserDaoImpl.getDao();
			dao.deleteUser(user.getId(), sqlSession);
			return "redirect:logout.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "main.jsp";
		}
	}

}
