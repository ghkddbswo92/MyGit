package com.springbook.biz;

import java.util.List;

public interface OrdertbService {

	void insertOrdertb(OrdertbVO vo, String Sorderlist, int time, String orderid);

	void deleteOrdertb();

	List<OrdertbVO> getOrdertbList(OrdertbVO vo);

}