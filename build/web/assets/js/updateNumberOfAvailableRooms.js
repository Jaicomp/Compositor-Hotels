function updateNumberOfAvailableRooms(obj) {
	
	var idRHotelTypeRoom = obj.getAttribute("idrhoteltyperoom");
	var numberOfAvailableRooms = obj.value;
	console.log(idRHotelTypeRoom);
	console.log(numberOfAvailableRooms);
	let request = {
		method: "GET",
		url: "UpdateNumberOfAvailableRooms?id=" + idRHotelTypeRoom + "&numavailablerooms="+numberOfAvailableRooms,
		isAsynchronous: true

	}

	sendRequest(request, function(response) {
		console.log("DONE");
	});


}
