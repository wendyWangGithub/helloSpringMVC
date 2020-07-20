package com.springdemo.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.exception.BusinessException;

@Service
public class SubmitOrderService {

	@Autowired
	private ProductService productService;
	@Autowired
	private StockService stockService;
	@Autowired
	private OrderService orderService;
	
    private ExecutorService executorService = Executors.newCachedThreadPool();
    
    /**
     * 并行校验产品状态和库存
     */
	public String submitAsync(String productCode, int number) {
		long start = System.currentTimeMillis();
		try {
			doCheckAsync(productCode, number);
			return orderService.add(productCode, number);
		} catch (BusinessException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (Exception e) {
			throw new RuntimeException("请稍后再试!", e);
		} finally {
			System.out.println("耗时 ： " + (System.currentTimeMillis() - start) + "ms");
		}
	}
	
	/**
	 * 串行校验产品状态和库存
	 */
	public String submitSync(String productCode, int number) {
		long start = System.currentTimeMillis();
		try {
			doCheckSync(productCode, number);
			return orderService.add(productCode, number);
		} finally {
			System.out.println("耗时 ： " + (System.currentTimeMillis() - start) + "ms");
		}
	}

	private void doCheckSync(String productCode, int number) {
		if (!productService.checkProduct(productCode)) {
			throw new RuntimeException("产品已下架！");
		}
		if (!stockService.checkStock(productCode, number)) {
			throw new RuntimeException("库存不足!");
		}
		
	}
	
	private void doCheckAsync(String productCode, int number) throws Exception {
		Future<Boolean> checkProductFuture = executorService.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return productService.checkProduct(productCode);
			}
		});
		Future<Boolean> checkStockFuture = executorService.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return stockService.checkStock(productCode, number);
			}
		});
		if (!checkProductFuture.get(3 * 1000, TimeUnit.MILLISECONDS)) {
			throw new BusinessException("产品已下架！");
		}
		if (!checkStockFuture.get(3 * 1000,  TimeUnit.MILLISECONDS)) {
			throw new BusinessException("库存不足!");
		}
	}
	
}