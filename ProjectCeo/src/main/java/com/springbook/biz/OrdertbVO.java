package com.springbook.biz;

import java.sql.*;

public class OrdertbVO {
	private int num;
	private String orderlist;
	private Timestamp nowtime;
	private Timestamp complete;
	private String orderid;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}
	public Timestamp getNowtime() {
		return nowtime;
	}
	public void setNowtime(Timestamp nowtime) {
		this.nowtime = nowtime;
	}
	public Timestamp getComplete() {
		return complete;
	}
	public void setComplete(Timestamp complete) {
		this.complete = complete;
	}

	
}
