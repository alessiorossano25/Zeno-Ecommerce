<%@page import="com.azienda.eCommerce.model.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Zeno: Innovazione, Stile e Sostenibilità</title>
    <link rel="shortcut icon" href="/MEDIA/logo3.png" type="image/x-icon" />
    <!-- FAVICON -->
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/carrello.css"%>" />
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/style.css"%>" >
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/listautenti.css"%>" >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
    <%@ include file="HeaderPriv.jsp" %>


    <!--INIZIO TABELLA PRODOTTO-->

       <%
	
	List<Utente> utenti = (List<Utente>) request.getAttribute("listaUtenti");
	%>
    <div class="container my-6">
        <div class="d-flex py-3">
            <h3>Lista utenti:</h3> 
        </div>
        <table class="table table-light ">
            <thead>
                <tr>
                    <th scope="col">Username:</th>
                    <th scope="col">Nome:</th>
                    <th scope="col">Cognome:</th>
                    <th>Email:</th>
                    <th scope="col">Cancella</th>
                </tr>
            </thead>
         <%for (Utente utente2 : utenti) {
        	 if(utente2.getTipoUtente().getTipoUtente().equalsIgnoreCase("admin") ){
 				continue;}
				%>
            <tbody>
                <tr>
                    <td><%=utente2.getUsername()%></td>
                    <td><%=utente2.getNome()%></td>
                    <td><%=utente2.getCognome()%></td>
                    <td><%=utente2.getEmail()%></td>
                    <td><a href="/Ecommerce/EliminaUtente?username=<%=utente2.getUsername()%>" class="btn btn-sm btn-danger">Cancella</a></td>
                    
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