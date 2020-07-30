package com.izt.nti;

import java.util.List;

import com.izt.common.CreateTbIdService;
import com.izt.common.file.FileCommon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KANTI01Service {
    @Autowired
    KANTI01DAO KANTI01DAO;

    @Autowired
    FileCommon FileCommon;

    @Autowired
    private CreateTbIdService createTbIdService;


    // 공지사항 글 등록
    public void writeNotice(KANTI01VO KANTI01VO) {
        System.out.println("writeNotice 서비스 도착");
         // PK id값생성
         String notice_id = createTbIdService.createPkId("NT");
         KANTI01VO.setNotice_id(notice_id);
         System.out.println("KANTI01VO??" + KANTI01VO);
         KANTI01DAO.writeNotice(KANTI01VO);
        
        //파일 저장
        System.out.println("서비스에서 ? " + KANTI01VO.getAttachFile().length);
        for (int i = 0; i < KANTI01VO.getAttachFile().length; i++) {
            System.out.println("File Upload << " + i + " >>th");
            System.out.println(KANTI01VO.getAttachFile()[i].getOriginalFilename());
            FileCommon.fileStore(KANTI01VO.getAttachFile()[i], KANTI01VO.getPost_type(), notice_id);
        }
        
        // 저장된 파일 갯수 리턴
        int filecount = KANTI01VO.getAttachFile().length;
        System.out.println("filecount??" + filecount);
    }

    //공지사항 글 목록 조회
    public List<KANTI01VO> selectNotice(){
        List<KANTI01VO> list = KANTI01DAO.selectNotice();
        return list; 
    }
}