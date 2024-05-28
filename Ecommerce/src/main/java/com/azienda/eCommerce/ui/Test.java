package com.azienda.eCommerce.ui;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
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
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;
import com.azienda.eCommerce.util.CostantiCategoria;
import com.azienda.eCommerce.util.CostantiUtente;



public class Test {

	public static void main(String[] args) {
		EntityManager manager = null;
		try {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("e_commerce");
			manager = factory.createEntityManager();
			
			DaoProdotto dp = new DaoProdotto(manager);
			DaoUtente du = new DaoUtente(manager);
			DaoCategoriaProdotto dc = new DaoCategoriaProdotto(manager);
			DaoStoricoAcquisti dSPA = new DaoStoricoAcquisti(manager);
			DaoCarrello dca = new DaoCarrello(manager);
			DaoTipoUtente dtu = new DaoTipoUtente(manager);
			DaoProdottoAcquistato dpa = new DaoProdottoAcquistato(manager);
			DaoProdottoNelCarrello dpc = new DaoProdottoNelCarrello(manager);
			
			BussinessLogic bl = new BussinessLogic(manager, dca, dc, dp, dpa, dSPA, dtu, du,dpc);
			
			TipoUtente admin = new TipoUtente(CostantiUtente.ADMIN);
			TipoUtente user = new TipoUtente(CostantiUtente.USER);
			
			CategoriaProdotto catUomo = new CategoriaProdotto (CostantiCategoria.UOMO);
			CategoriaProdotto catDonna = new CategoriaProdotto (CostantiCategoria.DONNA);
			CategoriaProdotto catAbbigliamento = new CategoriaProdotto (CostantiCategoria.ABITI);
			
			bl.insertTipoUtente(admin);
			bl.insertTipoUtente(user);
			bl.insertCategoriaProdotto(catUomo);
			bl.insertCategoriaProdotto(catDonna);
			bl.insertCategoriaProdotto(catAbbigliamento);
			
			
			
			List<CategoriaProdotto> list1 = new ArrayList<>();
			list1.add(catAbbigliamento);
			list1.add(catUomo);
			
			List<CategoriaProdotto> list2 = new ArrayList<>();
			list2.add(catAbbigliamento);
			list2.add(catDonna); 
			
			
			Prodotto p1 = new Prodotto("mascara","ref", 1f,10,list2);
			Prodotto p2 = new Prodotto("scarabeo","ref", 1f,10,list1);
			Prodotto p3 = new Prodotto("righello","ref", 1f,10,list2);
			
			
			
			
			Utente utente1 = new Utente ("Carlo", "Rossi", "Mail","Username", "Password",user);
			bl.insertUtente(utente1);
			Utente utente2 = new Utente ("Carla", "Magenta", "Mail2","Username2", "Password2",admin);
			du.create(utente2);
			
			
			//bl.insertProdotto(p1,utente2);
			//bl.insertProdotto(p2,utente2);			
			//bl.insertProdotto(p3,utente2);
			
			
			Carrello carrello1 = utente1.getCarrello();
			Carrello carrello2 = utente2.getCarrello();
			
			bl.addItemCarrello(carrello1, p1,2);
		    bl.addItemCarrello(carrello1, p2,4);
		    //bl.acquista(carrello1);
		    
			bl.addItemCarrello(carrello1, p3,6);
			//bl.acquista(carrello1);
			
			//bl.addItemCarrello(carrello1, p3,1);
			//bl.acquista(carrello1);
			
			//bl.addItemCarrello(carrello2, p1,2);
		    //bl.addItemCarrello(carrello2, p2,3);
		    
		    
			//System.out.println(dca.searchByProd(p3));
			//bl.deleteProdotto(p3,utente2);
			//System.out.println("PreRimozione");
			//System.out.println(carrello1.getProdottoCarrello());
			
			bl.svuotaCarrello(carrello1);
			
			//System.out.println("PostRimozione");
			//System.out.println(carrello1.getProdottoCarrello());
			
			
			
			
			//System.out.println(bl.searchByCategoria(catUomo));
			System.out.println("Programma terminato");

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			manager.close();
			System.exit(0);
		}	
	}



}
