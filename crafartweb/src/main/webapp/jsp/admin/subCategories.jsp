<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" /> 
<c:set var="context" value="${pageContext.servletContext.contextPath}" />

<div class="col-lg-10">
	<div class="container-fluid" style="background-color: white;">
		<div class="row">
			<div class="col-lg-3">
				<h1 style="color: #333; font-size: 25px; margin-top: 20px;">&nbsp;Sub Categories</h1>
			</div>
			<div class="pull-right" style="padding: 25px;">
				<button type="button" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<hr />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-th-list"></i> &nbsp;Sub Categories List
				</h3>
			</div>
			<br>

			<!-- Table Section-->
			<div class="container">
				<div class="tab-pane" id="tab-shipping">
					<div class="table-responsive">
						<table id="shipping" class="table table-striped table-bordered table-hover pull-left">
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Categories Name</td>
									<td>Sort Order</td>
									<td>Action</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>MP3 Players > test 18</td>
									<td>0</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>MP3 Players > test 19</td>
									<td>0</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Components</td>
									<td>3</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Components > Mice and Trackballs</td>
									<td>1</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
								<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Components > Components  >  Printers</td>
									<td>1</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
								<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Components > Components  >  Scanners</td>
									<td>1</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
								<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Desktops</td>
									<td>1</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>
								<thead>
								<tr>
									<td><input type="checkbox" name="myTextEditBox" value="checked" /></td>
									<td>Laptops & Notebooks  >  Macs</td>
									<td>1</td>
									<td><button type="button" class="btn btn-warning">Edit</button></td>
								</tr>
							</thead>

						</table>
						<nav>
							<ul class="pagination">
								<li class="disabled"><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


