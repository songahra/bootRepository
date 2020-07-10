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
	    SimpleDateFormat time = new SimpleDateFormat("hhmmsssss");
	    String pkId = flag + date.format(today) +    time.format(today);
	    
	    System.out.println(pkId);
	    System.out.println("Date: "+date.format(today));
	    System.out.println("Time: "+time.format(today));
        System.out.println(date.format(today) + time.format(today));
        
        return pkId;
    }
}