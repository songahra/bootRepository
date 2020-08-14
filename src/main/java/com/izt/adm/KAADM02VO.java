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
public class KAADM02VO {
	// user 정보
	private String user_id;
	private String update_userid;
	private String user_name;
	private String user_pw;
	private String company;
	private String user_type;
	private String solution;
	private String solution_name;
	private String dept;
	private String use_yn;
	private String login_lock;
	private int login_cnt;
	private String update_date;
	private String reg_date;
	
	private String flag;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUpdate_userid() {
		return update_userid;
	}

	public void setUpdate_userid(String update_userid) {
		this.update_userid = update_userid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getSolution_name() {
		return solution_name;
	}

	public void setSolution_name(String solution_name) {
		this.solution_name = solution_name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getLogin_lock() {
		return login_lock;
	}

	public void setLogin_lock(String login_lock) {
		this.login_lock = login_lock;
	}

	public int getLogin_cnt() {
		return login_cnt;
	}

	public void setLogin_cnt(int login_cnt) {
		this.login_cnt = login_cnt;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "uu [user_id=" + user_id + ", update_userid=" + update_userid + ", user_name=" + user_name + ", user_pw="
				+ user_pw + ", company=" + company + ", user_type=" + user_type + ", solution=" + solution
				+ ", solution_name=" + solution_name + ", dept=" + dept + ", use_yn=" + use_yn + ", login_lock="
				+ login_lock + ", login_cnt=" + login_cnt + ", update_date=" + update_date + ", reg_date=" + reg_date
				+ "]";
	}
}