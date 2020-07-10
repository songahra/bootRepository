package com.izt.log;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class KALOG01Service {
    
    @Autowired
    KALOG01DAO KALOG01DAO;
    
    //회원가입 
    public void signUp(KALOG01VO KALOG01VO) {
        System.out.println("회원가입 서비스 " + KALOG01VO.toString());
        // DB 저장 전 비밀번호 암호화
        String hashPassword = BCrypt.hashpw(KALOG01VO.getUser_pw(), BCrypt.gensalt());
        KALOG01VO.setUser_pw(hashPassword);
        System.out.println("암호화 된 비밀번호는 ? " + hashPassword);
        KALOG01DAO.signUp(KALOG01VO);
    }

    public KALOG01VO test(){
        return KALOG01DAO.test();
    }

    //로그인
    public Map<String,String> login(String user_id,String user_pw) {
      System.out.println("로그인 서비스 도착");
      Map<String, String> map = new HashMap<String,String>();
      KALOG01VO KALOG01VO = null;
      KALOG01VO = KALOG01DAO.checkId(user_id);
     if(KALOG01VO == null){
         map.put("msg", "아이디 없거나 계정 잠김");
         return map;
        // return "아이디 없거나 계정 잠김";
     }else{
        boolean checkPw = BCrypt.checkpw(user_pw, KALOG01VO.getUser_pw());
        if(checkPw){
           String token = generateToken(KALOG01VO);
           map.put("token", token);
           return map;
        }else{
        KALOG01DAO.loginCnt(KALOG01VO.getUser_id());
        // int loginCnt = KALOG01DAO.selectCount(KALOG01VO.getUser_id());
        String msg = selectCount(KALOG01VO.getUser_id());
        map.put("msg", msg);
        return map;
        // if(loginCnt == 5){
        // KALOG01DAO.loginRock(KALOG01VO.getUser_id());
        // return "계정 잠김";
        // }
        // return "비밀번호 틀림";
        }
    
     }
    }

    //로그인 잠금 계정 확인
    public String selectCount(String user_id){
        int num = KALOG01DAO.selectCount(user_id);
        if(num >= 5){
            KALOG01DAO.loginRock(user_id);
            return "계정 잠김";
        }
        return "비밀번호 틀림";
    }

    //계정 잠금 여부 확인
    public boolean selectLock(String user_id){
         String lockYN = KALOG01DAO.selectLock(user_id);
         if(lockYN == "Y"){
            return true;
         }
         return false;
    }

    //토큰 발급
    public String generateToken(KALOG01VO KALOG01VO){
         Calendar cal = Calendar.getInstance();
         cal.add(Calendar.DATE,1); //만료일 1일
         String key = "ScretKey";
         Claims claims = Jwts.claims()
         .setIssuedAt(new Date())
         .setExpiration(new Date(cal.getTimeInMillis())); //만료일 설정

         //payload
         claims.put("user_id", KALOG01VO.getUser_id()); 
         claims.put("user_name", KALOG01VO.getUser_name()); 
         claims.put("user_type", KALOG01VO.getUser_type());
         claims.put("company", KALOG01VO.getCompany());
         claims.put("solution", KALOG01VO.getSolution());
         claims.put("dept", KALOG01VO.getDept());

         String token = Jwts.builder()
         .setHeaderParam("typ", "JWT")
         .setClaims(claims)
         .signWith(SignatureAlgorithm.HS512, key)
         .compact();

         return token;
    }
    
    //아이디 중복 체크
    public int idCheck(String user_id){
        System.out.println("아이디 중복체크 서비스 도착");
        int count = KALOG01DAO.idCheck(user_id);
        return count;
    }

    //솔루션 리스트 가져오기
    public List<Map<String,String>> getSolution(){
        return KALOG01DAO.getSolution();
    }
}