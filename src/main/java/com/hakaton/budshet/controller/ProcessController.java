package com.hakaton.budshet.controller;

import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.response.ProcessResponse;
import com.hakaton.budshet.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProcessController {

    @Autowired
    private ProcessService processService;

    public ProcessController(ProcessService service) {
        this.processService = service;
    }

    @RequestMapping("/enterprise")
    public ResponseEntity<?> getEnterpriseByParamId(@RequestParam("parentId") String parentId) {
        int parentIdInt = Integer.parseInt(parentId);
        return ResponseEntity.ok(processService.getEnterpriseByParentId(parentIdInt));
    }

    @RequestMapping("/process")
    public ResponseEntity<?> getProcessById(@RequestParam("id") String processId) {
        int processIdint = Integer.parseInt(processId);
        Process process = processService.getProcessById(processIdint);
        ProcessResponse processResponse = new ProcessResponse(process);
        return ResponseEntity.ok(processResponse);


    }
}
