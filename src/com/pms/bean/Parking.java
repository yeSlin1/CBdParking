package com.pms.bean;

import java.io.Serializable;
import java.util.List;

public class Parking implements Serializable{
	//数据库id号
	private  int parkingId; 
	//产权证编号
	private String propertyNo;
	//图片地址
	private String parkingPicture; 
	//车位地址
	private String parkingAddress;
	//停车位编号
	private String parkingNo; 
	//停车位生审批状态<0,1>
	private int parkingType; 
	//关联personal类
	private Personal personal;
	//关联ParkingMessage类
	private List<ParkingMessage> parkingMessage;
	
	public List<ParkingMessage> getParkingMessage() {
		return parkingMessage;
	}
	public void setParkingMessage(List<ParkingMessage> parkingMessage) {
		this.parkingMessage = parkingMessage;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public String getPropertyNo() {
		return propertyNo;
	}
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
	public String getParkingPicture() {
		return parkingPicture;
	}
	public void setParkingPicture(String parkingPicture) {
		this.parkingPicture = parkingPicture;
	}
	public String getParkingAddress() {
		return parkingAddress;
	}
	public void setParkingAddress(String parkingAddress) {
		this.parkingAddress = parkingAddress;
	}
	public String getParkingNo() {
		return parkingNo;
	}
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	public int getParkingType() {
		return parkingType;
	}
	public void setParkingType(int parkingType) {
		this.parkingType = parkingType;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	@Override
	public String toString() {
		return "Parking [parkingId=" + parkingId + ", propertyNo=" + propertyNo + ", parkingPicture=" + parkingPicture
				+ ", parkingAddress=" + parkingAddress + ", parkingNo=" + parkingNo + ", parkingType=" + parkingType
				+ ", personal=" + personal + "]";
	}
	
	

}
