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
    <h4>Edit below data:</h4>
</div>
<div class="container">
    <p><br><br></p>
    <form action="/update_repair_record" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="number" class="form-control" id="id" name="id" value="${order.id}" readonly>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control" id="status" name="status">
                <option value="${order.status}">Current Status : ${order.status}</option>
                <option value="in repair">In Repair</option>
                <option value="repair cost approved">Cost approved</option>
                <option value="ready to pick up">Ready to Pick Up</option>
                <option value="repair cancel">Repair Cancel</option>
            </select>
        </div>
        <div class="form-group">
            <label for="repair_start_date_planned">Pepair Start Date Planned:</label>
            <input type="text" class="form-control" id="repair_start_date_planned" name="repair_start_date_planned" value="${order.repairStartDatePlanned}" readonly>
        </div>
        <div class="form-group">
            <label for="assigned_repairman_id">Assigned Repairman Id:</label>
            <input type="number" class="form-control" id="assigned_repairman_id" name="assigned_repairman_id" value="${order.assignedRepairmanId}" readonly>
        </div>
        <div class="form-group">
            <label for="defect_description">Defect Description:</label>
            <input type="text" class="form-control" id="defect_description" name="defect_description" value="${order.defectDescription}">
        </div>
        <div class="form-group">
            <label for="repair_description">Repair Description:</label>
            <input type="text" class="form-control" id="repair_description" name="repair_description" value="${order.repairDescription}">
        </div>
        <div class="form-group">
            <label for="repair_cost">Repair Cost:</label>
            <input type="number" class="form-control" id="repair_cost" name="repair_cost" value="${order.repairCost}" readonly>
        </div>
        <div class="form-group">
            <label for="parts_cost">Parts Cost:</label>
            <input type="number" class="form-control" id="parts_cost" name="parts_cost" value="${order.partsCost}">
        </div>
        <div class="form-group">
            <label for="repair_hours">Repair Hours:</label>
            <input type="number" class="form-control" id="repair_hours" name="repair_hours" value="${order.repairHours}">
        </div>
        <button type="submit" class="btn btn-default">Save Changes</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
