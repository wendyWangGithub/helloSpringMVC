package com.springdemo.service;

import org.springframework.stereotype.Service;

@Service
public class StockService {

	/**
	 * 校验库存
	 */
	public boolean checkStock(String productCode, int number) {
		pause();
		if ("123".equals(productCode) && number < 10) {
			System.out.println("产品：" + "库存验证通过!");
			return true;
		} else {
			System.out.println("产品：" + "库存不足!");
			return false;
		}
	}
	
	/**
	 * 模拟延迟
	 */
	private void pause() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}