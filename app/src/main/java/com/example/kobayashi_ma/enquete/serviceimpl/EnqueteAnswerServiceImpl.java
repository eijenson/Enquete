package com.example.kobayashi_ma.enquete.serviceimpl;

import com.example.kobayashi_ma.enquete.bean.Choice;
import com.example.kobayashi_ma.enquete.bean.Enquete;
import com.example.kobayashi_ma.enquete.service.EnqueteAnswerService;

/**
 * アンケート回答に関するサービスクラス
 * Created by kobayashi-ma on 2015/09/04.
 */
public class EnqueteAnswerServiceImpl implements EnqueteAnswerService {
	@Override
	public Enquete init() {
		//enquete = (Enquete)savedInstanceState.get(ENQUETE_ID);
		return Enquete.testInstance();
	}

	@Override
	public Choice answer(Choice choice) {
		//選択された数を増やす
		choice.setValue(choice.getValue() + 1);
		return choice;
	}

}
