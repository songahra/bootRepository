/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01VO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.knm;

public class KAKNM01VO {
	private String question_id;
	private String requestion_id;
	private String project_id;
	private String answer_id;
	private String reg_userid;
	private String update_userid;
	private String solution_id;
	private String title;
	private String content_q;
	private String content_s;
	private String err_log;
	private String reg_date;
	private String update_date;
	private int score;
	private String status;
	private int hit;
	private String display_yn;
	
	// 조회시 파라미터명
	private String rowNum;
	private String userid;
	private String tag;
	private String reg_userName_tq;
	private String reg_userid_tq;
	private String reg_date_tq;
	private String reg_userName_ta;
	private String reg_userid_ta;
	private String reg_date_ta;
	private String tag_tag;
	private String tag_erc;
	private String tag_ert;
	private String sortType;
	private String term;
	private String solution_name;
	private String flag;

	// 프로젝트 조회
	private String project_name;
	private String customer;
	private String reg_date_st;
	private String reg_date_ed;

	// tag
	private String post_type;
	private String post_id;
	private String tag_type;
	private String tag_value;
	private String tag_id;
	 
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getRequestion_id() {
		return requestion_id;
	}
	public void setRequestion_id(String requestion_id) {
		this.requestion_id = requestion_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
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
	public String getSolution_id() {
		return solution_id;
	}
	public void setSolution_id(String solution_id) {
		this.solution_id = solution_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_q() {
		return content_q;
	}
	public void setContent_q(String content_q) {
		this.content_q = content_q;
	}
	public String getContent_s() {
		return content_s;
	}
	public void setContent_s(String content_s) {
		this.content_s = content_s;
	}
	public String getErr_log() {
		return err_log;
	}
	public void setErr_log(String err_log) {
		this.err_log = err_log;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDisplay_yn() {
		return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
		this.display_yn = display_yn;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getReg_userName_tq() {
		return reg_userName_tq;
	}
	public void setReg_userName_tq(String reg_userName_tq) {
		this.reg_userName_tq = reg_userName_tq;
	}
	public String getReg_userid_tq() {
		return reg_userid_tq;
	}
	public void setReg_userid_tq(String reg_userid_tq) {
		this.reg_userid_tq = reg_userid_tq;
	}
	public String getReg_date_tq() {
		return reg_date_tq;
	}
	public void setReg_date_tq(String reg_date_tq) {
		this.reg_date_tq = reg_date_tq;
	}
	public String getReg_userName_ta() {
		return reg_userName_ta;
	}
	public void setReg_userName_ta(String reg_userName_ta) {
		this.reg_userName_ta = reg_userName_ta;
	}
	public String getReg_userid_ta() {
		return reg_userid_ta;
	}
	public void setReg_userid_ta(String reg_userid_ta) {
		this.reg_userid_ta = reg_userid_ta;
	}
	public String getReg_date_ta() {
		return reg_date_ta;
	}
	public void setReg_date_ta(String reg_date_ta) {
		this.reg_date_ta = reg_date_ta;
	}
	public String getTag_tag() {
		return tag_tag;
	}
	public void setTag_tag(String tag_tag) {
		this.tag_tag = tag_tag;
	}
	public String getTag_erc() {
		return tag_erc;
	}
	public void setTag_erc(String tag_erc) {
		this.tag_erc = tag_erc;
	}
	public String getTag_ert() {
		return tag_ert;
	}
	public void setTag_ert(String tag_ert) {
		this.tag_ert = tag_ert;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getSolution_name() {
		return solution_name;
	}
	public void setSolution_name(String solution_name) {
		this.solution_name = solution_name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
	public String getReg_date_st() {
		return reg_date_st;
	}
	public void setReg_date_st(String reg_date_st) {
		this.reg_date_st = reg_date_st;
	}
	public String getReg_date_ed() {
		return reg_date_ed;
	}
	public void setReg_date_ed(String reg_date_ed) {
		this.reg_date_ed = reg_date_ed;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getTag_type() {
		return tag_type;
	}
	public void setTag_type(String tag_type) {
		this.tag_type = tag_type;
	}
	public String getTag_value() {
		return tag_value;
	}
	public void setTag_value(String tag_value) {
		this.tag_value = tag_value;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	@Override
	public String toString() {
		return "dd [question_id=" + question_id + ", requestion_id=" + requestion_id + ", project_id=" + project_id
				+ ", answer_id=" + answer_id + ", reg_userid=" + reg_userid + ", update_userid=" + update_userid
				+ ", solution_id=" + solution_id + ", title=" + title + ", content_q=" + content_q + ", content_s="
				+ content_s + ", err_log=" + err_log + ", reg_date=" + reg_date + ", update_date=" + update_date
				+ ", score=" + score + ", status=" + status + ", hit=" + hit + ", display_yn=" + display_yn
				+ ", rowNum=" + rowNum + ", userid=" + userid + ", tag=" + tag + ", reg_userName_tq=" + reg_userName_tq
				+ ", reg_userid_tq=" + reg_userid_tq + ", reg_date_tq=" + reg_date_tq + ", reg_userName_ta="
				+ reg_userName_ta + ", reg_userid_ta=" + reg_userid_ta + ", reg_date_ta=" + reg_date_ta + ", tag_tag="
				+ tag_tag + ", tag_erc=" + tag_erc + ", tag_ert=" + tag_ert + ", sortType=" + sortType + ", term="
				+ term + ", solution_name=" + solution_name + ", flag=" + flag + ", project_name=" + project_name
				+ ", customer=" + customer + ", reg_date_st=" + reg_date_st + ", reg_date_ed=" + reg_date_ed
				+ ", post_type=" + post_type + ", post_id=" + post_id + ", tag_type=" + tag_type + ", tag_value="
				+ tag_value + ", tag_id=" + tag_id +"]";
	}
}

