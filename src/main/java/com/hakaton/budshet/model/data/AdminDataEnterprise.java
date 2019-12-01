package com.hakaton.budshet.model.data;

import com.hakaton.budshet.entity.Enterprise;

public class AdminDataEnterprise {
    private int id;
    private String name;

    public AdminDataEnterprise(Enterprise enterprise) {
        this.id=enterprise.getId();
        this.name=enterprise.getName();
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
}
