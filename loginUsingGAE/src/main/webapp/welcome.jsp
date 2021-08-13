<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>
            Welcome Page
        </title>
        <style>
            #show{
                display: none;
            }
        </style>
    </head>
    <body>
        <span id="message"></span>
        <span id="page"></span>
        <h4 id="response"></h4>
        <div id="show">
            <a href="logout"><button>logout</button></a>
            <a href="showDetails"><button>ShowMyDetails</button></a>
            <a href="showFullDetailsAfterLogin"><button>ShowFullDetails</button></a>
        </div>
        <script>
            $.ajax("/welcomeJson",{
                method:"GET",
                success: function(data){
                    if(data.hasOwnProperty("message")){
                        $("#response").html(data.message);
                        $("#show").show();
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