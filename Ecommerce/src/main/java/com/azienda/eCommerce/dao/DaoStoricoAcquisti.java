package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.StoricoAcquisti;

public class DaoStoricoAcquisti implements DaoInterface<StoricoAcquisti>{
	private EntityManager manager;
	public DaoStoricoAcquisti(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public StoricoAcquisti create(StoricoAcquisti ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<StoricoAcquisti> retrieve() {
		return manager.createQuery("select p from p StoricoAcquisti x",StoricoAcquisti.class).getResultList();
		}

	@Override
	public StoricoAcquisti update(StoricoAcquisti ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(StoricoAcquisti ref) {
		manager.remove(ref);
	}
}
