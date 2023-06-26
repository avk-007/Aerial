<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation details</title>
</head>
<body>
	<h1>Flight Details</h1>
	<%-- spring expression and breakTag--%>
	  Flight Number: ${flight.flightNumber}	</br>
      operating Airlines: ${flight.operatingAirlines}</br> 
	  Departure City: ${flight.departureCity}</br>
	  Arrival City: ${flight.arrivalCity}</br> 
	  Departure Date: ${flight.dateOfDeparture}</br>
	


	<h2>Enter Passenger Details</h2>
	<form action="confirmReservation" method ="post">
		<pre>
		First Name<input type="text" name="firstName"/>
		Last Name<input type="text" name="lastName"/>
		Middle Name<input type="text" name="middleName"/>
		email<input type="text" name="email"/>
		phone<input type="text" name="phone"/>
		<input type="hidden" name ="flightId" value="${flight.id }"/> 
		
	   <h2>Enter the Payment Details</h2>
		Name Of The Card<input type = "text" name="nameOfTheCard"/>
		Card Number<input type = "text" name="cardNumbar"/>
		Cvv<input type="text" name ="cvv"/>
		Expiry Date<input type ="text" name ="expirDate"/>	
	    <input type="submit" value="complete reservation"/>
		
		</pre>
		

	</form>
</body>
</html>

<%-- hidden form is picking the data but enduser can not see the data --%>