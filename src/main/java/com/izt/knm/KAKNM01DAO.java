package com.izt.knm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAKNM01DAO {

    @Autowired
	private SqlSession sqlSession;
    
    public List<KAKNM01VO> selectList(){
        System.out.println("KAKNM01DAO selectList called...");
        return sqlSession.selectList("kAKNM01DAO.selectList");
    }
}