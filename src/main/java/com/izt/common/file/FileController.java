/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : FileController.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 17 신예은 최초작성
 * -------------------------------
 */
package com.izt.common.file;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileCommon fileCommon;

    // 파일 업로드
    @PostMapping(value = "upload")
    public int write(FileVo file) {
        System.out.println("File Write called...");
        // 업로드할 파일들을 배열로 저장
        MultipartFile [] m = file.getAttachFile();

        // 파일 하나씩 저장
        for(int i=0;i<m.length;i++){
            System.out.println("File Upload << " + i + " >>th");
            System.out.println(m[i].getOriginalFilename());
            fileCommon.fileStore(m[i], file.getPost_type(), file.getPost_id());
        }
        // 저장된 파일 갯수 리턴
        return m.length;
    }

    // 해당 게시물의 파일 리스트 가져오기
    // postId -> 게시물 아이디
    @GetMapping(value="list")
    public List<FileVo> getList(@RequestParam(value="postId") String postId){
        List<FileVo> FileVo = fileCommon.getList(postId);
        return FileVo;
    }
}