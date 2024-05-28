package com.azienda.eCommerce.bussinessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.eCommerce.dao.DaoCarrello;
import com.azienda.eCommerce.dao.DaoCategoriaProdotto;
import com.azienda.eCommerce.dao.DaoProdotto;
import com.azienda.eCommerce.dao.DaoProdottoAcquistato;
import com.azienda.eCommerce.dao.DaoProdottoNelCarrello;
import com.azienda.eCommerce.dao.DaoStoricoAcquisti;
import com.azienda.eCommerce.dao.DaoTipoUtente;
import com.azienda.eCommerce.dao.DaoUtente;
import com.azienda.eCommerce.model.Carrello;
import com.azienda.eCommerce.model.CategoriaProdotto;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoAcquistato;
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.StoricoAcquisti;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;

public class BussinessLogic {
	private EntityManager manager;
	private DaoCarrello daoCarrello;
	private DaoCategoriaProdotto daoCatProdotto;
	private DaoProdotto daoProdotto;
	private DaoProdottoAcquistato daoProdAcquistato;
	private DaoStoricoAcquisti daoStoricoAcquisti;
	private DaoTipoUtente daoTipoUtente;
	private DaoUtente daoUtente;
	private DaoProdottoNelCarrello daoProdottoNelCarrello;

	public BussinessLogic(EntityManager manager, DaoCarrello daoCarrello, DaoCategoriaProdotto daoCatProdotto,
			DaoProdotto daoProdotto, DaoProdottoAcquistato daoProdAcquistato, DaoStoricoAcquisti daoStoricoAcquisti,
			DaoTipoUtente daoTipoUtente, DaoUtente daoUtente, DaoProdottoNelCarrello daoProdottoNelCarrello) {
		super();
		this.manager = manager;
		this.daoCarrello = daoCarrello;
		this.daoCatProdotto = daoCatProdotto;
		this.daoProdotto = daoProdotto;
		this.daoProdAcquistato = daoProdAcquistato;
		this.daoStoricoAcquisti = daoStoricoAcquisti;
		this.daoTipoUtente = daoTipoUtente;
		this.daoUtente = daoUtente;
		this.daoProdottoNelCarrello = daoProdottoNelCarrello; 
	}

