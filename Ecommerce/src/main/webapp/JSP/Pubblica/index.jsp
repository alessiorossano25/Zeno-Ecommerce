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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  </head>

<body>
 
    <%@ include file="Header.jsp" %>

    
<!-- slider home-->
<div class="slider">
  <div class="controls"> 
    <div class="up" id="previous">
      <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6v13m0-13 4 4m-4-4-4 4"/>
      </svg>
      
    </div>
    <div class="down" id="next">
      <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 19V5m0 14-4-4m4 4 4-4"/>
      </svg>
      
    </div>
  </div>

  <div class="wrapper">
    <div class="left">

      <div class="testoSlide">
        <h2>Vibrazioni estive:<br> il tuo stile prende il volo!
        </h2>
        <p>Vivi l'estate al massimo con la nostra nuova collezione primavera-estate! Lascia che il tuo stile prenda il volo e libera la tua personalità con capi comodi, alla moda e perfetti per ogni occasione. Scopri la collezione ora e preparati a brillare!</p>      
      </div>

      <div class="testoSlide">
        <h2>Sconti Esclusivi</h2>
        <p>Un'occasione imperdibile per immergersi nel lusso a prezzi unici. Approfitta degli sconti esclusivi su tutta la collezione primavera-estate e rinnova il tuo guardaroba con capi esclusivi realizzati con i migliori materiali e rifiniti con la massima cura per i dettagli.</p>
      </div>

      <div class="testoSlide">
        <h2>Ultimi Arrivi</h2>
        <p>Siamo lieti di presentare i nuovi arrivi della nostra collezione primavera-estate, dove l'artigianalità italiana incontra il design contemporaneo. Scopri capi esclusivi realizzati con i migliori materiali e rifiniti con la massima cura per i dettagli.</p>      
        </div>

      
    </div>

    <div class="right">
      
      <div class="movimento">
      <img src="<%=request.getContextPath()+ "/MEDIA/modella1.png"%>" alt="">
      </div>

      <div class="movimento">
        <img src="<%=request.getContextPath()+ "/MEDIA/saldi.png"%>" alt="">
        </div>

        <div class="movimento">
          <img src="<%=request.getContextPath()+ "/MEDIA/modella2.png"%>" alt="">
          </div>

    </div>
  </div>
 </div>

 

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