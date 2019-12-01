package com.hakaton.budshet.model.response;

public class EnterpriseResponse {
    private int id;

    private String name;

    //Количество просроченных процессов
    private int overdueProcessesCount;

    private int waitProcessesCount;

    private int readyProcessesCount;

    //ИД родителя

    private int parentId;


    public EnterpriseResponse() {

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

    public int getOverdueProcessesCount() {
        return overdueProcessesCount;
    }

    public void setOverdueProcessesCount(int overdueProcessesCount) {
        this.overdueProcessesCount = overdueProcessesCount;
    }

    public int getWaitProcessesCount() {
        return waitProcessesCount;
    }

    public void setWaitProcessesCount(int waitProcessesCount) {
        this.waitProcessesCount = waitProcessesCount;
    }

    public int getReadyProcessesCount() {
        return readyProcessesCount;
    }

    public void setReadyProcessesCount(int readyProcessesCount) {
        this.readyProcessesCount = readyProcessesCount;
    }
}
