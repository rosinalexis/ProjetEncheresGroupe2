
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>

<html lang="fr">
<%@ include file="miseEnPage/head.jsp" %>
<link href="<%=request.getContextPath() %>/dist/bootstrap/css/style1.css" rel="stylesheet">

<body class="bg-light" style="background-color: #333;">
<%@ include file="miseEnPage/headercompte.jsp" %>
 <div class="container" style="background-color: white;">
        <div class="col-md-12 col-xs-12" style="text-align: center">
            <h2 class="titre_index" style="text-align: center">Nouvelle Vente</h2>
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
            <form action="">
            <div class="col-md-6 col-sm-12">
                <div class="form-group">
                    <!----- ARTICLE ----->
                    <div  class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Article :</i></span>
                        <input type="text" class="form-control" name="article" required style="margin-left:12%; width: 88%;" />
                    </div>
                    <!----- DESCRIPTION ----->
                    <div  class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Déscription :</i></span>
                        <textarea style="margin-left:6%; width: 94%;" class="form-control" id="exampleTextarea" rows="3">
                            </textarea>
                    </div>
                    <!----- CATEGORIE ----->
                    <div class="input-group mb-3" style="margin-top: 1%;">
                        <div class="input-group">
                            <span class="input-group-addon" id="inputVente"  style=" border: 0px solid #ccc;
                                                                        background-color:white !important;">Catégorie</span>
                            <select class="form-control" id="inputGroupSelect01" style="margin-left:33%; width: 316%;">
                                <option selected>Choose...</option>
                                <option value="1">Informatique</option>
                                <option value="2">Ameublement</option>
                                <option value="3">Vêtement</option>
                                <option value="4">Sport&loisirs</option>
                            </select>
                        </div>
                    </div>
                    <!----- PHOTO DE L ARTICLE ----->
                    <div  class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>photo de l'article :</i></span>
                        <form name="myForm" action="">
                            <input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg" onclick="loadPic()">
                        </form>
                        <div id="imgContainer"></div>
                    </div>
                    <!----- MISE A PRIX ----->
                    <div  class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Mise à prix :</i></span>
                        <input type="number" id="tentacles" name="tentacles" min="10" max="1000" class="form-control" name="MiseAPRIX" style="margin-left:7%; width: 93%;" required />
                    </div>
                    <!----- DEBUT ENCHERE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Début de l'enchère :</i></span>
                        <input class="form-control" type="date" value="2020-09-14" id="example-date-input" style="margin-left:4%; width: 96%;">
                    </div>
                    <!----- FIN ENCHERE ----->
                    <div class="input-group" style="margin-top: 1%;">
                        <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Fin de l'enchère :</i></span>
                        <input class="form-control" type="date" value="2020-09-14" id="example-date-input" style="margin-left: 8%;width: 92%;">
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
                            <span class="input-group-addon" id="inputVente" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Rue :</i></span>
                            <input type="text" style="margin-left: 10%; width: 88%;" class="form-control" name="article" required />
                        </div>
                        <!----- CODE POSTAL ----->
                        <div class="input-group" style="margin-top: 1%;">
                            <span class="input-group-addon" id="inputVente" style="     border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Code postal : </i></span>
                            <input type="text" style="width: 98%;" class="form-control" name="article" required />
                        </div>
                        <!----- VILLE ----->
                        <div  class="input-group" style="padding: 2%;">
                            <span class="input-group-addon" style=" border: 0px solid #ccc;
                                                                        background-color:white !important;"><i>Ville :</i></span>
                            <input type="text" class="form-control" style="margin-left: 8%; width: 92%;" name="article" required />
                        </div>
                    </div>
                    <!---------DIV BOUTON------->
                    <div style="margin-top: 8%">
                        <!---------BOUTON CREER ------>
                        <input type="button" name="envoi" value="Envoyer" class="btn btn-success btn-block-connexion" onclick="window.location.href='nouvelleVenteVerification.html';" style=" width: 20%;
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
            </form>
        </div>
        <script>
            var loadPic = function() {
                alert("loadPic started");
                $("#imgContainer").html('<img/>');
                $("img").attr("src", "#");
                alert("loadPic finished");
            }

        </script>
        </div>
</body>

</html>