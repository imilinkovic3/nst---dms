<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        <%@include file="../bootstrap/css/userinformation-popup.css"%>
    </style>
</head>
<body id="userCreation_body">
<%@ include file="users_table.tag"%>
<%@ include file="user_information_popup.tag"%>
</body>

<script type="text/javascript"
        src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
    <%@include file="../../../js/userInformationPopup.js" %>
    <%@include file="../../../js/tableUsers.js" %>
</script>
</html>
