let requestAjax;
let isIE;

function sendRequest(request, callback) {
        
    requestAjax = initRequest();
    requestAjax.open(request.method, request.url, request.isAsynchronous);
        
    
    requestAjax.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
					if (typeof callback !== "undefined") {
                callback(requestAjax.responseXML);
					}
        }
    }
    requestAjax.send();
}

function initRequest() {
	if (window.XMLHttpRequest) {
		if (navigator.userAgent.indexOf('MSIE') != -1) {
			isIE = true;
		}
		return new XMLHttpRequest();

	} else if (window.ActiveXObject) {
		isIE = true;
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}










































