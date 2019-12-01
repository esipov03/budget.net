package com.hakaton.budshet.service;

import com.hakaton.budshet.convertor.AdminProcessConverter;
import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.request.AdminEnterpriseRequest;
import com.hakaton.budshet.model.request.AdminProcessRequest;
import com.hakaton.budshet.model.response.AdminProcessResponse;
import com.hakaton.budshet.repository.EnterpriseRepository;
import com.hakaton.budshet.repository.ProcessRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    private AdminProcessConverter converter;

    public AdminService(){
        converter = new AdminProcessConverter();
    }


    public ResponseEntity<?> getProcess(){
        List<Process> processes = processRepository.findAll();
        List<AdminProcessResponse> response = converter.processConverter(processes);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> createProcess(AdminProcessRequest request){
        Process process = new Process();
        process.setStatusDocument(request.getStatusDocument());
        process.setNumber(request.getNumber());
        process.setDescription(request.getDescription());
        process.setDateEnd(request.getDateEnd());
        process.setDateCreate(request.getDateCreate());
        Enterprise founder = enterpriseRepository.getOne(request.getFounderEnterprise());
        Enterprise executor = enterpriseRepository.getOne(request.getExecutorEnterprise());
        List<Process> nextProcesses =  new ArrayList<>();
        request.getNextProcess().forEach(p->{
            Process nextProcess = processRepository.getOne(p);
            nextProcesses.add(nextProcess);
        });
        List<Process> previousProcesses  = new ArrayList<>();
        request.getPreviousProcess().forEach(p->{
            Process previousProcess = processRepository.getOne(p);
            previousProcesses.add(previousProcess);

        });

        process.setNextProcess(nextProcesses);
        process.setPreviousProcess(previousProcesses);
        process.setFounderEnterprise(founder);
        process.setExecutorEnterprise(executor);
        processRepository.save(process);
        return ResponseEntity.ok().build();

    }


    public ResponseEntity<List<Enterprise>> getAllEnterprise(){

        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return ResponseEntity.ok(enterprises);
    }

    public ResponseEntity<?> createNewEnterprise(AdminEnterpriseRequest request){
        Enterprise enterprise = enterpriseRepository.getEnterpriseByInn(request.getInn());
        if(enterprise==null){
            enterprise = new Enterprise(request);
            enterpriseRepository.save(enterprise);

        } else {
            return ResponseEntity.status(0).build();
        }

        return ResponseEntity.status(1).build();
    }
}
