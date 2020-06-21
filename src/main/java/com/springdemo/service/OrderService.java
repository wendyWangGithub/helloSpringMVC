package com.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	public String add(String productCode, int number) {
		System.out.println("新增订单成功!产品code：" + productCode + ", 数量:" + number);
		return "O" + System.currentTimeMillis();
	}
	
}
