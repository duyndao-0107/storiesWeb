<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Writing Story</title>
    
    <!-- Library -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    
    <!-- Web Font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@0,200;0,300;0,400;0,600;0,700;0,900;1,200;1,300;1,400;1,600;1,700;1,900&display=swap"
        rel="stylesheet">
    
    <!-- Icon  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.css"
        integrity="sha512-FA9cIbtlP61W0PRtX36P6CGRy0vZs0C2Uw26Q1cMmj3xwhftftymr0sj8/YeezDnRwL9wtWw8ZwtCiTDXlXGjQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <!-- CSS styles -->
    <link rel="stylesheet" href="<c:url value='/resources/styles/writeStories.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/resources/styles/general.css'/>"/>

</head>

<body>
    <header class="header">
        <div class="header-back-btn">
            <i class="fa-solid fa-circle-chevron-left"></i>
        </div>
    </header>
    <div class="contain-bg">
        <div class="justify-content-center">
            <form:form class="form-floating col-lg-12 justify-content-center" method="post" modelAttribute="chapter">
				<!-- <textarea class="form-control chapter"
					placeholder="Type your text here" id="description"
					style="height: 100vh;" rows="10" cols="100">
				</textarea> -->
				<div class="chapter col-lg-12 mb-3 mt-5">
					<form:input type="text" path="chap-title" id="c-header"
						placeholder="Untitled Chapter" class="col-lg-12 fs-3 fw-bold text-center px-5"/>
				</div>
				<form:textarea class="form-control" path="desc" id="description"></form:textarea>
            	<div class="d-flex justify-content-center col-lg-12 btn-submit mt-3">
            		<input class="btn primary-btn-style px-4 py-2 fs-6 fw-bold" id="send" type="button" value="Submit">
            	</div>
			</form:form>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
</html>