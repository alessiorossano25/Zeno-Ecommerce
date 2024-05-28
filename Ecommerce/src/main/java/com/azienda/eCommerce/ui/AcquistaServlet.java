package com.azienda.eCommerce.ui;

import java.io.IOException;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Utente;
import com.azienda.eCommerce.util.EmailUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Acquista")
public class AcquistaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			Utente utente = (Utente)req.getSession().getAttribute("Utente");
			bl.acquista(utente.getCarrello());
			EmailUtils.sendEmail(utente.getEmail());
			req.getRequestDispatcher("/JSP/Pubblica/index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);

		}
	}
}
