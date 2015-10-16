package com.example.kobayashi_ma.enquete.dao;

import com.example.kobayashi_ma.enquete.bean.Enquete;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kobayashi-ma on 2015/10/16.
 */
public class EnqueteDao {
	//TODO:DB保存実装
	public static List<Enquete> collection = new ArrayList<>();

	public static long insertEnquete(Enquete enquete) {
		if (collection.add(enquete)) {
			return 1;
		}
		return 0;
	}

	public static List<Enquete> selectAllEnquete() {
		return collection;
	}
}
