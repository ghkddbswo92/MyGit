package com.springbook.biz.user;

import java.util.List;

public interface ServiceUser {
	
	public UserVO getUser(UserVO vo);
	
	public void insertUser(UserVO vo);
	
	public void point_update(UserVO vo,int price);
	
	List<UserVO> check_User();
	
}
