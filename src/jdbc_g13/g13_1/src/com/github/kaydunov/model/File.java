package com.github.kaydunov.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class File extends Entity
{
    private int size;

    File(Catalog parent, String name, int size)
    {
        super(parent, name);
        this.size = size;
    }
}
