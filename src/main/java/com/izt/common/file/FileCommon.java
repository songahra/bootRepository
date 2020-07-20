/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : FileCommon.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 17 신예은 최초작성
 * -------------------------------
 */
package com.izt.common.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.izt.common.CreateTbIdService;

@Service
public class FileCommon {
    // 파일이 저장될 위치
    private static final String SAVE_PATH = "src\\main\\java\\com\\izt\\common\\file\\fileStore";

    @Autowired
    private CreateTbIdService createId;
    @Autowired
	private FileDao fileDao;
    
    // 파일 저장
    // db에 들어갈 file_id와 물리적으로 저장될 파일 이름을 일치시켰음 (파일 이름 중복 방지)
    // id 생성은 createPkId 사용
    public void fileStore(MultipartFile multipartfile, String postType, String postId) throws FileUploadException {
        System.out.println("<< file Store >>");
        System.out.println(multipartfile);
        System.out.println("postType : " + postType);
        System.out.println("postId : " + postId);
        try {
            // 저장될 파일 정보 생성
            FileVo fileVo = new FileVo();
            String orgFileName = multipartfile.getOriginalFilename();
            String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.') + 1, orgFileName.length());
            String fileSize = Long.toString(multipartfile.getSize());
            String fileId = createId.createPkId("FI");
            String saveFileName = fileId + "." + fileExtName;

            // 저장될 파일 정보 입력
            fileVo.setFile_path(writeFile(multipartfile, saveFileName));
            fileVo.setOrg_file_name(orgFileName);
            fileVo.setSave_file_name(saveFileName);
            fileVo.setFile_ext_name(fileExtName);
            fileVo.setFile_id(fileId);
            fileVo.setPost_type(postType);
            fileVo.setPost_id(postId);
            fileVo.setFile_size(fileSize);

            // 입력된 파일 정보 저장
            fileDao.fileInsert(fileVo);

        } catch (IOException ex){
            throw new FileUploadException();
        }
    }
    
    // 파일을 물리적 저장 공간에 저장
    private String writeFile(MultipartFile multipartfile, String saveFileName) throws IOException{
        byte[] fileData = multipartfile.getBytes();
        String path = SAVE_PATH + "/" + saveFileName;
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(fileData);
        fos.close();
        return path;
    }

    // 게시물에 업로드된 파일 리스트 가져오기
	public List<FileVo> getList(String postId) {
		return fileDao.getList(postId);
	}
}