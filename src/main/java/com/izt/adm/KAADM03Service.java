/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM03Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.30 신동경   최초작성
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
public class KAADM03Service {

    @Autowired
    private KAADM03DAO kAADM03DAO;

    // 설정>사용자권한 메인화면 리스트
    public List<KAADM03VO> codeList() {
        System.out.println("KAADM03Service codeList called..");
        return kAADM03DAO.codeList();
    }

    // 설정>사용자권한 리스트조회
    public List<KAADM03VO> srchCodeList(Map<String, Object> map) {
        System.out.println("KAADM03Service srchCodeList called..");
        return kAADM03DAO.srchCodeList(map);
    }

    // 설정>사용자권한 등록
    public int write(KAADM03VO kAADM03VO) {
        System.out.println("KAADM03Service write called..");
        return kAADM03DAO.write(kAADM03VO);
    }

    // 설정>사용자권한 수정
    public int modify(List<KAADM03VO> list) {
        System.out.println("KAADM03Service modify called..");
        return kAADM03DAO.modify(list);
    }

    // 설정>사용자권한 삭제
    public int delete(List<KAADM03VO> list) {
        System.out.println("KAADM03Service delete called..");
        return kAADM03DAO.delete(list);
    }
    

}