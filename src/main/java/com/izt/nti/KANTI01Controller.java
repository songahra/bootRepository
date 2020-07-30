/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KANTI01Controller.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 27 송아라 최초작성
 * -------------------------------
 */

package com.izt.nti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notice")
public class KANTI01Controller {
    @Autowired
    KANTI01Service KANTI01Service;
    
    //공지사항 등록
    @PostMapping(value="write")
    public void write(KANTI01VO KANTI01VO){
        
        System.out.println("공지사항 등록 컨트롤러 도착");
        System.out.println("공지사항 등록 컨트롤러 도착 KANTI01VO는?" + KANTI01VO);
        KANTI01Service.writeNotice(KANTI01VO);
        
    }

    // 공지사항 목록 조회
    @GetMapping(value="list")
    public List<KANTI01VO> selectNotice(){
      List<KANTI01VO> list  = KANTI01Service.selectNotice();
      return list;
    }

    // 공지사항 상세보기 
    // @GetMapping(value="detail")
    // public KANTI01VO detailNotice() {

    // }
    
}