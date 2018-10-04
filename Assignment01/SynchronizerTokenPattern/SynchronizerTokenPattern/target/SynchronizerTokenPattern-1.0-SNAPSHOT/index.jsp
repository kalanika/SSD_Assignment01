<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Login Page</title>

        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
                
                input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            
            input[type="submit"]:active {
                    top:3px;
                    box-shadow: inset 0px 1px 0px #2ab7ec, 0px 2px 0px 0px #31524d, 0px 5px 3px #999;
                  }

/* Set a style for all buttons */
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

        button:hover {
              opacity: 0.8;
           }

               
               
            }
            .login-form form {
                margin-bottom: 20px;
                background: #a2c3d3;
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
            }
            
            
        </style>

    </head>
    <body>

        <div class="login-form" >
            <form action="Login" method="POST">
                <h2 class="text-center">Log in</h2>     
                 
                <div class="form-group">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" class="form-control" name="username">
                </div>
                <div class="form-group">
                     <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary active" value="Login" style="text-align:center;"/>
                </div>
                <div class="clearfix">
                    <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
                    <a href="#" class="pull-right">Forgot Password?</a>
                </div>        
            </form>
           
        </div>

        <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
    </body>
</html>
