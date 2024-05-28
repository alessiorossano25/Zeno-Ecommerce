package com.azienda.eCommerce.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descrizione;
	private Float prezzo;
	private Integer quantita;
	private Blob immagine;
	private String nomeImmagine;
	
	
	@ManyToMany
	@JoinTable(name="Categoria_Prodotto",joinColumns = @JoinColumn(name="prodotto_id"),
	inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private List<CategoriaProdotto> categoria=new ArrayList<>();
	
	
	/*@ManyToMany(mappedBy = "prodottoCarrello",cascade = CascadeType.ALL)
	private List<Carrello> carrello=new ArrayList<>();*/
	
	@OneToMany(mappedBy="prodottiNelCarrello")
	private List<ProdottoNelCarrello> prodottoCarrello=new ArrayList<>();
	
	public Prodotto() {
		super();
	}

	public Prodotto(String nome, String descrizione, Float prezzo, Integer quantita, List<CategoriaProdotto> categorieProdotto) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.categoria = categorieProdotto;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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

	public List<CategoriaProdotto> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaProdotto> categoria) {
		this.categoria = categoria;
	}

	public List<ProdottoNelCarrello> getProdottoCarrello() {
		return prodottoCarrello;
	}

	public void setProdottoCarrello(List<ProdottoNelCarrello> prodottoCarrello) {
		this.prodottoCarrello = prodottoCarrello;
	}
	
	

	public Blob getImmagine() {
		return immagine;
	}

	public void setImmagine(Blob immagine) {
		this.immagine = immagine;
	}

	public String getNomeImmagine() {
		return nomeImmagine;
	}

	public void setNomeImmagine(String nomeImmagine) {
		this.nomeImmagine = nomeImmagine;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", quantita=" + quantita + ", categoria=" + categoria + ", prodottoCarrello=" + prodottoCarrello
				+ "]";
	}

	
	
	
}
