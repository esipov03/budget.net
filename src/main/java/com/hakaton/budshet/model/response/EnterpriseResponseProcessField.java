package com.hakaton.budshet.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseResponseProcessField {
    private int id;

    private int founder;

    private Date dateCreate;

    private Date dateEnd;

    private List<Integer> nextProcesses;

    private List<Integer> previousProcesses;

    public EnterpriseResponseProcessField() {
        nextProcesses = new ArrayList<>();
        previousProcesses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFounder() {
        return founder;
    }

    public void setFounder(int founder) {
        this.founder = founder;
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


    public List<Integer> getNextProcesses() {
        return nextProcesses;
    }

    public void setNextProcesses(List<Integer> nextProcesses) {
        this.nextProcesses = nextProcesses;
    }

    public List<Integer> getPreviousProcesses() {
        return previousProcesses;
    }

    public void setPreviousProcesses(List<Integer> previousProcesses) {
        this.previousProcesses = previousProcesses;
    }
}
