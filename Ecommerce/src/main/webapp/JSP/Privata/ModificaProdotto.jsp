<%@page import="com.azienda.eCommerce.model.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Zeno: Innovazione, Stile e Sostenibilità</title>
<link rel="shortcut icon" href="/MEDIA/logo3.png" type="image/x-icon" />
<!-- FAVICON -->
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/carrello.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/style.css"%>">
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/listautenti.css"%>">
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/listaprodotti.css"%>">
<link rel="stylesheet"
	href="<%=request.getContextPath()+ "/CSS/inserimentoProdotto.css"%>" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="spazio">

	<%@ include file="HeaderPriv.jsp"%>

	<!--  MODIFICARE  -->
	<%
    Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");
    %>

	<div>
		<h2 class="titolo_prodotto justify-content-center d-flex">MODIFICA
			PRODOTTO</h2>
		<br>

		<form id="creazione" action="/Ecommerce/ModificaProdotto"
			enctype="multipart/form-data" method="GET">
			<input type="hidden" name="id" value="<%=prodotto.getId()%>">

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nome"><strong> Nome articolo </strong></label> <input
						type="text" class="form-control" id="nome" name="nome"
						value="<%=prodotto.getNome()%>">
				</div>
				<br>
				<div class="form-group col-md-6">
					<label for="descrizione"><strong> Descrizione
							articolo</strong></label>
					<textarea class="form-control" id="descrizione" name="descrizione"><%=prodotto.getDescrizione()%></textarea>
				</div>
			</div>
			<br>
			<div class="numeri">
				<div class="form-group col-md-1 p-2">
					<label for="prezzo"><strong> Prezzo </strong></label> <input
						type="number" min="0" class="form-control" id="prezzo"
						placeholder="€" name="prezzo" value="<%=prodotto.getPrezzo()%>">
				</div>
				<br>
				<div class="form-group col-md-2 p-2">
					<label for="quantita"><strong>Quantità in
							magazzino</strong></label> <input type="number" class="form-control" id="quantita"
						name="quantita" value="<%=prodotto.getQuantita()%>">
				</div>
			</div>
			<br> <br> <br>

			<button type="submit" class="col-md-2 btn-primary rounded">
				<strong> Modifica articolo </strong>
			</button>
			<br> <br>

		</form>
	</div>

	<%@ include file="FooterPriv.jsp"%>

	<script src="<%=request.getContextPath() + "/JS/script.js"%>"></script>
	<script src="<%=request.getContextPath() + "/JS/listaprodotti.js"%>"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>