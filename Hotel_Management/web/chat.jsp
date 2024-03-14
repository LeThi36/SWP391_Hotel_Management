<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Room Management</title>
        <!-- Add Bootstrap CSS link -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            * {
                box-sizing: border-box;
            }
            .chat-container {
                margin: auto;
                height: 70vh;
                border: 1px solid #ccc;
                border-radius: 5px;
                overflow: hidden;
                position: relative;
            }
            .chat-messages {
                height: 60vh;
                overflow-y: auto;
                padding: 10px;
            }
            .message {
                width: 100%;
                height: 6vh;
                background-color: #f0f0f0;
                padding: 5px 10px;
                border-radius: 10px;
                margin-bottom: 10px;
            }
            .input-group {
                position: absolute;
                bottom: 0;
                height: 7vh;
            }
            
            .input-group *{
                height: 7vh;
            }

            :root {
                --main-color: #ff9843;
            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: var(--main-color);">
            <div class="container">
                <a class="navbar-brand" href="home">🏨 Hotel Booking</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">

                        <c:if test="${not empty sessionScope.User}">
                            <li class="nav-item active">
                                <a class="nav-link" href="profile">Profile</a>
                            </li>
                        </c:if>


                    </ul>
                </div>
            </div>
        </nav>

        <div class="container profile-container">
            <h1 class="text-center mb-4 mt-5">Chat with Receptionist</h1>
            
            <div class="chat-container">
                
                <div class="chat-messages" id="chatMessages">
                    <!-- Chat messages will be displayed here -->
                </div>
                
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Type your message" id="messageInput">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button" onclick="sendMessage()">Send</button>
                    </div>
                </div>
                
            </div>
        </div>

        <!-- Include Bootstrap JS, Popper.js, and DataTables JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <!-- Your WebSocket connection and message handling scripts -->
        <script>
                            var ws; // Declare ws variable in the global scope

                            // Function to send a message
                            function sendMessage() {
                                var messageInput = document.getElementById("messageInput");
                                var message = messageInput.value.trim();
                                if (message !== "") {
                                    // Display the message locally
                                    displayMessage("You: " + message);

                                    // Send the message over WebSocket
                                    ws.send('${user ne null ? user.fullName : 'Receptionist'}: ' + message);
                                    messageInput.value = "";
                                }
                            }

                            // Function to display a message in the chat
                            function displayMessage(message) {
                                var chatMessages = document.getElementById("chatMessages");
                                var messageDiv = document.createElement("div");
                                messageDiv.classList.add("message");
                                messageDiv.textContent = message;
                                chatMessages.appendChild(messageDiv);
                                chatMessages.scrollTop = chatMessages.scrollHeight; // Scroll to bottom
                            }

                            // Create WebSocket connection after the DOM is loaded
                            document.addEventListener("DOMContentLoaded", function () {
                                // WebSocket connection setup
                                var wsUrl = "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/websocket/${conversationId}";
                                ws = new WebSocket(wsUrl); // Assign ws variable in the global scope

                                // WebSocket event listeners
                                ws.onopen = function (event) {
                                    console.log("WebSocket connected");

                                    // Event listener for Enter key press
                                    document.getElementById("messageInput").addEventListener("keypress", function (event) {
                                        if (event.key === "Enter") {
                                            sendMessage();
                                        }
                                    });
                                };

                                ws.onmessage = function (event) {
                                    displayMessage(event.data);
                                };

                                ws.onclose = function (event) {
                                    console.log("WebSocket closed");
                                };

                                ws.onerror = function (event) {
                                    console.error("WebSocket error: " + event);
                                };
                            });
        </script>


    </body>
</html>
