package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class UserMapperTest {

	private UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		this.userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void testQueryUserById() {

		User user = this.userMapper.queryUserById(1L);
		System.out.println(user);
	}

	@Test
	public void testQueryUserByUserNameAndPassword() {
			User user = this.userMapper.queryUserByUserNameAndPassword("zhangsan", "123456");
			System.out.println(user);
	}

	
	@Test
	public void testSaveUser() {

	User user  = new User();
	user.setId(null);
	user.setUserName("ui");
	user.setPassword("123");
	user.setName("ui");
	user.setSex(1);
	user.setAge(12);
	
	this.userMapper.saveUser(user);
	
	System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		
		
		User user  = new User();
		user.setId(7L);
		user.setUserName("ui");
		user.setPassword("12356");
		user.setName("ui");
		user.setSex(1);
		user.setAge(12);
		
		this.userMapper.updateUser(user);
	
	}

	@Test
	public void testDeleteUserById() {

	this.userMapper.deleteUserById(7L);
	
	}

}
