package com.banco.base.pagosbase.dto;

import com.banco.base.pagosbase.utileria.EstatusPago;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PagoDTO {

	private Long idPago;
	
	@NotBlank(message = "El concepto no puede estar vacío.")
    private String concepto;

    @Min(value = 1, message = "La cantidad de productos debe ser al menos 1.")
    private int cantidadProductos;

    @NotBlank(message = "El remitente no puede estar vacío.")
    private String remitente;

    @NotBlank(message = "El receptor no puede estar vacío.")
    private String receptor;

    @DecimalMin(value = "0.01", message = "El monto debe ser mayor que 0.")
    private double monto;
    
    @NotNull(message = "El estatus no puede estar vacío.")
    private EstatusPago estatus;
    
    public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public EstatusPago getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusPago estatus) {
		this.estatus = estatus;
	}
	
	

}
