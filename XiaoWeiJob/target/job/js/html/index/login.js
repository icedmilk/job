$(function()
{

	$('#login_a').click(function()
	{
		$('#login').dialog("open");
	});

	$('#login').dialog(
	{
		autoOpen : false,
		title : "登录",
		buttons :
		{
			"Submit" : function()
			{
				$('#login').submit();
			},

			"Cancel" : function()
			{
				$(this).dialog('close');
			}
		},
		// show : "clip",
		hide : true,
		modal : true,
		width : "340px",
	// height : "1000px"
	}).buttonset().validate(
	{
		submitHandler : function(form)
		{
			$(form).ajaxSubmit(
			{
				url : 'servlet/LoginServlet',
				type : 'POST',
				beforeSubmit : function()
				{
					$('#login').dialog('widget').find('button')
							.eq(1).button('disable');
					// alert("b");
					$('#loading').dialog('open');
				},
				
				success : function(responseText)
				{

					if (responseText)
					{

						$('#login').dialog('widget').find(
								'button').eq(1)
								.button('enable');
						$('#loading').addClass('success').html(
								'Success');

						
						$('#loading').dialog('close');
						$('#login').dialog('close');
						$('#login').resetForm();
						$('#login span.star').html('*')
								.removeClass('succ');
						
						location.href ="company.html";
							
					}
				}

			});
		},
		// debug: true,
		errorLabelContainer : 'ol.login_error',
		wrapper : 'li',

		rules :
		{
			sno_login :
			{
				required : true,
				minlength : 5
			},
			password_login :
			{
				required : true,
				minlength : 5,
				remote :
				{
					url : 'servlet/LoginServlet',
					type : 'POST',
					data :
					{
						name_login : $('#name_login').val()
					}
				/*
				 * , success: function(){ alert("succ"); }
				 */
				}
			}
		},

		messages :
		{
			password_login :
			{
				remote : '企业名/密码不正确'
			}
		},

		highlight : function(element, errorClass)
		{
			$(element).css("border", "2px solid #ff2400");
			$(element).parent().find('span').removeClass('succ');
		},

		unhighlight : function(element, errorClass)
		{
			$(element).css("border", "1px solid #ccc");
			//$(element).parent().find('span').html('√').css('color', 'green');
			$(element).parent().find('span').addClass('succ').html("");
		}

	});
});