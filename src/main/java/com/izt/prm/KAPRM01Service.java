package com.izt.prm;


import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.izt.log.KALOG01VO;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.util.SystemInfo;

import org.apache.tomcat.util.codec.binary.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;

/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAPRM01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.01  송아라      최초작성
 * ------------------------------------------------------
 *
 */
@Service
public class KAPRM01Service {
    @Autowired
    KAPRM01DAO KAPRM01DAO;

    // 이전 비밀번호 확인
    public String chkPassword(Map<String,Object> param){
        System.out.println("서비스에서 : " + param);
        // String id = (String)param.get("user_pw");
        String pw = KAPRM01DAO.getPassword((String)param.get("user_id")); //이전 비밀번호
        boolean checkPw = BCrypt.checkpw((String)param.get("user_pw"), pw); 
        if(checkPw){ 
           updatePassword(param); //true일 경우 비밀번호 변경
           return "비밀번호 변경 성공";
       }
       return "이전 비밀번호 확인"; //false일 경우 비밀번호 확인 alert
    }
    
    //비밀번호 변경
    public void updatePassword(Map<String,Object> param){
     String update_pw = BCrypt.hashpw((String)param.get("update_pw"), BCrypt.gensalt()); // 변경 비밀번호를 DB에 암호화하여 저장 
     param.put("update_pw", update_pw); //key(update_pw)에대한 value를 암호화된 비밀번호로 바꿈
     
     KAPRM01DAO.updatedPassword(param);
    }
    
    //파일 base64 encoding -> db에 저장
    public String fileUpload(KAPRM01DTO KAPRM01DTO){
        System.out.println("fileUpload서비스도착");
        String base64Image =  base64Encoding(KAPRM01DTO.getProfile_image());
        KAPRM01DTO.setBase64_image(base64Image);

        KAPRM01DAO.insertProfileImage(KAPRM01DTO);
        return KAPRM01DTO.getBase64_image();
    }

    //base64 encoding
    public String base64Encoding(MultipartFile image){
     
     String fileString = new String();
     InputStream inputStream =  null;
     ByteArrayOutputStream byteOutStream = null;

    try {
    inputStream = new BufferedInputStream(image.getInputStream());
	byteOutStream = new ByteArrayOutputStream();
	int len = 0;
    byte[] buf = new byte[1024];
    
        while ((len = inputStream.read(buf)) != -1) {
             byteOutStream.write(buf, 0, len);
        }

        byte[] fileArray = byteOutStream.toByteArray();
        fileString = new String(Base64.encodeBase64(fileArray));

     }catch (IOException e) {
        e.printStackTrace();
    }finally {

    }
    return fileString;
    }

    //프로필 수정
    public ResponseEntity updateProfile(KALOG01VO KALOG01VO){
        int rst = KAPRM01DAO.updateProfile(KALOG01VO);
        String msg = "";
        if(rst > 0){
            //성공
            msg = "프로필 수정 성공";
            return new ResponseEntity<>(msg, HttpStatus.valueOf(200));
        }else{
            //실패
            msg = "프로필 수정 실패";
            return new ResponseEntity<>(msg, HttpStatus.valueOf(405));
        }
    }

    //프로필 조회
    public String selectProfile(String user_id){
        System.out.println("selectProfile 서비스 도착");
        String image = KAPRM01DAO.selectProfile(user_id);
        return image;
    }

    //사용자 별 지식 포인트 조회
    public List<KAPRM01VO> selectMonthPoint(KAPRM02DTO KAPRM02DTO){
        System.out.println("selectMonthPoint 서비스 도착");
        List<KAPRM01VO> list = KAPRM01DAO.selectMonthPoint(KAPRM02DTO);
        return list;
    }
    //사용자 총 누적 지식 포인트 조회 & 이번달 총 누적 지식 포인트 조회
    public KAPRM02DTO selectTotalPoint(String user_id, String month){
        KAPRM02DTO KAPRM02DTO = new KAPRM02DTO();
        KAPRM02DTO.setUser_id(user_id);
        KAPRM02DTO.setMonth(month);

        System.out.println("selectTotalPoint 서비스 도착");

        int total_point = KAPRM01DAO.selectTotalPoint(user_id);
        int month_total_point = KAPRM01DAO.selectMonthTotalPoint(KAPRM02DTO);

        KAPRM02DTO.setTotal_point(total_point);
        KAPRM02DTO.setMonth_total_point(month_total_point);

        System.out.println("point 조회는?" + KAPRM02DTO.toString());
        return KAPRM02DTO;
    }
}