package com.pms.service;

import java.util.List;

import com.pms.bean.Personal;
import com.pms.bean.User;

public interface UserService {
	/**
	 * 登陆方法
	 * @param user
	 * @return 1为成功，0为失败
	 * 返回user对象
	 */
	public User  login(User user);
	
	/**
	 * 注册
	 * 要求1.检查重名，2.为Personal表添加初始信息
	 * @param user
	 * @return 1成功，0失败
	 */
	public int regist(User user);
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	public int modify(Personal personal);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public int add(User user);
	/**
	 * 查询  通过id
	 * @param userId
	 * @return
	 */
	public User fingbyId(int userId);
	/**
	 * 如果用户名查询
	 * @param userName
	 * @return
	 */
	public User fingbyName(String userName);


	/**
	 * 更新
	 * @param user
	 * @return
	 */
	public int Update(User user);
	
}
