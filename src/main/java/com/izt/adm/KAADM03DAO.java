/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM03DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * * 2020.07.30 신동경   최초작성
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
public class KAADM03DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kAADM03.";
    
    // 설정 유저 리스트 
    public List<KAADM03VO> codeList(){
        System.out.println("KAADM03DAO codeList called...");
        return sqlSession.selectList(mapperNameSpace+"codeList");
    }

    // 설정 유저 리스트 조회
    public List<KAADM03VO> srchCodeList(Map<String, Object> map){
        System.out.println("KAADM03DAO srchCodeList called...");
        return sqlSession.selectList(mapperNameSpace+"srchCodeList");
    }

}