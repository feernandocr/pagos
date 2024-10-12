package com.banco.base.pagosbase.entity;

import com.banco.base.pagosbase.utileria.EstatusPago;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pago")
public class PagoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago") // Mapeamos el campo idPago a la columna idPago
	private Long idPago;

	@Column(name = "cantidadProductos")
	private int cantidadProductos;

	@Column(name = "remitente")
	private String remitente;

	@Column(name = "receptor")
	private String receptor;

	@Column(name = "monto")
	private double monto;
	
	@Column(name = "concepto")
	private String concepto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estatus")
	private EstatusPago estatus;

	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
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
