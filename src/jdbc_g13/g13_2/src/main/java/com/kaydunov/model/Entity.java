package com.kaydunov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public abstract class Entity implements Serializable
{
    private Long id;
    private String name;

    protected Entity(){}

    protected Entity(String name)
    {
        this.name = name;
    }
}
