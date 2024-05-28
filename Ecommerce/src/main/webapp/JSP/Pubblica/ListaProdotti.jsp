<%@page import="java.util.Map"%>
<%@page import="com.azienda.eCommerce.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Zeno: Innovazione, Stile e Sostenibilità</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>"
	type="image/x-icon" />
<!-- FAVICON -->
<link rel="stylesheet"
	href="<%=request.getContextPath()+ "/CSS/style.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath()+ "/CSS/listaprodotti.css"%>" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>

<body>
	
	<%@ include file="Header.jsp" %>
	<!-- INIZIO CARTE PRODOTTO -->


	<%
	List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("listaProdotti");
	Map <Integer,String> mappaImmagini = (Map <Integer,String>) request.getAttribute("mappaImmagini");
	
	%>

<div class="flex-container" style="display:flex;flex-wrap:wrap;justify-content:between;margin-left:60px;padding-left:10px;"> <% for (Prodotto prodotto : prodotti) { %> 
	<form action="/Ecommerce/AggiungiProdCar" method="POST" style="flex-direction:row;">
	<div class=" d-flex justify-content-center flex-wrap" style="gap:30px;flex-direction:column;">
		<div class=" d-flex justify-content-center" style="gap: 30px;">
			<div class=" d-flex justify-content-center">
				<div class="cartaProdotto" style="width: 400px;margin-left:50px;">
					<img class="card-img-top" style="height: 400px;"
						src="<%= mappaImmagini.get(prodotto.getId())%>" alt="Card image cap">
					<div class="card-body ">
						<input type="hidden" id="nomeProdotto"
							class="prezzo btn btn-outline-secondary mx-1"
							value="<%=prodotto.getNome()%>" name="nomeProdotto">

						<h5 class="card-title"><a class="reference" href="/Ecommerce/SingleProd?idProd=<%=prodotto.getId()%>"><%=prodotto.getNome()%></a></h5>

						<input type="hidden" id="descrizioneProdotto"
							class="prezzo btn btn-outline-secondary mx-1"
							value="<%=prodotto.getDescrizione()%>" name="descrizione">

						<p class="card-text"><%=prodotto.getDescrizione()%></p>
						<br>
						
						<div class="d-flex justify-content-end">
						<label for="prezzo" class=" tipo-prezzo d-flex col-3" style="padding-left:15px;">€ <%=prodotto.getPrezzo()%></label>
						
						<%if(log!=null){ %>
						
						
						
						<input type="hidden" id="prezzo"class=" prezzo btn btn-outline-secondary mx-1" value="<%=prodotto.getPrezzo()%>f" name="prezzoProdotto">                         
						<br>
						<span class="a-dropdown-label">Quantità:</span>
						<input type="number" class=" mx-1 form-control" style="width: 3vw;" id="quantita" name="quantita" min="1" value="1">
						<button type="submit" class="col-5 acquista text-white btn-gradient-border btn-glow mx-2" style="min-width: 4vw; min-height: 10px;" value="oggetto1">Aggiungi al carrello
						</button>
						<%} %>
						</div>
					</div>
				</div>
			</div>
			</div>
			
</div>





	</form>

	<%
	}
	%>
	</div>
	
	
	
	
	
	
	

	<!-- FINE CARTE PRODOTTO -->



	<!-- FOOTER START -->
<%@ include file="Footer.jsp" %>
	<!-- FINE FOOTER -->

	<script src="<%=request.getContextPath()+ "/JS/listaprodotti.js"%>"></script>
	<script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>