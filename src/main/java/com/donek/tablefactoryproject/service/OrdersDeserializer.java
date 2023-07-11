package com.donek.tablefactoryproject.service;

import com.donek.tablefactoryproject.domain.OrderConfig;
import com.donek.tablefactoryproject.domain.TableConfig;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;

public class OrdersDeserializer extends JsonDeserializer<OrderConfig> {

    @Override
    public OrderConfig deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        String material = node.get("material").asText();
        String color = node.get("color").asText();
        Integer width = node.get("width").asInt();
        Integer height = node.get("height").asInt();
        boolean epoxyResin = node.get("epoxyResin").asBoolean();
        Integer rivers = node.get("rivers").asInt();
        return new TableConfig(material, color, width, height, epoxyResin, rivers);
    }
}
