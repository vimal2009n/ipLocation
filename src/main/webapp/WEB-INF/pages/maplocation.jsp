<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ip Location</title>
		<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<!-- <script src="http://maps.google.com/maps?file=api&amp;v=3.27&amp;key=AIzaSyCqecPcK2Znd1CR5KzvoQvhyEDxFi-sCb8" type="text/javascript"></script>-->
		 
   		 <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCqecPcK2Znd1CR5KzvoQvhyEDxFi-sCb8" type="text/javascript"></script>  
   		<script type="text/javascript"  src="resources/scripts/validate.js"></script>
		
		<link rel="stylesheet" href="resources/style/style.css">
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
 		
	
		
	</head>
	<body>
		
	<div class="panel panel-success">	
	 <div class="panel-heading">Geo Location</div>
  		<div class="panel-body">
		 <div class="row">
		  <div class="col-xs-6">
			Enter IP:<input type="text" placeholder="Ip address"  id="input-search" >
			<span>
				<input type="button" id="input-button-search"  value="Search">
			</span>
		 </div>
		 <div class="col-xs-6">
		 	Enter Name:
		
			<input type="text"  id="input-search-byname"  placeholder="City Name">
	    	<input type="button" id="input-button-search-name" value="Search">
		 	
		 </div>	
		 
		</div> 
		</div>
	</div>	
		
		<div id="table">
			<table>
				<tr>
					<td>Country Name:</td>
					<td id="country"></td>
				</tr>
				<tr>
					<td>State Name:</td>
					<td id="state"></td>
				</tr>
				<tr>
					<td>City Name:</td>
					<td id="city"></td>
				</tr>
				<tr>
					<td><input type="button" onclick="showStreetView()" value="StreetView"></td>
					<td><input type="button" onclick="speed(1)" value="Forward"></td>
					<td><input type="button" onclick="turn(-15)" value="Left"></td>
					<td><input type="button" onclick="turn(15)" value="Right"></td>
					<td><input type="button" onclick="speed(-1)" value="Break"></td>
				</tr>
			</table>
		</div>
		<div style="width:800px;height:600px" id="map">
		</div>
	</body>
</html>