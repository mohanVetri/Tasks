<%@ page session="false" %>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>Login Form</title>
        <style>
            #response{
                color: red;
            }
        </style>
    </head>

    <body>
        <span id="response"></span>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>
                        <b>UserName:</b>
                    </td>
                    <td>
                        <input type="text" name="userName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Password:</b>
                    </td>
                    <td>
                        <input type="text" name="password" />
                    </td>
                </tr>
            </table>
            <input type="submit" value="submit" />
        </form>
        <script>
            $.ajax("/loginJson", {
                method: "GET",
                data: JSON,
                success: function (data) {
                    if (data.hasOwnProperty("message")) {
                        $("#response").html(data.message);
                    }
                },
            })
        </script>
    </body>

    </html>