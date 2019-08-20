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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="well well-lg">
    <h4>Repair records of ${repair_info[0].nameRepairman}  ${repair_info[0].surnameRepairman} :</h4>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Repair Id</th>
            <th>Repair Start Date</th>
            <th>Defect Description</th>
            <th>Repair Description</th>
            <th>Repair Status</th>
            <th>Car Brand</th>
            <th>Car Model</th>
            <th>Registration No</th>
            <th>Repair Hours</th>
            <th>Repair Cost</th>
            <th>Repairman name</th>
            <th>Repairman Surname</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${repair_info}" var="el" varStatus="status">
            <c:if test="${repair_info != null}">
                <tr>
                    <td>${el.id}</td>
                    <td>${el.repairStartDate}</td>
                    <td>${el.defectDescription}</td>
                    <td>${el.repairDescription}</td>
                    <td>${el.status}</td>
                    <td>${el.model}</td>
                    <td>${el.brand}</td>
                    <td>${el.registrationNo}</td>
                    <td>${el.repairHours}</td>
                    <td>${el.repairCost}</td>
                    <td>${el.nameRepairman}</td>
                    <td>${el.surnameRepairman}</td>

                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
