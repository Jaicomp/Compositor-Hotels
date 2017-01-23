var modals = document.getElementsByClassName('myModal');

var buttonsOpenModal = document.getElementsByClassName("openModal");

var closeModal = document.getElementsByClassName("close");

for (let i = 0; i < buttonsOpenModal.length; i++) {
	console.log(i);
	buttonsOpenModal[i].onclick = function() {
			console.log("MMM");
	    modals[i].style.display = "block";
			closeModal[i].style.display = "block";
			closeModal[i].onclick = function() {
				closeModal[i].style.display = "none";
				modals[i].style.display = "none";
			}
	}
}

window.onclick = function(event) {
	for (let i = 0; i < modals.length; i++) {
		if (event.target == modals[i]) {
  		modals[i].style.display = "none";
		}
	}
}

