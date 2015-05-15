$(function(){
	$('#recruitment').click(function(){
		$.ajax({
			url: 'servlet/SelectJobByCid',
			type: 'POST',
			success: function(resp) {
				$('header').html(resp);
				$('.display').dataTable();
				
				// 查看投递操作
				$('td a[id]').each(function(index, element){
					var id = $(element).attr('id');
					$('<div class="jqmWindow" id="ajax-dialog' + id + 
					'"><a href="#" class="jqmClose">Close</a><hr/><div class="ajax-content"></div></div>').appendTo('#dialogs');
					
					$('#ajax-dialog'+id).jqm({
						trigger: 'a#' + id,
						ajax: 'servlet/ShowDelivery?jid=' + id,
						targer: 'div.ajax-content',
						closeOnEsc: true,

					});
				});
				
				// 删除操作
				$('button').each(function(index, element){
					$(element).click(function(){
						$.ajax({
							url: 'servlet/DeleteJob',
							data: {
								jid: $(element).attr('id')
							},
							type: 'POST',
							success: function(){
								$(element).parent().parent().remove();
							}
						})
					});
				});
			}
		});
	
	});
	$('#recruitment').click();
	
});