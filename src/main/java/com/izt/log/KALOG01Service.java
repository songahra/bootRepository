package com.izt.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KALOG01Service {
    @Autowired
    KALOG01DAO KALOG01DAO;

    public KALOG01VO test(){
        return KALOG01DAO.test();
    }
}