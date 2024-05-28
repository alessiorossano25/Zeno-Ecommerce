<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="com.azienda.eCommerce.model.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Zeno: Innovazione, Stile e Sostenibilità</title>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="shortcut icon" href="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" type="image/x-icon" />
  <!-- FAVICON -->
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/style.css"%>"/>
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/listaprodotti.css"%>"/>
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/singoloprodotto.css"%>"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  </head>

<body>
  
  <%@ include file="Header.jsp" %>
  <!-- INZIO SINGOLO PRODOTTO-->
  <%
	Prodotto prodotto = (Prodotto) request.getAttribute("singleProd");
	Map <Integer,String> mappaImmagini = (Map <Integer,String>) request.getAttribute("mappaImmagini");

	%>
<section class=" sing-product py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<%=mappaImmagini.get(prodotto.getId())%>" /></div>
            <div class="col-md-6">
                <h1 class="display-5 fw-bolder"><%=prodotto.getNome() %></h1><br>
                <div class="fs-5 mb-5">
                    <span class="colorato bg-danger rounded p-1">€<%=prodotto.getPrezzo()%></span>
                </div>
                <p class="lead rounded"><%=prodotto.getDescrizione()%></p>
                <br><br>
                <%if(log!=null){ %>
                <div class="d-flex justify-content-start">
                
                
                    <form action="/Ecommerce/AggiungiProdCar?nomeProdotto=<%=prodotto.getNome()%>&descrizione=<%=prodotto.getDescrizione()%>&prezzoProdotto=<%=prodotto.getPrezzo()%>f&quantita=-1&id=<%=prodotto.getId()%>" method="POST"><button class="meno rounded btn-danger  mx-1"
                        style="min-width:2vw; min-height: 4vh;">-</button></form>
                        
                        <form action="/Ecommerce/AggiungiProdCar?nomeProdotto=<%=prodotto.getNome()%>&descrizione=<%=prodotto.getDescrizione()%>&prezzoProdotto=<%=prodotto.getPrezzo()%>f&quantita=1&id=<%=prodotto.getId()%>" method="POST"><button class="acquista text-white btn-gradient-border btn-glow  mx-1 "
                        style="min-width:9vw; min-height: 4vh;" value="oggetto6">Aggiungi al carrello</button></form>
                        
                    <form action="/Ecommerce/AggiungiProdCar?nomeProdotto=<%=prodotto.getNome()%>&descrizione=<%=prodotto.getDescrizione()%>&prezzoProdotto=<%=prodotto.getPrezzo()%>f&quantita=1&id=<%=prodotto.getId()%>" method="POST"><button class="piu rounded btn-success mx-1 "
                        style="min-width:2vw; min-height: 4vh;">+</button></form>
                        
                </div>
                <%} %>
            </div>
        </div>
    </div>
</section>

    <!-- FINE SINGOLO PRODOTTO-->
    
    
<!-- FOOTER START -->
<%@ include file="Footer.jsp" %>

<!-- FINE FOOTER -->


    


    <script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
     <script src="<%=request.getContextPath()+ "/JS/listaprodotti.js"%>"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>