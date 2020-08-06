package com.izt.myp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")

public class KAMYP01Controller{
    @Autowired
    KAMYP01Service KAMYP01Service;

    //조회
    @GetMapping(value="list")
    public List<Map<String, String>> selectMypage(@RequestParam(value = "user_id") String user_id){
        System.out.println("selectMypage 컨트롤러 도착");
        return KAMYP01Service.selectMypage(user_id);
    }
    // questionID조회
    @GetMapping(value = "getId")
    public String getId(@RequestParam(value = "answer_id") String answer_id) {
        System.out.println("getId 컨트롤러 도착" + answer_id);
        return KAMYP01Service.getId(answer_id);
    }
}