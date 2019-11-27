package com.ssafy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diary {
	private int no; // primary key, auto_increment
	private int year;
	private int month;
	private int day;
	private String meal;
	private String time;
	private String kind;
	
	// search용
	public Diary(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// insert update용
	public Diary(int year, int month, int day, String meal, String time, String kind) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.meal = meal;
		this.time = time;
		this.kind = kind;
	}
	
	
	
	
	
}
