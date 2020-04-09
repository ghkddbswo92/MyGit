package com.springbook.biz;

import java.util.List;

public interface DrinkService {

	void insertdrink(DrinkVO vo);

	void updatedrink(DrinkVO vo, String before);

	void deletedrink(DrinkVO vo);

	DrinkVO getdrink(DrinkVO vo);

	List<DrinkVO> getdrinkList(DrinkVO vo);

}