	//operazioni CRUD 
	public String insertUtente(Utente utente) {
		try {
			manager.getTransaction().begin();

			if(daoUtente.searchByMail(utente.getEmail()).isEmpty() &&
					daoUtente.searchByUsername(utente.getUsername()).isEmpty()) {
				TipoUtente tpu = daoTipoUtente.searchUser("user");
				utente.setTipoUtente(tpu);
				daoUtente.create(utente);
				manager.getTransaction().commit();
				return "Inserimento corretto";
			}
			else if (daoUtente.searchByMail(utente.getEmail()).isEmpty()){
				return "Username già esistente";
			}else{
				return "Mail già utilizzata";
			}

		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertTipoUtente(TipoUtente tipoUtente) {
		try {
			manager.getTransaction().begin();
			daoTipoUtente.create(tipoUtente);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertStoricoAcquisti(StoricoAcquisti storicoAcquisti) {
		try {
			manager.getTransaction().begin();
			daoStoricoAcquisti.create(storicoAcquisti);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertProdottoAcquistato(ProdottoAcquistato prodottoAcquistato) {
		try {
			manager.getTransaction().begin();
			daoProdAcquistato.create(prodottoAcquistato);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertProdotto(Prodotto prodotto) {
		try {

			manager.getTransaction().begin();
			daoProdotto.create(prodotto);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertCategoriaProdotto(CategoriaProdotto catProdotto) {
		try {
			manager.getTransaction().begin();
			daoCatProdotto.create(catProdotto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void insertCarrello(Carrello carrello) {
		try {
			manager.getTransaction().begin();
			daoCarrello.create(carrello);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void insertProdottoNelCarrello(ProdottoNelCarrello prodottoNelCarrello) {
		try {
			manager.getTransaction().begin();
			daoProdottoNelCarrello.create(prodottoNelCarrello);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}


	public List<Utente> selectUtenti(){
		List<Utente> utenti = null;
		try {
			manager.getTransaction().begin();
			utenti=daoUtente.retrieve();
			manager.getTransaction().commit();
			return utenti;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<TipoUtente> selectTipoUtente(){
		List<TipoUtente> tipi = null;
		try {
			manager.getTransaction().begin();
			tipi=daoTipoUtente.retrieve();
			manager.getTransaction().commit();
			return tipi;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<StoricoAcquisti> selectStoricoAcquisti(){
		List<StoricoAcquisti> storicoAcquisti = null;
		try {
			manager.getTransaction().begin();
			storicoAcquisti=daoStoricoAcquisti.retrieve();
			manager.getTransaction().commit();
			return storicoAcquisti;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<ProdottoAcquistato> selectProdottiAcquistati(){
		List<ProdottoAcquistato> prodottiAcquistati = null;
		try {
			manager.getTransaction().begin();
			prodottiAcquistati=daoProdAcquistato.retrieve();
			manager.getTransaction().commit();
			return prodottiAcquistati;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<Prodotto> selectProdotti(){
		List<Prodotto> prodotti = null;
		try {
			manager.getTransaction().begin();
			prodotti=daoProdotto.retrieve();
			manager.getTransaction().commit();
			return prodotti;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<CategoriaProdotto> selectCategorieProdotti(){
		List<CategoriaProdotto> categorieProdotti = null;
		try {
			manager.getTransaction().begin();
			categorieProdotti=daoCatProdotto.retrieve();
			manager.getTransaction().commit();
			return categorieProdotti;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public List<Carrello> selectCarelli(){
		List<Carrello> carrelli = null;
		try {
			manager.getTransaction().begin();
			carrelli=daoCarrello.retrieve();
			manager.getTransaction().commit();
			return carrelli;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public  List<ProdottoNelCarrello> selectProdottoNelCarrello() {
		List<ProdottoNelCarrello> prodottiNelCarrello= null;
		try {
			manager.getTransaction().begin();
			prodottiNelCarrello= daoProdottoNelCarrello.retrieve();
			manager.getTransaction().commit();
			return prodottiNelCarrello;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteUtente(Utente utente) {
		try {
			manager.getTransaction().begin();
			daoUtente.delete(utente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteTipoUtente(TipoUtente tipoUtente) {
		try {
			manager.getTransaction().begin();
			daoTipoUtente.delete(tipoUtente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteStoricoAcquisti(StoricoAcquisti storicoAcquisto) {
		try {
			manager.getTransaction().begin();
			daoStoricoAcquisti.delete(storicoAcquisto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteProdottoAcquistato(ProdottoAcquistato prodAcquistato) {
		try {
			manager.getTransaction().begin();
			daoProdAcquistato.delete(prodAcquistato);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public void deleteProdotto(Prodotto prodotto) {
		try {
			manager.getTransaction().begin();
			List<Carrello> carrelli = new ArrayList<>();
			List<ProdottoNelCarrello> pnc = daoProdottoNelCarrello.searchByProd(prodotto);
			List <ProdottoNelCarrello> copiaProdottiCarrello = new ArrayList<>();
			for(ProdottoNelCarrello prodottoCarrello : pnc) {
				carrelli.add(prodottoCarrello.getCarrelli());
				copiaProdottiCarrello.add(prodottoCarrello);
			}
			for(Carrello carrelloA : carrelli) {
				for(ProdottoNelCarrello y : copiaProdottiCarrello) {
					daoCarrello.removeItemCarrello(carrelloA, y);
					daoProdottoNelCarrello.delete(y);
				}
			}
			List<CategoriaProdotto> categoria = prodotto.getCategoria();
			for(CategoriaProdotto x : categoria) {
				x.getProdotti().remove(prodotto);
			}
			
			daoProdotto.delete(prodotto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	

	public void deleteCatProdotto(CategoriaProdotto catProdotto) {
		try {
			manager.getTransaction().begin();
			daoCatProdotto.delete(catProdotto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public void deleteCarrello(Carrello carrello) {
		try {
			manager.getTransaction().begin();
			daoCarrello.delete(carrello);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void deleteProdottoNelCarrello(ProdottoNelCarrello prodottoNelCarrello) {
		try {
			manager.getTransaction().begin();
			daoProdottoNelCarrello.delete(prodottoNelCarrello);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	//funzionalità ricerca
	public List<Prodotto> searchByName (String search){
		List<Prodotto> prodotti = null;
		try {
			manager.getTransaction().begin();
			prodotti=daoProdotto.searchByName(search);
			manager.getTransaction().commit();
			return prodotti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Prodotto> searchByCategoria (String categoria){
		List<Prodotto> prodotti = null;
		try {
			manager.getTransaction().begin();
			prodotti= daoCatProdotto.searchByCategoria(categoria);
			manager.getTransaction().commit();
			return prodotti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Prodotto> searchByCategoria2 (String categoria1, String categoria2){
		List<Prodotto> prodotti = null;
		try {
			manager.getTransaction().begin();
			prodotti= daoCatProdotto.searchByCategoria2(categoria1,categoria2);
			manager.getTransaction().commit();
			return prodotti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public Prodotto searchByTutto (String nome, String descrizione, Float prezzo){
		try {
			manager.getTransaction().begin();
			Prodotto prodotto= daoProdotto.searchByTutto(nome,descrizione,prezzo);
			manager.getTransaction().commit();
			return prodotto;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Utente> searchByMail (String mail){
		List<Utente> utenti = null;
		try {
			manager.getTransaction().begin();
			utenti=daoUtente.searchByMail(mail);
			manager.getTransaction().commit();
			return utenti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Utente> searchByUsername (String userName){
		List<Utente> utenti = null;
		try {
			manager.getTransaction().begin();
			utenti=daoUtente.searchByUsername(userName);
			manager.getTransaction().commit();
			return utenti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	//funzionalità carrello
	public void addItemCarrello (Carrello carrello, Prodotto prod,Integer quantita){
		try {
			manager.getTransaction().begin();

			daoCarrello.addItemCarrello(carrello, prod, quantita);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}	
	public void removeItemCarrello (Carrello carrello, ProdottoNelCarrello prod){
		try {
			manager.getTransaction().begin();
			daoCarrello.removeItemCarrello(carrello, prod);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}	
	public void svuotaCarrello (Carrello carrello){

		try {
			manager.getTransaction().begin();
			List<ProdottoNelCarrello> prodNelCarrello = carrello.getProdottoNelCarrello();
			for(ProdottoNelCarrello x : prodNelCarrello) {
				daoProdottoNelCarrello.delete(x);
			}
			daoCarrello.svuotaCarrello(carrello);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void acquista (Carrello carrello) {
		try {
			manager.getTransaction().begin();
			List<ProdottoNelCarrello> prodottiCarrello = carrello.getProdottoNelCarrello();
			List <ProdottoNelCarrello> copiaProdottiCarrello = new ArrayList<>();
			for(ProdottoNelCarrello prodottoCarrello : prodottiCarrello) {
				copiaProdottiCarrello.add(prodottoCarrello);
			}
			for(ProdottoNelCarrello prodottoCarrello : copiaProdottiCarrello) {
				if(prodottoCarrello.getProdottiNelCarrello().getQuantita() >= prodottoCarrello.getQuantita()) {
					ProdottoAcquistato prodAcquistato = new ProdottoAcquistato(prodottoCarrello.getNome(), prodottoCarrello.getPrezzo(), prodottoCarrello.getQuantita());
					daoProdAcquistato.create(prodAcquistato);
					daoProdotto.setQuantitaAcquisto(prodottoCarrello, prodottoCarrello.getProdottiNelCarrello());
					daoProdAcquistato.addNelloStorico(prodAcquistato, carrello.getUtente().getStoricoAcquisti());
					daoCarrello.removeItemCarrello(carrello, prodottoCarrello);
					daoProdottoNelCarrello.delete(prodottoCarrello);
					
					System.out.println("Acquisto con suceesso");
				}
				else {
					System.out.println("quantita in magazzino non disponibilie");
				}
			}
			
			manager.merge(carrello);
			manager.getTransaction().commit();
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}



	public void insertLoad (List<TipoUtente> tipiUtente, List<CategoriaProdotto> categorie, List<Utente> utentiAdmin) {
		try {
			manager.getTransaction().begin();
			for (TipoUtente tipi: tipiUtente) {
				daoTipoUtente.create(tipi);
			}
			for (CategoriaProdotto cat: categorie) {
				daoCatProdotto.create(cat);
			}
			for (Utente utente : utentiAdmin) {
				daoUtente.create(utente);
			}
			manager.getTransaction().commit();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	public Prodotto selectProdottoForId(Integer id){
		try {
			manager.getTransaction().begin();
			Prodotto prodotto=daoProdotto.searchById(id);
			manager.getTransaction().commit();
			return prodotto;
		}catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public void updateItemCar(ProdottoNelCarrello prod,Carrello ref) { 
		  try { 
		   manager.getTransaction().begin(); 
		   
		   daoProdottoNelCarrello.update(prod); 
		   daoCarrello.update(ref); 
		   manager.getTransaction().commit(); 
		  } catch (Exception e) { 
		   manager.getTransaction().rollback(); 
		   throw e; 
		  } 
		 }

	public List<ProdottoNelCarrello> searchByTuttoCar (Utente utente,String nome, String descrizione, Float prezzo){ 
		  try { 
		   manager.getTransaction().begin(); 
		   
		   List<ProdottoNelCarrello> prodotto= daoProdotto.searchByTuttoCar(utente, nome, descrizione, prezzo); 
		   manager.getTransaction().commit(); 
		   return prodotto; 
		  } catch (Exception e) { 
		   manager.getTransaction().rollback(); 
		   throw e; 
		  } 
		 }


public Prodotto searchByIdProdotto (Integer id){
	try {
		manager.getTransaction().begin();
		Prodotto prodotto= daoProdotto.searchById(id);
		manager.getTransaction().commit();
		return prodotto;
	} catch (Exception e) {
		manager.getTransaction().rollback();
		throw e;
	}
}


public List<ProdottoNelCarrello> searchByProdId (Prodotto prod){
	try {
		manager.getTransaction().begin();
		List<ProdottoNelCarrello> prodotto= daoProdottoNelCarrello.searchByProdId(prod);
		manager.getTransaction().commit();
		return prodotto;
	} catch (Exception e) {
		manager.getTransaction().rollback();
		throw e;
	}
}

public void deleteUtente2(Utente utente) {
	try {
		manager.getTransaction().begin();	
		Carrello carrello = utente.getCarrello();
		daoCarrello.svuotaCarrello(carrello); 
		carrello.setUtente(null);
		
		daoCarrello.create(carrello);
		daoCarrello.delete(carrello);
		
		StoricoAcquisti storico = utente.getStoricoAcquisti();
		storico.getProdottiAcquistati().clear();
		storico.setUtente(null);
		daoStoricoAcquisti.create(storico);
		daoStoricoAcquisti.delete(storico);
		
		utente.getTipoUtente().getUtente().remove(utente);
		
		utente.setCarrello(null);
		utente.setTipoUtente(null);
		utente.setStoricoAcquisti(null);
		daoUtente.create(utente);
		daoUtente.delete(utente);
		manager.getTransaction().commit();
	} catch (Exception e) {
		manager.getTransaction().rollback();
		throw e;
	}
}
	
	
	
	
	
	
	
	

public ProdottoNelCarrello searchByIdProdottoNelCarrello (Integer id){
	try {
		manager.getTransaction().begin();
		ProdottoNelCarrello prodotto= daoProdottoNelCarrello.searchById(id);
		manager.getTransaction().commit();
		return prodotto;
	} catch (Exception e) {
		manager.getTransaction().rollback();
		throw e;
	}
}




}
