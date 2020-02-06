<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>JSP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:useBean id="publicacion" class="com.uniovi.sdi.Publicacion" />
	<jsp:setProperty name="publicacion" property="*" />
	<c:if test="${publicacion.nombre != null}">
		<jsp:useBean id="publicacionService"
			class="com.uniovi.sdi.PublicacionesService" />
		<jsp:setProperty name="publicacionService" property="nuevaPublicacion"
			value="${publicacion}" />
		<c:redirect url="/blog" />
	</c:if>
	<!-- Contenido -->
	<div class="container" id="contenedor-principal">
		<h2>Blog</h2>
		<form class="form-horizontal" method="post" action="vista-blog.jsp">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nombre">Nombre de
					usuario:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="nombre"
						required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="comentario">Comentario:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="comentario"
						required="true" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Publicar</button>
				</div>
			</div>
		</form>


		<div class="row">

			<jsp:useBean id="publicacionesService"
				class="com.uniovi.sdi.PublicacionesService" />
			<c:forEach var="publicacion" begin="0"
				items="${publicacionesService.publicaciones}">
				<div>
					<div>
						<c:out value="Autor: ${publicacion.nombre}" />
					</div>
					<div>
						<c:out value="Comentario: ${publicacion.comentario}" />
					</div>
				</div>
			</c:forEach>

		</div>
	</div>



</body>
</html>