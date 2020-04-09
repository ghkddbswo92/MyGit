package com.springbook.biz.impl;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.OrdertbService;
import com.springbook.biz.OrdertbVO;

@Service("OrdertbService")
public class OrdertbServiceImpl implements OrdertbService{
	@Autowired
	private OrdertbDAO OrdertbDAO;
	
	public void insertOrdertb(OrdertbVO vo, String Sorderlist,int time, String userid) {
		OrdertbDAO.insertOrdertb(vo, Sorderlist,time, userid);
	}
	
	public void deleteOrdertb() {
		OrdertbDAO.deleteOrdertb();
	}

	public List<OrdertbVO> getOrdertbList(OrdertbVO vo){
		return OrdertbDAO.getOrdertbList(vo);
	}

	
}
