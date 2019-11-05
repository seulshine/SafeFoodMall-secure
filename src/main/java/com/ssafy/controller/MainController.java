package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.service.FoodService;
import com.ssafy.service.HistoryService;
import com.ssafy.service.UserService;
import com.ssafy.vo.History;

@Controller
public class MainController {
	@Autowired
	FoodService fs;

	@Autowired
	HistoryService hs;

	@Autowired
	UserService us;

	@GetMapping("main.do")
	public String index(Model model) {
		return "main";
	}

	@GetMapping("detail.do")
	public String detail(@RequestParam("code") int code, @RequestParam("id") String id, Model model) {
		try {
			model.addAttribute("code", code);
			System.out.println("id : " + id);
			History history = new History(id, code);
			int result = hs.searchHistory(history);
			if (result > 0) {
				model.addAttribute("count", result);
			}
			return "detail";
		} catch (Exception e) {
			throw e;
		}
	}

}
