<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div class="col-lg-10" style="min-height: 100px;padding-top:10px">
<div class="container" style="background-color: white;">
		<!--BLOCK SECTION -->
		<div style="margin-top: 5px">
			<div class="col-lg-2 col-md-2 col-sm-6">
				<div class="tile" style="background-color: #FF5C33;">
					<a href="#">
						<div class="tile_heading">Total Orders</div>
						<div>
							<i class="icon-shopping-cart"></i>
							<h2 class="pull-right">
								<span class="icon-inr"></span>&nbsp;
							</h2>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-6">
				<a href="#">
					<div class="tile" style="background-color: #0099FF;">
						<div class="tile_heading">Total Sales</div>
						<div class="tile_body">
							<i class="icon-credit-card"></i>
							<h2 class="pull-right">
								<span class="icon-inr"></span>&nbsp;100
							</h2>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-6">
				<a href="#">
					<div class="tile" style="background-color: #19A347;">
						<div class="tile_heading">Total Revenue</div>
						<div>
							<i class="icon-signal"></i>
							<h2 class="pull-right">
								<span class="icon-inr"></span>&nbsp;10000000
							</h2>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-6">
				<a href="#">
					<div class="tile" style="background-color: #FF3333;">
						<div class="tile_heading">Total Customers</div>
						<div>
							<i class="icon-user"></i>
							<h2 class="pull-right">
								<span class="icon-inr"></span>&nbsp;500
							</h2>
						</div>
					</div>
				</a>
			</div>
			<div class="col-lg-2 col-md-2 col-sm-6">
				<a href="#">
					<div class="tile" style="background-color: #A52A2A;">
						<div class="tile_heading">Total Sellers</div>
						<div>
							<i class="icon-user"></i>
							<h2 class="pull-right">
								<span class="icon-inr"></span>&nbsp;500
							</h2>
						</div>
					</div>
				</a>
			</div>
		</div>
		<!--END BLOCK SECTION -->
		<hr />
		<!--CHART SECTION -->
		<div class="container col-lg-10">
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
						<td>0.4</td>
						<td>2</td>
						<td>Ice cream</td>

					</tr>
					<tr>
						<td>3.5</td>
						<td>10</td>
						<td>Umbrellas</td>

					</tr>
					<tr>
						<td>0.56</td>
						<td>4.5</td>
						<td>Horse shoes</td>

					</tr>
					<tr>
						<td>0.2</td>
						<td>0.8</td>
						<td>Pencils</td>

					</tr>
					<tr>
						<td>1.3</td>
						<td>5</td>
						<td>Mugs</td>

					</tr>
					<tr>
						<td>6</td>
						<td>20</td>
						<td>Wizardhats</td>

					</tr>
					<tr>
						<td>1</td>
						<td>3</td>
						<td>Lightbulbs</td>

					</tr>
					<tr>
						<td>4</td>
						<td>13</td>
						<td>Fire</td>

					</tr>
					<tr>
						<td>5.5</td>
						<td>7.6</td>
						<td>Wheelbarrows</td>

					</tr>
					<tr>
						<td>5</td>
						<td>6.5</td>
						<td>Deck chairs</td>

					</tr>
				</tbody>
			</table>

		</div>
		<!-- TABLE SECTION -->

		<div class="container">
			<div class="col-lg-10">
				<div class="panel panel-default" style="margin-left:20px">
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
</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		/*  $.jqplot.config.enablePlugins = true;
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
		 ); */
	});
</script>