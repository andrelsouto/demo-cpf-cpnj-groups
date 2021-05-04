package com.example.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class CollectionSerializer extends StdSerializer<AbstractCollection> {

    public CollectionSerializer() {
        super(AbstractCollection.class);
    }

    @Override
    public void serialize(AbstractCollection collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (Objects.isNull(collection)) {
            jsonGenerator.writeObject(Collections.EMPTY_LIST);
        } else {
            jsonGenerator.writeObject(collection.toArray());
        }
    }
}
