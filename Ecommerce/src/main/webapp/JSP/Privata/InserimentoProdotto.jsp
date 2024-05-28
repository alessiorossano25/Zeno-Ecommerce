<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Zeno: Innovazione, Stile e Sostenibilità</title>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/inserimentoProdotto.css"%>" />
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/style.css"%>" />
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/listaprodotti.css"%>" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="spazio">

<%@ include file="HeaderPriv.jsp" %>

	<div >
		<h2 class="titolo_prodotto justify-content-center d-flex">INSERIMENTO
			PRODOTTO</h2>
		<br>
		<form id="creazione" action="/Ecommerce/InserimentoProdotto"
			enctype="multipart/form-data" method="POST">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nome"><strong> Nome articolo </strong></label> <input
						type="name" class="form-control" id="nome" name="nomeP">
				</div>
				<br>
				<div class="form-group col-md-6">
					<label for="descrizione"><strong> Inserire
							descrizione articolo</strong></label> <input type="text-area" class="form-control"
						id="text" placeholder="Inserire descrizione..." name="descrizione">
				</div>
			</div>
			<br>
			<div class="numeri">
				<div class=" form-group col-md-1 p-2">
					<label for="prezzo"><strong> Prezzo </strong></label> <input
						type="number" min="0" class="form-control" id="prezzo"
						placeholder="€" name="prezzo">
				</div>
				<br>
				<div class=" form-group col-md-2 p-2">
					<label for="quantita"><strong>Quantità in
							magazzino</strong></label> <input type="number" class="form-control" id="quantita"
						name="quantita">
				</div>
			</div>
			<br> <br> <br>

			<p>
				<strong>Seleziona macro-categoria:</strong>
			</p>
			<div class="form-group">
				<div class="form-check1">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						value="uomo" name="catUomo"> <label
						class="form-check-label" for="gridCheck"> Uomo </label>
				</div>

				<div class="form-check2">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						value="donna" name="catDonna"> <label
						class="form-check-label" for="gridCheck"> Donna </label>
				</div>
				<div class="form-check3">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						value="bambino06" name="catBambino06"> <label
						class="form-check-label" for="gridCheck"> Bambino 0 - 6
						anni </label>
				</div>
				<div class="form-check4">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						value="bambino610" name="catBambino610"> <label
						class="form-check-label" for="gridCheck"> Bambino 6 - 10
						anni </label>
				</div>
			</div>

			<br> <br>


			<div class="form-row">
				<div class="selezione-form form-group col-md-2">
					<label for="categorie"><strong> Seleziona
							categorie: </strong></label><br>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="maglieria" />
						<label for="uomo">Maglieria</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="pantaloni" />
						<label for="uomo">Pantaloni</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="abiti" /> <label
							for="uomo">Abiti</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria"
							value="giacche/cappotti" /> <label for="uomo">Giacche/Cappotti</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="Camicie" />
						<label for="uomo">Camicie</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="jeans" /> <label
							for="uomo">Jeans</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="scarpe" />
						<label for="uomo">Scarpe</label>
					</div>
					<div id="categorie" class="form-control">
						<input type="radio" id="uomo" name="categoria" value="accessori" />
						<label for="uomo">Accessori</label>
					</div>
					<br>
				</div>
			</div>


			<div class="File-img">
				<input type="file" name="file">
			</div>
			<br>

			<button type="submit" class="col-md-2 btn-primary rounded">
				<strong> Crea articolo </strong>
			</button>
			<br>
			<br>


		</form>
	</div>

<%@ include file="FooterPriv.jsp" %>


	<script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
     <script src="<%=request.getContextPath()+ "/JS/listaprodotti.js"%>"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>
