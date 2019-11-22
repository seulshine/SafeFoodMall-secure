package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	private String id;
	private String name;
	private int price;
	private int code;
	private int qty;
//	private int listPrice; // code * qty
//	private int totalCost; // cart의 총 합 수
	
	public Cart(String id, int code) {
		this.id = id;
		this.code = code;
	}

	
	
}
