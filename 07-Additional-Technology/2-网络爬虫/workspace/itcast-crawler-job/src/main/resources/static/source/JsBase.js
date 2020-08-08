function openwin( url , name , width , height , left , top ){
    window.open( url , name ,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width="+width+",height="+height+",left="+left+",top="+top );
}

function openwinscroll( url , name , width , height , left , top ){
    window.open( url , name ,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width="+width+",height="+height+",left="+left+",top="+top );
}

String.prototype.Trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

String.prototype.LTrim = function(){
    return this.replace(/(^\s*)/g, "");
}

String.prototype.RTrim = function(){
    return this.replace(/(\s*$)/g, "");
}


function strlength(str){
    return str.replace(/[^\x00-\xff]/gi,'xx').length;
}

function JumpOutSend(URLStr,rsmid){
    var f1 = document.Form1;
    var oldTarget = f1.target;
    var oldReSumeID = f1.ReSumeID.value;
    var oldAction = f1.action;
    f1.target = JumpOutSend;
    f1.ReSumeID.value=rsmid;
    f1.action = URLStr;
    f1.submit();
    f1.action = oldAction;
    f1.ReSumeID.value = oldReSumeID;
    f1.target = oldTarget;
}

function j2gb(url)
{
    if(url != '')
    {
        location.href = "ht" + "tp://www.51job.com/" + url;
        return false;
    }

    if(location.hostname == "big5.51job.com")
    {
        location.href = "ht" + "tp://www.51job.com/" + url;
        return false;
    }
    else
    {
        location.href = "ht" + "tp://big5.51job.com" + url;
        return false;
    }
}

function chkUserEmail( str,language )
{
    var language = (arguments[1]!='')?arguments[1]:'CN';
    if( str.Trim() == '' ){
        if(language == 'EN')
        {
            window.alert( "Please enter your email address!" );
        }
        else
        {
            window.alert( "请输入您的E-mail地址 ！" );
        }
        return false;
    }
    return chkUserEmailFormat( str,language );
}

function chkUserEmailFormat( str,language )
{
    var language = (arguments[1]!='')?arguments[1]:'CN';

    if( str.Trim().length > 100 ){
        if(language == 'EN')
        {
            window.alert( "Your email address should not have more than 100 characters!" );
        }
        else
        {
            window.alert( "email地址长度不能超过100位!" );
        }
        return false;
    }
    str = str.toLowerCase().Trim()
    if( isEmail(str) ){
        return true;
    }else{
        if(language == 'EN')
        {
            window.alert( "Please use correct email address!" );
        }
        else
        {
            window.alert ( "Email书写不正确！" );
        }
        return false;
    }
}

function chkUserName( str,language )
{
    var language = (arguments[1]!='')?arguments[1]:'CN';

    if( str.Trim() == '' ){
        if(language == 'EN')
        {
            window.alert( "Please enter your member ID!" );
        }
        else
        {
            window.alert( "请输入用户名！" );
        }
        return false;
    }
    if( str.Trim().length < 4 ){
        if(language == 'EN')
        {
            window.alert( "Your member ID should have more than 3 characters!" );
        }
        else
        {
            window.alert( "您的用户名需大于3位 ！" );
        }
        return false;
    }
    if( str.Trim().length > 50 ){
        if(language == 'EN')
        {
            window.alert( "Your member ID should not have more than 50 characters!" );
        }
        else
        {
            window.alert( "您的用户名不能超过50位 ！" );
        }
        return false;
    }
    return chkUserNameFormat( str,language );
}

function chkUserNameFormat( str,language )
{
    var language = (arguments[1]!='')?arguments[1]:'CN';
    str=str.Trim()
    var regu = "^([0-9a-zA-Z]+[_0-9a-zA-Z@.-]*)$"
    var re = new RegExp(regu);
    if( str.search( re ) != -1 ){
        var sReg = /^(1[3456789]{1,1}[0-9]{9,9})$/;
        if(sReg.test(str))
        {
            if(language == 'EN')
            {
                window.alert( "Please use correct member ID!" );
            }
            else
            {
                window.alert( "用户名不能为手机号" );
            }
            return false;
        }
        else
        {
            return true;
        }
    }else{
        if(language == 'EN')
        {
            window.alert( "Please use correct member ID!" );
        }
        else
        {
            window.alert( "用户名须以字母或数字开头，至少4位" );
        }
        return false;
    }

}

function chkNum( value , minvalue , maxvalue ){
    if( isNaN( value ) ){
        return false;
    }else{
        if( typeof( minvalue ) == 'number' ){
            if( value < minvalue )	{
                return false;
            }
        }
        if( typeof( maxvalue ) == 'number' ){
            if( value > maxvalue ){
                return false;
            }
        }
        return true;
    }
}
var ZLayer;
function creatZLayer( divcontent ){//支持多个层
    if (divcontent=='')
        divcontent='<div></div>';
    var zlParam3 = {
        content: divcontent ,
        divProps: { style : { zIndex : 1007 } } ,
        dragNode: 'drag3'	,
        closeNode: 'close3',
        openType: 2 , //居中定位
        filterParam: {} ,//滤镜层设置
        createIfr:false
    }
    ZLayer = new ExtZzLayer( zlParam3 );
}
function creatZLayerOnce( divcontent ){//单一层
    if (typeof(ZLayer)!='object'){
        creatZLayer( divcontent );
    }
}
function OpenZLayer(){
    ZLayer.open();
}
function CloseZLayer(){
    ZLayer.close();
}
function SetZLayerContent(divcontent){
    ZLayer.setContent(divcontent);
}
function RemoveZLayerContent(divcontent){
    ZLayer.removeContent();
}
function GetZLayerContent(divcontent){
    contentType=0;//获取层内容，当type为1时，返回DOM对象索引数组（即层的childNodes属性） ,否则返回层内容的HTML字符串
    return ZLayer.getContent(contentType);
}
function SetZLayerCloseNode(CloseNode){
    ZLayer.setCloseNode(CloseNode);
}
function SetZLayerDragNode(dragNode){
    ZLayer.setDragNode( dragNode  );
}
function SetLanguageFlag(flag){//设置语言标记，中文为 CN  英文为EN
    LANGUAGE_FLAG=flag;
}

//判断是否是Email
function isEmail(str)
{
    var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|com|gov|mil|org|edu|int|name|asia)$";
    var re = new RegExp( regu );
    if( str.search( re ) == -1 )
    {
        return false;
    }
    else
    {
        return true;
    }
}

// 判断是否含有大写字母
function hasCapital(str)
{
    var result = str.match(/^.*[A-Z]+.*$/);
    if(result==null) return false;
    return true;
}

// 判断是否含有小写字母
function hasLowercase(str)
{
    var result = str.match(/^.*[a-z]+.*$/);
    if(result==null) return false;
    return true;
}

// 判断是否含有数字
function hasNumber(str)
{
    var result = str.match(/^.*[0-9]+.*$/);
    if(result==null) return false;
    return true;
}

// 判断是否含有其他字符
function hasOther(str)
{
    var result = str.match(/^.*[^0-9A-Za-z]+.*$/);
    if(result==null) return false;
    return true;
}

function j2gb(url)
{
    if(url != '')
    {
        location.href = "ht" + "tp://www.51job.com/" + url;
        return false;
    }

    if(location.hostname == "big5.51job.com")
    {
        location.href = "ht" + "tp://www.51job.com/" + url;
        return false;
    }
    else
    {
        location.href = "ht" + "tp://big5.51job.com" + url;
        return false;
    }
}

function gotoehire(isenglish)
{
    var urllast;
    var iscnc=0;
    if(isenglish==0)
    {
        urllast ="MainLogin.aspx";
    }else
    {
        urllast="MainLoginEN.aspx";
    }

    if(location.hostname == "big5.51job.com")
    {
        url=document.URL;
        tmpHPage = url.split( "/" );
        oldhostName = tmpHPage[5].split( "." );
        domainname=oldhostName[0];
        if(domainname=="cnc" || domainname=="cn" || domainname=="bj1")
        {
            iscnc=1;
        }
    }

    if(location.hostname == "cnc.51job.com" || location.hostname == "cn.51job.com" || location.hostname == "bj1.51job.com" || iscnc==1)
    {
        location.href = "ht" + "tp://eh.51job.com/" + urllast;
        return false;
    }else{
        location.href = "ht" + "tp://ehire.51job.com/" + urllast;
        return false;
    }
}

function Jtrim(str)
{
    var i = 0;
    var len = str.length;
    if ( str == "" ) return( str );
    j = len -1;
    flagbegin = true;
    flagend = true;
    while (( flagbegin == true) && (i< len))
    {
        if ( str.charAt(i) == " " )
        {
            i=i+1;
            flagbegin=true;
        }
        else
        {
            flagbegin=false;
        }
    }

    while  ((flagend== true) && (j>=0))
    {
        if (str.charAt(j)==" ")
        {
            j=j-1;
            flagend=true;
        }
        else
        {
            flagend=false;
        }
    }

    if ( i > j ) return ("");

    trimstr = str.substring(i,j+1);
    return trimstr;
}

function isValidDate( year, month, day )
{
    year  = parseInt(year,10);
    month = parseInt(month,10);
    day   = parseInt(day,10);

    if (( month==4) || (month==6) || (month==9) || (month==11) )
    { if (( day < 1) || (day > 30) )
    {
        return (false);
    }
    }
    else
    { if ( month!=2 )
    { if ( (day < 1) || (day > 31 ))
    {
        return (false);
    }
    }
    else
    { // month == 2
        if ( ( year % 100 ) != 0 && (year % 4 == 0) || ( year % 100 ) == 0 && ( year % 400) == 0 )
        { if ( (day < 1) || day > 29 )
        {
            return (false);
        }
        }
        else
        { if ( (day < 1) || day > 28 )
        {
            return (false);
        }
        }
    }
    }
    return (true);
}

function isValidDate_e( year, month, day )
{
    year  = parseInt(year,10);
    month = parseInt(month,10);
    day   = parseInt(day,10);

    if (( month==4) || (month==6) || (month==9) || (month==11) )
    { if (( day < 1) || (day > 30) )
    {
        return (false);
    }
    }
    else
    { if ( month!=2 )
    { if ( (day < 1) || (day > 31 ))
    {
        return (false);
    }
    }
    else
    { // month == 2
        if ( ( year % 100 ) != 0 && (year % 4 == 0) || ( year % 100 ) == 0 && ( year % 400) == 0 )
        { if ( day > 29 )
        {
            return (false);
        }
        }
        else
        { if ( day > 28 )
        {
            return (false);
        }
        }
    }
    }
    return (true);
}

function DateCompare(YearFrom, MonthFrom, YearTo, MonthTo)
{  YearFrom  = parseInt(YearFrom,10);
    MonthFrom = parseInt(MonthFrom,10);
    YearTo    = parseInt(YearTo,10);
    MonthTo   = parseInt(MonthTo,10);

    if (YearFrom > YearTo)
    { return false;}
    else
    {  if (YearFrom == YearTo)
    {  if (MonthFrom > MonthTo)
        return false;
    }
    }
    return true;
}

function isInt(obj){
    if (obj==""){
        return false;
    }
    slen=obj.length;
    for (i=0; i<slen; i++)
    {
        cc = obj.charAt(i);
        if (cc <"0" || cc >"9")
        {
            return false;
        }
    }
    return true;
}

function MM_openBrWindow(theURL,winName,features)
{
    window.open(theURL,winName,features);
}

function InvestCallPage(htmlurl){
    var newwin1=window.open(htmlurl,"investwin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,width=430,height=300");
}
function chkInvestOK(){
    var f1    = document.fInvestigate;
    var issub = false;
    for(i=0;i<f1.SelVal.length;i++){
        if( f1.SelVal[i].checked ){
            issub = true;
        }
    }
    if( true == issub ){
        InvestCallPage('');
        return true;
    }
    else{
        window.alert("请选择您的答案");
        return false;
    }
}
function hotKeyWordSlip(ul, delay, speed, lineHeight) {
//停留时间，相对速度（越小越快）,每次滚动多少，最好和Li的Line-height一致。
    var slideBox = (typeof ul == "string") ? document.getElementById(ul) : ul;
    var delay = delay || 1000;
    var speed = speed || 20;
    var lineHeight = lineHeight || 20;
    var tid = null,
        pause = false;
    var start = function() {
        tid = setInterval(slide, speed);
    };
    var slide = function() {
        if (pause) {
            return;
        }
        slideBox.scrollTop += 2;
        if (slideBox.scrollTop % lineHeight == 0) {
            clearInterval(tid);
            slideBox.appendChild(slideBox.getElementsByTagName("li")[0]);
            slideBox.scrollTop = 0;
            setTimeout(start, delay);
        }
    };
    slideBox.onmouseover = function() {
        pause = true;
    };
    slideBox.onmouseout = function() {
        pause = false;
    };
    setTimeout(start, delay);
}
function EncodeUrl( city , address ,searchdomain, lonlat) {
    src=searchdomain+'/jobsearch/tranToMap.php?city=' + encodeURIComponent( city ) + '&address=' + encodeURIComponent( address ) + '&lonlat=' + lonlat;
    window.open(src , 'ShowMap' , 'width=800,height=480,top=50, left=50,resizable=yes' );
}

function getlength(str){
    return str.replace(/[^\x00-\xff]/g,"**").length;
}

function   codehtml(str)
{
    var   s   =   "";
    if   (str.length   ==   0)   return   "";
    for   (var   i=0;   i<str.length;   i++)
    {
        switch   (str.substr(i,1))
        {
            case   "<"     :   s   +=   "&lt;";       break;
            case   ">"     :   s   +=   "&gt;";       break;
            case   "&"     :   s   +=   "&amp;";     break;
            case   "   "     :   s   +=   "&nbsp;";   break;
            case   "\'"   :   s   +=   "&#39;";     break;
            case   "\""   :   s   +=   "&quot;";   break;
            case   "\n"   :   s   +=   "<br>";       break;
            default       :   s   +=   str.substr(i,1);   break;
        }
    }
    return   s;
}

function copyToClipboard(txt) {
    if (window.clipboardData) {
        window.clipboardData.clearData();
        window.clipboardData.setData("text", txt);
    } else if (navigator.userAgent.indexOf("Opera") != -1) {
        window.location = txt;
    } else if (window.netscape) {
        try {
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
        } catch(e) {
            alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'");
            return;
        }
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip) return;
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans) return;
        trans.addDataFlavor('text/unicode');
        var str = new Object();
        var len = new Object();
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = txt;
        str.data = copytext;
        trans.setTransferData("text/unicode", str, copytext.length * 2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip) return false;
        clip.setData(trans, null, clipid.kGlobalClipboard);
        alert("复制成功")
    }
}

function floatingLayer(iPageWidth, sElementId) {
    iLeft = parseInt(screen.width - iPageWidth)/2 + parseInt(iPageWidth) - 5;
    $('#' + sElementId).css({"left":iLeft});
    $('#' + sElementId).show();
}

function cutStr(sText, iLength, sDot) {
    if ('' == sDot) {
        sDot = '...';
    }

    if (sText.length > iLength) {
        sFormatText = sText.substr(0, iLength) + sDot;
    } else {
        sFormatText = sText;
    }


    return sFormatText;
}