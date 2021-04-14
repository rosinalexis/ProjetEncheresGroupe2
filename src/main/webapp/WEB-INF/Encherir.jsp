  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<%@ include file="miseEnPage/head.jsp" %>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/registre.css" rel="stylesheet"> 
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/style1.css" rel="stylesheet">
<body class="bg-light" style="background-color: #333;">
<%@ include file="miseEnPage/headercompte.jsp"%>
  <div class="container" style="background-color: white;">
        <div class="col-md-12 col-xs-12" style="text-align: center">
            <h2 class="titre_index" style="text-align: center">Détaile Vente</h2>
        </div>

        <div class="row" style='padding-bottom: 2%;'>
            <!------------------------------------------------- FIN   titre --------------------------------------------->


            <!------------------------------------------------- todo_section --------------------------------------------->

            <div class="col-md-4 col-sm-12">
                <div class="insertintoimage" style="   border: solid;
                                                            width: 84%;
                                                            height: 26%;
                                                            margin-left: 8%;
                                                            margin-top: 18%;">
                </div>
            </div>
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <!----- ARTICLE ----->
                    <div  style="margin-top: 10%;">
                        <span id="inputVente" ><i>Article :</i></span>

                    </div>
                    <!----- DESCRIPTION ----->
                    <div  class="input-group" style="margin-top: 2%;">
                        <span id="inputVente" ><i>Déscription :</i></span>

                    </div>
                    <br>
                    <br>
                    <!----- CATEGORIE ----->

                    <div  class="input-group" style="margin-top: 2%;">
                        <span id="inputVente"  >Catégorie</span>

                    </div>
                    <!----- MEILLEURE OFFRE ----->
                    <div  class="input-group" style="margin-top: 2%;">
                        <span id="inputVente"><i>Meilleure offre :</i></span>

                    </div>

                    <!----- MISE A PRIX ----->
                    <div  class="input-group" style="margin-top: 2%;">
                        <span id="inputVente" ><i>Mise à prix :</i></span>

                    </div>

                    <!----- FIN ENCHERE ----->
                    <div class="input-group" style="margin-top: 2%;">
                        <span id="inputVente"><i>Fin de l'enchère :</i></span>

                    </div>


                    <!----- RETRAIT ----->
                    <div  class="input-group" style="margin-top: 2%;">
                        <span id="inputVente"><i>Retrait :</i></span>

                    </div>

                    <div  class="input-group" style="margin-top: 2%;">

                        <span id="inputVente" ><i>Vendeur :</i></span>
                    </div>

                    <!------ENCHERIR ------>

                    <div  class="input-group" style="margin-top: 2%;">
                        <span class="input-group-addon" id="inputVente" >Ma proposition :</span>
                        <input type="number" id="tentacles" name="tentacles" min="10" max="1000" class="form-control" name="MiseAPRIX" required />

                        <!---------DIV BOUTON------->

                        <!---------BOUTON CREER ------>
                   </div>
                         <input type="button" name="envoi" value="Envoyer" class="btn btn-success btn-block-connexion" style="float:right"  />
                   
                </div>
            </div>
        </div>

    </div>
</body>

</html>