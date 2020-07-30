package com.izt.nti;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KANTI01DAO {
    @Autowired
    SqlSession sqlSession;

    //글 등록
    public void writeNotice(KANTI01VO KANTI01VO){
        System.out.println("writeNotice 다오 도착");
        System.out.println("KANTI01VO??" + KANTI01VO);

       sqlSession.insert("writeNotice", KANTI01VO);
    }
    
    //공지사항 조회
    public List<KANTI01VO> selectNotice(){
        System.out.println("selectNotice 다오 도착");
        List<KANTI01VO> list = sqlSession.selectList("selectNotice");
        return list;
    }
}