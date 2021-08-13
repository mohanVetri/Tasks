<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>
            Individual Details
        </title>
        <style>
            #table,#button,#heading{
                display: none;
            }
            #table,.tr,.td{
                border: 2px solid black;
            }
        </style>
        </head>
        <body>
            <h1 id="heading">My Details</h1>
            <span id="message"></span>
            <span id="page"></span>
            <table id="table">
                <tr class="tr">
                    <td class="td"><b>FirstName</b></td>
                    <td class="td"><span id="firstName"></span></td>
                </tr>

                <tr class="tr">
                    <td class="td"><b>LastName</b></td>
                    <td class="td"><span id="lastName"></span></td>
                </tr>

                <tr class="tr">
                    <td class="td"><b>UserName</b></td>
                    <td class="td"><span id="userName"></span></td>
                </tr>

                <tr class="tr">
                    <td class="td"><b>Password</b></td>
                    <td class="td"><span id="password"></span></td>
                </tr>

                <tr class="tr">
                    <td class="td"><b>EmailId</b></td>
                    <td class="td"><span id="emailId"></span></td>
                </tr>
            </table><br>
            <a id="button" href="editDetails"><button>EditDetails</button></a>
            <script>
                $.ajax("/individualJson",{
                    method: "GET",
                    success: function(data){
                        if(data.hasOwnProperty("session")){
                        $("#firstName").html(data.firstName);
                        $("#lastName").html(data.lastName);
                        $("#userName").html(data.userName);
                        $("#password").html(data.password);
                        $("#emailId").html(data.emailId);
                        $("#table").show();
                        $("#button").show();
                        $("#heading").show();
                    }
                    else{
                        $("#message").html("Login First!!").css({"color": "red"});
                        $("#page").load("loginForm.jsp");
                    }
                    }
                })
            </script>
        </body>
</html>