/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKND01Service.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 30 신예은 최초작성
 * -------------------------------
 */
package com.izt.knd;

import java.util.List;

import com.izt.common.CreateTbIdService;
import com.izt.common.file.FileCommon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAKND01Service {
    @Autowired
	KAKND01DAO KAKND01DAO;

	@Autowired
	CreateTbIdService createTbIdService;
	
	@Autowired
    FileCommon FileCommon;

	public List<KAKND01VO> getList(String title, String solution) {
		return KAKND01DAO.getList(title, solution);
	}

	public void postWrite(KAKND01VO kAKND01VO) {
		String manual_id;
		if(kAKND01VO.getDo_type().equals("W")){
			manual_id = createTbIdService.createPkId("MA");
			System.out.println("manual : " + manual_id);
			kAKND01VO.setManual_id(manual_id);
			KAKND01DAO.postWrite(kAKND01VO);
		}else{
			manual_id=kAKND01VO.getManual_id();
			KAKND01DAO.modify(kAKND01VO);
		}

		if(kAKND01VO.getAttachFile() != null){
			for (int i = 0; i < kAKND01VO.getAttachFile().length; i++) {
				System.out.println("File Upload << " + i + " >>th");
				System.out.println(kAKND01VO.getAttachFile()[i].getOriginalFilename());
				FileCommon.fileStore(kAKND01VO.getAttachFile()[i], "M", manual_id);
			}
		}

	}

	public KAKND01VO getDetail(String manual_id, String type) {
		System.out.println(" GET DETAIL!! manual : " + manual_id);
		return KAKND01DAO.getDetail(manual_id, type);
	}

	public void delete(KAKND01VO kAKND01VO) {
		System.out.println("KAKND01SERVICE << DELETE >> CALLED!!!!!!"+ kAKND01VO.getManual_id());
		KAKND01DAO.delete(kAKND01VO);
	}
    
}