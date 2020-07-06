/**
 * sJobIdElementName: 存储职位ID的HTML元素的NAME, 例如<input type="hidden" name="delivery_jobid" value="jobid_value" jt="1" />: value: 职位id, jt: 职位类型
 * sDeliveryType: 投递类型: 1: 单个投递 2: 批量投递
 * sDomainMy:发送AJAX请求的域名
 * sLanguage: 页面语言: ‘c’: 中文 ‘e’: 英文
 * sPrd: 页面来源域名
 * sPrp: 页面来源页面代码
 * sCp: 当前投递域名页面代码
 * sImgPath: 图片服务器域名
 */

//投递过程
function delivery(sJobIdElementName, sDeliveryType, sDomainMy, sLanguage, sPrd, sPrp, sCp, sImgPath, callback)
{
    if ($('#deliveryLayer').parent().css('visibility') == 'hidden')
    {
        $('#deliveryLayer').remove();
    }

    var reg = new RegExp('^(?:(?:https?):)?/*(?:[^@]+@)?([^:/#]+)');
    var matches = reg.exec(sPrd);
    sPrd = matches ? matches[1] : sPrd;
    sPrp = sPrp ? sPrp : '01';

    Delivery.setPrp(sPrp);
    Delivery.setPrd(sPrd);
    Delivery.setImagePath(sImgPath);

    //当前投递域名: var sCd = document.domain;
    var sCd = document.domain;

    //单个投递, 多个投递处理
    var sJob = Delivery.getJobStr(sJobIdElementName, sDeliveryType);

    var sResumeId = $('#rsmId').val();
    var sCvLan = $('#cvLanguage').val();
    var sCoverId = $('#coverId').val();
    var sQPostSet = $('input:checkbox[name="qPostSet"]:checked').val();
    if ($('#tips').attr('tipid') == 2)
    {
        alert('您选择的简历不完整，将不能投递，请完善后再投递。');
        return;
    }
    sDomainMy = window.cfg.domain.i;
    if (sJob != '()')
    {
        var oData = {
            jobid : sJob,           //职位
            prd : sPrd,             //来源域名
            prp : sPrp,             //来源页面
            cd : sCd,               //投递域名
            cp : sCp,               //投递页面
            resumeid : sResumeId,   //简历，可能为空
            cvlan : sCvLan,         //简历语言，可能为空
            coverid : sCoverId,     //求职信，可能为空
            qpostset : sQPostSet,   //快速投递，可能为空
            elementname: sJobIdElementName,
            deliverytype: sDeliveryType,
            deliverydomain: sDomainMy,
            language: sLanguage,
            imgpath:sImgPath
        };

        $.each(oData, function(key,value){
            if (typeof value == 'undefined')
            {
                oData[key] = '';
            }
        });

        Delivery.loadingLayer();

        //ajax请求URL: sDomainMy + '?jobid=()&prd=&prp=&cd=&cp=&accountid=&resumeid=';
        $.ajax({
            url: sDomainMy + '/delivery/delivery.php?rand=' + Math.random(),
            type: 'GET',
            dataType: 'jsonp',
            jsonp: "jsoncallback",
            data: oData,
            success: function (result) {   //成功后回调
                if (typeof(callback) === 'function')
                {
                    Delivery.setCallback(callback);
                }
                Delivery.ajaxCallback(result);
            },
            error: function (e) {
                alert('error');
            }
        });
    }
    else
    {
        alert('请选择职位再投递！');
    }
}


