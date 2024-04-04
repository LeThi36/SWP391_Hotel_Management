<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <div class=" container-fluid my-5 ">
            <div class="row justify-content-center ">
                <div class="col-xl-10">
                    <div class="card shadow-lg ">
                        <div class="row  mx-auto justify-content-center text-center">
                            <div class="col-12 mt-3 ">
                                <nav aria-label="breadcrumb" class="second ">
                                    <ol class="breadcrumb indigo lighten-6 first  " >
                                        <li class="breadcrumb-item font-weight-bold "><a style="color: black" class="black-text text-uppercase " href="home"><span class="mr-md-3 mr-1">BACK TO SHOP</span>\</li>
                                        <li class="breadcrumb-item font-weight-bold"><a style="color: black" class="black-text text-uppercase"><span class="mr-md-3 mr-1">SHOPPING BAG</span>\</li>
                                        <li class="breadcrumb-item font-weight-bold"><a style="color: black" class="black-text text-uppercase active-2"><span class="mr-md-3 mr-1">CHECKOUT</span></a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>

                        <div class="row justify-content-around">
                            <div class="col-10">
                                <div class="card border-0 ">
                                    <div class="card-header card-2" style="margin-bottom: 10px">
                                        <p class="card-text text-muted mt-md-4  mb-2 space" >YOUR ORDER </p>
                                        <hr class="my-2">
                                    </div>
                                    <div class="card-body pt-0">

                                        <c:if test="${invoicesList.size() eq 0}">
                                            <div class="row  justify-content-between" id="commit">
                                                <div class="col-auto col-md-9">
                                                    No room booked! <a href="listroom">Back to shopping</a>
                                                </div>
                                            </div>
                                        </c:if>

                                        <c:if test="${invoicesList.size() ne 0}">
                                            <table class="col-12" id="roomTable">
                                                <thead style="font-weight: bold">
                                                    <tr>
                                                        <td>Room</td>
                                                        <td>Check-in Date</td>
                                                        <td>Check-out Date</td>
                                                        <td># Rooms</td>
                                                        <td># Person</td>
                                                        <td>Action</td>
                                                    </tr>
                                                </thead>
                                                <c:set value="0" var="total"/>
                                                <c:forEach items="${invoicesList}" var="i">
                                                    <tr>
                                                        <td>
                                                            <img class=" img-fluid" src="${i.getRoom().getImg()}" width="62" height="62">
                                                            ${i.getRoom().getName()}
                                                        </td>
                                                        <td>${i.getCheckInDate()}</td>
                                                        <td>${i.getCheckOutDate()}</td>
                                                        <td class="text-center">${i.getNumberRoom()}</td>
                                                        <td class="text-center">${i.getNumberPerson()}</td>
                                                        <td>
                                                            <c:if test="${i.isIsEnded() && i.getReservationStatus() != 2}">
                                                                <i style="color: red; cursor: pointer; padding: 5px 10px;" id="trash" onclick="cancel(${i.getInID()})">Cancel </i>
                                                            </c:if>
                                                            <c:if test="${i.isIsEnded() && i.getReservationStatus() == 2}">
                                                                <i style="color: #003eff; padding: 5px 10px;" id="trash">Cancelled</i>
                                                            </c:if>
                                                            <c:if test="${!i.isIsEnded()}">
                                                                <i style="color: gray; padding: 5px 10px;" id="trash">None</i>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>

                                        </c:if>
                                        <hr class="my-2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

        <script>
                                                                    $(document).ready(function () {
                                                                        $('#roomTable').DataTable({
                                                                            "pageLength": 10,
                                                                            "lengthChange": true
                                                                        });
                                                                    });
        </script>

        <script>
            function cancel(id) {
                window.location.href = `./cancel?id=` + id;
            }
        </script>
    </body>
</html>