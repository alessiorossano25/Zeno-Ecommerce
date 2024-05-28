<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Zeno: Innovazione, Stile e Sostenibilità</title>
  <link rel="shortcut icon" href="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" type="image/x-icon" />
  <!-- FAVICON -->
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/style.css"%>" />
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/listaprodotti.css"%>" />
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/brand.css"%>" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  </head>

<body>
<%@ include file="Header.jsp" %>
<!-- inizio mission -->

<div class="cartina row row-cols-3 g-4">
  <div class="col">
    <div class="card" style="border: 2px solid black;">
      <img src="<%=request.getContextPath()+ "/MEDIA/gucci.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">GUCCI</h5>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card"  style="border: 2px solid black;">
      <img src="<%=request.getContextPath()+ "/MEDIA/versace.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">VERSACE</h5>
       
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card" style="border: 2px solid black;">
      <img src="<%=request.getContextPath()+ "/MEDIA/chanel.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">CHANEL</h5>
     
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card" style="border: 2px solid black;">
      <img src="<%=request.getContextPath()+ "/MEDIA/emporio.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">EMPORIO ARMANI</h5>
       
      </div>
    </div>
  </div>
  <div class="col ">
    <div class="card" style="border: 2px solid black;" >
      <img src="<%=request.getContextPath()+ "/MEDIA/lv.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">LOUIS VUITTON</h5>
        
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card" style="border: 2px solid black;">
      <img src="<%=request.getContextPath()+ "/MEDIA/balenciaga.png"%>" class="card-img-top">
      <div class="card-body">
        <h5 class="card-title justify-content-center d-flex">BALENCIAGA</h5>
        
      </div>
    </div>
  </div>
</div>
<!-- fine mission -->
<%@ include file="Footer.jsp" %>

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