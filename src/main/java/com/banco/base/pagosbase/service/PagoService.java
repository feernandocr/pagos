package com.banco.base.pagosbase.service;

import com.banco.base.pagosbase.dto.PagoDTO;
import com.banco.base.pagosbase.utileria.EstatusPago;

public interface PagoService {

	PagoDTO crearPago(PagoDTO pagoDTO);
	
	PagoDTO verificarEstatus(Long id);
	 
	PagoDTO cambiarEstatus(Long id, String nuevoEstatus);
	 
	 
}

