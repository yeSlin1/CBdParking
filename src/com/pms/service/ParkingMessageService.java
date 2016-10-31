package com.pms.service;

import java.util.List;

import com.pms.bean.ParkingMessage;

public interface ParkingMessageService {
/**
 * 通过id找
 */
public 	ParkingMessage findByid(int id);

/**
 * 查找全部
 * @return
 */
public List<ParkingMessage> findlist();
	
}
