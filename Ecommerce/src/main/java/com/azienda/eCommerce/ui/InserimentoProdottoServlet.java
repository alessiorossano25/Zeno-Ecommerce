package com.azienda.eCommerce.ui;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.azienda.eCommerce.bussinessLogic.BussinessLogic;
import com.azienda.eCommerce.model.CategoriaProdotto;
import com.azienda.eCommerce.model.Prodotto;
import com.azienda.eCommerce.util.BlobConverter;
import com.azienda.eCommerce.util.CostantiCategoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/InserimentoProdotto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,maxFileSize = 1024 * 1024 * 10,maxRequestSize = 1024 * 1024 * 10 * 5)
public class InserimentoProdottoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			
			String nome = req.getParameter("nomeP");
			String descrizione = req.getParameter("descrizione");
			Float prezzo = Float.parseFloat(req.getParameter("prezzo"));
			Integer quantita = Integer.parseInt(req.getParameter("quantita"));
			String catUomo = req.getParameter("catUomo");
			String catDonna = req.getParameter("catDonna");
			String catBambino06 = req.getParameter("catBambino06");
			String catBambino610 = req.getParameter("catBambino610");
			String categoria = req.getParameter("categoria");
			List<String> listaCategorieString = new ArrayList<>();
			listaCategorieString.add(catUomo);
			listaCategorieString.add(catDonna);
			listaCategorieString.add(catBambino06);
			listaCategorieString.add(catBambino610);
			listaCategorieString.add(categoria);
			listaCategorieString.removeAll(Collections.singleton(null));
			
			List<CategoriaProdotto> listaClassiCat = (List<CategoriaProdotto>)req.getServletContext().getAttribute("listaCategorie");
			BussinessLogic bl = (BussinessLogic)req.getServletContext().getAttribute("businessLogic");
			
			List<CategoriaProdotto> listaDefinitiva = new ArrayList<>();
			for(CategoriaProdotto x :listaClassiCat) {
				String confronto = x.getNome();
				for(String y : listaCategorieString) {
					if(y.equalsIgnoreCase(confronto)) {
						listaDefinitiva.add(x);
					}
				}
			}
			
			
			if(	(nome != null && nome.replaceAll("\\s", "") != "")&&
					(prezzo != null && prezzo >0 )&&
					(quantita != null && quantita > 0)) {
				
				String uploadPath = getServletContext().getRealPath("") + File.separator + "MEDIA";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				String filePath = null;
				Blob immagine = null;
				String nomeImmagine =null;
				for ( Part part : req.getParts() ) {
					String fileName = part.getSubmittedFileName();
					if ( fileName!=null && !fileName.isEmpty() ) {
						filePath = uploadPath + File.separator + fileName;
						part.write(filePath);
						immagine = BlobConverter.generateBlob(filePath);
						nomeImmagine =fileName;
					}
				}
				
				Prodotto prodotto = new Prodotto(nome, descrizione, prezzo, quantita, listaDefinitiva);
				prodotto.setImmagine(immagine);
				prodotto.setNomeImmagine(nomeImmagine);
				bl.insertProdotto(prodotto);
				req.getRequestDispatcher("/JSP/Privata/InserimentoProdotto.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/JSP/Privata/Inserimento.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();		
			req.getRequestDispatcher("/JSP/Privata/Inserimento.jsp").forward(req, resp);

		}

	}
}
