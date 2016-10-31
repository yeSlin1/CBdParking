package com.pms.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//合约实体类
public class Contract implements Serializable{

	private int contractId;//合约ID
	private String contractNo;//合约编号
	private String contractPicture;//合约图片地址
	private int contractType;//是否解约状态
	private int contractDirection;//(合约类型<出租合约、租赁合约>)
	private Date contractStart;//合约开始时间
	private Date contractEnd;//合约结束时间
	private Company company;//多对一关系，一个合约对应一个企业用户
	private List<CBDParking> cbdparking;//多对多关系，
	
	
	public List<CBDParking> getCbdParking() {
		return cbdparking;
	}
	public void setCbdParking(List<CBDParking> cbdParking) {
		this.cbdparking = cbdParking;
	}
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractPicture() {
		return contractPicture;
	}
	public void setContractPicture(String contractPicture) {
		this.contractPicture = contractPicture;
	}
	public int getContractType() {
		return contractType;
	}
	public void setContractType(int contractType) {
		this.contractType = contractType;
	}
	public int getContractDirection() {
		return contractDirection;
	}
	public void setContractDirection(int contractDirection) {
		this.contractDirection = contractDirection;
	}
	public Date getContractStart() {
		return contractStart;
	}
	public void setContractStart(Date contractStart) {
		this.contractStart = contractStart;
	}
	public Date getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(Date contractEnd) {
		this.contractEnd = contractEnd;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractNo=" + contractNo + ", contractPicture="
				+ contractPicture + ", contractType=" + contractType + ", contractDirection=" + contractDirection
				+ ", contractStart=" + contractStart + ", contractEnd=" + contractEnd + ", company=" + company
				+ ", cbdparking=" + cbdparking + ", getCbdParking()=" + getCbdParking() + ", getContractId()="
				+ getContractId() + ", getContractNo()=" + getContractNo() + ", getContractPicture()="
				+ getContractPicture() + ", getContractType()=" + getContractType() + ", getContractDirection()="
				+ getContractDirection() + ", getContractStart()=" + getContractStart() + ", getContractEnd()="
				+ getContractEnd() + ", getCompany()=" + getCompany() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
