/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAKNM01DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kAKNM01.";
    
    // 지식관리 기술문의 메인 리스트 조회
    public List<KAKNM01VO> getAllList(){
        System.out.println("KAKNM01DAO getAllList called...");
        return sqlSession.selectList(mapperNameSpace+"getAllList");
    }
    
    // 지식관리 기술문의 리스트 조회
    public List<KAKNM01VO> srchList(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO getList called...");
        return sqlSession.selectList(mapperNameSpace+"srchList", kAKNM01VO);
    }

    // 지식관리 질문상세보기
    public KAKNM01VO getDetail(Map<String, Object> map){
        System.out.println("KAKNM01DAO getList called...");
        return sqlSession.selectOne(mapperNameSpace+"getDetail", map);
    }     

    // 지식관리 기술문의 질문 id 조회
    public String srchQuId(String question_id){
        System.out.println("KAKNM01DAO srchQuId called...");
        return sqlSession.selectOne(mapperNameSpace+"srchQuId", question_id);
    }

    // 지식관리 기술문의 등록 
    public int insertQuInfo(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO write called...");
        return sqlSession.insert(mapperNameSpace+"insertQuInfo", kAKNM01VO);
    }

    // 지식관리 기술문의 일반태그 등록 
    public int insertTag(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO insertTag called...");
        return sqlSession.insert(mapperNameSpace+"insertTag", kAKNM01VO);
    }

    // 지식관리 기술문의 에러태그 등록 
    public int insertErcTag(Map<String, Object> map){
        System.out.println("KAKNM01DAO insertErcTag called...");
        return sqlSession.insert(mapperNameSpace+"insertErcTag", map);
    }

    // 지식관리 기술문의 예외종류태그 등록 
    public int insertErtTag(Map<String, Object> map){
        System.out.println("KAKNM01DAO insertErtTag called...");
        return sqlSession.insert(mapperNameSpace+"insertErtTag", map);
    }

    // 지식관리 기술문의 삭제
    public int deletetQuInfo(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO deletetQuInfo called...");
        return sqlSession.insert(mapperNameSpace+"deletetQuInfo", kAKNM01VO);
    }

    // 지식관리 기술문의 태그 삭제 
    public void deleteTagInfo(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO deleteTagInfo called...");
        sqlSession.delete(mapperNameSpace+"deleteTagInfo", kAKNM01VO);
    }

    // 지식관리 기술문의 수정
    public int modify(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01DAO moify called...");
        return sqlSession.update(mapperNameSpace+"updateQuInfo", kAKNM01VO);
    }

    // 지식관리 내가 문의한 질문 리스트 조회
    public List<KAKNM01VO> getMyList(String userid){
        System.out.println("KAKNM01DAO srchMyList");
        return  sqlSession.selectList(mapperNameSpace+"getMyList", userid);
    }

    // 지식관리 내가 문의한 질문 리스트 조건 조회
    public List<KAKNM01VO> srchMyList(Map<String,Object> map){
        System.out.println("KAKNM01DAO srchMyList");
        return  sqlSession.selectList(mapperNameSpace+"srchMyList", map);
    }

    // 지식관리 프로젝트 팝업 리스트 조회
    public List<KAKNM01VO> getPrList(){
        System.out.println("KAKNM01DAO getPrList");
        return sqlSession.selectList(mapperNameSpace+"getPrList");
    }
        
    // 지식관리 프로젝트 팝업 리스트 조건조회
    public List<KAKNM01VO> srchPrList(Map<String,Object> map){
        System.out.println("KAKNM01DAO srchPrList");
        return  sqlSession.selectList(mapperNameSpace+"srchPrList", map);
    }
}