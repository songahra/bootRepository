/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KADSB01Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.30 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.dsb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KADSB01Service {

    @Autowired
    private KADSB01DAO kADSB01DAO;

    // 설정>사용자권한 메인화면 리스트조회
    public List<KADSB01VO> main() {
        System.out.println("KADSB01Service main called..");
        return kADSB01DAO.main();
    }

    // 설정>사용자권한 메인화면 리스트조회
    public List<KADSB01VO> noticeList() {
        System.out.println("KADSB01Service main called..");
        return kADSB01DAO.noticeList();
    }
    
}