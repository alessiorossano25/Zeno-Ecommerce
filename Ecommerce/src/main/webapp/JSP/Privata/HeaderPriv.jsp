
<%@page import="com.azienda.eCommerce.model.Utente"%>
<nav>
	<div class="main-navbar shadow-sm sticky-top">
		<div class="top-navbar">
			<div class="container-fluid">
				<div class="row">
					<div
						class="col-md-2 my-auto d-none d-sm-none d-md-block d-lg-block riga1">
						<!-- logo e testo -->

						<div class="logoSito navbar-light">
							<div class="container-fluid">
								<a class="navbar-brand" href="http://localhost:8080/Ecommerce/JSP/Pubblica/index.jsp"> <img
									src="<%=request.getContextPath()+ "/MEDIA/ZENO.png"%>" alt=""
									class="d-inline-block align-text-center text-white" />
								</a>
							</div>
						</div>

						<!-- fine logo e testo -->
					</div>

					<!-- barra di ricerca -->
					<div class="col-md-4 my-auto">
						<form role="search" action="/Ecommerce/ListaProdotti"
							method="POST">
							<div class="input-group">
								<input type="search" placeholder="Cerca su Zeno"
									class="form-control" name="ricerca" />
								<!-- inizio button -->
								<button type="submit" class="btn" id="tastocerca"
									data-mdb-ripple-init>
									<i class="">Cerca </i>
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                      <path
											d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
                    </svg>
								</button>
								<!-- fine button -->
							</div>
							<!-- fine barra di ricerca -->
						</form>
					</div>


					<!-- ICONE IN ALTO A DESTRA  -->
					
					<%String log = (String)request.getSession().getAttribute("Loggato");
			Utente utente = (Utente)request.getSession().getAttribute("Utente");
			
			if(log != null) {
				%>
					
					<div class=" col-md-5 my-auto">
						<ul class="nav justify-content-end">
							<li class="nav-item"><a class="nav-link"
								href="/Ecommerce/Carrello"> <svg
										class=" mt-1 carrello  w-[48px] h-[48px] text-gray-800 dark:text-white"
										aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
										width="40" height="40" fill="none" viewBox="0 0 24 24">
                              <path stroke="currentColor"
											stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2"
											d="M5 4h1.5L9 16m0 0h8m-8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm-8.5-3h9.25L19 7H7.312" />
                          </svg></i>
									Carrello
							</a> 
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle"
								href="http://localhost:8080/Ecommerce/ControlloUtenteHome"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false"> <svg
										class="mt-1 w-[48px] h-[48px] text-gray-800 dark:text-white"
										aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
										width="40" height="40" fill="currentColor" viewBox="0 0 24 24">
                      <path fill-rule="evenodd"
											d="M12 20a7.966 7.966 0 0 1-5.002-1.756l.002.001v-.683c0-1.794 1.492-3.25 3.333-3.25h3.334c1.84 0 3.333 1.456 3.333 3.25v.683A7.966 7.966 0 0 1 12 20ZM2 12C2 6.477 6.477 2 12 2s10 4.477 10 10c0 5.5-4.44 9.963-9.932 10h-.138C6.438 21.962 2 17.5 2 12Zm10-5c-1.84 0-3.333 1.455-3.333 3.25S10.159 13.5 12 13.5c1.84 0 3.333-1.455 3.333-3.25S13.841 7 12 7Z"
											clip-rule="evenodd" />
                    </svg>  <%=utente.getNome()%>
							</a> <%}else{ %> <a
								href="http://localhost:8080/Ecommerce/JSP/Pubblica/Registrazione.jsp">Accedi/Registrati</a>

								<% }%>



								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item"
										href="/Ecommerce/ControlloUtenteHome"><i
											class="fa fa-user"></i> Il mio account</a></li>
									<li><a class="dropdown-item" href="/Ecommerce/ListaAcquisti"><i
											class="fa fa-list"></i> I miei ordini</a></li>


									<li><a class="dropdown-item"
										href="http://localhost:8080/Ecommerce/logout"><i
											class="fa fa-sign-out"></i> Logout</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- FINE ICONE IN ALTO A DESTRA  -->


		<!-- INIZIO MENU-->
		<div class="menu1">
			<ul>
				<li><a
					href="http://localhost:8080/Ecommerce/JSP/Pubblica/index.jsp">Home</a></li>
				<li id="menu-item-1"><a href="#">Donna</a></li>
				<li id="menu-item-2"><a href="#">Uomo</a></li>
				<li id="menu-item-3"><a href="#">Bambino</a></li>
				<li id="menu-item-4"><a
					href="http://localhost:8080/Ecommerce/JSP/Pubblica/brand.jsp">Brand</a></li>
				<li id="menu-item-5"><a
					href="/Ecommerce/ListaProdotti?ricerca=">Shopping</a></li>

				<li id="menu-item-5"><a
					href="http://localhost:8080/Ecommerce/JSP/Pubblica/mission.jsp">Mission</a></li>

				<div class="submenu">
					<div class="mega-menu">
						<div class="children">
							<figure class="media">
								<!--Mettere immagine che selezionamo-->
								<img src="<%=request.getContextPath()+ "/MEDIA/donna.png"%>" />
							</figure>
						</div>
						<div class="children">
							<h3>
								<b>CATEGORIE</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=maglieria">Maglieria</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=pantaloni">Pantaloni</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=giacche/cappotti">Giacche/Cappotti</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=camicie">Camicie</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=jeans">Jeans</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=scarpe">Scarpe</a></li>
							</ul>
						</div>
						<div class="children">
							<h3>
								<b>DONNA</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=donna&ricerca2=">Tutto
										il catalogo</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="submenu2">
					<div class="mega-menu">
						<div class="children">
							<figure class="media">
								<!--Mettere immagine che selezionamo-->
								<img src="<%=request.getContextPath()+ "/MEDIA/uomo.png"%>" />
							</figure>
						</div>
						<div class="children">
							<h3>
								<b>CATEGORIE</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=maglieria">Maglieria</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=pantaloni">Pantaloni</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomoa&ricerca2=giacche/cappotti">Giacche/Cappotti</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=camicie">Camicie</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=jeans">Jeans</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=scarpe">Scarpe</a></li>
							</ul>
						</div>

						<div class="children">
							<h3>
								<b>UOMO</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=uomo&ricerca2=">Tutto
										il catalogo</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="submenu3">
					<div class="mega-menu">
						<div class="children">
							<figure class="media">
								<!--Mettere immagine che selezionamo-->
								<img src="<%=request.getContextPath()+ "/MEDIA/bambini.png"%>" />
							</figure>
						</div>
						<div class="children">
							<h3>
								<b>DA 0 A 6 ANNI</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=maglieria">Maglieria</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=pantaloni">Pantaloni</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=abiti">Abiti</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=scarpe">Scarpe</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=accessori">Accessori</a></li>
							</ul>
						</div>
						<div class="children">
							<h3>
								<b>DA 6 A 10 ANNI</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=maglieria">Maglieria</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=pantaloni">Pantaloni</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=abiti">Abiti</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=scarpe">Scarpe</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=accessori">Accessori</a></li>
							</ul>
						</div>
						<div class="children">
							<h3>
								<b>BAMBINO</b>
							</h3>
							<ul class="sub-menu">
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino06&ricerca2=">Tutto
										il catalogo 0 - 6 anni</a></li>
								<li><a
									href="/Ecommerce/ListaProdottiByCategoria?ricerca1=bambino610&ricerca2=">Tutto
										il catalogo 6 - 10 anni</a></li>
							</ul>
						</div>
					</div>
				</div>
			</ul>
		</div>
	</div>
</nav>