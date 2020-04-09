package com.springbook.biz.impl;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.OrdertbService;
import com.springbook.biz.OrdertbVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("OrdertbDAO")

public class OrdertbDAO implements OrdertbService {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String ordertb_insert = "insert into ordertb(orderlist,complete,orderid) values (?,ifnull(dateadd ('second',?,select complete from (select * from ordertb order by num desc limit 1)), dateadd('second',?,now())), ?)";
	private final String ordertb_delete = "delete ordertb where complete < now()";
	private final String ordertb_list = "select * from ordertb order by num";
	
	@Override
	public void insertOrdertb(OrdertbVO vo, String Sorderlist, int time, String orderid) {
		System.out.println("insert 작동");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(ordertb_insert);
			stmt.setString(1, Sorderlist);
			stmt.setInt(2, time);
			stmt.setInt(3, time);
			stmt.setString(4, orderid);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	@Override
	public void deleteOrdertb() {
		System.out.println("delete 작동");
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(ordertb_delete);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	@Override
	public List<OrdertbVO> getOrdertbList(OrdertbVO vo){
		System.out.println("List get 작동");
		List<OrdertbVO> ordertbList = new ArrayList<OrdertbVO>();
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ordertb_list);
			rs = stmt.executeQuery();
			while(rs.next()){
				OrdertbVO ordertb = new OrdertbVO();
				ordertb.setNum(rs.getInt("num"));
				ordertb.setOrderlist(rs.getString("orderlist"));
				ordertb.setNowtime(rs.getTimestamp("nowtime"));
				ordertb.setComplete(rs.getTimestamp("complete"));
				ordertb.setOrderid(rs.getString("orderid"));
				ordertbList.add(ordertb);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return ordertbList;
	}
}
