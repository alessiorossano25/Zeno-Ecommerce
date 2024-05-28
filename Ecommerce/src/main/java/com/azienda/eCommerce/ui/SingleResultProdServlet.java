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
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SingleProd")
public class SingleResultProdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer idProd =Integer.parseInt(req.getParameter("idProd"));
			
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			
			Prodotto prodotto=bl.selectProdottoForId(idProd);
			req.setAttribute("singleProd", prodotto);
			aggiungiImmagini(req, prodotto);
			req.getRequestDispatcher("/JSP/Pubblica/SingoloProdotto.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Pubblica/LoginErrato.jsp").forward(req, resp);

		}
	}
	
	private void aggiungiImmagini(HttpServletRequest request, Prodotto prodotto) throws Exception {
		Map<Integer, String> mappaImmagini = new HashMap(); 
		String uploadPath = getServletContext().getRealPath("") + File.separator + "MEDIA";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String baseHTTPUrl = "http://" + request.getServerName() + ":" + 
				request.getServerPort() + request.getContextPath(); 
		
		
			 Blob immagine = prodotto.getImmagine();
			 if(immagine != null) {
				 String filepath = uploadPath + File.separator + prodotto.getId() + "_" + prodotto.getNomeImmagine();
				 BlobConverter.saveFile(immagine, filepath);
				 mappaImmagini.put(prodotto.getId(), baseHTTPUrl + File.separator + "MEDIA"+ File.separator + prodotto.getId() + "_" + prodotto.getNomeImmagine());
			 }
			 else {
				 mappaImmagini.put(prodotto.getId(), baseHTTPUrl + File.separator + "MEDIA" + File.separator + "Template.png");
			 }	 
		
		request.setAttribute("mappaImmagini", mappaImmagini);
		
	}
}
