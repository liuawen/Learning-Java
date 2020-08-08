function fadeShow(idObjSrc,idShowDivContainer,hotArea){
    this.strTimeOut = "";
    this.bleIsShow = false;
    this.idObjSrc = "";

    if(typeof(idObjSrc) == "object"){
        this.idObjSrc = idObjSrc;
    } else if(typeof(idObjSrc) == "string"){
        this.idObjSrc = "#" + idObjSrc;
    }

    this.hotArea = hotArea || this.idObjSrc;

    this.idShowDivContainer = "";
    if(typeof(idShowDivContainer) == "object"){
        this.idShowDivContainer = idShowDivContainer;
    } else if(typeof(idShowDivContainer) == "string"){
        this.idShowDivContainer = "#" + idShowDivContainer;
    }
    this.init();
}

fadeShow.prototype.init = function(){
    var thisObj =  this;
    var widthTemp = $(this.idShowDivContainer).outerWidth();
    var objTop = $(this.idObjSrc).offset().top;
    var objLeft = $(this.idObjSrc).offset().left;
    var objWidth = $(this.idObjSrc).width();
    var objHeight = $(this.idObjSrc).height();
    var leftTemp = parseInt(objLeft)+parseInt(objWidth)-parseInt(widthTemp);
    var topTemp = parseInt(objTop)+parseInt(objHeight);
    $(this.idShowDivContainer).css({position:"absolute",top:topTemp + "px",left:leftTemp+"px"}).mouseout(function(e){
        thisObj.hide(e);
    });
    $(this.hotArea).mouseout(function(e){
        thisObj.hide(e);
    });
}

fadeShow.prototype.hide = function(evt){
    evt = (evt)?evt:window.event;
    var toElementObj;
    if($.browser.msie){
        toElementObj = evt.toElement;
    } else if($.browser.mozilla){
        toElementObj = evt.relatedTarget;
    } else {
        toElementObj = evt.relatedTarget;
    }
    var thisObj = this;
    if ($(this.idShowDivContainer)[0].contains(toElementObj) || $(this.hotArea)[0].contains(toElementObj)) {
        this.bleIsShow = false;
    } else {
        this.bleIsShow = true;
        if(this.strTimeOut == ""){
            this.strTimeOut = setTimeout(function(){thisObj.doHide()},1000);
        }
    }
}

fadeShow.prototype.doHide = function(){
    if(this.strTimeOut != ""){
        clearInterval(this.strTimeOut);
        this.strTimeOut = "";
    }
    if(!this.bleIsShow){
        return ;
    }
    $(this.idShowDivContainer).fadeOut("slow");
}

fadeShow.prototype.show = function(){
    $(this.idShowDivContainer).fadeIn("slow");
}

var objLoginDiv = "";

var objAreaDiv = "";


function showLoginDiv(obj){
    var lang = $("#top_login_language").val();
    if(lang == "en"){
        var language = "EN";
    }else{
        var language = "CN";
    }
    var callback = function(){
        if(window.location.host == 'bbs.51job.com'){//bbs 登录后刷新页面
            window.location.href=window.location.href;
        }
    };
    ShowPassportLayer(language,callback);
}

var myDomainMy = "";
function loginInSpeacial(para){
    myDomainMy = para.domain_my;
    myDomainMySSL = para.domain_my_ssl;
    var sucess = para.sucess;
    if(typeof sucess == "function"){
        $("#top_login_form").unbind("submit");
        $("#loginDiv").unbind("");
        $("#top_login_form")[0].onsubmit = "";
        $("#top_login_form").submit(function(){
            return loginIn(myDomainMy,myDomainMySSL,sucess);
        });
    }
}

function showAreaDiv(obj,thisObj){
    if(objAreaDiv == ""){
        objAreaDiv = new fadeShow(obj,"all-channel",thisObj);
    }
    objAreaDiv.show();
}

function hideLoginDiv(){
    if($('#createPassportLoginDiv').length > 0){
        $('#createPassportLoginDiv').remove();
    }
    if(document.getElementById('passportFilterDiv')){
        $('#passportFilterDiv').remove();
    }
    if(document.getElementById('passportFilterIframe')){
        $('#passportFilterIframe').remove();
    }
}

