<%-- 
    Document   : advertisement
    Created on : Dec 4, 2013, 12:03:59 PM
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
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header">Sidebar</li>
                            <li class="active"><a href="#"></a></li>
                            <li><a href="record_transaction.html">Transaction</a></li>
                            <li><a href="customerInfo.html">Customer Information</a></li>
                            <li><a href="advertisement.html">Advertisement</a></li>
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <h1></h1>
                        <h2>Advertisement</h2>   
                        <table class="table table-striped">  
                            <tr>
                                <th style="width: 100px"><span style="font-size: 10pt">Advertisement id</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Employee</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Type</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Date</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Company</span></th>
                                <th style="width: 130px"><span style="font-size: 10pt">Item Name</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Content</span></th>
                                <th style="width: 100px"><span style="font-size: 10pt">Unit Price</span></th>
                                <th style="width: 100px"><span style="font-size: 10pt">Available Units</span></th>
                               
                            </tr>   
                            <tr>
                                 <td><button class="btn btn-default" type="button">Create</button> </td>
                                 <td><button class="btn btn-default" type = "button"> Cancel</button></td>
                             </tr>  
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
