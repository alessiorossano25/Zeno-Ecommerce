package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.ProdottoNelCarrello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ModificaProdotto")
public class ModificaProdottoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			Integer id = Integer.parseInt(req.getParameter("id"));
			Prodotto prodotto  = bl.searchByIdProdotto(id);
			List<ProdottoNelCarrello> prodottiNeiCarrelli =  bl.searchByProdId(prodotto);
			String nome = (String)req.getParameter("nome");
			String descrizione = (String)req.getParameter("descrizione");
			String prezzo = req.getParameter("prezzo");
			String quantita = req.getParameter("quantita");
			
			
			if(!nome.equalsIgnoreCase("")) {
				prodotto.setNome(nome);
				for(ProdottoNelCarrello x : prodottiNeiCarrelli) {
					x.setNome(nome);
				}
			}
			if(!descrizione.equalsIgnoreCase("")) {
				prodotto.setDescrizione(descrizione);
				
			}
			if(!prezzo.equalsIgnoreCase("")) {
				prodotto.setPrezzo(Float.parseFloat(prezzo));
				for(ProdottoNelCarrello x : prodottiNeiCarrelli) {
					Float prezzoAntecedetne = x.getCarrelli().getPrezzoTot();
					Float prezzoDurante = prezzoAntecedetne - x.getPrezzoTot(); 
					x.getCarrelli().setPrezzoTot( prezzoDurante);
					x.setPrezzo(Float.parseFloat(prezzo));
					x.setPrezzoTot(Float.parseFloat(prezzo) * x.getQuantita());
					x.getCarrelli().setPrezzoTot( (prezzoDurante + x.getPrezzoTot()) );
					bl.insertProdottoNelCarrello(x);
					bl.insertCarrello(x.getCarrelli());
				}
			}
			if(!quantita.equalsIgnoreCase("")) {
				prodotto.setQuantita(Integer.parseInt(quantita));
			}
			bl.insertProdotto(prodotto);
			req.getRequestDispatcher("/ListaProdottiAdmin").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/JSP/Privata/Boh.jsp").forward(req, resp);
		}
	}
}
