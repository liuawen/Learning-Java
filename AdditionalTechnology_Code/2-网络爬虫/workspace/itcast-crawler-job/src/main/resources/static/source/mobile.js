var mobileComponent = function() {
    return {
        sMobileErrorMessage_CHINA_CN: '仅支持11位大陆手机号码，且以13、14、15、17、18开头',
        sMobileErrorMessage_CHINA_EN: 'Numbers in China mainland only, starting with 13、14、15、17、18, 11-digit.',
        sMobileEmptyErrorMessage_CN: '请输入手机号',
        sMobileEmptyErrorMessage_EN: 'Please enter your mobile number.',
        sMobileErrorMessage_CN: '你输入的手机号码有误',
        sMobileErrorMessage_EN: 'Incorrect mobile number.',
        sBindMobileErrorMessage_CHINA_CN: '只有大陆的手机号码才能被绑定',
        sBindMobileErrorMessage_CHINA_EN: 'Just support Mainland mobile phone Binding',
        sBindMobileErrorMessage_MOBILE_SAME_CN: '请输入新的手机号码',
        sBindMobileErrorMessage_MOBILE_SAME_EN: 'Please enter another mobile number.',
        sBindMobileErrorMessage_foreign_CN: '你输入的不是大陆手机号码，无法获取短信进行认证。确认使用该号码，请直接“保存”',
        sBindMobileErrorMessage_foreign_EN: 'SMS verification is not available for numbers outside China mainland. Save it if you are sure to use this number.',
        checkMobile: function(iMobile, sMpCountry) {
            if ('086' == sMpCountry) {
                var sReg = /^(1[3456789]{1,1}[0-9]{9,9})$/;
            } else {
                var sReg = /^[0-9]{1,20}$/;
            }

            return sReg.test(iMobile);
        }
    }
}

var sCaptchaErrorMessage_CN = '验证码不能为空!';
var sCaptchaErrorMessage_EN = 'The verification code can’t be empty!';

