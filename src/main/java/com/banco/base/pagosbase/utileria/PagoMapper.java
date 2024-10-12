package com.banco.base.pagosbase.utileria;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.banco.base.pagosbase.dto.PagoDTO;
import com.banco.base.pagosbase.entity.PagoEntity;

@Mapper
public interface PagoMapper {

	PagoMapper INSTANCE = Mappers.getMapper(PagoMapper.class);

    // Mapea de DTO a entidad
    @Mapping(target = "idPago", ignore = true)  // Ignora el idPago al mapear el DTO a la entidad
    PagoEntity toEntity(PagoDTO pagoDTO);

    // Mapea de entidad a DTO
    PagoDTO toDto(PagoEntity pagoEntity);
}
