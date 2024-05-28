package com.azienda.eCommerce.ui;

import java.io.IOException;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SvuotaCarrello")
public class SvuotaCarrelloServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
				Utente utente = (Utente)req.getSession().getAttribute("Utente");
				bl.svuotaCarrello(utente.getCarrello());
				req.getRequestDispatcher("/Carrello").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();		
				req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);

			}
		}
	}

