package com.pms.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pms.bean.Company;
import com.pms.bean.Complain;
import com.pms.bean.Contract;
import com.pms.bean.Manager;
import com.pms.bean.Parking;

/*
 * 这个service主要是负责操作员用户的业务
 * 包括 修改个人信息 企业用户的增删查，以及与企业的双向合约的生成，CBDParking的批量生成，
 * 个人车位的审批，投诉的受理
 * 对于超级管理员来说，还拥有对其他管理员的增删改查
 * 
 */
public interface ManagerService {
	/**
	 * 这个方法用于操作员修改自己的基础信息，密码，电话号码等
	 * @param manager
	 * @return 成功与否 1成功  0失败
	 */
	public int updateManagerInfo(Manager manager);
	
	/**
	 * 超级操作员新增一个操作员，注意不止是往操作员表中插入一条数据，同时还要往操作员_权限表中给这个操作员权限
	 * @param manager
	 * @return 成功与否 1成功  0失败
	 */
	public int addManager(Manager manager);
	
	/**
	 * 超级操作员删除一个操作员，注意不止是往操作员表中删除一条数据，同时还要在操作员_权限表中将这个操作员的权限删除
	 * @param manager
	 * @return 成功与否 1成功  0失败
	 */
	public int delManager(Manager manager);
	
	/**
	 * 超级操作员修改一个操作员，注意不止是修改操作员表中一条数据，同时还有可能要修改操作员_权限表中的权限数据
	 * @param manager
	 * @return 成功与否 1成功  0失败
	 */
	public int updateManager(Manager manager);
	
	/**
	 * 获取到当前页码的对应管理员列表数据
	 * @param page
	 * @return 指定页码的管理员列表
	 */
	public List<Manager> getAllManager(int page);
	
	/**
	 * 获取上面这个方法的所有页码的方法
	 * @return 总共有多少页数据
	 */
	public int getAllManager();
	
	/**
	 * 获取到指定页码，指定模糊企业名查询的所有企业用户列表
	 * @param companyName  需要模糊查询的企业名
	 * @param page 指定的页码
	 * @return 符合查询条件和页码的企业列表
	 */
	public List<Company> getAllCompanyByName(String companyName,int page);
	
	/**
	 * 获取上面这个方法的总页码数的方法
	 * @param companyName 模糊查询的企业名
	 * @return 总共有多少页数据
	 */
	public int getAllCompanyByNamePage(String companyName);
	
	/**
	 * 新增一个企业用户
	 * @param company 要新增的企业用户
	 * @return 成功与否 1成功 0失败
	 */
	public int addCompany(Company company);
	
	/**
	 * 删除一个企业用户
	 * @param company 要删除的企业用户
	 * @return 成功与否 1成功 0失败
	 */
	public int delCompany(Company company);
	
	
	
	
	/**
	 * 获取到所有的企业用户列表，供签订合同时的企业下拉菜单用
	 * @return 所有企业用户
	 */
	public List<Company> getAllCompany();
	
	/**
	 * 用户得到所有待审核的个人停车位列表（分页）
	 * @param page 指定页码
	 * @return 指定页码的待审核停车位列表
	 */
	public List<Parking> parkingToCheck(int page);
	
	/**
	 * 获取上面这个方法的页码的方法
	 * @return 总共有多少页数据
	 */
	public int parkingToCheckPage();
	
	/**
	 * 审核操作，将待审核的Parking对象的状态更新为通过审核或者未通过审核（未审核）
	 * @param parking
	 * @return 更新成功与否 1成功 0失败
	 */
	public int checkParking(Parking parking);
	
	/**
	 * 批量添加CBD停车位 注意数据库中的no字段即停车位编码。所属公司英文缩写加数字编号组成
	 * @param company 停车位所属公司ID
	 * @param count 批量生成的个数
	 * @return 影响的数据库行数
	 */
	public int mutilCBDParkingAdd(int companyID,int count);
	
	/**
	 * 新增一个合约（有可能是向企业租车位，也有可能是租车位给企业，用contract里的contractDirection来判断合约的方向）
	 * @param contract 要增加的合约
	 * @return 成功与否 1成功 0失败
	 */
	public int signContract(Contract contract);
	
	/**
	 * 续签合约，保持原合约内容不变，新增一个合约，变化的内容有合约起始时间以及合同编号
	 * @param contract 老合约
	 * @param start  新合约的开始时间
	 * @param end 新合约的结束时间
	 * @param contract_no 新合约的合同编号
	 * @return 成功与否 1成功 0失败
	 */
	public int renewContract(Contract contract,Date start,Date end,String contract_no);
	
	/**
	 * 解约，将指定合约的contract_Type更新为解约状态，（思考。1合同到期自动解约，2合同快到期提醒续约如何实现）
	 * @param contract 要解约的合约
	 * @return 成功与否 1成功 0失败
	 */
	public int releaseContract(Contract contract);
	
	/**
	 * 获取到所有未处理的投诉 ，分页
	 * @param page 指定页面
	 * @return 指定页面的未处理投诉
	 */
	public List<Complain> getAllUndoComplain(int page);
	/**
	 * 获取上面的方法的总页数
	 * @return 一共有多少页未处理投诉
	 */
	public int  getAllUndoComplainPage();
	/**
	 * 受理一个投诉，也就是更改这个投诉的状态为已受理，
	 * 同时注意不光是更改投诉表的数据，关联个人用户的信誉度需要即时更新
	 * 被投诉并受理次数除以总成交订单数的百分比即是个人用户的信誉度
	 * @param complain 要受理的投诉
	 * @return 是否受理成功
	 */
	public int acceptComplain(Complain complain);
	
	/**
	 * 通过UserId来查找Manager
	 * @param userId
	 * @return
	 */
	
	public Manager findManagerByUserId(int userId);
}
