function Qpost_set( isEnglish,My_Domain )
{
    if ( !window.apply ) {
        var Qpost_set_Param = {
            openType: 2 , //居中定位
            filterParam: {} //滤镜层设置
        }
        window.apply = new ExtZzLayer( Qpost_set_Param );
    }
    var numbers = Math.random();

    var action_url = My_Domain+"/cv/CResume/CV_CQpostsetting.php?jsoncallback=?&r=" + numbers+"&isEnglish="+isEnglish;

    $.getJSON( action_url,{},function(result) {
        if(result.status == 1)
        {
            if( isEnglish == "1" && $('link[href$="tLogin.css"]').length == 0 && $('link[href$="tLogin-En.css"]').length == 0){
                $("head").append('<link href="http://js.51jobcdn.com/in/css/resume/tLogin-En.css" rel="stylesheet" type="text/css">');
            }else if(isEnglish == "0" && $('link[href$="tLogin-En.css"]').length == 0 && $('link[href$="tLogin.css"]').length == 0){
                $("head").append('<link href="http://js.51jobcdn.com/in/css/resume/tLogin.css" rel="stylesheet" type="text/css">');
            }

            apply.setContent( result.content );
            apply.setCloseNode( 'window_close' );
            apply.open();
            var status_value =  $("#status_value").val();

            var qpost_set_callbackfunction = function(){
                if(status_value == "1" ||  status_value == ""){
                    DIVOPTION.initDivOption("#rsmid_div","#rsmid_options",'#rsmid','#rsmid_input');
                    DIVOPTION.initDivOption("#coverid_div","#coverid_options",'#coverid','#coverid_input');
                    $(document).click(function(){
                        $('div[pop_options]').hide();
                    });
                }
            }

            if($('script[src$="divoption.js"]').length == 0){
                var sScriptSrc = 'http://js.51jobcdn.com/in/js/2009/resume/divoption.js';
                var oHead = document.getElementsByTagName('head')[0];
                if(oHead)
                {
                    var oScript = document.createElement('script');
                    oScript.setAttribute('src',sScriptSrc);
                    oScript.setAttribute('type','text/javascript');
                    var loadFunction = function()
                    {
                        if (this.readyState == 'complete' || this.readyState == 'loaded')
                        {
                            qpost_set_callbackfunction();
                        }
                    };
                    oScript.onreadystatechange = loadFunction;
                    oScript.onload = qpost_set_callbackfunction;
                    oHead.appendChild(oScript);
                }
            }else{
                qpost_set_callbackfunction();
            }
        }
        else
        {
            window.location.href = result.content;
        }
    } );
}

function checkstatus( aa,lang )
{
    if( aa == 0 )
    {
        stop_rsmid = $("#rsmid")[0].value;
        $("#stop_rsmid")[0].value = stop_rsmid;
        $("#rsmid_div").unbind();
        $("#coverid_div").unbind();
        $("#rsmid_input").addClass("disabled");
        $("#coverid_input").addClass("disabled");
    }
    else if( aa == 1 )
    {
        $("#rsmid_input").removeClass("disabled");
        $("#coverid_input").removeClass("disabled");
        DIVOPTION.initDivOption("#rsmid_div","#rsmid_options",'#rsmid','#rsmid_input');
        DIVOPTION.initDivOption("#coverid_div","#coverid_options",'#coverid','#coverid_input');
        rsmid = $("#rsmid").val();
        qcheckSelectedResume(rsmid,lang);
    }
}

function qcheckSelectedResume( aa, lang )
{
    var CLang = $("#Cn_"+aa).val();
    var ELang = $("#En_"+aa)[0].value;
    $("#IsCn")[0].value = CLang;
    $("#IsEn")[0].value = ELang;
    var Cbase = $("#CBase_"+aa).val();
    var Ebase = $("#EBase_"+aa).val();
    if(Cbase != 2 && Ebase != 2)
    {
        $("#tips").show();
        var tips = lang == 0 ? '此简历不完整，不能投递，请完善后再选择。' : 'Resume is incomplete! It cannot apply the job.';
        $("#tips").html('<i class="inpPromptIcon"></i>'+tips);
    }
}

function checkedselect()
{
    var obj = document.Qpost_Set_Form.status;
    var id = $("#rsmid").val();
    var cbase	= $("#CBase_"+id).val();
    var ebase	= $("#EBase_"+id).val();

    if(!obj[0].checked && !obj[1].checked)
    {
        alert("请选择状态!");
        return false;
    }

    if(cbase!= 2 && ebase != 2 && obj[0].checked)
    {
        alert("此简历不完整，不能投递，请完善后再选择。");
        return false;
    }

    return true;
}

function checkedselectE()
{
    var obj = document.Qpost_Set_Form.status;
    var id = $("#rsmid").val();
    var cbase	= $("#CBase_"+id).val();
    var ebase	= $("#EBase_"+id).val();

    if(!obj[0].checked && !obj[1].checked)
    {
        alert("Please Select Status!");
        return false;
    }

    if(cbase!= 2 && ebase != 2 && obj[0].checked)
    {
        alert("Your resume is incomplete. Please finish it first.");
        return false;
    }
    return true;
}

function fsubmit(domain_my)
{
    if(checkedselect())
    {
        var str = $('#Qpost_Set_Form').serialize();
        action_url = domain_my + '/cv/CResume/CV_CQpostsetting.php?jsoncallback=?&isEnglish=0&r='+Math.random();
        $.getJSON( action_url, str , function(result){
            Qpost_showResponse(result);
        });
    }
}

function Efsubmit(domain_my)
{
    if(checkedselectE())
    {
        var str = $('#Qpost_Set_Form').serialize();
        action_url = domain_my + '/cv/CResume/CV_CQpostsetting.php?jsoncallback=?&isEnglish=1&r='+Math.random();
        $.getJSON( action_url, str , function(result){
            Qpost_showResponse(result);
        });
    }
}

// post-submit callback 
function Qpost_showResponse(result)  {
    if(result.status== '1')
    {
        var Qpost_str = result.content.split("|");
        $("#Qpostcoverid").val(Qpost_str[1]);
        alert(Qpost_str[0]);
        apply.close();
    }
    else
    {
        window.location.href = result.content;
    }
}