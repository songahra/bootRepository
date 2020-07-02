package com.izt.prm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAPRM01DAO {
    @Autowired
    SqlSession sqlSession;

    //비밀번호 변경
    public void updatedPassword(String password){
        System.out.println("비밀번호 변경 DAO 도착");
        sqlSession.update("updatePassword", password);
        
    }
}