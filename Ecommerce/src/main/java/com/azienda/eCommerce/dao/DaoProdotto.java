package com.azienda.eCommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.Utente;

public class DaoProdotto implements DaoInterface<Prodotto>{
	EntityManager manager;

	public DaoProdotto(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Prodotto create(Prodotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Prodotto> retrieve() {
		return manager.createQuery("select p from Prodotto p",Prodotto.class).getResultList();
	}

	@Override
	public Prodotto update(Prodotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Prodotto ref) {
		manager.remove(ref);
		
	}
	
	public List<Prodotto> searchByName(String search){
		return manager.createQuery("select p from Prodotto p where p.nome like:searchProdotto",Prodotto.class)
				.setParameter("searchProdotto", "%" + search + "%").getResultList();
	}
	
	//public List<Carrello> searchCarrelloPres
	
	
	
	/*public List<Prodotto> searchByCaratteristiche(CategoriaProdotto categoria){
		return manager.createQuery("select p from Prodotto p join p.categoriaProdotto c where c.nome= :searchCategoria",Prodotto.class)
				.setParameter("searchCategoria", categoria.getNome()).getResultList();
	}*/
	public void setQuantitaAcquisto(ProdottoNelCarrello prodCar, Prodotto prodMag) {
		prodMag.setQuantita(prodMag.getQuantita() - prodCar.getQuantita());
		manager.merge(prodMag);
	}
	
	
	public Prodotto searchById(Integer id){
		return manager.createQuery("select p from Prodotto p where p.id = :searchProdottoId",Prodotto.class)
				.setParameter("searchProdottoId",id).getSingleResult();
	}
	
	public Prodotto searchByTutto (String nome, String descrizione, Float prezzo){ 
		  return manager.createQuery("select p from Prodotto p where p.nome=:searchNome AND  p.descrizione=:searchDescrizione AND p.prezzo=:searchPrezzo",Prodotto.class) 
		    .setParameter("searchNome", nome).setParameter("searchDescrizione", descrizione).setParameter("searchPrezzo", Math.abs(prezzo)).getSingleResult(); 
		  //implementare se possibile la multi ricerca 
		 } 
		  
		 public List<ProdottoNelCarrello> searchByTuttoCar (Utente utente,String nome, String descrizione, Float prezzo){ 
		  return manager.createQuery("select p from ProdottoNelCarrello p where p.nome=:searchNome  AND p.prezzo=:searchPrezzo AND p.carrello=:searchCarrId",ProdottoNelCarrello.class) 
		    .setParameter("searchNome", nome).setParameter("searchPrezzo", Math.abs(prezzo)).setParameter("searchCarrId", utente.getCarrello()).getResultList(); 
		  //implementare se possibile la multi ricerca 
		 }
	
}
