/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAKNM01Service {
    @Autowired
    private KAKNM01DAO kAKNM01DAO;

    // 지식관리 메인화면 리스트조회
    public List<KAKNM01VO> mainList() {
        System.out.println("KAKNM01Service mainList");
        return kAKNM01DAO.getAllList();
    }

    // 지식관리 게시판 조건에 따른 조회
    public List<KAKNM01VO> getList(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service getList");
        return kAKNM01DAO.getList(kAKNM01VO);
    }

    // 지식관리 질문 등록
    public List<KAKNM01VO> KnmForm(KAKNM01VO kAKNM01VO) {
        System.out.println("KAKNM01Service KnmForm");

        return kAKNM01DAO.getList(kAKNM01VO);
    }
}
