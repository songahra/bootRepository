package com.izt.myp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAMYP01Service {
    @Autowired
    KAMYP01DAO KAMYP01DAO;


    // 조회
    public List<Map<String, String>> selectMypage(String user_id){
        System.out.println("selectMypage서비스 도착");
        List<Map<String, String>> list = KAMYP01DAO.selectMypage(user_id);
        System.out.println(KAMYP01DAO.selectMypage(user_id));

        System.out.println();
        return list;
    }
    // question_id 조회
    public String getId(String answer_id){
        System.out.println("getId 서비스 도착");
        return KAMYP01DAO.getId(answer_id);
    }
}