<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

  <div class="inner">
    <div class="row">
      <div class="col-lg-3">
        <h1 style="color:#333; font-size:30px;"> Bank Details </h1>
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
                    <label for="bankName" class="control-label col-lg-4">Bank-Name</label>
                    <div class="col-lg-8">
                      <input type="text" class="form-control" id="bankName" placeholder="Bank Name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">Account-Name</label>
                    <div class="col-lg-8">
                      <input type="text" id="accountName" name="accountName" class="form-control" 
                                            placeholder="Account Name" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">IFSC-Code</label>
                    <div class="col-lg-8">
                      <input type="number" id="IfscCode" name="IfscCode" class="form-control" 
                                	placeholder="IFSC Code" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">Branch-Name</label>
                    <div class="col-lg-8">
                      <input type="text" id="branchName" name="branchName" class="form-control" 
                                            placeholder="Branch Name"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">Branch-State</label>
                    <div class="col-lg-8">
                      <input type="text" id="branchState" name="branchState" class="form-control" 
                                            placeholder="Branch State"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">Branch-Pincode</label>
                    <div class="col-lg-8">
                      <input type="text" id="branchPincode" name="branchPincode" class="form-control" 
                                            placeholder="Branch PinCode"/>
                    </div>
                  </div>
                </div>
                <div class="col-lg-5">
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Account-Type</label>
                    <div class="col-lg-8">
                      <select class="form-control" id="accountType" placeholder="Account-Type">
                        <option>Savings</option>
                        <option>Current</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label  for="" class="control-label col-lg-4">Account-No</label>
                    <div class="col-lg-8">
                      <input type="number" id="accountNo" name="accountNo" class="form-control" 
                                	placeholder="Account Code" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label  for="" class="control-label col-lg-4">MICR</label>
                    <div class="col-lg-8">
                      <input type="number" id="micr" name="micr" class="form-control" 
                                	placeholder="MICR" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Branch-Street-Address</label>
                    <div class="col-lg-8">
                      <input type="text" id="branchStreetAddress" name="branchStreetAddress" class="form-control" 
                                        placeholder="Branch Street Address" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">Branch-City</label>
                    <div class="col-lg-8">
                      <input type="text" id="branchCity" name="branchCity" class="form-control" 
                                	placeholder="Branch City" />
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