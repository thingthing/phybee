$(function() {
    var $date = $("#datepicker").datepicker({
    	defaultDate: $("#date").val(),
    	dateFormat: "yy-mm-dd",
    	onSelect: function(date, obj){
    	        $('#date').val(date);  //Updates value of of your input 
    	    }
    });
  });