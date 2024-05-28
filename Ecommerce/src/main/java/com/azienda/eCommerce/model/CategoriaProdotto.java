package com.azienda.eCommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class CategoriaProdotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToMany(mappedBy = "categoria")
	private List<Prodotto>prodotti=new ArrayList<>();
	
	public CategoriaProdotto() {
		super();
	}

	public CategoriaProdotto(String nome) {
		super();
		this.nome = nome;
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

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "CategoriaProdotto [id=" + id + ", nome=" + nome + ", prodotti=" + prodotti + "]";
	}
	
	
}
