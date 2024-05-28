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
import com.azienda.eCommerce.model.CategoriaProdotto;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;
import com.azienda.eCommerce.util.CostantiCategoria;
import com.azienda.eCommerce.util.CostantiUtente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

	@WebServlet(value="/init",loadOnStartup=1)
	public class LoadOnServlet extends HttpServlet{
		@Override
		public void init() throws ServletException{
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("e_commerce");
			EntityManager manager=factory.createEntityManager();
			
			DaoProdotto dp = new DaoProdotto(manager);
			DaoUtente du = new DaoUtente(manager);
			DaoCategoriaProdotto dc = new DaoCategoriaProdotto(manager);
			DaoStoricoAcquisti dSPA = new DaoStoricoAcquisti(manager);
			DaoCarrello dca = new DaoCarrello(manager);
			DaoTipoUtente dtu = new DaoTipoUtente(manager);
			DaoProdottoAcquistato dpa = new DaoProdottoAcquistato(manager);
			DaoProdottoNelCarrello dpc = new DaoProdottoNelCarrello(manager);
			
			BussinessLogic bl = new BussinessLogic(manager, dca, dc, dp, dpa, dSPA, dtu, du,dpc);
			
			
			
			
			List<TipoUtente> tipiUtente = new ArrayList<TipoUtente>();
			TipoUtente user = new TipoUtente(CostantiUtente.USER);
			tipiUtente.add(user);
			TipoUtente admin = new TipoUtente(CostantiUtente.ADMIN);
			tipiUtente.add(admin);
			
			List<CategoriaProdotto> categorie =new ArrayList<>();
			CategoriaProdotto catUomo = new CategoriaProdotto (CostantiCategoria.UOMO);
			categorie.add(catUomo);
			CategoriaProdotto catDonna = new CategoriaProdotto (CostantiCategoria.DONNA);
			categorie.add(catDonna);
			CategoriaProdotto catBambino06 = new CategoriaProdotto (CostantiCategoria.BAMBINO06);
			categorie.add(catBambino06);
			CategoriaProdotto catBambino610 = new CategoriaProdotto (CostantiCategoria.BAMBINO610);
			categorie.add(catBambino610);
			CategoriaProdotto catMagliaeria = new CategoriaProdotto (CostantiCategoria.MAGLIERIA);
			categorie.add(catMagliaeria);
			CategoriaProdotto catPantaloni = new CategoriaProdotto (CostantiCategoria.PANTALONI);
			categorie.add(catPantaloni);
			CategoriaProdotto catAbiti = new CategoriaProdotto (CostantiCategoria.ABITI);
			categorie.add(catAbiti);
			CategoriaProdotto catAccessori = new CategoriaProdotto (CostantiCategoria.ACCESSORI);
			categorie.add(catAccessori);
			CategoriaProdotto catScarpe = new CategoriaProdotto (CostantiCategoria.SCARPE);
			categorie.add(catScarpe);
			CategoriaProdotto catJeans = new CategoriaProdotto (CostantiCategoria.JEANS);
			categorie.add(catJeans);
			CategoriaProdotto catCamicie = new CategoriaProdotto (CostantiCategoria.CAMICIE);
			categorie.add(catCamicie);
			CategoriaProdotto catGiacche = new CategoriaProdotto (CostantiCategoria.GIACCHE);
			categorie.add(catGiacche);
			
			List<Utente> utentiAdmin = new ArrayList<>();
			//inserire mail admin
			Utente admin1 = new Utente("admin", "admin", "leccalorenzo98@gmail.com", "admin", "admin", admin);
			utentiAdmin.add(admin1);
			
			
			bl.insertLoad(tipiUtente, categorie, utentiAdmin);

			getServletContext().setAttribute("businessLogic", bl);
			getServletContext().setAttribute("utenteAdmin", admin);
			getServletContext().setAttribute("listaCategorie", categorie);
		}
	}


