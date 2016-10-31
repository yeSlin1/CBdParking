package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.bean.Manager;
import com.pms.bean.Power;
import com.pms.bean.User;
import com.pms.service.impl.ManagerServiceImpl;
import com.pms.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Resource
	UserServiceImpl userService;
	
	@Resource
	private ManagerServiceImpl managerService;
	HttpSession session;
	
	@RequestMapping(path="/findManagerByUserId",method=RequestMethod.GET)
	public void findManagerByUserId(HttpServletRequest req){
		Manager manager=(Manager) session.getAttribute("manager");
		System.out.println(manager.getUserId());
		List<Power> list=manager.getPower();
		for(Power p:list){
			req.setAttribute("power", p);
		}
		
	}
	/**
	 * 跳转到managet.jsp页面
	 * @param manager
	 * @param req
	 * @param res
	 */
	@RequestMapping("/managers")
	public String manager(Manager  manager,ModelMap model){
	    

		Manager managers = managerService.findManagerByUserId(manager.getManagerId());
		model.addAttribute("manager", managers);
		    
	return "/manager";
	
	}
	/**
	 * 保存
	 * @param manager
	 * @param req
	 * @param res
	 */
	@RequestMapping("/save")
	public String save(Manager  manager ,String password,String complain,String 
			contract,String carport,String user,String managerIds,ModelMap model){
	    
		User users = new User();
		users.setUserName(manager.getManagerName());
		users.setUserPassword(password);
		users.setUserType(4);
		userService.add(users);
		Manager managers = managerService.findManagerByUserId(Integer.valueOf(managerIds));
		manager.setUserId(userService.fingbyName(manager.getManagerName()).getUserId());
		
		model.addAttribute("manager", managers);
		    

		managerService.addManager(manager);
	
	return "/manager";
	
	}
	
	/**
	 * 保存
	 * @param manager
	 * @param req
	 * @param res
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(Manager  manager ,String complain,String 
			contract,String carport,String user,ModelMap model){
		
		try {
			Manager managers = managerService.findManagerByUserId(manager.getManagerId());
			
			managers.setManagerName(manager.getManagerName());
			managers.setManagerPhone(manager.getManagerPhone());
			managers.setManagerNo(manager.getManagerNo());
		
				
			model.addAttribute("manager", managers);
			    

			managerService.updateManager(managers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "1";
		}
	
	
	return "0";
	
	}
	@RequestMapping("/updateManagerInfo")
	public void updateManagerInfo(@RequestBody Manager manager,HttpServletRequest req,HttpServletResponse res){
		String pwd=req.getParameter("userPassword");
		String newpwd=req.getParameter("newuserPassword");
		if(pwd.equals(newpwd)){
		managerService.updateManagerInfo(manager);
		}
		else{req.setAttribute("msg", "两次密码输入不相同，请重新输入！");}
	}
}
