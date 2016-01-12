function showTips(tips, height, time) {
	var windowWidth = document.documentElement.clientWidth;
	var tipsDiv = '<div class="tipsClass">' + tips + '</div>';

	$('body').append(tipsDiv);
	$('div.tipsClass').css({
		'top' : height + 'px',
		'left' : (windowWidth / 2) - (tips.length * 21 / 2) + 'px',
		'position' : 'absolute',
		'padding' : '12px 18px',
		'border-radius': '5px',
		'background' : '#fafafa',
		'font-size' : 20 + 'px',
		'margin' : '0 auto',
		'text-align' : 'center',
		'width' : 'auto',
		'color' : '#c0392b',
		'opacity' : '0.8'
	}).show();
	setTimeout(function() {
		$('div.tipsClass').fadeOut();
	}, (time * 1000));
}