package com.azienda.eCommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class TipoUtente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoUtente;
	@OneToMany(mappedBy = "tipoUtente")
	private List<Utente>utente=new ArrayList<>();
	
	public TipoUtente() {
		super();
	}

	public TipoUtente(String tipoUtente) {
		super();
		this.tipoUtente = tipoUtente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	public List<Utente> getUtente() {
		return utente;
	}

	public void setUtente(List<Utente> utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "TipoUtente [id=" + id + ", tipoUtente=" + tipoUtente + ", utente=" + utente + "]";
	}
	
	
	
}
