package com.izt.common.file;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FileDao {
    @Autowired
    SqlSession sqlSession;

    // 파일 정보를 db에 저장
    public void fileInsert(FileVo fileVo){
        // System.out.println("fild_id : " + fileVo.getFile_id());
        // System.out.println("post_type : " + fileVo.getPost_type());
        // System.out.println("post_id : " + fileVo.getPost_id());
        // System.out.println("org_file_name : " + fileVo.getOrg_file_name());
        // System.out.println("save_file_name : " + fileVo.getSave_file_name());
        // System.out.println("file_ext_name : " + fileVo.getFile_ext_name());
        // System.out.println("file_size : " + fileVo.getFile_size());
        sqlSession.insert("File.insert", fileVo);
        
    }
    // 게시물에 업로드된 파일 리스트 가져오기
    // postId -> 게시물 아이디
	public List<FileVo> getList(String postId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("postId", postId);
        return sqlSession.selectList("File.getList", map);
	}
	public void delFile(String file_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("file_id", file_id);
        sqlSession.delete("File.delete", map);
	}
}