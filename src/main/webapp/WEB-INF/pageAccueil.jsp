<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="fr">
<%@ include file="miseEnPage/head.jsp"%>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/login.css"
	rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headerprofile.jsp"%>

	<div><marquee style="color:white"> Bonjour, ${utilisateur.pseudo} bienvenue sur notre site d'enchéres en ligne   </marquee></div>

	<div class="container" style="background-color: white; border-radius: 12px !important;">
		<div class="col-md-6 col-sm-12">
			<section class="todo_section">
				<h4 class="index_text_input">Filtres :</h4>
				<section>
					<form class="needs-validation col-md-12 col-sm-12 " novalidate>
						<div class="input-group">
							<span class="input-group-addon"><i class="fas fa-search"></i></span>
							<input type="text" class="form-control" id="inputGroupSuccess1"
								aria-describedby="inputGroupSuccess1Status">
						</div>
					</form>
				</section>

				<section class=" col-md-12 col-sm-12">
					<i id="cat">Catégorie :</i> <select class="form-control "
						style="float: right; padding: 0px 12px; width: 61%;">
						<option value="">Toutes Catégories</option>
						<option value="info">Informatique</option>
						<option value="ameu">Ameublement</option>
						<option value="vet">Vêtement</option>
						<option value="spetlois">Sport et Loisirs</option>
					</select>
				</section>
			</section>
		</div>

		<!---------------------------Bouton recherche -------------------->
		<div class="col-md-6 col-xs-8 " id="pad_btn" style="padding-top: 30px">
			<input type="submit" value="Rechercher"
				class="btn btn-success btn-connexion "
				
				id="btn_search">
		</div>


		<div class="row" style="padding-bottom: 3%">

			<div class="col-md-8 col-sm-12">
				<!----------------------- groupe Achat ----------------------------->
				<div class="col-md-6 col-xs-12" id="groupeAchat">
					<input type="radio" name="radioGroup" id="contactChoice1"
						value="yes"><label style="margin-left: 0.4em;"
						for="contactChoice1">Achat</label> <br> <input
						type="checkbox" class="checkboxA" name="checkboxGroup[]"
						id="checkboxGroupAchat" value="Value 1"><label
						style="margin-left: 0.4em;"> Enchères ouvertes</label> <br> <input
						type="checkbox" class="checkboxA" name="checkboxGroup[]"
						id="checkboxGroupAchat" value="Value 2"><label
						style="margin-left: 0.4em;"> Mes enchères</label> <br> <input
						type="checkbox" class="checkboxA" name="checkboxGroup[]"
						id="checkboxGroupAchat" value="Value 2"><label
						style="margin-left: 0.4em;"> Mes enchères remportées</label> <br>

				</div>
				<!----------------------- groupe Vente ----------------------------->

				<div class="col-md-6 col-xs-12" id="groupeVente">
					<input type="radio" name="radioGroup" id="contactChoice2"
						value="no"><label style="margin-left: 0.4em;"
						for="contactChoice2"> Mes ventes</label> <br> <input
						type="checkbox" class="checkboxV" name="checkboxGroup[]"
						id="checkboxGroupVente" value="Value 1"><label
						style="margin-left: 0.4em;">Mes ventes en cours</label> <br>
					<input type="checkbox" class="checkboxV" name="checkboxGroup[]"
						id="checkboxGroupVente" value="Value 2"><label
						style="margin-left: 0.4em;">Ventes non débutées</label> <br>
					<input type="checkbox" class="checkboxV" name="checkboxGroup[]"
						id="checkboxGroupVente" value="Value 2"><label
						style="margin-left: 0.4em;">Ventes terminées</label> <br>

				</div>
				<script>
                    document.getElementById("contactChoice1").onclick = function() {
                        var elems = document.getElementsByClassName('checkboxV');
                        for (var i = 0; i < elems.length; i++) {
                            elems[i].checked = false;
                            elems[i].disabled = true;
                        }
                    }
                    document.getElementById("contactChoice2").onclick = function() {
                        var elems = document.getElementsByClassName('checkboxA');
                        for (var i = 0; i < elems.length; i++) {
                            elems[i].checked = false;
                            elems[i].disabled = true;
                        }
                    };

                </script>
			</div>
		</div>
		<div class="row" style='padding-bottom: 2%;'></div>
		<div>
			<!---------VERIFICATION ------>
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

		</div>
		
	</div>
	
	
	
	<!------------------------------------------------- FIN TODO_SECTION --------------------------------------------->

	<footer class="my-5 pt-5 text-muted text-center text-small"> </footer>
	<div class="forgot"></div>
	<script>
        window.jQuery || document.write('<script src="<link href="<%=request.getContextPath() %>/dist/bootstrap/js/jquery.slim.min.js"><\/script>')

    </script>
	<script
		src="<%=request.getContextPath() %>/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
