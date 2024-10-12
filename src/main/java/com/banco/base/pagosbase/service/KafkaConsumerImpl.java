package com.banco.base.pagosbase.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);
    private final List<String> mensajes = new ArrayList<>();

    @KafkaListener(topics = "pago-estatus", groupId = "grupo-pagos")
	@Override
	public void escucharMensaje(String mensaje) {
    	logger.info("Mensaje recibido en el tópico 'pago-estatus': {}", mensaje);
        synchronized (mensajes) {
            mensajes.add(mensaje); // Guardamos el mensaje recibido
        }
	}
    
    public List<String> obtenerMensajes() {
        synchronized (mensajes) {
            return new ArrayList<>(mensajes); // Retorna una copia de la lista de mensajes
        }
    }

}
