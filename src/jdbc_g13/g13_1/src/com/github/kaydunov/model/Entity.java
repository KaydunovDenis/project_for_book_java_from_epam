package com.github.kaydunov.model;

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
    private Catalog parent;
    private String name;

    protected Entity(){}

    protected Entity(Catalog parent, String name)
    {
        this.parent = parent;
        this.name = name;
    }
}
