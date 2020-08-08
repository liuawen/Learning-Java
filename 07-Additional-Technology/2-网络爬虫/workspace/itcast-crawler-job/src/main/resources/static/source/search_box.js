$(document).ready(function(){
    //急招
    $(':input[name=keyword]').keydown(function(){
        $('#KwdSearchContent').hide();
    });

    //修正点击搜索类型搜索历史，不隐藏条件筛选下拉框
    var hidearr = {cotype : $('#cotype'), workyear : $('#workyear'), salary : $('#providesalary'),
        companysize : $('#companysize'), issuedate : $('#issuedate'), degree : $('#degreefrom'), jobterm : $('#jobterm'),
        keywordtype : $('#kwdTypeSel'), history : $('#searchHistory'), kwdsearchcontent : $('#KwdSearchContent'), kwdresult : $('#KwdSearchResult')};
    $('#showSearchHistory').click(function(e){
        //搜索历史取消
        $.each(hidearr, function(name, obj){
            obj.hide();
        });
        //$('#searchHistory').show();
        e.stopPropagation();
    });



    $('#kwdTypeSelUl').hover(function(e){
        $('#kwdTypeSelUl').addClass('on');
    },function(e){
        $('#kwdTypeSelUl').removeClass('on');
    });

    /** 首页的type选择 */
    $('#kwdType').hover(function(e){
        $.each(hidearr, function(name, obj){
            obj.hide();
        });
        $('#kwdType').css('background-color', 'white');
        $('#kwdType').parent().addClass('on');
        $('#kwdTypeSel').show();
        e.stopPropagation();
    },function(e){
        $('#kwdType').css('background-color', '#EFEFEF');
        $('#kwdType').parent().removeClass('on');
        $('#kwdTypeSel').hide();
    });

    $('#kwdTypeSel').hover(function(e){
        $('#kwdType').css('background-color', 'white');
        $('#kwdType').parent().addClass('on');
        $('#kwdTypeSel').show();
        e.stopPropagation();
    },function(e){
        $('#kwdType').css('background-color', '#EFEFEF');
        $('#kwdType').parent().removeClass('on');
        $('#kwdTypeSel').hide();
        e.stopPropagation();
    });

    $('#kwdType').click(function(e){
        $.each(hidearr, function(name, obj){
            obj.hide();
        });
        $('#kwdType').css('background-color', 'white');
        $('#kwdType').parent().addClass('on');
        $('#kwdTypeSel').show();
        e.stopPropagation();
    });
    /* end*/


    $(document).click(function(e){
        var evt = window.event || arguments.callee.caller.arguments[0]; // 获取event对象
        var src = evt.srcElement || evt.target; // 获取触发事件的源对象
        $.each(hidearr, function(name, obj){
            obj.hide();
        });
        if(src.id == 'kwdselectid' && $('#kwdselectid').val() == '') {
            $('#searchHistory').show();
        } else if(src.id == 'kwdselectid' && $('#kwdselectid').val() != '') {
            kwdSearch();
            // 每次搜索后重置kwdsearchresult选中index值
            document.getElementById('kwdselectid').setAttribute('vindex','-1');
            $('#KwdSearchResult').show();
        }
    });

    //点击此处隐藏搜索类型，搜索历史框
    var bindarr = {cotype : $('#cotype_trigger'), workyear : $('#workyear_trigger'), salary : $('#salary_trigger'),
        companysize : $('#companysize_trigger'), degree : $('#degree_trigger'), jobterm : $('#jobterm_trigger'),
        func : $('#select_expect_funtype'), indust : $('#select_expect_indtype'), jobchoose : $('#Jobareachoose')};

    $.each(bindarr, function(name, obj){
        obj.click(function(){
            $('#kwdTypeSel').hide();
            $('#searchHistory').hide();
            $('#KwdSearchContent').hide();
        });
    });

});

function clickStatistics(DOMAIN_SEARCH, sType) {
    $.ajax({
        type:"get",
        cache:false,
        url:DOMAIN_SEARCH + '/jobsearch/click_statistics.php?type='+ sType + '&referer=' + $('#statistics_referer').val() + '&ran=' + Math.random()
    });
}


/** 首页的type选择 */
function kwdtypeChange(kwdType)
{
    var typeInfo = {"1":"公司","2":"全文"};
    $('#kwdTypeSelUl').html('');
    $('#keywordtype').val(kwdType);
    $('#kwdType')[0].innerHTML = typeInfo[kwdType];
    $('#kwdTypeSel').hide();
    var content = '';
    for (type in typeInfo) {
        if(kwdType != type) {
            content = '<li><a href="javascript:void(0);" onclick="kwdtypeChange('+type+');">'+typeInfo[type]+'</a></li>';
            $('#kwdTypeSelUl').append(content);
        }
    }
    $('#kwdType').css('background-color', '#EFEFEF');
    $('#kwdType').parent().removeClass('on');
}

