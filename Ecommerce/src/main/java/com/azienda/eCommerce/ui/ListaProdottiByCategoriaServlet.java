package com.azienda.eCommerce.ui;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.util.BlobConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListaProdottiByCategoria")
public class ListaProdottiByCategoriaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			String ricerca1 = req.getParameter("ricerca1");
			String ricerca2 = req.getParameter("ricerca2");
			List<Prodotto> prodotti = new ArrayList<>();
			if (ricerca2.equals("")) {
				
				prodotti =  bl.searchByCategoria(ricerca1);
			}else {
				prodotti = bl.searchByCategoria2(ricerca1,ricerca2);
			}
			
			req.setAttribute("listaProdotti", prodotti);
			aggiungiImmagini(req, prodotti);
			req.getRequestDispatcher("/JSP/Pubblica/ListaProdotti.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/index.jsp").forward(req, resp);
		}
	}
	
	private void aggiungiImmagini(HttpServletRequest request, List<Prodotto> prodotti) throws Exception {
		Map<Integer, String> mappaImmagini = new HashMap(); 
		String uploadPath = getServletContext().getRealPath("") + File.separator + "MEDIA";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String baseHTTPUrl = "http://" + request.getServerName() + ":" + 
				request.getServerPort() + request.getContextPath(); 
		
		for (Prodotto p : prodotti) {
			 Blob immagine = p.getImmagine();
			 if(immagine != null) {
				 String filepath = uploadPath + File.separator + p.getId() + "_" + p.getNomeImmagine();
				 BlobConverter.saveFile(immagine, filepath);
				 mappaImmagini.put(p.getId(), baseHTTPUrl + File.separator + "MEDIA"+ File.separator + p.getId() + "_" + p.getNomeImmagine());
			 }
			 else {
				 mappaImmagini.put(p.getId(), baseHTTPUrl + File.separator + "MEDIA" + File.separator + "Template.png");
			 }	 
		}
		request.setAttribute("mappaImmagini", mappaImmagini);
		
	}
}


