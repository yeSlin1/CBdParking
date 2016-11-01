package com.pms.bean;

import java.io.Serializable;
import java.util.List;

//企业用户实体类
public class Company  implements Serializable {


	private int companyId;// 企业ID
	private String companyName;// 企业名称
	private String companyAddress;// 企业地址
	private String companyResponsible;// 企业责任人
	private String companyPhone;// 企业电话
	private List<CBDParking>  cbdParking;//一对多关系，企业有多个CBD

	private List<Contract> contract;// 一对多关系，企业里面有多个合约



	public List<CBDParking> getCbdParking() {
		return cbdParking;
	}

	public void setCbdParking(List<CBDParking> cbdParking) {
		this.cbdParking = cbdParking;
	}

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	private int userId;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyResponsible() {
		return companyResponsible;
	}

	public void setCompanyResponsible(String companyResponsible) {
		this.companyResponsible = companyResponsible;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyResponsible=" + companyResponsible + ", companyPhone=" + companyPhone + ", cbdParking="
				+ cbdParking + ", contract=" + contract + ", userId=" + userId + "]";
	}



}
