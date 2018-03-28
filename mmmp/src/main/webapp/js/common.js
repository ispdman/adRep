// ajax 호출
function ajaxSubmit(url, async, callback,param) {
	jQuery.ajax({
		type	: 'post',
		async	: async,
		url		: url,
		data	: {chartNm:param},//$("#ajaxChratParam").serialize(),
		success	: function(data) {
			callback(data);
		},
		error: function(data, status, err) {
			alert('서버와의 통신 중 오류가 발생했습니다.\n잠시 후 다시 시도해주세요.');
		}
	});
}

function fnLoadingStartProgress(){
	$('#viewLoading').show();
	// 로딩이미지의 위치 및 크기조절	
	$('#viewLoading').css('position', 'absolute');
	$('#viewLoading').css('left', $('#loadData'));
	$('#viewLoading').css('top', $('#loadData'));
	$('#viewLoading').css('width', $('#loadData').css('width'));
	$('#viewLoading').css('height', $('#loadData').css('height'));
	$('#viewLoading').fadeIn(500);
}
function fnLoadingStopProgress(){
	$('#viewLoading').show();
	// 로딩이미지의 위치 및 크기조절	
	$('#viewLoading').css('position', 'absolute');
	$('#viewLoading').css('left', $('#loadData'));
	$('#viewLoading').css('top', $('#loadData'));
	$('#viewLoading').css('width', $('#loadData').css('width'));
	$('#viewLoading').css('height', $('#loadData').css('height'));

	$(this).fadeIn(500);
	$('#viewLoading').fadeOut(500);
}

$(document).ready(function(){
	$("#depth1_li").addClass("on");
	//$("#li01").addClass("on");
	$(".depth2").css("display","block");
	$(".left_menu .depth1>li").click(function(){
		$(this).addClass("on");
		$(this).find(".depth2").css("display","block");
	}); //left메뉴 열고 닫기

	$(".depth2 li").click(function(){
			$(".depth2 li").removeClass("on");
			$(this).addClass("on");
	});
	$("#"+$("#depth2").val()).addClass("on");
    // 팝업
	$("button#popup").click(function(){
		$(".popup_layer").css("display","block");
	});
	$("button#close").click(function(){
		$(".popup_layer").css("display","none");
	});
	$("button#close2").click(function(){
		$(".popup_layer2").css("display","none");
	});
	
    fnLoadingStopProgress();

	// ajax 실행 및 완료시 'Loading 이미지'의 동작을 컨트롤하자.
	$('#viewLoading')
	.ajaxStart(function()
	{
		fnLoadingStartProgress();
	})
	.ajaxStop(function()
	{
		fnLoadingStopProgress();
	});

});


