function changeActiveClass(obj) {
	let rooms = document.getElementsByClassName("room");
	obj.classList.toggle("active");

	for (let i = 0; i < rooms.length; i++) {
		if(rooms[i].getAttribute("typeRoom") == obj.innerHTML) {
			rooms[i].classList.toggle("visible");
		}
	}
}
