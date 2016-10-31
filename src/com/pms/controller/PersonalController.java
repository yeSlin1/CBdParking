package com.pms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.service.impl.PersonalServiceImpl;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	@Resource
	private PersonalServiceImpl impl;
	HttpSession session;

	@RequestMapping(path = "/changeMsg")
	public String updatePersonal(@RequestBody Personal personal) {
		System.out.println(personal.toString());
		impl.updatePersonal(personal);
		return "/WEB-INF/personal";
	}
	@RequestMapping(path = "/myparking", method = RequestMethod.POST)
	public @ResponseBody List<Parking> getMyParking(String personalId, String button) {
		Personal personal = new Personal();
		int id = Integer.parseInt(personalId);
		int butt = Integer.parseInt(button);
		personal.setPersonalId(id);
		List<Parking> parking = impl.getmyParking(butt, personal);
		return parking;
	}

	@RequestMapping(path="/fenyeparking")
	public@ResponseBody int fenyeparking(String personalId){
		int personid=Integer.parseInt(personalId);
		Personal personal=new Personal();
		personal.setPersonalId(personid);
		return impl.getmyParkingPage(personal);		
	}
	

	@RequestMapping(path="/delmyparking/{parkingId}",method = RequestMethod.GET)
	public String delMyParking(@PathVariable int parkingId){
		impl.delParking(parkingId);
		return "personal";
	}
	

	@RequestMapping(path="/qiangfenyeparking",method=RequestMethod.POST)
	public @ResponseBody int fenyeqiuzuParking(){
		int pagebut=impl.findRentParkingMessagePage();
		System.out.println(pagebut);
		return pagebut;
	}
	@RequestMapping(path="/qiangfenyeparkingxianshi",method=RequestMethod.POST)
	public @ResponseBody List<ParkingMessage> fenyeqiuzuParking(String button){
		int page=Integer.parseInt(button);
		List<ParkingMessage> list =impl.findRentParkingMessage(page);
		return list;	
	}
	
	@RequestMapping(path="/addparking",method=RequestMethod.POST)
	public String addparking(@RequestBody Parking parking){
		System.out.println(parking);
		impl.addParking(parking);
		return "WEB-INF/personal";	
	}
	public void ddd(){
	}

	/*
	 * @RequestMapping(path="/tentfenye",method=RequestMethod.POST)
	 * public@ResponseBody int findTentParkingMessagepage(HttpServletRequest
	 * req){ List<ParkingMessage> list =
	 * impl.getMyDealOutParkingMessage(personal, page); HttpSession
	 * session=req.getSession(); Personal personal = (Personal)
	 * session.getAttribute("personal"); int
	 * count=impl.getMyDealOutParkingMessagePage(personal); return count; }
	 */

	@RequestMapping(path = "/tentJilu", method = RequestMethod.POST)
	public @ResponseBody List<ParkingMessage> findTentParkingMessage(String btnval, HttpServletRequest req) {
		int page = Integer.parseInt(btnval);
		session = req.getSession();
		Personal personal1 = (Personal) session.getAttribute("personal");
		List<ParkingMessage> list = impl.getMyDealOutParkingMessage(personal1, page);
		System.out.println(list.size());
		return list;

	}
}
