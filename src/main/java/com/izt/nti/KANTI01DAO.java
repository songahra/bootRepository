package com.izt.nti;

import java.io.Console;
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

    // 공지사항 조회
    public List<KANTI01VO> searchNotice(KANTI01DTO KANTI01DTO) {
        System.out.println("selectNotice 다오 도착");
        List<KANTI01VO> list = sqlSession.selectList("searchNotice", KANTI01DTO);
        return list;
    }

    // 조회수 +1 
    public void plusCnt(String notice_id){
        System.out.println("plusCnt 다오 도착");
        sqlSession.update("plusCnt", notice_id);
    }

    // 상세보기
    public KANTI01VO detailNotice(String notice_id) {
        System.out.println("detailNotice 다오 도착");
        return sqlSession.selectOne("detailNotice", notice_id);
    }
    
    //공지사항 수정
    public void updateNotice(KANTI01VO KANTI01VO){
        System.out.println("updateNotice 다오 도착");
        sqlSession.update("updateNotice",KANTI01VO);
    }

    //공지사항 삭제
    public void deleteNotice(String notice_id){
        System.out.println("?" + notice_id);
        sqlSession.update("deleteNotice", notice_id);
    }
}