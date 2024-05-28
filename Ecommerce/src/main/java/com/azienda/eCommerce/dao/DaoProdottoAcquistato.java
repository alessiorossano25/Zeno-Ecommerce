package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.ProdottoAcquistato;
import com.azienda.eCommerce.model.StoricoAcquisti;

public class DaoProdottoAcquistato implements DaoInterface<ProdottoAcquistato>{
	
	private EntityManager manager;

	public DaoProdottoAcquistato(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public ProdottoAcquistato create(ProdottoAcquistato ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<ProdottoAcquistato> retrieve() {
		return manager.createQuery("select p from p ProdottoAcquistato x",ProdottoAcquistato.class).getResultList();
	}

	@Override
	public ProdottoAcquistato update(ProdottoAcquistato ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(ProdottoAcquistato ref) {
		manager.remove(ref);
	}
	
	public void addNelloStorico(ProdottoAcquistato prodotto, StoricoAcquisti storico) {
		prodotto.setStoricoAcquisto(storico);
		storico.getProdottiAcquistati().add(prodotto);
		storico.setPrezzoTotale(storico.getPrezzoTotale() + (prodotto.getPrezzo()* prodotto.getQuantita() ));
		manager.merge(prodotto);
	}
	
	
}
