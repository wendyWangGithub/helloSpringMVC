package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.model.User;
import com.springdemo.service.UserService;
import com.springdemo.vo.BaseResult;

 
@Controller//@Controller注解为Spring标注前置控制器的方式
public class HelloSpringController {
	
	@Autowired
	private UserService userService;
	
    String message = "Welcome to Spring MVC!";
 
    @RequestMapping("/hello")//@RequestMapping注解映射web请求到具体要操作的类或者方法上面,//@RequestParam注解为请求指定参数
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
        ModelAndView mv = new ModelAndView("hellospring");//指定视图向视图中添加所要展示或使用的内容，将在页面中使用
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
    
    /**
     * get请求，请求报文，url：http://localhost:8080/helloSpringMVC_war_exploded/getUserById?id=4
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
	@RequestMapping("/getUserById")
	public Object getUserById(HttpServletRequest request, HttpServletResponse response) {
    	User user = userService.queryById(Integer.valueOf(request.getParameter("id")));
		return user;
	}
    
    /**
     * post请求，需要有@RequestBody
     * 请求报文：Post请求url：http://localhost:8080/helloSpringMVC/addUser，body：{"name":"a","password":"abc"}
     * @param user
	 * @RequestBody表示请求为json格式。
     * @return
     */
    @ResponseBody
   	@RequestMapping("/addUser")
   	public BaseResult<User> addUser(@RequestBody User user) {
    	try {
    		userService.add(user);
       		return BaseResult.ok(user);
    	} catch(Exception e) {
    		return BaseResult.fail("500", e.getMessage());
    	}
       	
   	}
    
}