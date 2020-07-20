/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM04Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.24  신예은   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAADM04Service {
    @Autowired
    private KAADM04DAO kAADM04DAO;

    // 솔루션별 지식포인트 조회
    public List<KAADM04VO> getSolList(String sDate, String eDate) {
        System.out.println("KAADM04Service getSolList Called...");
        return kAADM04DAO.getSolList(sDate, eDate);
    }
    // 사용자별 지식포인트 조회
    public List<KAADM04VO> getUserList(String sDate, String eDate) {
        System.out.println("KAADMService getUserList Called...");
        return kAADM04DAO.getUserList(sDate, eDate);
    }

    // 선택된 솔루션의 지식포인트 조회
	public List<KAADM04VO> getPointSearchListSol(String sol, String type, String sDate, String eDate) {
        System.out.println("KAADMService getPointSearchListSol Called...");
		return kAADM04DAO.getPointSearchListSol(sol, type, sDate, eDate);
	}
    // 선택된 유저의 지식포인트 조회
	public List<KAADM04VO> getPointSearchListUser(String userId, String type, String sDate, String eDate) {
        System.out.println("KAADMService getPointSearchListUser Called...");
		return kAADM04DAO.getPointSEarchListUser(userId, type, sDate, eDate);
	}
    
}