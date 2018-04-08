package com.pdd.SpringBoot.server;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pdd.SpringBoot.Annotation.changeDataSource;
import com.pdd.SpringBoot.Enum.DataSourceKey;
import com.pdd.SpringBoot.bean.user;
import com.pdd.SpringBoot.dao.usersMapper;

@Service
public class TestService {
	
	@Autowired
	private usersMapper um;
	
	@changeDataSource(DataSourceKey.rDaraSource)
	public user findOne(Long id){
		return um.findById(id);
	}
	
	@changeDataSource(DataSourceKey.wDataSource)
    public void save(user user){
		um.save(user);
    }
	
	@changeDataSource(DataSourceKey.rDaraSource)
	public List<user> findAll(){
		return um.findAll();
	}
	
}
