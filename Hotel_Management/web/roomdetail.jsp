
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
        <title> Sona | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
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


        <style>
            .select-option input[type = text] {
                width: 100%;
                height: 50px;
                border: 1px solid #e5e5e5;
                font-size: 16px;
                color: #aaaab3;
                padding-left: 20px;
                margin-bottom: 25px;
            }
        </style>

        <style>
            .footer-color {
                background: #7dbaab;
            }

            .footer-btn {
                background: #415762;
            }

            .check-container {
                background: #7dbaab;
                height: 82px;
                width: 82px;
            }

            .iconheight {
                height: 36px;
                width: 36px;
            }

            .btn:hover {
                color: var(--bs-btn-hover-color);
                background: #415762;
                border-color: #415762;
            }

            .angle::after {
                position: absolute;
                content: "";
                height: 20px;
                width: 20px;
                top: -1px;
                left: 48%;
                background: #fff;
                clip-path: polygon(50% 50%, 0 0, 100% 0);
            }

            #btnnn {
                display: block;
                font-size: 14px;
                text-transform: uppercase;
                border: 1px solid #dfa974;
                border-radius: 2px;
                color: #dfa974;
                font-weight: 500;
                background: transparent;
                width: 100%;
                height: 46px;
                margin-top: 30px;
            }

            #btnnn:hover {
                background: #19191a;
                color: white;
            }

        </style>
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
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb Section End -->

        <!-- Room Details Section Begin -->
        <section class="room-details-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="room-details-item">
                            <img src="${room.getImg()}" style="width: 100%;" alt="">
                            <div class="rd-text">
                                <div class="rd-title">
                                    <h3>${room.getName()}</h3>
                                    <div class="rdt-right">
                                        <div class="rating">
                                            <i class="icon_star"></i>
                                            <i class="icon_star"></i>
                                            <i class="icon_star"></i>
                                            <i class="icon_star"></i>
                                            <i class="icon_star-half_alt"></i>
                                        </div>
                                    </div>
                                </div>
                                <h2>${String.format("%,.0f", room.getPrice())} VND<span>/Pernight</span></h2>
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
                                    </tbody>
                                </table>
                                <p class="f-para">
                                    ${room.getDetail()}
                                </p>
                            </div>
                        </div>
                        <div class="rd-reviews">
                            <h4>Reviews</h4>

                            <c:forEach items="${listFeedback}" var="fb">
                                <div class="review-item">
                                    <div class="ri-pic">
                                        <img src="https://cdn-icons-png.flaticon.com/512/1077/1077114.png" alt="">
                                    </div>
                                    <div class="ri-text">
                                        <span>${fb.getCreatedDate()}</span>
                                        <div class="rating">
                                            <c:forEach begin="1" end="${fb.getRating()}">
                                                <i class="icon_star active"></i>
                                            </c:forEach>

                                            <c:forEach begin="${fb.getRating()}" end="4">
                                                <i class="icon_star "></i>
                                            </c:forEach>
                                        </div>
                                        <h5>${fb.getUserFeedback().getFullName()}</h5>
                                        <p>${fb.getContent()}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="room-booking">
                            <h3>Your Reservation</h3>
                            <form action="roomdetail" class="ra-form">
                                <input type="hidden" name="id" value="${room.getRID()}">
                                <div class="check-date">
                                    <label for="date-in">Check In:</label>
                                    <input style="padding-right: 15px" type="date" id="date-in" name="checkInDate" value="${checkInDate}" onchange="resetlink()" required>
                                </div>
                                <div class="check-date">
                                    <label for="date-out">Check Out:</label>
                                    <input style="padding-right: 15px" type="date"  id="date-out" name="checkOutDate" value="${checkOutDate}" onchange="resetlink()" required>
                                </div>
                                <div class="select-option">
                                    <label for="guest">Number People: </label>
                                    <select id="guest" name="numPeople" onchange="resetlink()">
                                        <c:forEach begin="1" end="${room.getCapacity()}" var="number">
                                            <option value="${number}">${number} Person</option>
                                        </c:forEach>

                                    </select>
                                </div>
                                <div class="select-option">
                                    <label for="room">Number Room: (${room.getTotalRoom() } remaining)</label>
                                    <input id="room" style="color: #19191a" type="text" placeholder="Number of rooms" name="numRoom" value="1" onchange="resetlink()" required>
                                </div>
                                <div>
                                    <label>Choose Service:  </label> 
                                    <div>
                                        <c:forEach items="${room.getListServiceByRoomId()}" var="sv">
                                            <div style="background-color: #e5e5e5; padding: 5px; margin-bottom: 20px; display: inline-block;">
                                                <span>${sv.getServiceName()}</span> 
                                                <input class="sevices" type="checkbox" name="svId" value="${sv.getSeID()}" onclick="resetlink()">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>

                                <a id="btnnn" href="confirmbooking?id=${room.getRID()}&checkIn=${checkInDate}&checkOut=${checkOutDate}&numPeople=0&numRoom_raw=3}" class="btn btn-primary">Book now</a>
                                <button type="submit" class="btn btn-primary">Update information</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Room Details Section End -->
        
        <script>
            function updateCheckOutDateMin() {
                // Get the selected checkInDate value
                var checkInDate = document.getElementById('date-in').value;

                // Set the minimum checkOutDate value to checkInDate
                var checkOutDate = document.getElementById('date-out');
                checkOutDate.min = checkInDate;
                if (checkOutDate.value < checkInDate) {
                    checkOutDate.value = checkInDate;
                }
            }
            
            function updateCheckInDateMax() {
                // Get the selected checkInDate value
                var  checkOutDate= document.getElementById('date-out').value;

                // Set the minimum checkOutDate value to checkInDate
                var checkInDate = document.getElementById('date-in');
                checkInDate.max = checkInDate;
                if (checkInDate.value > checkOutDate) {
                    checkInDate.value = checkOutDate;
                }
            }
            
            let link = document.getElementById('btnnn');
            let numberRoom = document.getElementById('room');
            let numberPeople = document.getElementById('guest');
            link.href = 'confirmbooking?id=${room.getRID()}&checkIn=${checkInDate}&checkOut=${checkOutDate}&numPeople=' + numberPeople.value + '&numRoom=' + numberRoom.value;
            function resetlink() {
                let inputCheckIn = document.getElementById('date-in');
                let msggg = document.getElementById('msggg');
                let inputcheckOut = document.getElementById('date-out');
                let link = document.getElementById('btnnn');
                let numberRoom = document.getElementById('room');
                let numberPeople = document.getElementById('guest');

                let listServices = document.getElementsByClassName('sevices');
                let urlService = '';
                for (var i = 0; i < listServices.length; i++) {
                    if (listServices[i].checked) {
                        urlService += '&svId=' + listServices[i].value;
                    }
                }

                link.href = 'confirmbooking?id=${room.getRID()}&checkIn=' + inputCheckIn.value + '&checkOut=' + inputcheckOut.value + '&numPeople=' + numberPeople.value + '&numRoom=' + numberRoom.value + urlService;
                if (inputCheckIn.value > inputcheckOut.value) {
                    link.href = '#';
                    msggg.style.display = 'inline';
                } else {
                    msggg.style.display = 'none';
                }

                updateCheckOutDateMin();
                updateCheckInDateMax();
            }
        </script>



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

        <c:if test="${status eq 'available'}">
            <!-- Modal -->
            <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog ">
                    <div class="modal-content rounded-0">
                        <div class="modal-header border-0">
                            <!-- <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1> -->
                            <button type="button" class="btn-close shadow-none" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="text-center">
                                <div class="d-flex justify-content-center pb-2">
                                    <div class="check-container d-flex justify-content-center align-items-center rounded-pill">
                                        <img class="iconheight"
                                             src="https://img.icons8.com/office/16/000000/checkmark--v1.png"
                                             alt="check-lg">
                                    </div>
                                </div>
                                <h1 class="fw-bold">Awesome!</h1>
                                <p class="fw-bold">You're ready to proceed using Dbook</p>
                            </div>
                        </div>
                        <div class="modal-footer border-0 justify-content-center footer-color rounded-0 position-relative">
                            <div class="angle "></div>
                            <!-- <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
                            <div class="text-center p-4 ">
                                <form action="confirmbooking" id="confirmbookingform">
                                    <input type="hidden" class="date-input" id="date-in" name="checkIn" value="${checkIn}">
                                    <input type="hidden" class="date-input" id="date-out" name="checkOut" value="${checkOut}">
                                    <input type="hidden"  name="numRoom" value="${numRoom}">
                                    <input  type="hidden"name="numPeople" value="${numPeople}">
                                    <input  type="hidden"name="id" value="${room.getRID()}">
                                    <button type="button" class="btn shadow-none footer-btn text-white rounded-0 px-5" onclick="submit()">
                                        Start
                                        Booking</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${status ne 'available' && status ne null}">
            <!-- Modal -->
            <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog ">
                    <div class="modal-content rounded-0">
                        <div class="modal-header border-0">
                            <!-- <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1> -->
                            <button type="button" class="btn-close shadow-none" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="text-center">
                                <div class="d-flex justify-content-center pb-2">
                                    <div class="check-container d-flex justify-content-center align-items-center rounded-pill" style="background: red">
                                        <img class="iconheight"
                                             src="images/close.png" alt="check-lg">
                                    </div>
                                </div>
                                <h1 class="fw-bold">Sadly!</h1>
                                <p class="fw-bold">Our room remain only ${total}! please try ours others rooms.</p>
                            </div>
                        </div>
                        <div class="modal-footer border-0 justify-content-center footer-color rounded-0 position-relative" style="background: red">
                            <div class="angle "></div>
                            <!-- <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
                            <div class="text-center p-4 ">
                                <form action="confirmbooking" id="confirmbookingform">
                                    <input type="hidden" class="date-input" id="date-in" name="checkIn" value="${checkIn}">
                                    <input type="hidden" class="date-input" id="date-out" name="checkOut" value="${checkOut}">
                                    <input type="hidden"  name="numRoom" value="${numRoom}">
                                    <input  type="hidden"name="numPeople" value="${numPeople}">
                                    <button type="button" class="btn shadow-none footer-btn text-white rounded-0 px-5" aria-label="Close" data-bs-dismiss="modal">
                                        Try Again</button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>


        <script>
            let inputCheckIn = document.getElementById('date-in');
            let inputcheckOut = document.getElementById('date-out');

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
        </script>
        
        


        <!-- bootstrap link -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

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

</html>
