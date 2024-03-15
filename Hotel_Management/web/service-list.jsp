<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Service List</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Add DataTables CSS link -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div class="container profile-container">
            <h1 class="text-center mb-4 mt-5">Service List</h1>

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

            <div class="w-100 text-right">
                <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#addModal">Add Service</button>
            </div>

            <table id="serviceTable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Service ID</th>
                        <th>Service Name</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="service" items="${serviceList}">
                        <tr>
                            <td>${service.seID}</td>
                            <td>${service.serviceName}</td>
                            <td>${service.status==1 ? "Visible" : "Invisible"}</td>
                            <td>
                                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal"
                                        data-target="#editModal${service.seID}">
                                    Edit
                                </button>
                            </td>
                        </tr>

                        <!-- Edit Modal for each service -->
                    <div class="modal fade" id="editModal${service.seID}" tabindex="-1" role="dialog"
                         aria-labelledby="editModalLabel${service.seID}" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="editModalLabel${service.seID}">Edit Service</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="service?action=update" method="post">
                                        <input type="hidden" name="action" value="update">
                                        <input type="hidden" name="seID" value="${service.seID}">

                                        <div class="form-group">
                                            <label for="serviceName">Service Name:</label>
                                            <input type="text" class="form-control" name="serviceName" value="${service.serviceName}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="status">Status:</label>
                                            <select class="form-control" name="status" required>
                                                <option value="1" ${service.status == 1 ? 'selected' : ''}>Visible</option>
                                                <option value="0" ${service.status == 0 ? 'selected' : ''}>Hidden</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="icon">Image:</label>
                                            <input type="text" class="form-control" name="icon" value="${service.icon}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="description">Description:</label>
                                            <textarea class="form-control" name="description" rows="4" required>${service.description}</textarea>
                                        </div>

                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>

            <!-- Add Service Modal -->
            <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addModalLabel">Add Service</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="service?action=add" method="post">
                                <input type="hidden" name="action" value="add">

                                <div class="form-group">
                                    <label for="serviceName">Service Name:</label>
                                    <input type="text" class="form-control" name="serviceName" required>
                                </div>

                                <div class="form-group">
                                    <label for="status">Status:</label>
                                    <select class="form-control" name="status" required>
                                        <option value="1">Visible</option>
                                        <option value="0">Hidden</option>
                                    </select>
                                </div>

                                <div class="form-group" style="display: none">
                                    <label for="icon">Image:</label>
                                    <input type="text" class="form-control" name="icon">
                                </div>

                                <div class="form-group">
                                    <label for="description">Description:</label>
                                    <textarea class="form-control" name="description" rows="4" required></textarea>
                                </div>

                                <button type="submit" class="btn btn-primary">Add Service</button>
                            </form>
                        </div>
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
                $('#serviceTable').DataTable({
                    "pageLength": 5,
                    "lengthChange": false
                });
            });
        </script>

    </body>
</html>
