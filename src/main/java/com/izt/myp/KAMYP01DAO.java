package com.izt.myp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAMYP01DAO {
    @Autowired
    SqlSession sqlSession;

    //조회
    public List<Map<String, String>> selectMypage(String user_id){
        System.out.println("selectMypage 다오 도착");
        return sqlSession.selectList("selectMypage", user_id);
    }

    // question_id 조회
    public String getId(String answer_id){
    return sqlSession.selectOne("getId",answer_id);
    }
}