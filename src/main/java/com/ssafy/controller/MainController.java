package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.service.CartService;
import com.ssafy.service.FoodService;
import com.ssafy.service.HistoryService;
import com.ssafy.service.UserService;
import com.ssafy.vo.Cart;
import com.ssafy.vo.History;

@Controller
public class MainController {
	@Autowired
	FoodService fs;

	@Autowired
	HistoryService hs;
	
	@Autowired
	CartService cs;

	@Autowired
	UserService us;

	@GetMapping("main.do")
	public String index(Model model) {
		return "main";
	}

	@GetMapping("detail.do")
	public String detail(@RequestParam("code") int code, @RequestParam("id") String id, Model model) {
		try {
		

			fs.watchFood(code); // 본 갯수 업데이트
			
			model.addAttribute("code", code);
			System.out.println("id : " + id);
			History history = new History(id, code);
			
			int count = hs.searchHistory(history);
			if (count > 0) {
				model.addAttribute("count", count);
			}
			
			Cart cart = new Cart(id, code);
			Cart qty = cs.searchCart(cart);
		
			if(qty != null && qty.getQty() > 0) {
				model.addAttribute("qty", qty.getQty());
			}
			
			Integer instock = cs.searchInStock(code);
			//System.out.println("instock : " +  instock);
			if(instock != null && instock >= 0) {
				model.addAttribute("instock", instock.intValue());
			}
			
			

			return "detail";
		} catch (Exception e) {
			throw e;
		}
	}

}
