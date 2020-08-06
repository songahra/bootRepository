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
import org.springframework.web.bind.annotation.RequestParam;
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

    // 공지사항 목록 조회
    @GetMapping(value = "searchList")
    public List<KANTI01VO> searchNotice(@RequestParam(value ="search_title") String search_title,
                                        @RequestParam(value="sortType")String sortType) {
      KANTI01DTO KANTI01DTO = new KANTI01DTO();
      KANTI01DTO.setSortType(sortType);
      KANTI01DTO.setSearch_title(search_title);
      
      System.out.println("컨트롤러 도착" + KANTI01DTO.toString());

      List<KANTI01VO> list = KANTI01Service.searchNotice(KANTI01DTO);

      System.out.println("list?????"+ list.toString());
      return list;
    }

    // 조회수 +1
    @GetMapping(value="plusCnt")
    public void getMethodName(@RequestParam(value = "notice_id") String notice_id) {
        KANTI01Service.plusCnt(notice_id);
    }

    // 공지사항 상세보기
    @GetMapping(value = "detail")
    public KANTI01VO detailNotice(@RequestParam(value = "notice_id") String notice_id) {
      System.out.println("detailNotice called..notice_id?" + notice_id);
      return KANTI01Service.detailNotice(notice_id);
    }

    // 공지사항 수정하기
    @PostMapping(value= "modify")
    public void updateNotice(KANTI01VO KANTI01VO){
      System.out.println("여기는수정하기 컨트롤러");
      System.out.println("KANTI01VO??" + KANTI01VO);
      KANTI01Service.updateNotice(KANTI01VO);
    }
    
    //공지사항 삭제
    @PostMapping(value="delete")
    public void deleteNotice(@RequestParam(value = "notice_id") String notice_id){
      System.out.println("삭제하기 컨트롤러");
      System.out.println("삭제하기 컨트롤러notice_id?"+ notice_id);

      KANTI01Service.deleteNotice(notice_id);
    }
    
}