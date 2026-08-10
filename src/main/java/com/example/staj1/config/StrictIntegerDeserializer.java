package com.example.staj1.config;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;

public class StrictIntegerDeserializer extends StdDeserializer<Integer> {

    public StrictIntegerDeserializer() {
        super(Integer.class);
    }

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt)
            throws JacksonException {

        if (p.currentToken() != JsonToken.VALUE_NUMBER_INT) {
            throw ctxt.weirdStringException(
                    p.getText(),
                    Integer.class,
                    "Değer sayı olmalıdır."
            );
        }

        return p.getIntValue();
    }
}