var Delivery = (function(){
    var sPrp = '';
    var sPrd = '';
    var singleType = '';
    var sImagePath = '';
    var callback = '';

    function setPrd(p_sValue)
    {
        sPrd = p_sValue;
    }
    function setPrp(p_sValue)
    {
        sPrp = p_sValue;
    }
    function setImagePath(p_sValue)
    {
        sImagePath = p_sValue || window.cfg.domain.img;
    }
    function setCallback(p_callback)
    {
        callback = p_callback;
    }

    function getJobStr(sJobIdElementName, sDeliveryType)
    {
        var sJob = '';
        var iJobId = 0;
        var iJobType = 0;

        var sSelectorStr  = '';
        if (sDeliveryType == 1)
        {
            //单个职位的页面
            sSelectorStr = 'input[name="' + sJobIdElementName + '"]';
            singleType = $(sSelectorStr).attr('jt');   //单个职位的跟踪
        }
        else if(sDeliveryType == 3)
        {
            //多个职位的页面单个投递，通过id
            sSelectorStr = '#' + sJobIdElementName;
        }
        else
        {
            //多个职位的页面多选投递
            sSelectorStr = 'input:checkbox[name="'+ sJobIdElementName +'"]:checked';
        }

        $(sSelectorStr).each(function () {
            iJobId = $(this).attr('value');
            iJobType = $(this).attr('jt');

            if (isNaN(iJobId)) {iJobId = 0;}
            if (isNaN(iJobType)) {iJobType = '';}

            if (iJobType == '') {
                sJob =  sJob + iJobId + ',';
            } else {
                sJob =  sJob + iJobId + ':' + iJobType + ',';
            }
        });

        if (sJob != '')
        {
            sJob = sJob.substring(0, sJob.length-1);
        }
        return '(' + sJob + ')';
    }

    //返回结果处理
    function ajaxCallback(oResult)
    {
        var iType = oResult.type;
        var sContent = oResult.content;
        if (typeof iType == 'undefined' || typeof sContent == 'undefined')
        {
            iType = 1;
            sContent = '';
        }
        showRemind(iType, sContent);
    }

    function showRemind(p_iType, p_sContent)
    {
        switch (p_iType)
        {
            case 1:
                alert(p_sContent);
                if ($(".layer_class, .layer_back_drop_class").length > 0) {
                    $('.layer_close').click();
                }
                break;
            case 2:
                var refer = '?url=' + encodeURIComponent(window.location);

                location.href = p_sContent + refer;
                break;
            case 5:
                location.href = p_sContent;
                break;
            case 3:
                windowOpen(p_sContent);
                if ($(".layer_class, .layer_back_drop_class").length > 0) {
                    $('.layer_close').click();
                }
                break;
            case 4:
            default:
                remindLayer(p_sContent);
        }
    }

    //弹层等处理
    function remindLayer(p_oLayerInfo)
    {
        var sLayer = p_oLayerInfo.layer;
        var sHtml = p_oLayerInfo.content.html;
        var oData = p_oLayerInfo.content.data;
        showLayer(sHtml);
        bindAction(sLayer, oData);
    }

    function showLayer(content)
    {
        var oLayerSettings = jQuery.FLayer.init();

        oLayerSettings['layer_after_close'] = function(){
            $(".layer_class, .layer_back_drop_class").remove();
        };

        jQuery.FLayer.setContent(oLayerSettings,content);
        jQuery.FLayer.open(oLayerSettings);
    }

    function bindAction(p_sLayer, p_oData)
    {
        if (p_sLayer == 'deliverySuccessLayer')
        {
            setTimeout('if($("#deliverySuccessLayer").length>0){$(".layer_close").click();}',2500);
            if ($("#app_ck").length > 0)
            {
                $("#app_ck").attr("href","#").attr("class","but_sq off").removeAttr("onclick");
                $('#app_ck').html('<img width="22" height="22" src="'+ sImagePath +'/im/jobs/but_img_sq_2.png" alt="" />已申请');
            }
            //若传递了回调函数，投递成功 页面关闭时执行
            if (typeof(callback) === 'function')
            {
                $('.layer_close').click(function(){
                    callback();
                });
            }
        }

        var oLayer = $('#' + p_sLayer);
        //下拉按钮
        oLayer.find("span.i_arrow").each(function(){

            var oButDown = $(this);
            var oSelectLayer = oButDown.siblings(".ul");

            $('body').click(function(){
                oSelectLayer.hide();
            });

            oButDown.click(function(event) {
                $('body').click();
                event.stopPropagation();
                oSelectLayer.show();
            });
        });

        //投递按钮
        oLayer.find('#apply_now').click(function(event){
            event.stopPropagation();
        });

        //简历下拉点击
        oLayer.find('#resumeSelectList_div_data span').each(function(){
            $(this).click(function(){
                oLayer.find('#rsmText').val($(this).text());
                oLayer.find('#rsmId').val($(this).attr('data-value'));
                tip(p_oData);
            });
        });

        //中英文下拉点击
        oLayer.find('#languageSelectList_div_data span').each(function(){
            $(this).click(function(){
                oLayer.find('#languageText').val($(this).text());
                oLayer.find('#cvLanguage').val($(this).attr('data-value'));
                tip(p_oData);
            });
        });

        //求职信下拉点击
        oLayer.find('#coverSelect_div_data span').each(function(){
            $(this).click(function(){
                oLayer.find('#coverText').val($(this).text());
                oLayer.find('#coverId').val($(this).attr('data-value'));
            });
        });

        //快速投递默认勾选
        var qPostCheck = oLayer.find('input:checkbox[name="qPostSet"]');
        qPostCheck.attr('checked', true);
        oLayer.find('#qPostSetEm').click(function() {
            $(this).find('em').toggleClass('on');
            if (qPostCheck.is(':checked'))
            {
                qPostCheck.attr('checked', false);
            }
            else
            {
                qPostCheck.attr('checked', true);
            }
        });


        //问号
        oLayer.find('#question').css({
            'background-image':'url("'+ sImagePath +'/im/2016/form/form.png")'
        });
        oLayer.find('#question').click(function(){
            window.open(window.cfg.domain.i + '/resume/help.php?lang=c&module=td');
        });

        oLayer.find('#resumeSelectList_div_data span:first').click();
        oLayer.find('#languageSelectList_div_data span:first').click();
        oLayer.find('#coverSelect_div_data span:first').click();
    }

    //简历弹层提示语动作
    function tip(p_oData)
    {
        var iResumeId = $('#rsmId').val();
        var iLan = $('#cvLanguage').val();

        var sTipContent = p_oData[iResumeId][iLan]['tip'];
        var url = p_oData[iResumeId][iLan]['url'];
        var iTipId = p_oData[iResumeId][iLan]['tipid'];

        $('#tips').empty();
        $('#tips').attr('tipid', '');

        $('#tips').append(sTipContent);
        $('#tips').find('a').click(function(){
            window.open(url);
        });
        $('#tips').attr('tipid', iTipId);
        if (iTipId == 2)
        {
            $('#apply_now').css('background-color','#818181').css('border','#818181');
        }
        else
        {
            $('#apply_now').css('background-color','#f56101').css('border','#f56101');
        }
        $('#tips').show();
    }

    //加载 弹层
    function loadingLayer()
    {
        var sContent = '<div id="loadingLayer">'
            +'<input type="hidden" class="layer_close" />'
            + '<p align="center"><img src="'+ sImagePath +'/im/2009/loading.gif"></p>'
            + '</div>';

        var oLayer = {
            layer:'loadingLayer',
            content:{html:sContent}
        };

        remindLayer(oLayer);
    }

    function windowOpen(url){
        var aHref = document.getElementById('aHref');
        if(aHref){
            aHref.href = url;
        }else{
            var aHref    = document.createElement('a');
            aHref.href   = url;
            aHref.target = '_blank';
            aHref.id     = 'aHref';
            document.body.appendChild(aHref);
        }
        aHref.click();
    }

    return {
        getJobStr:getJobStr,
        ajaxCallback:ajaxCallback,
        loadingLayer:loadingLayer,
        setPrd:setPrd,
        setPrp:setPrp,
        setImagePath:setImagePath,
        setCallback:setCallback
    }
}());