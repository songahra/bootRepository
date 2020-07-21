/**
 * ---------------------------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME   : CreateTbIdService.java
 * ----------------------------------------------------
 * REVERSION:
 * 2020. 07. 03 신동경 최초작성
 * 2020. 07. 10 신예은 수정(DateFormat 형식 변경)
 * ----------------------------------------------------
 */

package com.izt.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CreateTbIdService {
    
    public String createPkId (String flag){
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("hhmmssSSS");
		String pkId = flag + date.format(today) +    time.format(today);
		return pkId;
	}
}