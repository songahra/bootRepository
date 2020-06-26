package com.izt.log;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KALOG01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  송아라      최초작성
 * ------------------------------------------------------
 *
 */


@RestController
@RequestMapping("/api/test")
public class KALOG01Controller {

    @Autowired
    KALOG01Service KALOG01Service;

    // DB 테스트
    @GetMapping(value = "test")
    public KALOG01VO test() throws Exception {
        KALOG01VO kav= KALOG01Service.test();
        System.out.println(kav + "kav");
        return kav;
    }

    // 로그인
    @PostMapping(value="login")
    public Map<String, String> login(@RequestBody KALOG01VO KALOG01VO){
        Map<String, String> map = new HashMap<String,String>();
        System.out.println("KALOG01VO"+KALOG01VO.toString());
        map = KALOG01Service.login(KALOG01VO.getUser_id(), KALOG01VO.getUser_pw());
        System.out.println(map);
        if(map.containsKey("token")){
            System.out.println("토큰있음?..");
            return map;
        }System.out.println("토큰 없음");
        return map;
    }

    // 회원가입
    @PostMapping(value="signUp")
    public ResponseEntity signUp(@RequestBody KALOG01VO KALOG01VO){
        System.out.println("회원가입 컨트롤러 도착");
       System.out.println(KALOG01VO.toString());
           KALOG01Service.signUp(KALOG01VO);
        return new ResponseEntity<>("회원가입 성공",  HttpStatus.valueOf(200));
        }


}