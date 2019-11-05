package com.ssafy.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
	private int historyNo;
	private String id;
	private int code;
	private int count;
	private String eating_date;
	
	@Override
	public String toString() {
		return "History [historyNo=" + historyNo + ", id=" + id + ", code=" + code + ", count=" + count
				+ ", eatingDate=" + eating_date + "]";
	}

	public History(String id, int code) {
		this.id = id;
		this.code = code;
	}
	
	
	
}




