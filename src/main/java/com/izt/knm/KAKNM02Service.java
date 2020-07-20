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
	
	// 내가 답변한 리스트
	public List<KAKNM02VO> getList(String title, String status, String user) {
        System.out.println("KAKNM02Service searchList");
		return kAKNM02DAO.getList(title, status, user);
	}
	// 답변 가져오기
	public List<KAKNM02VO> getAnswer(String answer_id) {
		System.out.println("KAKNM02Service getAnswer Called...!!");
		return kAKNM02DAO.getAnswer(answer_id);
	}
	// 답변하기 (+수정)
	public int postWrite(KAKNM02VO kAKNM02VO) {
		System.out.println("KAKNM02 << Service >> postWrite Called...!!");
		// 태그를 # 단위로 분리해서 배열로 저장
		String [] tag = tag(kAKNM02VO.getContent_t());
		
		// 답변작성이라면
		if(kAKNM02VO.getDo_type().equals("W")){
			// answer id 생성
			kAKNM02VO.setAnswer_id(createTbIdService.createPkId("AN"));
			// answer insert
			kAKNM02DAO.postWrite(kAKNM02VO);
		}
		// 수정이라면 (answer id 생성할 필요 없음)
		else if(kAKNM02VO.getDo_type().equals("M")){
			// 예전 태그 지우기
			kAKNM02DAO.delTag(kAKNM02VO);
			// 수정하기
			kAKNM02DAO.modify(kAKNM02VO);
		}

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

	// 태그 분리하기
	public String[] tag(String Stag) {
		System.out.println("KAKNM02Service tag Called...!!");
		String t1 = Stag.replaceAll(" ", "");
		String t2 = t1.replaceAll(",", "");
		String [] arr = t2.split("#");
		return arr;
	}
    
}