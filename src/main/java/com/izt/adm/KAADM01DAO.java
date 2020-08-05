/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM01DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * * 2020.07.24 신동경   최초작성
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
public class KAADM01DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kAADM01.";
    
    // 설정 유저 리스트 
    public List<KAADM01VO> getPjList(){
        System.out.println("KAADM01DAO getPjList called...");
        return sqlSession.selectList(mapperNameSpace+"getPjList");
    }
   
    // 설정 유저 리스트 조회
    public List<KAADM01VO> srchPjList(Map<String, Object> map){
        System.out.println("KAADM01DAO srchPjList called...");
        return sqlSession.selectList(mapperNameSpace+"srchPjList", map);
    } 

}