package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.dao.HistoryDao;
import com.ssafy.util.MyBatisUtil;
import com.ssafy.vo.History;
import com.ssafy.vo.User;

public class HistoryInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HistoryDao hDao = HistoryDao.getInstance();
		SqlSession session = MyBatisUtil.getUtil().getSession();
		HttpSession webSession = request.getSession();
		User user = (User) webSession.getAttribute("LoginUser");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int code = Integer.parseInt(request.getParameter("code"));
		History history = new History(user.getId(), code, quantity);
		System.out.println("-------------------------------------------");
		System.out.println(history);
		hDao.insertHistory(session, history);
		return "main.jsp";
	}
}