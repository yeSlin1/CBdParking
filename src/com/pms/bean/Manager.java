package com.pms.bean;

import java.io.Serializable;
import java.util.List;

//管理员
public class Manager extends User implements Serializable {
	private int managerId; // 管理员ID
	private String managerName;// 管理员名字
	private String managerPhone;// 管理员电话
	private int managerNo; // 管理员编号
	private int userId;
	private List<Power>  power;
	
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerPhone=" + managerPhone
				+ ", managerNo=" + managerNo + ",userId=" + userId + ", power=" + power + "]";
	}


	public List<Power> getPower() {
		return power;
	}

	public void setPower(List<Power> power) {
		this.power = power;
	}



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}	





}
