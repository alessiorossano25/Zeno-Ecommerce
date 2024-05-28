package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.Manager;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AggiungiProdCar")
public class AggiungiProdCarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try { 
			String nome = req.getParameter("nomeProdotto"); 
			String descrizione = req.getParameter("descrizione"); 
			Float prezzo = Float.parseFloat(req.getParameter("prezzoProdotto")); 
			String idString = req.getParameter("id");
			Integer quantita = Integer.parseInt(req.getParameter("quantita")); 
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic"); 
			Utente utente = (Utente)req.getSession().getAttribute("Utente"); 
			List<ProdottoNelCarrello> prodottoCar = bl.searchByTuttoCar(utente,nome, descrizione, prezzo); 
			if(!prodottoCar.isEmpty()) { 
				List<ProdottoNelCarrello> pd =utente.getCarrello().getProdottoNelCarrello(); 
				for(ProdottoNelCarrello pds : pd) { 
					if (quantita>0) {
						if(pds.getNome().equals(prodottoCar.get(0).getNome())&&pds.getPrezzo()==prodottoCar.get(0).getPrezzo()) {
							utente.getCarrello().setPrezzoTot(utente.getCarrello().getPrezzoTot()- pds.getPrezzoTot());	
							prodottoCar.get(0).setPrezzoTot(prodottoCar.get(0).getPrezzoTot() + (prezzo * quantita));
							prodottoCar.get(0).setQuantita(prodottoCar.get(0).getQuantita()+quantita);
							bl.insertProdottoNelCarrello(prodottoCar.get(0));
							utente.getCarrello().getProdottoNelCarrello().remove(pds);
							utente.getCarrello().getProdottoNelCarrello().add(prodottoCar.get(0));
							utente.getCarrello().setPrezzoTot(utente.getCarrello().getPrezzoTot()+ prodottoCar.get(0).getPrezzoTot());
							bl.updateItemCar(prodottoCar.get(0),utente.getCarrello());

							if(idString==null) {
								req.getRequestDispatcher("/Carrello").forward(req, resp); 
							}else {
								//Integer id = Integer.parseInt(idString);
								//req.setAttribute("idProd", id);
								resp.sendRedirect(req.getContextPath()+ "/SingleProd?idProd=" + idString);
								//req.getRequestDispatcher("/SingleProd").forward(req, resp);  
							}
						} 
					}else {
						if(pds.getNome().equals(prodottoCar.get(0).getNome())&&pds.getPrezzo()==prodottoCar.get(0).getPrezzo()) {
							utente.getCarrello().setPrezzoTot(utente.getCarrello().getPrezzoTot() - prezzo);
							bl.insertCarrello(utente.getCarrello());
							utente.getCarrello().getProdottoNelCarrello().remove(pds);
							prodottoCar.get(0).setPrezzoTot(prodottoCar.get(0).getPrezzoTot()-prezzo);
							prodottoCar.get(0).setQuantita(prodottoCar.get(0).getQuantita()+quantita);
							utente.getCarrello().getProdottoNelCarrello().add(prodottoCar.get(0));
							bl.updateItemCar(prodottoCar.get(0),utente.getCarrello());

							if(idString==null) {
								req.getRequestDispatcher("/Carrello").forward(req, resp); 
							}else {

								//Integer id = Integer.parseInt(idString);
								//req.setAttribute("idProd", id);
								resp.sendRedirect(req.getContextPath()+ "/SingleProd?idProd=" + idString);
								//req.getRequestDispatcher("/SingleProd").forward(req, resp);  
							}
						}
					}

				} 
			}else { 
				Prodotto prodotto=bl.searchByTutto(nome, descrizione, prezzo); 
				bl.addItemCarrello(utente.getCarrello(), prodotto, quantita); 
				if(idString==null) {
					req.getRequestDispatcher("/Carrello").forward(req, resp); 
				}else {

					//Integer id = Integer.parseInt(idString);
					//req.setAttribute("idProd", id);
					resp.sendRedirect(req.getContextPath()+ "/SingleProd?idProd=" + idString);
					//req.getRequestDispatcher("/SingleProd").forward(req, resp); 
				}
			} 
		} catch (Exception e) { 
			e.printStackTrace();   
			req.getRequestDispatcher("/JSP/Privata/Inserimento.jsp").forward(req, resp); 
		} 
	} 

}
