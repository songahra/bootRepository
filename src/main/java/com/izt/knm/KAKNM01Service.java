/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.Map;

import com.izt.common.CreateTbIdService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izt.common.mail.MailService;
import com.izt.common.mail.EmailMessage;

@Service
public class KAKNM01Service {
    @Autowired
    private CreateTbIdService createTbIdService;
    @Autowired
    private MailService mailService;
    @Autowired
    private KAKNM01DAO kAKNM01DAO;

    // 지식관리 메인화면 리스트조회
    public List<KAKNM01VO> mainList() {
        System.out.println("KAKNM01Service mainList");
        return kAKNM01DAO.getAllList();
    }

    // 지식관리 게시판 조건에 따른 조회
    public List<KAKNM01VO> srchList(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service getList");
        return kAKNM01DAO.srchList(kAKNM01VO);
    }

    // 지식관리 기술문의 질문 id 조회
    public KAKNM01VO srchQuId(String question_id){
        System.out.println("KAKNM01DAO srchQuId called...");
        return kAKNM01DAO.srchQuId(question_id);
    }

    // 상세조회
    public KAKNM01VO getDetail(String question_id) {
        System.out.println("KAKNM01Service getDetail");
        
        kAKNM01DAO.updateQuHite(question_id);
        return kAKNM01DAO.getDetail(question_id);
    }

    // 지식관리 질문 등록
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public int write(KAKNM01VO kAKNM01VO) {
       System.out.println("KAKNM01Service write..");
       try {
         int result = 0;
         String user_id ="";
         String setSubject="";
         String setBody="";
         
         // PK id값생성
         String question_id = createTbIdService.createPkId("QU");
         kAKNM01VO.setQuestion_id(question_id);
         
         // 재질문등록시 원질문 id
         String up_question_id = kAKNM01VO.getUp_question_id();
         String title =kAKNM01VO.getTitle();

         // 질문 등록
         if(up_question_id != ""  || up_question_id.trim() != "" || up_question_id.equals(true)){
            // 재질문등록
            System.out.println("재질문등록일때 => "+ up_question_id);
            // kAKNM01VO.setStatus("RQ");
            kAKNM01DAO.updateQuInfo(kAKNM01VO);
            result = kAKNM01DAO.insertQuInfo(kAKNM01VO);
            
            // 답변자에게 알림메일 발송
            user_id    = kAKNM01VO.getReg_userid_ta();
            System.out.println("재질문등록일때 답변자 이메일=> "+ user_id);
            setSubject = "[솔루션지식자산화시스템] 회원님의 답변에 대해 재질문처리가 되었습니다.";
            setBody    = "안녕하세요. 솔루션지식자산화시스템입니다. <br />" 
                         + "회원님의 답변이 재질문처리가 되었습니다 <br />"
                         + "재질문의 글 제목은 " + title +" 입니다 <br />"
                         + "확인부탁드립니다. 감사합니다.";
            sendMail(setSubject, setBody, user_id)  ;

         } else{
            // 신규등록  
            result = kAKNM01DAO.insertQuInfo(kAKNM01VO);
         }

         // 일반 태그 등록
         String [] tag = spiltTag(kAKNM01VO.getTag_tag());
         System.out.println("tag 수 => "+ tag.length);
 
         for(int i=1; i<tag.length; i++){
             // tag id 생성
             kAKNM01VO.setTag_id(createTbIdService.createPkId("TG"));
             // tag 값 저장
             kAKNM01VO.setTag_value(tag[i]);
             // tag insert
             kAKNM01DAO.insertTag(kAKNM01VO);
         }
 
         // 에러코드 및 예외종류 태그 등록
         String tag_erc = kAKNM01VO.getTag_erc();
         String tag_ert = kAKNM01VO.getTag_ert();
         System.out.println("tag_erc 머니?"+tag_erc);
         if(kAKNM01VO.getTag_ert()!=null){
             System.out.println("<<<<<<tag_ert 머니?>>>>>>>"+tag_ert);
         }
         Map<String,Object> map = new HashMap<String,Object>();
         
         if(tag_erc != "" || tag_erc.trim() != "" || tag_erc.equals(true)){
             map.put("tag_id", createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_erc());
             System.out.println("tag_erc map1tag_erc???? => " + map);
             
             kAKNM01DAO.insertErcTag(map);
             System.out.println("tag_erc의 / " + result);
 
         } 
         if(tag_ert != "" || tag_ert.trim() != "" || tag_ert.equals(true)){
             map.put("tag_id",createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_ert());
             System.out.println("tag_ert map2???? => " + map);
             
             kAKNM01DAO.insertErtTag(map);
             System.out.println("tag_ert의 / "+ result);

         }
         // 질문자에게 알림메일 발송
         user_id    = kAKNM01VO.getUserid();
         setSubject = "[솔루션지식자산화시스템] 회원님의 기술문의가 등록되었습니다.";
         setBody    = "안녕하세요. 솔루션지식자산화시스템입니다. <br />" 
                      + "회원님의 기술문의 등록이 처리 되었습니다 <br />"
                      + "이용해 주셔서 감사합니다";
         System.out.println("질문등록일때 질문자 이메일=> "+ user_id);
         sendMail(setSubject, setBody, user_id);

         return result;

       } catch (Exception e) {
        // log.error("fail to process file", e);
         e.printStackTrace();
         return 0;
       } 
    }
    
