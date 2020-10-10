$(function() {
	$("#header").load("../header.html");
	$("#footer").load("../footer.html");
	
	$("#tabs").find("span").click(function(){
	  $(this).addClass("active").siblings().removeClass("active");
	  var value = $(this).attr("value-index")
	  $(".tab").hide()
	  $(".tab" +value).show()
	})
})