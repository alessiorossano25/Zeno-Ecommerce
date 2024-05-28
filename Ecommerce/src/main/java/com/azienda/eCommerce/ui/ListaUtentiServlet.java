package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;

import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListaUtenti")
public class ListaUtentiServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			List<Utente> utenti = new ArrayList<>();
			utenti =  bl.selectUtenti();
			req.setAttribute("listaUtenti", utenti);
			req.getRequestDispatcher("/JSP/Privata/ListaUtenti.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/index.jsp").forward(req, resp);
		}
	}
}
