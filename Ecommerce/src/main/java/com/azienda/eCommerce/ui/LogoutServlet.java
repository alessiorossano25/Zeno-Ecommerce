package com.azienda.eCommerce.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.getSession().removeAttribute("Loggato");

			req.getRequestDispatcher("/JSP/Pubblica/Login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("logout errato");
			req.getRequestDispatcher("/JSP/Pubblica/Login.jsp").forward(req, resp);
		}
	}
}
