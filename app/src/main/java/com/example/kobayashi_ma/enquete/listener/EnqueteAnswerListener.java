package com.example.kobayashi_ma.enquete.listener;

import com.example.kobayashi_ma.enquete.bean.Choice;

/**
 * Created by kobayashi-ma on 2015/09/04.
 */
public interface EnqueteAnswerListener {
	void answer(Choice choice);

	void back();

	void moveTotal();
}
