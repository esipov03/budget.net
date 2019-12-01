package com.hakaton.budshet.controller;

import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.service.ProcessService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    public ProcessController(ProcessService service){
        this.processService=service;
    }

    @RequestMapping("/enterprise")
    public ResponseEntity<List<Enterprise>> getEnterpriseByParamId(@RequestParam("paramId") String parentId){
        int parentIdInt = Integer.parseInt(parentId);
        return processService.getEnterpriseByParentId(parentIdInt);
    }

}
