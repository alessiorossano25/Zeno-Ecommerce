package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Carrello;
import com.azienda.eCommerce.model.ProdottoNelCarrello;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			Utente utente = (Utente)req.getSession().getAttribute("Utente");
			
			Carrello carrello = utente.getCarrello();
			List<ProdottoNelCarrello> listaProdotti = carrello.getProdottoNelCarrello();
			
			req.setAttribute("listaProdotti", listaProdotti);
			req.setAttribute("carrello", carrello);
			req.getRequestDispatcher("/JSP/Privata/Carrello.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);
		}

	}


}
