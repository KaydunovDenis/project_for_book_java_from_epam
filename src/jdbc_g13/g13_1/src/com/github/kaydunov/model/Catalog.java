package com.github.kaydunov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Catalog extends Entity {

    @Builder
    public Catalog(Catalog parent, String name)
    {
        super(parent, name);
    }

    public Catalog(Long id, Catalog catalog, String name)
    {
        super(id, catalog, name);
    }
}
