/**
 * -------------------------------
 * PROJECT:AI기반 솔루션 지식자산화
 * NAME : KAKND01Controller.java
 * -------------------------------
 * REVERSION:
 * 2020. 07. 30 신예은 최초작성
 * -------------------------------
 */
package com.izt.knd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/KAKND01")
public class KAKND01Controller {
    @Autowired
    KAKND01Service KAKND01Service;
    KAKND01VO KAKND01VO;


    @GetMapping(value="getList")
    public List<KAKND01VO> getList(@RequestParam(value="title") String title,
                                   @RequestParam(value="solution") String solution){
        System.out.println("KAKND01CONTROLLER << GET LIST >> CALLED!!");                            
        List<KAKND01VO> KAKND01VO = KAKND01Service.getList(title, solution);
        return KAKND01VO;
    }

    @PostMapping(value="postManual")
    public void write (KAKND01VO KAKND01VO){
        System.out.println("KAKND01CONTROLLER << WRITE >> CALLED!!");
        KAKND01Service.postWrite(KAKND01VO);
    }

    @PostMapping(value="delete")
    public void delete (@RequestBody KAKND01VO KAKND01VO){
        System.out.println("KAKND01CONTROLLER << DELETE >> CALLED!!" + KAKND01VO.getManual_id());
        KAKND01Service.delete(KAKND01VO);
    }
    @GetMapping(value="getDetail")
    public KAKND01VO getDetail(@RequestParam(value="manual_id") String manual_id,
                               @RequestParam(value="type") String type){
        System.out.println("KAKND01CONTROLLER << GET DETAIL >> CALLED!! ");
        
        return KAKND01Service.getDetail(manual_id, type);
    }

    
}