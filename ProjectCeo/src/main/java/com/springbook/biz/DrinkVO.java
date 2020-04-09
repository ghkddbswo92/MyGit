package com.springbook.biz;

public class DrinkVO {
	private String name;
	private int price;
	private String recipe;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	@Override
	public String toString() {
		return "DrinkVO [name=" + name + ", price=" + price + ", recipe=" + recipe + "]";
	}
	
	
}
