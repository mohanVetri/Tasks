<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>Log out Page</title>
        <style>
            #button{
                display: none;
            }
        </style>
    </head>
    <body>
        <span id="message"></span>
        <span id="page"></span>
        <span id="response"></span>
        <a id="button" href="index.jsp"><button>Go to HomePage</button></a>
        <script>
            $.ajax("/logoutJson",{
                method: "GET",
                success: function(data){
                    if(data.hasOwnProperty("message")){
                        $("#response").html(data.message);
                        $("#button").show();
                    }
                    else{
                        $("#message").html("Login First!").css({"color": "red"});
                        $("#page").load("loginForm.jsp");
                    }
                }
            })
        </script>
    </body>
</html>