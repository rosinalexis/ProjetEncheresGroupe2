
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<%@ include file="miseEnPage/head.jsp"%>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/login.css"
	rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headercompte.jsp"%>
	<div class="col-md-4" id="login">
		<section id="inner-wrapper" class="login">
			<div style="text-align: center">
				<h2>Connexion</h2>
			</div>
			<br>
			
			<!---------VERIFICATION ------>
			<c:if test="${!empty errorMessage }">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}"></c:out>
					<c:out value="${login}"></c:out>
					<c:out value="${password}"></c:out>
				</div>
			</c:if>
			
			
			<article>
				<form action="/ProjetEncheresGroupe2/Connexion" method="POST">

					<fieldset>
						<!---------INPUT IDENTIFIANT ------>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i>Identifiant</i> </span> <input
									type="text" name="id" class="form-control"
									placeholder="Saisir ID" />

							</div>
						</div>
						<!---------INPUT PASSWORD ------>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i>Mot de passe</i> </span> <input
									type="password" name="mdp" class="form-control"
									placeholder="Saisir MdP" />
							</div>
						</div>
						<!---------BOUTON CONNECTION ------>
						<button type="submit" class="btn btn-success btn-block-connexion"
							style="float: left">connexion</button>
						<!---------CHECKBOX ------>
						<div class="form-check" style="float: right; width: 40%">
							<input type="checkbox" class="form-check-input" name="remember"
								id="exampleCheck1">


							<div class="form-check-label">
								<a href="mot-de-passe-oublie.php" class="form-check-label"
									id="pass"> Mot de passe oublié </a>
							</div>
						</div>
						<!---------MOT DE PASSE OUBLIE------>
						<button type="button" class="btn btn-success btn-block"
							onclick="window.location.href='registre.html';">créer un
							compte</button>
						<!---------BOUTON CREER COMPTE ------>
						<div class="forgot"></div>
					</fieldset>
				</form>

			</article>
		</section>
	</div>
</body>
</html>