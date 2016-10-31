package com.pms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.bean.CBDParking;
import com.pms.bean.Company;
import com.pms.bean.Complain;
import com.pms.bean.Contract;
import com.pms.bean.Manager;
import com.pms.bean.Parking;
import com.pms.bean.Personal;
import com.pms.bean.Power;
import com.pms.bean.User;
import com.pms.mapper.CBDParkingMapper;
import com.pms.mapper.CompanyMapper;
import com.pms.mapper.ComplainMapper;
import com.pms.mapper.ContractMapper;
import com.pms.mapper.ManagerMapper;
import com.pms.mapper.ParkingMapper;
import com.pms.mapper.PersonalMapper;
import com.pms.mapper.UserMapper;
import com.pms.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService{
	private static int row=5;
	@Resource
	private ManagerMapper managerMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private UserMapper userMapper;
	@Resource 
	private ComplainMapper complainMapper;
	@Resource
	private PersonalMapper personalMapper;
	@Resource
	private ParkingMapper parkingMapper;
	@Resource(name="cBDParkingMapper")
	private CBDParkingMapper cbdParingMapper;
	@Resource
	private ContractMapper contractMapper;

	
	@Override
	public int updateManagerInfo(Manager manager) {//更新两个表的数据USER manager
		// TODO Auto-generated method stub
		managerMapper.updateManager(manager);
		User user=new User();
		user.setUserId(manager.getUserId());
		user.setUserName(manager.getUserName());
		user.setUserPassword(manager.getUserPassword());
		user.setUserType(manager.getUserType());
		userMapper.updateUser(user);
		return 0;
		
		
	}

	@Override
	public int addManager(Manager manager) {//需要修改，遍历powerList,
		// TODO Auto-generated method stub		
		managerMapper.addManager(manager);
//		List<Power> powers=manager.getPower();
//		for(Power p:powers){
//			managerMapper.addManagerAndPower(manager.getManagerId(), p.getPowerId());
//		}
		
		
		return 0;
	}

	@Override
	public int delManager(Manager manager) {
		managerMapper.delManagerAndPower(manager.getManagerId());
		managerMapper.delManager(manager.getManagerId());
		return 0;
	}

	@Override
	public int updateManager(Manager manager) {
		managerMapper.updateManager(manager);
		List<Power> powers=manager.getPower();
//		for(Power p:powers){
//			managerMapper.updateMManagerAndPower(manager.getManagerId(), p.getPowerId());
//		}
		return 0;
	}

	@Override
	public List<Manager> getAllManager(int page) {
		// TODO Auto-generated method stub
		
		return managerMapper.findManagerByName((page-1)*row, row, "");
	}

	@Override
	public int getAllManager() {
		// TODO Auto-generated method stub
		int i=managerMapper.findManagerPageNumber("");
		return i%row==0?i/row:(i/row)+1;
	}

	@Override
	public List<Company> getAllCompanyByName(String companyName, int page) {
		// TODO Auto-generated method stub
		return companyMapper.findCompanyByPage((page-1)*row, row, companyName);
	}

	@Override
	public int getAllCompanyByNamePage(String companyName) {
		// TODO Auto-generated method stub
		int i=companyMapper.getCompanyPage(companyName);
		return i%row==0?i/row:(i/row)+1;
	}

	@Override
	public int addCompany(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.addCompany(company);
	}

	@Override
	public int delCompany(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.delCompany(company.getCompanyId());
	}

	
	
	
	
	
	
	
	
	@Override
	public List<Company> getAllCompany() {
		
		return companyMapper.findAllCompany();
	}
									
	@Override
	public List<Parking> parkingToCheck(int page) {//测试通过
		// TODO Auto-generated method stub
		page = (page-1)*row;
		List<Parking> list = parkingMapper.findParkingByParkingType(page, row, 0);//0未通过审核  1通过  2 待审核
		return list;
	}

	@Override
	public int parkingToCheckPage() {//总条数  通过
		// TODO Auto-generated method stub
		int page =  parkingMapper.parkingPageNumber();
		int page1 = page %row;
		if(page1!=0){
			 page1=(page/row)+1;
			return page1;
		}
		return  page/row;
	}

	@Override
	public int checkParking(Parking parking) { //通过
		return parkingMapper.updateParking(parking);
	}
	
	
	public String CDBNum(){  //车位随机产生
		String che[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String che1[]={"1","2","3","4","5","6","7","8","9","0"};
		int num = (int)(Math.random()*che.length);
		int numx = (int)(Math.random()*che.length);
		int numy= (int)(Math.random()*che1.length);
		int numz= (int)(Math.random()*che1.length);
		String cdbNum = che[num]+che[numx]+che1[numy]+che1[numz];
		if(cbdParingMapper.findCBDParkingByNo(cdbNum)!=null){
			return CDBNum();
		}
		return cdbNum;
	}
	@Override
	public int mutilCBDParkingAdd(int companyID, int count) {  //测试通过
		for(int i=0;i<count;i++){
			String num  = CDBNum();

			
			Company company = new Company();
			company.setCompanyId(companyID);
			
			CBDParking cbdParking = new CBDParking();
			cbdParking.setCbdNo(num);
			cbdParking.setCompany(company);
			cbdParingMapper.addCBDParking(cbdParking);
		}
		return 1;
	}

	@Override
	public int signContract(Contract contract) {  //通过
		
		return contractMapper.addContract(contract);
	}

	@Override
	public int renewContract(Contract contract, Date start, Date end,//通过
			String contract_no) {
		contract.setContractStart(start);
		contract.setContractEnd(end);
		contract.setContractNo(contract_no);
		return contractMapper.updateContract(contract);
	}

	@Override
	public int releaseContract(Contract contract) {//解约  通过
		//0合同无效  1 合同有效
		contract.setContractType(0);
		return contractMapper.updateContract(contract);
	}

	@Override
	public List<Complain> getAllUndoComplain(int page) {
		
		return complainMapper.findComplainByType(page, row, 0);
	}

	@Override
	public int getAllUndoComplainPage() {
		int i = complainMapper.pageNum(0);
		return i%row==0?i/row:(i/row)+1;
	}

	@Override//此方法未实现
	public int acceptComplain(Complain complain) {
		complainMapper.updateComplain(complain);
		Personal complainTo = complain.getComplainTo();
//		int toId = complainTo.getPersonalId();
//		Personal per = personalMapper.findPersonalById(toId);
		
		return 0;
	}

	//通过UserId来查找Manager
	@Override
	public Manager findManagerByUserId(int userId) {
		 Manager manager=managerMapper.findManagerByUserId(userId);
		return manager;
	}
	

}
