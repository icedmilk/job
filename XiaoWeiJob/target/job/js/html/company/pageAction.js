$(function()
{
	$('#charts').click(function(){
		$.ajax({
			url: 'pivot.html',
			success: function(resp){
				$('header').children().remove();
				$('header').append('<iframe src="pivot.html" frameborder="0" scrolling="no" width="100%" height="700"></iframe>');
				
			}
		});
		$('body').click();
	});
	
	$.ajax({
		url: 'servlet/GetCompanyName',
		type: 'POST',
		success: function(resp) {
			$('#name_a span').text('您好，' + resp);
		}
	});
	
	$('#addjobs').click(function(){
		
		$('#addjobform').dialog('open');
		$('body').click();
	});
	
	$('#recruitment').click(function(){
		$('body').click();
	})
	
});