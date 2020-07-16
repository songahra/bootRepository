/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKNM02.java
 * -------------------------------
 * REVERSION:
 * 2020. 06. 24 신예은 최초작성
 * -------------------------------
 */
package com.izt.knm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class KAKNM02DAO {
    @Autowired
    SqlSession sqlSession;


	public List<KAKNM02VO> getList(String title, String status, String user) {
		System.out.println("KAKNM02DAO getList");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("status", status);
		map.put("reg_userid", user);
		return sqlSession.selectList("KAKNM02.getList", map);
	}


	public void postWrite(KAKNM02VO kAKNM02VO) {
		System.out.println("KAKNM02DAO postWrite");
		sqlSession.insert("KAKNM02.postWrite", kAKNM02VO);
	}

	public void postTag(KAKNM02VO kAKNM02VO){
		System.out.println("KAKNM02DAO postTag");
		sqlSession.insert("KAKNM02.postTag", kAKNM02VO);
	}

}