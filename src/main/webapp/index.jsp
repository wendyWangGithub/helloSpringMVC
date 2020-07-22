<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聚合页面</title>
</head>
<script src="jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function addUser(){
		var data = {};
		data['name'] = $("#name").val();
		data['password'] = $("#password").val();
			alert(JSON.stringify(data));
		$.ajax({
			headers: {
				'content-type': 'application/json'
			},
			url: "/helloSpringMVC/addUser",
			data: JSON.stringify(data),
			async: false,
			type: "post",
			datatype: "json",
			success: function(data) { //ajax返回的数据
				var _data = $.parseJSON(data);
				if(_data.success){
					alert(_data.errorMsg);
				}else {
					alert(_data.errorMsg);
				}
			},
			error: function(a, b, c) {
				console.info(a, b, c);
			}
		});
	}
</script>
<body>
			<h2>a页面路径：http://localhost:8080/helloSpringMVC</h2>
			<h2>有道云笔记关于该项目的说明（文件上层有个专门的目录）： <br>http://note.youdao.com/noteshare?id=c924361d7cc9c4d2c2e44e389ae344d4</h2>
			<h2>1、功能一 <br>&nbsp;&nbsp;&nbsp;&nbsp;
				1.1、SpringMVC框架点击跳转，https://www.cnblogs.com/daxiang2008/p/9663317.html<br>&nbsp;&nbsp;&nbsp;&nbsp;
				1.2、DATE:20191120<br>&nbsp;&nbsp;&nbsp;&nbsp;
			 	1.3、DATE:2020626 涉及文件：web.xml,springContext.xml,HelloSpringController.java,hellospring.jsp,index.jsp.</h2>
			<h2>2、功能二<br>&nbsp;&nbsp;&nbsp;&nbsp;
				2.1、连接数据库，pom文件要添加 mysql-connector-java.jar<br>&nbsp;&nbsp;&nbsp;&nbsp;
				2.2、Mybatis框架操作数据库，单表查询：https://www.cnblogs.com/xqz0618/p/javaweb03.html<br>&nbsp;&nbsp;&nbsp;&nbsp;
				涉及文件：spring-mybatis.xml,MybatisConf.xml,UserMapper.mxl,ScoresMapper.xml,User.java,Scores.java,test.java<br>&nbsp;&nbsp;&nbsp;&nbsp;
				2.3、DATE:20200329:Mybatis框架操作数据库，①mysql表分次查询。②mysql表联合查询<br>&nbsp;&nbsp;&nbsp;&nbsp;
				涉及文件：test.java,User.java<br>&nbsp;&nbsp;&nbsp;&nbsp;
				2.4、DATE:20191206</h2>
			<h2>3、功能三 <br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.1、  写一个httpPost和一个httpGet请求来操作数据库<br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.2、需要Spring和Mybatis关联，文件：spring-mybatis.xml。<br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.3、pom文件需要的artifactId为：mybatis-spring、commons-dbcp、spring-jdbc、fastjson<br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.4、说明：此功能不需要httpclient的jar包，httpclient是模拟浏览器发送请求的，<br>&nbsp;&nbsp;&nbsp;&nbsp;
				调用此httpPost或者httpGet请求时则需要用到httpclient了。DLJ<br>&nbsp;&nbsp;&nbsp;&nbsp;
				涉及文件：HelloSpringController.java,UserService.java,UserMapper.java中的方法getUser和insertUser对应UserMapper.xml中id为gerUser和insertUser<br>&nbsp;&nbsp;&nbsp;&nbsp;
				页面中添加User：涉及文件HelloSpringController.java,index,jsp,BaseResult.java,todo<br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.6、index.jsp中使用json，get及post，ajax方式提交表单（用户数据）详解：https://www.iqiyi.com/w_19rr0ngp89.html，<br>&nbsp;&nbsp;&nbsp;&nbsp;
				https://tv.sohu.com/v/cGwvOTQ1ODAyNi85ODc5NTI5MC5zaHRtbA==.html<br>&nbsp;&nbsp;&nbsp;&nbsp;
				3.5、DATE:20191208
			</h2>
			<h2>4、功能四 <br>&nbsp;&nbsp;&nbsp;&nbsp;
				4.1、httpclientjar包（并没有用httpclient还是自己写的请求），写一个httppost请求并是多线程的，是否需要hessian，todo<br>&nbsp;&nbsp;&nbsp;&nbsp;
				异步请求：http://localhost:8080/helloSpringMVC_war_exploded/order/submitSync?productCode=123&number=4<br>&nbsp;&nbsp;&nbsp;&nbsp;
				同步请求：http://localhost:8080/helloSpringMVC_war_exploded/order/submitAsync?productCode=123&number=4<br>&nbsp;&nbsp;&nbsp;&nbsp;
				入口-SubmitOrderController.java,模拟数据-StockService.java,ProductService.java,<br>&nbsp;&nbsp;&nbsp;&nbsp;
				模拟延迟接口，为了方便看出来同步和异步哪个请求时间快。每个请求都做了两个验证，checkProduct，checkStock所以走的代码也是一样的<br>&nbsp;&nbsp;&nbsp;&nbsp;
				多线程-SubmitOrderService.java，开启线程执行executorService.submit(new Callable)<br>&nbsp;&nbsp;&nbsp;&nbsp;
					异步没看到有多个线程，同步没看到发送请求（因为这只是一个接口，不需要发送请求，发送请求是httpclient做的事，异步也只是管理的线程问题）<br>&nbsp;&nbsp;&nbsp;&nbsp;
					4.2、DATE：20200705
			</h2>
        <h2>5、功能五<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		5.1、testng做测试todoza项目如何解析验证点的，如何解析json数据，如何管理报告的？<br>&nbsp;&nbsp;&nbsp;&nbsp;
        </h2>
			<h2>6、功能六<br>&nbsp;&nbsp;&nbsp;&nbsp;
				6.1、用httpclient模拟浏览器发送http请求post请求的body为json格式。并用alibabafastjson解析。见kaopu项目，com.test.httpclient包<br>&nbsp;&nbsp;&nbsp;&nbsp;
				调用了heooSpringMVC项目中的saveUser接口（http请求）。
				6.2、DATE：20200705<br>&nbsp;&nbsp;&nbsp;&nbsp;
			</h2>
        <h2>说明：框架为累计</h2>
        <h2>知识点：</h2>
        <h2>AJAX、泛型</h2>
        <h3>
            <a href="hello?name=zhangsan">6、点击跳转</a><br>
         <h3>7、添加用户</h3>
         	<form action="" name="form" id="">
            	名字：<input type="text" id="name">
            	密码：<input type="text" id="password">
            	<input type="button" value="添加" onclick="addUser();">
            </form>
        </h3>
</body>
</html>