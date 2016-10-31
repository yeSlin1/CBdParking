package com.pms.bean;

import java.io.Serializable;
import java.util.List;
//权限
public class Power implements Serializable {
	private int powerId;  // 权限ID
	private String powerName; //权限名称
	private List<Manager> manager;
	public List<Manager> getManager() {
		return manager;
	}
	public void setManager(List<Manager> manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + ", manager=" + manager + "]";
	}
  public int getPowerId() {
		return powerId;
	}
	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}
	public String getPowerName() {
		return powerName;
	}
	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
  
}
