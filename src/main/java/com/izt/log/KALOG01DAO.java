package com.izt.log;

import java.util.List;
import java.util.Map;

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

   //회원가입
   public void signUp(KALOG01VO KALOG01VO){
      System.out.println("회원가입 DAO도착");
      System.out.println(KALOG01VO);
      sqlSession.insert("signUp", KALOG01VO);
   }

   //로그인 (아이디 확인)
   public KALOG01VO checkId(String user_id){
      System.out.println("로그인 DAO checkId 도착");
      return sqlSession.selectOne("checkId", user_id);
   }

   //로그인 카운트 ++ (아아디 O / 비밀번호 X)
   public void loginCnt(String user_id){
      System.out.println("로그인 카운트 DAO 도착");
      sqlSession.update("loginCount", user_id);
   }

   
   //로그인 카운트 횟수 조회
   public int selectCount(String user_id){
      System.out.println("로그인 카운트 횟수 조회 DAO 도착");
      return sqlSession.selectOne("selectCount", user_id);
   }

   //사용자 계정 잠금
   public void loginRock(String user_id){
      System.out.println("loginRock 잠금 DAO");
      sqlSession.update("loginRock", user_id);
   }

   //사용자 계정 잠금 여부 확인
   public String selectLock(String user_id){
      return sqlSession.selectOne("selectL ck", user_id);
   }

   //아이디 중복 체크
   public int idCheck(String user_id){
      System.out.println("idCheck DAO도착");
      return sqlSession.selectOne("idCheck", user_id); //중복 아이디 있으면 1 반환
   }

   //솔루션 목록
   public List<Map<String,String>> getSolution(){
      System.out.println(sqlSession.selectList("getSolution"));
      return sqlSession.selectList("getSolution");
   }

   //비밀번호 변경
   public void updatePassword(KALOG01VO KALOG01VO){
      System.out.println("updatePassword DAO 도착");
      sqlSession.update("updatePassword", KALOG01VO);
   }

}
