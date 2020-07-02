package com.izt.prm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.izt.log.KALOG01VO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

 @RestController
 @RequestMapping("/api/prm")
 public class KAPRM01Controller {

   @Autowired
   KAPRM01Service KAPRM01Service;
    
   @PostMapping(value="upload")
   public String fileUpload(@RequestParam(value="image") MultipartFile image) {
        System.out.println("upload하러 들어옴.....");
        System.out.println(image);

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
}//

 //비밀번호 변경
 @PostMapping(value="updatePassword")
 public ResponseEntity updatePassword(@RequestBody KALOG01VO KALOG01VO){
        System.out.println("updatePassword 컨트롤러 도착");
        KAPRM01Service.updatePassword(KALOG01VO);
        return new ResponseEntity<>("비밀번호 변경 성공",  HttpStatus.valueOf(200));
    
 }
 }


