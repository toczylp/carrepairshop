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
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Repair Id</th>
            <th>Repair Start Date Planned</th>
            <th>Repair Start Date</th>
            <th>Assigned Repairman Id</th>
            <th>Defect Description</th>
            <th>Repair Description</th>
            <th>Status</th>
            <th>Vehical Id</th>
            <th>Repair Cost</th>
            <th>Parts Cost</th>
            <th>Wage Hourly</th>
            <th>Repair Hours</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${orders}" var="order" varStatus="status">
            <c:if test="${order != null}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.repairStartDatePlanned}</td>
                    <td>${order.repairStartDate}</td>
                    <td>${order.assignedRepairmanId}</td>
                    <td>${order.defectDescription}</td>
                    <td>${order.repairDescription}</td>
                    <td>${order.status}</td>
                    <td>${order.vehicalId}</td>
                    <td>${order.repairCost}</td>
                    <td>${order.partsCost}</td>
                    <td>${order.wageHourly}</td>
                    <td>${order.repairHours}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
