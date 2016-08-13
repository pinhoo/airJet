package br.pos.unipe.unipeJet.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="flights")
public class Voo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String origem;
	private String destino;
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Date horaPartida;
	
	@DateTimeFormat(pattern="hh:mm")
	private java.util.Date duracao;
	private BigDecimal distancia;
	private BigDecimal precoPassagem;
	private int assentosOcupados;
	private String volta;
	@OneToOne
	@JoinColumn(name = "aircraft_id")
	private Aeronave aeronave;
	
	public Voo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voo(Long id, String origem, String destino, Date horaPartida, Date duracao, BigDecimal distancia,
			BigDecimal precoPassagem, int assentosOcupados, String volta) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.horaPartida = horaPartida;
		this.duracao = duracao;
		this.distancia = distancia;
		this.precoPassagem = precoPassagem;
		this.assentosOcupados = assentosOcupados;
		this.volta = volta;
	}

	public Voo(Long id, String origem, String destino, Date horaPartida, Date duracao, BigDecimal distancia,
			BigDecimal precoPassagem, int assentosOcupados, String volta, Aeronave aeronave) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.horaPartida = horaPartida;
		this.duracao = duracao;
		this.distancia = distancia;
		this.precoPassagem = precoPassagem;
		this.assentosOcupados = assentosOcupados;
		this.volta = volta;
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(BigDecimal precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

	public int getAssentosOcupados() {
		return assentosOcupados;
	}

	public void setAssentosOcupados(int assentosOcupados) {
		this.assentosOcupados = assentosOcupados;
	}

	public String getVolta() {
		return volta;
	}

	public void setVolta(String volta) {
		this.volta = volta;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	
	
	
}
