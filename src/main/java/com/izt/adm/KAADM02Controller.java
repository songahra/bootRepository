/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM02Controller.java
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/adm")
public class KAADM02Controller {

    @Autowired 
    private KAADM02Service kAADM02Service;

    /**
    * 설정 권한 관리 메인화면 호출
    * @param KAADM02VO 
    * @return List<KAADM02VO>
    * @exception Exception
    */
    @GetMapping(value="allUserList")
    public List<KAADM02VO> allUserList() throws Exception {
        System.out.println("KAADM02Controller allUserList Method called..");
        
        List<KAADM02VO> list = kAADM02Service.allUserList();

        return list;
    }

    /**
    * 설정 관한관리 조회 리스트
    * @param KAADM02VO 
    * @return List<KAADM02VO>
    * @exception Exception
    */
    @GetMapping(value="srchUserList")
    public List<KAADM02VO> srchUserList(@RequestParam(value="user_id") String user_id,
                                        @RequestParam(value="user_name") String user_name, 
                                        @RequestParam(value="company") String company){
        System.out.println("KAADM02Controller srchUserList Method called..");
        System.out.println("user_id : " + user_id + "user_name : " + user_name);
        
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("user_id", user_id);
        paramMap.put("user_name", user_name);
        paramMap.put("company", company);
        
        System.out.println("paramMap" + paramMap);

        List<KAADM02VO> list = kAADM02Service.srchUserList(paramMap);     
        
        return list;
    }

    /**
    * 설정 관한관리 사용자정보 수정
    * @param KAKNM01VO
    * @return void
    * @exception 
    */
    @PostMapping(value="modify")
    public int modify(@RequestBody List<KAADM02VO> list){
        System.out.println("KAKNM01Controller modify Method called..");
        System.out.println("KAADM02VO => " + list);
        
        int result = kAADM02Service.modify(list);

        return result;
    }  

    /**
    * 설정 관한관리 사용자정보 삭제
    * @param KAKNM01VO
    * @return void
    * @exception 
    */
    @PostMapping(value="delete")
    public int delete(@RequestBody List<KAADM02VO> list){
        System.out.println("KAKNM01Controller modify Method called..");
        System.out.println("KAADM02VO => " + list);
        
        int result = kAADM02Service.delete(list);

        return result;
    }  
}