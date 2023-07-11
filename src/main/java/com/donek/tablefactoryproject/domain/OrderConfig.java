package com.donek.tablefactoryproject.domain;

import com.donek.tablefactoryproject.service.OrdersDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OrdersDeserializer.class)
public abstract class OrderConfig {
    private String material;
    private String color;
    private Integer width;
    private Integer height;

    public OrderConfig() {
    }
    @JsonCreator
    public OrderConfig(String material, String color, Integer width, Integer height) {
        this.material = material;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
