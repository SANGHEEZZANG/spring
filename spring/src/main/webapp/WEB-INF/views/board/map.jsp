<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
   
<!DOCTYPE html>
<html>

  <head>
    <title>오시는길</title>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDchmiBmIrXO_g41VUxw9vQS7U3OWXbXKY&callback=initMap&libraries=&v=weekly"
      defer
    ></script>
    <style type="text/css">
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 50%;
      }

      /* Optional: Makes the sample page fill the window. */
      html,
      body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <script>
      // This example displays a marker at the center of Australia.
      // When the user clicks the marker, an info window opens.
      function initMap() {
        const seoul = { lat: 37.5610419, lng: 126.9751701 };
        const map = new google.maps.Map(document.getElementById("map"), {
          zoom: 16,
          center: seoul,
        });
        const contentString = '<div id="content">서울시청</div>';
         
        const infowindow = new google.maps.InfoWindow({
          content: contentString,
        });
        const marker = new google.maps.Marker({
          position: seoul,
          map,
          title: "seoul (city hall)",
        });
        marker.addListener("click", () => {
          infowindow.open(map, marker);
        });
      }
    </script>
  </head>
  <body>
  	<br></br>
  	<br></br>
    <div id="map"></div>
    <h1>오시는길 겁나멈 </h1>
		<br></br>
    	<br></br>
    	<br></br>
    	<br></br>
    	<br></br>
    	<br></br>
    	<br></br>
    
  </body>
</html>
<%@ include file="footer.jsp" %>