package com.izt.common.file;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {

    private String post_type; // 게시물 타입
    private String post_id; // 업로드된 게시물의 id
    private String org_file_name; // 원래 파일 이름
    private String save_file_name; // 저장된 파일 이름
    private String file_ext_name; // 파일 확장자
    private String file_size; // 파일 사이즈
	private String file_id; // db에 저장된 파일정보 id
	private String file_path; // 저장된 파일 위치
	private MultipartFile[] attachFile; // 저장될 파일

    public MultipartFile[] getAttachFile() {
		return this.attachFile;
	}
	public void setAttachFile(MultipartFile[] attachFile) {
		this.attachFile = attachFile;
	}
    public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
    public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
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
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getFile_ext_name() {
		return file_ext_name;
	}
	public void setFile_ext_name(String file_ext_name) {
		this.file_ext_name = file_ext_name;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	
	@Override
	public String toString() {
		return "Practice [post_type=" + post_type + ", post_id=" + post_id + ", org_file_name=" + org_file_name
				+ ", save_file_name=" + save_file_name + ", file_ext_name=" + file_ext_name + ", file_size=" + file_size
				+ "]";
	}
	

}