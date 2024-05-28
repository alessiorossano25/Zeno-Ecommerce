package com.azienda.eCommerce.ui;

import java.io.IOException;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.TipoUtente;
import com.azienda.eCommerce.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nome = req.getParameter("nome");
			String cognome = req.getParameter("cognome");
			String userName = req.getParameter("userNameReg");
			String password = req.getParameter("passwordReg");
			String passwordConferma = req.getParameter("passwordRegConf");
			String mail = req.getParameter("email");

			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");

			String errore ="";
			String risultatoInserimento="";
			if(	(nome != null && nome.replaceAll("\\s", "") != "")&&
					(cognome != null && cognome.replaceAll("\\s", "") != "")&&
					(mail != null && mail.replaceAll("\\s", "") != "")&&
					(userName != null && userName.replaceAll("\\s", "") != "")&&
					(password != null && password.replaceAll("\\s", "") != "")&&
					(passwordConferma != null && passwordConferma.replaceAll("\\s", "") != "")
					){
				if (password.equals(passwordConferma)) {
					Utente utente = new Utente (nome, cognome, mail,userName, password);
					risultatoInserimento = bl.insertUtente(utente);
					if (risultatoInserimento.equals("Inserimento corretto")) {
						req.setAttribute("errore", errore);
						req.setAttribute("risIns", risultatoInserimento);
						req.getRequestDispatcher("/JSP/Pubblica/Login.jsp").forward(req, resp);
					}else {
						req.setAttribute("errore", errore);
						req.setAttribute("risIns", risultatoInserimento);
						req.getRequestDispatcher("/JSP/Pubblica/Registrazione.jsp").forward(req, resp);
					}
					
				}else {
					errore = "le due password non combaciano";
					req.setAttribute("errore", errore);
					req.setAttribute("risIns", risultatoInserimento);
					System.out.println("Le password non matchano");
					req.getRequestDispatcher("/JSP/Pubblica/Registrazione.jsp").forward(req, resp);
				}	
			}else {
				errore = "uno dei campi inseriti è vuoto";
				req.setAttribute("errore", errore);
				req.setAttribute("risIns", risultatoInserimento);
				System.out.println("Mancano dei campi");
				req.getRequestDispatcher("/JSP/Pubblica/Registrazione.jsp").forward(req, resp);

			}
			
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/Registrazione.jsp").forward(req, resp);

		}
		
		
	}
}
