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
<c:if test="${message == \"success\"}">
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
                    <p>Record has been added successfuly</p>
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
<c:if test="${message == \"invalid_inputs\"}">
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
                    <p>Invalid data has been found</p>
                    <p>Please input correct data!</p>
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
    <form action="/add_client" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" id="surname" name="surname">
        </div>
        <div class="form-group">
            <label for="date_of_birth">Date Of Birth:</label>
            <input type="date" class="form-control" id="date_of_birth" name="date_of_birth">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" nameRepairman="email">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of Birth</th>
            <th>Mail</th>
            <th>Edit</th>
            <th>Assign Car</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${clients != null}">
        <c:forEach items="${clients}" var="el">
            <tr>
                <td>${el.id}</td>
                <td>${el.name}</td>
                <td>${el.surname}</td>
                <td>${el.dateOfBirth}</td>
                <td><a href="mailto:${el.mail}">${el.mail}</a></td>
                <td>
                    <form action="<c:url value="/client_edit"/>" method="get">
                        <input type="number" name="id" hidden value="${el.id}"/>
                        <button type="submit" class="btn btn-warning">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/car_assign"/>" method="get">
                        <input type="number" name="id" hidden value="${el.id}"/>
                        <button type="submit" class="btn btn-info">Assign Car</button>
                    </form>
                </td>
                <td>
                    <form action="<c:url value="/remove_client"/>" method="get">
                        <input type="number" name="id" hidden value="${el.id}"/>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
