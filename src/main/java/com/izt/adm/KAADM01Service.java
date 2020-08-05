/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM01Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.24 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAADM01Service {

    @Autowired
    private KAADM01DAO kAADM01DAO;

    // 설정>사용자권한 메인화면 리스트조회
    public List<KAADM01VO> getPjList() {
        System.out.println("KAADM01Service getPrList called..");
        return kAADM01DAO.getPjList();
    }

    // 설정>사용자권한 메인화면 리스트조회
    public List<KAADM01VO> srchPjList(Map<String, Object> map) {
        System.out.println("KAADM02Service srchPjList called..");
        return kAADM01DAO.srchPjList(map);
    }

}