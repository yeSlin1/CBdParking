package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.Personal;
import com.pms.bean.User;
import com.pms.mapper.CompanyMapper;
import com.pms.mapper.ManagerMapper;
import com.pms.mapper.PersonalMapper;
import com.pms.mapper.UserMapper;
import com.pms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private PersonalMapper personalMapper;
	@Resource
	private ManagerMapper manangerMapper;
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public User login(User userlog) {
		
		User ucheck = userMapper.getUserByUserName(userlog.getUserName());
//		if (userlog.getUserName()) {
//			
//		}
		if (ucheck == null) {
			// System.out.println(ucheck.toString());
			return null;
		} else {
			if (ucheck.getUserPassword().equals(userlog.getUserPassword())) {
				switch (ucheck.getUserType()) {
				// 0超级管理员 1企业用户 2个人用户 3操作员
				// 正常登陆
				case 0:
					return manangerMapper.findManagerByUserId(ucheck.getUserId());
				case 1:
					return companyMapper.findCompanyByUserId(ucheck.getUserId());
				case 2:
					return personalMapper.findPersonlByUserId(ucheck.getUserId());
				case 3:
					return manangerMapper.findManagerByUserId(ucheck.getUserId());
				}
			} else {
				// 用户名正确但是密码错误
				return null;
			}
		}
		return null;
	}

	@Override
	public int regist(User user) {
		User userName = userMapper.getUserByUserName(user.getUserName());
		if (userName == null) {
			userMapper.addUser(user);

			Personal personal = new Personal();
			personal.setUserId(user.getUserId());
			personalMapper.addPersonal(personal);

			return 1;
		} else {
			// 已存在用户名
			return 0;
		}
	}

	@Override
	public int modify(Personal personal) {
		return personalMapper.updatePersonal(personal);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
		return 0;
	}

	@Override
	public User fingbyId(int userId) {
		// TODO Auto-generated method stub
		
		return userMapper.getUserById(userId);
	}

	@Override
	public User fingbyName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserName(userName);
	}

	@Override
	public int Update(User user) {
		// TODO Auto-generated method stub
		
		
		return userMapper.updateUser(user);
	}

}
