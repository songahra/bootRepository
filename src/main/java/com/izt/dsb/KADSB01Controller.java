/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KADSB01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.30 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.dsb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/dsb")
public class KADSB01Controller {

    @Autowired 
    private KADSB01Service kADSB01Service;

    /**
    * 대시보드 메인화면 호출
    * @param KADSB01VO 
    * @return List<KADSB01VO>
    * @exception Exception
    */
    @GetMapping(value="main")
    public List<KADSB01VO> main() throws Exception {
        System.out.println("KAADM02Controller main Method called..");
        
        List<KADSB01VO> list = kADSB01Service.main();

        return list;
    }

    /**
    * 대시보드 공지사항
    * @param KADSB01VO 
    * @return List<KADSB01VO>
    * @exception Exception
    */
    @GetMapping(value="noticeList")
    public List<KADSB01VO> noticeList() throws Exception {
        System.out.println("KAADM02Controller noticeList Method called..");
        
        List<KADSB01VO> list = kADSB01Service.noticeList();

        return list;
    }
   
}