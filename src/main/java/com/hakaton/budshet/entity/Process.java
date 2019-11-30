package com.hakaton.budshet.entity;

import org.apache.tomcat.jni.Proc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;


    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @Temporal(TemporalType.DATE)
    private Date dateStartFact;

    @Temporal(TemporalType.DATE)
    private Date dateEndFact;


    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateApproval() {
        return dateApproval;
    }

    public void setDateApproval(Date dateApproval) {
        this.dateApproval = dateApproval;
    }

    public StatusDocument getStatusDocument() {
        return statusDocument;
    }

    public void setStatusDocument(StatusDocument statusDocument) {
        this.statusDocument = statusDocument;
    }

    public Enterprise getFounderEnterprise() {
        return founderEnterprise;
    }

    public void setFounderEnterprise(Enterprise founderEnterprise) {
        this.founderEnterprise = founderEnterprise;
    }

    public Enterprise getExecutorEnterprise() {
        return executorEnterprise;
    }

    public void setExecutorEnterprise(Enterprise executorEnterprise) {
        this.executorEnterprise = executorEnterprise;
    }



    @Temporal(TemporalType.DATE)

    private Date dateApproval;

    @ManyToMany
    private List<Process>  previousProcess;

    @ManyToOne
    private StatusDocument statusDocument;

    @ManyToOne
    private Enterprise founderEnterprise;

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    @ManyToOne
    private Enterprise executorEnterprise;

    @ManyToOne
    private TypeDocument typeDocument;

    @ManyToMany
    private List<Process> nextProcess;

        public Process() {
        this.nextProcess = new ArrayList<>();
        this.previousProcess =  new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStartFact() {
        return dateStartFact;
    }

    public void setDateStartFact(Date dateStartFact) {
        this.dateStartFact = dateStartFact;
    }

    public Date getDateEndFact() {
        return dateEndFact;
    }

    public void setDateEndFact(Date dateEndFact) {
        this.dateEndFact = dateEndFact;
    }

    public List<Process> getNextProcess() {
        return nextProcess;
    }

    public void setNextProcess(List<Process> nextProcess) {
        this.nextProcess = nextProcess;
    }

    public List<Process> getPreviousProcess() {
        return previousProcess;
    }

    public void setPreviousProcess(List<Process> previousProcess) {
        this.previousProcess = previousProcess;
    }




}
