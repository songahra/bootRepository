/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM03DAO.java
 * ------------------------------------------------------
 * REVERSION :
 * * 2020.07.30 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAADM03DAO {

    @Autowired
    private SqlSession sqlSession;
    
    private final String mapperNameSpace = "kAADM03.";
    
    // 설정 코드 리스트 
    public List<KAADM03VO> codeList(){
        System.out.println("KAADM03DAO codeList called...");
        return sqlSession.selectList(mapperNameSpace+"codeList");
    }

    // 설정 코드 리스트 조회
    public List<KAADM03VO> srchCodeList(Map<String, Object> map){
        System.out.println("KAADM03DAO srchCodeList called...");
        System.out.println("Kssssss.." + map.get("code_content"));
        
        return sqlSession.selectList(mapperNameSpace+"srchCodeList",map);
    }

    // 설정 코드 등록
    public int write(KAADM03VO kAADM03VO){
        System.out.println("KAADM03DAO write called...");
        return sqlSession.insert(mapperNameSpace+"insertCodeInfo", kAADM03VO);
    }

    // 설정 코드 수정
    public int modify(List<KAADM03VO> list){
        System.out.println("KAADM03DAO modify called...");
        return sqlSession.update(mapperNameSpace+"updateCodeInfo", list);
    }

    // 설정 코드 삭제
    public int delete(List<KAADM03VO> list){
        System.out.println("KAADM03DAO srchCodeList called...");
        return sqlSession.delete(mapperNameSpace+"deleteCodeInfo", list);
    }

}