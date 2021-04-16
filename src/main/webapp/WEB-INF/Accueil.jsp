<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>

<html lang="fr">
<%@ include file="miseEnPage/head.jsp"%>

<body class="bg-light" style="background-color: #333; ">
	<%@ include file="miseEnPage/header.jsp"%>

	<!------------------------------------------------- TITRE --------------------------------------------->
	<div class="container" style="background-color: white; border-radius: 12px !important;">
		<div class="col-md-12 col-xs-12" style="text-align: center">
			<h2 class="titre_index" style="text-align: center">Liste des
				enchères</h2>
		</div>

		<div class="row" style='padding-bottom: 15%;'>
			<!------------------------------------------------- FIN   titre --------------------------------------------->
			<!------------------------------------------------- todo_section --------------------------------------------->
			<div class="col-md-6 col-xs-12">
				<section class="todo_section">
					<h4 class="index_text_input">Filtres :</h4>

					<section class="first">
						<form class="needs-validation col-md-12 col-xs-12 " novalidate>
							<div class="input-group">
								<span class="input-group-addon"><i class="fas fa-search"></i></span>
								<input type="text" class="form-control" id="inputGroupSuccess1"
									aria-describedby="inputGroupSuccess1Status">
							</div>
						</form>
					</section>

					<section class="second">
						<label for="categorie"><strong>Catégorie:</strong></label> 
							<select class="form-control" name="categorie" id="categorie">

								<option selected></option>

								<c:forEach items="${listeCategories}" var="listeCategorie">
									<option value="${listeCategorie.libelle}">
										<c:out value="${listeCategorie.libelle}" />
									</option>
								</c:forEach>
							</select>
					</section>

					<script>
						if ($(window).width() < 820) {
							$(".first").insertAfter($(".second"));
						} else {
							$(".first").insertBefore($(".second"));
						}
					</script>
				</section>
			</div>
			<!------------------------------------------------- FIN TODO_SECTION --------------------------------------------->

			<div class="col-md-6 col-xs-8 " id="pad_btn"
				style="padding-top: 30px">
				<input type="button" value="Rechecher"
					class="btn btn-secondary btn-lg "
					onclick="window.location.href='assets/SeConnecter';"
					id="btn_search">
			</div>

		</div>

			<!---------TEST AFFICHAGE DES ENCHERES ------>
			
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
							 <c:out value="Fin de l'enchère :${ listeEnchere.dateFinEnchere }"/> <br>
							 <c:out value="Vendeur :${ listeEnchere.pseudo }"/> <br>
						</p>
					</div>

				</div>
			</c:forEach>

		</div>


	</div>


	<footer class="my-5 pt-5 text-muted text-center text-small">

	</footer>
	<div class="forgot" style="font-size: 16px;"></div>

	<script>
		window.jQuery
				|| document
						.write('<script src="assets/bootstrap/bootstrap-4.5.3-dist/js/jquery.slim.min.js"><\/script>')
	</script>
	<script
		src="assets/style/bootstrap/bootstrap-4.5.3-dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="assets/style/bootstrap/bootstrap-3.4.1-dist/js/form-validation.js"></script>

</body>
</html>