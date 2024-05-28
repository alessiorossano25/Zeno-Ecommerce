package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoAcquistato;
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.StoricoAcquisti;
import com.azienda.eCommerce.model.Utente;

public class DaoUtente implements DaoInterface<Utente>{
	
	private EntityManager manager;
	
	public DaoUtente(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Utente create(Utente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Utente> retrieve() {
		return manager.createQuery("select x from Utente x",Utente.class).getResultList();
	}

	@Override
	public Utente update(Utente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Utente ref) {
		manager.remove(ref);
	}
	
	
	
	public List<Utente> searchByMail(String mail){
		return manager.createQuery("select u from Utente u where u.email =:searchMail",Utente.class)
				.setParameter("searchMail", mail.toLowerCase()).getResultList();
	}
	
	public List<Utente> searchByUsername(String userName){
		return manager.createQuery("select u from Utente u where u.username =:searchUser",Utente.class)
				.setParameter("searchUser", userName.toLowerCase()).getResultList();
	}
}

