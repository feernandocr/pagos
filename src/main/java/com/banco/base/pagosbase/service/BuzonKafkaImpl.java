package com.banco.base.pagosbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuzonKafkaImpl implements BuzonKafka {

	@Autowired
	private KafkaConsumer kafkaConsumer;

	@Override
	public List<String> obtenerMensajes() {
		return kafkaConsumer.obtenerMensajes();
	}
}
