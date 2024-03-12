<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Hotel Booking</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            /* Additional Styles */
            body {
                background-color: white;
            }

            .decorative-text {
                font-size: 1.2em;
                color: #666;
                text-align: center;
                margin-top: 20px;
            }

            .gallery-heading {
                font-size: 2em;
                font-weight: bold;
                text-align: center;
                margin-top: 40px;
                color: #483729;
            }

            /* Footer Styles */
            .footer {
                background-color: var(--main-color); /* Background color for the footer */
                color: #fff;
                padding: 20px 0;
                text-align: center;
            }

            /* Booking form styles */
            .booking-form {
                background-color: var(--main-color);
                color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            }

            /* Image and gallery styles */
            .hotel-image {
                border-radius: 10px;
                overflow: hidden;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            }

            .gallery-image {
                border-radius: 10px;
                overflow: hidden;
                margin-bottom: 20px;
            }

            .btn-primary {
                background-color: #EF7F23;
                border-color: #EF7F23;
            }

            .btn-primary:hover {
                background-color: #CF6F20;
                border-color: #CF6F20;
            }
        </style>
    </head>
    <body>

        <jsp:include page="/header.jsp" />

        <div class="container mt-5">
            <div class="row">
                <!-- Image on the left -->
                <div class="col-md-8">
                    <img class="img-fluid hotel-image rounded shadow" alt="Hotel Image"
                         src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/426610590.jpg?k=d8b6db85f75b8deecacd4621f8b0e77df695259066b413820f7de4fdce3d0bc9&o=&hp=1">
                </div>
                <!-- Booking form on the right -->
                <div class="col-md-4">
                    <div class="booking-form shadow">
                        <h1 class="text-center mb-4">Hotel Booking</h1>
                        <form>
                            <div class="form-group">
                                <label for="checkInDate">Check-in Date:</label>
                                <input type="date" class="form-control" id="checkInDate" required>
                            </div>
                            <div class="form-group">
                                <label for="checkOutDate">Check-out Date:</label>
                                <input type="date" class="form-control" id="checkOutDate" required>
                            </div>
                            <div class="form-group">
                                <label for="numOfGuests">Number of Guests:</label>
                                <input type="number" class="form-control" id="numOfGuests" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Search</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Gallery Heading -->
            <div class="row">
                <div class="col-md-12">
                    <h2 class="gallery-heading">Explore Our Gallery</h2>
                </div>
            </div>

            <!-- Image Gallery -->
            <div class="row mt-4">
                <div class="col-md-4">
                    <img src="https://assets-global.website-files.com/5c6d6c45eaa55f57c6367749/65045f093c166fdddb4a94a5_x-65045f0266217.webp" class="img-fluid gallery-image shadow" alt="Gallery Image 1">
                </div>
                <div class="col-md-4">
                    <img src="https://imageio.forbes.com/specials-images/imageserve/5cdb058a5218470008b0b00f/Nobu-Ryokan-Malibu/0x0.jpg?format=jpg&height=1009&width=2000" class="img-fluid gallery-image shadow" alt="Gallery Image 2">
                </div>
                <div class="col-md-4">
                    <img src="https://www.thegrove.co.uk/wp-content/uploads/2023/06/Banner-resized-2-1920x1080.jpg" class="img-fluid gallery-image shadow" alt="Gallery Image 3">
                </div>
            </div>

            <!-- Decorative Text -->
            <div class="row mt-4">
                <div class="col-md-12">
                    <p class="decorative-text">Indulge in a world of luxury and comfort. Our hotel is designed to provide you with an unforgettable experience. Explore the stunning images in our gallery and book your stay today.</p>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="footer mt-5">
            <div class="container">
                <p>&copy; 2024 Your Hotel. All Rights Reserved.</p>
            </div>
        </footer>

        <!-- Add Bootstrap JS and Popper.js -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
