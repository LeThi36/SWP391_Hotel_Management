<%-- 
    Document   : bookingroom
    Created on : Jan 20, 2024, 8:16:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
    <title>Log</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-image: url(https://media.istockphoto.com/id/962720026/photo/bedroom-and-living-on-balcony-in-hotel-or-resort-bedroom-white-tone-design-and-white.jpg?s=170667a&w=0&k=20&c=RWgS3d2glc0Diqp2qu_xpOWSEGdrUh4OX2SPEYTjMhc=);
        }
        .checkdate {
            width: 50%;
        }
        .room-booking {
            background-color: rgb(226, 226, 226);
            padding: 5% 10%;
        }
        .date {
            width: 45%;
        }
        .select-option input[type=text] {
            width: 100%;
            height: 50px;
            border: 1px solid #e5e5e5;
            font-size: 16px;
            color: #aaaab3;
            padding-left: 20px;
        }
        textarea {
            width: 100%;
            height: 132px;
            border: 1px solid #e5e5e5;
            font-size: 16px;
            color: #aaaab3;
            padding-left: 20px;
            padding-top: 12px;
            margin-bottom: 24px;
            resize: none;
        }
    </style>
</head>

<body>

    <div class="col-lg-8">
        <div style="display: flex; justify-content: space-between; width: 100%; padding: 15px; margin-top: 300px;">
            <div class="logo">
                <a href="./index.html">
                    <img src="img/logo.png" alt="">
                </a>
            </div>
            <div>
                <strong style="font-size: 20px;">Sona A Luxury Hotel </strong><br>
                856 Cordia Extension Apt. 356, Lake, United State <br>
                (12) 345 67890 <br>

            </div>
        </div>
        <div class="room-booking">
            <h3>Your Reservation</h3>
            <p style="margin-bottom: 50px;">Please check the information of the form. Your registration will be verified
                prior to your arrival.</p>
            <form action="#">
                <div class="check-date" style="display: flex; justify-content: space-between;">
                    <div class="date">
                        <label for="date-in">Check In:</label>
                        <input type="text" class="date-input" id="date-in">
                        <i class="icon_calendar" style="text-align: right; right: 57%;"></i>
                    </div>
                    <div class="date">
                        <label for="date-out">Check Out:</label>
                        <input type="text" class="date-input" id="date-out">
                        <i class="icon_calendar"></i>
                    </div>
                </div>
                <div class="check-date">
                    <label for="date-out">Room information:</label>
                        <input type="text" class="date-input" id="date-out">
                        <i id="show" class='bx bx-show' onclick=""></i>
                </div>
                <div class="select-option">
                    <label for="guest">Guests:</label>
                    <select id="guest">
                        <option value="">3 Adults</option>
                    </select>
                </div>
                <div class="select-option">
                    <label for="room">Room:</label>
                    <select id="room">
                        <option value="">1 Room</option>
                    </select>
                </div>
                <div class="select-option">
                    <label for="email">Email:</label>
                    <input id="email" type="text" placeholder="Email">
                </div>
                <div class="select-option">
                    <label for="phone">Phone number:</label>
                    <input id="phone" type="text" placeholder="Phonenumber">
                </div>
                <div class="select-option">
                    <label for="payment">Payment Method:</label>
                    <select id="payment">
                        <option value="">VNPAY</option>
                        <option value="">Direct</option>
                    </select>
                </div>
                <div>

                </div>
                <div class="select-option">
                    <label for="note">Any special accommodation needs:</label>
                    <textarea placeholder="Your Review"></textarea>
                </div>
                <div style="display: flex; justify-content: space-between; align-items: center;">
                    <button class="btn" style="color: white; background-color: #DFA974;width: 48%;" type="submit">Subtmit</button>
                    <button class="btn" style="color: white; background-color: #DFA974;width: 48%;" type="submit">Cancel</button>
                </div>
            </form>
        </div>
    </div>

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