/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.24 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/adm")
public class KAADM01Controller {

    @Autowired 
    private KAADM01Service kAADM01Service;

    /**
    * 설정 프로젝트 관리 메인화면 호출KAADM01VO
    * @param KAADM01VO 
    * @return List<KAADM02VO>
    * @exception Exception
    */
    @GetMapping(value="getPjList")
    public List<KAADM01VO> getPjList() throws Exception {
        System.out.println("KAADM02Controller allUserList Method called..");
        
        List<KAADM01VO> list = kAADM01Service.getPjList();

        return list;
    }
    /**
    * 지식관리 프로젝트 리스트 조회 화면
    * @param String
    * @return List<KAKNM01VO>
    * @exception 
    */
    @GetMapping(value="srchPjList")
    public List<KAADM01VO> srchPjList(@RequestParam(value="project_id") String project_id,
                                      @RequestParam(value="project_name") String project_name,
                                      @RequestParam(value="customer") String customer,
                                      @RequestParam(value="project_start_date") String project_start_date,
                                      @RequestParam(value="project_end_date") String project_end_date){
        System.out.println("KAKNM01Controller srchPrList Method called..");
        System.out.println("project_name : " + project_name + "customer : " + customer);
        
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("project_id", project_id);
        paramMap.put("project_name", project_name);
        paramMap.put("customer", customer);
        paramMap.put("project_start_date", project_start_date);
        paramMap.put("project_end_date", project_end_date);
        
        System.out.println("paramMap" + paramMap);

        List<KAADM01VO> list = kAADM01Service.srchPjList(paramMap);     
        
        return list;
    }

}