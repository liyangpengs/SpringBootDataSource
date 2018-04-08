package com.pdd.SpringBoot.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pdd.SpringBoot.bean.Test;
import com.pdd.SpringBoot.bean.user;
import com.pdd.SpringBoot.server.TestService;

@Controller
public class TestController {
	private static Logger logger=Logger.getLogger(TestController.class);
	@Autowired
	private Test test;
	
	@Autowired
	private TestService ts;
	
	@RequestMapping(value="/")
	@ResponseBody
	public Test index(){
		return test;
	}
	
	@RequestMapping("/view")
	public String test(ModelMap map){
		map.put("name", "pdd");
		map.put("pwd", "123");
		return "index";
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public user findOne(Long id){
		return ts.findOne(id);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(user user){
		ts.save(user);
		return "success";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<user> findAll(){
		return ts.findAll();
	}
	
 }
