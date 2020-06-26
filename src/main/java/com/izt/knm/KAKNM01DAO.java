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

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAKNM01DAO {

    @Autowired
	private SqlSession sqlSession;
    
    public List<KAKNM01VO> getAllList(){
        System.out.println("KAKNM01DAO getAllList called...");
        return sqlSession.selectList("kAKNM01DAO.getAllList");
    }

    public List<KAKNM01VO> getList(KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01VO getList called...");
        return sqlSession.selectList("kAKNM01DAO.getList", kAKNM01VO);
    }
}