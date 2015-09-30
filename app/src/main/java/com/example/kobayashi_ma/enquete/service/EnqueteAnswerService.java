package com.example.kobayashi_ma.enquete.service;

import com.example.kobayashi_ma.enquete.bean.Choice;
import com.example.kobayashi_ma.enquete.bean.Enquete;

/**
 * アンケート回答に関するサービスのインターフェース
 * Created by kobayashi-ma on 2015/09/04.
 */
public interface EnqueteAnswerService {
	/**
	 * 初期化
	 */
	Enquete init();

	/**
	 * 回答
	 */
	Choice answer(Choice choice);
}
