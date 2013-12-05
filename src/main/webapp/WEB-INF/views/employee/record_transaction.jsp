<%-- 
    Document   : record_transaction
    Created on : Dec 4, 2013, 12:04:13 PM
    Author     : funfun
--%>

<%@page contentType="text/html" pageEncoding="x-windows-950"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=x-windows-950">
        <title>JSP Page</title>
        <style>
            #header {
                background-color: dodgerblue;
            }
            #header ul {
                list-style-type: none;
                margin:0;
                padding:0;
            }
            #header ul a {
                color: white;
            }
            #header ul a:hover {
                color: yellow;
            }
            #header li{
                display: inline;
            }
            #menu ul {
                list-style-type: none;
                margin:0;
                padding:0;
            }
            #outer{
                width: 700px;
                height: 600px;
                background: buttonface;
                margin: 0 auto;
                display: block;
            }
            #inner{
                background: buttonface;
                margin: 50px 50px 500px 50px;
                padding: 0;
                display: block;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <div id="header" style="">
                <div>
                    <h1 style ="color: white; margin-bottom: 0;">FB+</h1>
                </div>
                <div>
                    <ul>
                        <li><a href="#Home">Home</a></li>                    
                        <li><a href="#Logout">Logout</a></li>
                    </ul>
                </div>
            </div>
            <div id ="menu" style="background-color: lightblue ; height: 400px;width: 200px; float: left;">
                <ul>                  
                    <li><a href="record_transaction">Transaction</a></li>
                    <li><a href="customerInfo">Customer Information</a></li>
                    <li><a href="advertisement">Advertisement</a></li>
                </ul>
            </div>
        </div>
        <div id ="content" style="background-color: white; height: 200px; width: 500px;float: left">
            <form>
                <div id="outer">
                    <div id="inner"> <div> <span style="font-size: 20pt; font-family: Arial">Record Transaction</span> <br>
                            <div>  

                                <table>
                                    <tbody>
                                        <tr>
                                            <td>Transaction ID:</td><td><input name="transaction_id" placeholder="transaction id" type="text"></td>
                                        </tr>
                                        <tr>
                                            <td>User ID:</td><td><input name="User_Id" placeholder="User ID" type="text"></td>
                                        </tr>

                                        <tr>
                                            <td>Date: </td><td><input name="Date" placeholder="Date" type="text"></td>

                                        </tr>
                                        <tr>
                                            <td>Advertisement: </td><td><input name="Advertisement" placeholder="Advertisement" type="text"> </td>
                                        </tr>
                                        <tr>
                                            <td> Number of Unit: </td> <td><input name="Number_Of_Unit" placeholder="Number of Unit" type="text"></td>
                                        </tr>
                                        <tr>
                                            <td> Account: </td><td><input name="Account" placeholder="Account" type="text"></td>
                                        </tr>

                                        <tr>
                                            <td><button type="button">Add a transaction</button> </td>
                                            <td><button type = "button"> Cancel</button></td>
                                        </tr>

                                    </tbody>
                                </table>

                            </div>


                        </div>

                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
