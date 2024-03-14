<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Room Management</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Add DataTables CSS link -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
        
        <style>
            * {
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <div class="container profile-container">
            <h1 class="text-center mb-4 mt-5">Room Management</h1>

            <table id="roomTable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Room ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Size</th>
                        <th>Capacity</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="room" items="${roomList}">
                        <tr>
                            <td>${room.RID}</td>
                            <td>${room.name}</td>
                            <td>${room.price}</td>
                            <td>${room.size}</td>
                            <td>${room.capacity}</td>
                            <td>${room.status}</td>
                            <td>
                                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#roomEditModal${room.RID}">
                                    Edit
                                </button>
                                <a class="btn btn-secondary" href="service?id=${room.RID}">Services</a>
                            </td>
                        </tr>

                        <!-- Room Edit Modal -->
                    <div class="modal fade" id="roomEditModal${room.RID}" tabindex="-1" role="dialog" aria-labelledby="roomEditModalLabel${room.RID}" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="roomEditModalLabel${room.RID}">Edit Room</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!-- Form for editing room details -->
                                    <form action="roomController?action=update" method="post">
                                        <input type="hidden" name="roomId" value="${room.RID}">

                                        <div class="form-group">
                                            <label for="name">Name:</label>
                                            <input type="text" class="form-control" name="name" value="${room.name}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="price">Price:</label>
                                            <input type="number" class="form-control" name="price" value="${room.price}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="size">Size:</label>
                                            <input type="number" class="form-control" name="size" value="${room.size}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="capacity">Capacity:</label>
                                            <input type="number" class="form-control" name="capacity" value="${room.capacity}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="img">Image URL:</label>
                                            <input type="text" class="form-control" name="img" value="${room.img}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="status">Status:</label>
                                            <input type="text" class="form-control" name="status" value="${room.status}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="bid">Building ID:</label>
                                            <input type="number" class="form-control" name="bid" value="${room.BID}" required>
                                        </div>

                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Room Edit Modal -->

                </c:forEach>
                </tbody>
            </table>

        </div>

        <!-- Include Bootstrap JS, Popper.js, and DataTables JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#roomTable').DataTable({
                    "pageLength": 5,
                    "lengthChange": false
                });
            });
        </script>

    </body>
</html>