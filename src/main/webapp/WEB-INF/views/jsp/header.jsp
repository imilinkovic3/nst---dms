<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <style type="text/css">
        <%@include file="../bootstrap/css/template.css"%>

    </style>
</head>
<body>
<div class="fixed-header">

        <div class="company-name">
            <output type="text" id="company">${currentUser.companyBean.name}</output>
        </div>
        <div class=" header-right">
            <div class="one-line">
                <output type="text" id="user_roles">Change view</output>
                <select size="1" onchange="window.location=this.options[this.selectedIndex].value">
                    <c:forEach items="${currentUser.roles}" var="role">
                        <option value="homepage_user.jsp">${role.title}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <a class="link-css" href="prijavi_se.jsp">Log out</a>

            </div>

            <%--<nav>--%>
            <%--<a href="#">Home</a>--%>
            <%--<a href="#">About</a>--%>
            <%--<a href="#">Products</a>--%>
            <%--<a href="#">Services</a>--%>
            <%--<a href="#">Contact Us</a>--%>
            <%--</nav>--%>
        </div>

</div>
<div class="fixed-content">
    <div class="container ">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit...</p>
    </div>
</div>
<div class="left-menu">

    <ul>
        <li><a href="#">Users</a></li>
        <li><a href="#">Company informations</a></li>
    </ul>
</div>
<div class="fixed-footer">
    <div class="container">Copyright &copy; 2017 Irena Milinkovic & Milos Kuzmanovic</div>
</div>
</body>
</html>