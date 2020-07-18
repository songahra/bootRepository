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
@RequestMapping("/knm")
public class KAKNM01Controller {

    @Autowired 
    private KAKNM01Service kAKNM01Service;

    /**
    * 지식관리 메인화면 호출
    * @param KAKNM01VO 
    * @return List<KAKNM01VO>
    * @exception Exception
    */
    @GetMapping(value="mainList")
    public List<KAKNM01VO> main() throws Exception {
        System.out.println("KAKNM01Controller main Method called..");
        
        List<KAKNM01VO> list = kAKNM01Service.mainList();
        // System.out.println("Main list : " + list.toString());
        return list;
    }

    /**
    * 지식관리 조건에 따른 조회화면
    * @param KAKNM01VO 
    * @return List<KAKNM01VO>
    * @exception
    */
    @PostMapping(value="srchList")
    public List<KAKNM01VO> srchList (@RequestBody KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01Controller srchList Method called..");        
        System.out.println("kAKNM01VO.getTitle : " + kAKNM01VO.getTitle());
        List<KAKNM01VO> list = kAKNM01Service.srchList(kAKNM01VO);
        System.out.println("get list : " + list.toString());
        return list;
    }
    
     /**
    * 지식관리 기술문의 상세보기
    * @param String
    * @return KAKNM01VO
    * @exception 
    */
    @GetMapping(value="getDetail")
    public KAKNM01VO getDetail(@RequestParam(value="reg_userid") String reg_userid,
                               @RequestParam(value="question_id") String question_id){
        System.out.println("KAKNM01Controller getDetail Method called..");
        System.out.println("reg_userid : " + reg_userid);
        System.out.println("question_id : " + question_id);

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("reg_userid", reg_userid);
        paramMap.put("question_id", question_id);

        KAKNM01VO kAKNM01VO = kAKNM01Service.getDetail(paramMap);     

        System.out.println("kAKNM01VO =>=> "+ kAKNM01VO);
        
        return kAKNM01VO;
    }

    /**
    * 지식관리 기술문의 질문 등록/삭제/수정
    * @param KAKNM01VO
    * @return void
    * @exception 
    */
    @PostMapping(value="modify")
    public int modify(@RequestBody KAKNM01VO kAKNM01VO){
        System.out.println("KAKNM01Controller modify Method called..");
        System.out.println("kAKNM01VO => " + kAKNM01VO.toString());
        
        int result = 0;
        String flag = kAKNM01VO.getFlag();
        
        // 등록/삭제/수정 분기
        if("W".equals(flag)){
            result = kAKNM01Service.write(kAKNM01VO);
        } else if("D".equals(flag))  { 
            result = kAKNM01Service.delete(kAKNM01VO);
        } else {
            result = kAKNM01Service.modify(kAKNM01VO);
        }

        System.out.println("kAKNM01VO => " + kAKNM01VO.toString());
        
        return result;
    }

    /**
    * 지식관리 내가 문의한 질문 메인화면
    * @param String
    * @return List<KAKNM01VO>
    * @exception 
    */
    @GetMapping(value="getMyList")
    public List<KAKNM01VO> getMyList(@RequestParam(value="userid") String userid){
        System.out.println("KAKNM01Controller getMyList Method called..");
        System.out.println("userid" + userid);

        List<KAKNM01VO> list = kAKNM01Service.getMyList(userid);     
        
        return list;
    }

    /**
    * 지식관리 내가 문의한 질문 조회 화면
    * @param String
    * @return void
    * @exception 
    */
    @GetMapping(value="srchMyList")
    public List<KAKNM01VO> srchMyList(@RequestParam(value="userid") String userid,
                                      @RequestParam(value="title") String title, 
                                      @RequestParam(value="status") String status){
        System.out.println("KAKNM01Controller getMyList Method called..");
        System.out.println("userid : " + userid + "title : " + title);
        
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("userid", userid);
        paramMap.put("title", title);
        paramMap.put("status", status);
        
        System.out.println("paramMap" + paramMap);

        List<KAKNM01VO> list = kAKNM01Service.srchMyList(paramMap);     
        
        return list;
    }

    /**
    * 지식관리 질문 등록화면에서 Project List 화면
    * @param KAKNM01VO
    * @return List<KAKNM01VO>
    * @exception 
    */
    @GetMapping(value="getPrList")
    public List<KAKNM01VO> getPrList(){
        System.out.println("KAKNM01Controller getPrList Method called..");
        List<KAKNM01VO> list = kAKNM01Service.getPrList();
        return list;
    }

    /**
    * 지식관리 프로젝트 리스트 조회 화면
    * @param String
    * @return List<KAKNM01VO>
    * @exception 
    */
    @GetMapping(value="srchPrList")
    public List<KAKNM01VO> srchPrList(@RequestParam(value="project_id") String project_id,
                                      @RequestParam(value="project_name") String project_name,
                                      @RequestParam(value="customer") String customer){
        System.out.println("KAKNM01Controller srchPrList Method called..");
        System.out.println("project_name : " + project_name + "customer : " + customer);
        
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("project_id", project_id);
        paramMap.put("project_name", project_name);
        paramMap.put("customer", customer);
        
        System.out.println("paramMap" + paramMap);

        List<KAKNM01VO> list = kAKNM01Service.srchPrList(paramMap);     
        
        return list;
    }
}