package com.pms.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Administrator
 *
 */
public class Complain implements Serializable {

	private int complainId;       // 投诉ID
	private Date complainTime;    // 投诉时间
	private String complain;      // 投诉内容
	private int complainType;     // 受理状态<0,1>
	private Personal complainFrom;// 投诉人  外键链接Personal
	private Personal complainTo;  // 被投诉人   外键链接Personal
	private ParkingMessage parkingMessage; //外键链接ParkingMessage

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public Date getComplainTime() {
		return complainTime;
	}

	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public int getComplainType() {
		return complainType;
	}

	public void setComplainType(int complainType) {
		this.complainType = complainType;
	}

	public Personal getComplainFrom() {
		return complainFrom;
	}

	public void setComplainFrom(Personal complainFrom) {
		this.complainFrom = complainFrom;
	}

	public Personal getComplainTo() {
		return complainTo;
	}

	public void setComplainTo(Personal complainTo) {
		this.complainTo = complainTo;
	}

	public ParkingMessage getParkingMessage() {
		return parkingMessage;
	}

	public void setParkingMessage(ParkingMessage parkingMessage) {
		this.parkingMessage = parkingMessage;
	}

}
