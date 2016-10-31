package com.pms.bean;

import java.io.Serializable;
import java.util.List;
/**
 * 租赁日志实体类
 * @author Administrator
 *
 */
public class RentLog implements Serializable {

	private int rentLogId;     //租-日志Id
	private String tenantMsg;  //抢租客留言
	private int rentLogType;   //租赁的状态<0,1>
	private ParkingMessage parkingMsg;   //外键链接ParkingMessage
	private Personal personal;   		//外键链接Personal
	
	public int getRentLogId() {
		return rentLogId;
	}
	public void setRentLogId(int rentLogId) {
		this.rentLogId = rentLogId;
	}
	public String getTenantMsg() {
		return tenantMsg;
	}
	public void setTenantMsg(String tenantMsg) {
		this.tenantMsg = tenantMsg;
	}
	public int getRentLogType() {
		return rentLogType;
	}
	public void setRentLogType(int rentLogType) {
		this.rentLogType = rentLogType;
	}
	public ParkingMessage getParkingMsg() {
		return parkingMsg;
	}
	public void setParkingMsg(ParkingMessage parkingMsg) {
		this.parkingMsg = parkingMsg;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}


	
}
