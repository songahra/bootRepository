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

@Service
public class KAKNM01Service {
    @Autowired
    private CreateTbIdService createTbIdService;
    
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

    // 상세조회
    public KAKNM01VO getDetail(Map<String, Object> map) {
        System.out.println("KAKNM01Service getDetail");
        return kAKNM01DAO.getDetail(map);
    }

    // 지식관리 질문 등록
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public int write(KAKNM01VO kAKNM01VO) {
       System.out.println("KAKNM01Service write..");
       try {
         // id값생성
         String question_id = createTbIdService.createPkId("QU");
         kAKNM01VO.setQuestion_id(question_id);
         
         // 질문 등록  
         int result = 0;
         result = kAKNM01DAO.insertQuInfo(kAKNM01VO);
 
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
         
         if(tag_erc != null){
             map.put("tag_id",createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_erc());
             System.out.println("tag_erc map1tag_erc???? => " + map);
             
             result = kAKNM01DAO.insertErcTag(map);
             System.out.println("tag_erc의 / " + result);
 
         } 
         if(tag_ert != null){
             map.put("tag_id",createTbIdService.createPkId("TG"));
             map.put("question_id", question_id);
             map.put("tag_value", kAKNM01VO.getTag_ert());
             System.out.println("tag_ert map2???? => " + map);
             
             result = kAKNM01DAO.insertErtTag(map);
             System.out.println("tag_ert의 / "+result);
         }
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
    public List<KAKNM01VO> getPrList() {
        System.out.println("KAKNM01Service getPrList");
        return kAKNM01DAO.getPrList();
    }

    // 지식관리 프로젝트 리스트 조회 화면
    public List<KAKNM01VO> srchPrList(Map<String, Object> map) {
        System.out.println("KAKNM01Service srchPrList");
        return kAKNM01DAO.srchPrList(map);
    }

}
