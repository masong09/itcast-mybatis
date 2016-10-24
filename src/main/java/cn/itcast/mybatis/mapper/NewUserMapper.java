package cn.itcast.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.mybatis.pojo.User;

import com.github.abel533.mapper.Mapper;

public interface NewUserMapper extends Mapper<User>{

	/**
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	
	public List<User> queryListByPage(@Param("page") Integer page,@Param("rows") Integer rows);
}
