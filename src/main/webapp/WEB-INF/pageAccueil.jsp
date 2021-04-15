
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<%@ include file="miseEnPage/head.jsp"%>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/login.css"
	rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headerprofile.jsp"%>
	<div class="container" style="background-color: white;">
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
					<i id="cat">Cat�gorie :</i> <select class="form-control "
						style="float: right; padding: 0px 12px; width: 61%;">
						<option value="">Toutes Cat�gories</option>
						<option value="info">Informatique</option>
						<option value="ameu">Ameublement</option>
						<option value="vet">V�tement</option>
						<option value="spetlois">Sport & Loisirs</option>
					</select>
				</section>
			</section>
		</div>

		<!---------------------------Bouton recherche -------------------->
		<div class="col-md-6 col-xs-8 " id="pad_btn" style="padding-top: 30px">
			<input type="button" value="Rechercher"
				class="btn btn-secondary btn-lg "
				onclick="window.location.href='../Acquereur/DetailVente.html';"
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
						style="margin-left: 0.4em;"> Ench�res ouvertes</label> <br> <input
						type="checkbox" class="checkboxA" name="checkboxGroup[]"
						id="checkboxGroupAchat" value="Value 2"><label
						style="margin-left: 0.4em;"> Mes ench�res</label> <br> <input
						type="checkbox" class="checkboxA" name="checkboxGroup[]"
						id="checkboxGroupAchat" value="Value 2"><label
						style="margin-left: 0.4em;"> Mes ench�res remport�es</label> <br>

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
						style="margin-left: 0.4em;">Ventes non d�but�es</label> <br>
					<input type="checkbox" class="checkboxV" name="checkboxGroup[]"
						id="checkboxGroupVente" value="Value 2"><label
						style="margin-left: 0.4em;">Ventes termin�es</label> <br>

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
			<c:if test="${!empty errorMessage }">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}"></c:out>
				</div>
			</c:if>

			<c:forEach items="${ listeEncheres }" var="listeEnchere">
				<div class="bg-danger col-md-5 d-inline" style="margin: 5px 20px;">
					<div class="bg-primary col-md-4"
						style="height: 150px; margin: 0 5px;">
						<img
							src="https://img.icons8.com/offices/100/000000/phone-contact.png" />
					</div>
					<div class="bg-danger  col m-1">
						<h3><c:out value="${ listeEnchere.nomArticle }"/></h3>
						<p>
							 <c:out value="Prix :${ listeEnchere.prix }"/> <br> 
							 <c:out value="Fin de l'ench�re :${ listeEnchere.dateFinEnchere }"/> <br>
							 <c:out value="Vendeur :${ listeEnchere.pseudo }"/> <br>
						</p>
					</div>

				</div>
			</c:forEach>

		</div>
		
	</div>
	
	
	
	<!------------------------------------------------- FIN TODO_SECTION --------------------------------------------->

	<footer class="my-5 pt-5 text-muted text-center text-small"> </footer>
	<div class="forgot"></div>
	<script>
        window.jQuery || document.write('<script src="<link href="<%=request.getContextPath() %>/dist/bootstrap/js/jquery.slim.min.js"><\/script>')

    </script>
	<script
		src="../style/bootstrap/bootstrap-4.5.3-dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
