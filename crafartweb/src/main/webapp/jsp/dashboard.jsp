<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />


<div class="inner" style="min-height: 700px;">
      <div class="row">
        <div class="col-lg-3">
          <h1 style="color:#333; font-size:30px;"> Seller Dashboard </h1>
        </div>
        <div class="col-lg-9" style="padding-top:20px;">
          <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> UPDATED SUCCESSFULLY </div>
          <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> SELLER APPROVED:YES </div>
          <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> COMMISSION: 10% </div>
        </div>
      </div>
      <hr />
      <!--BLOCK SECTION -->
      
      <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-6"> <a href="#">
          <div class="tile" style="background-color:#FF5C33;">
            <div class="tile_heading"> Total Orders </div>
            <div class="tile_body"> <i class="icon-shopping-cart"></i>
              <h2 class="pull-right">50</h2>
            </div>
          </div>
          </a> </div>
        <div class="col-lg-3 col-md-3 col-sm-6"> <a href="#">
          <div class="tile" style="background-color:#0099FF;">
            <div class="tile_heading"> Total Sales </div>
            <div class="tile_body"> <i class="icon-credit-card"></i>
              <h2 class="pull-right">100</h2>
            </div>
          </div>
          </a> </div>
        <div class="col-lg-3 col-md-3 col-sm-6"> <a href="#">
          <div class="tile" style="background-color:#19A347;">
            <div class="tile_heading"> Total Revenue </div>
            <div class="tile_body"> <i class="icon-signal"></i>
              <h2 class="pull-right"><span class=" icon-inr"></span>&nbsp;10000000000</h2>
            </div>
          </div>
          </a> </div>
        <div class="col-lg-3 col-md-3 col-sm-6"> <a href="#">
          <div class="tile" style="background-color:#FF3333;">
            <div class="tile_heading"> Total Customers </div>
            <div class="tile_body"> <i class="icon-user"></i>
              <h2 class="pull-right">500</h2>
            </div>
          </div>
          </a> </div>
      </div>
      <!--END BLOCK SECTION -->
      <hr />
      
      <!-- CHART & CHAT  SECTION -->
      <div class="row">
        <div class="col-lg-8">
          <div class="panel panel-default">
            <div class="panel-heading"> Categories Chart </div>
            <div class="panel-body">
              <div class="demo-container">
                <div id="placeholder" class="demo-placeholder"></div>
              </div>
            </div>
          </div>
        </div>
        
        <!--END CHAT & CHAT SECTION --> 
        
        <!-- NOTIFICATION SECTION-->
        
        <div class="col-lg-4">
          <div class="panel panel-danger">
            <div class="panel-heading"> <i class="icon-bell"></i> Notifications Alerts Panel </div>
            <div class="panel-body">
              <div class="list-group"> <a href="#" class="list-group-item"> <i class=" icon-comment"></i> New Comment <span 
              			class="pull-right text-muted small"><em> 4 minutes ago</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-twitter"></i> 3 New Followers <span
               				 class="pull-right text-muted small"><em> 12 minutes ago</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-envelope"></i> Message Sent <span class="pull-right text-muted small"><em> 27 minutes ago</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-tasks"></i> New Task <span class="pull-right text-muted small"><em>43 minutes ago</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-upload"></i> Server Rebooted <span class="pull-right text-muted small"><em>11:32 AM</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-warning-sign"></i> Server Crashed! <span class="pull-right text-muted small"><em>11:13 AM</em> </span> </a> <a href="#" class="list-group-item"> <i class="icon-ok"></i> New Order Placed <span class="pull-right text-muted small"><em>9:49 AM</em> </span> </a> <a href="#" class="list-group-item"> <i class=" icon-money"></i> Payment Received <span class="pull-right text-muted small"><em>Yesterday</em> </span> </a> </div>
              <a href="#" class="btn btn-default btn-block btn-primary">View All Alerts</a> </div>
          </div>
        </div>
      </div>
      <!-- END NOTIFICATION SECTION--> 
      
      <!-- TABLE SECTION -->
      
      <div class="row">
        <div class="col-lg-12">
          <div class="panel panel-default">
            <div class="panel-heading"> Latest Orders </div>
            <div class="panel-body">
              <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                  <thead>
                    <tr>
                      <th>Order ID</th>
                      <th>Customer Name</th>
                      <th>Status</th>
                      <th>Confirmed Date</th>
                      <th>Total</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="odd gradeX">
                      <td>25</td>
                      <td>Sachin</td>
                      <td>Shipped</td>
                      <td class="center">16/02/2015</td>
                      <td class="center">$300</td>
                      <th><a href="#" class="btn btn-info">View</a></th>
                    </tr>
                    <tr class="even gradeC">
                      <td>35</td>
                      <td>Dhiyanesh</td>
                      <td>Shipped</td>
                      <td class="center">16/02/2015</td>
                      <td class="center">$200</td>
                      <th><a href="#" class="btn btn-info">View</a></th>
                    </tr>
                    <tr class="odd gradeA">
                      <td>15</td>
                      <td>Amirth Singh</td>
                      <td>Processed</td>
                      <td class="center">16/02/2015</td>
                      <td class="center">$700</td>
                      <th><a href="#" class="btn btn-info">View</a></th>
                    </tr>
                    <tr class="even gradeA">
                      <td>20</td>
                      <td>Rizwan</td>
                      <td>Processed</td>
                      <td class="center">16/02/2015</td>
                      <td class="center">$400</td>
                      <th><a href="#" class="btn btn-info">View</a></th>
                    </tr>
                    <tr class="odd gradeA">
                      <td>10</td>
                      <td>Ganesh</td>
                      <td>Pending</td>
                      <td class="center">16/02/2015</td>
                      <td class="center">$250</td>
                      <th><a href="#" class="btn btn-info">View</a></th>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>