<%@page import="com.azienda.eCommerce.model.Prodotto"%>
<%@page import="com.azienda.eCommerce.model.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Zeno: Innovazione, Stile e Sostenibilit�</title>
    <link rel="shortcut icon" href="/MEDIA/logo3.png" type="image/x-icon" />
    <!-- FAVICON -->
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/carrello.css"%>" />
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/style.css"%>" >
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/listautenti.css"%>" >
        <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/listaprodotti.css"%>" >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
 
<body style="background-color:lightblue;">
    <%@ include file="HeaderPriv.jsp" %>

    <!--INIZIO TABELLA PRODOTTO-->

       <%
       List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("listaProdottiAdmin");
   	
	%>
    <div class="container my-6 rounded" style="background-color:whitesmoke;">    
        <div class="d-flex py-3">
            <h3>Lista prodotti:</h3> 
        </div>
        <table class="table table-light" style="width:100%;height:30vh;">
            <thead>
                <tr>
                    <th scope="col">Nome:</th>
                    <th scope="col">Quantit�:</th>
                    <th scope="col">Prezzo:</th>
                    
                    <th scope="col">Cancella</th>
                    <th scope="col">Modifica</th>
                </tr>
            </thead>
         <%for (Prodotto prodottoSingolo : prodotti) {
				%>
            <tbody>
                <tr>
                    <td><br><%=prodottoSingolo.getNome()%></td>
                    <td><br><%=prodottoSingolo.getQuantita()%></td>
                    <td><br><%=prodottoSingolo.getPrezzo()%></td>
                    
                    <td><br><a href="/Ecommerce/EliminaProdotto?id=<%=prodottoSingolo.getId()%>" class="btn btn-sm btn-danger">Cancella</a></td>
                    <td><br><a href="/Ecommerce/FormModifica?id=<%=prodottoSingolo.getId()%>" class="btn btn-sm btn-success">Modifica</a></td>
                    
                </tr>
            </tbody>
            <%} %>
        </table>
    </div>
    
    
    
    <!-- FOOTER START -->
    <%@ include file="FooterPriv.jsp" %>



    <script src="<%=request.getContextPath() + "/JS/script.js"%>"></script>
    <script src="<%=request.getContextPath() + "/JS/listaprodotti.js"%>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>