$(function() {
    //维权类型
    $('.typeInformation > span').click(function() {
        $(this).addClass('active').siblings().removeClass('active');
    });
    $('.add').click(function() {
        $('.typeTitle').css('display','block');
    });
    $('.cancel').click(function() {
        $('.typeTitle').css('display','none');
    });
    $('.determine').click(function() {
        const $activetxt = $('.typeInformation > span.active').text();
        $('.typeName').val($activetxt);
        $('.typeTitle').css('display','none');
    });
    $('.typeInformation > .custom').click(function() {
        $('.typeTitle').css('display','none');
        $('.typeName').focus();
    })
    //维权诉求
    $('.typeInformation1 > span').click(function() {
        $(this).addClass('active').siblings().removeClass('active');
    });
    $('.add1').click(function() {
        $('.typeTitle1').css('display','block');
    });
    $('.cancel1').click(function() {
        $('.typeTitle1').css('display','none');
    });
    $('.determine1').click(function() {
        const $activetxt1 = $('.typeInformation1 > span.active').text();
        $('.typeName1').val($activetxt1);
        $('.typeTitle1').css('display','none');
    });
    $('.typeInformation1 > .custom1').click(function() {
        $('.typeTitle1').css('display','none');
        $('.typeName1').focus();
    })
    
})