/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM02VO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.24 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAADM01VO {
	// 프로젝트 조회
	private String project_id;
	private String project_name;
	private String customer;
	private String project_start_date;
	private String project_end_date;
	private String term;
	private String flag;

	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProject_start_date() {
		return project_start_date;
	}
	public void setProject_start_date(String project_start_date) {
		this.project_start_date = project_start_date;
	}
	public String getProject_end_date() {
		return project_end_date;
	}
	public void setProject_end_date(String project_end_date) {
		this.project_end_date = project_end_date;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "cc [project_id=" + project_id + ", project_name=" + project_name + ", customer=" + customer
				+ ", project_start_date=" + project_start_date + ", project_end_date=" + project_end_date + ", term="
				+ term + ", flag=" + flag + "]";
	}
	
}