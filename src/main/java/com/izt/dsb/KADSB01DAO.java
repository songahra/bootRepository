/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KADSB01DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * * 2020.07.30 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.dsb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KADSB01DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kADSB01.";
    
    // 설정 유저 리스트 
    public List<KADSB01VO> main(){
        System.out.println("KADSB01DAO main called...");
        return sqlSession.selectList(mapperNameSpace+"main");
    }

        
    // 설정 유저 리스트 
    public List<KADSB01VO> noticeList(){
        System.out.println("KADSB01DAO noticeList called...");
        return sqlSession.selectList(mapperNameSpace+"noticeList");
    }
    
}