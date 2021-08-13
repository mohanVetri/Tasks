<%@ page session="false" %>
<!DOCTYPE html>
<html>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <title>
        StudentDetails
    </title>
    <style>
        #message{
            color: red;
        }
        #table,#heading,#page{
            display: none;
        }

        table,
        th,
        td {
            border: 2px solid black;
        }
    </style>
</head>

<body>
    <h1 id="heading">Student Details</h1>
    <span id="message"></span>
    <span id="withoutSession"></span>
    <a id="page" href="loginForm.jsp"><button>Go to LoginPage</button></a>
    <table id="table">
        <tr id="response">
            <th>FirstName</th>
            <th>LastName</th>
            <th>userName</th>
            <th>Password</th>
            <th>EmailId</th>
        </tr>
    </table>
    <script>
        $.ajax("/detailsJson", {
            method: "GET",
            success: function (data) {
                if (data.hasOwnProperty("message")) {
                    $("#message").html(data.message);
                }
                else if (data.hasOwnProperty("details")) {
                    $(data.details).each(function (key, val) {
                        window.output += "<tr><td>" + val["firstName"] + "</td>" +
                            "<td>" + val["lastName"] + "</td>" +
                            "<td>" + val["userName"] + "</td>" +
                            "<td>" + val["password"] + "</td>" +
                            "<td>" + val["emailId"] + "</td></tr>";
                    })
                    $("#response").after(window.output);
                    $("table").show();
                    $("#heading").show();
                }
                else{
                    $("#withoutSession").html("Login First!!").css({"color": "red"});
                    $("#page").show();
                }
            }
        })
    </script>
</body>

</html>