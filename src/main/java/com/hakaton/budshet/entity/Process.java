package com.hakaton.budshet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

     private String description;

     private String number;

     private String comment;

    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    @Temporal(TemporalType.DATE)
    private Date dateStartFact;

    @Temporal(TemporalType.DATE)
    private Date dateEndFact;

    @Temporal(TemporalType.DATE)
    private Date dateApproval;

    @JsonIgnore
    @ManyToMany
    private List<Process>  previousProcess;

    private int statusDocument;

    @ManyToOne
    private Enterprise founderEnterprise;

    @ManyToOne
    private Enterprise executorEnterprise;

    @JsonIgnore
    @ManyToMany
    private List<Process> nextProcess;

        public Process() {
        this.nextProcess = new ArrayList<>();
        this.previousProcess =  new ArrayList<>();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Date getDateApproval() {
        return dateApproval;
    }

    public void setDateApproval(Date dateApproval) {
        this.dateApproval = dateApproval;
    }

    public List<Process> getPreviousProcess() {
        return previousProcess;
    }

    public void setPreviousProcess(List<Process> previousProcess) {
        this.previousProcess = previousProcess;
    }

    public int getStatusDocument() {
        return statusDocument;
    }

    public void setStatusDocument(int statusDocument) {
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

    public List<Process> getNextProcess() {
        return nextProcess;
    }

    public void setNextProcess(List<Process> nextProcess) {
        this.nextProcess = nextProcess;
    }
}
