package br.pos.unipe.unipeJet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Voo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String origem;
	@OneToOne
	@JoinColumn(name = "aircraft_id")
	private Aeronave aeronave;
	public Voo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public 	Voo(String origem){
		this.origem = origem;
	}
	public Voo(String origem, Aeronave aeronave) {
		super();
		this.origem = origem;
		this.aeronave = aeronave;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Aeronave getAeronave() {
		return aeronave;
	}
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	
	
	
	
	
	
	
	
}
