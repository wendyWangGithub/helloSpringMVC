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
		<h2>页面路径：http://localhost:8080/helloSpringMVC</h2>
		<h2>有道云笔记关于该项目的说明（文件上层有个专门的目录）： <br>http://note.youdao.com/noteshare?id=c924361d7cc9c4d2c2e44e389ae344d4</h2>
        <h2>1、功能一 <br>&nbsp;&nbsp;&nbsp;&nbsp; 
        		1.1、SpringMVC框架点击跳转，https://www.cnblogs.com/daxiang2008/p/9663317.html<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		1.2、DATE:20191120</h2>
        <h2>2、功能二<br>&nbsp;&nbsp;&nbsp;&nbsp; 
        		2.1、连接数据库，pom文件要添加 mysql-connector-java.jar<br>&nbsp;&nbsp;&nbsp;&nbsp; 
        		2.2、Mybatis框架操作数据库，单表查询：https://www.cnblogs.com/xqz0618/p/javaweb03.html<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		2.3、DATE:20200329:Mybatis框架操作数据库，①mysql表分次查询。②mysql表联合查询<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		2.4、DATE:20191206</h2>
        <h2>3、功能三 <br>&nbsp;&nbsp;&nbsp;&nbsp; 
      			3.1、  写一个httpPost和一个httpGet请求来操作数据库<br>&nbsp;&nbsp;&nbsp;&nbsp; 
      			3.2、需要Spring和Mybatis关联，文件：spring-mybatis.xml。<br>&nbsp;&nbsp;&nbsp;&nbsp;
      			3.3、pom文件需要的artifactId为：mybatis-spring、commons-dbcp、spring-jdbc、fastjson<br>&nbsp;&nbsp;&nbsp;&nbsp;
      			3.4、说明：此功能不需要httpclient的jar包，httpclient是模拟浏览器发送请求的，<br>&nbsp;&nbsp;&nbsp;&nbsp;
      				调用此httpPost或者httpGet请求时则需要用到httpclient了。此功能为DLJ代写<br>&nbsp;&nbsp;&nbsp;&nbsp;
      			3.5、DATE:20191208
      			</h2>
        <h2>4、功能四<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		4.1、httpclientjar包，写一个httppost请求并是多线程的，是否需要hessian，todo</h2><br>&nbsp;&nbsp;&nbsp;&nbsp;
        <h2>5、功能五<br>&nbsp;&nbsp;&nbsp;&nbsp;
        		5.1、testng做测试<br>&nbsp;&nbsp;&nbsp;&nbsp;
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