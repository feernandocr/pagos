package com.banco.base.pagosbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.base.pagosbase.dto.EstatusNuevoDTO;
import com.banco.base.pagosbase.dto.PagoDTO;
import com.banco.base.pagosbase.service.PagoService;
import com.banco.base.pagosbase.utileria.EstatusPago;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagos")
public class PagoController {

	@Autowired
	private PagoService pagoService;

	// Crear un nuevo pago (usando DTO)
	@PostMapping("/altaPago")
	public ResponseEntity<?> crearPago(@Valid @RequestBody PagoDTO pagoDTO) {
		try {
			PagoDTO nuevoPago = pagoService.crearPago(pagoDTO);
			return ResponseEntity.ok(nuevoPago);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
		
	}

	// Verificar el estatus de un pago (devuelve el estatus)
	@GetMapping("/verificarEstatus/{id}")
	public ResponseEntity<String> verificarEstatus(@PathVariable Long id) {
		try {
			PagoDTO pago = pagoService.verificarEstatus(id);
			return ResponseEntity.ok(pago.getEstatus().toString());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	// Cambiar el estatus de un pago (usando DTO)
	@PutMapping("/cambiarEstatus/{id}")
	public ResponseEntity<?> cambiarEstatus(@PathVariable Long id, @RequestBody EstatusNuevoDTO nuevoEstatus) {
		try {
			PagoDTO pagoActualizado = pagoService.cambiarEstatus(id, nuevoEstatus.getEstatus());
			return ResponseEntity.ok(pagoActualizado);
		} catch (IllegalArgumentException re) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(re.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);

		}
		
	}
}
