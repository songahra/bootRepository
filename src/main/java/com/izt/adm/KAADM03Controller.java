/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM03Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.30 신동경   최초작성
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
public class KAADM03Controller {

    @Autowired 
    private KAADM03Service kAADM03Service;

    /**
    * 설정 > 코드 관리 메인화면 호출
    * @param  
    * @return List<KAADM03VO>
    * @exception Exception
    */
    @GetMapping(value="codeList")
    public List<KAADM03VO> codeList() throws Exception {
        System.out.println("KAADM03Controller srchCodeList Method called..");
        
        List<KAADM03VO> list = kAADM03Service.codeList();

        return list;
    }
    
    /**
    * 설정 > 코드 관리 메인화면 호출
    * @param String 
    * @return List<KAADM03VO>
    * @exception Exception
    */
    @GetMapping(value="srchCodeList")
    public List<KAADM03VO> srchCodeList(@RequestParam(value="code_name") String code_name,
                                        @RequestParam(value="code_id") String code_id, 
                                        @RequestParam(value="code_content") String code_content) throws Exception {
        System.out.println("KAADM03Controller srchCodeList Method called..");
        
        System.out.println("code_name : " + code_name + "code_id : " + code_id);
        
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("code_name", code_name);
        paramMap.put("code_id", code_id);
        paramMap.put("code_content", code_content);
        
        System.out.println("paramMap" + paramMap);

        List<KAADM03VO> list = kAADM03Service.srchCodeList(paramMap);   

        return list;
    }

       /**
    * 지식관리 기술문의 질문 등록
    * @param kAADM03VO
    * @return void
    * @exception 
    */
    @PostMapping(value="writeCodeInfo")
    public int write(@RequestBody KAADM03VO kAADM03VO){
        System.out.println("KAKNM01Controller modify Method called..");
        
        int result = 0;
        result = kAADM03Service.write(kAADM03VO);

        System.out.println("result?? " + result);
        
        return result;
    }

    /**
    * 지식관리 기술문의 질문 삭제/수정
    * @param kAADM03VO
    * @return void
    * @exception 
    */
    @PostMapping(value="modifyCodeInfo")
    public int modify(@RequestBody List<KAADM03VO> list){
        System.out.println("KAKNM01Controller modify Method called..");
        
        int result = 0;
        
        String flag = list.get(0).getFlag();
        System.out.println("flag=> " + flag);

        // 삭제/수정 분기
        if("D".equals(flag))  { 
            result = kAADM03Service.delete(list);
        } else if ("M".equals(flag)){
            result = kAADM03Service.modify(list);
        }

        System.out.println("result?? " + result);
        
        return result;
    }

}