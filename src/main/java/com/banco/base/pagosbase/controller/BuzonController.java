package com.banco.base.pagosbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.base.pagosbase.service.BuzonKafka;

@RestController
@RequestMapping("/buzon")
public class BuzonController {

	@Autowired
	private BuzonKafka buzonKafka;

	@GetMapping("/mensajes")
	public ResponseEntity<List<String>> obtenerMensajesKafka() {
		List<String> mensajes = buzonKafka.obtenerMensajes();
		return ResponseEntity.ok(mensajes);
	}
}
