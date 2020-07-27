/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKNM02Controller.java
 * -------------------------------
 * REVERSION:
 * 2020. 06. 24 신예은 최초작성
 * -------------------------------
 */
package com.izt.knm;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/KAKNM02")
public class KAKNM02Controller {
    
    @Autowired
    KAKNM02Service KAKNM02Service;
    KAKNM02VO KAKNM02VO;

    // 답변 작성
    @PostMapping(value = "write")
    public int write(@RequestBody KAKNM02VO kAKNM02VO) {
        System.out.println("KAKNM02Controller << write / modify >> called...");
        return KAKNM02Service.postWrite(kAKNM02VO);
    }
    // 답변 수정을 위한 질문 답변 detail 가져오기
    @GetMapping(value = "getModifyDetail")
    public KAKNM02VO getModifyDetail(/*@RequestParam(value="questionId") String question_id,*/
                                           @RequestParam(value="answer_id") String answer_id){
        System.out.println("KAKNM02CONTROLLER <<<<<< GET Modify DETAIL >>>>>> CALLED");
        // System.out.println("question_id : " + question_id);
        System.out.println("answer_id : " + answer_id);
        KAKNM02VO kAKNM02VO = KAKNM02Service.getModifyDetail(/*question_id,*/ answer_id);
        return kAKNM02VO ;
    }
    // 답변 가져오기
    @GetMapping(value = "getAnswer")
    public List<KAKNM02VO> getAnswer(@RequestParam(value="answer_id") String answer_id){
        System.out.println("KAKNM02Controller getAnswer called..");
        System.out.println("answer_id : " + answer_id);
        List<KAKNM02VO> KAKNM02VO = KAKNM02Service.getAnswer(answer_id);
        return KAKNM02VO;
    }
    // 답변 지우기
    @GetMapping(value="ansDelete")
    public int delete(@RequestParam(value="answer_id") String answer_id){
        System.out.println("KAKNM02Controller << delete >> called");
        System.out.println("answer_id : " + answer_id);
        KAKNM02Service.delete(answer_id);
        return 1;
    }

    // 내가 답변한 리스트
    @GetMapping(value = "getList")
    public List<KAKNM02VO> getList(@RequestParam(value="title") String title,
                                   @RequestParam(value="status") String status,
                                   @RequestParam(value="user") String user) {
        System.out.println("KAKNM02Controller searchList called..");
        System.out.println("title : " + title);
        System.out.println("status : " + status);
        System.out.println("user : " + user);
        List<KAKNM02VO> KAKNM02VO = KAKNM02Service.getList(title, status, user);
        return KAKNM02VO;
    }

   

    
}