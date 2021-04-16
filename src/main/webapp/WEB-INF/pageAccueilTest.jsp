<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>

<title>Page d'accueil</title>
</head>
<body style="background-color: #333">
<header>
	
		<nav class="navbar navbar-dark bg-dark text-white">
			<div class="container text-white">

				<ul class="nav me-auto">
					<li class="nav-item fw-bolder fst-italic"><a href="Accueil"
						class="nav-link link-dark text-white"><strong class="fst-italic">ENI-Enchère</strong></a></li>
				</ul>

				<ul class="nav">
				
					<li class="nav-item">
						<a href="Inscription" class="nav-link link-dark px-2 text-white "> 
							Enchères
						</a>
					</li>
					
					<li class="nav-item">
						<a href="NouvelleVente" class="nav-link link-dark px-2 text-white "> 
							 Vendre un article
						</a>
					</li>
					
					<li class="nav-item">
						<a href="MonProfil" class="nav-link link-dark px-2 text-white "> 
							 Mon profil
						</a>
					</li>
					
					
					<li class="nav-item">
					<a href="Deconnexion" class="nav-link link-dark px-2 text-white"> 
							Déconnexion
					</a></li>
				</ul>

			</div>
		</nav>
	
	</header>
	
	<section id="myform" class ="bg-light">
		<h1 class="text-center ">La liste de enchères</h1>
		<div class="container bg-light p-3">
			<!-- <form action="TraitementAccueilSession" method=""> -->
			<form action="TraitementAccueilSession" method="GET">
				<div class="row mx-4">

					<div class="col-md-7 col-sm-12">
						<label for="description"><strong>Filtre:</strong></label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="bi bi-search"></i>
								</span>
							</div>
							<input type="text" class="form-control"
								placeholder="le nom de l'article " name="description">
						</div>

						<div class="form-group my-2">
							<label for="categorie"><strong>Catégorie:</strong></label> 
							<select class="form-control" name="categorie" id="categorie">

								<option selected></option>

								<c:forEach items="${listeCategories}" var="listeCategorie">
									<option value="${listeCategorie.libelle}">
										<c:out value="${listeCategorie.libelle}" />
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="row my-4 mx-2" id="groupeVente">
							<div class="col-5">
										<input class="form-check-input" type="radio" name="checkChoix" id="radio1" value="Achat"> 
										<label class="form-check-label" for="radio1">Achat </label><br>
										
										<input type="checkbox" id="enchereOuvertes" class="checkboxA" checkboxAname="etatAchat" >
										<label for="enchereOuvertes">encherères ouvertes</label><br>
										
										<input type="checkbox" id="encheresEnCours" class="checkboxA" name="etatAchat" >
										<label for="encheresEnCours">mes encherès en cours</label><br>
										
										<input type="checkbox" id="encheresRemportees" class="checkboxA" name="etatAchat" >
										<label for="encheresRemportees">mes enchères remportées</label><br>
							</div>
							
							<div class="col-5">
								<input class="form-check-input" type="radio" name="checkChoix" id="radio2" value="Ventes">
								<label class="form-check-label" for="radio2">Mes ventes </label><br>
								
								
								<input type="checkbox" id="mesVentesEnCours" class="checkboxV" name="etatVentes"  >
								<label for="mesVentesEnCours">mes ventes en cours </label><br>
								
								<input type="checkbox" id="ventesNonDebutees" class="checkboxV" name="etatVentes" >
								<label for="ventesNonDebutees">ventes noon débutées </label><br>
								
								<input type="checkbox" id="ventesTerminees" class="checkboxV" name="etatVentes"  >
								<label for="ventesTerminees">ventes terminées </label><br>
								
							</div>
						</div>
					</div>
					<script>
                    document.getElementById("radio1").onclick = function() {
                        var elems = document.getElementsByClassName('checkboxV');
                        for (var i = 0; i < elems.length; i++) {
                        	elems[i].checked = false;
                            elems[i].disabled = true;
                        }
                        var elems = document.getElementsByClassName('checkboxA');
                        for (var i = 0; i < elems.length; i++) {
                            elems[i].checked = false;
                            elems[i].disabled = false;
                        }
                    }
                    document.getElementById("radio2").onclick = function() {
                        var elems = document.getElementsByClassName('checkboxA');
                        for (var i = 0; i < elems.length; i++) {
                            elems[i].checked = false;
                            elems[i].disabled = true;
                        }
                        var elems = document.getElementsByClassName('checkboxV');
                        for (var i = 0; i < elems.length; i++) {
                        	elems[i].checked = false;
                            elems[i].disabled = false;
                        }
                    };

                </script>

					<div class=" mt-3 col">
						<button class="btn btn-success p-5 mt-3 border border-3 border-dark "
							type="submit">rechercher</button>
					</div>
				</div>
			</form>
		</div>

	</section>

	<section id="verification">
		<c:if test="${!empty errorMessage }">
			<div class="alert alert-danger" role="alert">
				<c:out value="${errorMessage}"></c:out>
			</div>
		</c:if>
	</section>

	
	<section class="my-5" id="lesEncheres" >
		<div class="container">
			<div class="card-deck ">
				<c:forEach items="${ listeEncheres }" var="listeEnchere">
					<div class="card mx-2" style="width: 480px; margin: 0;">
						<div class="card-body   bg-white  border border-dark border-3">
							<div class="row">
								<div class="col">
									<img class="card-img-top"
										src="https://homepages.cae.wisc.edu/~ece533/images/boat.png"
										alt="Card image cap">
								</div>

								<div class="col">
									<h3>
										<c:out value="${ listeEnchere.article.nomArticle }" />
									</h3>
									<p>
										<strong>Prix:</strong>
										<c:out value="${ listeEnchere.article.prixInitial }" />
									</p>

									<p>
										<strong>Fin de l'enchère:</strong>
										<c:out value="${ listeEnchere.article.dateFinEncheres }" />
									</p>

									<p>
										<strong>Vendeur :</strong>
										<c:out value="${ listeEnchere.utilisateur.pseudo }" />
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>

	</section>

</body>
</html>