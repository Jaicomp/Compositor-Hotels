
let listRooms;
let hotel;
let hotelName;
let numberOfAdults;
let numberOfChildren;
let entryDate;
let departurDate;

function init() {
	listRooms = document.getElementById("listRooms");
        
}

function autocompleteRoomsList() {
    
    hotel = document.getElementsByTagName("select")[0];
    hotelName = hotel.options[hotel.selectedIndex].value;
    
    numberOfAdults = document.getElementById("adults");
    numberOfAdults = numberOfAdults.options[numberOfAdults.selectedIndex].value;
    
    numberOfChildren = document.getElementById("children");
    numberOfChildren = numberOfChildren.options[numberOfChildren.selectedIndex].value;
    
    entryDate = document.getElementById("entryDate");
    departureDate = document.getElementById("departureDate");
    
    let request = {
        method: "GET",
        url: "AutocompleteRoomsList?hotel="+hotelName,
        isAsynchronous: true
    }
    
    
    sendRequest(request,function(responseXML) {
        
        removeAllRooms();
        removeAllRooms();
        removeAllRooms();
        
        let rooms = responseXML.getElementsByTagName("rooms")[0];
        
        if (rooms.childNodes.length > 0) {
            
            for(let i = 0; i < rooms.childNodes.length; i++) {
                
                let room = rooms.childNodes[i];
                let idRoom = room.getElementsByTagName("idRoom")[0];
                let hotel = room.getElementsByTagName("hotel")[0];
                let typeRoom = room.getElementsByTagName("typeRoom")[0];
                let numRoomsAvailable = room.getElementsByTagName("numRoomsAvailable")[0];
                let price = room.getElementsByTagName("price")[0];
                
               
                let roomDiv = document.createElement("div");
                roomDiv.setAttribute('class','room visible'); + 
                roomDiv.setAttribute('typeRoom',typeRoom.childNodes[0].nodeValue);
                
                
                let image = document.createElement("img");
                image.setAttribute("class", "imageRoom");
                image.setAttribute("src", "http://www.srisrivaastu.com/image/peh-superior-room.jpg");
                image.setAttribute("alt", "room");
                image.setAttribute("width", "200");
                image.setAttribute("height", "200");
                
                roomDiv.appendChild(image);
                
                let nameHotelDiv = document.createElement("div");
                nameHotelDiv.setAttribute("class", "nameHotel");
                let textNode = document.createTextNode(hotel.childNodes[0].nodeValue);
                nameHotelDiv.appendChild(textNode);
                
                
                let priceDiv = document.createElement("div");
                priceDiv.setAttribute("class", "price");
                textNode = document.createTextNode("€" + price.childNodes[0].nodeValue);
                priceDiv.appendChild(textNode);
                
                let typeRoomDiv = document.createElement("div");
                typeRoomDiv.setAttribute("class", "typeRoom");
                textNode = document.createTextNode(typeRoom.childNodes[0].nodeValue);
                typeRoomDiv.appendChild(textNode);
                
                let numOfRoomsAvailableDiv = document.createElement("div");
                numOfRoomsAvailableDiv.setAttribute("class", "numberOfRoomsAvailable");
                textNode = document.createTextNode("Habitaciones disponibles: " + numRoomsAvailable.childNodes[0].nodeValue);
                numOfRoomsAvailableDiv.appendChild(textNode);
                
                let form = document.createElement("form");
                form.setAttribute("method", "POST");
                form.setAttribute("action", "reservation.jsp");
                
                let adultHiddenInput = document.createElement("input");
                adultHiddenInput.setAttribute("type", "hidden");
                adultHiddenInput.setAttribute("name", "adults");
                adultHiddenInput.setAttribute("value", numberOfAdults);
                
                let childrenHiddenInput = document.createElement("input");
                childrenHiddenInput.setAttribute("type", "hidden");
                childrenHiddenInput.setAttribute("name", "children");
                childrenHiddenInput.setAttribute("value", numberOfChildren);
                
                let entryDateInput = document.createElement("input");
                entryDateInput.setAttribute("type", "hidden");
                entryDateInput.setAttribute("name", "entryDate");
                entryDateInput.setAttribute("value", entryDate.value);
                
                let departureDateInput = document.createElement("input");
                departureDateInput.setAttribute("type", "hidden");
                departureDateInput.setAttribute("name", "departureDate");
                departureDateInput.setAttribute("value", departureDate.value);
                
                let idRoomHiddenInput = document.createElement("input");
                idRoomHiddenInput.setAttribute("type", "hidden");
                idRoomHiddenInput.setAttribute("name", "idRoom");
                idRoomHiddenInput.setAttribute("value", idRoom.childNodes[0].nodeValue);
                
                
                
                let bookingButton = document.createElement("button");
                bookingButton.setAttribute("class", "bookingButton");
                textNode = document.createTextNode("Reservar habitación ➤");
                bookingButton.appendChild(textNode);
                
                form.appendChild(bookingButton);
                form.appendChild(adultHiddenInput);
                form.appendChild(childrenHiddenInput);
                form.appendChild(entryDateInput);
                form.appendChild(departureDateInput);
                form.appendChild(idRoomHiddenInput);
                
                
                roomDiv.appendChild(image);
                roomDiv.appendChild(nameHotelDiv);
                roomDiv.appendChild(priceDiv);
                roomDiv.appendChild(typeRoomDiv);
                roomDiv.appendChild(numOfRoomsAvailableDiv);
                roomDiv.appendChild(form);
                
                listRooms.appendChild(roomDiv);
               
            }    
        }   
    });
}


function removeAllRooms() {
    let rooms = document.getElementsByClassName("room");
    for (var i = 0; i < rooms.length; i++) {
        rooms[i].parentNode.removeChild(rooms[i]);
    }
     
}



