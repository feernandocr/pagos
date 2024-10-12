package com.banco.base.pagosbase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImpl implements KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerImpl.class);

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public void enviarMensaje(String topico, String mensaje) {
        logger.info("Enviando mensaje al tópico {}: {}", topico, mensaje);
        kafkaTemplate.send(topico, mensaje);
	}
}
