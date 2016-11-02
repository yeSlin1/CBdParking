package com.pms.service.impl;

import javax.annotation.Resource;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   
	/** CacheManager */
	private static final CacheManager cacheManager = CacheManager.create();
	

	
	@Override
	public Boolean login(User userlog) {
		
		User ucheck = fingbyName(userlog.getUserName());
		
		Ehcache cache = cacheManager.getEhcache(User.USER_NAME);
	
//		if (cacheElement!=null) {
//			 return true;
//		}
		

//		if (userlog.getUserName()) {
//		}
		
		if (ucheck == null) {
			// System.out.println(ucheck.toString());
			return false;
		} else {
			if (ucheck.getUserPassword().equals(userlog.getUserPassword())) {
				cache.put(new Element(User.USER_KEY,ucheck));
				
				Element cacheElement = cache.get(User.USER_KEY);
				User ucheck2 = (User) cacheElement.getObjectValue();
				
				
				System.out.print(ucheck2.toString());
             return true;
			} else {
				// 用户名正确但是密码错误
				return false;
			}
		}
		
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

	@Cacheable(User.USER_NAME)
	@Transactional(readOnly = true)
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
