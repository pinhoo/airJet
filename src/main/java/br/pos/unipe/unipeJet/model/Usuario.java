package br.pos.unipe.unipeJet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class Usuario {
	

	@NotNull
	private String nome;
	
	@NotNull
	private String documento;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	private String cartaoMilhas;
	
	@Id
	@NotNull
	private String username;
	
	@NotNull
	@Min(6)
	@Column(name = "password")
	private String senha;
	
	@OneToOne(mappedBy = "usuario")
	private Pedido pedido;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Usuario(String nome, String documento, Date dataNascimento, String cartaoMilhas, String username,
			String senha) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.dataNascimento = dataNascimento;
		this.cartaoMilhas = cartaoMilhas;
		this.username = username;
		this.senha = senha;
	}



	public Usuario(String nome, String documento, Date dataNascimento, String cartaoMilhas, String username,
			String senha, Voo voo) {
		super();

		this.nome = nome;
		this.documento = documento;
		this.dataNascimento = dataNascimento;
		this.cartaoMilhas = cartaoMilhas;
		this.username = username;
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCartaoMilhas() {
		return cartaoMilhas;
	}

	public void setCartaoMilhas(String cartaoMilhas) {
		this.cartaoMilhas = cartaoMilhas;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
