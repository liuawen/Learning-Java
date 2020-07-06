var ERR_ICON = '<i class="inpPromptIcon"></i> ';
function QuickApply(jobid, isEnglish,My_Domain,btnId )
{
    var old_jobid = jobid;
    if(jobid==1){
        var chxs = document.getElementsByTagName( 'input' );
        var jobids = [];
        var j=0;
        for ( var i = 0 ; i < chxs.length ; i++ ) {
            if ( /^selectJobid/.test( chxs[i].name ) && chxs[i].checked  ) {
                jobids[j]=chxs[i].name.substr(11,chxs[i].name.length-11);
                j++;
            }
        }
        if(jobids.length==0){
            alert("请在要选择的职位前打勾！");
            return ;
        }
        jobid=jobids[0];
        for ( var i = 1 ; i < jobids.length ; i++ ) {
            jobid+=","+jobids[i];
        }
    }
    if(jobid==2){
        var inputs = document.getElementsByTagName( 'input' );
        var jobids = [];
        var j=0;
        for(var i=0;i < inputs.length;i++){
            if(inputs[i].id =='jobid[]' && inputs[i].checked==true){
                jobids[j] = inputs[i].value;
                j++;
            }
        }
        if(jobids.length==0){
            alert("请在要选择的职位前打勾！");
            return ;
        }
        jobid=jobids[0];
        for ( var i = 1 ; i < jobids.length ; i++ ) {
            jobid+=","+jobids[i];
        }
    }
    ShowWaitImage();
    jobid = '('+jobid+')';
    if(isEnglish == 'c')
    {
        islang = 0;
    }
    else
    {
        islang = 1;
    }

    var url = My_Domain+"/cv/CV_Login.php?isEnglish="+islang+"&"+Math.random()+"&jsoncallback=?";
    $.getJSON( url, {jobid:jobid} , function(result){
        if(result.return_type == 'nologin'){
            apply.close();
            var lang = $("#top_login_language").val();
            if(lang == "en"){
                var language = "EN";
            }else{
                var language = "CN";
                if(old_jobid > 2 && result.job_type == 'grassroot')
                {
                    window.isGr = true;
                    window.jobid = old_jobid;
                }
            }
            var isreport = result.isreport;
            var callback = function(){
                QuickApply(old_jobid, isEnglish,My_Domain,btnId );
            };
            ShowPassportLayer(language,callback);
        }else if(result.return_type == 'special'){
            apply.close();
            //window.open(result.return_content);
            window.location.href = result.return_content;
        }else if (result.return_type == 'special3')
        {
            MyApply3(jobid, isEnglish,My_Domain,btnId);
        }else{
            MyApply2(jobid, isEnglish,My_Domain,btnId);
        }
    });
}
function MyApply2(jobid, isEnglish,My_Domain,btnId){
    if(isEnglish == 'e'){
        var action_url = My_Domain+"/cv/EResume/CV_EQuickApply.php?";
    }else{
        var action_url = My_Domain+"/cv/CResume/CV_CQuickApply.php?";
    }
    action_url += Math.random()+"&jsoncallback=?";
    if(jobid.substr(0,1)!='(' && jobid.substr(jobid.length-1,1)!=')'){
        jobid='('+jobid+')';
    }
    ShowWaitImage();
    $.getJSON( action_url, {jobid : jobid } , function(result){
        switch(result.return_type){
            case 'createGrassRootsRsm':
                if(window.apply){
                    apply.close();
                }
                var cfg = window.cfg;
                if ( !window.apply ) {
                    var Param = {
                        openType: 2 ,
                        divProps: { style : { zIndex : 1007 } } ,
                        filterParam: {},
                        afterClose: function(){
                            if(window.grRsmjobAreaLayer){
                                window.grRsmjobAreaLayer.close();
                            }
                            if(window.grRsmFuntypeLayer){
                                window.grRsmFuntypeLayer.close();
                            }
                        }
                    };
                    window.apply = new ExtZzLayer( Param );
                }
                window.apply.setContent( result.return_content );
                window.apply.setCloseNode( 'grRsm_close' );
                window.apply.open();

                //绑定各个下拉单和选择层
                bandGrassRootResumeInput();
                break;
            case 'createMRsm':
                if(window.apply){
                    apply.close();
                }
                var cfg = window.cfg;
                if ( !window.microResume ) {
                    var Param = {
                        openType: 2 ,
                        divProps: { style : { zIndex : 1007 } } ,
                        filterParam: {},
                        afterClose: function(){
                            if(window.jobAreaLayer){
                                window.jobAreaLayer.close();
                            }
                            if(window.lowFuntypeLayer){
                                window.lowFuntypeLayer.close();
                            }
                        }
                    };
                    window.microResume = new ExtZzLayer( Param );
                }
                microResume.setContent( result.return_content );
                microResume.setCloseNode( 'mResume_close' );
                microResume.setCloseNode( 'mResume_confirm' );

                var param = {
                    divProps: { style : { zIndex : 1007 } } ,
                    cfg : cfg ,
                    openNodes : 'btnSelectArea' ,
                    _textNodes :'btnSelectArea' ,
                    _valueNodes : 'selectAreaVal' ,
                    isMulty : false,
                    isHasNolimit : false,
                    noShowSpArea : true,
                    showPvnCityDistrict : true,
                    extData : ja_new,
                    afterOpen : function(){
                        $("#sex").css({'visibility':'hidden'});
                        $("#YearOfBirthday").css({'visibility':'hidden'});
                        $("#MonthOfBirthday").css({'visibility':'hidden'});
                        $("#DayOfBirthday").css({'visibility':'hidden'});
                    },
                    afterClose : function(){
                        $("#sex").css({'visibility':''});
                        $("#YearOfBirthday").css({'visibility':''});
                        $("#MonthOfBirthday").css({'visibility':''});
                        $("#DayOfBirthday").css({'visibility':''});
                    }
                };
                window.jobAreaLayer = new JobareaLayer( param );

                var functype = document.getElementById('selectFuncVal').value;
                if(typeof(lft[functype]) == 'undefined'){
                    document.getElementById('selectFuncVal').value = '';
                }
                var param = {
                    divProps: { style : { zIndex : 1007 } } ,
                    cfg : cfg ,
                    openNodes : 'btnSelectFunc' ,
                    _textNodes : 'btnSelectFunc' ,
                    _valueNodes :  'selectFuncVal' ,
                    isMulty : false,
                    isHasNolimit : false,
                    selValues :  [document.getElementById('selectFuncVal').value],
                    afterOpen : function(){
                        $("#sex").css({'visibility':'hidden'});
                        $("#YearOfBirthday").css({'visibility':'hidden'});
                        $("#MonthOfBirthday").css({'visibility':'hidden'});
                        $("#DayOfBirthday").css({'visibility':'hidden'});
                    },
                    afterClose : function(){
                        $("#sex").css({'visibility':''});
                        $("#YearOfBirthday").css({'visibility':''});
                        $("#MonthOfBirthday").css({'visibility':''});
                        $("#DayOfBirthday").css({'visibility':''});
                    }
                };
                window.lowFuntypeLayer = new LowFuntypeLayer( param );

                microResume.open();
                break;
            case 'editMRsm':
                if(window.apply){
                    apply.close();
                }
                var cfg = window.cfg;
                if ( !window.microResume ) {
                    var Param = {
                        openType: 2 ,
                        divProps: { style : { zIndex : 1007 } } ,
                        filterParam: {},
                        afterClose: function(){
                            if(window.jobAreaLayer){
                                window.jobAreaLayer.close();
                            }
                            if(window.lowFuntypeLayer){
                                window.lowFuntypeLayer.close();
                            }
                        }
                    };
                    window.microResume = new ExtZzLayer( Param );
                }
                microResume.setContent( result.return_content );
                microResume.setCloseNode( 'mResume_close' );
                microResume.setCloseNode( 'mResume_confirm' );
                str_limit(document.getElementById('selfIntro').value,'inputNum');

                var param = {
                    divProps: { style : { zIndex : 1007 } } ,
                    cfg : cfg ,
                    openNodes : 'btnSelectArea' ,
                    _textNodes :'btnSelectArea' ,
                    _valueNodes : 'selectAreaVal' ,
                    isMulty : false,
                    isHasNolimit : false,
                    extData : ja_new
                };
                window.jobAreaLayer = new JobareaLayer( param );

                var functype = document.getElementById('selectFuncVal').value;
                var param = {
                    divProps: { style : { zIndex : 1007 } } ,
                    cfg : cfg ,
                    openNodes : 'btnSelectFunc' ,
                    _textNodes : 'btnSelectFunc' ,
                    _valueNodes :  'selectFuncVal' ,
                    isMulty : false,
                    isHasNolimit : false,
                    selValues :  [document.getElementById('selectFuncVal').value]
                };
                window.lowFuntypeLayer = new LowFuntypeLayer( param );

                microResume.open();
                break;
            case 'nojob':
            case 'unqpost':
                ShowLayer(result.return_content);
                //ie placeholder
                $('input').placeholder();
                //关闭下拉弹层
                $(document).click(function(){
                    $('.select_layer').hide();
                    jQuery.layer.fixIEBug(jQuery.selectLayer.currentSettings.oLayerSettings, true);
                });
                //绑定简历下拉单
                if(typeof(result.resumeSelectList) == 'string' && result.resumeSelectList.length > 0){
                    $('#resumeSelectList_div').dropDownListLayer({
                        'id': 'rsmText',
                        'div_id':'resumeSelectList_div',
                        'code_id':'rsmid',
                        'layer_id':'resumeSelectList_layer',
                        'data_init_data':eval(result.resumeSelectList),
                        'after_close':function(){
                            checkSelectedResume($('#rsmid').val());
                        }
                    });
                }
                //绑定简历语言下拉单
                if(typeof(result.languageSelectList) == 'string' && result.languageSelectList.length > 0)
                {
                    $('#languageSelectList_div').dropDownListLayer({
                        'id': 'languageText',
                        'div_id':'languageSelectList_div',
                        'code_id':'cvlanguage',
                        'layer_id':'languageSelectList_layer',
                        'data_init_data':eval(result.languageSelectList),
                        'after_close':function(){
                            checkSelectedLanguage($('#cvlanguage').val());
                        }
                    });
                }
                //绑定求职信下拉单
                if(typeof(result.coverSelectList) == 'string' && result.coverSelectList.length > 0)
                {
                    $('#coverSelect_div').dropDownListLayer({
                        'id': 'coverText',
                        'div_id':'coverSelect_div',
                        'code_id':'coverid',
                        'layer_id':'coverSelect_layer',
                        'data_init_data':eval(result.coverSelectList),
                        'after_close':function(){}
                    });
                }

                break;
            case 'noresume':
            case 'nocompleted':
            case 'resume_confirm':
                apply.close();
                windowHref(result.return_content);
                break;
            case 'nologin':
                alert('请先登录！');
                return false;
                break;
            case 'completes':
                apply.close();
                alert('您只能有一份默认简历,请修改!');
                windowHref(My_Domain+'/cv/CResume/CV_CResumeManage.php');
                break;
            case 'quncompleted':
                apply.close();
                alert('您设置的直接发送的简历个人信息不完整，请先去完善简历.');
                windowHref(result.return_content);
                break;
            case 'qapplied':
                apply.close();
                if(result.return_content == ""){
                    alert('您的申请中包含已经申请过的职位，一周之内无法重复申请。');
                    return ;
                }
                break;
            case 'qapplied2':
                apply.close();
                overdued = confirm('您的申请中包含已经申请过的职位，一周之内无法重复申请。');
                if(overdued == false ){
                    return;
                }
                ShowLoading();
                pos1 = result.return_content.indexOf("-");
                jobiduni =  result.return_content.substr(0,pos1);
                url = result.return_content.substr(pos1+1);
                var action_url = url+"&jsoncallback=?";
                $.getJSON( action_url, {jobiduni:jobiduni} , function(result){
                    MyApply(result.return_type,result.return_content);
                });
                break;
            case 'success':
                ShowLoading();
                pos1 = result.return_content.indexOf("-");
                jobiduni =  result.return_content.substr(0,pos1);
                url = result.return_content.substr(pos1+1);
                var action_url = url+"&jsoncallback=?";
                $.getJSON( action_url, {jobiduni:jobiduni} , function(result){
                    MyApply(result.return_type,result.return_content);
                });
                break;
        }
    });
}

