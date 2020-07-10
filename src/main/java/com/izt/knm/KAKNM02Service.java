/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM01Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신동경   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAKNM02Service {
    @Autowired
    private KAKNM02DAO kAKNM02DAO;

	public List<KAKNM02VO> getList(String title, String status, String user) {
        System.out.println("KAKNM02Service searchList");
		return kAKNM02DAO.getList(title, status, user);
	}

	public void postWrite(KAKNM02VO KAKNM02VO) {
	}
    
    
}