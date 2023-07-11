package com.donek.tablefactoryproject.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class TableConfig extends OrderConfig {
    private boolean epoxyResin;
    private Integer rivers;

    public TableConfig() {
    }
    public TableConfig(String material, String color, Integer width, Integer height, boolean epoxyResin, Integer rivers) {
        super(material, color, width, height);
        this.epoxyResin = epoxyResin;
        this.rivers = rivers;
    }
}
