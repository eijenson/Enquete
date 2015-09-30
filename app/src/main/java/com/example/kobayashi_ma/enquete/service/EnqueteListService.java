package com.example.kobayashi_ma.enquete.service;

/**
 * Created by kobayashi-ma on 2015/09/25.
 */
public interface EnqueteListService {
	/**
	 * 初期化
	 */
	void init();

	/**
	 * 回答画面へ遷移
	 */
	void moveAnswer(Long id);

	/**
	 * 集計画面へ遷移
	 */
	void moveTotal(Long id);
}
