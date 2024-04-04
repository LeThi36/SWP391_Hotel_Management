<%-- 
    Document   : cart
    Created on : Nov 1, 2023, 7:51:15 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <style>
            .loader {
                position: fixed;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                background-color: rgba(0,0,0,.65);
                backdrop-filter: blur(5px);
                justify-content: center;
                align-items: center;
                text-align: center;
                display: none;
                z-index: 2;
            }


            .container-fluid {
                z-index: 1
            }
            #popup {
                background-color: white;
                padding: 45px;
            }

            #confirm-btn {
                padding: 10px 30px;
                cursor: pointer;
                background-color: black;
                color: white
            }

            #confirm-btn:hover {
                background-color: #333
            }

            .dropdown-menu {
                left: 82%;
            }

            #trash:hover {
                background-color: #ddd;

                border-radius: 50%
            }
        </style>
    </head>
    <body>
        <div class="loader" id="loader">
            <p style="margin: auto" id="popup">
                Check-out successfully! Please check your order for confirmming!<br>
                <button id="confirm-btn" type="button" style="margin-top: 30px" onclick="turnOff()">
                    OK
                </button>
            </p>

        </div>
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

                                        <c:if test="${sessionScope.roomCart.size() eq 0}">
                                            <div class="row  justify-content-between" id="commit">
                                                <div class="col-auto col-md-9">
                                                    No product added! <a href="listroom">Back to shopping</a>
                                                </div>
                                            </div>
                                        </c:if>

                                        <c:if test="${sessionScope.roomCart.size() ne 0}">
                                            <table class="col-12">
                                                <thead style="font-weight: bold">
                                                    <tr>
                                                        <td>Room</td>
                                                        <td>Check-in Date</td>
                                                        <td>Check-out Date</td>
                                                        <td># Rooms</td>
                                                        <td># Person</td>
                                                        <td>Total</td>
                                                        <td>Action</td>
                                                    </tr>
                                                </thead>
                                                <c:set value="0" var="total"/>
                                                <c:forEach items="${sessionScope.roomCart}" var="i">
                                                    <c:set value="${total + i.getTotal()}" var="total"/>
                                                    <tr>
                                                        <td>
                                                            <img class=" img-fluid" src="${i.getRoom().getImg()}" width="62" height="62">
                                                            ${i.getRoom().getName()}
                                                        </td>
                                                        <td>${i.getCheckInDate()}</td>
                                                        <td>${i.getCheckOutDate()}</td>
                                                        <td class="text-center">${i.getNumberRoom()}</td>
                                                        <td class="text-center">${i.getNumberPerson()}</td>
                                                        <td>${String.format("%,.0f", i.getTotal())} VND</td>
                                                        <td>
                                                            <i style="color: red; cursor: pointer; padding: 5px 10px;" id="trash" class='bx bx-trash' onclick="remove(${i.getInID()})"></i>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>

                                        </c:if>


                                        <hr class="my-2">


                                        <div class="row ">
                                            <div class="col">
                                                <div class="row justify-content-between">
                                                    <div class="col-4"><p ><b>Total</b></p></div>
                                                    <div class="flex-sm-col col-auto"><p  class="mb-1"><b>${String.format("%,.0f",total)} VND</b></p> </div>
                                                </div><hr class="my-0">
                                            </div>
                                        </div>
                                        <div class="row mb-5 mt-4 ">
                                            <div class="col-md-7 col-lg-6 mx-auto"><button type="button" class="btn btn-block btn-outline-primary btn-lg" onclick="window.location.href = './paymentcart'">SUBMIT PAYMENT</button></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                function remove(id) {
                    fetch('addcart?id=' + id, {
                        method: 'POST'
                    });
                    location.reload();
                }
            </script>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </body>
</html>