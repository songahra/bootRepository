/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAKNM02Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.18  신예은   최초작성
 * ------------------------------------------------------
 * */

package com.izt.knm;

import java.util.List;

import com.izt.common.CreateTbIdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAKNM02Service {
    @Autowired
	private KAKNM02DAO kAKNM02DAO;
	@Autowired
    private CreateTbIdService createTbIdService;

	public List<KAKNM02VO> getList(String title, String status, String user) {
        System.out.println("KAKNM02Service searchList");
		return kAKNM02DAO.getList(title, status, user);
	}

	public int postWrite(KAKNM02VO kAKNM02VO) {
		System.out.println("KAKNM02 << Service >> postWrite Called...!!");

		String [] tag = tag(kAKNM02VO.getContent_t());
		// for(int i=1; i<tag.length; i++){
		// 	System.out.println("tag["+i+"]=" +tag[i]);
		// }

		// answer id 생성
		kAKNM02VO.setAnswer_id(createTbIdService.createPkId("AN"));
		// answer insert
		kAKNM02DAO.postWrite(kAKNM02VO);

		// tag 갯수만큼 아이디 생성해서 넣어주기
		for(int i=1; i<tag.length; i++){
			// tag id 생성
			kAKNM02VO.setTag_id(createTbIdService.createPkId("TG"));
			// tag 값 저장
			kAKNM02VO.setContent_t(tag[i]);
			// tag insert
			kAKNM02DAO.postTag(kAKNM02VO);
		}

		return tag.length-1;
	}

	public String[] tag(String Stag) {
		System.out.println("KAKNM02Service tag Called...!!");
		String t1 = Stag.replaceAll(" ", "");
		String t2 = t1.replaceAll(",", "");
		String [] arr = t2.split("#");
		return arr;
	}
    
    
}