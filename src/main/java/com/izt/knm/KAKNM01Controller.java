/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/knm")
public class KAKNM01Controller {

    @Autowired 
    private KAKNM01Service kAKNM01Service;

    /**
    * 지식관리 메인화면 호출
    * @param KAKNM01VO kAKNM01VO
    * @return List<KAKNM01VO>
    * @exception Exception
    */
    @GetMapping(value="main")
    public List<KAKNM01VO> main() throws Exception {
        System.out.println("KAKNM01Controller Controller main Method called..");
        
        List<KAKNM01VO> list = kAKNM01Service.mainList();
        System.out.println("Main list : " + list.toString());
        return list;
    }

    /**
    * 지식관리 조건에 따른 조회화면
    * @param KAKNM01VO 
    * @return List<KAKNM01VO>
    * @exception
    */
    @PostMapping(value="getList")
    public List<KAKNM01VO> getList (@RequestBody KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01Controller getList Method called..");        
        System.out.println("kAKNM01VO.getTitle : " + kAKNM01VO.getTitle());
        List<KAKNM01VO> list = kAKNM01Service.getList(kAKNM01VO);
        System.out.println("get list : " + list.toString());
        return list;
    }

    /**
    * 지식관리 질문 등록화면
    * @param KAKNM01VO
    * @return void
    * @exception 
    */
    @PostMapping(value="KnmFrom")
    public void KnmFrom(@RequestBody KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01Controller KnmFrom Method called..");
        kAKNM01Service.getList(kAKNM01VO);
    }
}