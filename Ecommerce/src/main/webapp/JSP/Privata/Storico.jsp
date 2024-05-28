<%@page import="com.azienda.eCommerce.model.ProdottoAcquistato"%>
<%@page import="com.azienda.eCommerce.model.StoricoAcquisti"%>
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
    <link rel="stylesheet" href="<%=request.getContextPath() + "/CSS/listaprodotti.css"%>" >
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body style="background-color:lightblue;">
    <%@ include file="HeaderPriv.jsp" %>

    <!--INIZIO TABELLA PRODOTTO-->

<%StoricoAcquisti storico =(StoricoAcquisti)request.getAttribute("storico");
List<ProdottoAcquistato> prodottiAcquistati = (List<ProdottoAcquistato>)request.getAttribute("listaProdottiAcquistati");%>


    <div class="container my-9 rounded" style="background-color:whitesmoke;">
            <div class="d-flex py-3">
            <h3>Storico Acquisti:</h3> <br>
            <h3 style="padding-left:45vw;text-align: right;justify-content-end;display:flex;"> Prezzo totale: <%=storico.getPrezzoTotale()%></h3> 
			</div>
            <table class="table table-light" style="width:100%;height:30vh;">
            <thead>
                <tr>
                    <th scope="col">Nome:</th>
                    <th scope="col">Data:</th>
                    <th scope="col">Quantità:</th>
                    <th scope="col">Prezzo:</th>
                  
                </tr>
            </thead>
            
            <%for(ProdottoAcquistato x : prodottiAcquistati){%>

            <tbody>
                <tr>
                    <td><%=x.getNome()%></td>
                    <td><%=x.getOraDataAcquisto()%></td>
                    <td><%=x.getQuantita()%></td>
                    <td><%=x.getPrezzo()%></td>
                    
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