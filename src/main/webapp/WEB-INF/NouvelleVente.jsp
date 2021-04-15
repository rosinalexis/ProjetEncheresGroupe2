<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<%@ include file="miseEnPage/head.jsp" %>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/registre.css" rel="stylesheet"> 
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/style1.css" rel="stylesheet">
<body class="bg-light" style="background-color: #333;">
<%@ include file="miseEnPage/headerConnecte.jsp"%>
   <div class="container" style="background-color: white; border-radius: 12px !important;">
        <div class="col-md-12 col-xs-12" style="text-align: center">
            <h2 class="titre_index" style="text-align: center; margin-bottom:4%;">Nouvelle Vente</h2>
        </div>

        <div class="row" style='padding-bottom: 2%;'>
            <!------------------------------------------------- FIN   titre --------------------------------------------->


            <!------------------------------------------------- todo_section --------------------------------------------->

            <div class="col-md-4 col-sm-12">
                <div class="insertintoimage" style=" width: 84%;height: 26%; margin-left: 8%; margin-top: 18%;">
                ${afficheIMG}
                </div>
            </div>
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <!----- ARTICLE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente"  ><i>Article :</i></span>
                        <input type="text" class="form-control" name="article" required />
                    </div>
                    <!----- DESCRIPTION ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" ><i>Déscription :</i></span>
                        <textarea  class="form-control" id="exampleTextarea" rows="5">
                            </textarea>
                    </div>
                    <!----- CATEGORIE ----->
                    <div class="input-group mb-3" style="margin-top: 1%;">
                        <div class="input-group">
                            <span class="input-group-addon" id="inputVente" >Catégorie</span>
                            <select class="form-control" id="inputGroupSelect01" style="padding: 3px 12px;" >
                                <option selected>Choose...</option>
                                <option value="1">Informatique</option>
                                <option value="2">Ameublement</option>
                                <option value="3">Vêtement</option>
                                <option value="4">Sport&loisirs</option>
                            </select>
                        </div>
                    </div>
                    <!----- PHOTO DE L ARTICLE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" ><i>photo de l'article :</i></span>
                        <form name="myForm" action="">
                            <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg" >
                        </form>
                        <div id="imgContainer"></div>
                    </div>
                    <!----- MISE A PRIX ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" ><i>Mise à prix :</i></span>
                        <input type="number" id="tentacles" name="tentacles" min="10" max="1000" class="form-control" name="MiseAPRIX" required />
                    </div>
                    <!----- DEBUT ENCHERE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" ><i>Début de l'enchère :</i></span>
                        <input class="form-control" type="date" value="2020-09-14" id="example-date-input" >
                    </div>
                    <!----- FIN ENCHERE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" ><i>Fin de l'enchère :</i></span>
                        <input class="form-control" type="date" value="2020-09-14" id="example-date-input" >
                    </div>
                    <!------div retrait ------>
                    <div style="    margin-top:5%;      
                                        border: solid;
                                        border-radius: 8px;
                                        border-color: #00000040;">
                        <p style="  width : 54px;
                                    margin-left : 50px;
                                    margin-top: -12px;
                                    background-color : white;
                                    color: #00000080;
                                    text-align: center;">Retrait</P>
                        <!----- RUE ----->
                        <div  class="input-group" style="margin-top: 1%;">
                            <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;"><i>Rue :</i></span>
                            <input type="text" class="form-control" name="article" required />
                        </div>
                        <!----- CODE POSTAL ----->
                        <div class="input-group" style="margin-top: 1%;">
                            <span class="input-group-addon" id="inputVente" style="border: 0px solid #ccc;"><i>Code postal : </i></span>
                            <input type="text"  class="form-control" name="article" required />
                        </div>
                        <!----- VILLE ----->
                        <div class="input-group" style="margin-top:1%; margin-bottom:2%">
                            <span class="input-group-addon"><i>Ville :</i></span>
                            <input type="text" class="form-control"  name="article" required />
                        </div>
                    </div>
                    <!---------DIV BOUTON------->
                    <div style="margin-top: 8%">
                        <!---------BOUTON CREER ------>
                        <input type="submit" name="envoi" value="Envoyer" class="btn btn-success btn-block-connexion" style=" width: 20%;
                                                                                                                        height: 8%;
                                                                                                                        float: left; 
                                                                                                                        margin-left:18%" />
                        <script></script>
                        <!---------BOUTON ANNULER ------>
                        <a href="Home"><button type="button" class="btn btn-success btn-block-annuler"  style="     width: 20%;
                                    height: 8%;
                                    float: right;
                                    margin-right:18%">
                            Annuler
                        </button></a>
                    </div>
                </div>
            </div>
        </div>
        </div>

</body>

</html>
