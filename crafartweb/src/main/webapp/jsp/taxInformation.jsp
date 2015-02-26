<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<div class="inner">
    <div class="row">
      <div class="col-lg-3">
        <h1 style="color:#333; font-size:30px;"> Tax Information </h1>
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
          <div id="collapseOne" class="accordion-body collapse in body" style="padding-top:30px;padding-bottom: 30px;">
            <form class="form-horizontal" action="#" id="block-validate">
              <div class="row">
                <div class="col-lg-6">
                  <div class="form-group">
                    <label for="" class="control-label col-lg-4">VAT-NO</label>
                    <div class="col-lg-8">
                      <input type="number" id="VatNo" name="VatNo" class="form-control" 
                                	placeholder="VAT NO"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for=""class="control-label col-lg-4">CST-NO</label>
                    <div class="col-lg-8">
                      <input type="text" id="cstNo" name="cstNo" class="form-control" 
                                            placeholder="CST N0"/>
                    </div>
                  </div>
                </div>
              </div><br>
             <div class="row">
              <div class="col-lg-7">
                <center>
	                <a class="btn btn-success" href="#">&nbsp;SAVE&nbsp;</a>&nbsp;&nbsp;&nbsp;
	                <a class="btn btn-danger" href="#">CANCEL</a>
                </center>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
