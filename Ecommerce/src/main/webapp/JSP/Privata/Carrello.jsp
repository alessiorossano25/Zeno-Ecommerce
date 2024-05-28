<%@page import="com.azienda.eCommerce.model.ProdottoNelCarrello"%>
<%@page import="java.util.List"%>
<%@page import="com.azienda.eCommerce.model.Carrello"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Zeno: Innovazione, Stile e Sostenibilità</title>
<link rel="shortcut icon" href="/MEDIA/ZENO.png" type="image/x-icon" />
<!-- FAVICON -->
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/style.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/listaprodotti.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/carrello.css"%>" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>

<body>

	<%@ include file="HeaderPriv.jsp"%>

	<!--INIZIO CARRELLO -->

	<%
	Carrello carrello = (Carrello) request.getAttribute("carrello");
	List<ProdottoNelCarrello> prodotti = (List<ProdottoNelCarrello>) request.getAttribute("listaProdotti");
	if(prodotti.isEmpty()|| prodotti==null){
		%>
	<div class="background-ottimo">
		<div class=" contenitore container my-6">
			<div class="d-flex py-4 pt-5 col-12">
				<h3>
					Prezzo Totale:
					<%=carrello.getPrezzoTot()%>
					€
				</h3>

				<br>
			</div>

			<br>
			<table class="tabella table table-light ">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Prezzo</th>
						<th scope="col">PrezzoTot</th>
						<th scope="col">Quantità</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><p></p></td>
						<td><p></p></td>
						<td><p></p></td>
						<td><p></p></td>
					</tr>
				</tbody>
			</table>
			<br>

		</div>
	</div>
	<%
	}else{
	%>

	<div class="background-ottimo">
		<div class=" contenitore container my-6">
			<div class="d-flex py-4 pt-5 col-12">
				<h3>
					Prezzo Totale:
					<%=carrello.getPrezzoTot()%>
					€
				</h3>
				<div class="d-flex justify-content-end align-items-end">
					<a class="mx-3 btn btn-outline-primary" href="/Ecommerce/Acquista">Vai
						al Pagamento</a> <br> 
						<a class="mx-3 btn btn-outline-danger "
						id="svuota" href="/Ecommerce/SvuotaCarrello">Svuota Carrello</a> <br>
				</div>
				<br>
			</div>

			<br>
			<table class="tabella table table-light ">
				<thead>
					<tr>
						<th scope="col">Nome</th>
						<th scope="col">Prezzo</th>
						<th scope="col">PrezzoTot</th>
						<th scope="col">Quantità</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>

				<%
				for (ProdottoNelCarrello prodotto : prodotti) {
				%>
				<tbody>
					<tr>
						<td><h5><%=prodotto.getNome()%></h5></td>
						<td><%=prodotto.getPrezzo()%> €</td>
						<td><%=prodotto.getPrezzoTot()%> €</td>
						<td>x <%=prodotto.getQuantita()%></td>
						<td><a href="/Ecommerce/RimuoviSingoloProdottoCarrello?id=<%=prodotto.getId()%>" class="btn  btn-danger border border-dark">Rimuovi</a></td>
					</tr>
				</tbody>

				<%
				}}
				%>
			</table>
			<br>

		</div>
	</div>

	<!--FINE CARRELLO -->


	<!-- FOOTER START -->
	<%@ include file="FooterPriv.jsp"%>
	<!-- FINE FOOTER -->




	<script src="<%=request.getContextPath() + "/JS/script.js"%>"></script>
	<script src="<%=request.getContextPath() + "/JS/listaprodotti.js"%>"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>