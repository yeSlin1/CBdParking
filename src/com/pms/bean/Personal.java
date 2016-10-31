package com.pms.bean;

import java.io.Serializable;
import java.util.List;

public class Personal extends User implements Serializable {

	private int personalId;//个人用户编号
	private String personalName;//个人用户姓名
	private String personalRealName;//真实姓名
	private String personalPhone;//个人用户密码
	private String personalIdCard;//个人用户电话号码
	private String personalAddress;//个人用户地址
	private String personalJob;//个人用户职位
	private double tenantReputation;//租用信誉
	private double renterReputation;//出租信誉
	private List<Parking> parkList;//个人可能拥有多个车位
	
	
	public List<Parking> getParkList() {
		return parkList;
	}
	public void setParkList(List<Parking> parkList) {
		this.parkList = parkList;
	}
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalRealName() {
		return personalRealName;
	}
	public void setPersonalRealName(String personalRealName) {
		this.personalRealName = personalRealName;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getPersonalIdCard() {
		return personalIdCard;
	}
	public void setPersonalIdCard(String personalIdCard) {
		this.personalIdCard = personalIdCard;
	}
	public String getPersonalAddress() {
		return personalAddress;
	}
	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}
	public String getPersonalJob() {
		return personalJob;
	}
	public void setPersonalJob(String personalJob) {
		this.personalJob = personalJob;
	}
	public double getTenantReputation() {
		return tenantReputation;
	}
	public void setTenantReputation(double tenantReputation) {
		this.tenantReputation = tenantReputation;
	}
	public double getRenterReputation() {
		return renterReputation;
	}
	public void setRenterReputation(double renterReputation) {
		this.renterReputation = renterReputation;
	}
	@Override
	public String toString() {
		return "Personal [personalId=" + personalId + ", personalName=" + personalName + ", personalRealName="
				+ personalRealName + ", personalPhone=" + personalPhone + ", personalIdCard=" + personalIdCard
				+ ", personalAddress=" + personalAddress + ", personalJob=" + personalJob + ", tenantReputation="
				+ tenantReputation + ", renterReputation=" + renterReputation + "]";
	}
	
}
