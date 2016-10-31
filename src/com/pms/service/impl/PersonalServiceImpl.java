package com.pms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.Complain;
import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
import com.pms.mapper.ComplainMapper;
import com.pms.mapper.ParkingMapper;
import com.pms.mapper.ParkingMessageMapper;
import com.pms.mapper.PersonalMapper;
import com.pms.mapper.RentLogMapper;
import com.pms.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService{
	@Resource(name="personalMapper")
    private PersonalMapper personalMapper;
	@Resource(name="parkingMessageMapper")
	private ParkingMessageMapper parkingMessageMapper;
	@Resource(name="parkingMapper")
	private ParkingMapper parkingMapper;
	@Resource(name="rentLogMapper")
	private RentLogMapper rentLogMapper;
	@Resource(name="complainMapper")
	private ComplainMapper complainMapper;
	@Override
	public Personal personalLogin(int userId) {
		return personalMapper.findPersonlByUserId(userId);
	}

	@Override
	public int updatePersonal(Personal personal) {
		return personalMapper.updatePersonal(personal);
	}

	@Override
	public List<Parking> getmyParking(int page, Personal personal) {
		int page1=(page-1)*ROW;
		return parkingMapper.findParkingByPersonId(page1, ROW, personal.getPersonalId());
	}

	@Override
	public int getmyParkingPage(Personal personal) {
		int i=parkingMapper.ParkingPageNumberByPersonId(personal.getPersonalId());
		return i%ROW==0?i/ROW:(i/ROW)+1;
	}

	@Override
	public int addParking(Parking parking) {
		return parkingMapper.addParking(parking);
	}

	@Override
	public int addParkingMessage(ParkingMessage parkingMessage) {
		return parkingMessageMapper.addParkingMessage(parkingMessage);
	}

	@Override
	public List<ParkingMessage> getMyParkingMessage(Personal personal, int page) {
		Date date=new Date();
		int start=(page-1)*ROW;
		
	
		return parkingMessageMapper.findParkingMsgByPersonal(start, ROW,personal.getPersonalId(), date);

	}

	@Override
	public int getMyParkingMessagePage(Personal personal) {
		Date date=new Date();
		int i=parkingMessageMapper.ParkingMsgPageNumber(personal.getPersonalId(), date);
		return i%ROW==0?i/ROW:(i/ROW)+1;
	}

	@Override
	public List<RentLog> getMyRentlogByParkingMessage(ParkingMessage parkingMessage, int page) {
		int page1=(page-1)*ROW;
		return rentLogMapper.findRentLogByParkingMessageId(page1, ROW,parkingMessage.getParkingMsgId());
	}

	@Override
	public int getMyRentlogByParkingMessagePage(ParkingMessage parkingMessage) {
		int page =  rentLogMapper.rentLogPageNum(parkingMessage.getParkingMsgId());
		return page%ROW==0?page/ROW:(page/ROW)+1; 
	}

	@Override
	public int getDealWhitRentlog(RentLog rentlog) {
		return rentLogMapper.updateRentLog(rentlog); 
	}

	@Override
	public List<ParkingMessage> getMyDealOutParkingMessage(Personal personal, int page) {
		int start=(page-1)*ROW;
		return parkingMessageMapper.findParkingMessageByTentPersonId(personal.getPersonalId(), start, ROW);
	}

	@Override
	public int getMyDealOutParkingMessagePage(Personal personal) {
		int page =  parkingMessageMapper.findParkingMessageByTentPersonIdPage(personal.getPersonalId());
		return page%ROW==0?page/ROW:(page/ROW)+1; 
		}

	@Override
	public List<ParkingMessage> getMyDealInParkingMessage(Personal personal, int page) {
		int page1=(page-1)*ROW;
		return parkingMessageMapper.findParkingMessageByPersonId(page1, ROW, personal.getPersonalId(), 1);
	}

	@Override
	public int getMyDealInParkingMessagePage(Personal personal) {
		int page =parkingMessageMapper.ParkingMesPageNumber(personal.getPersonalId(), 1);
		return page%ROW==0?page/ROW:(page/ROW)+1;
	}

	@Override
	public int addComplain(Complain complain) {                                                                                                                                                                                                                                                                          
		return complainMapper.addComplain(complain);
	}

	@Override
	public List<ParkingMessage> findParkingMessageTopark(Date start, Date end, int page) {
		int page1=(page-1)*ROW;
		return 	parkingMessageMapper.findParkingMessageByTime(page1,ROW , start, end);
	}

	public int findParkingMessageToparkPage(Date start,Date end) {
		int page=parkingMessageMapper.ParkingMessagePageNumber(start, end);
		return page%ROW==0?page/ROW:(page/ROW)+1;
	}

	@Override
	public int orderAparkingMessage(RentLog rentlog) {
		return rentLogMapper.addRentLog(rentlog);
	}
	@Override
	public  List<ParkingMessage> findRentParkingMessage(int page){	
		int page1=(page-1)*ROW;
		return parkingMessageMapper.findRentParkingMessage(page1,ROW);
	}
	@Override
	public int findRentParkingMessagePage(){
		int page=parkingMessageMapper.findRentParkingMessagePage();
		return page%ROW==0?page/ROW:(page/ROW)+1;	
	}

	@Override
	public int delParking(int parkingId) {
		return parkingMapper.delParking(parkingId);
	}

}
