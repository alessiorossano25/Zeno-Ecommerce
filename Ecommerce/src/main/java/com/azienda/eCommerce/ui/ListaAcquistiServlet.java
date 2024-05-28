package com.azienda.eCommerce.ui; 
 
import java.io.IOException; 
import java.util.List; 
 
import com.azienda.eCommerce.bussinessLogic.BussinessLogic; 
import com.azienda.eCommerce.model.Prodotto; 
import com.azienda.eCommerce.model.ProdottoAcquistato; 
import com.azienda.eCommerce.model.ProdottoNelCarrello; 
import com.azienda.eCommerce.model.StoricoAcquisti; 
import com.azienda.eCommerce.model.Utente; 
 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet("/ListaAcquisti") 
public class ListaAcquistiServlet extends HttpServlet{ 
 @Override 
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
  doPost(req, resp); 
 } 
 @Override 
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
  try { 
 
   BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
   Utente utente = (Utente)req.getSession().getAttribute("Utente"); 
   //Float prezzoTot = utente.getStoricoAcquisti().getPrezzoTotale();
   StoricoAcquisti storico = utente.getStoricoAcquisti();
   
   
   List<ProdottoAcquistato> storicoProdotti=utente.getStoricoAcquisti().getProdottiAcquistati(); 
   req.setAttribute("listaProdottiAcquistati", storicoProdotti); 
   req.setAttribute("storico", storico); 
   req.getRequestDispatcher("/JSP/Privata/Storico.jsp").forward(req, resp); 
  } 
  catch (Exception e) { 
   e.printStackTrace();   
   req.getRequestDispatcher("/JSP/Privata/Inserimento.jsp").forward(req, resp); 
  } 
 } 
 
}
