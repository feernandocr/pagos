package com.banco.base.pagosbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.base.pagosbase.dto.PagoDTO;
import com.banco.base.pagosbase.entity.PagoEntity;
import com.banco.base.pagosbase.repository.PagoRepository;
import com.banco.base.pagosbase.utileria.EstatusPago;
import com.banco.base.pagosbase.utileria.PagoMapper;

@Service
public class PagoServiceImpl implements PagoService {

	@Autowired
	private PagoRepository pagoRepository;

	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public PagoDTO crearPago(PagoDTO pagoDTO) {
		PagoEntity pagoEntity = PagoMapper.INSTANCE.toEntity(pagoDTO);
		PagoEntity pagoGuardado = pagoRepository.save(pagoEntity);
		return PagoMapper.INSTANCE.toDto(pagoGuardado);
	}

	@Override
	public PagoDTO verificarEstatus(Long id) {
		PagoEntity pagoEntity = pagoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pago no encontrado"));

		// Mapea la entidad a DTO usando MapStruct
		return PagoMapper.INSTANCE.toDto(pagoEntity);
	}

	@Override
	public PagoDTO cambiarEstatus(Long id, String nuevoEstatus) {
		// Verifica si el pago existe
		PagoEntity pagoEntity = pagoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pago no encontrado"));
		
		// Validar si el nuevoEstatus es válido
        EstatusPago estatusPago;
        try {
            estatusPago = EstatusPago.valueOf(nuevoEstatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El estatus proporcionado no es válido.");
        }
        
		// Cambia el estatus en la entidad
		pagoEntity.setEstatus(estatusPago);

		// Guarda la entidad actualizada
		PagoEntity pagoActualizado = pagoRepository.save(pagoEntity);

		// Envía el mensaje a Kafka con el nuevo estatus
		kafkaProducer.enviarMensaje("pago-estatus",
				"El estatus del pago con ID " + id + " ha cambiado a " + estatusPago);

		// Mapea la entidad actualizada a DTO antes de devolverla
		return PagoMapper.INSTANCE.toDto(pagoActualizado);
	}
}
