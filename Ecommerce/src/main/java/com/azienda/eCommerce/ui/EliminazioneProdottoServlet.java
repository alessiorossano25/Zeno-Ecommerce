package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminaProdotto")
public class EliminazioneProdottoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			
		Integer id = Integer.parseInt(req.getParameter("id"));
		Prodotto prodotto = bl.searchByIdProdotto(id);
		bl.deleteProdotto(prodotto);
		
			req.getRequestDispatcher("/ListaProdottiAdmin").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/JSP/Privata/Boh.jsp").forward(req, resp);
		}
		
		
		
			
		
	}
}