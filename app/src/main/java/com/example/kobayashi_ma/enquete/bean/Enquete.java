package com.example.kobayashi_ma.enquete.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kobayashi-ma on 2015/09/04.
 */
public class Enquete {

	private long id;

	private String name;

	private List<Choice> choiceList;

	private static Enquete testEnquete;

	public static Enquete testInstance() {
		if (testEnquete == null) {
			testEnquete = new Enquete();
		}
		return testEnquete;
	}

	public Enquete() {
		id = java.util.Calendar.getInstance().getTimeInMillis();
		name = "旅行に行きたい場所は？";
		choiceList = new ArrayList<>();
		choiceList.add(new Choice("北海道"));
		choiceList.add(new Choice("沖縄"));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Choice> getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(List<Choice> choiceList) {
		this.choiceList = choiceList;
	}
}