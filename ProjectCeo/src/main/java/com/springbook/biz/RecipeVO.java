package com.springbook.biz;

public class RecipeVO {
	private String num;
	private String action;
	private int time;
	private int priority;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "RecipeVO [num=" + num + ", action=" + action + ", time=" + time + ", priority=" + priority + "]";
	}
	
}
