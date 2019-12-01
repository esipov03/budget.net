package com.hakaton.budshet.entity;

import com.hakaton.budshet.model.request.AdminEnterpriseRequest;

import javax.persistence.*;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String inn;

    private int parentId;

    public Enterprise() {
    }

    public Enterprise(AdminEnterpriseRequest request){
        this.name=request.getName();
        this.inn=request.getInn();
        this.parentId= request.getParentId();
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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