if(typeof(HTMLElement) != "undefined"){
    HTMLElement.prototype.contains = function(obj) {
        while(obj != null &&  typeof(obj.tagName) != "undefind"){
            if(obj == this)
                return true;
            obj = obj.parentNode;
        }
        return false;
    };
}
//分区搜索
function type_search(districtVal){
    obj = document.forms.type_form;
    var districtVal12 = districtVal.substr( 0 , 2 );
    obj.district.value = districtVal;
    obj.jobarea.value = '99' == districtVal12 || '0302' == districtVal ? '0302' : districtVal12+'00';
    obj.submit();
}



var objOtherAreaDiv = "";
var objOtherCityDiv = "";
function onloadFun(){
    if(window.$){
        $(document).ready(function(){
            /*去除链接，button，image button的点击时虚线框*/
            $("a,input[type='button'],input[type='image'],input[type='submit'],area").bind("focus",function(){
                if(this.blur){
                    this.blur();
                }
            })
            var obj = document.getElementById("51job|dev|all-channel1");
            if(obj != null){
                $(obj).mouseover(function(){
                    if(objOtherAreaDiv == ""){
                        objOtherAreaDiv = new fadeShow(this,"all-channel1");
                    }
                    objOtherAreaDiv.show();
                }).css({cursor:"pointer"});
            }

            var obj = document.getElementById("51job|dev|selectcity");
            if(obj != null){
                $(obj).mouseover(function(){
                    if(objOtherCityDiv == ""){
                        objOtherCityDiv = new fadeShow(this,"selectcity");
                    }
                    objOtherCityDiv.show();
                }).css({cursor:"pointer"});
            }

            /*登录弹层esc关闭*/
            document.onkeydown = function(event){
                var e = window.event||event;
                if(e.keyCode == 27){
                    hideLoginDiv();
                }
            }

            /*登录首页 用户名输入框点击进去的时候  提示文字清空,*/
            var userNameInpuValue = $('#username').attr('value');
            if($.trim(userNameInpuValue) == '邮箱/用户名/手机号' || $.trim(userNameInpuValue) == 'Email/MemberID/Phone')
            {
                $('#username').css('color','#999');
            }
            $("#username").click(function(){
                if($.trim(this.value) == '邮箱/用户名/手机号' || $.trim(this.value) =='Email/MemberID/Phone')
                {
                    this.value = '';
                }
                $('#username').css('color','black');
            });//username click end

            //登录功能  验证码切换  start
            $('.verifyPicChangeClick').click(function(){
                var objDate = new Date();
                var strTime = objDate.getTime();
                url = $('#verifyPic_img').attr('src');
                var type = $('#verifyPic_img').attr('type');
                if(type == '' || type == undefined){
                    type=3;
                }
                if(url.indexOf('?') > 0)
                {
                    url = url.replace(/\?.*/g,'?');
                }else
                {
                    url = url + '?';
                }
                url = url + 'type=' + type + '&from_domain='+window.location.host+'&t=' + strTime;

                $('#verifyPic_img').attr('src',url);

                return false;
            });// 验证码切换   end
        })
    } else {
        setTimeout("onloadFun()",1000);
    }
}
onloadFun();

