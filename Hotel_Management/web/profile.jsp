<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>User Profile</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Your Custom Styles -->
        <style>
            .profile-container {
                max-width: 600px;
                margin: 50px auto;
            }
        </style>
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <div class="container profile-container">
            <h1 class="text-center mb-4">User Profile</h1>

            <c:if test="${param.success ne null}">
                <div class="alert alert-success" role="alert">
                    Update success!
                </div>
            </c:if>

            <form action="profile" method="post">
                <input type="hidden" name="id" value="${user.userId}" readonly>

                <div class="form-group">
                    <label for="username">Email:</label>
                    <input type="text" class="form-control" name="username" value="${user.email}" readonly>
                </div>
                <div class="form-group">
                    <label for="fullName">Full Name:</label>
                    <input type="text" class="form-control" name="fullName" value="${user.fullName}">
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="tel" class="form-control" name="phone" value="${user.phone}" >
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth:</label>
                    <input type="date" class="form-control" name="dob" value="${user.dob}">
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <select class="form-control" name="gender">
                        <c:choose>
                            <c:when test="${user.gender == '1'}">
                                <option value="Male" selected>Male</option>
                                <option value="Female">Female</option>
                            </c:when>
                            <c:otherwise>
                                <option value="Male">Male</option>
                                <option value="Female"selected>Female</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>

                <button class="btn btn-primary">Update</button>
            </form>
        </div>

        <!-- Include Bootstrap JS and Popper.js -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
