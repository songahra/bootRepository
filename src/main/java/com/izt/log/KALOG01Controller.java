package com.izt.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class KALOG01Controller {

    @Autowired
    KALOG01Service KALOG01Service;

    @GetMapping(value = "test")
    public KALOG01VO test() throws Exception {
        System.out.println("컨트롤러 도착");
        KALOG01VO kav= KALOG01Service.test();
        System.out.println(kav + "kav");
        return kav;
    }
}