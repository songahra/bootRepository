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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.izt.common.CreateTbIdService;

@Service
public class FileCommon {
    // 파일이 저장될 위치
    private static final String SAVE_PATH = "src\\main\\java\\com\\izt\\common\\file\\fileStore";

    @Autowired
    private CreateTbIdService createId;
    @Autowired
	private FileDao fileDao;
    
    // 여러개의 파일을 하나씩 나누어 저장하도록 함
    public int write(FileVo file) {
        System.out.println("File Write called...");
        // 업로드할 파일들을 배열로 저장
        MultipartFile [] m = file.getAttachFile();

        // 파일 하나씩 저장
        for(int i=0;i<m.length;i++){
            System.out.println("File Upload << " + i + " >>th");
            System.out.println(m[i].getOriginalFilename());
            fileStore(m[i], file.getPost_type(), file.getPost_id()); // 파일 저장
        }
        // 저장된 파일 갯수 리턴
        return m.length;
    }

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
    // 파일 지우기
	public void delFile(String file_id, String file_name) {
        System.out.println("Real file delete Common");
        System.out.println(SAVE_PATH+"\\"+file_name);
        File file = new File(SAVE_PATH+"\\"+file_name);
        file.delete();
        fileDao.delFile(file_id);
	}
    
    // 파일 다운로드
    // public void download(HttpServletResponse response,
    //                      String fileSName) {
    //     String fileName = fileSName.substring(0, fileSName.length()-1);
    //     System.out.println("download called : "+fileName);

    //     try {
    //         File file = new File("src\\main\\java\\com\\izt\\common\\file\\fileStore\\"+fileName); // 경로에서 파일을 가져온다.
    //         Files.copy(file.toPath(), response.getOutputStream()); // 파일 복사.
    //         String mimeType = URLConnection.guessContentTypeFromName(file.getName()); // 파일 타입을 가져온다
    //         String contentDisposition = String.format("attachment; filename=%s", file.getName()); // 셋팅중 하나....ㅎㅎ
    //         int fileSize = Long.valueOf(file.length()).intValue();
            
    //         response.setContentType(mimeType);
    //         System.out.println(response.getContentType());
    //         response.setHeader("Content-Disposition", contentDisposition); // 
    //         response.setContentLength(fileSize);
    //     }catch (FileNotFoundException e) {
    //         System.out.println(e);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}