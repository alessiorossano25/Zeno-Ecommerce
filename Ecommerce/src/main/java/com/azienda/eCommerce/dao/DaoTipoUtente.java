package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.TipoUtente;

public class DaoTipoUtente implements DaoInterface<TipoUtente>{

	EntityManager manager;
	
	 public DaoTipoUtente(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public TipoUtente create(TipoUtente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<TipoUtente> retrieve() {
		return manager.createQuery("select x from TipoUtente x",TipoUtente.class).getResultList();
	}

	@Override
	public TipoUtente update(TipoUtente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(TipoUtente ref) {
		manager.remove(ref);
	}
	
	public TipoUtente searchUser(String user){
		return manager.createQuery("select u from TipoUtente u where u.tipoUtente =:searchTipo",TipoUtente.class)
				.setParameter("searchTipo", user).getSingleResult();
	}
}
