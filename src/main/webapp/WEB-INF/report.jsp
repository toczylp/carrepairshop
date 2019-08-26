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
<c:if test="${message != null}">
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
                    <c:if test="${message = \"success\"}">
                        <p>Record has been added successfuly</p>
                    </c:if>
                    <c:if test="${message = \"invalid_inputs\"}">
                        <p>Invalid data has been found</p>
                        <p>Please input correct data!</p>
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
    <form action="/reports" method="post">
        <div class="form-group">
            <label for="report_type">Select Report type:</label>
            <select class="form-control" id="report_type" name="report_type">
                <option value="sallary_report"><p>Sallary Report</p></option>
                <option value="profit_loss_report">Profit and Loss Report</option>
            </select>
        </div>

        <div class="form-group">
            <label for="start_date">Start Date</label>
            <input type="date" class="form-control" id="start_date" name="start_date">
        </div>
        <div class="form-group">
        <label for="end_date">End Date:</label>
        <input type="date" class="form-control" id="end_date" name="end_date">
        </div>
        <div>
        <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </form>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Employee Name</th>
            <th>Employee Surname</th>
            <th>Salary</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${report != null}">
        <c:forEach items="${report}" var="el">
            <tr>
                <td>${el.name}</td>
                <td>${el.surname}</td>
                <td>${el.salary}</td>
            </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
