package com.pms.mappertest;

import java.util.List;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.bean.User;
import com.pms.mapper.UserMapper;
import com.pms.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../applicationContext.xml")
public class TestUser {


	@Resource
	private UserService service;
	
	@Test
	public void login() {
		User user = new User();
		user.setUserName("admin");
		user.setUserPassword("123123");
		User u1 = service.login(user);
		System.out.println(u1);
	}




}
