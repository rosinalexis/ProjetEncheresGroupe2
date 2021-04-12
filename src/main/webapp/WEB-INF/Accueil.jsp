<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>

<html lang="fr">
<%@ include file="miseEnPage/head.jsp" %>
<body class="bg-light" style="background-color: #333">
<%@ include file="miseEnPage/header.jsp" %>
<!------------------------------------------------- TITRE --------------------------------------------->
    <div class="container" style="background-color: white;">
        <div class="col-md-12 col-xs-12" style="text-align: center">
            <h2 class="titre_index" style="text-align: center">Liste des enchères</h2>
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
	                                <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status">
	                            </div>
	                        </form>
                    </section>


                    <section class="second">
                        <label  for="categorie" >Catégorie :</label>
                            <select class="form-control mb-2 mr-sm-2" id="categorie" >
                                <option value="">Toutes Catégories</option>
                                <option value="info">Informatique</option>
                                <option value="ameu">Ameublement</option>
                                <option value="vet">Vêtement</option>
                                <option value="spetlois">Sport et Loisirs</option>
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

            <div class="col-md-6 col-xs-8 " id="pad_btn" style="padding-top: 30px">
                <input type="button" value="Rechecher" class="btn btn-secondary btn-lg " onclick="window.location.href='assets/SeConnecter';" id="btn_search">
            </div>

        </div>


        <footer class="my-5 pt-5 text-muted text-center text-small">

        </footer>

        <div class="forgot" style="font-size: 16px;">

        </div>


    </div>

    <script>
        window.jQuery || document.write('<script src="assets/bootstrap/bootstrap-4.5.3-dist/js/jquery.slim.min.js"><\/script>')

    </script>
    <script src="assets/style/bootstrap/bootstrap-4.5.3-dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/style/bootstrap/bootstrap-3.4.1-dist/js/form-validation.js"></script>

</body>
 </html>