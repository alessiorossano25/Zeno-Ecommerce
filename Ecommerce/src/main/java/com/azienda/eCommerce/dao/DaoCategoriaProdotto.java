package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.CategoriaProdotto;
import com.azienda.eCommerce.model.Prodotto;

public class DaoCategoriaProdotto implements DaoInterface<CategoriaProdotto>{
	EntityManager manager;

	public DaoCategoriaProdotto(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public CategoriaProdotto create(CategoriaProdotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<CategoriaProdotto> retrieve() {
		return manager.createQuery("select cp from CategoriaProdotto cp",CategoriaProdotto.class).getResultList();
	}

	@Override
	public CategoriaProdotto update(CategoriaProdotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(CategoriaProdotto ref) {
		manager.remove(ref);
	}
	
	public List<Prodotto> searchByCategoria (String categoria){
		return manager.createQuery("select p from Prodotto p join p.categoria c where c.nome= :searchCaratteristica",Prodotto.class)
				.setParameter("searchCaratteristica", categoria).getResultList();
		//implementare se possibile la multi ricerca
	}
	
	public List<Prodotto> searchByCategoria2 (String categoria1, String categoria2){
		return manager.createQuery("select p from Prodotto p join p.categoria c where c.nome=:searchCaratteristica AND  c.nome=:searchCaratteristica2",Prodotto.class)
				.setParameter("searchCaratteristica", categoria1).setParameter("searchCaratteristica2", categoria2).getResultList();
		//implementare se possibile la multi ricerca
	}
}
