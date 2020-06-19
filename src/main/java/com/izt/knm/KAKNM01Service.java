package com.izt.knm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KAKNM01Service {
    @Autowired
    private KAKNM01DAO kAKNM01DAO;

    public List<KAKNM01VO> getList(){
        System.out.println("KAKNM01Service getList");
        return kAKNM01DAO.selectList();
    }
}
