package com.ssafy.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
	private Date regdate;
	private String id;
	private String name;
	private int price;
	private int code;
	private int qty;
	private String img;
	
	
	
	@Override
	public String toString() {
		return "Order [regdate=" + regdate + ", id=" + id + ", name=" + name + ", price=" + price + ", code=" + code
				+ ", qty=" + qty + ", img=" + img + "]";
	}



	public Order(String id, String name, int price, int code, int qty, String img) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.code = code;
		this.qty = qty;
		this.img = img;
	}

	
}