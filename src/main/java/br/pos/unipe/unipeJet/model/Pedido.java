package br.pos.unipe.unipeJet.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int id;
	
	@Column(name = "num_passagens")
	private int numPassagem;
	
	private BigDecimal valorTotal;
	
	private int totalMilhas;
	
	@OneToOne
	@JoinColumn(name="flights_id_flight")
	private Voo voo;
	
	@OneToOne
	@JoinColumn(name = "user_username")
	private Usuario usuario;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int id, int numPassagem, BigDecimal valorTotal, int totalMilhas, Voo voo, Usuario usuario) {
		super();
		this.id = id;
		this.numPassagem = numPassagem;
		this.valorTotal = valorTotal;
		this.totalMilhas = totalMilhas;
		this.voo = voo;
		this.usuario = usuario;
	}

	public Pedido(int id, int numPassagem, BigDecimal valorTotal, int totalMilhas) {
		super();
		this.id = id;
		this.numPassagem = numPassagem;
		this.valorTotal = valorTotal;
		this.totalMilhas = totalMilhas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPassagem() {
		return numPassagem;
	}

	public void setNumPassagem(int numPassagem) {
		this.numPassagem = numPassagem;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getTotalMilhas() {
		return totalMilhas;
	}

	public void setTotalMilhas(int totalMilhas) {
		this.totalMilhas = totalMilhas;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
