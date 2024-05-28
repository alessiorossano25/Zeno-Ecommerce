package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoNelCarrello;


public class DaoProdottoNelCarrello implements DaoInterface<ProdottoNelCarrello>{

	private EntityManager manager;
	
	
	public DaoProdottoNelCarrello(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public ProdottoNelCarrello create(ProdottoNelCarrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<ProdottoNelCarrello> retrieve() {
		return manager.createQuery("select x from ProdottoNelCarrello x",ProdottoNelCarrello.class).getResultList();
	}

	@Override
	public ProdottoNelCarrello update(ProdottoNelCarrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(ProdottoNelCarrello ref) {
		manager.remove(ref);
	}

	public List<ProdottoNelCarrello> searchByProd(Prodotto prodotto){
		return manager.createQuery("select p from ProdottoNelCarrello p where p.nome= :searchCarrello",ProdottoNelCarrello.class)
				.setParameter("searchCarrello", prodotto.getNome()).getResultList();
		}
	
	public List<ProdottoNelCarrello> searchByProdId(Prodotto prodotto){
		return manager.createQuery("select p from ProdottoNelCarrello p where p.prodottiNelCarrello= :searchId",ProdottoNelCarrello.class)
				.setParameter("searchId", prodotto).getResultList();
		}
	
	public ProdottoNelCarrello searchById (Integer id) {
		return manager.createQuery("select p from ProdottoNelCarrello p where p.id= :searchId",ProdottoNelCarrello.class)
				.setParameter("searchId", id).getSingleResult();
		}
	
}
