$(function(){
$('#reg').dialog(
	{
		autoOpen: false,
		title: "注册",
		buttons:
		{
			"Submit": function()
			{
				$('#reg').submit();
			},

			"Cancel": function()
			{
				$(this).dialog('close');
			}
		},
		//show : "clip",
		hide: true,
		modal: true,
		width: "350px",
		//height : "1000px"
	}).buttonset()
		.validate(
		{
			submitHandler: function(form)
			{
				$(this).ajaxSubmit(
				{
					type: 'POST',
					url: 'servlet/RegisterServlet',
					data: {
						cname: $('#name').val(),
						cpassword: $('#password').val(),
						cemail: $('#email').val(),
						cscale: $('input[name=scale]:checked').val(),
						ctype: $('input[name=type]:checked').val(),
						cindustry: $('#industry').val(),
						cdescription: $('#description').val()
					},
					beforeSubmit: function()
					{
						//alert("a");
						$('#reg').dialog('widget').find('button').eq(1).button('disable');

						$('#loading').dialog('open');
					},
					success: function(responseText)
					{
						//alert(responseText);
						
						if (responseText == 'true')
						{
							$('#reg').dialog('widget').find('button').eq(1).button('enable');
							
							$('#loading').addClass('success').html('Success');

							setTimeout(function()
							{
								$('#loading').dialog('close');
								$('#reg').dialog('close');
								$('#reg').resetForm();
								$('#reg span.star').html('*').removeClass('succ');
								//alert($('#name').val());
								$.cookie('user', $('#sno').val());
								
								$('#exit_a, #name_a').show();
								$('#name_a').find('a').html($.cookie('user'));
								$('#login_a, #reg_a').hide();

							}, 1000);
						}
						else
						{
							alert('已被注册');
						}
					}

				});
			},
			//debug: true,
			errorLabelContainer: 'ol.reg_error',
			wrapper: 'li',

			rules:
			{
				//TODO validate
				cname:
				{
					required: true,
					remote:
					{
						url: 'servlet/RegisterServlet',
						type: 'POST'
					}
				},
				name:
				{
					required: true,
					minlength: 2
				},
				password:
				{
					required: true,
					minlength: 5
				},
				confirm:
				{
					required: true,
					minlength: 5
				},
//				birth:
//				{
//					required: true,
//				},
				cemail:
				{
					required: true,
					email: true
				}
			},
			messages:
			{
				cname:
				{
					remote: '该公司已被注册'
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


	$('#reg_a').click(function()
	{
		$('#reg').dialog("open");
	});

	$('#birth').datepicker(
	{
		changeYear: true,
		changeMonth: true,
		dateFormat: "yy-mm-dd",
		showButtonPanel: true,
		maxDate: 0,

		yearRange: "1914:2014",
		hideIfNoPrevNext: true,

		defaultDate: "1990-1-1"
	}); //日历

	$('#reg input[title]').tooltip(
	{
		position:
		{
			my: "left+5px center",
			at: "right center"
		},
		show: false,
		hide: false
	}); //提示标签位置


	$('#email').autocomplete(
	{
		source: function(request, response)
		{
			var hosts = ["qq.com", "163.com", "gmail.com", "sina.com.cn", "hotmail.com"];
			var term = request.term; //用户填写的内容
			var name = term; //name部分
			var host = ""; //host部分
			var ix = term.indexOf("@"); //@的位置
			var result = [];

			result.push(term);

			if (ix > -1)
			{
				name = term.slice(0, ix);
				host = term.slice(ix + 1);
			}

			if (name)
			{
				var findedHosts = [];

				if (host)
				{
					findedHosts = $.grep(hosts, function(value, index)
					{
						return value.indexOf(host) > -1;
					});
				}
				else
				{
					findedHosts = hosts;
				}
				var findedResult = $.map(findedHosts, function(value, index)
				{
					return name + "@" + value;
				});
			}

			var finalResult = result.concat(findedResult);

			response(finalResult);
		},
		delay: 0,
		autoFocus: true,
	}); //自动补全
});