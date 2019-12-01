package com.hakaton.budshet.controller;

import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.model.request.AdminEnterpriseRequest;
import com.hakaton.budshet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController(AdminService service){
        this.adminService=service;
    }

    @GetMapping("/enterprise")
    public ResponseEntity<List<Enterprise>> getAllEnterprise(){
        return adminService.getAllEnterprise();
    }

    @PostMapping("/enterprise")
    public ResponseEntity<?> createEnterprise(@RequestBody AdminEnterpriseRequest request){
        return adminService.createNewEnterprise(request);
    }

    @GetMapping("/process")
    public ResponseEntity<?> getProcess(){
        return adminService.getProcess();
    }

}
