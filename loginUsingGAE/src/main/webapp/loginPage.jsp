<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>Login Page</title>
        <style>
            #button{
                display: none;
            }
        </style>
    </head>
    <body>
        <span id="response"></span>
        <span id="include"></span>
        <a id="button" href="welcome"><button>Go to Profile</button></a>
        <script>
            $.ajax("/loginPageJson",{
                method: "GET",
                success: function (data) {
                    if(data.hasOwnProperty("session")){
                    if(data.session!=null){
                        $("#response").html(data.message+"<br>");
                        $("#button").show();
                    }
                }
                    else{
                        $("#include").load("loginForm.jsp");
                    }
                },
                error: function(responseTxt,statusTxt,xhr){
                    alert(statusTxt);
                }
            })
        </script>
    </body>
</html>