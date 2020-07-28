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

import com.izt.common.mail.MailService;
import com.izt.common.mail.EmailMessage;

@Service
public class KAKNM02Service {
    @Autowired
	private KAKNM02DAO kAKNM02DAO;
	@Autowired
	private CreateTbIdService createTbIdService;
	@Autowired
    private MailService mailService;
	
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
	public KAKNM02VO getModifyDetail(/*String question_id, */String answer_id) {
		System.out.println("KAKNM02Service << getModifyDetail >> Called...!!");
		return kAKNM02DAO.getModifyDetail(/*question_id,*/ answer_id);
	}
	// 답변 지우기
	public void delete(String answer_id) {
		KAKNM02VO kAKNM02VO = new KAKNM02VO();
		kAKNM02VO.setAnswer_id(answer_id);
		// 테그 지우기
		// kAKNM02DAO.delTag(kAKNM02VO);
		// 게시물 지우기
		kAKNM02DAO.delete(answer_id);
	}
	// 답변하기 (+수정)
	public int postWrite(KAKNM02VO kAKNM02VO) {
		System.out.println("KAKNM02 << Service >> postWrite Called...!!");
		// 태그를 # 단위로 분리해서 배열로 저장
		String [] tag = tag(kAKNM02VO.getContent_t());
		// email 발송 변수
		String user_id ="";
        String setSubject="";
		String setBody="";
		String title =kAKNM02VO.getTitle();
		user_id = kAKNM02VO.getReg_userid_tq();
		
		// 답변작성이라면
		if(kAKNM02VO.getDo_type().equals("W")){
			System.out.println("KAKNM02 Service postWrite >>> Post Called...!!");
			// answer id 생성
			kAKNM02VO.setAnswer_id(createTbIdService.createPkId("AN"));
			// answer insert
			kAKNM02DAO.postWrite(kAKNM02VO);
			// 질문자에게 이메일 발송
			System.out.println("이메일 발송 !!! " + user_id);
			setSubject = "[솔루션지식자산화시스템] 회원님의 질문에 답변이 등록되었습니다.";
			setBody = "안녕하세요. 솔루션지식자산화시스템입니다. <br />" 
						+ "회원님의 \"" + title + "\" 질문에 답변이 등록되었습니다. <br />"
						+ "확인부탁드립니다. 감사합니다.";
			sendMail(setSubject, setBody, user_id);
		}
		// 수정이라면 (answer id 생성할 필요 없음)
		else if(kAKNM02VO.getDo_type().equals("M")){
			System.out.println("KAKNM02 Service postWrite >>> Modify Called...!!");
			// 예전 태그 지우기
			kAKNM02DAO.delTag(kAKNM02VO);
			// 수정하기
			kAKNM02DAO.modify(kAKNM02VO);
			// setSubject = "[솔루션지식자산화시스템] 회원님의 질문의 답변이 수정되었습니다.";
			// setBody = "안녕하세요. 솔루션지식자산화시스템입니다. <br />" 
			// 			+ "회원님의 \"" + title + "\" 질문의 답변이 수정되었습니다. <br />"
			// 			+ "확인부탁드립니다. 감사합니다.";
			// sendMail(setSubject, setBody, user_id);
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

	// 메일전송
    public void sendMail(String setSubject, String setBody, String user_id){
        try {
         // 메일 전송
         EmailMessage emailMessage = new EmailMessage();
         emailMessage.setBody(setBody);
         
         emailMessage.setSubject(setSubject);
         emailMessage.setTo_address(user_id); //user 이메일 user_id로 바꿔야함

         mailService.sendmail(emailMessage); //메일 발송  
            
        } catch (Exception e) {
            //TODO: handle exception
          e.printStackTrace();
        }
    }
	
    
}