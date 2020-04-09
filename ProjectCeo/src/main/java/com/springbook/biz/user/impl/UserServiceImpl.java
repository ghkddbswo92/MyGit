package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.ServiceUser;
import com.springbook.biz.user.UserVO;

@Service("ServiceUser")
public class UserServiceImpl implements ServiceUser {
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		userDAO.insertUser(vo);
		
	}

	@Override
	public void point_update(UserVO vo, int price) {
		// TODO Auto-generated method stub
		userDAO.point_update(vo, price);
	}

	@Override
	public List<UserVO> check_User() {
		// TODO Auto-generated method stub
		return userDAO.check_User();
	}

	



}
