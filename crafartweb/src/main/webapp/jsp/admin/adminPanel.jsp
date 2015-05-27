<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="context" value="${pageContext.servletContext.contextPath}" />


<div class="inner" style="min-height: 700px;">

	<!--BLOCK SECTION -->
	<div class="row">
		<div class="col-lg-2 col-md-3 col-sm-6">
			<div class="tile" style="background-color: #FF5C33;">
				<a href="#">
					<div class="tile_heading">Total Orders</div>
					<div class="tile_body">
						<i class="icon-shopping-cart"></i>
						<h2 class="pull-right">50</h2>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-2 col-md-3 col-sm-6">
			<a href="#">
				<div class="tile" style="background-color: #0099FF;">
					<div class="tile_heading">Total Sales</div>
					<div class="tile_body">
						<i class="icon-credit-card"></i>
						<h2 class="pull-right">100</h2>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-2 col-md-3 col-sm-6">
			<a href="#">
				<div class="tile" style="background-color: #19A347;">
					<div class="tile_heading">TotalRevenue</div>
					<div class="tile_body">
						<i class="icon-signal"></i>
						<h2 class="pull-right">
							<span class=" icon-inr"></span>&nbsp;10000000000
						</h2>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-2 col-md-3 col-sm-6">
			<a href="#">
				<div class="tile" style="background-color: #FF3333;">
					<div class="tile_heading">TotalCustomers</div>
					<div class="tile_body">
						<i class="icon-user"></i>
						<h2 class="pull-right">500</h2>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-2 col-md-3 col-sm-6">
			<a href="#">
				<div class="tile" style="background-color: #A52A2A;">
					<div class="tile_heading">TotalSellers</div>
					<div class="tile_body">
						<i class="icon-user"></i>
						<h2 class="pull-right">500</h2>
					</div>
				</div>
			</a>
		</div>
	</div>
	<!--END BLOCK SECTION -->
	<hr />
	<!--CHART SECTION -->
	<table class="fm-column-bar" data-fm-pull-out-items="1,3" data-fm-pull-out-title="Marketing campaign" data-fm-value-suffix="$">
		<thead>
			<tr>
				<th>Product</th>
				<th>Supplier price</th>
				<th>Sales price</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Ice cream</td>
				<td>0.4</td>
				<td>2</td>
				

			</tr>
			<tr>
				<td>Umbrellas</td>
				<td>3.5</td>
				<td>10</td>
				

			</tr>
			<tr>
				<td>Horse shoes</td>
				<td>0.56</td>
				<td>4.5</td>
				

			</tr>
			<tr>
				<td>Pencils</td>
				<td>0.2</td>
				<td>0.8</td>
				

			</tr>
			<tr>
				<td>Mugs</td>
				<td>1.3</td>
				<td>5</td>
				

			</tr>
			<tr>
			<td>Wizardhats</td>
				<td>6</td>
				<td>20</td>
				

			</tr>
			<tr>
				<td>Lightbulbs</td>
				<td>1</td>
				<td>3</td>
				

			</tr>
			<tr>
				<td>Fire</td>
				<td>4</td>
				<td>13</td>
				

			</tr>
			<tr>
				<td>Wheelbarrows</td>
				<td>5.5</td>
				<td>7.6</td>
				

			</tr>
			<tr>
				<td>Deck chairs</td>
				<td>5</td>
				<td>6.5</td>
				

			</tr>
		</tbody>
	</table>


	<!-- TABLE SECTION -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Latest Orders</div>
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
									<td>Rahul</td>
									<td>Shipped</td>
									<td class="center">16/05/2015</td>
									<td class="center">$600</td>
									<th><a href="#" class="btn btn-info">View</a></th>
								</tr>
								<tr class="even gradeC">
									<td>35</td>
									<td>Ganesh</td>
									<td>Shipped</td>
									<td class="center">16/05/2015</td>
									<td class="center">$500</td>
									<th><a href="#" class="btn btn-info">View</a></th>
								</tr>
								<tr class="odd gradeA">
									<td>15</td>
									<td>Bharath</td>
									<td>Processed</td>
									<td class="center">16/05/2015</td>
									<td class="center">$700</td>
									<th><a href="#" class="btn btn-info">View</a></th>
								</tr>
								<tr class="even gradeA">
									<td>20</td>
									<td>Kumaran</td>
									<td>Processed</td>
									<td class="center">16/05/2015</td>
									<td class="center">$800</td>
									<th><a href="#" class="btn btn-info">View</a></th>
								</tr>
								<tr class="odd gradeA">
									<td>10</td>
									<td>Abdul</td>
									<td>Pending</td>
									<td class="center">16/05/2015</td>
									<td class="center">$550</td>
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
<script type="text/javascript">
	/* $(document).ready(function(){
	 $.jqplot.config.enablePlugins = true;
	 var s1 = [2, 6, 7, 10];
	 var ticks = ['a', 'b', 'c', 'd'];
	
	 plot1 = $.jqplot('chart1', [s1], {
	 // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
	 animate: !$.jqplot.use_excanvas,
	 seriesDefaults:{
	 renderer:$.jqplot.BarRenderer,
	 pointLabels: { show: true }
	 },
	 axes: {
	 xaxis: {
	 renderer: $.jqplot.CategoryAxisRenderer,
	 ticks: ticks
	 }
	 },
	 highlighter: { show: false }
	 });
	
	 $('#chart1').bind('jqplotDataClick', 
	 function (ev, seriesIndex, pointIndex, data) {
	 $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
	 }
	 );
	 }); */
</script>