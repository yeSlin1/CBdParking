package com.pms.bean;

import java.io.Serializable;

/**
 * 用户实体类
 * @author CSL
 *
 */
public class User  implements Serializable{
	/** 缓存名称 */
	public static final String USER_NAME = "user_name";
	/** 缓存key */
	public static final String USER_KEY = "user_key";
	private  int  userId;//用户ID
	private String userName;//用户名
	private String userPassword;//用户密码
	private int userType;//用户类型
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userType="
				+ userType + "]";
	}
	

	
}
