package com.izt.log;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KALOG01DAO {
   @Autowired
   SqlSession sqlSession;

   //test 테이블 조회
   public KALOG01VO test(){
       System.out.println("DAO..");
        return sqlSession.selectOne("KALOG01.test");
   }
}