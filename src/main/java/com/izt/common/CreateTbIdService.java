package com.izt.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CreateTbIdService {
    
    public String createPkId (String flag){
		Date today = new Date();
	    System.out.println(today);
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

		// if(flag.equals("TG")){
		// 	SimpleDateFormat time = new SimpleDateFormat("hhmmssS");
		// 	String pkId = flag + date.format(today) +    time.format(today);
		// 	return pkId;
		// }else {	
			SimpleDateFormat time = new SimpleDateFormat("hhmmssSSS");
			String pkId = flag + date.format(today) +    time.format(today);
			return pkId;
		// }
	    
	    // System.out.println(pkId);
	    // System.out.println("Date: "+date.format(today));
	    // System.out.println("Time: "+time.format(today));
        // System.out.println(date.format(today) + time.format(today));
        
        // return pkId;
	}
}