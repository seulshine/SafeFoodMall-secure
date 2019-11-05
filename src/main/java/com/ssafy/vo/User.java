package com.ssafy.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
	protected String[] aller;
	
	protected String allergy;
	
	protected List<Food> foodList;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", allergy=" + allergy + "]";
	}

}
