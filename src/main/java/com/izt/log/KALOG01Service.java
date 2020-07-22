package com.izt.log;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.izt.common.mail.EmailMessage;
import com.izt.common.mail.MailService;

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

    @Autowired
    MailService mailService;

    // 회원가입
    public void signUp(KALOG01VO KALOG01VO) {
        System.out.println("회원가입 서비스 " + KALOG01VO.toString());
        // DB 저장 전 비밀번호 암호화
        String hashPassword = BCrypt.hashpw(KALOG01VO.getUser_pw(), BCrypt.gensalt());
        KALOG01VO.setUser_pw(hashPassword);
        System.out.println("암호화 된 비밀번호는 ? " + hashPassword);
        KALOG01DAO.signUp(KALOG01VO);
    }

    // 로그인
    public Map<String, String> login(String user_id, String user_pw) {
        System.out.println("로그인 서비스 도착");
        Map<String, String> map = new HashMap<String, String>();
        KALOG01VO KALOG01VO = null;
        KALOG01VO = KALOG01DAO.checkId(user_id);
        if (KALOG01VO == null) {
            map.put("msg", "아이디 없거나 계정 잠김");
            return map;
            // return "아이디 없거나 계정 잠김";
        } else {
            boolean checkPw = BCrypt.checkpw(user_pw, KALOG01VO.getUser_pw());
            if (checkPw) {
                String token = generateToken(KALOG01VO);
                map.put("token", token);
                return map;
            } else {
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

    // 로그인 잠금 계정 확인
    public String selectCount(String user_id) {
        int num = KALOG01DAO.selectCount(user_id);
        if (num >= 5) {
            KALOG01DAO.loginRock(user_id);
            return "계정 잠김";
        }
        return "비밀번호 틀림";
    }

    // 계정 잠금 여부 확인
    public boolean selectLock(String user_id) {
        String lockYN = KALOG01DAO.selectLock(user_id);
        if (lockYN == "Y") {
            return true;

        }
        return false;
    }

    // 토큰 발급
    public String generateToken(KALOG01VO KALOG01VO) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1); // 만료일 1일
        String key = "ScretKey";
        Claims claims = Jwts.claims().setIssuedAt(new Date()).setExpiration(new Date(cal.getTimeInMillis())); // 만료일 설정

        // payload
        claims.put("user_id", KALOG01VO.getUser_id());
        claims.put("user_name", KALOG01VO.getUser_name());
        claims.put("user_type", KALOG01VO.getUser_type());
        claims.put("company", KALOG01VO.getCompany());
        claims.put("solution", KALOG01VO.getSolution());
        claims.put("dept", KALOG01VO.getDept());

        String token = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, key).compact();

        return token;
    }

    // 아이디 중복 체크
    public int idCheck(String user_id) {
        System.out.println("idCheck 서비스 도착");
        int count = KALOG01DAO.idCheck(user_id);

        return count;
    }

    // 솔루션 리스트 가져오기
    public List<Map<String, String>> getSolution() {
        return KALOG01DAO.getSolution();
    }

    // 비밀번호 찾기
    public String searchPassword(String user_id) throws AddressException, MessagingException, IOException {
        KALOG01VO KALOG01VO = new KALOG01VO();
        KALOG01VO.setUser_id(user_id);

        int count = KALOG01DAO.idCheck(KALOG01VO.getUser_id());
        if(count == 1){ //존재하는 이메일이면 임시비밀번호 디비에 새로 저장 후 이메일 발송
         String newPassword = randomPassword();
         System.out.println("새로 발급한 비밀번호" + newPassword);
         String hashPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
         
         //암호화된 비밀번호 set
         KALOG01VO.setUser_pw(hashPassword);
         System.out.println("암호화 된 비밀번호는 ? " + hashPassword);
         KALOG01DAO.updatePassword(KALOG01VO); //DB에 비밀번호 변경 

         EmailMessage emailMessage = new EmailMessage();
         emailMessage.setBody("안녕하세요. 솔루션지식자산화시스템입니다. <br />" + "회원님의 비밀번호 찾기를 통해 새로운 비밀번호를 지급해 드립니다. <br />"
         + "로그인 후, 비밀번호 변경 서비스를 이용하시기 바랍니다.<br /><br />" + "새 비밀번호 : " + newPassword + "<br/> <br/> 감사합니다.");
         
         emailMessage.setSubject("솔루션지식자산화시스템 패스워드 변경 요청");
         emailMessage.setTo_address(user_id); //user 이메일 user_id로 바꿔야함
         mailService.sendmail(emailMessage);//메일 발송
        
         return "이메일 전송 완료";
        }else{
        return "존재하지 않는 이메일 입니다.";
        }
    }
    //임시 비밀번호 발급
    public static String randomPassword() {
        int index = 0;
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
                'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            index = (int) (charSet.length * Math.random());
            sb.append(charSet[index]);
        }
        return sb.toString();
    }

    
}