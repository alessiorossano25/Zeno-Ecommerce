package com.azienda.eCommerce.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Carrello {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name="id_utente")
	private Utente utente;
	private Float prezzoTot;



	/*@ManyToMany
	@JoinTable(name="ProdottoNelCarrello",joinColumns = @JoinColumn(name="carrello_id"),
	inverseJoinColumns = @JoinColumn(name="prodotto_id") )
	private List<Prodotto> prodottoCarrello=new ArrayList<>();*/

	@OneToMany(mappedBy="carrello")
	private List<ProdottoNelCarrello> prodottoCarrello=new ArrayList<>();

	public Carrello(Utente utente) {
		super();
		this.utente = utente;
		this.prezzoTot = 0f;
	}

	public Carrello() {
		super();
		this.prezzoTot = 0f;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}




	public List<ProdottoNelCarrello>  getProdottoNelCarrello() {
		return prodottoCarrello;
	}

	public void setProdottoNelCarrello(List<ProdottoNelCarrello> carrelloProdotto) {
		this.prodottoCarrello = carrelloProdotto;
	}

	public Float getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(Float prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	@Override
	public String toString() {
		return "Carrello [id=" + id + ", utente=" + utente + ", prezzoTot=" + prezzoTot + ", carrelloProdotto="
				+ prodottoCarrello + "]";
	}




}
