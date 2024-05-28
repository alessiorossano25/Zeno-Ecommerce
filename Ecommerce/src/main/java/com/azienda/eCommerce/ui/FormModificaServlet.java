package com.azienda.eCommerce.ui;

import java.io.IOException;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Prodotto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FormModifica")
public class FormModificaServlet extends HttpServlet{

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
		
		req.setAttribute("prodotto", prodotto);
		req.getRequestDispatcher("/JSP/Privata/ModificaProdotto.jsp").forward(req, resp);
		
	} catch (Exception e) {
		e.printStackTrace();
		req.getRequestDispatcher("/JSP/Privata/Boh.jsp").forward(req, resp);
	}
	}
	

}