package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.service.FoodService;
import com.ssafy.service.HistoryService;
import com.ssafy.service.UserService;

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
	public String detail(@RequestParam("code") String code,  Model model) {
		model.addAttribute("code", code);
		return "detail";
	}
	
}
