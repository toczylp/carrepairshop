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
    <!--<script type="text/javascript" src="/home/piotr/IdeaProjects/carrepairshop/src/main/webapp/WEB-INF/app.js"></script>-->

<%--    <script type="text/javascript">
            $(document).ready(function() {
                $('.btn-edit').parent().on('click', '.btn-edit', function () {
                    console.log("click");
                    //var sendData = $('#data').val();
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
                    <c:if test="${message == \"success\"}">
                    <p>Record has been added successfuly</p>
                    </c:if>
                    <c:if test="${message == \"invalid_inputs\"}">
                        <p>Invalid data has been found</p>
                        <p>Please input correct data!</p>
                    </c:if>
                    <c:if test="${message == \"no_repair\"}">
                        <p>No repair history for issued repairman</p>
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
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Car Id</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Production Year</th>
            <th>Registration No</th>
            <th>Next Inspection Date</th>
            <th>Client Id</th>
            <th>Edit</th>
            <th>not active</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${vehicles}" var="el" varStatus="status">
            <c:if test="${vehicles != null}">
                <tr>
                    <td>${el.vehicalId}</td>
                    <td>${el.brand}</td>
                    <td>${el.model}</td>
                    <td>${el.productionYear}</td>
                    <td>${el.registrationNo}</td>
                    <td>${el.nextInspectionDate}</td>
                    <td readonly>${el.clientId}</td>
                    <td>
                        <form action="<c:url value="/car_edit"/>" method="get">
                            <input type="number" name="id" hidden value="${el.vehicalId}"/>
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/repair_by_repairman"/>" method="post">
                            <input type="number" name="id" hidden value="${el.vehicalId}"/>
                            <button type="submit" class="btn btn-info">Repairs</button>
                        </form>
                    </td>
                    <td>
                        <form action="<c:url value="/car_remove"/>" method="get">
                            <input type="number" name="id" hidden value="${el.vehicalId}"/>
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
