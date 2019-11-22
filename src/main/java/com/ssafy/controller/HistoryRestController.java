package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.ssafy.service.CartService;
import com.ssafy.service.FoodService;
import com.ssafy.service.HistoryService;
import com.ssafy.vo.Cart;
import com.ssafy.vo.Food;
import com.ssafy.vo.History;
import com.ssafy.vo.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin(value="*")
public class HistoryRestController {
	
	
	@Autowired
	HistoryService hservice;
	
	@GetMapping("updateHistory")
	public String updateHistory(History history, Model model) {

		return "detail";
	}
	
	@PostMapping("updateHistory")
	public String updateHistory(History history, HttpSession session) {
		log.trace("updateHistory is called");
		System.out.println(history.toString());
		try {
			//System.out.println(history.toString());
			int result = hservice.updateHistory(history);
			if(result > 0) {
				System.out.println(result + " : update");
			} else {
				result = hservice.insertHistory(history); // 업데이트 할게 없다면 insert
				System.out.println(result + " : insert");
			}
			return "redirect:detail.do?code=" + history.getCode() + "&id=" + history.getId();
		} catch (Exception e) {
			log.error("getAllFoods", e);
			//throw e;		// 얘를 호출한놈은 spring. 이걸 톰캣이 클라이언트한테 에러로 보낸다.

		}
		
		return "redirect:detail.do?code=" + history.getCode() + "&id=" + history.getId()+".jsp";
	}
	
	
	@Autowired
	CartService cservice;
	
	@GetMapping("updateCart")
	public String updateCart(Cart cart, Model model) {

		return "detail";
	}
	
	@PostMapping("updateCart")
	public String updateCart(Cart cart, HttpSession session) {
		log.trace("updateCart is called");
		//System.out.println(cart.toString());
		try {
			
			if(cart.getQty()==0) {
				int result = cservice.deleteCart(cart);
			} else {
				//System.out.println(history.toString());
				int result = cservice.updateCart(cart);
				if(result > 0) {
					//System.out.println(result + " : update");
				} else {
					result = cservice.insertCart(cart); // 업데이트 할게 없다면 insert
					//System.out.println(result + " : insert");
				}
			}
			return "redirect:detail.do?code=" + cart.getCode() + "&id=" + cart.getId();
		} catch (Exception e) {
			log.error("getAllFoods", e);
			//throw e;		// 얘를 호출한놈은 spring. 이걸 톰캣이 클라이언트한테 에러로 보낸다.

		}
		
		return "redirect:detail.do?code=" + cart.getCode() + "&id=" + cart.getId()+".jsp";
	}
}
