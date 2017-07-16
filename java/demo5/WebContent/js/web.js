$(window).load(function(){
	
	//주메뉴
	$('.gnb>ul>li>a').click(function(){
		console.log("ddd")
		$('.sub_layer').stop().slideDown(400);
		return false;
	});

	$('.sub_layer').mouseleave(function(){
		$('.sub_layer').stop().slideUp(400);
	});


			
});/*끝*/