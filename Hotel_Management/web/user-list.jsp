<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>User Profile</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Add DataTables CSS link -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <div class="container profile-container">
            <h1 class="text-center mb-4 mt-5">Receptionist Management</h1>

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

            <!-- Add User Button -->
            <div class="w-100" style="text-align: end;">
                <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#addUserModal">
                    Add User
                </button>
            </div>

            <table id="userTable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Gender</th>
                        <th>DOB</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <c:if test="${user.role eq 2}">
                            <tr>
                                <td>${user.userId}</td>
                                <td>${user.fullName}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td>${user.gender=="1" ? "Male" : "Female"}</td>
                                <td>${user.dob}</td>
                                <td>
                                    <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#editModal${user.userId}">
                                        Edit
                                    </button>
        <!--                                <a href="user?action=ban&userId=${user.userId}&status=false" class="btn btn-danger btn-sm">Ban</a>
                                    <a href="user?action=ban&userId=${user.userId}&status=true" class="btn btn-danger btn-sm">Unban</a>-->
                                </td>
                            </tr>
                        </c:if>



                        <!-- Edit Modal for each user -->
                    <div class="modal fade" id="editModal${user.userId}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel${user.userId}" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="editModalLabel${user.userId}">Edit User</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="user?action=update" method="post">
                                        <input type="hidden" name="userId" value="${user.userId}">
                                        <input type="hidden" class="form-control" name="password" value="${user.password}">

                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="email" class="form-control" name="email" value="${user.email}" required readonly>
                                        </div>

                                        <div class="form-group">
                                            <label for="phonenumber">Phone Number:</label>
                                            <input type="text" class="form-control" name="phonenumber" value="${user.phone}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="fullName">Full Name:</label>
                                            <input type="text" class="form-control" name="fullName" value="${user.fullName}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="gender">Gender:</label>
                                            <select class="form-control" name="gender" required>
                                                <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
                                                <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="dob">Date of Birth:</label>
                                            <input type="date" class="form-control" name="dob" value="${user.dob}" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="role">Role:</label>
                                            <select class="form-control" name="role" required>
                                                <option value="1" ${user.role == 1 ? 'selected' : ''}>Admin</option>
                                                <option value="0" ${user.role == 0 ? 'selected' : ''}>User</option>
                                                <option value="2" ${user.role == 2 ? 'selected' : ''}>Receptionist</option>
                                            </select>
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

        </div>

        <!-- Add User Modal -->
        <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addUserModalLabel">Add User</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Add your user creation form fields here -->
                        <!-- For simplicity, assuming similar fields as in user-form.jsp -->
                        <form action="user?action=create" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" name="email" required>
                            </div>

                            <div class="form-group">
                                <label for="phonenumber">Phone Number:</label>
                                <input type="text" class="form-control" name="phonenumber" required>
                            </div>

                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" name="password" required>
                            </div>

                            <div class="form-group">
                                <label for="fullName">Full Name:</label>
                                <input type="text" class="form-control" name="fullName" required>
                            </div>

                            <div class="form-group">
                                <label for="gender">Gender:</label>
                                <select class="form-control" name="gender" required>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="dob">Date of Birth:</label>
                                <input type="date" class="form-control" name="dob" required>
                            </div>

<!--                            <div class="form-group">
                                <label for="role">Role:</label>
                                <select class="form-control" name="role" required>
                                    <option value="0">User</option>
                                    <option value="1">Admin</option>
                                </select>
                            </div>-->

                            <button type="submit" class="btn btn-primary">Create User</button>
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
                $('#userTable').DataTable({
                    "pageLength": 5,
                    "lengthChange": false
                });
            });
        </script>

    </body>
</html>
