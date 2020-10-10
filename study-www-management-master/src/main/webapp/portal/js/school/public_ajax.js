
       function getAjax(type,url,callback){
        //全局变量接收数据
        var xmlhttp;
        //兼容处理
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
        //创建对象
        xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //向服务端发送请求(请求类型,请求的URL,异步/同步)
        xmlhttp.open(type,url,true);
        //向服务器发送请求
        xmlhttp.send();
    //响应事件
    xmlhttp.onreadystatechange=function(){
        //响应状态
        if(xmlhttp.readyState==4 && xmlhttp.status==200){
            //响应数据，并转换成object
            var data1=xmlhttp.responseText;
            callback(data1)
        }
    }
}