$(function() {
	var dateSplit = $("#date").val().split("-");
	var $date = $("#datepicker").datepicker({
		dateFormat : "yyyy-mm-dd",
		todayHighlight : true
	}).on("changeDate", function(event) {
		console.log("date event is == ", event.date.toLocaleDateString())
		var stringDate = event.date.getFullYear() + "-" + (event.date.getMonth() + 1) + "-" + event.date.getDate();
		$('#date').val(stringDate); // Updates value of of your input
	});
	$date.datepicker("update", new Date(dateSplit[0], dateSplit[1] - 1, dateSplit[2]));
});