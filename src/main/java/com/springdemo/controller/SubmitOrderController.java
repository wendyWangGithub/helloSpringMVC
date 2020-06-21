package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.service.SubmitOrderService;
import com.springdemo.vo.BaseResult;

@Controller
@RequestMapping("/order")
public class SubmitOrderController {

	@Autowired
	private SubmitOrderService submitOrderService;
	
	@ResponseBody
	@RequestMapping("/submitAsync")
    public BaseResult<String>submit(String productCode, Integer number) {
		try {
			String orderNo = submitOrderService.submitAsync(productCode, number);
			return BaseResult.ok(orderNo);
		} catch (Exception e) {
			return handleException(e);
		}
    }
	
	@ResponseBody
	@RequestMapping("/submitSync")
    public BaseResult<String>submitNormal(String productCode, Integer number) {
		try {
			String orderNo = submitOrderService.submitSync(productCode, number);
			return BaseResult.ok(orderNo);
		} catch (Exception e) {
			return handleException(e);
		}
    }
	
	private BaseResult handleException(Exception e) {
		return BaseResult.fail("500", e.getMessage());
	}
	
}
