package com.pdd.SpringBoot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.pdd.SpringBoot.bean.user;

@Mapper
public interface usersMapper {
	
	@Select("select * from users where id=#{id}")
	public user findById(@Param("id")long id);
	
	@Select("insert into users(id,name)values(#{id},#{name})")
	public void save(user user);
	
	@Select("select * from users")
	public List<user> findAll();
}
