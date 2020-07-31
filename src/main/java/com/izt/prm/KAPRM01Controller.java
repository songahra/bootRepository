package com.izt.prm;

import java.util.List;
import java.util.Map;

import com.izt.log.KALOG01VO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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
   public String fileUpload(KAPRM01DTO KAPRM01DTO) {
        System.out.println("upload하러 들어옴.....");
        System.out.println(KAPRM01DTO);

        String base64Image= KAPRM01Service.fileUpload(KAPRM01DTO);
        System.out.println("base64Image" + base64Image);


        return base64Image;
   //   String fileString = new String();
   //   InputStream inputStream =  null;
   //   ByteArrayOutputStream byteOutStream = null;
   //  try {
   // inputStream = new BufferedInputStream(image.getInputStream());
	// byteOutStream = new ByteArrayOutputStream();
	// int len = 0;
	// byte[] buf = new byte[1024];
   //      while ((len = inputStream.read(buf)) != -1) {
   //           byteOutStream.write(buf, 0, len);
   //      }
   //      byte[] fileArray = byteOutStream.toByteArray();
   //      fileString = new String(Base64.encodeBase64(fileArray));

   //   }catch (IOException e) {
   //      e.printStackTrace();
   //  }finally {
   //  }
   //  return fileString;
}//

 //비밀번호 변경
 @PostMapping(value="updatePassword")
 public ResponseEntity updatePassword(@RequestBody Map<String, Object> param){
        String msg = KAPRM01Service.chkPassword(param);

        System.out.println("컨트롤러에서 msg"+ msg);
        return new ResponseEntity<>(msg,  HttpStatus.valueOf(200));

 }

  //프로필 수정
  @PostMapping(value="updateProfile")
  public ResponseEntity updateProfile(@RequestBody KALOG01VO KALOG01VO) {
     System.out.println("updateProfile컨트롤러에서 KALOG01VO" + KALOG01VO);
      
     return KAPRM01Service.updateProfile(KALOG01VO);
   }

   //프로필 조회
   @GetMapping(value="selectProfile")
   public String selectProfile(@RequestParam(value = "user_id") String user_id) {
      System.out.println("user_id" + user_id);
      return KAPRM01Service.selectProfile(user_id);
   }

   //사용자 별 지식 포인트 조회
   @GetMapping(value = "selectMonthPoint")
   public List<KAPRM01VO> selectMonthPoint(@RequestParam(value = "user_id") String user_id,
                                           @RequestParam(value = "start_date") String start_date,
                                           @RequestParam(value = "end_date") String end_date)
   {
      System.out.println("selectMonthPoint컨트롤러" + user_id + start_date + end_date);
      KAPRM02DTO KAPRM02DTO = new KAPRM02DTO();
      KAPRM02DTO.setUser_id(user_id);
      KAPRM02DTO.setStart_date(start_date);
      KAPRM02DTO.setEnd_date(end_date);
      
      System.out.println("KAPRM02DTO.toString()->" + KAPRM02DTO.toString());

      return KAPRM01Service.selectMonthPoint(KAPRM02DTO);
   }
   
   //사용자 총 누적 지식 포인트 조회
   @GetMapping(value="selectTotalPoint")
   public KAPRM02DTO selectTotalPoint(@RequestParam(value = "user_id") String user_id,
                                     @RequestParam(value="month") String month) {
      System.out.println("selectTotalPoint컨트롤러 도착"); 
      System.out.println("값은?");
                                       
      return KAPRM01Service.selectTotalPoint(user_id, month);
   }

   //
   
 }


