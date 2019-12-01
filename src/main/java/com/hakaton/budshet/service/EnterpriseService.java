package com.hakaton.budshet.service;

import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.model.response.EnterpriseResponse;
import com.hakaton.budshet.repository.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public ResponseEntity<EnterpriseResponse> getEnterpriseById(int enterpriseId){
        Enterprise enterprise = enterpriseRepository.findById(enterpriseId).get();
        EnterpriseResponse response = new EnterpriseResponse();
        if(enterprise!=null){


        } else {
            return  ResponseEntity.notFound().build();
        }

       return ResponseEntity.ok(response);

    }



}
