<%-- 
    Document   : listrooms
    Created on : Jan 20, 2024, 2:23:09 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Sona Template">
        <meta name="keywords" content="Sona, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sona | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/flaticon.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">


    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Offcanvas Menu Section Begin -->
        <div class="offcanvas-menu-overlay"></div>
        <div class="canvas-open">
            <i class="icon_menu"></i>
        </div>
        <div class="offcanvas-menu-wrapper">
            <div class="canvas-close">
                <i class="icon_close"></i>
            </div>
            <div class="search-icon search-switch">
                <i class="icon_search"></i>
            </div>
            <div class="header-configure-area">
                <div class="language-option">
                    <img src="img/flag.jpg" alt="">
                    <span>EN <i class="fa fa-angle-down"></i></span>
                    <div class="flag-dropdown">
                        <ul>
                            <li><a href="#">Zi</a></li>
                            <li><a href="#">Fr</a></li>
                        </ul>
                    </div>
                </div>
                <a href="#" class="bk-btn">Booking Now</a>
            </div>
            <nav class="mainmenu mobile-menu">
                <ul>
                    <li class="active"><a href="./index.html">Home</a></li>
                    <li><a href="./rooms.html">Rooms</a></li>
                    <li><a href="./about-us.jsp">About Us</a></li>
                    <li><a href="./pages.html">Pages</a>
                        <ul class="dropdown">
                            <li><a href="./room-details.html">Room Details</a></li>
                            <li><a href="./blog-details.html">Blog Details</a></li>
                            <li><a href="#">Family Room</a></li>
                            <li><a href="#">Premium Room</a></li>
                        </ul>
                    </li>
                    <li><a href="./blog.html">News</a></li>
                    <li><a href="./contact.jsp">Contact</a></li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
            <div class="top-social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-tripadvisor"></i></a>
                <a href="#"><i class="fa fa-instagram"></i></a>
            </div>
            <ul class="top-widget">
                <li><i class="fa fa-phone"></i> (12) 345 67890</li>
                <li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
            </ul>
        </div>
        <!-- Offcanvas Menu Section End -->

        <!-- Header Section Begin -->
        <header class="header-section header-normal">
            <div class="top-nav">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <ul class="tn-left">
                                <li><i class="fa fa-phone"></i> (12) 345 67890</li>
                                <li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <div class="tn-right">
                                <a href="listroom" class="bk-btn">Booking Now</a>
                                <div class="language-option">
                                    <img src="https://cdn-icons-png.flaticon.com/512/1077/1077114.png" alt="">
                                    <c:if test="${sessionScope.User != null}">

                                        <span>User <i class="fa fa-angle-down"></i></span>
                                        </c:if>
                                        <c:if test="${sessionScope.User eq null}">
                                        <span><i class="fa fa-sign-in"></i></span>
                                        </c:if>
                                    <div class="flag-dropdown">
                                        <ul>
                                            <c:if test="${sessionScope.User != null}">
                                                <li><a href="profile">Profile</a></li>
                                                <li><a href="listbooked">Booked</a></li> 
                                                <li><a href="log">Logout</a></li>
                                                </c:if>
                                                <c:if test="${sessionScope.User eq null}">
                                                <li><a href="login.jsp">Login</a></li>
                                                </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="menu-item">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2">
                            <div class="logo">
                                <a href="home">
                                    <img src="img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-10">
                            <div class="nav-menu">
                                <nav class="mainmenu">
                                    <ul>
                                        <li><a href="home">Home</a></li>
                                        <li class="active"><a href="listroom">Rooms</a></li>
                                        <li><a href="./about-us.jsp">About Us</a></li>
                                        <li><a href="./contact.jsp">Contact</a></li>
                                    </ul>
                                </nav>
                                <div class="nav-right search-switch">
                                    <i class="icon_search"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Header End -->

        <!-- Breadcrumb Section Begin -->
        <div class="breadcrumb-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb-text">
                            <h2>Our Rooms</h2>
                            <div class="bt-option">
                                <a href="home">Home</a>
                                <span>Rooms</span>
                            </div>
                        </div>
                        <div class="container mt-4">
                            <form action="listroom">
                                <div class="row mb-4">
                                    <div class="col-md-3">
                                        <label for="guest">Capacity:</label><br>
                                        <select id="guest" name="Capacity" style="width: 150px; ">
                                            <option value="2" ${Capacity eq 2 ? 'selected' : ''}>2 People</option>
                                            <option value="3" ${Capacity eq 3 ? 'selected' : ''}>3 People</option>
                                            <option value="4" ${Capacity eq 4 ? 'selected' : ''}>More than 3 People</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label for="capacityFilter">Check-in Date</label>
                                        <input type="date" class="form-control" id="checkInDateFilter" name="checkInDate" onchange="updateCheckOutDateMin()" value="${checkInDate}" required>
                                    </div>
                                    <div class="col-md-3">
                                        <label for="capacityFilter">Check-out Date</label>
                                        <input type="date" class="form-control" id="checkOutDateFilter" name="checkOutDate" onchange="updateCheckInDateMax()" value="${checkOutDate}" required>
                                    </div>
                                    <div class="col-md-3 d-flex justify-content-center">
                                        <div>
                                            <label class="d-block">&nbsp;</label>
                                            <button type="submit" class="btn btn-primary btn-block ">Apply Filters</button>
                                        </div>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb Section End -->

        <!-- Rooms Section Begin -->
        <section class="rooms-section spad">
            <div class="container">
                <div class="row">
                    <c:if test="${roomList.size() == 0}">
                        <div class="col-lg-12 text-center" style="font-size: 50px; height: 600px; color: #aaaab3">
                            No suitable room
                        </div>
                    </c:if>
                    <c:forEach items="${requestScope.roomList}" var="room">
                        <div class="col-lg-4 col-md-6">
                            <div class="room-item">
                                <img src="${room.getImg()}" alt="" style="aspect-ratio: 1.5/1">
                                <div class="ri-text">
                                    <h4>${room.getName()}</h4>
                                    <h3>${String.format("%,.0f", room.getPrice())} VND<span>/Pernight</span></h3>
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td class="r-o">Size:</td>
                                                <td>${room.getSize()} ft</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o">Capacity:</td>
                                                <td>Max persion ${room.getCapacity()}</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o">Bed:</td>
                                                <td>${room.getBedSById().getBedName()}</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o">Room left: </td>
                                                <td>${room.getTotalRoom()}</td>
                                            </tr>
                                            <tr>
                                                <td class="r-o">Services:</td>
                                                <td>${room.listServiceInString()}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <a href="roomdetail?id=${room.getRID()}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}&Capacity=${Capacity}" class="primary-btn">More Details</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="col-lg-12">
                        <div class="room-pagination">
                            <c:if test="${index ne 1 && roomList.size() ne 0}">
                                <a href="listroom?index=${index -1}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}&Capacity=${Capacity}">Previous <i class="fa fa-long-arrow-left"></i></a>
                                </c:if>
                                <c:forEach begin="1" end="${requestScope.endPage}" var="page">
                                <a href="listroom?index=${page}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}&Capacity=${Capacity}" ${page == index ? 'style="background-color: #DFA974; color: white"' : ''}>${page}</a>
                            </c:forEach>
                            <c:if test="${index ne endPage && roomList.size() ne 0}">
                                <a href="listroom?index=${index + 1}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}&Capacity=${Capacity}">Next <i class="fa fa-long-arrow-right"></i></a>
                                </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Rooms Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer-section">
            <div class="container">
                <div class="footer-text">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="ft-about">
                                <div class="logo">
                                    <a href="#">
                                        <img src="img/footer-logo.png" alt="">
                                    </a>
                                </div>
                                <p>We inspire and reach millions of travelers<br /> across 90 local websites</p>
                                <div class="fa-social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-tripadvisor"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-youtube-play"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-1">
                            <div class="ft-contact">
                                <h6>Contact Us</h6>
                                <ul>
                                    <li>(12) 345 67890</li>
                                    <li>info.colorlib@gmail.com</li>
                                    <li>856 Cordia Extension Apt. 356, Lake, United State</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-1">
                            <div class="ft-newslatter">
                                <h6>New latest</h6>
                                <p>Get the latest updates and offers.</p>
                                <form action="#" class="fn-form">
                                    <input type="text" placeholder="Email">
                                    <button type="submit"><i class="fa fa-send"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-7">
                            <ul>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Terms of use</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Environmental Policy</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-5">
                            <div class="co-text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Search model Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch"><i class="icon_close"></i></div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search model end -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

    <script>
            let inputCheckIn = document.getElementById('checkInDateFilter');
            let inputcheckOut = document.getElementById('checkOutDateFilter');
            
            const today = new Date();
            const year = today.getFullYear();
            let month = today.getMonth() + 1;
            let day = today.getDate();

            // Add leading zero for single-digit months and days
            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;
            let date = year + '-' + month + '-' + day;
            inputCheckIn.min = date;
            inputcheckOut.min = date;
            if(inputCheckIn.value === null && inputCheckIn.value === '') {
                inputCheckIn.value = date;
                
            }
            if(inputcheckOut.value === null && inputcheckOut.value === '') {
                inputCheckIn.value = date;
                
            }
        </script>
        
        <script>
            function updateCheckOutDateMin() {
                // Get the selected checkInDate value
                var checkInDate = document.getElementById('checkInDateFilter').value;

                // Set the minimum checkOutDate value to checkInDate
                var checkOutDate = document.getElementById('checkOutDateFilter');
                checkOutDate.min = checkInDate;
                if (checkOutDate.value < checkInDate) {
                    checkOutDate.value = checkInDate;
                }
            }
            
            function updateCheckInDateMax() {
                // Get the selected checkInDate value
                var  checkOutDate= document.getElementById('checkOutDateFilter').value;

                // Set the minimum checkOutDate value to checkInDate
                var checkInDate = document.getElementById('checkInDateFilter');
                checkInDate.max = checkInDate;
                if (checkInDate.value > checkOutDate) {
                    checkInDate.value = checkOutDate;
                }
            }
        </script>
    
</html>
