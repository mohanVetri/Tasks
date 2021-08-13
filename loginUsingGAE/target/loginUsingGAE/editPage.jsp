<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <title>
            Edit Page
        </title>
        <style>
            #form{
                display: none;
            }
            .warning,#warningMessage{
                color:red;
            }
        </style>
    </head>
    <body>
        <span id="message"></span>
        <span id="page"></span>
        <form id="form" action="updateDetails" method="POST">
        <table>
            <tr>
                <td><b>FirstName</b></td>
                <td><input type="text" name="firstName" id="firstName"></td>
                <td><span id="fname" class="warning"></span></td>
            </tr>

            <tr>
                <td><b>LastName</b></td>
                <td><input type="text" name="lastName" id="lastName"></td>
                <td><span id="lname" class="warning"></span></td>
            </tr>

            <tr>
                <td><b>UserName</b></td>
                <td><input type="text" name="userName" id="userName"></td>
                <td><span id="uname" class="warning"></span></td>
            </tr>

            <tr>
                <td><b>Password</b></td>
                <td><input type="text" name="password" id="password"></td>
                <td><span id="pass" class="warning"></span></td>
            </tr>

            <tr>
                <td><b>EmailId</b></td>
                <td><input type="text" name="emailId" id="emailId"></td>
                <td><span id="mail" class="warning"></span></td>
            </tr>
        </table>
        <input type="button" value="update" onclick="submitform()"/>
    </form>
    <span id="warningMessage"></span>
        <script>
            $.ajax("/editJson",{
                method:"GET",
                success:function(data){
                    if(data.hasOwnProperty("session")){
                                $("#firstName").val(data.firstName);
                                $("#lastName").val(data.lastName);
                                $("#userName").val(data.userName);
                                $("#password").val(data.password);
                                $("#emailId").val(data.emailId);
                                $("#form").show();
                                $.ajax("/validationJson",{
                                    method: "GET",
                                    success:function(data){
                                    if(data.hasOwnProperty("message")){
                                        $("#warningMessage").html(data.message);
                                    }
                                }
                                })

                    }
                    else{
                        $("#message").html("Login First!!").css({"color":"red"});
                        $("#page").load("loginForm.jsp");
                    }
                }
            })
            function submitform(){
                    var form=document.getElementById("form");
                    if(validation()){
                        form.submit();
                    }
                }
                function firstNameValidation() {
                    var firstName = document.getElementsByName("firstName")[0].value;
                    if (firstName.trim() === null || firstName.trim() === "") {
                        document.getElementById("fname").innerHTML = "*firstName should not be empty";
                        return false;
                    }
                    else if (!(firstName[0] === firstName[0].toUpperCase())) {
                        document.getElementById("fname").innerHTML = "*first letter of firstName should be in capital";
                        return false;
                    }
                    else {
                        document.getElementById("fname").innerHTML = "";
                        return true;
                    }
                }

                function lastNameValidation() {
                    var lastName = document.getElementsByName("lastName")[0].value;
                    if (lastName.trim() === null || lastName.trim() === "") {
                        document.getElementById("lname").innerHTML = "*lastName should not be empty";
                        return false;
                    }
                    else if (!(lastName[0] === lastName[0].toUpperCase())) {
                        document.getElementById("lname").innerHTML = "*first letter of lastName should be in capital";
                        return false;
                    }
                    else {
                        document.getElementById("lname").innerHTML = "";
                        return true;
                    }
                }
                function userNameValidation() {
                    var userName = document.getElementsByName("userName")[0].value;
                    if (userName.trim() === null || userName.trim() === "") {
                        document.getElementById("uname").innerHTML = "*userName should not be empty";
                        return false;
                    }
                    else {
                        document.getElementById("uname").innerHTML = "";
                        return true;
                    }
                }

                function passwordValidation() {
                    var password = document.getElementsByName("password")[0].value;
                    if (password.trim() === null || password.trim() === "") {
                        document.getElementById("pass").innerHTML = "*password should not be empty";
                        return false;
                    }
                    else if(!(/^(?=.{8,15}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).*$/g.test(password))){
                        document.getElementById("pass").innerHTML="*password should have atleast 1(a-z & A-Z & 0-9 & any symbol) length is from 8 to 15)";
                    }
                    else {
                        document.getElementById("pass").innerHTML = "";
                        return true;
                    }
                }

                function emailIdValidation() {
                    var emailId = document.getElementsByName("emailId")[0].value;
                    if (emailId.trim() === null || emailId.trim() === "") {
                        document.getElementById("mail").innerHTML = "*emailId should not be empty";
                        return false;
                    }
                    else if (!(/^([a-z0-9]+)[@]{1}([a-z]+)[\.]{1}([a-z]+)$/g.test(emailId))) {
                        document.getElementById("mail").innerHTML = "*email ID should be in the form abc@abc.abc";
                        return false;
                    }
                    else {
                        document.getElementById("mail").innerHTML = "";
                        return true;
                    }
                }

                function validation(){
                    if((firstNameValidation() && lastNameValidation() && userNameValidation() && passwordValidation
                    && emailIdValidation())){
                        return true;
                    }
                    else{
                        return false;
                    }
                }

        </script>
    </body>
</html>