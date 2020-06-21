package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.springdemo.model.Scores;
import com.springdemo.model.User;

public class Test {
	
	public static void main(String[] args) throws IOException {

	//mybatis的配置文件
	String resource = "mybatis/MybatisConf.xml";
	//使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	InputStream is = Resources.getResourceAsStream(resource);
	//构建sqlSession的工厂
	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	//使用Mybatis提供的Resource类加载mybatis的配置文件（它也加载关联的映射文件)
	//Reader reader = Resources.getResourceAsReader(resource);
	//构建sqlSession的工厂
	//SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	//创建能执行映射文件中sql的sqlSession
	SqlSession session = sessionFactory.openSession();
	
	/*
	 * 映射sql的标识字符串，
	 * me.gacl.mapping.userMapper|?springdemo.mapping.userMappe是userMapper.xml文件中mapper标签的namespace属性的值，
	 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	 */
	/*根据id查找users表中的某一条数据*/
	String statement = "com.springdemo.mapper.UserMapper.getUser";
	//映射sql的标识字符串，getUser与映射文件中配置select标签id一致
	//执行查询返回一个唯一user对象的sql
	User user = session.selectOne(statement,1);
	System.out.println("根据id查找users表中的某一条数据结果为：");
	System.out.println(user);
	System.out.println();
	
	/*
	 * 列出users表中的所有数据
	 */
	String stateselect = "com.springdemo.mapper.UserMapper.selectUser";
	List<User> userList = session.selectList(stateselect);
	System.out.println("列出users表中的所有数据");
	for(int i=0;i<userList.size();i++){
		System.out.println(userList.get(i));
	}
	System.out.println();

	
	/*
	 * 列出Scores表中的所有数据
	 */
	String stateselectscores = "com.springdemo.mapper.ScoresMapper.selectScores";
	List<Scores> scoresList = session.selectList(stateselectscores);
	System.out.println("列出Scores表中的所有数据");
	for(int i=0;i<scoresList.size();i++){
		System.out.println(scoresList.get(i));
	}
	System.out.println();
	
	/*
	 * 删除指定某一列users数据
	 */
/*	String statedelete = "springdemo.mapping.userMapper.deleteUser";
	try{
		session.delete(statedelete,1);
		session.commit();
		System.out.println("删除指定某一列users数据");
		System.out.println();
	}catch(Exception e){
		e.printStackTrace();
		session.rollback();
	}*/
	
	/*
	 * 更新users表记录
	 */
	String stateUpdate = "com.springdemo.mapper.UserMapper.updateUser";
	User userup = new User("name221","password22");
	userup.setId(2);
	try{
		session.update(stateUpdate,userup);
		session.commit();
		System.out.println("更新users表id为2的记录成功！");
		System.out.println();
	}catch(Exception e){
		e.printStackTrace();
		session.rollback();
	}
	
	/*
	 * 新增users表记录
	 */
		/*
		 * String stateInsert = "com.springdemo.mapper.UserMapper.insertUser"; User
		 * userin = new User("namex","passwordx"); try{
		 * session.insert(stateInsert,userin); session.commit();
		 * System.out.println("新增users表记录成功！"); System.out.println(); }catch(Exception
		 * e){ e.printStackTrace(); session.rollback(); }
		 */
	
	/*表联合查询*/
	String statementUnion = "com.springdemo.mapper.UserMapper.getScore";
	//映射sql的标识字符串，getUser与映射文件中配置select标签id一致
	User user1 = session.selectOne(statementUnion, 5);
	System.out.println("联合表查询用户成绩为:" + user1);
	
	/*
	 * 分步查询用户和成绩
	 */
	List<User> _userList = session.selectList("com.springdemo.mapper.UserMapper.selectUser");
	for (User _user : _userList) {
		Scores score = session.selectOne("com.springdemo.mapper.ScoresMapper.getScoreByUserName", _user.getName());
		if(score != null && score.getName() != null) {
			System.out.println("分步查询用户和成绩结果为：" + score);
		} 
	}
	//判断是否为没有设置mybatis编码导致的程序错误
		/*
		 * Scores score =
		 * session.selectOne("com.springdemo.mapper.ScoresMapper.getScoreByUserName",
		 * "A"); System.out.println(score);
		 */
	}
}
	
