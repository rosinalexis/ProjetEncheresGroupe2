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
            <h2 class="titre_index" style="text-align: center">Bravo ench�re remport�</h2>
        </div>

        <div class="row" style='padding-bottom: 2%;'>
            <!------------------------------------------------- FIN   titre --------------------------------------------->


            <!------------------------------------------------- todo_section --------------------------------------------->

            <div class="col-md-4 col-sm-12">
                <div class="insertintoimage" style="width: 84%;height: 26%;margin-left: 8%;margin-top: 18%;">
                </div>
            </div>
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <!----- ARTICLE ----->
                    <div  style="margin-top: 10%;">
                        <span id="inputVente"><i>Article :</i></span>

                    </div>
                    <!----- DESCRIPTION ----->
                    <div  class="input-group" style="margin-top: 4%;">
                        <span id="inputVente" ><i>D�scription :</i></span>

                    </div>
                    <br>
                    <br>

                    <!----- MEILLEURE OFFRE ----->
                    <div  class="input-group" style="margin-top: 4%;">
                        <span id="inputVente" ><i>Meilleure offre :</i></span>

                    </div>

                    <!----- MISE A PRIX ----->
                    <div class="input-group" style="margin-top: 4%;">
                        <span id="inputVente" ><i>Mise � prix :</i></span>

                    </div>

                    <!----- FIN ENCHERE ----->



                    <!----- RETRAIT ----->
                    <div class="input-group" style="margin-top: 4%;">
                        <span id="inputVente" ><i>Retrait :</i></span>

                    </div>
                    <br>

                    <div  class="input-group" style="margin-top: 4%;">

                        <span id="inputVente"><i>Vendeur :</i></span>
                    </div>
                    <!----- TELEPHONE ----->

                    <div class="input-group" style="margin-top: 4%;">
                        <span id="inputVente" >T�l :</span>

                    </div>
                    <br><br>
                    <!------ENCHERIR ------>

                    <div  class="input-group" style="margin-top: 4%;">



                        <!---------DIV BOUTON------->

                        <!---------BOUTON CREER ------>
                       <a href="Home"><input type="button" name="envoi" value="Back" class="btn btn-success btn-block-connexion"  
                       style=" width: 120%; height: 8%; float: left;  margin-left:1%" /></a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>