package com.hakaton.budshet.model.request;

import java.util.Date;
import java.util.List;

public class AdminProcessRequest {

    private String description;

    private String number;

    private Date dateCreate;

    private Date dateEnd;

    private List<Integer> previousProcess;

    private List<Integer> nextProcess;

    private int statusDocument;

    private int founderEnterprise;

    private int executorEnterprise;

    public AdminProcessRequest() {
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

    public int getStatusDocument() {
        return statusDocument;
    }

    public void setStatusDocument(int statusDocument) {
        this.statusDocument = statusDocument;
    }

    public int getFounderEnterprise() {
        return founderEnterprise;
    }

    public void setFounderEnterprise(int founderEnterprise) {
        this.founderEnterprise = founderEnterprise;
    }

    public int getExecutorEnterprise() {
        return executorEnterprise;
    }

    public void setExecutorEnterprise(int executorEnterprise) {
        this.executorEnterprise = executorEnterprise;
    }
}
