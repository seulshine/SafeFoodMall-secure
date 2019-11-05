package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.FoodDao;
import com.ssafy.dao.FoodDaoImpl;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	FoodDao dao;
	
	private String[] allergys={"대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"};

	
	public List<Food> searchAll() {
		return dao.searchAll();
	}
	
	//  code에  맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
	public Food search(int code) {
		Food food =	dao.search(code);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allergys.length; i++) {
			if (food.getMaterial().contains(allergys[i]))
			{
				sb.append(allergys[i]).append(",");
			}
		}
		
		food.setAllergy(sb.toString());
		
		return food;
	}
	
	public List<Food> searchBest() {
		return dao.searchBest();
	}
	
	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}
}
