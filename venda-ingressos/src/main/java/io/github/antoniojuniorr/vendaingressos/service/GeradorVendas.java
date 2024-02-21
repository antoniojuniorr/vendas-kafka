package io.github.antoniojuniorr.vendaingressos.service;

import io.github.antoniojuniorr.vendaingressos.model.Venda;
import io.github.antoniojuniorr.vendaingressos.serializer.VendaSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class GeradorVendas {

    private static Random rand = new Random();
    private static long operacao = 0;
    private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());

        try (KafkaProducer<String, Venda> producer = new KafkaProducer<>(properties)) {
            while (true) {
                Venda venda = gerarVenda();
                ProducerRecord<String, Venda> record = new ProducerRecord<>("venda-ingressos", venda);
                producer.send(record);
                Thread.sleep(200);
            }
        }
    }

    private static Venda gerarVenda() {
        long cliente = rand.nextLong();
        int qtdIngressos = rand.nextInt();

        return new Venda(operacao++, cliente, qtdIngressos, valorIngresso.multiply(BigDecimal.valueOf(qtdIngressos)));
    }
}
