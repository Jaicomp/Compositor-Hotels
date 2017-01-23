$(document).ready(function() {
	$("header ul li").click(function(event){
		if ($(this).attr('class') !== 'active') {
			$("header ul li").removeClass('active');
			$(this).attr('class', 'active');
		}
	});
});
