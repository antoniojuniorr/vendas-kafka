package io.github.antoniojuniorr.vendaingressos.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.antoniojuniorr.vendaingressos.model.Venda;
import org.apache.kafka.common.serialization.Serializer;

public class VendaSerializer implements Serializer<Venda> {

    @Override
    public byte[] serialize(String s, Venda venda) {
        try {
            return new ObjectMapper().writeValueAsBytes(venda);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
