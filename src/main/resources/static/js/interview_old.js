$(document).ready(function() {
$('#interviewform').submit(function(e) {
	//alert("hello");
	e.preventDefault();
	e.stopImmediatePropagation();
	
	var formdata=$('#interviewform').serializeArray();
	console.log('formdata---'+JSON.stringify(formdata));
	var jsonData = {"data": formdata};
	$.ajax({
			url: "interviewDetails",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(jsonData),
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function(data) {
				var len = data.length;
				console.log("data is---" + JSON.stringify(data));
				console.log("data length is---" + len);
				var res = JSON.parse(JSON.stringify(data)); 
				setTimeout(function () {
			        toastr.options = {
			          timeOut: 2000,
			          progressBar: true,
			          showMethod: "slideDown",
			          hideMethod: "slideUp",
			          showDuration: 200,
			          hideDuration: 200,
			          positionClass: "toast-top-center",
					  onHidden: function() {
	     		  	    window.location.reload();
	                  }
			        };
			        if(res.modifiedBy=="Error"){
							toastr.error('Error while adding');
						}else if(res.modifiedBy=="Updated"){
							toastr.success('Updated Successfully.');
						}else{
							toastr.success('Added Successfully.');
						}
			        $('.theme-switcher').removeClass('open');
			      }, 500);

			}, error: function(e) {
				setTimeout(function () {
			        toastr.options = {
			          timeOut: 2000,
			          progressBar: true,
			          showMethod: "slideDown",
			          hideMethod: "slideUp",
			          showDuration: 200,
			          hideDuration: 200,
			          positionClass: "toast-top-center"

			        };
					console.log(e);
					toastr.error('Error while adding Currency');
					
			        $('.theme-switcher').removeClass('open');
			      }, 500);
			}
		});
	
	return false;
});
	
});