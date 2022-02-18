/*滑动验证启动js*/
$(function(){
	var SlideVerifyPlug = window.slideVerifyPlug;
	var slideVerify = new SlideVerifyPlug('#verify-wrap',{
		wrapWidth:'100%',//设置 容器的宽度 ,不设置的话，会设置成100%，需要自己在外层包层div,设置宽度，这是为了适应方便点；
		initText:'请向右滑动滑块',  //设置  初始的 显示文字
		sucessText:'验证通过',//设置 验证通过 显示的文字
		getSuccessState:function(res){
			//当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了
			console.log(res);
			if(slideVerify.slideFinishState){
				$('.value').html(slideVerify.slideFinishState)
				$('#resetBtn').removeClass('prohibit')
			}
		}
	});
	$("#resetBtn").on('click',function(){
		$('.value').html('false')
		$('#resetBtn').addClass('prohibit')
		slideVerify.resetVerify();//可以重置 插件 回到初始状态
	})
	$('#resetBtn').addClass('prohibit')
})