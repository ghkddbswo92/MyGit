package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.GuestVO;
import com.springbook.biz.user.ServiceGuest;
@Service("ServiceGuest")
public class GuestServiceImpl implements ServiceGuest {
	@Autowired
	private GuestDAO guestDAO;

	@Override
	public List<GuestVO> getMenuList(GuestVO gvo) {
		// TODO Auto-generated method stub
		return guestDAO.getMenuList(gvo);
	}
}
