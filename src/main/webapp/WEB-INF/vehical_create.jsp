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
    <form action="/car_assign" method="post">
        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" class="form-control" id="brand" name="brand">
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" class="form-control" id="model" name="model">
        </div>
        <div class="form-group">
            <label for="production_year">Production Year:</label>
            <input type="number" class="form-control" id="production_year" name="production_year">
        </div>
        <div class="form-group">
            <label for="registration_no">Registration no:</label>
            <input type="text" class="form-control" id="registration_no" name="registration_no">
        </div>
        <div class="form-group">
            <label for="next_inspection">Next Inspection Date:</label>
            <input type="date" class="form-control" id="next_inspection" name="next_inspection">
        </div>
        <div class="form-group">
            <label for="client_id">Client id:</label>
            <input type="number" class="form-control" id="client_id" name="client_id" value="${id}" readonly>
        </div>
        <button type="submit" class="btn btn-default">Apply</button>
    </form>
</div>
<div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
