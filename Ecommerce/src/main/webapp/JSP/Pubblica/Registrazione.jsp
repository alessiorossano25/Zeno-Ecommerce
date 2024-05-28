<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Zeno: Innovazione, Stile e Sostenibilità</title>
  <link rel="shortcut icon" href="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" type="image/x-icon" />

</head>

                
<body onload="disableSubmit()"style="background-image: url('<%=request.getContextPath()+ "/MEDIA/background.png"%>'); background-size: cover;">

	<div class="container">
	<div class="container form bg-white pt-5 mt-4 mb-3">
		<form action="/Ecommerce/registrazione" method="POST"
			class="container form bg-white pt-5 mt-4 mb-3">
  
         <img src="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" style="border-radius:50%;margin-left:350px;margin-top:-100px;margin-bottom:20px;height:20vh;width:20vw;display:flex;background-color:black;justify-content-center;align-items:center;" href="http://localhost:8080/Ecommerce/JSP/Pubblica/index.jsp" class="d-inline-block align-text-center text-white" />
                
			<p class="text-center login-heading show-me" style="font-size: 20px;">Registrati
				al sito:</p>
				
			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Nome</p>
					<div class="row mt-4">
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-user-o" aria-hidden="true" id="user"></i>
						</div>
						<div class="col-10 pl-0">
							<input type="text" placeholder="Digita il tuo nome"
								class='first-name' name="nome">
						</div>
					</div>
					<hr class="hr-1">
					<div class="first-name-hide"></div>
				</div>
			</div>
			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Cognome</p>
					<div class="row mt-4">
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-user-o" aria-hidden="true" id="user"></i>
						</div>
						<div class="col-10 pl-0">
							<input type="text" placeholder="Digita il tuo cognome"
								class='last-name' name="cognome">
						</div>
					</div>
					<hr class="hr-1">
					<div class="last-name-hide"></div>
				</div>
			</div>

			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Username</p>
					<div class="row mt-4">
					
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-user-o" aria-hidden="true" id="user"></i>
						</div>
						<div class="col-10 pl-0">
							<input type="text" placeholder="Digita il tuo username"
								class='first-name' name="userNameReg">
						</div>
					</div>
					<hr class="hr-1">
					<div class="first-name-hide"></div>
				</div>
			</div>


			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Email</p>
					<div class="row mt-4">
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-envelope-o" aria-hidden="true" id="user"></i>
						</div>
						<div class="col-10 pl-0">
							<input type="email" placeholder="Digita la tua mail" class='email'
								name="email">
						</div>
					</div>
					<hr class="hr-1">
					<div class="email-hide"></div>
				</div>
			</div>
			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Password</p>
					<div class="row mt-4">
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-lock" aria-hidden="true" id="lock"></i>
						</div>
						<div class="col-10 pl-0">
							<input type="password"  pattern=".{8,}"   required title="8 caratteri minimi" id="sub-password"
								placeholder="Digita la tua password" class="password-signup"
								name="passwordReg">
							<!-- Icona per mostrare/nascondere la password -->
							<span onclick="subtogglePassword()"> <i class="fa fa-eye"
								id="eyeIcon1"></i>
							</span>
						</div>
					</div>
					<hr class="hr-2">
					<div class="password-signup-hide"></div>
				</div>
			</div>
			<div class="row show-me">
				<div class="col mt-4 pl-5 pr-5">
					<p class="username">Conferma la password</p>
					<div class="row mt-4">
						<div class="col-2 text-center pt-1 pr-0">
							<i class="fa fa-lock" aria-hidden="true" id="lock"></i>
						</div>

						<div class="col-10 pl-0">
							<!-- Campo password -->
							<input type="password" pattern=".{8,}"   required title="8 caratteri minimi" value="" id="myInput"
								placeholder="Conferma la password" name="passwordRegConf">

							<!-- Icona per mostrare/nascondere la password -->
							<span onclick="togglePassword()"> <i class="fa fa-eye"
								id="eyeIcon"></i>
							</span>



						</div>
					</div>
					<hr class="hr-2">
					<div class="confirm-password-signup-hide"></div>
				</div>
			</div>


			<div class="row show-me">
				<div class="col pl-5 mt-2">
					<br>
					<!-- checkbox inizio-->
					<input type="checkbox" name="terms" id="terms" required
						onchange="activateButton(this)"> <a href="https://protezionedatipersonali.it/informativa"><span
						class="forget-password">Accetto i <span
							style="text-transform: capitalize; color: blue">termini di
								utilizzo </span>& <span style="text-transform: capitalize; color: blue">privacy
								policy</span></a> <br> <br> <br>
					<div class="col text-center">

						<input type="submit" id="submit" value="Registrati"
							class="btn btn-primary" data-mdb-ripple-init>
					</div>
				</div>
			</div>

			<!-- checkbox fine-->


			<!-- inserire pagina login-->
		</form>
		<%
		String errore =(String)request.getAttribute("errore");
		String risIns =(String)request.getAttribute("risIns");
		if (errore!=null){%>
		<p><%=errore%></p>
		<%}if (risIns!=null){%>
		<p><%=risIns%></p>
		<%}%> 
		<div class="row mt-5 show-me">
			<div class="col text-center">
				<span
					style="font-family: Arial, Helvetica, sans-serif; font-size: 15px; font-weight: 600; color: rgb(148, 141, 141)">Hai
					già un account?</span>
			</div>
			<div class="col-12 text-center pt-3">
				<a href="http://localhost:8080/Ecommerce/JSP/Pubblica/Login.jsp"><span
					class="login-page">Esegui il login</span></a> <br> <br>
			</div>
		</div>
	</div>
	
    
	


	<script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>