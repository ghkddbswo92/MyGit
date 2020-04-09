package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.DrinkService;
import com.springbook.biz.DrinkVO;

@Service("DrinkService")
public class DrinkServiceImpl implements DrinkService{
	@Autowired
	private DrinkDAO DrinkDAO;
	
	public void insertdrink(DrinkVO vo) {
		DrinkDAO.insertdrink(vo);
	}

	public void updatedrink(DrinkVO vo, String before) {
		DrinkDAO.updatedrink(vo, before);
	}

	public void deletedrink(DrinkVO vo) {
		DrinkDAO.deletedrink(vo);
	}

	public DrinkVO getdrink(DrinkVO vo) {
		return DrinkDAO.getdrink(vo);
	}

	public List<DrinkVO> getdrinkList(DrinkVO vo){
		return DrinkDAO.getdrinkList(vo);
	}
}
