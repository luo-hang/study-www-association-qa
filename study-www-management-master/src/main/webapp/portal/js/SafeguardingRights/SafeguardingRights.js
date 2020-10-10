$(function() {
    $('.navBox').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        const index = $(this).index();
        $('.titleBox').eq(index).addClass('active1').siblings().removeClass('active1');
    }) 
})