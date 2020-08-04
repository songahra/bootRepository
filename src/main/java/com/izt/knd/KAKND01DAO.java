/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKND01DAO.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 30 신예은 최초작성
 * -------------------------------
 */
package com.izt.knd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KAKND01DAO {
    @Autowired
    SqlSession sqlSession;

	public List<KAKND01VO> getList(String title, String solution) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("KAKND01DAO CALLED!!!");
        map.put("title", title);
        map.put("solution", solution);
        return sqlSession.selectList("KAKND01.getList", map);
	}

	public void postWrite(KAKND01VO kAKND01VO) {
        System.out.println("KAKND01DAO << post Write >> CALLED!");
        sqlSession.insert("KAKND01.postWrite", kAKND01VO);
	}

	public KAKND01VO getDetail(String manual_id, String type) {
        System.out.println("KAKND01DAO << get Detail >> CALLED!");
        System.out.println("manual_id : " + manual_id + " type : " + type);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("manual_id", manual_id);
        if(type.equals("D")){
            return sqlSession.selectOne("KAKND01.getDetail", map);
        }else{
            return sqlSession.selectOne("KAKND01.getModiDetail", map);
        }
	}

	public void modify(KAKND01VO kAKND01VO) {
        System.out.println("KAKND01DAO << get Modify >> CALLED!");
        sqlSession.update("KAKND01.Modify", kAKND01VO);
	}

	public void delete(KAKND01VO kAKND01VO) {
        System.out.println("KAKND01DAO << delete >> CALLED!"+kAKND01VO.getManual_id());
        sqlSession.update("KAKND01.delete", kAKND01VO);
	}

    
}