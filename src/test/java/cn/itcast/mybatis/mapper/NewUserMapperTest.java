package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.mybatis.pojo.User;

public class NewUserMapperTest {

	private NewUserMapper newUserMapper;
	@Before
	public void setUp() throws Exception {
		
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		this.newUserMapper = sqlSession.getMapper(NewUserMapper.class);
	}

	@Test
	public void testSelectOne() {

		User param = new User();
		param.setId(1l);
		User user = this.newUserMapper.selectOne(param);
		
		System.out.println(user);
	}

	@Test
	public void testSelect() {

		List<User> list = this.newUserMapper.select(null);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testSelectCount() {
		int count = this.newUserMapper.selectCount(null);
		System.out.println(count);
	}

	@Test
	public void testSelectByPrimaryKey() {

		User user = this.newUserMapper.selectByPrimaryKey(1l);
		System.out.println(user);
	}

	@Test
	public void testInsert() {
		
		User user  = new User();
		user.setId(null);
		user.setUserName("uiw");
		user.setPassword("123");
		user.setName("uiw");
		user.setSex(1);
		user.setAge(12);
		 this.newUserMapper.insert(user);
		
		System.out.println(user);
		
	}

	@Test
	public void testInsertSelective() {

		User user  = new User();
		user.setId(null);
		user.setUserName("uiw");
		user.setPassword("123");
		user.setName("uiw");
		user.setSex(1);
		user.setAge(12);
		 this.newUserMapper.insertSelective(user);
		 System.out.println(user);
	}

	@Test
	public void testDelete() {

		User user = new User();
		user.setId(10l);
		this.newUserMapper.delete(user);
	}

	@Test
	public void testDeleteByPrimaryKey() {

		this.newUserMapper.deleteByPrimaryKey(8l);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		User user  = new User();
		user.setId(10l);
		user.setUserName("uittt");
		user.setPassword("123");
		user.setName("uiw");
		user.setSex(1);
		user.setAge(12);
		
		this.newUserMapper.updateByPrimaryKey(user);
		System.out.println(user);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		User user  = new User();
		user.setId(10l);
		user.setUserName("uityy");
//		user.setPassword("123");
//		user.setName("uiw");
//		user.setSex(1);
//		user.setAge(12);
		
		this.newUserMapper.updateByPrimaryKeySelective(user);
		System.out.println(user);
	}

	@Test
	public void testSelectCountByExample() {
		Example example = new Example(User.class);
		List values = new ArrayList<>();
		values.add(21);
		values.add(20);
		example.createCriteria().andIn("age", values);
		
		int countByExample = this.newUserMapper.selectCountByExample(example);
		System.out.println(countByExample);
	}

	@Test
	public void testDeleteByExample() {

		Example example = new Example(User.class);
		List values = new ArrayList<>();
		values.add(21);
		values.add(20);
		example.createCriteria().andIn("age", values);
		this.newUserMapper.deleteByExample(example);
	}

	@Test
	public void testSelectByExample() {

		Example example = new Example(User.class);
		List values = new ArrayList<>();
		values.add(21);
		values.add(20);
		example.createCriteria().andIn("age", values);
		
		List<User> selectByExample = this.newUserMapper.selectByExample(example);
		
		for (User user : selectByExample) {
			System.out.println(user);
		}
	
	}

	@Test
	public void testUpdateByExampleSelective() {
		
		Example example = new Example(User.class);
		List values = new ArrayList<>();
		values.add(21);
		values.add(20);
		example.createCriteria().andIn("age", values);	

		User user = new User();
		user.setAge(19);
		this.newUserMapper.updateByExampleSelective(user, example);
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testQueryListByPage(){
		
		List<User> list = this.newUserMapper.queryListByPage(2, 2);
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	
	@Test
	public void testNewPage(){
		
		PageHelper.startPage(1, 2);
		
		List<User> list = this.newUserMapper.select(null);
		
		for (User user : list) {
			
			System.out.println(user);
		}
		
		PageInfo<User> pageInfo = new PageInfo<>(list);
		
		System.out.println(pageInfo.getTotal());
		
	}

}
