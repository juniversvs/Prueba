package com.cibertec.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "idclie")
	private Integer idClie;
	
	@Column(name = "razon_soc")
	private String razonSoc;
	
	@Column(name = "nombre_ciudad")
	private String nombreCiudad;
	
	@Column(name = "direccion_Clie")
	private String direccionClie;
	
	private String telefono;
}
