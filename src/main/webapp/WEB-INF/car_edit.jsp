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
    <form action="/car_edit" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="number" class="form-control" id="id" name="id" value="${vehicle.vehicalId}" readonly>
        </div>
        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" class="form-control" id="brand" name="brand" value="${vehicle.brand}">
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" class="form-control" id="model" name="model" value="${vehicle.model}">
        </div>
        <div class="form-group">
            <label for="production_year">Production Year:</label>
            <input type="number" class="form-control" id="production_year" name="production_year" value="${vehicle.productionYear}">
        </div>
        <div class="form-group">
            <label for="registration_no">Registration No:</label>
            <input type="text" class="form-control" id="registration_no" name="registration_no" value="${vehicle.registrationNo}">
        </div>
        <div class="form-group">
            <label for="next_inspection">Next Inspection:</label>
            <input type="date" class="form-control" id="next_inspection" name="next_inspection" value="${vehicle.nextInspectionDate}">
        </div>
        <div class="form-group">
            <label for="client_id">Client Id:</label>
            <input type="number" class="form-control" id="client_id" name="client_id" value="${vehicle.clientId}" readonly>
        </div>
        <button type="submit" class="btn btn-default">Save Changes</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
