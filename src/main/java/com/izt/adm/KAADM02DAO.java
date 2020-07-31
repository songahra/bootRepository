/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM02DAO.java
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
public class KAADM02DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kAADM02.";
    
    // 설정 유저 리스트 
    public List<KAADM02VO> allUserList(){
        System.out.println("KAKNM01DAO allUserList called...");
        return sqlSession.selectList(mapperNameSpace+"allUserList");
    }
   
    // 설정 유저 리스트 조회
    public List<KAADM02VO> srchUserList(Map<String, Object> map){
        System.out.println("KAKNM01DAO srchUserList called...");
        return sqlSession.selectList(mapperNameSpace+"srchUserList", map);
    } 

    // 유저정보 수정
    public int updateUserInfo(List<KAADM02VO> list){
        System.out.println("KAKNM01DAO updateUserInfo called...");
        return sqlSession.update(mapperNameSpace+"updateUserInfo", list);
    }

    // 유저정보 삭제
    public int deleteUserInfo(List<KAADM02VO> list){
        System.out.println("KAKNM01DAO deleteUserInfo called...");
        return sqlSession.update(mapperNameSpace+"deleteUserInfo", list);
    }

}