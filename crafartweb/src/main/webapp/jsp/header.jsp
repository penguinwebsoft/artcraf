<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}"/>
<c:set var="context" value="${pageContext.request.contextPath}"/>


<!-- HEADER SECTION -->
   <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px; font-size:16px;"> <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle"> <i class="icon-align-justify"></i> </a> 
      <!-- LOGO SECTION -->
      <header class="navbar-header"> <a href="${baseURL}/menu/dashboard" class="navbar-brand"> <img src="${context}/resources/img/logo1.png" alt="" /> </a> </header>
      <!-- END LOGO SECTION --> 
      
      <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <span class="label label-success">2</span> <i class="icon-tasks"></i>&nbsp; <i class=
                            "icon-chevron-down"></i> </a>
          <ul class="dropdown-menu dropdown-messages">
            <li> <a href="#">
              <div> <strong>John Smith</strong> <span class="pull-right text-muted"> <em>Today</em> </span> </div>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing. <br />
                <span class="label label-primary">Important</span> </div>
              </a> </li>
            <li class="divider"></li>
            <li> <a href="#">
              <div> <strong>Raphel Jonson</strong> <span class="pull-right text-muted"> <em>Yesterday</em> </span> </div>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing. <br />
                <span class="label label-success"> Moderate </span> </div>
              </a> </li>
            <li class="divider"></li>
            <li> <a href="#">
              <div> <strong>Chi Ley Suk</strong> <span class="pull-right text-muted"> <em>26 Jan 2014</em> </span> </div>
              <div>Lorem ipsum dolor sit amet, consectetur adipiscing. <br />
                <span class="label label-danger"> Low </span> </div>
              </a> </li>
            <li class="divider"></li>
            <li> <a class="text-center" href="#"> <strong>Read All Messages</strong> <i class="icon-angle-right"></i> </a> </li>
          </ul>
        </li>
        <!--END MESSAGES SECTION -->
        
        <li><a href="#"> <i class="icon-user"> </i> User Profile </a> </li>
        <li> <a href="#"> <i class="icon-gear"> </i> Change Password </a> </li>
        <li><a href="#"> <i class="icon-signout"> </i> Logout </a> </li>
      </ul>
</nav>
  <!-- END HEADER SECTION --> 

 

