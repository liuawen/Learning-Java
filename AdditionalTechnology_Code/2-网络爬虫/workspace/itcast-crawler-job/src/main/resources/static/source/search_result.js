$(document).ready(function() {

    $(window).scroll(function(){
        var offsetTop = 0;
        if($('.dw_tlc').eq(0).hasClass('fix')){
            offsetTop = $('#dw_tlc_mk').offset().top;
        }else{
            offsetTop = $('.dw_tlc').eq(0).offset().top;
        }

        if($(this).scrollTop() > offsetTop){
            if(!$('.dw_tlc').hasClass('fix')){
                $('#dw_tlc_mk').height($('.dw_tlc').eq(0).height()+2);
                $('.dw_tlc').eq(0).addClass('fix').hide();
                $('.dw_tlc.fix').fadeIn(500);
            }
            $("[event-type='13']").attr('event-type', 18);
            $("[event-type='14']").attr('event-type', 19);
        }else{
            $('#dw_tlc_mk').height(0);
            $('.dw_tlc').eq(0).removeClass('fix');
            $("[event-type='18']").attr('event-type', 13);
            $("[event-type='19']").attr('event-type', 14);
        }
    });

    $('.dw_filter .el .more').click(function(){//展示更多选项
        var $parent = $(this).parents('.el');
        if($parent.hasClass('on')){
            $parent.removeClass('on');
        }else{
            $parent.addClass('on');
        }
    });


    //搜索广告展示埋点
    if($("#search_company_ad").length > 0){
        var trackChangeParams = {
            cusParam: "1" + String.fromCharCode(22) + trackConfig.accountid + String.fromCharCode(22) + $.trim($("#kwdselectid").val()) + String.fromCharCode(22) + ($("#jobarea").val() == "000000" ? "" : $("#jobarea").val()) + String.fromCharCode(22) + $("#coad_companyid").val()
        };
        manualTrack("adShowManualTrack", trackChangeParams);
    }
    //名企关闭按钮
    $('.com_close').click(function(){
        $('.company').hide()
    })
});

$(document).mouseup(function() {
    $('.tSearch_select_list').find('.intPopbox').hide();
});


function search(keyword,redo) {
    var ind = '00';
    var fun = '0000';
    var jobarea = '000000';
    var specialarea = '00';
    var keywordtype = '2';
    var workyear = '99';
    var cotype = '99';
    var degreefrom = '99';
    var jobterm = '99';
    var companysize = '99';
    var providesalary = '99';
    var postchannel = '0000';
    var issuedate = '9';
    var lonlat = '0,0';
    var ord_field = '0';
    var dibiaoid = '0';
    var address = '';
    var line = '';
    var welfare = '';
    var radius = '-1';

    if ($('#indtype_code').length == 1 && $('#indtype_code').val() != '') ind = $('#indtype_code').val();
    if ($('#funtype_code').length == 1 && $('#funtype_code').val() != '') fun = $('#funtype_code').val();
    if ($('#jobarea').length == 1 && $('#jobarea').val() != '') jobarea = $('#jobarea').val();
    if ($('#keywordtype').length == 1 && $('#keywordtype').val() != '') keywordtype = $('#keywordtype').val();
    if (keyword == '') keyword = ' ';

    if (!redo){
        if ($('form[name=pageForm] input[name=keyword]').length == 1 && $.trim(keyword) == '') keyword = $('form[name=pageForm] input[name=keyword]').val();
        if (keyword == '') keyword = ' ';
        if ($('form[name=pageForm] input[name=cotype]').val() != '') cotype = $('form[name=pageForm] input[name=cotype]').val();
        if ($('form[name=pageForm] input[name=workyear]').val() != '') workyear = $('form[name=pageForm] input[name=workyear]').val();
        if ($('form[name=pageForm] input[name=providesalary]').val() != '') providesalary = $('form[name=pageForm] input[name=providesalary]').val();
        if ($('form[name=pageForm] input[name=companysize]').val() != '') companysize = $('form[name=pageForm] input[name=companysize]').val();
        if ($('form[name=pageForm] input[name=degreefrom]').val() != '') degreefrom = $('form[name=pageForm] input[name=degreefrom]').val();
        if ($('form[name=pageForm] input[name=jobterm]').val() != '') jobterm = $('form[name=pageForm] input[name=jobterm]').val();
        if ($('form[name=pageForm] input[name=issuedate]').val() != '') issuedate = $('form[name=pageForm] input[name=issuedate]').val();
        if ($('form[name=pageForm] input[name=lonlat]').val() != '') lonlat = $('form[name=pageForm] input[name=lonlat]').val();
        if ($('form[name=pageForm] input[name=ord_field]').val() != '') ord_field = $('form[name=pageForm] input[name=ord_field]').val();
        if ($('form[name=pageForm] input[name=dibiaoid]').val() != '') dibiaoid = $('form[name=pageForm] input[name=dibiaoid]').val();
        if ($('form[name=pageForm] input[name=address]').val() != '') address = $('form[name=pageForm] input[name=address]').val();
        if ($('form[name=pageForm] input[name=line]').val() != '') line = $('form[name=pageForm] input[name=line]').val();
        if ($('form[name=pageForm] input[name=welfare]').val() != '') welfare = $('form[name=pageForm] input[name=welfare]').val();
        if ($('form[name=pageForm] input[name=radius]').val() != '') radius = $('form[name=pageForm] input[name=radius]').val();
    }

    var url = window.cfg.domain.search + '/list/' + encodeURIComponent(encodeURIComponent(jobarea)) + ',000000,' + encodeURIComponent(encodeURIComponent(fun)) + ',' + encodeURIComponent(encodeURIComponent(ind)) + ',' + encodeURIComponent(encodeURIComponent(issuedate)) + ','+ encodeURIComponent(encodeURIComponent(providesalary)) +',' + encodeURIComponent(encodeURIComponent(keyword)) + ',' + encodeURIComponent(encodeURIComponent(keywordtype)) + ',1.html?lang=c&stype=&postchannel=' + postchannel + '&workyear=' + workyear + '&cotype=' + cotype + '&degreefrom=' + degreefrom + '&jobterm=' + jobterm + '&companysize=' + companysize + '&providesalary=' + providesalary +'&lonlat='+ encodeURIComponent(lonlat) +'&radius='+ encodeURIComponent(radius) +'&ord_field='+ ord_field +'&confirmdate=9&fromType=&dibiaoid='+ dibiaoid +'&address='+ encodeURIComponent(address) +'&line='+ encodeURIComponent(line) +'&specialarea='+ specialarea +'&from=&welfare='+encodeURIComponent(welfare);
    window.location = url;
}

