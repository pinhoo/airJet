package br.pos.unipe.unipeJet.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="aircraft")
public class Aeronave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aircraft")
	private Long id;
	
	@NotNull
	private String modelo;
	
	@Column(name = "num_assentos")
	@NotNull
	private int numAssentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumAssentos() {
		return numAssentos;
	}

	public void setNumAssentos(int numAssentos) {
		this.numAssentos = numAssentos;
	}
	
	
}
