package com.izt.prm;


import com.izt.log.KALOG01VO;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAPRM01Controller.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.07.01  송아라      최초작성
 * ------------------------------------------------------
 *
 */
@Service
public class KAPRM01Service {
    @Autowired
    KAPRM01DAO KAPRM01DAO;
    
    //비밀번호 변경
    public void updatePassword(KALOG01VO KALOG01VO){
     String updatedPassword = BCrypt.hashpw(KALOG01VO.getUser_pw(), BCrypt.gensalt()); 
     System.out.println("updatedPassword 패스워드는 ? " + updatedPassword);
     KAPRM01DAO.updatedPassword(updatedPassword);
    }
}