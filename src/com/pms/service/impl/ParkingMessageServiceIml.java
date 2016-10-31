package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.ParkingMessage;
import com.pms.mapper.ParkingMapper;
import com.pms.mapper.ParkingMessageMapper;
import com.pms.service.ParkingMessageService;

@Service
public class ParkingMessageServiceIml implements ParkingMessageService{

	@Resource
	private ParkingMessageMapper mapper;
	
	@Override
	public ParkingMessage findByid(int id) {
		// TODO Auto-generated method stub
		return mapper.findById(id);
	}

	@Override
	public List<ParkingMessage> findlist() {
		// TODO Auto-generated method stub
		return mapper.getAllParkingMessage();
	}

}
