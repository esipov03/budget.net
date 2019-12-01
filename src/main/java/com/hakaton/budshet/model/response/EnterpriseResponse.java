package com.hakaton.budshet.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseResponse {
    private int id;

    private String name;

  private  List<EnterpriseResponseProcessField> processes;

    public EnterpriseResponse() {
        processes = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnterpriseResponseProcessField> getProcesses() {
        return processes;
    }

    public void setProcesses(List<EnterpriseResponseProcessField> processes) {
        this.processes = processes;
    }
}





