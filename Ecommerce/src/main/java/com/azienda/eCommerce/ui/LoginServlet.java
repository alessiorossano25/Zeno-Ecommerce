package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName = req.getParameter("userNameLog");
			String password = req.getParameter("passwordLog");
			
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");

			
			List<Utente> listaUtenti= bl.searchByUsername(userName);
			
			if(listaUtenti.isEmpty()) {
				System.out.println("nessun utente registrato");
				req.getRequestDispatcher("/JSP/Pubblica/Login.jsp").forward(req, resp);
			}else {
				for(Utente ut: listaUtenti) {
					if(ut.getPassword().equals(password)) {	
					req.getSession().setAttribute("Loggato", "SI");
					req.getSession().setAttribute("tipoUtente", ut.getTipoUtente());
					req.getSession().setAttribute("Utente", ut);
					req.getRequestDispatcher("/ControlloUtenteHome").forward(req, resp);
					}else {
						System.out.println("Password sbagliata");
						req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);
						
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);

		}
	}
}
