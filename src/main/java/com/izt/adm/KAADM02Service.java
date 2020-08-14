/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM02Service.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.24 신동경   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAADM02Service {

    @Autowired
    private KAADM02DAO kAADM02DAO;

    // 설정>사용자권한 메인화면 리스트조회
    public List<KAADM02VO> allUserList() {
        System.out.println("KAADM02Service allUserList called..");
        return kAADM02DAO.allUserList();
    }

    // 설정>사용자권한 메인화면 리스트조회
    public List<KAADM02VO> srchUserList(Map<String, Object> map) {
        System.out.println("KAADM02Service srchUserList called..");
        return kAADM02DAO.srchUserList(map);
    }

    // 설정>사용자권한 사용자정보수정
    public int modify(List<KAADM02VO> list) {
        System.out.println("KAADM02Service modify called..");


        for (int i = 0; i < list.size(); i++) { 
            String pw= BCrypt.hashpw(list.get(i).getUser_pw(), BCrypt.gensalt());
            list.get(i).setUser_pw(pw);
            // int cnt = (int)list.get(i).getLogin_cnt();
            System.out.print("-------After set----------- ");
          }

        return kAADM02DAO.updateUserInfo(list);
    }

    // 설정>사용자권한 사용자정보삭제
    public int delete(List<KAADM02VO> list) {
        System.out.println("KAADM02Service delete called..");
        return kAADM02DAO.deleteUserInfo(list);
    }
}