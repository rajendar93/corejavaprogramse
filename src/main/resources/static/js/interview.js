$(document).ready(function() {
	console.log("ready!");
	$('#p1win').hide();
	$('#p2win').hide();
	$('#p3win').hide();
	$('#p4win').hide();
	$('#p5win').hide();
});

function genHeader(source) {
	var srcText = source.value;
	var targetId = source.id + "_head";
	$('#' + targetId).text('Technical interview by ' + srcText + ':');
}

function newProfile(note) {
	$('#searchForm').submit(function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();

		$('#p1win').show();
		$('#p2win').show();
		$('#p3win').show();
		$('#p4win').show();
		$('#p5win').show();
	});
}
function populate(note) {
	$('#searchForm').submit(function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();

		$('#p1win').show();
		$('#p2win').show();
		$('#p3win').show();
		$('#p4win').show();
		$('#p5win').show();
	});

	var search_box = $('#search_box').val();
	var str_array = search_box.split('-');
	var int_id = -1;
	for (var i = 0; i < str_array.length; i++) {
		// Trim the excess whitespace.
		str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
		// Add additional code here, such as:		
		if (str_array[i].startsWith("Interview Id :")) {
			var sub_str_array = str_array[i].split(':')[1];
			int_id = parseInt(sub_str_array);
			$('#interviewId').val(sub_str_array.trim());
			break;
		}
	}
	console.log('Processed Interview Id : ' + int_id);
	$.ajax({
		url: "/api/interviewdetails/" + int_id,
		type: "GET",
		async: true, // set to false if you don't mind the page pausing while waiting for response
		cache: false,
		contentType: "application/json; charset=utf-8",
		success: function(data, textStatus, xhr) {
			console.log("server response data is---" + JSON.stringify(data));
			var res = null;
			for (let x in data) {
				console.log(x + ": " + data[x])
				res = JSON.parse(JSON.stringify(data[x]));
				break;
			}
			//console.log(data["hireId"]);
			$('#iHireId').val(res.hireId);
			$('#iHireName').val(res.hireName);
			var comment = res.comment;
			str_array = comment.split(',');
			for (var i = 0; i < str_array.length; i++) {
				// Trim the excess whitespace.
				str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
				// Add additional code here, such as:		
				if (str_array[i].startsWith("Interview Scheduled Date(mm/dd/yyyy) :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$('#int_sch_date').val(sub_str_array.trim());
				}
				if (str_array[i].startsWith("Interview Position :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#positions").val(sub_str_array.trim()).attr("selected", "selected");
				}
				if (str_array[i].startsWith("Hiring Manager :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#hm").val(sub_str_array.trim());
				}
				if (str_array[i].startsWith("Approved By :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#approvedBy").val(sub_str_array.trim());
				}
				if (str_array[i].startsWith("Technology :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#tech").val(sub_str_array.trim());
				}
				if (str_array[i].startsWith("Technology :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#tech").val(sub_str_array.trim());
				}
				if (str_array[i].startsWith("Profile Source Acquired :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#ps").val(sub_str_array.trim()).attr("selected", "selected");
				}
				if (str_array[i].startsWith("HiringType :")) {
					var sub_str_array = str_array[i].split(':')[1];
					$("#ie").val(sub_str_array.trim()).attr("selected", "selected");
				}
				if (str_array[i].startsWith("Salary Negotiation Details :")) {
					var sub_str_array = str_array[i].split(':')[1];
					sub_str_array = sub_str_array.replaceAll('&comma;', ',');
					$("textarea#snd").val(sub_str_array);
				}
				if (str_array[i].startsWith("Hiring Objective Purpose :")) {
					var sub_str_array = str_array[i].split(':')[1];
					sub_str_array = sub_str_array.replaceAll('&comma;', ',');
					$("textarea#hop").val(sub_str_array);
				}
			}
			getSalaryDetails(res.id, note);

		},
		error: function(data, textStatus, xhr) {
			document.getElementById(note).innerHTML += "Error:" + JSON.stringify(data);
		}
	});
	document.getElementById('search_box').value = '';
	return false;
}

