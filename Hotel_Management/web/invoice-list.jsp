<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Invoices</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Add DataTables CSS link -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <div class="container invoice-container">
            <h1 class="text-center mb-4 mt-5">Invoice Management</h1>

            <c:if test="${param.success ne null}">
                <div class="alert alert-success" role="alert">
                    Update success!
                </div>
            </c:if>
            <c:if test="${param.fail ne null}">
                <div class="alert alert-danger" role="alert">
                    Update failed!
                </div>
            </c:if>

            <!-- Add Invoice Button -->
            <div class="w-100" style="text-align: end;">
                <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#addInvoiceModal">
                    Add Invoice
                </button>
            </div>

            <table id="invoiceTable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Invoice ID</th>
                        <th>User ID</th>
                        <th>Room ID</th>
                        <th>Check-In Date</th>
                        <th>Check-Out Date</th>
                        <th>Number of Persons</th>
                        <th>Note</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="invoice" items="${invoicesList}">
                        <tr>
                            <td>${invoice.inID}</td>
                            <td>${invoice.user.fullName}</td>
                            <td>${invoice.room.name}</td>
                            <td>${invoice.checkInDate}</td>
                            <td>${invoice.checkOutDate}</td>
                            <td>${invoice.numberPerson}</td>
                            <td>${invoice.note}</td>
                            <td>
                                <c:if test="${invoice.reservationStatus}">
                                    <a href="invoice?action=update&">Accecpt</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

        <!-- Add Invoice Modal -->
        <div class="modal fade" id="addInvoiceModal" tabindex="-1" role="dialog" aria-labelledby="addInvoiceModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addInvoiceModalLabel">Add Invoice</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="invoice" method="post">
                            <input type="hidden" class="form-control" name="action" value="add">

                            <div class="form-group">
                                <label for="userID">User ID:</label>
                                <input type="text" class="form-control" name="userId" required>
                            </div>

                            <div class="form-group">
                                <label for="roomID">Room ID:</label>
                                <input type="text" class="form-control" name="roomId" required>
                            </div>

                            <div class="form-group">
                                <label for="checkInDate">Check-In Date:</label>
                                <input type="date" class="form-control" name="checkInDate" required>
                            </div>

                            <div class="form-group">
                                <label for="checkOutDate">Check-Out Date:</label>
                                <input type="date" class="form-control" name="checkOutDate" required>
                            </div>

                            <div class="form-group">
                                <label for="numberPerson">Number of Persons:</label>
                                <input type="text" class="form-control" name="numberPerson" required>
                            </div>

                            <div class="form-group">
                                <label for="numberRoom">Number of Rooms:</label>
                                <input type="text" class="form-control" name="numberRoom" required>
                            </div>

                            <div class="form-group">
                                <label for="note">Note:</label>
                                <input type="text" class="form-control" name="note">
                            </div>

                            <input type="hidden" class="form-control" name="transactionCode" value="0">

                            <button type="submit" class="btn btn-primary">Add Invoice</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Include Bootstrap JS, Popper.js, and DataTables JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#invoiceTable').DataTable({
                    "pageLength": 5,
                    "lengthChange": false
                });
            });
        </script>

    </body>
</html>