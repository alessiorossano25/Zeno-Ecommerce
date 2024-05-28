package com.azienda.eCommerce.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class StoricoAcquisti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//private LocalDate oraDataAcquisto;
	private Float prezzoTotale;
	
	@OneToMany(mappedBy = "storicoAcquisto")
	private List<ProdottoAcquistato>prodottiAcquistati=new ArrayList<>();
	
	@OneToOne 
	@JoinColumn(name = "id_utente")
	private Utente utente;

	public StoricoAcquisti() {
		super();
		//this.oraDataAcquisto=LocalDate.now();
		this.prezzoTotale = 0f;
	}
	
	public StoricoAcquisti(Utente utente) {
		super();
		this.utente = utente;
	//	this.oraDataAcquisto=LocalDate.now();
		this.prezzoTotale = 0f;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public LocalDate getOraDataAcquisto() {
		return oraDataAcquisto;
	}

	public void setOraDataAcquisto(LocalDate oraDataAcquisto) {
		this.oraDataAcquisto = oraDataAcquisto;
	}*/

	public Float getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(Float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public List<ProdottoAcquistato> getProdottiAcquistati() {
		return prodottiAcquistati;
	}

	public void setProdottiAcquistati(List<ProdottoAcquistato> prodottiAcquistati) {
		this.prodottiAcquistati = prodottiAcquistati;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@Override
	public String toString() {
		return "StoricoAcquisti [id=" + id +  ", prezzoTotale=" + prezzoTotale
				+ ", prodottiAcquistati=" + prodottiAcquistati + ", utente=" + utente + "]";
	}
	
}
