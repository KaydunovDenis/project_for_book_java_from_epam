package com.github.kaydunov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
public class File extends Entity
{
    int size;

    @Builder
    public File(Catalog parent, String name, int size)
    {
        super(parent, name);
        this.size = size;
    }

    public File(Long id, Catalog parent, String name, int size)
    {
        super(id, parent, name);
        this.size = size;
    }
}