function excludeword()
{
    if ($.trim($(':input[name=excludekeyword]').val()) == "") {//未填写内容不做关键词处理
        search($(':input[name=keyword]').val(),0);
        return false;
    }
    var val = $(':input[name=excludekeyword]').val().replace( /[^\u3040-\u318f\u3100-\u312f\u3040-\u309F\u30A0-\u30FF\u31F0-\u31FF\u3300-\u337f\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff\uff65-\uff9fa-zA-Z0-9@#$%&+']+/g , ' ' ).trim();
    var keyword = '';
    if ( val ) {
        keyword = $(':input[name=keyword]').val() + ( ' ' + val ).replace( / +/g , ' -' );
    }
    search(keyword,0);
}



function collapseExpansionJobareaLine(id, element) {
    var config = {
        'show': {
            'add': 'show_line',
            'remove': 'hide_line',
            'html': '收起'
        },
        'hide': {
            'add': 'hide_line',
            'remove': 'show_line',
            'html': '更多'
        }
    }

    if ($('#' + id).hasClass(config.show.add)) {
        $('#' + id).addClass(config.hide.add);
        $('#' + id).removeClass(config.hide.remove);
        $(element).html(config.hide.html);
    } else {
        $('#' + id).addClass(config.show.add);
        $('#' + id).removeClass(config.show.remove);
        $(element).html(config.show.html);
    }
}


function showLine(DOMAIN_SEARCH, lineNum, element) {

    var urlEncode = window.encodeURIComponent || window.escape;


    if (0 == $('#station_' + lineNum).length) {
        var list = {
            'jobarea': '',
            'district': '',
            'funtype': '',
            'industrytype': '',
            'issuedate': '',
            'providesalary': '',
            'keyword': '',
            'keywordtype': '',
            'postchannel': '',
            'workyear': '',
            'cotype': '',
            'degreefrom': '',
            'jobterm': '',
            'companysize': '',
            'address': '',
            'line': '',
            'ord_field': '',
            'from': '',
            'line_now': '',//当前line,用与get_line.php判断
            'welfare': ''
        };

        $.each(list, function (i, value) {
            var formValue = $('[name="pageForm"] [name="' + i + '"]').val();

            switch (i) {
                case 'jobarea':
                    var formAreaList = jobarea = '';
                    if (-1 != formValue.indexOf(',')) {
                        formAreaList = formValue.split(',');
                        jobarea      = formAreaList[0];
                    } else {
                        jobarea      = formValue;
                    }

                    list[i] = jobarea;
                    break;

                case 'line':
                    list[i] = $(element).html();
                    break;

                case 'line_now':
                    list[i] = $('[name="pageForm"] [name="line"]').val();
                    break;

                default:
                    list[i] = formValue;
                    break;
            }
        });

        var actionUrl = DOMAIN_SEARCH + '/jobsearch/ajax/get_line.php?rand='+ Math.random() + '&jsoncallback=?';

        $.getJSON(actionUrl, list, function (data) {
            if ('' != data.data) {
                $('.nk').hide();
                $(element).addClass('dw_c_orange');

                $.each($(element).siblings(), function () {
                    $(this).removeClass('dw_c_orange');
                });

                $('#filter_p_line').after(data.data);
            }
        });
    }


    if ($('#station_' + lineNum).is(':hidden')) {
        $.each($('.nk'), function () {
            $(this).hide();
        });
        $('#station_' + lineNum).show();
        $(element).addClass('dw_c_orange');

        $.each($(element).siblings(), function () {
            $(this).removeClass('dw_c_orange');
        });
    }
}

function showDibiao(DOMAIN_SEARCH, districtNum, element) {

    var urlEncode = window.encodeURIComponent || window.escape;

    if (0 == $('#hotdibiao_' + $('[name="pageForm"] [name="jobarea"]').val().substr(0, 6) + '_' + districtNum).length) {
        var list = {
            'jobarea': '',
            'district': '',
            'funtype': '',
            'industrytype': '',
            'issuedate': '',
            'providesalary': '',
            'keyword': '',
            'keywordtype': '',
            'postchannel': '',
            'workyear': '',
            'cotype': '',
            'degreefrom': '',
            'jobterm': '',
            'companysize': '',
            'address': '',
            'line': '',
            'ord_field': '',
            'dibiaoid': '',
            'from': '',
            'district_now': '',//用于判断当前地标是否是热门地标
            'welfare': ''
        };

        $.each(list, function (i, value) {
            var formValue = $('[name="pageForm"] [name="' + i + '"]').val();

            switch (i) {
                case 'jobarea':
                    var formAreaList = jobarea = '';
                    if (-1 != formValue.indexOf(',')) {
                        formAreaList = formValue.split(',');
                        jobarea      = formAreaList[0];
                    } else {
                        jobarea      = formValue;
                    }

                    list[i] = jobarea;
                    break;

                case 'district':
                    list[i] = districtNum;
                    break;

                case 'district_now':
                    list[i] = $('[name=pageForm] [name=district]').val();
                    break;
                default:
                    list[i] = formValue;
                    break;
            }
        });

        var actionUrl = DOMAIN_SEARCH + '/jobsearch/ajax/get_districtdibiao.php?rand='+ Math.random() + '&jsoncallback=?';

        $.getJSON(actionUrl, list, function (data) {
            if ('' != data.data) {
                $('.nk').hide();
                $(element).addClass('dw_c_orange');

                $.each($(element).siblings(), function () {
                    $(this).removeClass('dw_c_orange');
                });

                $('#filter_p_line').after(data.data);
            }
        });
    }

    $.each($('.nk'), function () {
        $(this).hide();
    });

    $(element).addClass('dw_c_orange');
    $.each($(element).siblings(), function () {
        $(this).removeClass('dw_c_orange');
    });
    $('#hotdibiao_' + $('[name="pageForm"] [name="jobarea"]').val().substr(0, 6) + '_' + districtNum).show();
}


function collapseExpansion(DOMAIN_SEARCH, type, collapse) {
    $.ajax({
        type:"get",
        cache:false,
        url:DOMAIN_SEARCH + '/jobsearch/ajax/collapse_expansion.php?collapse=' + collapse + '&type='+ type + '&ran=' + Math.random()
    });
}

function showHotdibiaoid(element) {
    $('.nk').hide();
    $('#filter_p_dibiaoid').show();
    $.each($(element).siblings(), function () {
        $(this).removeClass('dw_c_orange');
    });
    $(element).addClass('dw_c_orange')
}
var filter_clicked_now;
function showFilterOther(id, obj) {
    $('#otherFilter li').removeClass('on');
    if (filter_clicked_now == obj) {
        $('.kel').hide();
        filter_clicked_now = null;
        return false;
    }
    $(obj).addClass('on');
    var objs = ['filter_p_jobterm', 'filter_p_keyword', 'filter_p_jobarea', 'filter_p_dibiaoid', 'filter_p_line'];
    if ($('#'+ id).is(':hidden')) {
        $.each(objs, function(i, n) {
            $('#'+ n).hide();
        });
        $('#'+ id).show();
    } else {
        $('#'+ id).hide();
    }
    $('.nk').hide();
    $('.kel').show();
    filter_clicked_now = obj;
}

function collapseExpansionSearch(DOMAIN_SEARCH, className, element) {
    var that = $(element);
    var element = $('.' + className);
    if (element.hasClass('on')) {  //收起
        that.find('span').html("展开选项（公司性质、公司规模、工作年限等）<em class='dicon Dm'></em>");
        element.removeClass('on');
        $('#otherFilter li').removeClass('on');
        $('.kel').hide();
        collapseExpansion(DOMAIN_SEARCH, 9, 0);
        /* 收起其他筛选 */
        var objs = ['filter_p_jobterm', 'filter_p_keyword', 'filter_p_jobarea', 'filter_p_dibiaoid', 'filter_p_line'];
        $.each(objs, function(i, n) {
            $('#'+ n).hide();
        });
        $('.nk').hide();
    } else {  //展开
        that.find('span').html("收起选项<em class='dicon Dm'></em>");
        element.addClass('on');
        collapseExpansion(DOMAIN_SEARCH, 10, 1);
    }
}

function selectAllJobs(element) {
    if ($(element).hasClass('on')) {
        $('#top_select_all_jobs_checkbox,#bottom_select_all_jobs_checkbox').removeClass('on');
        $("em[name='delivery_em']").removeClass("on");
        $("input[name='delivery_jobid']").attr("checked", false);
        $("div.op span.but_sq,div.op span.but_sc").addClass("uck");
    }
    else{
        $('#top_select_all_jobs_checkbox,#bottom_select_all_jobs_checkbox').addClass('on');
        $("em[name='delivery_em']").addClass("on");
        $("input[name='delivery_jobid']").attr("checked", true);
        $("div.op span.but_sq,div.op span.but_sc").removeClass("uck");
    }
}


function showStatistics(type) {
    var e = window.event || arguments.callee.caller.arguments[0]; // 获取event对象

    if ($('#' + type).is(':hidden')) {
        $('#' + type).show();

        $.each($('#' + type).parent().siblings(), function (index, value) {
            $(this).find('.intPopbox').hide();
        });
    } else {
        $('#' + type).hide();
    }

    if (e.stopPropagation) {
        // this code is for Mozilla and Opera
        e.stopPropagation();
    } else if (window.event) {
        // this code is for IE
        window.event.cancelBubble = true;
    }
}




function multipleChoiceShow(sType, bShow)
{
    if(bShow)
    {
        $("div[id^='filter_']").removeAttr("style");
        $('#filter_' + sType).hide();
        $("div[id^='multichoices_']").hide();
        $("#submit_" + sType).removeClass('unclick');
        $('#multichoices_' + sType).show();
        $("#multichoices_" + sType).find('div.err').hide();
    }
    else
    {
        $("div[id^='multichoices_']").hide();
        $('#multichoices_' + sType).find('li.on').removeClass('on');
        $('#multichoices_' + sType).find("li[name='defaultmultichoices']").addClass('on');
        $('#filter_' + sType).removeAttr("style");
    }
}


function checkMultipleChoice(oThis, sType)
{
    if($(oThis).hasClass('on'))
    {
        $("#multichoices_" + sType).find('div.err').hide();
        $(oThis).removeClass("on");
        if($("#multichoices_" + sType).find("li.on").length == 0)
        {
            $("#submit_" + sType).addClass('unclick');
            return;
        }
    }
    else
    {
        if($(oThis).attr('data-value') == '99')
        {
            $(oThis).siblings().removeClass("on");
            $(oThis).addClass('on');
        }
        else
        {
            $(oThis).siblings("li[data-value='99']").removeClass('on');
        }

        $("#submit_" + sType).removeClass('unclick');
        if($("#multichoices_" + sType).find("li.on").length >= 5)
        {
            $("#multichoices_" + sType).find('div.err').show();
            return;
        }
        else
        {
            $("#multichoices_" + sType).find('div.err').hide();
            $(oThis).addClass("on");
        }
    }
}

function submitMultiChoices(sType)
{
    if(!$("#submit_" + sType).hasClass("unclick"))
    {
        var aResult = [];
        $("#multichoices_" + sType).find("li.on").each(function(){
            aResult.push($(this).attr("data-value"));
        });

        if(aResult == []){
            sResult = '99';
        }
        else{
            sResult = aResult.join(",");
        }

        $('#' + sType).val(sResult);
        $(document.getElementsByName('pageForm')).submit();
    }
}

function jumpPage(totalPage)
{
    var jumpPage = parseInt($('#jump_page').val());

    if (jumpPage > 0 && jumpPage <= totalPage) {
        window.location.href = $('form[name=pageForm] input[name=pagejump]').val().replace('<<pagecode>>',jumpPage);
    } else {
        alert('请输入正确的页码');
    }
}


function jobview(jobid) {
    var win = window;
    var n = '_job_img_' + (+new Date()) + '.r' + Math.floor(Math.random() * 1000),
        img = win[n] = new Image();
    img.onload = img.onerror = function () {
        win[n] = null;
    };

    img.src = window.cfg.domain.search + '/jobsearch/jobview.php?jobiduni=' + jobid + '&' + Math.random();
}