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

	// 내가 답변한 리스트
	public List<KAKNM02VO> getList(String title, String status, String user) {
		System.out.println("KAKNM02DAO getList");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("status", status);
		map.put("reg_userid", user);
		return sqlSession.selectList("KAKNM02.getList", map);
	}

	// 답변하기
	public void postWrite(KAKNM02VO kAKNM02VO) {
		System.out.println("KAKNM02DAO postWrite");
		sqlSession.insert("KAKNM02.postWrite", kAKNM02VO);
	}

	// 태그 작성하기
	public void postTag(KAKNM02VO kAKNM02VO){
		System.out.println("KAKNM02DAO postTag");
		sqlSession.insert("KAKNM02.postTag", kAKNM02VO);
	}

	// 답변 가져오기
	public List<KAKNM02VO> getAnswer(String answer_id) {
		System.out.println("KAKNM02DAO getAnswer");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("answer_id", answer_id);
		return sqlSession.selectList("KAKNM02.getAnswer", map);
	}

	// 태그 지우기
	public void delTag(KAKNM02VO kAKNM02VO) {
		sqlSession.delete("KAKNM02.delTag", kAKNM02VO);
	}

	// 수정하기
	public void modify(KAKNM02VO kAKNM02VO) {
		sqlSession.update("KAKNM02.modify", kAKNM02VO);
	}

}