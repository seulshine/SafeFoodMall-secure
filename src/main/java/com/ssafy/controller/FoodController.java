package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		FoodDao dao = FoodDaoImpl.getDao();
//		List<Food> foods = dao.getList();
//		
//		Gson gson = new Gson();
//		return gson.toJson(foods);
		return null;
	}

}