function MyApply3(jobid, isEnglish,My_Domain,btnId)
{
    if(isEnglish == 'c')
    {
        isEnglish = 0;
    }else if(isEnglish == 'e')
    {
        isEnglish = 1;
    }
    var action_url = My_Domain+"/cv/CResume/CV_PostToInbox.php?";

    action_url += Math.random()+"&jsoncallback=?";
    if(jobid.substr(0,1)!='(' && jobid.substr(jobid.length-1,1)!=')')
    {
        jobid='('+jobid+')';
    }
    ShowWaitImage();
    $.getJSON( action_url, {jobid : jobid,isEnglish:isEnglish} , function(result)
    {
        switch(result.return_type)
        {
            case 'nojob':
            case 'selectrsm':
            case 'success':
                ShowLayer(result.return_content);
                //ie placeholder
                $('input').placeholder();
                //关闭下拉弹层
                $(document).click(function(){
                    $('.select_layer').hide();
                    jQuery.layer.fixIEBug(jQuery.selectLayer.currentSettings.oLayerSettings, true);
                });
                //绑定简历下拉单
                if(typeof(result.resumeSelectList) == 'string' && result.resumeSelectList.length > 0){
                    $('#resumeSelectList_div').dropDownListLayer({
                        'id': 'rsmText',
                        'div_id':'resumeSelectList_div',
                        'code_id':'rsmid',
                        'layer_id':'resumeSelectList_layer',
                        'data_init_data':eval(result.resumeSelectList),
                        'after_close':function(){
                            checkSelectedResume($('#rsmid').val());
                        }
                    });
                }
                //绑定简历语言下拉单
                if(typeof(result.languageSelectList) == 'string' && result.languageSelectList.length > 0)
                {
                    $('#languageSelectList_div').dropDownListLayer({
                        'id': 'languageText',
                        'div_id':'languageSelectList_div',
                        'code_id':'cvlanguage',
                        'layer_id':'languageSelectList_layer',
                        'data_init_data':eval(result.languageSelectList),
                        'after_close':function(){
                            checkSelectedLanguage($('#cvlanguage').val());
                        }
                    });
                }
                //绑定求职信下拉单
                if(typeof(result.coverSelectList) == 'string' && result.coverSelectList.length > 0)
                {
                    $('#coverSelect_div').dropDownListLayer({
                        'id': 'coverText',
                        'div_id':'coverSelect_div',
                        'code_id':'coverid',
                        'layer_id':'coverSelect_layer',
                        'data_init_data':eval(result.coverSelectList),
                        'after_close':function(){}
                    });
                }
                break;
            case 'nologin':
                apply.close();
                alert('请先登录！');
                break;
            case 'jumptocom':
            case 'nocomplete':
                window.location.href=result.return_content;
                break;
            case 'appjob_cftd':
                alert('您的申请中包含已经申请过的职位，一周之内无法重复申请。');
                apply.close();
                break;
            default:
                apply.close();
        }
    });
}


