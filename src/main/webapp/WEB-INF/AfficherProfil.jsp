<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">

<%@ include file="miseEnPage/head.jsp"%>

<link
	href="<%=request.getContextPath()%>/dist/bootstrap/css/registre.css" rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headerConnecte.jsp"%>

    <!------ Include the above in your HEAD tag ---------->

    <div class="col-md-4 col-md-offset-4" id="login">
        <section id="inner-wrapper" class="login">
            <div style="text-align: center">
                <h2>Votre compte</h2>
            </div><br>
            <article>
                <form action="Profil" method="POST">
                    <div style="margin-left: 15%">
                        <!---------INPUT PSEUDO ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Pseudo : </i> <strong style="color:blue">${utilisateur.pseudo}</strong>
								
                            </div>
                        </div>
                        <!---------INPUT NOM ------>
                        <div class="form-group">
                            <div  class="input-group"> 
                                <i>Nom : </i> <strong style="color:blue">${utilisateur.nom}</strong>
                            </div>
                        </div>
                        <!---------INPUT PRENOM ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Prénom : </i> <strong style="color:blue"> ${utilisateur.prenom}</strong>
                              
                            </div>
                        </div>
                        <!---------INPUT EMAIL ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Email : </i><strong style="color:blue"> ${utilisateur.email}</strong>
                               

                            </div>
                        </div>
                        <!---------INPUT TELEPHONE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Téléphone : </i> <strong style="color:blue">${utilisateur.telephone}</strong>
                                
                            </div>
                        </div>
                        <!---------INPUT RUE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Rue : </i> <strong style="color:blue">${utilisateur.rue}</strong>
                                

                            </div>
                        </div>
                        <!---------INPUT CODE POSTAL ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Code postal : </i> <strong style="color:blue">${utilisateur.codePostal}</strong>
                              
                            </div>
                        </div>
                        <!---------INPUT VILLE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Ville : </i> <strong style="color:blue">${utilisateur.ville}</strong>
                                

                            </div>
                        </div>
                    </div>
                </form>
            </article>
        </section>
    </div>
</body>

</html>
