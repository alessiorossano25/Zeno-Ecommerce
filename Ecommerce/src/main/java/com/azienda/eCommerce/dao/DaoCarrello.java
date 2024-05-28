package com.azienda.eCommerce.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.model.Carrello;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoNelCarrello;


public class DaoCarrello implements DaoInterface<Carrello>{
	EntityManager manager;
	
	
	public DaoCarrello(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Carrello create(Carrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Carrello> retrieve() {
		return manager.createQuery("select c from c Carrello c",Carrello.class).getResultList();
	}

	@Override
	public Carrello update(Carrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Carrello ref) {
		manager.remove(ref);
	}
	
	

	public void addItemCarrello(Carrello ref, Prodotto prod, Integer quantita) {
		
		
		ProdottoNelCarrello pnc = new ProdottoNelCarrello(prod, quantita);
		Boolean controllo=false;
		
		for(ProdottoNelCarrello pc :ref.getProdottoNelCarrello()) {
			if((prod.getNome()).equals(pc.getNome())&&prod.getPrezzo()==pc.getPrezzo()) {
					pc.setQuantita(quantita+pnc.getQuantita());
					controllo=true;
			}
		}
		if(!controllo) {
			manager.persist(pnc);
		}
		pnc.setCarrelli(ref);
		pnc.setProdottiNelCarrello(prod);
		ref.getProdottoNelCarrello().add(pnc);
		
		ref.setPrezzoTot(ref.getPrezzoTot()+pnc.getPrezzoTot());
		manager.merge(ref);
		
	}
	
	public void removeItemCarrello(Carrello ref, ProdottoNelCarrello prod) {
		ref.getProdottoNelCarrello().remove(prod);
		ref.setPrezzoTot(ref.getPrezzoTot()-prod.getPrezzoTot());
		manager.persist(ref);
	}
	
	public void svuotaCarrello(Carrello ref) { 
		List<ProdottoNelCarrello> prodNelCarrello = new ArrayList<>();
		ref.setProdottoNelCarrello(prodNelCarrello);
		ref.setPrezzoTot(0f);
		manager.persist(ref);
	}
	
	public List<Carrello> searchByProd(ProdottoNelCarrello prodotto){
	return manager.createQuery("select p from Carrello p join p.prodottoNelCarrello c where c.id= :searchCarrello",Carrello.class)
			.setParameter("searchCarrello", prodotto.getId()).getResultList();
	}
	
	public void updateItemCarrello(ProdottoNelCarrello prod,Carrello ref) { 
		  List<ProdottoNelCarrello>pdc =ref.getProdottoNelCarrello(); 
		  for(ProdottoNelCarrello pdcs :pdc) { 
		   if(pdcs.getNome().equals(prod.getNome())&&pdcs.getPrezzo().equals(prod.getPrezzo())) { 
		    pdc.remove(pdcs); 
		    pdc.add(prod); 
		   } 
		  } 
		  ref.setProdottoNelCarrello(pdc); 
		  manager.persist(prod); 
		  prod.setCarrelli(ref); 
		  prod.setProdottiNelCarrello(prod.getProdottiNelCarrello()); 
		 }
	
}
