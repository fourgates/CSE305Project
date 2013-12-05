<%-- 
    Document   : index
    Created on : Dec 5, 2013, 2:47:01 AM
    Author     : funfun
--%>

<%@page contentType="text/html" pageEncoding="x-windows-950"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>Facebook Plus</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<script language="javascript" type="text/javascript">
	function Button2_onclick() {
		window.open("registerPage.html", "_self");
	}
</script>
<link
	href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: cornflowerblue;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link
	href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-responsive.css" />
" rel="stylesheet">
</head>
<body style="text-align: center" onload='document.f.j_username.focus();'>
	<h1>Facebook +</h1>
	<h2>Sign into Facebook+</h2>
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<div class="container">

		<form class="form-signin" name='f'
			action="<c:url value='j_spring_security_check' />" method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" class="input-block-level" placeholder="Email address"name='j_username' value=''> 
			
			<input type="password"
				class="input-block-level" placeholder="Password" type='password' name='j_password'> 
				
				<label
				class="checkbox"> <input type="checkbox" value="remember-me">
				Remember me
			</label>
			<button class="btn btn-large btn-primary" name="submit" type="submit" value="submit" >Sign In</button>
		</form>

	</div>
	<!-- /container -->
	<!--<form name="myForm" action="login.jsp" method="post">
            <table align ="center">
                <tbody>
                    <tr>
                        <td>Username:</td><td><input name="username" placeholder="username" type="text"></td>
                    </tr>
                    <tr>
                        <td>Password:</td><td><input name="password" placeholder="password" type="password"></td>
                    </tr>
                    <tr>
                        <td><button type="button"> Login</button> </td>
                        <td><button type="button" onclick="return Button2_onclick()"> Register</button></td>
                    </tr>
                </tbody>
            </table>
           
     
        </form>
        -->

	<span style="font-size: 9px; color: gold;"> <br> Team USA<br>
		Computer Science Department <br> Stony Brook University
	</span>
	<script src="src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/jquery.js"></script>
	<!-- <c:url value="/resources/mytheme/bootstrap/js/jquery.js" /> -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-transition.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-modal.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-dropdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-scrollspy.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tab.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tooltip.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-popover.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-button.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-collapse.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-carousel.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-typeahead.js"></script>
</body>
</html>
