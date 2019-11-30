package com.hakaton.budshet.model.xml;

import java.util.Date;
import java.util.List;

public class ProcessXmlModel {


    private String InnFounder;
    private String InnExcecutor;
    private String Type;
    private String Status;
    private String Number;
    private String DateCreate;
    private String DateApproval;
    private String DateEnd;
    private List<Integer> ProcessNext;
    private List<Integer> ProcessPrevious;

    public List<Integer> getProcessNext() {
        return ProcessNext;
    }

    public void setProcessNext(List<Integer> processNext) {
        ProcessNext = processNext;
    }

    public List<Integer> getProcessPrevious() {
        return ProcessPrevious;
    }

    public void setProcessPrevious(List<Integer> processPrevious) {
        ProcessPrevious = processPrevious;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String dateEnd) {
        DateEnd = dateEnd;
    }

    public String getInnFounder() {
        return InnFounder;
    }

    public void setInnFounder(String innFounder) {
        InnFounder = innFounder;
    }

    public String getInnExcecutor() {
        return InnExcecutor;
    }

    public void setInnExcecutor(String innExcecutor) {
        InnExcecutor = innExcecutor;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(String dateCreate) {
        DateCreate = dateCreate;
    }

    public String getDateApproval() {
        return DateApproval;
    }

    public void setDateApproval(String dateApproval) {
        DateApproval = dateApproval;
    }
}
