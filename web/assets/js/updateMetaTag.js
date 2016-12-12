
function updateMetaTag(obj) {
	let page = obj.parentElement.parentElement.getAttribute("page");
	let headerField = obj.getAttribute("name");
	let valueField = obj.value;

	let request = {
		method: "GET",
		url: "UpdateMetaTag?namepage="+page+"&meta="+headerField+"&value="+valueField+"",
		isAsynchronous: true
	}

	console.log(request.url);

	sendRequest(request, function(response) {
	
	});

}
























