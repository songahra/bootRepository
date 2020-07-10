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

   // update (tb_question)
   private String question_id;
   
   // modify (tb_answer)
   private String display_yn;
   private int hit;

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
	@Override
	public String toString() {
		return "Practice02 [answer_id=" + answer_id + ", reg_userid=" + reg_userid + ", update_userid=" + update_userid
				+ ", reg_date=" + reg_date + ", update_date=" + update_date + ", title=" + title + ", question_id="
				+ question_id + ", display_yn=" + display_yn + ", hit=" + hit + ", status=" + status
				+ ", solution_code=" + solution_code + ", reg_date_tq=" + reg_date_tq + ", reg_date_ta=" + reg_date_ta
				+ ", reg_userid_tq=" + reg_userid_tq + ", reg_userid_ta=" + reg_userid_ta + ", term=" + term + "]";
	}
    
}