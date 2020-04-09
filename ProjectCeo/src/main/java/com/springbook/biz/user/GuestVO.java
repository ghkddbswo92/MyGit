package com.springbook.biz.user;

public class GuestVO {
	private String menu;
	private int price;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Menu= "+menu +", price= "+ price;
	}
}
