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
<c:if test="${not empty message}">
    <div class="modal" role="dialog" id="message_modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Feedback message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:if test="${message == \"success_del\"}">
                        <p>Record has been added successfuly</p>
                    </c:if>
                    <c:if test="${message == \"invalid_inputs\"}">
                        <p>Invalid data has been found</p>
                        <p>Please input correct data!</p>
                    </c:if>
                    <c:if test="${message == \"no_repair\"}">
                        <p>No repair history for issued repairman</p>
                    </c:if>
                    <c:if test="${message == \"fail\"}">
                        <p>Fail to delete record, failed to get data from DB</p>
                    </c:if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $("#message_modal").modal('show');
    </script>
</c:if>
<div class="container">
    <p><br><br></p>
    <form action="/repair_create" method="get">
        <div class="form-group">
            <label for="repair_start_planned">Planned Repair Start Date:</label>
            <input type="date" class="form-control" id="repair_start_planned" name="repair_start_planned">
        </div>
        <div class="form-group">
            <label for="vehicle_id">Vehicle Id:</label>
            <select class="form-control" id="vehicle_id" name="vehicle_id">
                <c:forEach items="${vehicles}" var="el">
                    <option value="${el.vehicalId}">${el.brand} ${el.model} ${el.registrationNo}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="defect_description">Defect Description:</label>
            <input type="text" class="form-control" id="defect_description" name="defect_description">
        </div>
        <div class="form-group">
            <label for="repairman_id">Assigned Repairman:</label>
             <select class="form-control" id="repairman_id" name="repairman_id">
                 <c:forEach items="${employees}" var="el">
                     <option value="${el.id}">${el.name} ${el.surname}</option>
                 </c:forEach>
            </select>
        </div>
        <div>
        <button type="submit" class="btn btn-default">Create Work Order</button>
        </div>
    </form>
</div>
<div class="well well-lg">
    <h4>Detailed Repair records:</h4>
</div>
<div class>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Repair Id</th>
            <th>Status</th>
            <th>Planned Start Date</th>
            <th>Start Date</th>
            <th>Car Brand</th>
            <th>Car Model</th>
            <th>Production Year</th>
            <th>Registration No</th>
            <th>Next Inspection</th>
            <th>Defect Description</th>
            <th>Repair Description</th>
            <th>Repair Cost</th>
            <th>Repair Hours</th>
            <th>Part Cost</th>
            <th>Repairman Surname</th>
            <th>Repairman Name</th>
            <th>Wage</th>
            <th>Client Surname</th>
            <th>Client Name</th>
            <th>Edit</th>
            <th>Change Status</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${repair_info}" var="el" varStatus="status">
            <c:if test="${repair_info != null}">
                <tr>
                    <td>${el.id}</td>
                    <td>${el.repairStatus}</td>
                    <td>${el.repairStartDatePlanned}</td>
                    <td>${el.repairStartDate}</td>
                    <td>${el.brand}</td>
                    <td>${el.model}</td>
                    <td>${el.productionYear}</td>
                    <td>${el.registrationNo}</td>
                    <td>${el.nextInspection}</td>
                    <td>${el.defectDescription}</td>
                    <td>${el.repairDescription}</td>
                    <td>${el.repairCost}</td>
                    <td>${el.repairHours}</td>
                    <td>${el.partsCost}</td>
                    <td>${el.nameRepairman}</td>
                    <td>${el.surnameRepairman}</td>
                    <td>${el.wageHourly}</td>
                    <td>${el.clientSurname}</td>
                    <td>${el.clientName}</td>
                    <td>
                        <form action="<c:url value="/employees_edit"/>" method="get">
                            <input type="number" name="id" hidden value="${el.id}"/>
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/update_repair_record"/>" method="get">
                            <input type="number" name="id" hidden value="${el.id}"/>
                            <button type="submit" class="btn btn-info">Update Record</button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/delete_repair_record"/>" method="get">
                            <input type="number" name="id" hidden value="${el.id}"/>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