function getSalaryDetails(id, note) {
	$.ajax({
		url: "/api/salNegDetailsIntId/" + id,
		type: "GET",
		async: true, // set to false if you don't mind the page pausing while waiting for response
		cache: false,
		contentType: "application/json; charset=utf-8",
		success: function(data, textStatus, xhr) {
			console.log("server response data is---" + JSON.stringify(data));
			var res = JSON.parse(JSON.stringify(data));
			/*
			for (let x in data) {
				console.log(x + ": " + data[x]);				
				
			}*/
			console.log(res);
			$('#budget').val(res.budget);
			$('#neg_ctc').val(res.negotiated);
			$('#off_ctc').val(res.offeredCTC);
			$('#pub1').hide();
			getInterviewDetails(id, note);

		},
		error: function(data, textStatus, xhr) {
			document.getElementById(note).innerHTML += "Error:" + JSON.stringify(data);
		}
	});
}

function getInterviewDetails(id, note) {
	$.ajax({
		url: "/api/getHiresInfoByToken/" + id,
		type: "GET",
		async: true, // set to false if you don't mind the page pausing while waiting for response
		cache: false,
		contentType: "application/json; charset=utf-8",
		success: function(data, textStatus, xhr) {
			console.log("server response data is---" + JSON.stringify(data));
			var res = null;
			for (let x in data) {
				console.log(x + ": " + data[x])
				res = JSON.parse(JSON.stringify(data[x]));
				console.log(res);
				if (res.roleDescription === 'Tech-Interview-1') {
					$('#tech1_int').val(res.interviewer);
					var feed = res.comment;
					feed = feed.replaceAll('&comma;', ',');
					$('#t1feed').text(feed);
					var rating = res.rating;
					$('#t1' + rating).attr('checked', true);
					$('#t1-status').val(res.status);
					$('#pub2').hide();
				}
				if (res.roleDescription === 'Tech-Interview-2') {
					$('#tech2_int').val(res.interviewer);
					var feed = res.comment;
					feed = feed.replaceAll('&comma;', ',');
					$('#t2feed').text(feed);
					var rating = res.rating;
					$('#t2' + rating).attr('checked', true);
					$('#t2-status').val(res.status);
					$('#pub3').hide();
				}
				if (res.roleDescription === 'Man-Interview') {
					$('#man_int').val(res.interviewer);
					var feed = res.comment;
					feed = feed.replaceAll('&comma;', ',');
					$('#manfeed').text(feed);
					var rating = res.rating;
					$('#man' + rating).attr('checked', true);
					$('#man-status').val(res.status);
					$('#pub4').hide();
				}
				if (res.roleDescription === 'hr-Interview') {
					$('#hr_int').val(res.interviewer);
					var feed = res.comment;
					feed = feed.replaceAll('&comma;', ',');
					$('#hrfeed').text(feed);
					var rating = res.rating;
					$('#hr' + rating).attr('checked', true);
					$('#hr-status').val(res.status);
					$('#pub5').hide();
				}

			}

		},
		error: function(data, textStatus, xhr) {
			document.getElementById(note).innerHTML += "Error:" + JSON.stringify(data);
		}
	});
}

