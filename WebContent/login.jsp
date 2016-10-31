<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <!--css-->
    <link rel="stylesheet" href="<c:url value='/css/login/reset.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/login/supersized.css'/>">

</head>
<body oncontextmenu="return false">

<!--包括登录的DIV块-->
<div class="page-container">
    <h1>Login</h1>

    <form action="check" method="post">
        <div>
            <div>
            <input id="username" type="text" name="userName" placeholder="Username" autocomplete="off"/>
                <span id="usernameMsg" ></span>
            </div>

        </div>
        <div>
            <div>
            <input id="password" type="password" name="userPassword" placeholder="Password" oncontextmenu="return false"
                   onpaste="return false"/>
                <span id="passwordMsg"></span>
            </div>
        </div>
        <div>
            <input type="submit" value="Sign in" class="loginBtn"/>
        </div>
    </form>
</div>

<div class="connect">
    <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
    <p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
</div>


<script src="<c:url value='/js/jquery-1.7.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/login/supersized.3.2.7.min.js'/>"></script>
<script src="<c:url value='/js/login/supersized-init.js'/>"></script>
<script src="<c:url value='/js/login/loginPage.js'/>"></script>

</body>
</html>