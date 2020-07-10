package com.izt.prm;

import org.springframework.web.multipart.MultipartFile;

public class KAPRM01DTO {
    private MultipartFile profile_image;
    private String user_id;
    private String base64_image;

    public String getUser_id() {
		return user_id;
    }
    
	public void setUser_id(String user_id) {
		this.user_id = user_id;
    }

    public MultipartFile getProfile_image() {
		return profile_image;
    }
    
	public void setProfile_image(MultipartFile profile_image) {
		this.profile_image = profile_image;
    }
    
    public void setBase64_image(String base64_image) {
		this.base64_image = base64_image;
    }

    public String getBase64_image(){
        return base64_image;
    }
}