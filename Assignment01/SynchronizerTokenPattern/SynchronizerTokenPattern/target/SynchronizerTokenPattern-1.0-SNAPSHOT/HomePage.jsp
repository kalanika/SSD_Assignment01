<%-- 
    Document   : HOME JSP PAGE
    Created on : September 15, 2018, 8:20:20 AM
    Author     : erandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <title>Home page</title>

        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 20px;
                background: #d3a2c3;;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 40px;
                border-radius: 20px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
                border-radius: 15px;
                background-color:#a2abd3;
            }
        </style>

    </head>
    <body>        
        <div class="login-form">
            <form action="Validator" method="POST">
                <h2 class="text-center">Enter your details</h2>       
                <div class="form-group">
                    <input type="text" name="id" placeholder="Enter the Id" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="key" placeholder="Enter the password" class="form-control">
                </div>
                <div class="form-group">
                    <input type="submit"  class="btn btn-primary active"/>
                </div>
                
                
                <input type="hidden" name="tokentext" id="tokentext"/>
            </form>
          
        </div>

        <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
        <script>
            $.ajax({
                type: 'GET',
                dataType: 'json',
                url: '/SynchronizerTokenPattern/Validator',
                async: false,
                contentType: "application/json",
                success: function (data) {
                    var response = JSON.stringify(data);
                    console.log("data.csrfToken: " + data.csrfToken);
                    
                    console.log("response   " + response[0].csrfToken);
                    alert("Token Data : " + response);
                    $("#tokentext").val(data.csrfToken);
                },
                error: function (xhr, status, error) {
                    alert(status);
                }
            });
        </script>
    </body>
</html>
