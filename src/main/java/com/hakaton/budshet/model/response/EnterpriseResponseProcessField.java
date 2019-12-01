package com.hakaton.budshet.model.response;

import java.util.ArrayList;
import java.util.Date;

public class EnterpriseResponseProcessField {
    private  int id;

    private int founder;

    private Date dateCreate;

    private Date dateEnd;

    private Integer[] nextProcesses;

    private Integer[] previousProcesses;

    public EnterpriseResponseProcessField() {
        nextProcesses = new Integer[]{};
        previousProcesses = new Integer[]{};
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

    public Integer[] getNextProcesses() {
        return nextProcesses;
    }

    public void setNextProcesses(Integer[] nextProcesses) {
        this.nextProcesses = nextProcesses;
    }

    public Integer[] getPreviousProcesses() {
        return previousProcesses;
    }

    public void setPreviousProcesses(Integer[] previousProcesses) {
        this.previousProcesses = previousProcesses;
    }
}
