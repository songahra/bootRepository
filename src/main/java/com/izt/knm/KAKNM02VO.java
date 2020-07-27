/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM02VO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신예은  최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

public class KAKNM02VO {
   // insert (tb_answer)
   private String answer_id;
   private String reg_userid;
   private String update_userid;
   private String reg_date;
   private String update_date;
   private String title;
   private String content_a;
   private String content_b;
   private String content_t;
   private String tag_id;
   private String solution_id;

   // modify question data
   private String solution_name;
   private String project_name;
   private String tag_tag;
   private String tag_erc;
   private String tag_ert;
   private String content_q;

   // detail
   private String dept;
   private String ansName;
   private String upAnsName;
   private String upDept;

   // update (tb_question)
   private String question_id;
   
   // modify (tb_answer)
   private String display_yn;
   private int hit;
   private String do_type;

   // list (tb_question, tb_answer)
   private String status;
   private String solution_code;
   private String reg_date_tq;
   private String reg_date_ta;
   private String reg_userid_tq;
   private String reg_userid_ta;
   private String term;

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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_a() {
		return content_a;
	}
	public void setContent_a(String content_a) {
		this.content_a = content_a;
	}
	public String getContent_b() {
		return content_b;
	}
	public void setContent_b(String content_b) {
		this.content_b = content_b;
	}
	public String getContent_t() {
		return content_t;
	}
	public void setContent_t(String content_t) {
		this.content_t = content_t;
	}
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	public String getSolution_id() {
		return solution_id;
	}
	public void setSolution_id(String solution_id) {
		this.solution_id = solution_id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAnsName() {
		return ansName;
	}
	public void setAnsName(String ansName) {
		this.ansName = ansName;
	}
	public String getUpAnsName() {
		return upAnsName;
	}
	public void setUpAnsName(String upAnsName) {
		this.upAnsName = upAnsName;
	}
	public String getUpDept() {
		return upDept;
	}
	public void setUpDept(String upDept) {
		this.upDept = upDept;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getDisplay_yn() {
		return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
		this.display_yn = display_yn;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDo_type() {
		return do_type;
	}
	public void setDo_type(String do_type) {
		this.do_type = do_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSolution_code() {
		return solution_code;
	}
	public void setSolution_code(String solution_code) {
		this.solution_code = solution_code;
	}
	public String getReg_date_tq() {
		return reg_date_tq;
	}
	public void setReg_date_tq(String reg_date_tq) {
		this.reg_date_tq = reg_date_tq;
	}
	public String getReg_date_ta() {
		return reg_date_ta;
	}
	public void setReg_date_ta(String reg_date_ta) {
		this.reg_date_ta = reg_date_ta;
	}
	public String getReg_userid_tq() {
		return reg_userid_tq;
	}
	public void setReg_userid_tq(String reg_userid_tq) {
		this.reg_userid_tq = reg_userid_tq;
	}
	public String getReg_userid_ta() {
		return reg_userid_ta;
	}
	public void setReg_userid_ta(String reg_userid_ta) {
		this.reg_userid_ta = reg_userid_ta;
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
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public String getContent_q() {
		return content_q;
	}
	public void setContent_q(String content_q) {
		this.content_q = content_q;
	}

	@Override
	public String toString() {
		return "Practice02 [answer_id=" + answer_id + ", reg_userid=" + reg_userid + ", update_userid=" + update_userid
				+ ", reg_date=" + reg_date + ", update_date=" + update_date + ", title=" + title + ", content_a="
				+ content_a + ", content_b=" + content_b + ", content_t=" + content_t + ", tag_id=" + tag_id
				+ ", solution_id=" + solution_id + ", dept=" + dept + ", ansName=" + ansName + ", upAnsName="
				+ upAnsName + ", upDept=" + upDept + ", question_id=" + question_id + ", display_yn=" + display_yn
				+ ", hit=" + hit + ", do_type=" + do_type + ", status=" + status + ", solution_code=" + solution_code
				+ ", reg_date_tq=" + reg_date_tq + ", reg_date_ta=" + reg_date_ta + ", reg_userid_tq=" + reg_userid_tq
				+ ", reg_userid_ta=" + reg_userid_ta + ", term=" + term + ", solution_name=" + solution_name
				+ ", project_name=" + project_name + ", tag_tag=" + tag_tag + ", tag_erc=" + tag_erc + ", tag_ert="
				+ tag_ert + ", content_q=" + content_q + "]";
	}
	
	
	
}