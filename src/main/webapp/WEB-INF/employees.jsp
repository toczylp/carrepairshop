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
    <form action="/employees" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" id="surname" name="surname">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <div class="form-group">
            <label for="phone_number">Phone no:</label>
            <input type="number" class="form-control" id="phone_number" name="phone_number">
        </div>
        <div class="form-group">
            <label for="note">Description:</label>
            <input type="text" class="form-control" id="note" name="note">
        </div>
        <div class="form-group">
            <label for="wage">Wage:</label>
            <input type="number" class="form-control" id="wage" name="wage">
        </div>
        <button type="submit" class="btn btn-default">Add New Employee</button>
    </form>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Surname</th>
            <th>Employee Address</th>
            <th>Employee Phone no</th>
            <th>Employee Description</th>
            <th>Employee Wage</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${employees}" var="employee" varStatus="status">
            <c:if test="${employees != null}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phoneNo}</td>
                    <td>${employee.note}</td>
                    <td>${employee.wageHourly}</td>
                    <td>
                        <form action="<c:url value="/employees_edit"/>" method="get">
                            <input type="number" name="id" hidden value="${employee.id}"/>
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/remove_employee"/>" method="get">
                            <input type="number" name="id" hidden value="${employee.id}"/>
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
