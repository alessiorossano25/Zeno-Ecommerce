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
  <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/mission.css"%>" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>

<body>
<%@ include file="Header.jsp" %>
<!-- inizio mission -->
<div class="mask">
  <div class="wrapper">
  <div class="left column">

      <!--contenuto 1-->
      <div class="content first" style="background-color: #2B82CF;">
          <h2 style="margin-top:-1vh;">Sostenibilità</h2>
          <p class="p-mission">Zeno rappresenta l'essenza dell'innovazione, dello stile e della sostenibilità nell'abbigliamento.
            Unitevi a noi per un futuro più sostenibile e alla moda!
          </p>
          
      </div>

      <!--contenuto 2-->
      <div class="content second" style="background-color: #B20E34;">
          <h2 style="margin-top:-6vh;">Design e Materiali</h2>
          <p class="p-mission">Dal casual alle linee formali, i nostri prodotti soddisfano le esigenze di un pubblico diversificato ispirandoci sulle ultime tendenze stilistiche.</p>
          
      </div>

      <!--contenuto 3-->
      <div class="content third" style="background-color: #DEB887;">
          <h2 style="margin-top:-20vh;">Storia</h2>
          <p class="p-mission">Zeno suona come una sinfonia elegante e raffinata, perfetto per il mondo della moda e dell'abbigliamento dove il glamour è di casa.</p>
          
      </div>


  </div>
  <div class="right column">
      <div class="pic first"><img class="mission-img" src="<%=request.getContextPath()+ "/MEDIA/IMPATTO.png"%>"></div>
      <div class="pic second"><img class="mission-img" src="<%=request.getContextPath()+ "/MEDIA/MARCHIO.png"%>"></div>
      <div class="pic third"><img class="mission-img" src="<%=request.getContextPath()+ "/MEDIA/storia.png"%>"></div>
  </div>
</div>
</div>

<!-- fine mission -->
<%@ include file="Footer.jsp" %>

<script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
     <script src="<%=request.getContextPath()+ "/JS/listaprodotti.js"%>"></script>
     <script src="<%=request.getContextPath()+ "/JS/mission.js"%>"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>