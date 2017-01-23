let largeViewRoom = document.getElementById("largeViewRoom");
let shortViewRoom = document.getElementById("shortViewRoom");
let typeRooms = document.getElementsByClassName("typeRoom");
let prices = document.getElementsByClassName("price");
let numRoomsAvailable = document.getElementsByClassName("numberOfRoomsAvailable");
let bookingButtons = document.getElementsByClassName("bookingButton");

let rooms = document.getElementsByClassName("room");


function changeActiveClass(obj) {
	let rooms = document.getElementsByClassName("room");
	obj.classList.toggle("active");

	for (let i = 0; i < rooms.length; i++) {
		if(rooms[i].getAttribute("typeRoom") == obj.innerHTML) {
			rooms[i].classList.toggle("visible");
		}
	}
}

shortViewRoom.onclick = function() {
	for (let i = 0; i < rooms.length; i++) {
		rooms[i].style.float = "left";
		rooms[i].style.width = "45%";
		rooms[i].style.marginRight = "10px";
		typeRooms[i].style.top = "50px";
		numRoomsAvailable[i].style.top = "70px";
		prices[i].style.top = "120px";
		prices[i].style.left = "225px";
		bookingButtons[i].style.top = "170px";
		bookingButtons[i].style.left = "225px";
	}

}

largeViewRoom.onclick = function() {
	for (let i = 0; i < rooms.length; i++) {
		rooms[i].style.float = "none";
		rooms[i].style.width = "100%";
		rooms[i].style.marginRight = "0";
		typeRooms[i].style.top = "120px";
		numRoomsAvailable[i].style.top = "160px";
		prices[i].style.top = "130px";
		prices[i].style.left = "980px";
		bookingButtons[i].style.top = "170px";
		bookingButtons[i].style.left = "980px";
	}

}
