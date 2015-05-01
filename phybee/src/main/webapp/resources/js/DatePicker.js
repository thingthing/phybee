$(function() {
    var $date = $("#datepicker").datepicker({
    	  defaultDate: $("#date").val(),
    	  onSelect: function(date, obj){
    	        $('#date').val(date);  //Updates value of of your input 
    	    }
    });
    //$("#datepicker").show().focus().hide();
    $date.datepicker( "show" );
  });