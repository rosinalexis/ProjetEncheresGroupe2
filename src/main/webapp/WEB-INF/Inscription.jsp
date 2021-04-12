<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">

<%@ include file="miseEnPage/head.jsp"%>

<link
	href="<%=request.getContextPath()%>/dist/bootstrap/css/registre.css"
	rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headercompte.jsp"%>


	<div class="col-md-10 col-md-offset-1" id="login">
		<section id="inner-wrapper" class="login">
			<div style="text-align: center">
				<h2>Créer un compte</h2>
			</div>
			<br>

			<!---------VERIFICATION ------>
			<c:if test="${!empty errorMessage }">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}"></c:out>
				</div>
			</c:if>

			<c:if test="${!empty etatInscription }">
				<div class="alert alert-success" role="alert">
					<c:out value="${etatInscription}"></c:out>
				</div>
			</c:if>


			<article>
				<form action="/ProjetEncheresGroupe2/Inscription" method="POST">
					<!---------INPUT PSEUDO ------>

					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Pseudo</i></span> <input
								type="text" class="form-control" value="${pseudo}" name="pseudo">
							<label>${erreurPseudo}</label>
						</div>
					</div>
					<!---------INPUT NOM ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Nom</i></span> <input
								type="text" class="form-control" value="${nom}" name="nom">
							<label>${erreurNom}</label>
						</div>
					</div>
					<!---------INPUT PRENOM ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Prénom</i></span> <input
								type="text" class="form-control" value="${prenom}" name="prenom">
							<label>${erreurPrenom}</label>
						</div>
					</div>
					<!---------INPUT EMAIL ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Email</i></span> <input
								type="text" class="form-control" value="${email}" name="email">
							<label class="is-invalid">${erreurEmail}</label>
						</div>
					</div>
					<!---------INPUT TELEPHONE ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Téléphone</i></span> <input
								type="text" class="form-control" value="${telephone}"
								name="telephone"> <label>${erreurTelephone}</label>
						</div>
					</div>
					<!---------INPUT RUE ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Rue</i></span> <input
								type="text" class="form-control" value="${rue}" name="rue">
							<label>${erreurRue}</label>
						</div>
					</div>
					<!---------INPUT CODE POSTAL ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Code postal</i></span> <input
								type="text" class="form-control" value="${codePostal}"
								name="codePostal"> <label>${erreurPost}</label>
						</div>
					</div>
					<!---------INPUT VILLE ------>
					<div class="col-md-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Ville</i></span> <input
								type="text" class="form-control" value="${ville}" name="ville">
							<label>${erreurVille}</label>
						</div>
					</div>
					<!---------INPUT MOT DE PASSE ------>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Mot de passe</i></span> <input
								type="password" class="form-control" name="motDePasse" required />
						</div>
					</div>
					<!---------INPUT CONFIRMATION MDP ------>
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i>Confirmation</i></span> <input
								type="password" class="form-control" name="confirmation" /> <label>${erreurConfirm}
								${erreurMdp}</label>
						</div>
					</div>

					<!---------BOUTON CREER ------>
					<div class="col-md-2 col-md-offset-2">
						<input type="submit" name="submit"
							class="btn btn-success btn-block-connexion" style="float: left"
							onclick="window.location.href='../SeConnecter.html.html';" />
					</div>
					<!---------BOUTON ANNULER ------>
					<div class="col-md-2 col-md-offset-4">
						<button type="button" class="btn btn-success btn-block-annuler"
							onclick="window.location.href='../../index.html';"
							style="float: right">Annuler</button>
					</div>
					<!---------Marge bottom------>
					<div class="forgot"></div>

				</form>
			</article>
		</section>
	</div>
</body>
</html>