function phaseOne(note) {
	$('#interviewform').submit(function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();
		//generate comment
		var hiringType = $('#ie :selected').text();
		var hm = $('#hm').val();
		var approvedBy = $('#approvedBy').val();
		var position = $('#positions :selected').text();
		var tech = $('#tech').val();
		var profileSource = $('#ps :selected').text();
		var int_sch_date = $('#int_sch_date').val();

		var snd = $('#snd').val();
		snd = snd.replaceAll(',', '&comma;');
		var hop = $('#hop').val();
		hop = hop.replaceAll(',', '&comma;');

		var comment = "";
		comment += "HiringType : " + hiringType + ",";
		comment += "Interview Scheduled Date(mm/dd/yyyy) : " + int_sch_date + ",";
		comment += "Interview Position : " + position + ",";
		comment += "Technology : " + tech + ",";
		comment += "Hiring Objective Purpose : " + hop + ",";
		comment += "Salary Negotiation Details : " + snd + ",";
		comment += "Hiring Manager : " + hm + ",";
		comment += "Approved By : " + approvedBy + ",";
		comment += "Profile Source Acquired : " + profileSource;

		document.getElementById('comment').value = comment;

		var iHireId = $('#iHireId').val();
		var budget = $('#budget').val();
		var neg_ctc = $('#neg_ctc').val();
		var off_ctc = $('#off_ctc').val();

		var jsdata = null;

		document.getElementById(note).innerHTML = "";
		var formdata = $('#interviewform').serializeArray();
		console.log('formdata---' + JSON.stringify(formdata));
		var jsonData = { "data": formdata };
		$.ajax({
			url: "api/interviewDetails",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(jsonData),
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function(data) {
				var len = data.length;
				console.log("server response data is---" + JSON.stringify(data));
				//console.log("data length is---" + len);
				var res = JSON.parse(JSON.stringify(data));
				//console.log("data city is---" + res.cityCode);
				var tmp = "" + res.hireId;
				//console.log(tmp);
				if (tmp.length > 0) {
					//document.getElementById("interviewform").reset();
					document.getElementById(note).innerHTML += 'Successfully Published Data<br/>';
					jsdata = JSON.stringify(
						{
							"hireId": iHireId,
							"budget": budget,
							"negotiated": neg_ctc,
							"offeredCTC": off_ctc,
							"token": res.id,
						}
					);

					publishSalaryNegotiationDetails(jsdata, note);

				}
			}, error: function(e) {
				document.getElementById(note).innerHTML += 'Error Publishing Data<br/>';
			}
		});

		return false;
	});


}

function publishSalaryNegotiationDetails(jsdata, note) {
	// step 2
	console.log(jsdata);

	$.ajax({
		url: "/api/pubSalNegDetails/",
		type: "POST",
		async: true, // set to false if you don't mind the page pausing while waiting for response
		cache: false,
		dataType: "json",
		data: jsdata,
		contentType: "application/json; charset=utf-8",
		success: function(data, textStatus, xhr) {
			console.log("server response data is---" + JSON.stringify(data));
			//console.log("data length is---" + len);
			var res = JSON.parse(JSON.stringify(data));
			var tmp = "" + res.hireId;

			if (tmp.length > 0) {
				document.getElementById(note).innerHTML += 'Successfully Published Salary Negotiation Details<br/>';
			}
		},
		error: function(data, textStatus, xhr) {
			document.getElementById(note).innerHTML += "Error:" + JSON.stringify(data);
		}
	});
}

function phaseTwo(formId, intv, feed, rating, status, int_role, note) {
	$('#' + formId).submit(function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();
		//generate content
		var int_id = $('#interviewId').val();
		var hireId = $('#iHireId').val();
		if (hireId !== "") {
		} else {
			document.getElementById(note).innerHTML += 'Get Hiring ID First<br/>';
			return;
		}

		var feedback = $('#' + feed).val();
		feedback = feedback.replaceAll(',', '&comma;');
		var ratingScore = $('input[name=' + rating + ']:checked', '#' + formId).val();
		var interviewer = $('#' + intv).val();
		var statusTemp = $('#' + status).val();
		console.log(status);
		jsdata = JSON.stringify(
			{
				"comment": feedback,
				"hireId": hireId,
				"interviewer": interviewer,
				"publishedDate": '',
				"rating": ratingScore,
				"roleDescription": int_role,
				"status": statusTemp,
				"token": int_id,
			}
		);

		console.log(jsdata);

		document.getElementById(note).innerHTML = "";
		$.ajax({
			url: "api/publishHireeDetails",
			type: "post",
			contentType: "application/json",
			data: jsdata,
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function(data) {
				var len = data.length;
				console.log("server response data is---" + JSON.stringify(data));
				//console.log("data length is---" + len);
				var res = JSON.parse(JSON.stringify(data));
				//console.log("data city is---" + res.cityCode);
				var tmp = "" + res.hireId;
				//console.log(tmp);
				if (tmp.length > 0) {
					//document.getElementById("interviewform").reset();
					document.getElementById(note).innerHTML += 'Successfully Published Data<br/>';
				}
			}, error: function(e) {
				document.getElementById(note).innerHTML += 'Error Publishing Data<br/>';
			}
		});
		return false;
	});


}

