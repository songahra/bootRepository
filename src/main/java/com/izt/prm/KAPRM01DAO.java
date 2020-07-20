package com.izt.prm;

import java.util.List;
import java.util.Map;

import com.izt.log.KALOG01VO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAPRM01DAO {
    @Autowired
    SqlSession sqlSession;

    //이전 비밀번호 확인
    public String getPassword(String user_id){
        return sqlSession.selectOne("KAPRM01.getPassword", user_id);
    }

    //비밀번호 변경
    public void updatedPassword(Map<String,Object> param){
        System.out.println("비밀번호 변경 DAO 도착 바꿀 비밀번호 (update_pw) : " + param.get("update_pw"));
        System.out.println("비밀번호 변경 DAO 도착 아이디 (user_id) : " + param.get("user_id"));
        System.out.println("비밀번호 변경 DAO 도착 원래 비밀번호 (user_pw) : " + param.get("user_pw"));
        sqlSession.update("KAPRM01.updatePw", param);
        
    }

    //프로필 수정
    public int updateProfile(KALOG01VO KALOG01VO){
        System.out.println("프로필 수정 DAO도착" + KALOG01VO);
        int rst = 0;
        rst = sqlSession.update("KAPRM01.updateProfile", KALOG01VO);
        return rst;
    }

    //프로필 이미지 base64 저장
    public void insertProfileImage(KAPRM01DTO KAPRM01DTO){
        System.out.println("insertProfileImage DAO도착");
        sqlSession.insert("insertImage", KAPRM01DTO);
    }

    //프로필 이미지 조회
    public String selectProfile(String user_id){
        System.out.println("selectProfile DAO도착");
        return sqlSession.selectOne("selectImage", user_id);
    }

    //사용자 별 지식 포인트 조회
    public List<KAPRM01VO> selectMonthPoint(KAPRM02DTO KAPRM02DTO){
    System.out.println("selectMonthPoint DAO 도착");
    List<KAPRM01VO> list = sqlSession.selectList("selectMonthPoint", KAPRM02DTO);
    System.out.println("list" + list);
    return list;

    }

    // 사용자 총 누적 지식 포인트 조회
    public int selectTotalPoint(String user_id){
        System.out.println("selectTotalPoint DAO 도착");
        return sqlSession.selectOne("selectTotalPoint", user_id);
    }
    // 이번달 총 누적 지식 포인트 조회
    public int selectMonthTotalPoint(KAPRM02DTO KAPRM02DTO){
        System.out.println("selectMonthTotalPoint DAO도착");
       return sqlSession.selectOne("selectMonthTotalPoint", KAPRM02DTO);
    }
}