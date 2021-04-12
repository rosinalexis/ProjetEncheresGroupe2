<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">

<%@ include file="miseEnPage/head.jsp"%>

<link
	href="<%=request.getContextPath()%>/dist/bootstrap/css/registre.css"
	rel="stylesheet">
<body>
	<%@ include file="miseEnPage/headercompte.jsp"%>

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
                                <i>Pseudo</i> ${pseudo}
								
                            </div>
                        </div>
                        <!---------INPUT NOM ------>
                        <div class="form-group">
                            <div  class="input-group"> 
                                <i>Nom</i> ${nom}
							
                            </div>
                        </div>
                        <!---------INPUT PRENOM ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Prénom</i>  ${prenom}
                              
                             

                            </div>
                        </div>
                        <!---------INPUT EMAIL ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Email</i> ${mail}
                               

                            </div>
                        </div>
                        <!---------INPUT TELEPHONE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Téléphone</i> ${telephone}
                                
                            </div>
                        </div>
                        <!---------INPUT RUE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Rue</i> ${rue}
                                

                            </div>
                        </div>
                        <!---------INPUT CODE POSTAL ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Code postal</i> ${code_postal}
                              
                            </div>
                        </div>
                        <!---------INPUT VILLE ------>
                        <div class="form-group">
                            <div  class="input-group">
                                <i>Ville</i> ${ville}
                                

                            </div>
                        </div>
                    </div>
                    <!---------INPUT MOT DE PASSE ------>



                    <!---------BOUTON CREER ------>
                    <a href="ModifProfil"><button type="button" name="submit"  class="btn btn-success btn-block-connexion" style="float: left;
                                                                   margin-left: 8%;
                                                                   margin-top: 8%;">Modifer</button></a>
                    <!---------BOUTON ANNULER ------>
                    <a href="Home"><button type="button" class="btn btn-success btn-block-annuler"  style="float: right;
                                                                                    margin-right: 8%;
                                                                                    margin-top: 8%;">Annuler</button></a>
                    <!---------Marge bottom------>
                    <div class="forgot"></div>

                </form>
            </article>
        </section>
    </div>
</body>

</html>
