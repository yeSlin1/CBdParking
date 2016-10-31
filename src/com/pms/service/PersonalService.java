package com.pms.service;

import java.util.Date;
import java.util.List;

import com.pms.bean.Complain;
import com.pms.bean.Parking;
import com.pms.bean.ParkingMessage;
import com.pms.bean.Personal;
import com.pms.bean.RentLog;
/*
 * 这个service主要是负责个人用户的业务其中包含个人用户资料维护，
 * 以及个人用户出租，求租车位从头至尾流程中需要对数据库进行的增删改查及验证等操作，
 * 
 */
public interface PersonalService {
	public static final int ROW=5;
	/**
	 * 使用已经登录的userId来找到对应的个人用户对象，用于存储到前端的session中维持访问状态
	 * @param userId 成功登录的userId
	 * @return 此userId对应的Personal对象
	 */
	public Personal personalLogin(int userId);
	
	/**
	 * 修改一个personal的信息，用于注册登录后完善以及更新信息使用，注意数据合法性检测
	 * @param personal
	 * @return 是否更改成功 成功1 失败0
	 */
	public int updatePersonal(Personal personal);
	
	/**
	 * 或者指定页码的属于当前personal的一页Parking数据
	 * @param page 选中要显示的页码
	 * @param personal 当前登录的个人用户
	 * @return 指定页码的List<Parking>
	 */
	public List<Parking> getmyParking(int page,Personal personal);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int getmyParkingPage(Personal personal);
	
	/**
	 * 个人增加我的车位
	 * @param parking 要加入的车位信息，注意此车位信息中包含一个Personal对象，
	 * 用于插入数据库时建立联系，
	 * @return 是否更改成功 成功1 失败0
	 */
	public int addParking(Parking parking);
	public int delParking(int id);
	
	/**
	 * 个人发布一条parkingMessage，需注意要发布的parkingMessage是否与已发布的parkingMessage有冲突，
	 * 主要是同一个车位在同一时间发布多次的情况，如有冲突则不允许添加 （注意！parking实体类中缺少List<parkingMessage>需改进）
	 * @param parkingMessage 要发布的parkingMessage 里面包含一个parking对象，用于插入数据库时得到外键
	 * @return 是否更改成功 成功1 失败0
	 */
	public int addParkingMessage(ParkingMessage parkingMessage);
	
	/**
	 * 查询登录用户发布的当前有效的parkingMessage列表，当前有效指当前时间在结束时间之前。
	 * @param personal 此时登录的用户
	 * 	@param page 选中要显示的页码
	 * @return 登录用户发布的当前有效的parkingMessage列表，注意有时间限制
	 */
	public List<ParkingMessage> getMyParkingMessage(Personal personal,int page);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int  getMyParkingMessagePage(Personal personal);
	
	/**
	 * 当用户点击上面方法查出的某一条parkingMessage时，找出所有申请这条parkingMessage的Rentlog,无论成交与否
	 * @param parkingMessage 客户选中的一条当前有效的parkingMessage
	 * @param page 选中要显示的页码
	 * @return 申请这条parkingMessage的所有Rentlog，供用户选择一个来成交或者都不成交
	 */
	public List<RentLog> getMyRentlogByParkingMessage(ParkingMessage parkingMessage,int page);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int   getMyRentlogByParkingMessagePage(ParkingMessage parkingMessage);
	

	/**
	 * 更改一条用户指定的rentlog的成交状态变为“1”成交
	 * @param rentlog 要成交的rentlog
	 * @return 是否更改成功 成功1 失败0
	 */
	public int getDealWhitRentlog(RentLog rentlog);
	
	/**
	 * 查询登录用户所有已成功出租的parkingMessage历史记录（作为包租婆）
	 * @param personal 此时登录的用户
	 * @param page 选中要显示的页码 
	 * @return 登录用户所有已成交的parkingMessage历史记录
	 */
	public List<ParkingMessage> getMyDealOutParkingMessage(Personal personal,int page);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int   getMyDealOutParkingMessagePage(Personal personal);
	 
	
	/**
	 * 查询登录用户所有已成功求租到的parkingMessage历史记录（作为求租客）
	 * @param personal 此时登录的用户
	 * @param page 选中要显示的页码
	 * @return 登录用户所有已成交的parkingMessage历史记录
	 */
	public List<ParkingMessage> getMyDealInParkingMessage(Personal personal,int page);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int  getMyDealInParkingMessagePage(Personal personal);
	
	/**
	 * 用户对一条已成交的parkingMessage历史记录进行投诉x
	 * @param parkingMessage 要投诉的那条ParkingMessage 
	 * 投诉的双方一个来自parking的拥有者（包租婆），一个来自于状态为成交的那条RentLog里申请租用停车位的人（抢租客）
	 * @param direction 投诉的方向指示，“1”为包租婆投诉抢租客 “0”为抢租客投诉包租婆
	 * @return 信息插入是否成功，注意成功插入的投诉信息，受理状态应为“未受理”
	 */
	public int addComplain(Complain complain);
	
	/**
	 * 作为求租客，设定了时间范围后查找符合要求的有效停车位信息(设定的时间被ParkingMessage的起始时间包含)
	 * @param start 什么时候开始停车
	 * @param end 需要停到什么时候
	 * 	@param page 选中要显示的页码
	 * @return 符合要求的所有有效(未成交)的停车信息
	 */
	public List<ParkingMessage> findParkingMessageTopark(Date start,Date end,int page);
	/**
	 * 上面方法获取总页数的方法
	 * @param personal
	 * @return 页码总数
	 */
	public int findParkingMessageToparkPage(Date start,Date end);
	
	/**
	 * 预约一个停车位，也就是往RentLog表中插入一条数据，注意外键链接
	 * @param rentlog 包含了求租申请的所有内容
	 * @return 是否更改成功 成功1 失败0
	 */
	public int orderAparkingMessage(RentLog rentlog);
	
	/**
	 * 查询选中页码的出租车位
	 * @return
	 */
	public  List<ParkingMessage> findRentParkingMessage(int page);
	/**
	 * 上面方法的分页
	 * @return
	 */
	public int findRentParkingMessagePage();
	
	
	
	
	
}