    // 태그 자르기
    public String[] spiltTag(String Stag) {
		System.out.println("KAKNM02Service spiltTag Called...!!");
		String t1 = Stag.replaceAll(" ", "");
		String t2 = t1.replaceAll(",", "");
        String [] arr = t2.split("#");
        System.out.println("arr!!!!!!!!!!!!!!"+ arr);
		return arr;
    }
    
    // 메일전송
    public void sendMail(String setSubject, String setBody, String user_id){
        try {
         // 메일 전송
         EmailMessage emailMessage = new EmailMessage();
         emailMessage.setBody(setBody);
         
         emailMessage.setSubject(setSubject);
         emailMessage.setTo_address(user_id); //user 이메일 user_id로 바꿔야함

         mailService.sendmail(emailMessage); //메일 발송  
            
        } catch (Exception e) {
            //TODO: handle exception
          e.printStackTrace();
        }
    }

    // 지식관리 질문 삭제 
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public int delete(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service delete..");
        try {
            System.out.println("지식관리 질문 삭제 kAKNM01VO =>" + kAKNM01VO);
            int result = 0;
            result = kAKNM01DAO.deletetQuInfo(kAKNM01VO); 
            System.out.println("질문+포인트 테이블 삭제 => 결과" + result);
            kAKNM01DAO.deleteTagInfo(kAKNM01VO); 
            System.out.println("테그테이블 삭제 => 결과" + result);
            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("에러발생");
            return 0;
        }
    }

    // 지식관리 질문 수정
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public int modify(KAKNM01VO kAKNM01VO) {
       System.out.println("KAKNM01Service modify..");
       try {
         String question_id = kAKNM01VO.getQuestion_id();
         
         // 질문 수정  
         int result = 0;
         result = kAKNM01DAO.modify(kAKNM01VO);
         System.out.println("질문테이블 결과=>>>" + result);
 
         // 일반 태그 등록
         kAKNM01DAO.deleteTagInfo(kAKNM01VO);

         String [] tag = spiltTag(kAKNM01VO.getTag_tag());
         System.out.println("tag 수 => "+ tag.length);
       
         for(int i=1; i<tag.length; i++){
             // tag id 생성
             kAKNM01VO.setTag_id(createTbIdService.createPkId("TG"));
             // tag 값 저장
             kAKNM01VO.setTag_value(tag[i]);
             // tag insertt
             System.out.println("일반 Tag :::"+ kAKNM01VO.getTag_id());
             kAKNM01DAO.insertTag(kAKNM01VO);
         }
 
         // 에러코드 및 예외종류 태그 등록
         String tag_erc = kAKNM01VO.getTag_erc();
         String tag_ert = kAKNM01VO.getTag_ert();
         
         Map<String,Object> map = new HashMap<String,Object>();
         
         if(!"".equals(tag_erc)||tag_erc != null){
             System.out.println("tag_value ???????????=>" +kAKNM01VO.getTag_erc());
             map.put("tag_id",createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_erc());
             System.out.println("tag_erc map1tag_ert???? => " + map);
             
             result = kAKNM01DAO.insertErcTag(map);
             System.out.println("tag_erc result => " + result);

         } 
         
        if(!"".equals(tag_ert)||tag_ert != null){
            System.out.println("tag_value ???????????=>" +kAKNM01VO.getTag_ert());
             map.put("tag_id",createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_ert());
             System.out.println("tag_ert map2???? => " + map);
             
             result = kAKNM01DAO.insertErtTag(map);
         }

         return result;

       } catch (Exception e) {
         return 0;
       } 
    }

    // 지식관리 기술문의 답변에 대해 평가하기
    public int estimateAn(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service estimateAn");
        String question_id = kAKNM01VO.getQuestion_id();
        int score = kAKNM01VO.getScore();
        String solution_id = kAKNM01VO.getSolution_id();
        String time = kAKNM01VO.getTime();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("question_id", question_id);
        map.put("score", score);
        map.put("solution_id", solution_id);
        map.put("time", time);
        return kAKNM01DAO.estimateAn(map);
    }

    // 지식관리 내가 문의한 질문 메인화면
    public List<KAKNM01VO> getMyList(String userid) {
        System.out.println("KAKNM01Service getMyList");
        return kAKNM01DAO.getMyList(userid);
    
    }

    // 지식관리 내가 문의한 질문 조회화면
    public List<KAKNM01VO> srchMyList(Map<String, Object> map) {
        System.out.println("KAKNM01Service srchMyList");
        return kAKNM01DAO.srchMyList(map);
        
    }

    // 지식관리 프로젝트 리스트 화면
    public List<KAKNM01VO> getPjList() {
        System.out.println("KAKNM01Service getPrList");
        return kAKNM01DAO.getPjList();
    }

    // 지식관리 프로젝트 리스트 조회 화면
    public List<KAKNM01VO> srchPjList(Map<String, Object> map) {
        System.out.println("KAKNM01Service srchPrList");
        return kAKNM01DAO.srchPjList(map);
    }

}
