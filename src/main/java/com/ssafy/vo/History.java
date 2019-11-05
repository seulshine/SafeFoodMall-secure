package com.ssafy.vo;

import lombok.Data;

@Data
public class History {
	private int historyNo;
	private String id;
	private int code;
	private int count;
	private String eatingDate;
	
	public History() {}
	
	public History(String id, int code, int count) {
		super();
		this.id = id;
		this.code = code;
		this.count = count;
	}
	public History(int historyNo, String id, int code, int count, String eatingDate) {
		this(id, code, count);
		this.historyNo = historyNo;
		this.eatingDate = eatingDate;
	}
	
	@Override
	public String toString() {
		return "History [historyNo=" + historyNo + ", id=" + id + ", code=" + code + ", count=" + count
				+ ", eatingDate=" + eatingDate + "]";
	}

	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEatingDate() {
		return eatingDate;
	}
	public void setEatingDate(String eatingDate) {
		this.eatingDate = eatingDate;
	}
	
	
}




