<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

 <div class="inner">
 <div class="row">
      <div class="col-lg-3">
        <h1 style="color:#333; font-size:30px;"></h1>
      </div>
      <div class="col-lg-9" style="padding-top:20px;">
        <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> UPDATED SUCCESSFULLY </div>
        <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> SELLER APPROVED:YES </div>
        <div class=" col-lg-4 alert alert_success " style="margin-bottom:5px; color:#FF704D; font-size:17px;"> COMMISSION: 10% </div>
      </div>
    </div>
    
    <hr />
    <div class="row">
      <div class="col-lg-12">
        <div class="box">
          <div id="collapseOne" class="accordion-body collapse in body" style="padding-top:40px; padding-bottom:40px;">
            <form class="form-horizontal" action="#" id="block-validate">
              <div class="row">
                <div class="col-lg-11" style="margin-left:20px;">
                  
                  <div class="form-group">
                    <label for="" class="control-label col-lg-2"  style="font-size:18px; padding-top:35px;">Shipping And 
                    &nbsp;Return Policy</label>
                    <div class="col-lg-10">
                     	<textarea  id="Shipping" name="Shipping" class="form-control" 
                                	placeholder="Shipping  and  Return Policy" rows="5"></textarea>
                    </div>
                  </div>
              </div>
              </div><br>
              <div class="row">
              	<div class="col-lg-12">
                    <center>
                    <a class="btn btn-success" href="#">&nbsp;&nbsp;SAVE&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-danger" href="#">CANCEL</a>
                    </center>
                </div>
              </div>
           </div>
            </form>
          </div>
        </div>
      </div>
    </div>
<!--END PAGE CONTENT --> 

