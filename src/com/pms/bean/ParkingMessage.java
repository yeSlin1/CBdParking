package com.pms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 发布的租车信息Bean
 * @author suisuinian
 *
 */
public class ParkingMessage implements Serializable{
          private int parkingMsgId;//发布的租车信息ID
          private Date startTime;//开始时间
          private Date endTime;//结束时间
          private BigDecimal price;//价格
          private Parking parking;//外键 连接个人停车位
          private List<RentLog> rentLogs; //外键 连接租车日志
          //无参构造函数
		public ParkingMessage() {
			super();
      		}
		//带参构造函数
	
		public ParkingMessage(int parkingMsgId, Date startTime, Date endTime, BigDecimal price, Parking parking,
				List<RentLog> rentLogs) {
			super();
			this.parkingMsgId = parkingMsgId;
			this.startTime = startTime;
			this.endTime = endTime;
			this.price = price;
			this.parking = parking;
			this.rentLogs = rentLogs;
		}

		public int getParkingMsgId() {
			return parkingMsgId;
		}
		
		public void setParkingMsgId(int parkingMsgId) {
			this.parkingMsgId = parkingMsgId;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public Parking getParking() {
			return parking;
		}

		public void setParking(Parking parking) {
			this.parking = parking;
		}
        
		
		public List<RentLog> getRentLogs() {
			return rentLogs;
		}



		public void setRentLogs(List<RentLog> rentLogs) {
			this.rentLogs = rentLogs;
		}


     //toString 方法
		@Override
		public String toString() {
			return "ParkingMessage [parkingMsgId=" + parkingMsgId + ", startTime=" + startTime + ", endTime=" + endTime
					+ ", price=" + price + ", parking=" + parking + ", rentLogs=" + rentLogs + "]";
		}
	
		
          
}
