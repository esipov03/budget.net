package com.hakaton.budshet.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class TypeDocument {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public TypeDocument() {
    }

    private String name;

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
