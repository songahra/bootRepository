package com.izt.prm;

public class KAPRM02DTO {
    
	private String user_id;
	private String start_date;
	private String end_date;
	private String month;
	
	private int total_point;
	private int month_total_point;

	
	public int getTotal_point(){
		return total_point;
	}
	public int getMonth_total_point(){
		return month_total_point;
	}

	public void setTotal_point(int total_point){
		this.total_point = total_point;
	}

	public void setMonth_total_point(int month_toal_point){
		this.month_total_point = month_toal_point;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "KAPRM01VO [user_id=" + user_id + ", start_date=" + start_date + ", end_date=" + end_date + ", month="
				+ month + "]";
	}
}