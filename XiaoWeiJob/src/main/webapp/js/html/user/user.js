$(function() {
//	$.ajax({
//		url: 'servlet/CompanyInfo',
//		data: {
//			cname: '阿里巴巴集团'
//		},
//		type: 'POST',
//		success: function(resp) {
//			alert(resp);
//		}
//	});
	$('#loading').dialog(
			{
				autoOpen: false,
				modal: true,
				height: 50,
				width: 100
			});
	// 查找现有工作
	$.ajax({
		url: "servlet/SelectAll",
		type: "GET",
		success: function(resp) {
			$('header').html(resp);
			$('.display').dataTable();
			
			//查看公司信息
			$('.trigger').each(function(index, element){
				
				$('<div class="jqmWindow" id="ajax-dialog' + index + 
						'"><a href="#" class="jqmClose">Close</a><hr/><div class="ajax-content"></div></div>').appendTo('#dialogs');
				
				var ajaxAddress = "servlet/CompanyInfo?id=" + $(element).attr('cid');
				$(element).attr('id', 'trigger' + index);
				$('#ajax-dialog'+index).jqm({
					trigger: 'a#trigger' + index,
					ajax: ajaxAddress,
					closeOnEsc: true
				});
			});
			
			$('input[type=file]').each(function(index, element){
				var jobid = $(element).attr('name');
				
				$('input[name=' + jobid + ']').change(function(){
					
					$('#' + jobid).ajaxSubmit({
						data : {
							jobId : jobid,
							jobName: $(element).parent().parent().parent().children('td').eq(1).text()
						},
						success: function() {
							$('#' + jobid).replaceWith('<strong>投递成功</strong>');
						},
						beforeSubmit: function() {
							$('#' + jobid).replaceWith('<strong id = ' + jobid + '>投递中...</strong>');
						}
						
					});
				});
				
			});
			
		}
	});
});