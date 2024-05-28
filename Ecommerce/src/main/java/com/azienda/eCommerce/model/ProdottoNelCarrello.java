package com.azienda.eCommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProdottoNelCarrello {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Float prezzo;
	private Integer quantita;
	private Float prezzoTot;
	
	@ManyToOne
	@JoinColumn(name = "prodotto_id")
	private Prodotto prodottiNelCarrello;
	
	@ManyToOne
	@JoinColumn(name = "carrello_id")
	private Carrello carrello;
	
	
	public ProdottoNelCarrello() {
		super();
	}

	public ProdottoNelCarrello(String nome, Float prezzo, Integer quantita) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.prezzoTot = prezzo *quantita;
	}
	
	public ProdottoNelCarrello(Prodotto prodotto, Integer quantita) {
		super();
		this.nome = prodotto.getNome();
		this.prezzo = prodotto.getPrezzo();
		this.quantita = quantita;
		this.prezzoTot = prodotto.getPrezzo() *quantita;
		
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

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Float getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(Float prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public  Prodotto getProdottiNelCarrello() {
		return prodottiNelCarrello;
	}

	public void setProdottiNelCarrello(Prodotto prodottiNelCarrello) {
		this.prodottiNelCarrello = prodottiNelCarrello;
	}

	public Carrello getCarrelli() {
		return carrello;
	}

	public void setCarrelli(Carrello carrelli) {
		this.carrello = carrelli;
	}
	
	
	
}
