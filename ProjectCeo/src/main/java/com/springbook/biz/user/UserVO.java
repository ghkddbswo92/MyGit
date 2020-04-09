package com.springbook.biz.user;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private int point;
	
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +" ?ãò ?ôò?òÅ?ï©?ãà?ã§. ?òÑ?û¨ ?è¨?ù∏?ä∏: "+ point;
	}
}
