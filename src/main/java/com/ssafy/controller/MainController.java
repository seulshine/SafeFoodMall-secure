package com.ssafy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") // 경로를 쓰지 않는다
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Controller> map = new HashMap<>();

	@Override
	public void init() throws ServletException {
//		map.put("/login.do", new LoginController());
//		map.put("/logout.do", new LogoutController());
//		map.put("/regist.do", new RegistController());
//		map.put("/update.do", new UpdateController());
//		map.put("/delete.do", new DeleteController());
//		map.put("/food.do", new FoodController());
//		map.put("/insertHistory.do", new HistoryInsertController());
	}

	// 모든 요청은 여기에서
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(request.getServletPath());
		Controller controller = map.get(path);
		
		
		if (controller == null) {
			System.out.println("null?");
			path = "main.jsp";
		} else {
			path = controller.execute(request, response);
		}
		
//		resp.getWriter().append("*.do : 확장자 기반 처리 " + path);
		// 후처리: 전달받은 페이지 이동
		if (path.startsWith("{")) {
			// {...}
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(path);
		} if (path.startsWith("redirect:")) {
			path = path.substring(path.indexOf(":") + 1);
			response.sendRedirect(path);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}

	}


}
