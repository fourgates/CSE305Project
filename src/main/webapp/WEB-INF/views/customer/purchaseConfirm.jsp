<%-- 
    Document   : purchaseConfirm
    Created on : Dec 5, 2013, 9:02:16 AM
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

        <link href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/css/bootstrap.css" rel="stylesheet">
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
       <link href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-responsive.css" />
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
                            <li><a href="../logout">Logout</a></li>
                        </ul>
                        <form class="form-search">
                            <input type="text" class="input-medium search-query">
                            <button type="submit" class="btn">Search</button>
                        </form>
                    </div><!--/.nav-collapse-->
                </div>
            </div>
        </div>
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            
                    
                                     <li><a><img src ="images/logo.jpg" alt ="ad image" height ="300" width="300"/></a></li>
                 
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <h1></h1>
                        <h2>Purchase confirm page</h2>
                        <table class="table table-striped">
                                <tr>
                                <td>Confirm Information:</td>
                            </tr>
                              <tr>
                                <td>Transaction ID:</td>
                            </tr>
                              <tr>
                                <td>Number OF Units:</td>
                            </tr>
                              <tr>
                                <td>Account:</td>
                            </tr>
                              <tr>
                                <td>User:</td>
                            </tr>                        
                         
                                  <td><button class="btn btn-default" type="button" >Confirm</button> </td>
                        </table>
                    </div>
                     <div class="row-fluid">
                        <div class="span4">
                            <h2>Item1</h2>
                            <p></p>
                            <p><a href="#"></a></p>
                        </div><!--/span-->
                        <div class="span4">
                            <h2>Item2</h2>
                            <p></p>
                            <p><a href="#"></a></p>
                        </div><!--/span-->
                         <div class="span4">
                            <h2>Item3</h2>
                            <p></p>
                            <p><a href="#"></a></p>
                        </div><!--/span-->
                    </div>
                </div>
            </div>

        </div>
        
        <script src="src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/jquery.js"></script>
        <!-- <c:url value="/resources/mytheme/bootstrap/js/jquery.js" /> -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-transition.js"></script>
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-modal.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-dropdown.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-scrollspy.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tab.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tooltip.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-popover.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-button.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-collapse.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-carousel.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-typeahead.js"></script>

    </body>
</html>