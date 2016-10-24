package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {

	//根据id查询用户
	public User queryUserById(Long id);
	
	//根据用户名和密码查询
	public User queryUserByUserNameAndPassword(String userName,String password);
	
	//保持用户
	public void saveUser(User user);
	
	//更新用户
	public void updateUser(User user);
	
	//根据id删除用户
	public void deleteUserById(Long id);
	
}
