package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.bean.ParkingMessage;
import com.pms.service.ParkingMessageService;

@Controller
@RequestMapping("/parkingMsg")
public class parkingMsgController {

	@Resource
	private ParkingMessageService parkingMessageService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<ParkingMessage>  list(String name,String value){
		List<ParkingMessage> list = parkingMessageService.findlist(); 
		
		return list;
	}
	
}
