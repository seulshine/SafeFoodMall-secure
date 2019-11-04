package com.ssafy.vo;

import java.util.List;

public class User {
	/**사용자 아이디 */
	protected String id;
	/**사용자 비밀번호 */
	protected String password;
	/**사용자 이름 */
	protected String name;
	/**사용자 주소 */
	protected String address;
	/**사용자 전화번호 */
	protected String phone;
	/**사용자 알러지 정보 */
	protected String allergy;
	
	protected List<Food> foodList;
	
	public List<Food> getFoodlist() {
		return foodList;
	}
	public void setFoodlist(List<Food> foodList) {
		this.foodList = foodList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public User(String id, String password, String name, String address, String phone, String allergy) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = allergy;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", allergy=" + allergy + "]";
	}

}
