package com.izt.nti;

import org.springframework.web.multipart.MultipartFile;

public class KANTI01VO {
    private String notice_id;
    private String reg_userid;
    private String update_userid;
    private String solution_code;
    private String title;
    private String content;
    private String reg_date;
    private String update_date;
    private String display_yn;
    private int hit;
    private MultipartFile[] attachFile; // 저장될 파일
    private String post_type;
    private int file_count;
    private String user_name;
    
    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
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

    public String getSolution_code() {
        return solution_code;
    }

    public void setSolution_code(String solution_code) {
        this.solution_code = solution_code;
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

    public MultipartFile[] getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(MultipartFile[] attachFile) {
        this.attachFile = attachFile;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public int getFile_count() {
        return file_count;
    }

    public void setFile_count(int file_count) {
        this.file_count = file_count;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "KANTI01VO [notice_id=" + notice_id + ", reg_userid=" + reg_userid + ", update_userid=" + update_userid
                + ", solution_code=" + solution_code + ", title=" + title + ", content=" + content + ", reg_date="
                + reg_date + ", update_date=" + update_date + ", display_yn=" + display_yn + ", hit=" + hit
                + ", post_type=" + post_type + ", file_count=" + file_count + ", user_name=" + user_name + "]";
    }
}