var waitTime=120;
var t;
var sendMsg = {
    sendStart:function ( iPhoneId, iSendCodeId, iApptype, IMGPATH, MYPATH, Lang ){
        return sendMsg.sendStartTool(iPhoneId, iSendCodeId, iApptype, IMGPATH, MYPATH, Lang, null);
    },
    sendStartExtra:function ( iPhoneId, iSendCodeId, iApptype, IMGPATH, MYPATH, Lang,options ){
        return sendMsg.sendStartTool(iPhoneId, iSendCodeId, iApptype, IMGPATH, MYPATH, Lang,options );
    },
    sendStartTool:function( iPhoneId, iSendCodeId, iApptype, IMGPATH, MYPATH, Lang,options )
    {
        waitTime = 120;
        if( typeof t != 'undefined' ){
            clearTimeout(t);
        }
        var Lang = Lang || 'CN';
        var phoneNo			= Jtrim($("#"+iPhoneId).val());
        //check phone number is right
        var oCheckResult = this.phoneCheck( phoneNo, IMGPATH, Lang );

        if( oCheckResult.status != 1)
        {
            return oCheckResult;
        }
        var piccode = '';
        var extradata = '';
        if(options!= null){
            if(options.hasOwnProperty('piccode')){
                extradata += '&piccode='+options['piccode'];
            }
            if(options.hasOwnProperty('name')){
                extradata += '&name='+options['name'];
            }
            if(options.hasOwnProperty('year')){
                extradata += '&year='+options['year'];
            }
            if(options.hasOwnProperty('month')){
                extradata += '&month='+options['month'];
            }
        }

        var returnV;
        //向后台发送处理数据
        $.ajax({
            type: "POST", //用POST方式传输
            dataType: "text", //数据格式:JSON
            url: MYPATH+'/AjaxAction/mobile_code/send_mobile_code.php', //目标地址
            data: "mobile="+phoneNo+"&apptype="+iApptype+extradata,
            async:false,
            success: function (data)
            {
                data = eval("("+data+")");
                switch( data.status )
                {
                    case -1:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Numbers in China mainland only, starting with 13、14、15、17、18, 11-digit.';
                        }
                        else
                        {
                            var returnMsg = '仅支持11位大陆手机号码，且以13、14、15、17、18开头';
                        }
                        break;
                    case -2:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Tries for this number are used up. Please try tomorrow.';
                        }
                        else
                        {
                            var returnMsg = '今天申请次数过多，请明天再试';
                        }
                        break;
                    case -3:
                    case -4:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Sorry, system response times out, please try again later.';
                        }
                        else
                        {
                            var returnMsg = '操作失败请稍后再试。';
                        }
                        break;
                    case -5:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Illegal request.';
                        }
                        else
                        {
                            var returnMsg = '非法请求。';
                        }
                        break;
                    case -6:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'The user is not logged in.';
                        }
                        else
                        {
                            var returnMsg = '用户未登录。';
                        }
                        break;
                    case -7:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Mobile or Apptype is empty';
                        }
                        else
                        {
                            var returnMsg = 'mobile或apptype为空';
                        }
                        break;
                    case -9:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'The number is not binding';
                        }
                        else
                        {
                            var returnMsg = '此手机号码不存在或未绑定';
                        }
                        break;
                    case -10:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Please enter another mobile number.';
                        }
                        else
                        {
                            var returnMsg = '请输入新的手机号码';
                        }
                        break;
                    case -21:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'please enter the verification code';
                        }
                        else
                        {
                            var returnMsg = '请输入验证码!';
                        }
                        break;
                    case -22:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Incorrect SMS verification code.';
                        }
                        else
                        {
                            var returnMsg = '你输入的短信验证码错误';
                        }
                        break;
                    case -24:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Your phone number is not bound to this account, you can not use the phone to retrieve password';
                        }
                        else
                        {
                            var returnMsg = '您的手机号没有绑定此账号，不能使用手机找回密码！';
                        }
                        break;
                    case 1:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'The verification code has been sent successfully, please check the phone';
                        }
                        else
                        {
                            var returnMsg = '验证码已发送成功, 请注意查收';
                        }
                        oDivObj = document.getElementById(iSendCodeId);
                        sendMsg.PhoneTime(oDivObj, null, Lang);
                        break;

                    default:
                        if( Lang == "EN" )
                        {
                            var returnMsg = 'Send the code.';
                        }
                        else
                        {
                            var returnMsg = '操作失败请稍后再试。';
                        }
                        break;
                }
                returnV = {status:data.status, msg:returnMsg};
            }
        });
        return returnV;
    },
    PhoneTime:function( o,num,lang )
    {
        if (waitTime == 0)
        {
            o.removeAttribute("disabled");
            if( lang == 'EN' )
            {
                o.value="Send the code";
            }
            else
            {
                o.value="获取验证码";
            }

            waitTime = 300;
        } else {
            o.setAttribute("disabled", true);

            if( lang == 'EN' )
            {
                o.value="Resend(" + waitTime + ")";
            }
            else
            {
                o.value="重新发送(" + waitTime + ")";
            }
            waitTime--;
            t = setTimeout(function() {sendMsg.PhoneTime(o,waitTime, lang);},1000);
        }
    },
    phoneCheck:function(sPhoneNo, IMGPATH, lang)
    {
        var retrunStatur	= 1;
        var returnMsg		= '';
        var phoneNo			= sPhoneNo;
        var phone_length	= strlength(phoneNo);
        if( lang == 'EN' )
        {
            var phoneTip	= 'Please enter your registered binding mobile phone number';
            var phoneError	= 'The phone number format error, please re-enter'
        }
        else
        {
            var phoneTip =  '请输入您注册绑定的手机号码';
            var phoneError	= '手机号格式错误，请重新填写'
        }
        //判断手机是否为空
        if( phone_length == 0 || phoneNo == phoneTip )
        {
            retrunStatur = '-100';
            returnMsg	 = phoneTip;
        }
        else
        {//判断手机是否错误
            var objPhoneCheck =  new mobileComponent();
            if(objPhoneCheck.checkMobile(phoneNo,'086') <= 0)
            {
                retrunStatur = '-101';
                returnMsg	 = phoneError;
            }
        }
        return {status:retrunStatur,msg:returnMsg}
    }
}
