package com.example.kobayashi_ma.enquete.serviceimpl;

import com.example.kobayashi_ma.enquete.bean.Enquete;
import com.example.kobayashi_ma.enquete.service.EnqueteTotalService;

/**
 * Created by kobayashi-ma on 2015/09/25.
 */
public class EnqueteTotalServiceImpl implements EnqueteTotalService {
	@Override
	public Enquete init(Long EnqueteId) {
		return Enquete.testInstance();
	}
}
