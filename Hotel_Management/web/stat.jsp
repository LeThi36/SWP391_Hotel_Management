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

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>

        <%@ include file="header.jsp"%>

        <div class="container profile-container text-center">
            <canvas id="revenueChart" class="w-100 mt-5" width="800" height="400"></canvas>

        </div>


        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Fixed data for previous months
                var fixedData = [1000, 1200, 1100, 1400, 1300];

                // Calculate revenue for this month (You need to replace this with your actual calculation)
                var thisMonthRevenue = Math.floor(Math.random() * 1000) + 1000;

                // Combine data for the chart
                var allData = [...fixedData, thisMonthRevenue];

                // Get the current month and year
                var currentDate = new Date();
                var currentMonth = currentDate.getMonth(); // 0-indexed
                var currentYear = currentDate.getFullYear();

                // Generate labels for the chart
                var labels = [];
                for (var i = 5; i >= 0; i--) {
                    var monthIndex = (currentMonth - i + 12) % 12; // Ensure the month index is within [0, 11]
                    var monthName = new Date(currentYear, monthIndex).toLocaleString('default', {month: 'long'});
                    labels.push(monthName);
                }

                var ctx = document.getElementById('revenueChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [{
                                label: 'Revenue',
                                data: allData,
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255, 99, 132, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(153, 102, 255, 1)',
                                    'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                        }
                    }
                });
            });
        </script>

        <!-- Include Bootstrap JS, Popper.js, and DataTables JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>



    </body>
</html>
