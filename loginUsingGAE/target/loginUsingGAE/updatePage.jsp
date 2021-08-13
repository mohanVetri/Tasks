<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>
            Updated Page
        </title>
        <style>
            #table,#button{
                display: none;
            }
            #table,.td,.tr{
                border: 2px solid black;
            }
        </style>
    </head>
    <body>
        <span id="message"></span>
        <span id="page"></span>
        <h4 id=success></h4>
        <button id="button">ShowUpdatedDetails</button>
        <br><br>
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
        </table>
        <script>
            $.ajax("/updateJson",{
                method:"GET",
                success: function(data){
                    if(data.hasOwnProperty("session")){
                        $("#success").html(data.message);
                        $("#response").html(data.message);
                        $("#firstName").html(data.firstName);
                        $("#lastName").html(data.lastName);
                        $("#userName").html(data.userName);
                        $("#password").html(data.password);
                        $("#emailId").html(data.emailId);
                        $("#button").show();
                    }
                    else{
                        $("#message").html("Login First!").css({"color": "red"});
                        $("#page").load("loginForm.jsp");
                    }
                }
            })
            $(document).ready( function(){
                $("#button").click(function(){
                    $("#success").html("Updated Details");
                    $("#table").show();
                })
            })
            
        </script>
    </body>
</html>