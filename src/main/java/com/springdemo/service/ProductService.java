package com.springdemo.service;

import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	/**
	 * 产品状态验证
	 */
	public boolean checkProduct(String productCode) {
		pause();
		if ("123".equalsIgnoreCase(productCode)) {
			System.out.println("产品：" + productCode + "状态验证通过!");
			return true;
		} else {
			System.out.println("产品：" + productCode + "已下架!");
			return false;	
		}
	}

	/**
	 * 模拟延迟
	 */
	private void pause() {
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}