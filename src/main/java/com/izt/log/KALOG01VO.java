package com.izt.log;

import org.springframework.web.multipart.MultipartFile;

public class KALOG01VO {

	private String user_id;
	private String user_name;
	private String user_pw;
	private String company;
	private String user_type;
	private String reg_date;
	private String update_date;
	private String update_userid;
	private String login_cnt;
	private String login_lock;
	private String use_yn;
	private MultipartFile profile_image;
	private String solution;
	private String dept;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_userid() {
		return update_userid;
	}
	public void setUpdate_userid(String update_userid) {
		this.update_userid = update_userid;
	}
	public String getLogin_cnt() {
		return login_cnt;
	}
	public void setLogin_cnt(String login_cnt) {
		this.login_cnt = login_cnt;
	}
	public String getLogin_lock() {
		return login_lock;
	}
	public void setLogin_lock(String login_lock) {
		this.login_lock = login_lock;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public MultipartFile getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(MultipartFile profile_image) {
		this.profile_image = profile_image;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return " [user_id=" + user_id + ", user_name=" + user_name + ", user_pw=" + user_pw + ", company="
				+ company + ", user_type=" + user_type + ", reg_date=" + reg_date + ", update_date=" + update_date
				+ ", update_userid=" + update_userid + ", login_cnt=" + login_cnt + ", login_lock=" + login_lock
				+ ", use_yn=" + use_yn + ", profile_image=" + profile_image + ", solution=" + solution + ", dept="
				+ dept + "]";
	}
	 
}
