<%@page import="com.azienda.eCommerce.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Zeno: Innovazione, Stile e Sostenibilità</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath() + "/MEDIA/ZENO.png"%>"
	type="image/x-icon" />
<!-- FAVICON -->
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/style.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/listaprodotti.css"%>" />
<link rel="stylesheet"
	href="<%=request.getContextPath() + "/CSS/infoAdmin.css"%>" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>

<body>

<%@ include file="HeaderPriv.jsp" %>
	<!-- INIZIO ADMIN -->
	
	<div class="tutto">
		<div class="contenuto d-flex justify-content-center">
			<div class="tot-tot card bg-info">
				<div class="card-header bg-white border-0">
					<div class=" fantasma row align-items-center">
						<div class="">
							<h3 class=" pt-3 d-flex justify-content-center">Il Mio
								Account</h3>
						</div>
						<div class="pb-3 pt-3 text-right d-flex justify-content-end">
							<a href="/Ecommerce/ListaAcquisti" class="storico btn btn-sm btn-outline-primary"><i class="fa fa-first-order" aria-hidden="true"></i> Storico Ordini</a> 
							<a href="/Ecommerce/Carrello" class="storico btn btn-sm btn-outline-dark"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Torna al carrello</a>
						</div>
					</div>
				</div>
				<div class="card-body">
					<form>
						<div class=" gruppo row">
							<div class="groppo col-3">
								<div class="form-group" id="spostamento-nome">
									<label class="form-control-label" for="input-email">Nome</label>
									<input type="text" class="form-control"
										value="<%=utente.getNome()%>" readonly>
								</div>
							</div>

							<div class="groppo col-7">
								<div class="form-group" id="spostamento-cognome">
									<label class="form-control-label" for="input-email">Cognome</label>
									<input type="text" class="form-control"
										value="<%=utente.getCognome()%>" readonly>
								</div>
							</div>


							<div class="groppo col-3">
								<div class="form-group" id="spostamento-nome">
									<label class="form-control-label" for="input-email">Username</label>
									<input type="text" class="form-control"
										value="<%=utente.getUsername()%>" readonly>
								</div>
							</div>

							<div class="groppo col-7">
								<div class="form-group" id="spostamento-cognome">
									<label class="form-control-label" for="input-email">Password</label>
									<span onclick="subtogglePassword()">
                        					<i class="fa fa-eye" id="eyeIcon1" style="display:flex;margin-left:20vw;margin-bottom:-24px;"></i>
                    					</span>
									<input type="password" class="form-control" id="sub-password"
										value="<%=utente.getPassword()%>" readonly>
								</div>
							</div>

							<div class="groppo col-8">
								<div class="form-group" id="spostamento-nome">
									<label class="form-control-label" for="input-email">E-mail</label>
									<input type="text" class="form-control"
										value="<%=utente.getEmail()%>" readonly>
								</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- FINE ADMIN-->


	<!-- FOOTER START -->
	<%@ include file="FooterPriv.jsp" %>
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

