<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Car Repair Shop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<%--    <script type="text/javascript">
            $(document).ready(function() {
                $('.btn-edit').parent().on('click', '.btn-edit', function () {
                    console.log("click");
                    //var sendData = $('#data').val();

                    $.ajax({
                        url: '/employees_edit_delete',    //Your api url
                        type: 'DELETE',   //type is any HTTP method
                        data: {
                            //data: sendData
                        },      //Data as js object
                        success: function () {
                        }
                    })
                    ;
                });
            });
    </script>--%>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="well well-lg">
    <h4>Edit below data:</h4>
</div>
<div class="container">
    <p><br><br></p>
    <form action="/client_edit" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="number" class="form-control" id="id" name="id" value="${client.id}" readonly>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${client.name}">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" id="surname" name="surname" value="${client.surname}">
        </div>
        <div class="form-group">
            <label for="date_of_birth">Date of Birth:</label>
            <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" value="${client.dateOfBirth}">
        </div>
        <div class="form-group">
            <label for="mail">Mail:</label>
            <input type="text" class="form-control" id="mail" name="mail" value="${client.mail}">
        </div>
        <button type="submit" class="btn btn-default">Save Changes</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
