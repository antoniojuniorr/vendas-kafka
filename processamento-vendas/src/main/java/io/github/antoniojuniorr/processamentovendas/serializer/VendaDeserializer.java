package io.github.antoniojuniorr.processamentovendas.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.antoniojuniorr.processamentovendas.model.Venda;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class VendaDeserializer implements Deserializer<Venda> {

    @Override
    public Venda deserialize(String s, byte[] venda) {
        try {
            return new ObjectMapper().readValue(venda, Venda.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
