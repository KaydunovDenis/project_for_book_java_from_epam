package com.kaydunov.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public abstract class Entity implements Serializable
{
    private Integer id;
    private String name;

    protected Entity(){}

    protected Entity(String name)
    {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
