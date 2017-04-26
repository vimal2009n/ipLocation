var vehicleBearing = 0;
var vehicleSpeed = 0;
var panorama;
var lat = 0;
var lon = 0;
var centre = 0;
var selectedItemId=0;
var links=0;
function showStreetView() {

	alert(lat+"  "+lon);
	/*centre=new google.maps.LatLng(lat, lon);
	panorama = new GStreetviewPanorama(document.getElementById("map"));
	panorama.setLocationAndPOV(centre, {yaw: 180, b: 0});*/
	
	centre=new google.maps.LatLng(lat, lon);
	panorama=new google.maps.StreetViewPanorama(document.getElementById("map"));
	panorama.setPosition(centre);
	panorama.setPov({heading: 180, pitch: 0});

	
	moveStart();
}

//turn left or right        
function turn(a)
{
	
	vehicleBearing += a;
	if (vehicleBearing < 0)
	{
		vehicleBearing += 360;
	}
	if (vehicleBearing > 360)
	{
		vehicleBearing -= 360;
	}
	//panorama.setPOV({yaw: vehicleBearing, b: 0});
	
	panorama.setPov({heading: vehicleBearing, pitch: 0});
	//panorama.setPosition(links[vehicleBearing]);
	
}

function speed(a)
{
	if (a < 0)
	{
		// brake
		vehicleSpeed = -1;
	} else
	{
		// accel
		vehicleSpeed += a;

		// speed limit
		if (vehicleSpeed > 6)
		{
			vehicleSpeed = 6;
		}
	}
}

function moveStart()
{
	setTimeout("moveStage()", parseInt(3000 / vehicleSpeed));
}

function moveStage()
{
	
	links =  panorama.getLinks();
	
	// forward
	if (vehicleSpeed > 0)
	{
		//panorama.followLink(vehicleBearing);
		//console.log("before pano");
		panorama.setPano(links[vehicleSpeed].pano);
		
	}
	// break;
	if (vehicleSpeed < 0)
	{
		vehicleSpeed = 0;
	}

	setTimeout("moveStage()", parseInt(3000 / Math.abs(vehicleSpeed)));
}

$(document).ready(function () {
	
	var locations="";
	
	$("#table").hide();
	
	
	//*********************auto complete***********************************
	
	 $( "#input-search-byname" ).autocomplete({
	      source: function( request, response ) {
	    	  $.ajax( {
	              url: "getLocationByName",
	              dataType: "json",
	               data: {
	            	  geoName: $('#input-search-byname').val()
	              },
	          success: function( data ) {
	        	  locations=[];
	  			 for(i=0;i<data.length;i++){
	  				 locations.push(data[i]);
	  			 }
	  			  response( locations );
	         }
	        } );
	      },
	      minLength: 2,
	      select: function( event, ui ) {
	    	 $('#input-search-byname').val(ui.item.locationName);
	    	 selectedItemId=ui.item.id;
	    	 return false;
	      }
	    } ).autocomplete( "instance" )._renderItem = function( ul, item ) {
	        return $( "<li>" ).append( "<div>" + item.locationName + "</div>" ).appendTo( ul );
	      };
	
	
	//*******************************Selected By Ip**********************************
	$("#input-button-search").click(function () {
		
		 $.getJSON("getLocationByIpAddress",
		 {
		 ipAddress: $('#input-search').val()
		 },
		 function (data) {
		json = data;
		if (json["countryCode"] != null) {
			$("#table").show();
			
			$("#country").text(json["countryName"]);
			$("#state").text(json["regionName"]);
			$("#city").text(json["city"]);
			
			 lat = parseFloat(json["latitude"]);
			 lon = parseFloat(json["longitude"]);
		     showMap(lat,lon);
		
		}
		}).done(function () {
		 })
		 .fail(function () {
		 })
		 .complete(function () {
		 });
	});
	
	//*************************Selected By Id**************************

	$("#input-button-search-name").click(function () {
		 $.getJSON("getLocationSelectedById",
		 {
			 selectName: selectedItemId
		 },
		 function (data) {
			 
			 lat=parseFloat(data["lat"]);
			 lon=parseFloat(data["lon"]);
			 showMap(lat,lon);
			
		}).done(function () {
		 })
		 .fail(function () {
		 })
		 .complete(function () {
		 });
	});
	
	
	//***********************************************
	
	function showMap(lat,lon){
	
		var googleLatLon=new google.maps.LatLng(lat,lon);
		
		var latlng = new google.maps.LatLng(lat, lon);
		 var mapOptions = {
		 zoom: 13,
		 center: latlng,
		 mapTypeId: google.maps.MapTypeId.ROADMAP
		 };

		 var map = new google.maps.Map(document.getElementById("map"), mapOptions);
		 
		 
		 var title = "Server Location";
			addMarker(map, googleLatLon, title, "");
	}
	function addMarker(map,latLong,title,content){
		
		var markerOptions ={
				
				position:latLong,
				map:map,
				title:title,
				clickable:true
		};
		var marker=new google.maps.Marker(markerOptions );
	}
 });


