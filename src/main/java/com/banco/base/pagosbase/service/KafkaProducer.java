package com.banco.base.pagosbase.service;

public interface KafkaProducer {

	void enviarMensaje(String topico, String mensaje);

}
