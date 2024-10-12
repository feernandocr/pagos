package com.banco.base.pagosbase.service;

import java.util.List;

public interface KafkaConsumer {

	void escucharMensaje(String mensaje);
	
	List<String> obtenerMensajes();
}
