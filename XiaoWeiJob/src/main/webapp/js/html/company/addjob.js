$(function(){
	$('#addjobform').dialog({
		width : "360px",
		modal : true,
		autoOpen : false,
		buttons:
		{
			"Submit": function()
			{
				$('#addjobform').submit();
			},

			"Cancel": function()
			{
				$(this).dialog('close');
			}
		},
	}).buttonset().validate(
	{
		submitHandler: function(form)
		{
			$(this).ajaxSubmit(
			{
				type: 'POST',
				url: 'servlet/addJobServlet',
				data: {
					jname: $('#jname').val(),
					jtype: $('#jtype').val(),
					jlocation: $('#jlocation').val(),
					jdegree: $('#jdegree').val(),
					jsalary: $('#jsalary').val(),
					jexperience: $('#jexperience').val(),
					jdescription: $('#jdescription').val()
				},
				beforeSubmit: function()
				{
					//alert("a");
					$('#addjobform').dialog('widget').find('button').eq(1).button('disable');

					$('#loading').dialog('open');
				},
				success: function(responseText)
				{
					if(responseText == 'login') {
						alert('请先登录');
						location.href = 'index.html';
					}
					else {
						$('#addjobform').dialog('widget').find('button').eq(1).button('enable');
						
						setTimeout(function()
						{
							$('#addjobform').dialog('close');
							location.reload();
						}, 500);
					}
				}

			});
		},
		//debug: true,
		errorLabelContainer: 'ol.addcourse_error',
		wrapper: 'li',

		rules:
		{
			cname:
			{
				required: true,
				minlength: 2
			},
			ctype:
			{
				required: true,
				minlength: 1
			},
			lim:
			{
				required: true,
				
			}
		},

		highlight: function(element, errorClass)
		{
			$(element).css("border", "2px solid #ff2400");
			$(element).parent().find('span').removeClass('succ');
		},

		unhighlight: function(element, errorClass)
		{
			$(element).css("border", "1px solid #ccc");
			//$(element).parent().find('span').html('√').css('color', 'green');
			$(element).parent().find('span').addClass('succ').html("");
		}

	});
});