function EditCVLetter(DOMAIN_MY,isenglish)
{
    if($("#coverid").val()!="0"){
        document.Qpost_Set_Form.CVLID.value = $("#coverid").val();
        document.Qpost_Set_Form.Read.value = 2;
        if(isenglish == 1){
            url = DOMAIN_MY + "/cv/EResume/CV_ELetter.php?#mark";
        }else{
            url = DOMAIN_MY + "/cv/CResume/CV_CLetter.php?#mark";
        }
        document.Qpost_Set_Form.target="_blank";
        document.Qpost_Set_Form.action=url;
        document.Qpost_Set_Form.submit();
    }
}
function EditResume(DOMAIN_I,rand)
{
    cvid= $("#rsmid").val();
    var objclang = $("#C_STAR_"+cvid).val();
    var objelang = $("#E_STAR_"+cvid).val();
    lan = $("#cvlanguage").val();
    var aResumeTypeList = $('#resume_type_list').val().split(';');
    var sResumeType = '';

    $.each(aResumeTypeList, function (i, value) {
        var aValue = value.split(':');
        if (aValue[0] == cvid)
        {
            sResumeType = aValue[1];

            return false;
        }
    });

    if(objelang< 3 &&  (lan == 1 || lan == 2)){
        switch (sResumeType)
        {
            case '9':
                url = DOMAIN_I +'/resume/paste_resume.php?lang=e&resumeid='+cvid+'&'+rand;
                break;

            default:
                url = DOMAIN_I +'/resume/standard_resume.php?lang=e&resumeid='+cvid+'&'+rand;
                break;
        }
    }

    if(objclang< 3 && (lan == 0 || lan == 2) ){
        switch (sResumeType)
        {
            case '9':
                url = DOMAIN_I +'/resume/paste_resume.php?lang=c&resumeid='+cvid+'&'+rand;
                break;

            default:
                url = DOMAIN_I +'/resume/standard_resume.php?lang=c&resumeid='+cvid+'&'+rand;
                break;
        }
    }


    document.Qpost_Set_Form.target="_blank";
    document.Qpost_Set_Form.action=url;
    document.Qpost_Set_Form.submit();
}
function prv(DOMAIN_MY,rand,isenglish)
{
    var obj=document.getElementById('completeflag');
    if(obj.value == '0'){
        alert("您选择的简历不完整，将不能投递，请完善后再投递。");
        return;
    }
    if(checkApply()){
        hasOverdue(DOMAIN_MY,'2');
    }
}
function send(DOMAIN_MY,rand,isenglish,flag){
    //document.getElementById("apply_now").onclick=function(){};
    var jobid = $("#jobiduni").val();
    var completeflag = document.getElementById('completeflag').value;
    if( completeflag == '0'){
        alert("您选择的简历不完整，将不能投递，请完善后再投递。");
        document.getElementById("apply_now").onclick=function(){ send(DOMAIN_MY,rand,0)};
        return;
    }
    if(checkApply()){
        /*如果是基础职位且选择的中文简历没有关键字，弹出关键字设置浮层*/
        var showRsmKeyNotice = $("#showRsmKeyNotice").val();
        var cvlanguage = $("#cvlanguage").val();
        var rkcomplate = $("#Rk_"+$("#CheckedResume").val()).val();
        var qpostset = $('input[name="qpostset"]:checked').val();
        var coverid = 0;
        if($("#coverid").length > 0)
        {
            coverid = $("#coverid").val();
        }
        if(typeof(qpostset) != 'undefined')
        {
            qpostset = 1;
        }else
        {
            qpostset = 0;
        }
        if(showRsmKeyNotice == 1 && cvlanguage == 0 && rkcomplate == 0)
        {
            action_url = DOMAIN_MY + '/cv/CResume/CV_ShowResumeKey.php?jsoncallback=?&r='+Math.random();
            $.getJSON(action_url,{jobid:jobid,rsmid:$("#CheckedResume").val(),qpostset:qpostset,coverid:coverid},function(data){
                ShowLayer(data.return_content);
            });
            return false;
        }

        if( arguments.length == 4 && arguments[3] == 1)
        {
            var url  = DOMAIN_MY+'/sc/applyjob/applyjob.php?'+Math.random()+'&isEN='+isenglish+'&rsmid='+document.getElementById("rsmid").value;
            var action_url = url+"&jsoncallback=?";
            var str = $('#Qpost_Set_Form').serialize();
            ShowLoading();
            $.getJSON( action_url, str , function(result)
            {
                if(result.return_type == 'jumptocom')
                {
                    window.location.href = result.return_content;
                }else if(result.return_type == 'nojumpurl')
                {
                    ShowLayer(result.return_content);
                    setTimeoutCloseMemo();
                    if ( $("#app_ck").length > 0 ) {
                        $("#app_ck").attr("href","#").attr("class","but_sq off").removeAttr("onclick");
                        $('#app_ck').html('<img width="22" height="22" src="http://img01.51jobcdn.com/im/jobs/but_img_sq_2.png" alt="" />已申请');
                    }
                }else
                {
                    if( window.apply )
                    {
                        apply.close();
                    }
                    alert('您的申请中包含已经申请过的职位，一周之内无法重复申请。');
                }
            });
        }else
        {
            hasOverdue(DOMAIN_MY,'1');
        }
    }else{
        if( arguments.length == 4 && arguments[0] == 1)
        {
            document.getElementById("apply_now").onclick=function(){ send(DOMAIN_MY,rand,0,flag)};
        }else
        {
            document.getElementById("apply_now").onclick=function(){ send(DOMAIN_MY,rand,0)};
        }
    }
}

function checkSelectedResume(id){
    var objc=document.getElementById('CBase_' + id);
    var obje=document.getElementById('EBase_' + id);
    cvid= $("#rsmid").val();
    document.Qpost_Set_Form.CheckedResume.value=cvid;
    if(objc.value==2 || obje.value==2){
        document.Qpost_Set_Form.completeflag.value=1;
    }else{
        document.Qpost_Set_Form.completeflag.value=0;
    }
    showNoticeMsg();
}
function showNoticeMsg(){
    var lan = $("#cvlanguage").val();
    var id = document.Qpost_Set_Form.CheckedResume.value;
    var objc=document.getElementById('CBase_' + id);
    var obje=document.getElementById('EBase_' + id);

    var objclang = $("#C_STAR_"+id).val();
    var objelang = $("#E_STAR_"+id).val();

    var noapplystr = '您选择的简历不完整，将不能投递，请完善后再投递。';
    var nocomplatestr1 = '此简历的星级较低，';
    var nocomplatestr2 = '建议完整后再投递，完整简历是求职的必要条件哦。';

    if(lan ==0 ){
        if(objc.value!=2){
            $("#tips").show();
            $("#tips span").html(noapplystr);
        }else{
            if(objclang < 3)
            {
                $("#tips").show();
                $("#tips span").html(nocomplatestr1  + nocomplatestr2);
            }
            else
            {
                $("#tips").hide();
            }
        }
    }
    if(lan ==1){
        if(obje.value!=2){
            $("#tips").show();
            $("#tips span").html(noapplystr);
        }else{
            if(objelang < 3)
            {
                $("#tips").show();
                $("#tips span").html(nocomplatestr1 + nocomplatestr2);
            }
            else
            {
                $("#tips").hide();
            }
        }
    }
    if(lan ==2){
        if(obje.value!=2 || objc.value!=2){
            $("#tips").show();
            $("#tips span").html(noapplystr);
        }else{
            if(objclang < 3 || objelang < 3)
            {
                $("#tips").show();
                $("#tips span").html(nocomplatestr1 + nocomplatestr2);
            }
            else
            {
                $("#tips").hide();
            }
        }
    }
}
function checkSelectedLanguage(code){
    switch(code){
        case '0':
            document.Qpost_Set_Form.CnResume.value=1;
            document.Qpost_Set_Form.EnResume.value=0;
            break;
        case '1':
            document.Qpost_Set_Form.CnResume.value=0;
            document.Qpost_Set_Form.EnResume.value=1;
            break;
        case '2':
            document.Qpost_Set_Form.CnResume.value=1;
            document.Qpost_Set_Form.EnResume.value=1;
            break;
    }
    showNoticeMsg();
}

function hasOverdue(DOMAIN_MY,flag){
    var rand = Math.random();
    var jobiduni = $("#jobiduni").val();
    var Url =DOMAIN_MY+"/sc/overdue.php?uid="+ document.getElementById('accid').value+"&rsmid="+document.getElementById("CheckedResume").value+ '&ran=' + rand+"&isEnglish=0&jsoncallback=?";
    $.ajax({
        type: "GET",
        url: Url,
        contentType: "application/json",
        dataType: "json",
        async:false,
        data: {jobid:  jobiduni },
        success: function(json) {
            if ( json ){
                if(json.return_type == 'nologin'){
                    alert('请先登录！');
                    document.getElementById("apply_now").onclick=function(){ send(DOMAIN_MY,rand,0)};
                    return false;
                }else if( json.return_type == 'wrongresume'){
                    window.location.href = json.return_content;
                }else{
                    document.getElementById("OverDue").value = json.result;
                    dbid = document.Qpost_Set_Form.dbid.value;
                    if(flag=='1'){
                        if(dbid  != ''){
                            url = DOMAIN_MY+'/sc/sendtwo/send_resume_new.php?'+rand+'&isEN=0&rsmid='+document.getElementById("CheckedResume").value+'&dbid='+dbid;
                        }
                        else{
                            url  = DOMAIN_MY+'/sc/sendtwo/send_resume_new.php?'+rand+'&isEN=0&rsmid='+document.getElementById("CheckedResume").value;
                        }
                        goon = checkoverdue('1');
                        if(goon  == true){
                            var action_url = url+"&jsoncallback=?";
                            var str = $('#Qpost_Set_Form').serialize();
                            var layer=0;
                            ShowLoading();
                            $.getJSON( action_url, str , function(result){
                                if(typeof passwd != 'undefined' && passwd != '')
                                {
                                    layer=1;
                                    result.return_content = getNewUserTipsLayerContent(mobilephone , passwd ,DOMAIN_MY , 0)
                                }
                                MyApply(result.return_type,result.return_content,layer);
                            });
                        }else{
                            document.getElementById("apply_now").onclick=function(){ send(DOMAIN_MY,rand,0)};
                        }
                    }else if(flag=='2'){
                        document.Qpost_Set_Form.CheckedResume.value=$("#rsmid").val();
                        if(dbid  != ''){
                            url = DOMAIN_MY +'/sc/applyjob/preview_cv_new.php?&'+rand+'&dbid='+dbid;
                        }else{
                            url = DOMAIN_MY +'/sc/applyjob/preview_cv_new.php?&'+rand;
                        }
                        document.Qpost_Set_Form.target="_blank";
                        document.Qpost_Set_Form.action=url;
                        checkoverdue('2');
                    }
                }
            }
        }
    });
}

