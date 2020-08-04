/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKND01VO.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 30 신예은 최초작성
 * -------------------------------
 */
package com.izt.knd;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class KAKND01VO {
    private String manual_id;
    private String title;
    private String content;
    private String reg_date;
    private String update_date;
    private String solution;
    private String hit;
    private String display_yn;
    private String reg_userid;
    private String userName;
	private String update_userid;
	private String version;
	private String file;
	private String do_type;
    private MultipartFile[] attachFile; // 저장될 파일
    
	public String getVersion() {
        return version;
	}
	public void setVersion(String version) {
        this.version = version;
	}
	public String getDo_type() {
        return do_type;
	}
	public void setDo_type(String do_type) {
        this.do_type = do_type;
	}
	public String getFile() {
        return file;
	}
	public void setFile(String file) {
        this.file = file;
	}
	public String getUserName() {
        return userName;
	}
	public void setUserName(String userName) {
        this.userName = userName;
	}
	public MultipartFile[] getAttachFile() {
        return attachFile;
    }
    public void setAttachFile(MultipartFile[] attachFile) {
        this.attachFile = attachFile;
    }
	public String getManual_id() {
        return manual_id;
	}
	public void setManual_id(String manual_id) {
        this.manual_id = manual_id;
	}
	public String getTitle() {
        return title;
	}
	public void setTitle(String title) {
        this.title = title;
	}
	public String getContent() {
        return content;
	}
	public void setContent(String content) {
        this.content = content;
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
	public String getSolution() {
        return solution;
	}
	public void setSolution(String solution) {
        this.solution = solution;
	}
	public String getHit() {
        return hit;
	}
	public void setHit(String hit) {
        this.hit = hit;
	}
	public String getDisplay_yn() {
        return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
        this.display_yn = display_yn;
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
	
    @Override
    public String toString() {
        return "Practice [title=" + title + ", content=" + content + ", reg_date=" + reg_date + ", update_date="
                + update_date + ", solution=" + solution + ", hit=" + hit + ", display_yn=" + display_yn
                + ", reg_userid=" + reg_userid + ", update_userid=" + update_userid + "]";
    }
    
}