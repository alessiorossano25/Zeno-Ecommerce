package com.azienda.eCommerce.model;

import javax.persistence.*;
@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	@OneToOne(mappedBy = "utente",cascade =CascadeType.ALL)
	private Carrello carrello;
	
	@OneToOne
	(mappedBy = "utente",cascade = CascadeType.ALL)
	private StoricoAcquisti storicoAcquisti;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_utente")
	private TipoUtente tipoUtente;
	
	public Utente(String nome, String cognome, String email, String username, String password,TipoUtente tipoUtente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.carrello = new Carrello(this);
		this.storicoAcquisti = new StoricoAcquisti(this);
		this.tipoUtente = tipoUtente;
	}
	
	public Utente(String nome, String cognome, String email, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.carrello = new Carrello(this);
		this.storicoAcquisti = new StoricoAcquisti(this);
	}

	public Utente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}

	public StoricoAcquisti getStoricoAcquisti() {
		return storicoAcquisti;
	}

	public void setStoricoAcquisti(StoricoAcquisti storicoAcquisti) {
		this.storicoAcquisti = storicoAcquisti;
	}

	public TipoUtente getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(TipoUtente tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", username="
				+ username + ", password=" + password + ", carrello=" + carrello + ", storicoAcquisti="
				+ storicoAcquisti + ", tipoUtente=" + tipoUtente + "]";
	}
	
	
}