function imgover(targetid,key){
    if (document.getElementById){
        target=document.getElementById(targetid);
        target.style.display="inline";
        switch(key){
            case 'A':
                target.style.left = '-18px';
                target.style.top = '-26px';
                break;
            case 'B':
                target.style.left = '-16px';
                target.style.top = '-26px';
                break;
            case 'C':
                target.style.left = '-46px';
                target.style.top = '-26px';
                break;
            case 'D':
                target.style.left = '28px';
                target.style.top = '-26px';
                break;
            case 'E':
                target.style.left = '92px';
                target.style.top = '-26px';
                break;
            case 'F':
                target.style.left = '104px';
                target.style.top = '-26px';
                break;
            case 'G':
                target.style.left = '134px';
                target.style.top = '-26px';
                break;
            case 'H':
                target.style.left = '-37px';
                target.style.top = '-26px';
                break;
            case 'J':
                target.style.left = '30px';
                target.style.top = '-26px';
                break;
            case 'K':
                target.style.left = '238px';
                target.style.top = '-26px';
                break;
            case 'L':
                target.style.left = '-82px';
                target.style.top = '1px';
                break;
            case 'M':
                target.style.left = '13px';
                target.style.top = '1px';
                break;
            case 'N':
                target.style.left = '-16px';
                target.style.top = '1px';
                break;
            case 'Q':
                target.style.left = '22px';
                target.style.top = '1px';
                break;
            case 'S':
                target.style.left = '-22px';
                target.style.top = '1px';
                break;
            case 'T':
                target.style.left = '59px';
                target.style.top = '1px';
                break;
            case 'W':
                target.style.left = '60px';
                target.style.top = '1px';
                break;
            case 'X':
                target.style.left = '119px';
                target.style.top = '1px';
                break;
            case 'Y':
                target.style.left = '90px';
                target.style.top = '1px';
                break;
            case 'Z':
                target.style.left = '-3px';
                target.style.top = '1px';
                break;
        }
    }
}
function imgout(targetid){
    if (document.getElementById){
        target=document.getElementById(targetid);
        target.style.display="none";
    }
}


/*************************定义通用函数****************************************/
var Sys = (function(ua){
    var s = {};
    s.IE = ua.match(/msie ([\d.]+)/)?true:false;
    s.Firefox = ua.match(/firefox\/([\d.]+)/)?true:false;
    s.Chrome = ua.match(/chrome\/([\d.]+)/)?true:false;
    s.IE6 = (s.IE&&([/MSIE (\d|1\d)\.0/i.exec(navigator.userAgent)][0][1] == 6))?true:false;
    s.IE7 = (s.IE&&([/MSIE (\d|1\d)\.0/i.exec(navigator.userAgent)][0][1] == 7))?true:false;
    s.IE8 = (s.IE&&([/MSIE (\d|1\d)\.0/i.exec(navigator.userAgent)][0][1] == 8))?true:false;
    return s;
})(navigator.userAgent.toLowerCase());

/**
 *  IE6背景图片默认不缓存
 */
Sys.IE6 && document.execCommand("BackgroundImageCache", false, true);

var $_ = function (id) {
    return  "string" == typeof id ? document.getElementById(id) : id;
};

/**
 *对数组的元素执行fun操作
 * params Array list  数组
 * params Function fun 数组元素需要执行的函数
 */
function Each(list, fun){
    for (var i = 0, len = list.length; i < len; i++) {fun(list[i], i); }
};

//给元素添加CSS
var Css = function(e, o){
    if(typeof o=="string")
    {
        e.style.cssText = o;
        return;
    }
    for(var i in o)
        e.style[i] = o[i];
};
//给元素添加属性
var Attr = function(e, o){
    for(var i in  o)
        e.setAttribute(i,o[i]);
};

var $$ = function( p, e){
    return p.getElementsByTagName(e);
};

/**
 * 创建一个html元素
 * params String e html元素
 * params Object p 指定父级元素，默认为document
 * params Function fn  对创建的元素执行fn函数
 * return Object html元素
 */
function create(e, p, fn){
    var element = document.createElement(e);
    p && p.appendChild(element);
    fn && fn(element);
    return element;
};

function getTarget(e){
    e = e||window.event;
    return e.srcElement||e.target;
};

/**
 * 创建一个tri行,tdi列的表格
 * params int tri 行数
 * params int tdi 列数
 * params Function arisetab 对创建的table执行arisetab函数
 * params Function arisetr  对每一个tr执行arisetr函数
 * params Function arisetd  对每一个td执行arisetd函数
 * params Object p  	   表格的父级元素
 * return Object 表格
 */
function createtab(tri, tdi, arisetab, arisetr, arisetd, p){
    var table = p ? p.createElement("table") : create("table");
    arisetab && arisetab(table);
    var tbody = p ? p.createElement("tbody") : create("tbody");
    for(var i=0; i<tri; i++)
    {
        var tr = p ? p.createElement("tr") : create("tr");
        arisetr && arisetr(i, tr);
        for(var j=0; j<tdi; j++)
        {
            var td = p ? p.createElement("td") : create("td");
            arisetd && arisetd(i, j, td);
            tr.appendChild(td);
        }
        tbody.appendChild(tr);
    }
    table.appendChild(tbody);
    return table;
};

