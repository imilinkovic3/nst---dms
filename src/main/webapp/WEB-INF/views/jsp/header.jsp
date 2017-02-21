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
        <label type="text" id="company">${currentUser.companyBean.name}</label>
    </div>
    <div class="header-right">
        <div class="one-line">
            <select id="selectView" class="form-control" size="1" onchange="changeView()">
                <option>Role</option>
                <c:forEach items="${currentUser.roles}" var="role">
                    <option value="homepage_" + ${role.title} + ".jsp">${role.title}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="header-left">
        <a class="link-css" href="/nst/logout/">Log out</a>
    </div>
</div>
<div class="fixed-content">
    <div class="container" id="mainContainer">
    </div>
</div>
<div class="left-menu">
    <ul>
        <li><a href="#">Users</a></li>
        <li><a href="#">Company</a></li>
    </ul>
</div>
<div class="fixed-footer">
    <div class="container">Copyright &copy; 2017 Irena Milinkovic & Milos Kuzmanovic</div>
</div>
</body>
</html>

<script type="text/javascript">
    function changeView() {
        var url = $('#selectView').val();
        console.log(url);
        $(location).attr('href', url);
    }
</script>