$(function()
{
	$('#loading').dialog(
	{
		autoOpen: false,
		modal: true,
		height: 50,
		width: 100
	}).parent().parent().find('.ui-widget-header').hide();
	
});