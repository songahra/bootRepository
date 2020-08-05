/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM03VO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.30 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAADM03VO {
	// code 정보
	private String userid;
	private String code_name;
	private String code_id;
	private String code_type;
	private String code_value;
	private String code_content;
	private String code_explain;
	private String code_up_id;
	private int code_order;
	private String code_display_yn;
	private String reg_date;
	private String update_date;
	private String reg_userid;
	private String update_userid;
	private String flag;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public String getCode_id() {
		return code_id;
	}
	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}
	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getCode_value() {
		return code_value;
	}
	public void setCode_value(String code_value) {
		this.code_value = code_value;
	}
	public String getCode_content() {
		return code_content;
	}
	public void setCode_content(String code_content) {
		this.code_content = code_content;
	}
	public String getCode_explain() {
		return code_explain;
	}
	public void setCode_explain(String code_explain) {
		this.code_explain = code_explain;
	}
	public String getCode_up_id() {
		return code_up_id;
	}
	public void setCode_up_id(String code_up_id) {
		this.code_up_id = code_up_id;
	}
	public int getCode_order() {
		return code_order;
	}
	public void setCode_order(int code_order) {
		this.code_order = code_order;
	}
	public String getCode_display_yn() {
		return code_display_yn;
	}
	public void setCode_display_yn(String code_display_yn) {
		this.code_display_yn = code_display_yn;
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
	public String getReg_userid() {
		return reg_userid;
	}
	public void setReg_userid(String reg_userid) {
		this.reg_userid = reg_userid;
	}
	public String getUpdate_userid() {
		return update_userid;
	}
	public void setUpdate_userid(String update_userid) {
		this.update_userid = update_userid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "cc [userid=" + userid + ", code_name=" + code_name + ", code_id=" + code_id + ", code_type=" + code_type
				+ ", code_value=" + code_value + ", code_content=" + code_content + ", code_explain=" + code_explain
				+ ", code_up_id=" + code_up_id + ", code_order=" + code_order + ", code_display_yn=" + code_display_yn
				+ ", reg_date=" + reg_date + ", update_date=" + update_date + ", reg_userid=" + reg_userid
				+ ", update_userid=" + update_userid + ", flag=" + flag + "]";
	}
	
}