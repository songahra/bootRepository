/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM02Service.java
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
import org.springframework.stereotype.Service;

@Service
public class KAADM02Service {

    @Autowired
    private KAADM02DAO kAADM02DAO;

    // 지식관리 메인화면 리스트조회
    public List<KAADM02VO> allUserList() {
        System.out.println("KAADM02Service allUserList");
        return kAADM02DAO.allUserList();
    }

    // 지식관리 메인화면 리스트조회
    public List<KAADM02VO> srchUserList(Map<String, Object> map) {
        System.out.println("KAADM02Service srchUserList");
        return kAADM02DAO.srchUserList(map);
    }

}