//继承属性和方法
var Extend = function(destination, source) {
    for (var property in source) {
        destination[property] = source[property];
    }
};

//绑定对象方法
var Bind = function(object, fun) {
    var args = Array.prototype.slice.call(arguments).slice(2);
    return function() {
        return fun.apply(object, args);
    }
};

//绑定对象事件
var BindAsEventListener = function(object, fun, args ) {
    var args = Array.prototype.slice.call(arguments).slice(2);
    return function(event) {
        return fun.apply(object, [event || window.event].concat(args));
    }
};

//获取对象的样式
var CurrentStyle = function(element){
    return element.currentStyle || document.defaultView.getComputedStyle(element, null);
};

//获取对象的位置
var Getpos = function(o){
    var x = 0, y = 0;
    do{
        x += o.offsetLeft; y += o.offsetTop;
    }
    while((o = o.offsetParent));
    return {'x':x, 'y':y };
};
/**
 * 元素给定事件绑定事件处理函数
 * params Object element  需要绑定事件处理函数的元素
 * params String e        事件
 * params Function fn     事件处理函数
 */
function addListener(element, e, fn){
    element.addEventListener ? element.addEventListener(e, fn, false) : element.attachEvent("on" + e, fn);
};
/**
 * 元素给定事件移除事件处理函数
 * params Object element  需要移除事件处理函数的元素
 * params String e        事件
 * params Function fn     事件处理函数
 */
function removeListener(element, e, fn){
    element.removeEventListener ? element.removeEventListener(e, fn, false) : element.detachEvent("on" + e, fn);
};

//usage:  var Editor = new Class(...);
var Class = function(properties) {
    var _class = function(){
        return  ( arguments[0] !== null && this.initialize && typeof(this.initialize) == 'function') ? this.initialize.apply(this, arguments) : this;
    };
    _class.prototype = properties;
    return _class;
};

/*登录功能验证码切换*/
function changeVerifyCode()
{
    var objDate = new Date();
    var strTime = objDate.getTime();
    url = $('#login_yzm_img').attr('src');
    if(url.indexOf('?') > 0)
    {
        url = url.replace(/\?.*/g,'?');
    }else
    {
        url = url + '?';
    }
    url = url + 'type=3&t=' + strTime;
    $('#login_yzm_img').attr('src',url);
}

/*登录弹层代码*/
/*统一登录 登录弹层处理js*/
var IMGPATH = 'http://img01.51jobcdn.com';
var MYPATH = 'http://my.51job.com';
var MYPATHSSL = 'https://mylogin.51job.com';
var THISHOST = window.location.host;

/*弹层 language = EN/CN*/
function ShowPassportLayer(language)
{
    //createPassPortLayer(language,callback,true);
    var sLang = "c";
    if(language == "EN")
    {
        sLang = "e";
    }
    var sHref = "?lang=" + sLang + "&url=" + encodeURIComponent(window.location.href);

    window.location.href = "http://login.51job.com/login.php" + sHref;
}

/*切换验证码*/
function changeLoginVerify()
{
    var objDate = new Date();
    var strTime = objDate.getTime();
    url = $('#passport_top_vimg').attr('src');
    if(url.indexOf('?') > 0)
    {
        url = url.replace(/\?.*/g,'?');
    }else
    {
        url = url + '?';
    }
    url = url + 'type=3&from_domain=' + THISHOST + '&t=' + strTime;

    $('#passport_top_vimg').attr('src',url);

    return false;
}

/*获取cookie*/
function getCookie(c_name)
{
    var cookieStr 	= unescape(document.cookie);
    if (cookieStr.length>0){
        c_start		= cookieStr.indexOf(c_name + "=");
        if (c_start!= -1){
            c_start = c_start + c_name.length+1 ;
            c_end	= cookieStr.indexOf(";",c_start);
            if (c_end==-1)
            {
                c_end=cookieStr.length;
            }
            return cookieStr.substring(c_start,c_end);
        }
    }
    return "";
}