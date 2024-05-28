package com.azienda.eCommerce.model;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class ProdottoAcquistato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Float prezzo;
	private Integer quantita;
	private LocalDate oraDataAcquisto;
	@ManyToOne
	@JoinColumn(name="id_storico_prodotti")
	private StoricoAcquisti storicoAcquisto;
	
	public ProdottoAcquistato(String nome, Float prezzo, Integer quantita) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.oraDataAcquisto=LocalDate.now();
	}

	public ProdottoAcquistato() {
		super();
		this.oraDataAcquisto=LocalDate.now();
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

	public StoricoAcquisti getStoricoAcquisto() {
		return storicoAcquisto;
	}

	public void setStoricoAcquisto(StoricoAcquisti storicoAcquisto) {
		this.storicoAcquisto = storicoAcquisto;
	}

	
	public LocalDate getOraDataAcquisto() {
		return oraDataAcquisto;
	}

	public void setOraDataAcquisto(LocalDate oraDataAcquisto) {
		this.oraDataAcquisto = oraDataAcquisto;
	}

	@Override
	public String toString() {
		return "ProdottoAcquistato [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", quantita=" + quantita
				+ ", storicoAcquisto=" + storicoAcquisto + "]";
	}
	
}
