<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<!--PAGE CONTENT -->

  <div class="inner">
    <div class="row">
      <div class="col-lg-3">
        <h1 style="color:#333; font-size:30px;"> My Account </h1>
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
          <div id="collapseOne" class="accordion-body collapse in body" style="padding-top:40px; padding-bottom:30px;">
            <form class="form-horizontal" action="#" id="block-validate">
              <div class="row">
                <div class="col-lg-5" style="margin-left: 50px;">
                  <div class="form-group">
                    <label for="firstName" class="control-label col-lg-4">First-Name</label>
                    <div class="col-lg-8">
                      <input type="text" class="form-control" id="firstName" placeholder="First Name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Gender</label>
                    <div class="col-lg-8">
                      <select class="form-control" id="gender" placeholder="Gender">
                        <option>Male</option>
                        <option>Female</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">
                    Company-Name</label>
                    <div class="col-lg-8">
                      <input type="text" id="companyName" name="companyName" class="form-control" 
                                            placeholder="company Name" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Street-Address</label>
                    <div class="col-lg-8">
                      <input type="text" id="streetAddress" name="streetAddress" class="form-control" 
                                	placeholder="Street Address" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">City</label>
                    <div class="col-lg-8">
                      <input type="text" id="city" name="city" class="form-control" 
                                	placeholder="city" />
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Phone-No</label>
                    <div class="col-lg-8">
                      <input type="number" id="phoneNo" name="phoneNo" class="form-control" 
                                	placeholder="Phone No" />
                    </div>
                  </div>
                  
                  
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Tin-No</label>
                    <div class="col-lg-8">
                      <input type="number" id="tinNo" name="tinNo" class="form-control" 
                                	placeholder="Tin No" />
                    </div>
                  </div>
                </div>
                <div class="col-lg-5">
                  <div class="form-group">
                    <label for="lastName" class="control-label col-lg-4">Last-Name</label>
                    <div class="col-lg-8">
                      <input type="text" class="form-control" id="lastName" placeholder="Last Name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""  class="control-label col-lg-4">Date-Of-Birth</label>
                    <div class="col-lg-8">
                    <!--<div class="well">
                        <div id="dpYears" class="input-append date" data-date-viewmode="years" 
                        		data-date-format="dd-mm-yyyy" data-date="12-02-2012">-->
                        <input class="span2 form_control_width" id="dateOfBirth" type="text" readonly value="12-02-2012" size="16"
                        	 style="padding-left: 5px; float:left; margin-right: 8px;">
                        <span class="add-on">
                        <i class="icon-calendar" style="font-size:20px;"></i>
                        </span>
                       <!-- </div>
                        </div> -->
                     </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Company-Logo</label>
                    <div class="col-lg-8">
                      <input type="file" id="companyLogo" name="companyLogo"
                                                    placeholder="Company Logo" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">States</label>
                    <div class="col-lg-8">
                      <input type="text" id="states" name="states" class="form-control" 
                                        placeholder="states" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label  for="" class="control-label col-lg-4">Pin-Code</label>
                    <div class="col-lg-8">
                      <input type="number" id="pinCode" name="pinCode" class="form-control" 
                                	placeholder="Pin Code" />
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Store-Name</label>
                    <div class="col-lg-8">
                      <input type="text" id="storeName" name="storeName" class="form-control" 
                                	placeholder="Store Name" />
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">EPCH-No</label>
                    <div class="col-lg-8">
                      <input type="number" id="EpchNo" name="EpchNo" class="form-control" 
                                	placeholder="EPCH NO" />
                    </div>
                  </div>
                </div>
              </div><br>
              <div class="row">
                <div class="col-lg-10" style="margin-left: 50px;">
                 <div class="form-group">
                    <label for="" class="control-label col-lg-2">Store-Descripton</label>
                    <div class="col-lg-10">
                     	<textarea  id="storeDescripton" name="storeDescripton" class="form-control" 
                                	placeholder="Store Descripton" rows="5"></textarea>
                    </div>
                  </div>
                  </div>
                
              </div><br>
              
              <div class="row">
                <center>
	                <a class="btn btn-success" href="#">&nbsp;&nbsp;SAVE&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
	                <a class="btn btn-danger" href="#">CANCEL</a>
                </center>
              </div>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

<!--END PAGE CONTENT --> 



