package com.pms.bean;

import java.io.Serializable;
import java.util.List;

/*
 * CBD停车位
 */
public class CBDParking implements Serializable {
	private int cbdId;// CBDID
	private String cbdNo;// CBD编号
	private List<Contract> contract;//合约用户
	private Company company;//企业对象
	

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	

	public int getCbdId() {
		return cbdId;
	}

	public void setCbdId(int cbdId) {
		this.cbdId = cbdId;
	}

	public String getCbdNo() {
		return cbdNo;
	}

	public void setCbdNo(String cbdNo) {
		this.cbdNo = cbdNo;
	}

	

	@Override
	public String toString() {
		return "CBDParking [cbdId=" + cbdId + ", cbdNo=" + cbdNo + ", companyId="  + ", contract=" + contract
				+ ", company=" + company + "]";
	}

	
	

}
