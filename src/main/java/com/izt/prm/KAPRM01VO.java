package com.izt.prm;

public class KAPRM01VO {

	private String reg_date;
	private String code_value;
	private int point_value;
	private String title;
	
	public String getReg_date() {
		return reg_date;
    }
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getCode_value() {
		return code_value;
	}
	public void setCode_value(String code_value) {
		this.code_value = code_value;
	}
	public int getPoint_value() {
		return point_value;
	}
	public void setPoint_value(int point_value) {
		this.point_value = point_value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "KAPRM01VO [reg_date=" + reg_date + ", code_value=" + code_value + ", point_value=" + point_value
				+ ", title=" + title + "]";
	}



}