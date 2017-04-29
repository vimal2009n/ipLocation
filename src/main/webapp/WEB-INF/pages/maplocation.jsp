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
	   <div class="form-inline">
	    <div class="row">
		  <div class="col-xs-6">
 		 <div class="form-group">
   			 <label for="ipAddress">Enter IP:</label>
   			 <input type="text" class="form-control" id="input-search" placeholder="Ip address">
		  </div>
		  <input type="button" id="input-button-search"  class="btn btn-primary"  value="Search">
		 </div>
		 
		  <div class="col-xs-6"> 
 	     <div class="form-group">
   			 <label for="cityName">Enter City:</label>
  			  <input type="text" class="form-control" id="input-search-byname" placeholder="City Name">
 		 </div>
 		 	<input type="button" id="input-button-search-name"  class = "btn btn-primary" value="Search">
		</div>
		</div>
		</div>
   	</div>
   </div>
		<div id="table" >
			
		  <div id="details">
			<dl class="dl-horizontal">
 				 <dt>Country Name</dt>
  				 <dd id="country"></dd>
  				 
  				 <dt>State Name</dt>
  				 <dd id="state"></dd>
  				 
  				  <dt>City Name</dt>
  				 <dd id="city"></dd>
  			</dl>
  			</div>	
  			
  				<table id="btnTable">
  				<tr><td><input type="button" class="btn btn-primary" onclick="showStreetView()" value="StreetView"></td>
  				    <td><input type="button" class="btn btn-success" onclick="speed(1)" value="Forward"></td>
  				    <td><input type="button" class="btn btn-info" onclick="turn(-15)" value="Left"></td>
  				    <td><input type="button" class="btn btn-info" onclick="turn(15)" value="Right"></td>
  				    <td><input type="button" class="btn btn-warning" onclick="speed(-1)" value="Break"></td>
  				</tr>
			</table>
			
			
			
		   </div>
		  <div  id="map">
		</div>
	</body>
</html>