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
        <link rel="stylesheet" href="CSS_files/login-form.css">
        <script src="JS_files/login-form.js"></script>
      
        <link rel="stylesheet" href="<%=request.getContextPath()+ "/CSS/style.css"%>" />
        <title>Zeno: Innovazione, Stile e Sostenibilità</title>
        
    </head>
    <div class="container" style="height:40vh;width:40vw;">
                  <a class="navbar-brand"  href="http://localhost:8080/Ecommerce/JSP/Pubblica/index.jsp">
                    <img src="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" alt="" class="d-inline-block align-text-center text-white" />
                  </a>
                </div>
                
    <body style="background-image:url('<%=request.getContextPath()+ "/MEDIA/background.png"%>');background-size:cover;">
    
        <div class="container">
            <div class="container form bg-white pt-5 mt-4 mb-3" style="margin-top:-140vh;width:160vw; height:55vh;">
<p class="text-center login-heading hide-me">Login</p>
<form action="/Ecommerce/Login" method="Post" class="container hide-me">
    <div class="row">
        <div class="col mt-4 pl-5 pr-5">
            <p class="username">Username</p>
            <div class="row mt-4">
                <div class="col-2 text-center pt-1 pr-0">
                    <i class="fa fa-user-o" aria-hidden="true" id="user"></i>
                </div>
                <div class="col-10 pl-0">
                    <input type="text" placeholder="Scrivi il tuo username" class='input-1' name="userNameLog">
                </div>
            </div>
            <hr class="hr-1">
            <div class="hide"></div>
        </div>
    </div>
    
    <div class="row">
        <div class="col mt-4 pl-5 pr-5">
            <p class="username">Password</p>
            <div class="row mt-4">
                <div class="col-2 text-center pt-1 pr-0">
                    <i class="fa fa-lock" aria-hidden="true" id="lock"></i>
                </div>
                <div class="col-10 pl-0">
                    <input type="password" placeholder="Scrivi la tua password" id="sub-password" class="input-2" name="passwordLog">
                <!-- Icona per mostrare/nascondere la password -->
                    <span onclick="subtogglePassword()">
                        <i class="fa fa-eye" id="eyeIcon1"></i>
                    </span>
                </div>
            </div>
            <hr class="hr-2">
            <div class="hide-1"></div>
        </div>
    </div>
    
    <br>
    <div class="row mt-4">
        <div class="col text-center">
            <input type="submit" value="Login" class="btn btn-primary" data-mdb-ripple-init>
            <br><br>
        </div>
        <div class="col-12 text-center pt-3">
					<a href="http://localhost:8080/Ecommerce/JSP/Pubblica/Registrazione.jsp"><span class="login-page">Vai alla registrazione</span></a> <br> <br>
				</div>
    </div>
</form>
<script src="<%=request.getContextPath()+ "/JS/script.js"%>"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</body>
</html>
