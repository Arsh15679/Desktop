package com.support.freshdesksupport.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organisation {
	
	@Id
	private int orgId;
	private String orgName;
	private String orgMobileNo;
	private String orgEmail;
	private String password;
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgMobileNo() {
		return orgMobileNo;
	}
	public void setOrgMobileNo(String orgMobileNo) {
		this.orgMobileNo = orgMobileNo;
	}
	public String getOrgEmail() {
		return orgEmail;
	}
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
