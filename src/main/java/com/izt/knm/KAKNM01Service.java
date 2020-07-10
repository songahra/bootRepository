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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // 지식관리 질문 등록
    public int write(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service write..");
        
        // id값생성
        String question_id = createTbIdService.createPkId("QU");
        kAKNM01VO.setQuestion_id(question_id);
        System.out.println("kAKNM01VO.setQuestion_id(question_id) =>> " + kAKNM01VO.getQuestion_id());
        
        // String tag= kAKNM01VO.getTag_tag();
        kAKNM01VO.setTag_value(kAKNM01VO.getTag_tag());

        int result = 0;
        result = kAKNM01DAO.insertQuInfo(kAKNM01VO);

        
        System.out.println("result ? " + result);
        
        // if (result != 0 ){
        
        //     // String question_id =kAKNM01VO.getQuestion_id(); // insert한 테이블의 pk값 가져오기
        //     question_id = kAKNM01DAO.srchQuId(question_id);
        //     kAKNM01VO.setPost_id(question_id); // tag테이블의 fk인 post_id에 question_id 넣어서  vo에 담음

        //     if(tag > 1){
        //         System.out.println("question_id"+ question_id);
        //         // 태그가 여러개일때 쪼개서 vo에 담는 행위 -> 아직 구현 전임
                 
        //         // tag = tag.replaceAll("#",'')
        //         String[] array = tag.split("# ");
        
        //         for (int i = 0; i < array.length; i++) { 
        //             System.out.println(array[i]);    
        //             kAKNM01DAO.insertTag(kAKNM01VO);
        //     }
        // } 
            
            return result;
        
    }

    // 지식관리 질문 삭제 
    public int delete(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service delete..");
         
        return kAKNM01DAO.delete(kAKNM01VO);
    }

    // 지식관리 질문 수정
    public int modify(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service modify..");

        return kAKNM01DAO.modify(kAKNM01VO);
    }

    // 지식관리 내가 문의한 질문 메인화면
    public List<KAKNM01VO> getMyList(String userid) {
        System.out.println("KAKNM01Service getMyList");
        return kAKNM01DAO.getMyList(userid);
    
    }

    // 지식관리 내가 문의한 질문 메인화면
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
