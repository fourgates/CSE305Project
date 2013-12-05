<%-- 
    Document   : managerRegistration
    Created on : Dec 5, 2013, 3:06:40 AM
    Author     : funfun
--%>

<%@page contentType="text/html" pageEncoding="x-windows-950"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>

        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
        <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
      
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">Facebook +</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li><a href="#contact">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse-->
                </div>
            </div>
        </div>
        
        <div id ="back" class="container-fluid" >
            <div class="row-fluid">
        
                <div class="span9" >
                    <div class="hero-unit">
                        <h1>Sign Up for Facebook+</h1>
                        <h2>Sign Up as Manager</h2>
                           <table>
                        <tbody>
                            <tr>
                                <td>SSN:</td><td><input class="form-control" name="SSN" placeholder="SSN" type="text"></td>
                            </tr>
                            <tr>
                                <td>User ID:</td><td><input class="form-control"  name="User_Id" placeholder="User ID" type="text"></td>
                            </tr>

                            <tr>
                                <td>First Name: </td><td><input class="form-control" name="First Name" placeholder="First Name" type="text"></td>

                            </tr>
                            <tr>
                                <td>Last Name: </td><td><input class="form-control" name="Last Name" placeholder="Last Name" type="text"> </td>
                            </tr>
                            <tr>
                                <td> Address: </td> <td><input class="form-control" name="Address" placeholder="Address" type="text"></td>
                            </tr>
                            <tr>
                                <td> City: </td><td><input class="form-control" name="City" placeholder="City" type="text"></td>
                            </tr>
                            <tr>
                                <td> State: </td>   <td><input class="form-control" name="State" placeholder="State" type="text"></td>
                            </tr>
                            <tr>
                                <td>Zip Code: </td><td><input class="form-control" name="Zip Code" placeholder="Zip Code" type="text"> </td>
                            </tr>

                            <tr>
                                <td> Telephone:</td> <td>  <input class="form-control" name="Telephone" placeholder="Telephone" type="text"> </td>
                            </tr>
                            <tr>
                                <td> Email: </td>   <td> <input class="form-control" name="Email" placeholder="Email" type="text"></td>
                            </tr>
                             <tr>
                                <td> Start Date: </td><td><input class="form-control" name="Start_Date" placeholder="Start Date" type="text"></td>
                            </tr>
                            <tr>
                                <td> Hourly Rate: </td><td><input class="form-control" name="Hourly_Rate" placeholder="Hourly Rate" type="text"> </td>
                            </tr>
                            <tr>
                                <td><button class="btn btn-default" type="button">Sign Up</button> </td>
                                <td><button class="btn btn-default" type = "button"> Cancel</button></td>
                            </tr>

                        </tbody>
                    </table>
                    </div>
                </div>
            </div>

        </div>
        
        <script src="../bootstrap/js/jquery.js"></script>
        <script src="../bootstrap/js/bootstrap-transition.js"></script>
        <script src="../bootstrap/js/bootstrap-alert.js"></script>
        <script src="../bootstrap/js/bootstrap-modal.js"></script>
        <script src="../bootstrap/js/bootstrap-dropdown.js"></script>
        <script src="../bootstrap/js/bootstrap-scrollspy.js"></script>
        <script src="../bootstrap/js/bootstrap-tab.js"></script>
        <script src="../bootstrap/js/bootstrap-tooltip.js"></script>
        <script src="../bootstrap/js/bootstrap-popover.js"></script>
        <script src="../bootstrap/js/bootstrap-button.js"></script>
        <script src="../bootstrap/js/bootstrap-collapse.js"></script>
        <script src="../bootstrap/js/bootstrap-carousel.js"></script>
        <script src="../bootstrap/js/bootstrap-typeahead.js"></script>

    </body>
</html>