function getNewUserTipsLayerContent(mobilephone , passwd ,DOMAIN_MY , type){
    var tips = '';
    if(type == 1){
        tips = '恭喜您，保存成功！';
    }else {
        tips = '恭喜您，投递成功！';
    }
    var content = '<div class="panel_lnp panel_lnp_sizeM">'
        + '		<h2><p class="c_ff7300">&nbsp;</p><a href="javascript:void(0);" id="window_close_apply"><i></i></a></h2>'
        + '		<div class="pannel_body">'
        + '			<div class="messagesOK" style="padding:0px 10px 10px; text-align:left;">'
        + '				<b class="titleFont">'+tips+'</b>'
        + '			</div>'
        + '			<div class="panalBox_text">'
        + '				<p class="panalText">同时您已成为51job会员，请牢记您的用户名，登陆后可查看您的简历及投递情况！</p>'
        + '			</div>'
        + '			<div class="jc_pop_key">'
        + '				<dl class="lineDl">'
        + '					<dt>用户名：</dt>'
        + '					<dd>'
        + '						<div class="inptext_fl"> <b>'+mobilephone+'</b> </div>'
        + '					</dd>'
        + '				</dl>'
        + '				<dl class="lineDl">'
        + '					<dt>密 码：</dt>'
        + '					<dd>'
        + '						<div class="inptext_fl"> <b>'+passwd+'</b> </div>'
        + '					</dd>'
        + '				</dl>'
        + '			</div>'
        + '			<div class="textStyle">'
        + '					<p class="c_ff7300 f14">建议您修改密码，进入<a style="color:#06F;" target="_blank" href="'+DOMAIN_MY+'/my/My_Pmc.php">my51job</a>-左上角“修改资料”中修改密码</p>'
        + '			</div>'
        + '			<div class="panelBtn_box">'
        + '				<a id="window_close_button" href="javascript:void(0);" class="panel_btn_s">关 闭</a>'
        + '			</div>'
        + '			<div class="mh_help_text" style="margin-top:10px;">如遇问题，可打客服热线：400-820-5100或者800-820-5100咨询</div>'
        + '		</div>'
        + '	</div>';

    return content;
}


