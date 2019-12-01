package com.hakaton.budshet.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hakaton.budshet.entity.Enterprise;
import com.hakaton.budshet.entity.Process;
import com.hakaton.budshet.model.data.AdminDataEnterprise;
import org.apache.tomcat.jni.Proc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessResponse {

    private int id;

    private String description;

    private String number;

    private Date dateCreate;

    private Date dateEnd;

    private List<Integer> previousProcess;

    private List<Integer> nextProcess;

    private int statusDocument;

    private AdminDataEnterprise founderEnterprise;

    private AdminDataEnterprise executorEnterprise;

    public ProcessResponse() {
    }

    public ProcessResponse(Process process) {
        previousProcess = new ArrayList<>();
        nextProcess = new ArrayList<>();
        this.dateCreate=process.getDateCreate();
        this.dateEnd=process.getDateEnd();
        this.description=process.getDescription();
        this.executorEnterprise = new AdminDataEnterprise(process.getExecutorEnterprise());
        this.founderEnterprise = new AdminDataEnterprise(process.getFounderEnterprise());
        this.id = process.getId();
        this.number = process.getNumber();

        process.getNextProcess().forEach(p->{
            this.nextProcess.add(p.getId());
        });

        process.getPreviousProcess().forEach(p->{
            this.previousProcess.add(p.getId());
        });

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getStatusDocument() {
        return statusDocument;
    }

    public void setStatusDocument(int statusDocument) {
        this.statusDocument = statusDocument;
    }

    public List<Integer> getPreviousProcess() {
        return previousProcess;
    }

    public void setPreviousProcess(List<Integer> previousProcess) {
        this.previousProcess = previousProcess;
    }

    public List<Integer> getNextProcess() {
        return nextProcess;
    }

    public void setNextProcess(List<Integer> nextProcess) {
        this.nextProcess = nextProcess;
    }

    public AdminDataEnterprise getFounderEnterprise() {
        return founderEnterprise;
    }

    public void setFounderEnterprise(AdminDataEnterprise founderEnterprise) {
        this.founderEnterprise = founderEnterprise;
    }

    public AdminDataEnterprise getExecutorEnterprise() {
        return executorEnterprise;
    }

    public void setExecutorEnterprise(AdminDataEnterprise executorEnterprise) {
        this.executorEnterprise = executorEnterprise;
    }
}
