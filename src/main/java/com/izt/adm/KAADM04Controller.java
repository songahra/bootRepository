/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM04Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.24  신예은   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/KAADM04")
public class KAADM04Controller {
    @Autowired
    private KAADM04Service kAADM04Service;

    // 솔루션별 지식포인트 조회
    @GetMapping(value="sol")
    public List<KAADM04VO> getSolList(@RequestParam(value="reg_date_start") String sDate,
                                      @RequestParam(value="reg_date_end") String eDate) {
        System.out.println("sDate : " + sDate + "\neDate : " + eDate);
        List<KAADM04VO> KAADM04VO = kAADM04Service.getSolList(sDate, eDate);
        System.out.println("KAADM04VO => " + KAADM04VO);
        return KAADM04VO;
    }
    // 사용자별 지식포인트 조회
    @GetMapping(value="user")
    public List<KAADM04VO> getUserList(@RequestParam(value="reg_date_start") String sDate,
                                       @RequestParam(value="reg_date_end") String eDate) {
        System.out.println("sDate : " + sDate + "\neDate : " + eDate);
        List<KAADM04VO> KAADM04VO = kAADM04Service.getUserList(sDate, eDate);
        System.out.println("KAADM04VO.GETLIST << USER >> "+ KAADM04VO.toString());
        return KAADM04VO;
    }

    // 선택된 솔루션의 지식포인트 조회
    @GetMapping(value="searchPointSol")
    public List<KAADM04VO> getPointSearchListSol(@RequestParam(value="solution") String solution,
                                                 @RequestParam(value="type") String type,
                                                 @RequestParam(value="reg_date_start") String startDate,
                                                 @RequestParam(value="reg_date_end") String endDate) {
        System.out.println("############### KAADM04Controller.searchPoint << Sol >> Called!!!!!! #################");
        System.out.println("solution : " + solution +" type : " +type+" reg_date_start : "+startDate+" reg_date_end : "+endDate);
        List<KAADM04VO> KAADM04VO = kAADM04Service.getPointSearchListSol(solution, type, startDate, endDate);
        System.out.println("KAADM04VO.SEARCHPOINTSOL"+ KAADM04VO.toString());                                            
        return KAADM04VO;
    }

    // 선택된 유저의 지식포인트 조회
    @GetMapping(value="searchPointUser")
    public List<KAADM04VO> getPointSearchListUser(@RequestParam(value="user") String userId,
                                                  @RequestParam(value="type") String type,
                                                  @RequestParam(value="reg_date_start") String sDate,
                                                  @RequestParam(value="reg_date_end") String eDate){
        System.out.println("############### KAADM04Controller.searchPoint  << User >> Called!!!!!! #################");
        System.out.println("userName : " + userId +" type : " +type+" reg_date_start : "+sDate+" reg_date_end : "+eDate);                                            
        List<KAADM04VO> KAADM04VO =kAADM04Service.getPointSearchListUser(userId, type, sDate, eDate);
        System.out.println("KAADM04VO.SEARCHPOINT << USER >> "+ KAADM04VO.toString());                                                
        return KAADM04VO;

    }
}