function checkoverdue(sendflag)
{
    var overdue_this;
    var overdue_other;
    var pos;
    var overdue_status = document.getElementById("OverDue").value;
    pos = document.getElementById("OverDue").value.indexOf("|");
    lastpos = overdue_status.lastIndexOf("|");

    overdue_this = overdue_status.substring(0,pos);
    overdue_other = overdue_status.substring(pos+1,lastpos);
    jobiduni =  overdue_status.substring(lastpos+1);
    if(jobiduni != "()"){
        if(overdue_status != 0){
            $("#jobiduni").val( jobiduni) ;
        }
        if(overdue_other > 0 || overdue_this > 0){
            var hasoverdued = window.confirm("您的申请中包含已经申请过的职位，一周之内无法重复申请。");
            if(hasoverdued == false || jobiduni == '()')
                return;
        }
        if( sendflag!=1){
            document.forms.Qpost_Set_Form.submit();
        }else{
            return true;
        }
    }else{
        alert("您的申请中包含已经申请过的职位，一周之内无法重复申请。");
        return;
    }
}
function sendGuide(sendflag){
    checkedResume = document.getElementById("CheckedResume").value;
    CnResume = document.getElementById("CnResume").value;
    EnResume = document.getElementById("EnResume").value;
    ResumeName = document.getElementById("resumename"+checkedResume).value;
    ResumeLanguage = "";
    if(CnResume == 1 && EnResume == 1){
        ResumeLanguage = "中文和英文";
    }else{
        if(CnResume == 1){
            ResumeLanguage = "中文";
        }

        if(EnResume == 1){
            ResumeLanguage = "英文";
        }
    }
    if(sendflag == '1'){
        strTemp = "发送";
    }
    if(sendflag == '2'){
        strTemp = "预览";
    }
    strGuide = "您选择" + strTemp + "的简历是:" + ResumeName + ",简历语言为:" + ResumeLanguage + "。\n确定吗?";
    var guide = window.confirm(strGuide);
    if(guide == false){
        return false;
    }else{
        return true;
    }
}
function checkApply(){
    var checkedResume;
    var CnResume;
    var EnResume;
    var cvid= $("#rsmid").val();
    var cvlanguage = $("#cvlanguage").val();
    var obj = document.getElementById("CheckedResume");
    obj.value=cvid;
    var objc=document.getElementById('CBase_' + cvid);
    var obje=document.getElementById('EBase_' + cvid);
    CnResume = objc.value;
    EnResume = obje.value;
    checkedResume = document.getElementById("CheckedResume").value;
    var iscompleted=true;
    if(!isInt(checkedResume)){
        alert("请选择一份完整的简历!");
        return false;
    }else{
        switch(cvlanguage){
            case '0':
                if(CnResume != 2)
                    iscompleted = false;
                break;
            case '1':
                if(EnResume != 2)
                    iscompleted = false;
                break;
            case '2':
                if(CnResume != 2 || EnResume != 2)
                    iscompleted = false;
                break;
        }
    }
    if(!iscompleted){
        alert('您的简历个人信息不完整,请先填写完整简历后再申请工作!');
        return false;
    }else{
        return true;
    }
}
function isInt(obj){
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
function ShowLayer(content){
    if ( !window.apply ) {
        var Param = {
            openType: 2 ,
            divProps: { style : { zIndex : 1007 } } ,
            filterParam: {},
            createIfr:false
        };
        window.apply = new ExtZzLayer( Param );
    }
    apply.setContent( content );
    apply.setCloseNode( 'window_close_apply' );
    if($('#window_close_button').length > 0){
        apply.setCloseNode( 'window_close_button' );
    }
    apply.open();

}
function ShowLoading(){
    var content = '	<div class="panel_lnp panel_lnp_sizes">'
        + '		<h2><p id="window_title">申请职位</p></h2>'
        + '			<div class="pannel_body">'
        + '			<p class="panalText_center">您的申请正在发送中，请稍候...</p>'
        + '			<p class="panalText_center"><img src="'+ this.cfg.url.image+'/loading2010.gif" /></p>'
        + '		</div>'
        + '	</div>';
    ShowLayer(content);
}
function ShowWaitImage(){
    var content = '<div style="height:100%;width:100%"><p align="center"><img src="'+ this.cfg.url.image+'/loading.gif" ></p></div>'	;
    ShowLayer(content);
}

function MyApply(return_type,return_content,layer){
    if(!arguments[2]) layer = 0;
    apply.close();
    switch(return_type){
        case 'special':
            windowHref(return_content);
            break;
        case 'notmyresume':
            alert('请选择自己的简历投递!');
            windowHref(return_content);
            break;
        case 'nojob':
        case 'noresume':
            alert(return_content);
            break;
        case 'nojobleft':
        case 'success_new':
            ShowLayer(return_content);
            break;
        case 'success_new1':
            ShowLayer(return_content);
            if(layer == 0){setTimeoutCloseMemo();}
            if ( $("#app_ck").length > 0 ) {
                $("#app_ck").attr("href","#").attr("class","but_sq off").removeAttr("onclick");
                $('#app_ck').html('<img width="22" height="22" src="http://img01.51jobcdn.com/im/jobs/but_img_sq_2.png" alt="" />已申请');
            }
            break;
    }
}

function windowHref(url){
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

var mobilephone = '';
var password = '';
function saveGrResume(domain_my)
{
    if(checkGrResume())
    {
        var showNotice = $("#hasMultResume").val();
        var bolsave = true;
        if(showNotice == 1)
        {
            bolsave = window.confirm("您有多份简历！为保证简历信息的真实性，每份简历的基本个人信息必须相同，如果修改，其他几份简历的基本个人信息将同时被修改，您确定要修改吗？");
        }
        if(bolsave)
        {
            var cname = $("#GrCname").val();
            var gender = $('input[name="Gender"]:checked').val();
            var birthday = $("#YearOfBirthday").val() + "-" + $("#MonthOfBirthday").val() + "-" + $("#DayOfBirthday").val();
            var mpnation = $('#MPNation').val();
            var mobile = $('#Mobile').val();
            var area = $("#grRsmAreaVal").val();
            var workyear = $('#WorkYear').val();
            var functype = $('#grRsmFuncVal').val();
            var resumekey = '';
            $('#GrRsmSelectedKeyword span').each(function(){
                resumekey += $(this).text() + ' ';
            });
            if(resumekey != '')
            {
                resumekey = $.trim(resumekey);
            }
            var workexp = $("#workExp").val();
            if(workexp == '最多可输入500个汉字')
            {
                workexp = '';
            }
            var actype = '1';
            var jcRsmid = $("#rsmid").val();
            if(jcRsmid != '')
            {
                actype = '3';
            }

            var sendData = {r:Math.random(), jobid:$('#apply_jobid').val(),cname:cname, gender:gender, birthday:birthday, mpnation:mpnation, mobile:mobile, area:area, workyear:workyear, functype:functype, resumekey:resumekey, workexp:workexp, resumeid:jcRsmid};

            var showNewUserLayer = false; //是否显示新用户层
            if($('#verifycode').length > 0){
                showNewUserLayer = true;
                sendData.verifycode = $('#phoneVerifyCode').val();
                sendData.havenoid = true;
            }
            //search频道添加短信验证码
            sendData.phoneVerifycode = $('#phoneVerifyCode').val();

            if($('#apply_jobid').val() == ''){
                sendData.noJobid = true;
            }

            $.getJSON(domain_my + '/cv/in/Resume/GrassRootsResumeAction.php?type='+actype+'&jsoncallback=?', sendData ,function(data){
                if(data.status == 1)
                {
                    //创建简历成功后续操作，投递职位或者展示登录成功提示层
                    if(actype == '3')
                    {
                        data.result = jcRsmid;
                    }
                    $("#hd_grresumeinfo").append('<input id="CBase_'+ data.result +'" type="hidden" value="2" name="CBase_'+data.result+'">');
                    $("#hd_grresumeinfo").append('<input id="EBase_'+ data.result +'" type="hidden" value="0" name="EBase_'+data.result+'">');
                    $("#cvlanguage").val('0');
                    $("#CheckedResume").val(data.result);
                    $("#completeflag").val('1');
                    $("#rsmid").val(data.result);

                    if(showNewUserLayer){
                        mobilephone = data.username;
                        username = data.cusername;
                        passwd = data.passwd;
                        if($('#apply_jobid').val() == ''){//基层首页
                            username = data.cusername;
                            if(username.length > 18){
                                username = username.slice(0,14) + "...";
                            }
                            var str_hello = username;

                            strdiv = '<div class="userinfo"><img src="http://img01.51jobcdn.com/im/2012/mycenter/my_userinfo_header.gif"><span id="top_username">'+str_hello+'</span>您好</div>';
                            strout = '<img src="http://img06.51jobcdn.com/im/2012/mycenter/my_logo_navx.gif"><a href="'+domain_my+'/my/My_SignOut.php">退出</a>';
                            $(".arc").append(strdiv);
                            $(".deputy_nav > li:eq(2)").remove();
                            $(".right").html(strout);
                        }else{ // 职位详情页面
                            if(username.length > 18){
                                username = username.slice(0,14) + "...";
                            }
                            var str_hello = username + '，你好！';
                            $("#loginname").html(str_hello.toLowerCase());
                            $('#loginInLink').hide();
                            $('#loginOutLink').show();
                        }
                    }

                    if($('#apply_jobid').val() != ''){
                        send(domain_my, Math.random(), 0);
                    }else{
                        ShowLayer(getNewUserTipsLayerContent(data.username , data.passwd ,domain_my , 1));
                    }

                }
                else if(data.status == -1)
                {
                    window.location.href = domain_my + '/my/My_SignOut.php';
                }
                else if(data.status == 'codeErr')
                {
                    $('#phoneVerifyCode').parent().addClass('active');
                    $('#phoneMsg_verifycode').show().html(ERR_ICON + '你输入的短信验证码错误');
                    $("#phoneVerifyCode").focus();
                }else if(data.status == 'mobilePhoneExist'){
                    showPhoneErr(domain_my,'false');
                }else{
                    alert('系统错误，请稍后再操作');
                }
            });
        }
    }
    return false;
}

function checkGrResume()
{
    var cnameok = true; //姓名验证
    var sexok = true; //性别验证
    var mobileok = true; //手机号验证
    var phoneverifycodeok = true; //手机短信验证
    var verifycodeok = true; //图形验证码验证
    var birthdayok = true; //生日验证
    var workyearok = true; //工作年限验证
    var areaok = true; //居住地验证
    var functypeok = true; //目标职位验证
    var resumekeyok = true; //关键词验证
    var workexpok = true; //工作经验描述验证
    var errorindex = 0;
    var errorid = new Array();

    //姓名与性别验证
    var cname = $("#GrCname").val();
    var sex = $('input[name="Gender"]:checked').val();
    if (('0' != sex) && ('1' != sex) && ('' == cname)) {
        $('#GrCname').parent().addClass('active');
        $('#gr_name_error').show().html(ERR_ICON + "您还没有输入姓名和性别");
        errorid[errorindex++] = 'input[name="Gender"]';
        sexok = false;
    } else if ('' != cname) {
        if (cname.getLen() > 20) {
            $('#gr_name_error').show().html(ERR_ICON + "中文姓名不超过10个字符，请重新填写");
            $('#GrCname').parent().addClass('active');
            cnameok = false;
            errorid[errorindex++] = '#GrCname';
        } else {
            $('#GrCname').parent().removeClass('active');
            if (('0' != sex) && ('1' != sex)) {
                $('#gr_name_error').show().html(ERR_ICON + "您还没有输入性别");
                errorid[errorindex++] = 'input[name="Gender"]';
                sexok = false;
            } else {
                $("#gr_name_error").hide();
            }
        }
    } else {
        $('#GrCname').parent().addClass('active');
        $('#gr_name_error').show().html(ERR_ICON + "您还没有输入姓名");
        cnameok = false;
        errorid[errorindex++] = '#GrCname';
    }

    //手机号验证
    var mpnation = $.trim($('#MPNation').val());
    var mobile = $.trim($('#Mobile').val());
    var oMobileComponent = new mobileComponent();
    if ('' == mobile) {
        $("#gr_mobile_error").show().html(ERR_ICON + "请输入手机号");
        $('#Mobile').parent().addClass('active');
        mobileok = false;
        errorid[errorindex++] = '#Mobile';
    } else if (mobile != '' && !oMobileComponent.checkMobile(mobile, mpnation)) {
        $("#gr_mobile_error").show().html(ERR_ICON + "你输入的手机号码有误");
        $('#Mobile').parent().addClass('active');
        mobileok = false;
        errorid[errorindex++] = '#Mobile';
    } else {
        if($("#phoneVerifyCode").length){
            if( window.phoneErr != 1)
            {
                $('#Mobile').parent().removeClass('active');
                $("#gr_mobile_error").hide();
            }
            else
            {
                mobileok = false;
                errorid[errorindex++] = '#Mobile';
            }
        }else{
            $('#Mobile').parent().removeClass('active');
            $("#gr_mobile_error").hide();
        }
    }

    //手机短信验证，如果是已登录的简历填写的话默认为true，不做验证
    if($("#phoneVerifyCode").length > 0 && mpnation == '086')
    {
        var verifycode = $.trim($("#phoneVerifyCode").val());
        if(verifycode == '')
        {
            $("#phoneMsg_verifycode").show().html(ERR_ICON + "请填写短信验证码");
            $('#phoneVerifyCode').parent().addClass('active');
            phoneverifycodeok = false;
            errorid[errorindex++] = '#phoneVerifyCode';
        }else{
            $('#phoneVerifyCode').parent().removeClass('active');
            $("#phoneMsg_verifycode").hide();
        }
    }

    //图形验证码验证，如果是已登录的简历填写的话默认为true，不做验证
    if($('#verifycode').length > 0)
    {
        verifycodeok = checkPhonePicCodeJSONP('CN','http://my.51job.com',0);
    }

    //出生日期验证
    var year  = $.trim($("#YearOfBirthday").val());
    var month = $.trim($("#MonthOfBirthday").val());
    var day = $.trim($("#DayOfBirthday").val());
    if(year == '' || month == '' || day == '')
    {
        $("#gr_birthday_error").show().html(ERR_ICON + "您还没有输入出生年月");
        $("#YearOfBirthday ,#MonthOfBirthday ,#DayOfBirthday").parent().addClass('active');
        if(year == '')
        {
            errorid[errorindex++] = '#YearOfBirthday';
        }
        else if(month == '')
        {
            errorid[errorindex++] = '#MonthOfBirthday';
        }
        else
        {
            errorid[errorindex++] = '#DayOfBirthday';
        }
        birthdayok = false;
    } else if (!isValidDate(year,month,day)) {
        $('#gr_birthday_error').show().html(ERR_ICON + "请正确选择出生日期");
        $("#YearOfBirthday ,#MonthOfBirthday ,#DayOfBirthday").parent().addClass('active');
        birthdayok = false;
    } else {
        $("#YearOfBirthday ,#MonthOfBirthday ,#DayOfBirthday").parent().removeClass('active');
        $('#gr_birthday_error').hide();
    }

    //居住地验证
    var area = $("#grRsmAreaVal").val();
    if(area == '')
    {
        $("#gr_area_error").show().html(ERR_ICON + "您还没有输入居住地");
        $("#grRsmArea_div").parent().addClass('active');
        areaok = false;
    } else {
        $("#grRsmArea_div").parent().removeClass('active');
        $("#gr_area_error").hide();
    }

    //工作经验验证
    var workExp = $("#workExp").val();
    if(workExp.getLen() > 1000)
    {
        $("#gr_workexp_error").show().html(ERR_ICON + "工作经验与特长技能有误，请重新填写");
        $("#workExp").parent().addClass('active');
        workexpok = false;
        errorid[errorindex++] = '#workExp';
    } else {
        $("#workExp").parent().removeClass('active');
        $("#gr_workexp_error").hide();
    }

    //简历关键词验证
    if($('#GrRsmSelectedKeyword span').length > 10)
    {
        resumekeyok = false;
    }
    $('#GrRsmSelectedKeyword span').each(function(){
        if($(this).text().getLen() > 20)
        {
            resumekeyok = false;
        }
    });

    if(cnameok && sexok && mobileok && phoneverifycodeok && verifycodeok && birthdayok && workyearok && areaok && functypeok && resumekeyok && workexpok)
    {
        return true;
    }
    else
    {
        if(errorid.length > 0)
        {
            if(errorid[0] == 'input[name="Gender"]')
            {
                $(errorid[0]).eq(0).focus();
            }
            else
            {
                $(errorid[0]).focus();
            }
        }
        return false;
    }
}

//该函数不在使用, 通过调用component/mobile.js来实现
function chkPhoneNumber(mpcountry, phone)
{
    var reg = '';
    var chkResult = false;
    if(mpcountry == '086')
    {
        reg = /^1[3458]{1,1}[0-9]{9,9}$/;
    }else if(mpcountry == '000')
    {
        reg = /^[0-9]{1,20}$/;
    }
    if(reg != '')
    {
        chkResult = reg.test(phone);
    }
    return chkResult;
}

function addKeywords()
{
    if(getAddedKeywordsNum() >= 10)
    {
        alert('最多设置10个关键字');
    }
    else
    {
        var addkeyword = $.trim($("#grip_keywords").val());
        if(addkeyword == '')
        {
            alert("请输入关键字");
        }
        else if(addkeyword.indexOf(' ') > 0)
        {
            alert("关键字中不能有空格");
        }
        else if(addkeyword.getLen() > 12)
        {
            alert("关键字长度不能超过6个汉字（12字符）");
        }
        else if(!checkAddkeyword(addkeyword))
        {
            alert("你已经添加了该关键字");
        }
        else
        {
            appendKeyword(addkeyword);
            $("#grip_keywords").val('');
            $("#GrRsmRecomentKeyword span").each(function(){
                if($(this).html() == addkeyword)
                {
                    $(this).addClass('disabled');
                    this.onclick = function(){};
                }
            });
        }
    }
}
function appendKeyword(keyword)
{
    keyword = $("#gr_escape").text(keyword).html();
    var tagNum = $("#GrRsmSelectedKeyword span").length;
    for(var i = 0; i < tagNum; i++)
    {
        if($("#grtag_"+i).length == 0)
        {
            tagNum = i;
            break;
        }
    }
    $("#GrRsmSelectedKeyword").append('<span  id="grtag_' + tagNum + '" class="topLableUnit" onclick="delKeywords(\'' + tagNum + '\')">'+keyword+' <i class="labClose"></i></span>');
}

function selectKeywords(id)
{
    keyword = $("#reckey_"+id).text();
    if(getAddedKeywordsNum() >= 10)
    {
        alert('最多设置10个关键字');
    }
    else if(!checkAddkeyword(keyword))
    {
        alert("你已经添加了该关键字");
    }
    else
    {
        $("#reckey_"+id).addClass('disabled');
        $("#reckey_"+id).onclick = function(){};
        appendKeyword(keyword);
    }
}

function getAddedKeywordsNum()
{
    return $('#GrRsmSelectedKeyword span[id^="grtag_"]').length;
}

function checkAddkeyword(keyword)
{
    var chkresult = true;
    $("#GrRsmSelectedKeyword span").each(function(){
        if($.trim($(this).text()) == keyword){
            chkresult = false;
            return false;
        }
    });
    return chkresult;
}

function delKeywords(id)
{
    var keyword = $.trim($("#grtag_"+id).text());
    $("#grtag_"+id).remove();
    $("#GrRsmRecomentKeyword span").each(function(){
        if($.trim($(this).text()) == keyword)
        {
            $(this).removeClass('disabled');
            this.onclick = function(){selectKeywords($(this).attr('uid'));};
        }
    });
}

function cleanWorkExp()
{
    if($("#workExp").val() == '最多可输入500个汉字')
    {
        $("#workExp").val('');
    }
}

function setWorkExp()
{
    if($("#workExp").val() == '')
    {
        $("#workExp").val('最多可输入500个汉字');
    }
}

function saveRsmKeyAndSend(domain_my)
{
    var jobid = $("#jobiduni").val().replace(/[()]/g,'');
    if($('#GrRsmSelectedKeyword').find('span').length > 10)
    {
        alert('关键字不能超过10个');
        return false;
    }
    if($('#GrRsmSelectedKeyword').find('span').length > 0)
    {
        var cansave = true;
        var resumekey = '';
        $('#GrRsmSelectedKeyword').find('span').each(function(){
            if($(this).text().getLen() > 12)
            {
                alert('关键字格式错误');
                cansave = false;
                return false;
            }
            resumekey += $(this).text() + ' ';
        });
        if(cansave)
        {
            resumekey = $.trim(resumekey);
            $.getJSON(domain_my + '/cv/in/Resume/GrassRootsResumeAction.php?type=2&jsoncallback=?',{r:Math.random, jobid:jobid, resumeid:$("#rsmid").val(),resumekey:resumekey}, function(data){
                if(data.status == 1)
                {
                    send(domain_my,Math.random(),0);
                }
            });
        }
        return cansave;
    }
    send(domain_my,Math.random(),0);
    return true;
}

function getNoIdQuickRsmLayer(jobid,isEnglish,My_Domain,btnId){
    if(isEnglish == 'e'){
        var action_url = My_Domain+"/cv/EResume/CV_EQuickApply.php?";
    }else{
        var action_url = My_Domain+"/cv/CResume/CV_CQuickApply.php?";
    }
    action_url += Math.random()+"&jsoncallback=?";
    jobid='('+jobid+')';
    ShowWaitImage();
    $.getJSON( action_url, {jobid : jobid } , function(result){
        switch(result.return_type){
            case 'createGrassRootsRsm':
                if(window.apply){
                    apply.close();
                }
                var cfg = window.cfg;
                if ( !window.apply ) {
                    var Param = {
                        openType: 2 ,
                        divProps: { style : { zIndex : 1007 } } ,
                        filterParam: {},
                        afterClose: function(){
                            if(window.grRsmjobAreaLayer){
                                window.grRsmjobAreaLayer.close();
                            }
                            if(window.grRsmFuntypeLayer){
                                window.grRsmFuntypeLayer.close();
                            }
                        }
                    };
                    window.apply = new ExtZzLayer( Param );
                }
                window.apply.setContent( result.return_content );
                window.apply.open();

                //绑定基层简历填写层input框
                bandGrassRootResumeInput();

                break;
        }
    });
}

function checkPhonePicCodeJSONP(language,DOMAIN_MY,ajax){
    var rtn = true;
    var verifycode = $.trim($("#verifycode")[0].value);
    if(verifycode == ''){
        showPicCodeTips('phonesignup',false,'verifycode_no',language);
        rtn = false;
    }else{
        if(ajax == 1){
            var oldasync = $.ajaxSettings.async;
            $.ajaxSettings.async = false;
            var type = $('#verifyPic_img').attr('type');
            var rt = new Object();
            var data = {'type':type,'verifycode':verifycode};
            var url = DOMAIN_MY+"/AjaxAction/check_verifycode.php?rand="+new Date().getTime()+"&jsoncallback=?&";
            $.getJSON(url,data,function(result){
                rt = result;
                $.ajaxSettings.async = oldasync;
                if(rt.result == 1){
                    showPicCodeTips('phonesignup',true,'verifycode_no',language);
                    rtn = true;
                }else{
                    showPicCodeTips('phonesignup',false,'verifycode_err',language);
                    rtn = false;
                }
            });
        }else{
            if($("#verifycode").parent().hasClass('active')){
                rtn = false;
            }else{
                rtn = true;
            }
        }

    }
    return rtn;
}

function checkPhoneJSONP(language,ajax,DOMAIN_MY,imgpath,loginLayer)
{
    var ajax = (arguments[1]==0)?arguments[1]:1;
    var DOMAIN_MY = (arguments[2]!='')?arguments[2]:'';
    var phoneNum = $.trim($('#Mobile').attr('value'));

    if($.trim(phoneNum) == '')
    {
        if(language == 'CN'){
            var errMsg = '请输入手机号';
        }else{
            $('.phone_notice').css("width","210px");
            var errMsg = 'Please enter your mobile number.';
        }
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").show().html(ERR_ICON + errMsg);
        return false;
    }
    var objPhoneCheck =  new mobileComponent();
    if(objPhoneCheck.checkMobile(phoneNum,'086') <= 0)
    {
        if(language == 'CN'){
            $('.phone_notice').css("width","160px");
            var errMsg = '你输入的手机号码有误';
        }else{
            $('.phone_notice').css("width","180px");
            var errMsg = 'Incorrect mobile number.';
        }
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").show().html(errMsg);
        return false;
    }

    if(ajax ==1)
    {
        //验证手机号是否已经被占用
        url = DOMAIN_MY+"/my/in/checkinfo.php?rand="+new Date().getTime()+"&jsoncallback=?&";
        $.getJSON(url, { type: "mobilePhone", value: phoneNum } , function(result) {
            if(result == 1){
                clearTimeout(id_set_timeout);
                if(language == 'CN'){
                    showPhoneErr(DOMAIN_MY,loginLayer);
                }else{
                    var loginUrl = DOMAIN_MY + '/emy/My_SignIn.php';
                    var fandPWDUrl = DOMAIN_MY + 'emy/My_ForgetPhone.php';
                    var errMsg = 'This number has already existed, you can <a href="'+loginUrl+'" stype="cursor:pointer;">log in directly</a> or  <a stype="cursor:pointer;" href="'+fandPWDUrl+'">forget password</a>';
                    $('.phone_notice').css("width","450px");
                    $('#Mobile').parent().addClass('active');
                    $("#gr_mobile_error").show().html(errMsg);
                    $('#btn').attr('value','Send Code');
                    $('#btn').css('background',"url('"+imgpath+"/im/mobile_code/2014/btn-send-cr.gif')");
                }
                return false;
            }else{
                window.phoneErr = 0;
                document.getElementById("btn").onclick=function(){sendVerifyCode(DOMAIN_MY,imgpath,language)}
                $('#Mobile').parent().removeClass('active');
                $("#gr_mobile_error").hide().html('');
                return true;
            }
        })//end post
    }
}

function showPicCodeTips(func,issucess , msgtype,language){
    if(language=='EN'){
        var tips = {
            verifycode_no : { info:'please enter verify code',width:'160px'},
            verifycode_err : { info:'verify code error or has been expired',width:'250px'}
        };
    }else{
        var tips = {
            verifycode_no : { info:'请填写验证码',width:'160px'},
            verifycode_err : { info:'验证码错误或已过期,看不清请换一张',width:'220px'}
        };
    }
    if(func == 'phonesignup'){

        if(issucess == false){
            $("#floatverifycodebox").show().html(ERR_ICON + tips[msgtype]['info']);
            $('#verifycode').parent().addClass('active');
        }else{
            $("#floatverifycodebox").hide().html('');
            $('#verifycode').parent().removeClass('active');
        }
    }
}


function sendPhoneVerifyCode(DOMAIN_MY,imgpath,language)
{
    // var DOMAIN_MY = $("#domain_my").val();
    // var imgpath = IMGPATH;
    var bolCheckPhone = false;
    var mpnation = $('#MPNation').val();
    var phoneNum = $.trim($('#Mobile').attr('value'));
    var oMobileComponent = new mobileComponent();
    if ('' == phoneNum) {
        $("#gr_mobile_error").show();
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").html(ERR_ICON + "请输入手机号");
    } else if (phoneNum != '' && !oMobileComponent.checkMobile(phoneNum, mpnation)) {
        $("#gr_mobile_error").show();
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").html(ERR_ICON + "你输入的手机号码有误");
    } else {
        $('#Mobile').parent().removeClass('active');
        $("#gr_mobile_error").hide();
        bolCheckPhone = true;
    }
    // var phoneNum = $.trim($('#Mobile').val());
    if(!bolCheckPhone) {
        return;
    }
    objBtn = document.getElementById("btn");
    objBtn.disabled = false;
    sendVerifytime(objBtn);
    //ajax 发送手机验证码短信
    $.getJSON(DOMAIN_MY+"/AjaxAction/mobile_code/send_mobile_code.php?rand="+Math.random()+"&jsoncallback=?", { mobile: phoneNum, apptype: 7} , function(result) {
        // result = eval('(' + result + ')');
        if(result.status != 1){
            //发送失败
            if(result.status == -2)//发送次数或者间隔错误
            {
                alert('手机验证码一天最多发送3次，且每次发送间隔时间大于2分钟');
                return;
            } else if(result.status == -1) {
                alert('请填写正确的手机号码');
                return;
            } else {
                alert('操作失败请稍后再试');
                return;
            }
        }else{
            //发送成功
        }
    });

}

function sendVerifyCode(DOMAIN_MY,imgpath,language,loginLayer)
{
    var bolCheckPhone = false;
    var mpnation = $('#MPNation').val();
    var phoneNum = $.trim($('#Mobile').attr('value'));
    var oMobileComponent = new mobileComponent();
    if ('' == phoneNum) {
        $("#gr_mobile_error").show();
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").html(ERR_ICON + "请输入手机号");
    } else if (phoneNum != '' && !oMobileComponent.checkMobile(phoneNum, mpnation)) {
        $("#gr_mobile_error").show();
        $('#Mobile').parent().addClass('active');
        $("#gr_mobile_error").html(ERR_ICON + "你输入的手机号码有误");
    } else {
        $('#Mobile').parent().removeClass('active');
        $("#gr_mobile_error").hide();
        bolCheckPhone = true;
    }

    if(bolCheckPhone)
    {
        var verifycode = $.trim($("#verifycode")[0].value);
        if (verifycode == "")
        {
            //验证码为空
            $("#floatverifycodebox").show();
            $('#verifycode').parent().addClass('active');
            $("#floatverifycodebox").html(ERR_ICON +"请输入图形验证码");
            return;
        }else{
            $('#verifycode').parent().removeClass('active');
            $("#floatverifycodebox").hide();
        }
        url = DOMAIN_MY+"/AjaxAction/mobile_code/send_mobile_code.php?rand="+new Date().getTime()+"&jsoncallback=?&";
        data = { mobile: phoneNum, apptype: 4 ,piccode:verifycode}
        //ajax 发送手机验证码短信
        $.getJSON(url, data , function(result) {
            if(result.status != 1){
                //发送失败
                if(result.status == -2)//发送次数或者间隔错误
                {
                    if(language == 'CN'){
                        $('#Mobile').parent().addClass('active');
                        $("#gr_mobile_error").show().html(ERR_ICON + result.result);
                    }else{
                        $("#gr_mobile_error").show().html(ERR_ICON + 'The verification code can be sent 3 times one day and 5 minutes to send one more time');
                    }
                }
                else if(result.status == -8){
                    if(language == 'CN'){
                        $("#floatverifycodebox").hide();
                        showPhoneErr(DOMAIN_MY,loginLayer);

                    }else{
                        var loginUrl = DOMAIN_MY + '/emy/My_SignIn.php';
                        var fandPWDUrl = DOMAIN_MY + 'emy/My_ForgetPhone.php';
                        var errMsg = 'This number has already existed, you can <a href="'+loginUrl+'" stype="cursor:pointer;color:#f60">log in directly</a> or  <a stype="cursor:pointer;color:#f60;" href="'+fandPWDUrl+'">forget password</a>';
                        $("#gr_mobile_error").show().html(ERR_ICON + errMsg);
                    }
                }else if(result.status == -21){
                    //验证码为空
                    $("#floatverifycodebox").show();
                    $('#verifycode').parent().addClass('active');
                    $("#errorMsg_verifycode").html(ERR_ICON + "请填写验证码");
                }else if(result.status == -22){
                    wait = 0;
                    //验证码错误
                    $("#floatverifycodebox").show();
                    $('#verifycode').parent().addClass('active');
                    $("#floatverifycodebox").html(ERR_ICON + "验证码错误或已过期,看不清请换一张");
                }else {
                    if(language == 'CN'){
                        var errMsg = '操作失败';
                    }else{
                        var errMsg = 'fail to send phone code';
                    }
                    $('#phoneVerifyCode').parent().addClass('active');
                    $("#phoneMsg_verifycode").show().html(ERR_ICON + errMsg);
                }
            }else{
                //发送成功
                if(language == 'CN'){
                    $('#Mobile').parent().removeClass('active');
                    $('#phoneVerifyCode').parent().removeClass('active');
                    $('#verifycode').parent().removeClass('active');
                    $('#gr_mobile_error').hide();
                    $('#floatverifycodebox').hide();
                    $('#phoneMsg_verifycode').hide();
                    $("#sendPhoneMsg").show().html(result.result);
                    objBtn = document.getElementById("btn");
                    objBtn.disabled = false;
                    wait = 120;
                    sendVerifytime(objBtn);
                }else{
                    $("#sendPhoneMsg").show().html('We have sended the code to your phone，please check your SMS');
                }

            }
        })// end post
    }
}

//发送验证图片记时功能
var wait=120;
var id_set_timeout = null;
function sendVerifytime(o) {
    if (wait == 0)
    {
        o.removeAttribute("disabled");
        o.value="发送验证码";
        $("#sendPhoneMsg").hide().html('');
        wait = 120;
    } else {
        o.setAttribute("disabled", true);
        o.value="重新发送(" + wait + ")";
        wait--;
        setTimeout(function() {
                sendVerifytime(o)
            },
            1000)
    }
}


function checkNoIdResume(language)
{
    var cnameok = false;
    var sexok = false;
    var mobileok = false;
    var birthok = false;
    var workexpok = false;
    var keywordok = false;
    if (language = 'CN')
    {
        var cname = $.trim($("#GrCname").val());
        var sex = $.trim($('input[name="Gender"]:checked').val());
        var mobile = $.trim($('#Mobile').val());
        var year  = $.trim($("#YearOfBirthday").val());
        var month = $.trim($("#MonthOfBirthday").val());
        var day = $.trim($("#DayOfBirthday").val());
        var workExp = $.trim($("#workExp").val());
        var Keyword = $.trim($("#GrRsmSelectedKeyword").html());

        cnameok = cname != '' ? true : false;
        sexok = (sex != '0' && sex != '1') ? false : true;
        mobileok = mobile != '' ? true : false;
        birthok = (year != '0' || month != '0' || day != '0') ? true : false;
        workexpok = (workExp != '' && workExp != '最多可输入500个汉字') ? true : false;
        keywordok = Keyword != '' ? true : false;
    }
    if(cnameok || sexok || mobileok ||  birthok || workexpok || keywordok)
    {
        r = confirm('您的简历未填写完，是否确认放弃填写？');
        if (r == true)
        {
            apply.close();
        }
    }
    else
    {
        apply.close();
    }
}

function showPhoneErr(domain_my,loginLayer)
{
    var fandPWDUrl = domain_my + '/my/My_ForgetPhone.php';
    if(loginLayer == 'true')
    {
        var errMsg = '此号码已存在，可直接<a onclick="apply.close();showLoginDiv(this);" href="javascript:;" style="cursor:pointer;color:#333;">登录</a>'
    }
    else
    {
        var errMsg = '此号码已存在，可直接<a  href="'+domain_my+'/my/My_SignIn.php" style="cursor:pointer;color:#333;">登录</a>'
    }
    $('#Mobile').parent().addClass('active');
    errMsg += '或<a style="cursor:pointer;color:#333;" href="'+fandPWDUrl+'">找回密码</a>';
    $("#gr_mobile_error").show().html(ERR_ICON + errMsg);
    window.phoneErr = 1;
}

function bandGrassRootResumeInput()
{
    //ie placeholder
    $('input').placeholder();
    //关闭下拉弹层
    $(document).click(function(){
        $('.select_layer').hide();
        jQuery.layer.fixIEBug(jQuery.selectLayer.currentSettings.oLayerSettings, true);
    });

    if($('#YearOfBirthday').attr('disabled') === false) //身份证诚信认证状态为"验证中"或者"验证通过" 时，姓名、性别、生日、证件号都不能修改
    {
        $('#YearOfBirthday_div').yearLayer({'id': 'YearOfBirthday','div_id':'YearOfBirthday_div','code_id':'YearOfBirthday','layer_id':'YearOfBirthday_layer', 'data_max': -10,"after_close":function(){}});
        $('#MonthOfBirthday_div').monthLayer({'id': 'MonthOfBirthday','div_id':'MonthOfBirthday_div','code_id':'MonthOfBirthday','layer_id':'MonthOfBirthday_layer',"after_close":function(){}});
        $('#DayOfBirthday_div').dayLayer({'id': 'DayOfBirthday','div_id':'DayOfBirthday_div','code_id':'DayOfBirthday','layer_id':'DayOfBirthday_layer',"after_close":function(){}});
    }
    if($('#MPNationText').attr('disabled') === false)//手机诚信认证状态为"验证中"或者"验证通过" 时，手机不能修改
    {
        $('#MPNation_div').mobileNationLayer({'id': 'MPNationText','div_id':'MPNation_div','code_id':'MPNation','layer_id':'MPNation_layer',"after_close":function(){}});
    }
    $('#WorkYear_div').workyearLayer({'id': 'WorkYearText','div_id':'WorkYear_div','code_id':'WorkYear','layer_id':'WorkYear_layer',"after_close":function(){}});
    //居住地
    $('#grRsmArea_btn').areaLayer({'id': 'grRsmAreaText',"code_id":"grRsmAreaVal", 'div_id': 'grRsmArea_div','data_district_show': true,'layer_index':'2000','back_drop_index':'1999',"after_close":function(){}});
    $('#grRsmArea_div').areaSearch({'id': 'grRsmAreaText',"code_id":"grRsmAreaVal",'layer_id':'grRsmArea_layer','div_id':'grRsmArea_div','data_show_type': 7,"after_close":function(){}});
    //目标职位选择
    $('#grRsmFunc_btn').funtypeLayer({"id":"grRsmFuncText","code_id":"grRsmFuncVal",'div_id': 'grRsmFunc_div','layer_index':'2000','back_drop_index':'1999',"after_close":function(){}});
    $('#grRsmFunc_div').funtypeSearch({"id":"grRsmFuncText","code_id":"grRsmFuncVal",'div_id': 'grRsmFunc_div',"layer_id":"grRsmFunc_layer","after_close":function(){if($('#funtype_err').is(':visible')){chkFuntype();}}});

    //如果有图片验证码输入框
    if($('.verifyPicChangeClick').length > 0){
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
        });
    }


}
function setTimeoutCloseMemo()
{
    //2秒自动隐藏处理
    if ( this.showMemoTimtout ) {
        clearTimeout( this.showMemoTimtout );
    }
    this.showMemoTimtout = setTimeout( function() {
        if(window.apply){
            apply.close();
        }
    } , 2000 );
}
function showVerifyCodeInput()
{
    if ($('#MPNation').val() == '086') {
        $('#phoneVerifyCodeDiv').show();
    } else {
        $('#phoneVerifyCodeDiv').hide();
    }
}
//给浮层绑定是否显示短信验证码
function bindShowVerifyCode()
{
    if ($('#phoneVerifyCodeDiv').length > 0) {
        $('#grdiv').bind('click',function(){
            showVerifyCodeInput();
        });
        showVerifyCodeInput();
    }
}
