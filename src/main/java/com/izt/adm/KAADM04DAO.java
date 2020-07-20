/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM04DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.24  신예은   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAADM04DAO {
    @Autowired
    SqlSession sqlSession;
    // 솔루션 지식포인트 조회
    public List<KAADM04VO> getSolList(String sDate, String eDate) {
        System.out.println("KAADM04DAO.GETSOLLIST CALLED...");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sDate", sDate);
        map.put("eDate", eDate);
        return sqlSession.selectList("KAADM04.getSolList", map);
    }
    // 사용자 지식포인트 조회
    public List<KAADM04VO> getUserList(String sDate, String eDate) {
        System.out.println("KAADM04DAO.GETUSERLIST CALLED...");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sDate", sDate);
        map.put("eDate", eDate);
        return sqlSession.selectList("KAADM04.getUserList", map);
    }

    // 솔루션별 지식포인트 조회
    // 질문, 답변, 미해결 기준으로 조회
	public List<KAADM04VO> getPointSearchListSol(String sol, String type, String sDate, String eDate) {
        System.out.println("KAADM04DAO.getPointSearchListSol Called...");
        System.out.println("type" + type);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sol", sol);
        map.put("sDate", sDate);
        map.put("eDate", eDate);
        System.out.println("map " + map);
        
        if(type.equals("answer")){
            // 솔루션별 답변조회
            return sqlSession.selectList("KAADM04.getPointSearchSolA", map);
        }else if(type.equals("question")){
            // 솔루션별 질문조회
            return sqlSession.selectList("KAADM04.getPointSearchSolQ", map);
        }else {
            // 솔루션별 미해결 조회
            return sqlSession.selectList("KAADM04.getPointSearchSolNS", map);
        }
    }
    
    // 사용자별 지식포인트 조회
    // 질문, 답변, 평가 기준으로 조회
	public List<KAADM04VO> getPointSEarchListUser(String userId, String type, String sDate, String eDate) {
        System.out.println("KAADM04DAO.getPointSearchListUser Called...");
        System.out.println("type" + type);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uId", userId);
        map.put("sDate", sDate);
        map.put("eDate", eDate);

        if(type.equals("answer")){
            // 사용자별 답변 조회
            return sqlSession.selectList("KAADM04.getPointSearchUserA", map);
        } else if(type.equals("question")){
            // 사용자별 질문 조회
            return sqlSession.selectList("KAADM04.getPointSearchUserQ", map);
        } else {
            // 사용자별 평가 조회
            return sqlSession.selectList("KAADM04.getPointSearchUserSC", map);
        }
	}
}