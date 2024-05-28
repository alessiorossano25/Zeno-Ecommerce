package com.azienda.eCommerce.ui;

import java.io.IOException;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.TipoUtente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ControlloUtente")
public class ControlloUtenteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
		TipoUtente tu = (TipoUtente)req.getSession().getAttribute("tipoUtente");

		if (tu.getTipoUtente().equals("admin")) {
			req.getRequestDispatcher("/JSP/Privata/InserimentoProdotto.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/JSP/Privata/Boh.jsp").forward(req, resp);
		}
	}
}

