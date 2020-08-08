(function($) {
    var oDefaultSettings = {
        'id'                        : 'association',
        'text_id'                   : 'association_text',
        'code_id'                   : 'association_code',
        'under_id'                  : 'association_under',
        'append_id'                 : 'association_append',
        'association_id'            : 'association_id',
        'float_index_id'            : 'association_float_index',
        'float_on_id'               : 'association_float_on',

        'save_type'                 : '1',
        'save_text_type'            : '1',
        'save_under_text_type'      : '1',
        'save_code_type'            : '1',

        'keyup_fn'                  : '',
        'append_fn'                 : '',
        'layer_append_type'         : '1',

        'association_type'          : '1',
        'data'                      : '',
        'data_struct_type'          : '1',
        'data_child_depth'          : '2',
        'data_multiple'             : false,
        'data_multiple_max'         : 5,
        'data_view_type'            : '1',
        'data_type'                 : '',
        'data_parent_click'         : true,
        'data_add_error_alert'      : true,
        'data_clear'                : true,

        'recommend'                 : false,
        'recommend_type'            : '1',
        'recommend_click_fn'        : '',
        'data_recommend'            : '',
        'data_recommend_struct_type': '1',
        'before_open'               : '',
        'after_close'               : '',
        'selected_class'            : 'on',
        'init_class'                : 'udbox',
        'init_sub_class'            : 'ul',
        'language'                  : 'c',

        'self_define_text_id'       : 'self_define_text_id',
        'init_selfdefine_class'     : 'li diy',
        'self_define'               : '0',
        'self_define_settings'      : [],
        'max_self_define_length'    : 50
    }


    //基本信息-居住地
    //基本信息-国籍/户口
    //求职意向-地点
    $.fn.areaAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'area_association',
            'text_id'                   : 'area_association_text',
            'code_id'                   : 'area_association_code',
            'under_id'                  : 'area_association_under',
            'association_id'            : 'area_association_id',
            'data'                      : area,
            'data_length'               : '2',
            'data_child_depth'          : '3',
            'data_child_type'           : '1'  //子集类型: 1: 有省市区, 国外无子集 2: 有省和市, 国外有子集 3: 有省和市+特殊频道, 国外无子集
        };

        oSelfSettings.data_type = 'area';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            switch (oSettings.data_child_type)
            {
                case '1':  //有省市区, 国外无子集: 删除国外的子集 + 特殊频道
                    var oTempData = {};

                    $.each(oSettings.data, function (code, value) {
                        var iParentCode = code.substr(0, 4) + '00';
                        if (-1 == jQuery.commonSelect.sForeignArea.indexOf(iParentCode) && (-1 == jQuery.commonSelect.sPecialArea.indexOf(code)))
                        {
                            oTempData[code] = value;
                        }
                    });

                    oSettings.data = oTempData;
                    break;

                case '2':  //有省和市, 国外有子集: 删除地区 + 删除国外 + 特殊频道
                    var oTempData = {};

                    $.each(oSettings.data, function (code, value) {
                        if ('00' == code.substr(4, 2))  //省+市, 要删除直辖市下面的区
                        {
                            var iParentCode = code.substr(0, 2) + '0000';

                            if (-1 != jQuery.commonSelect.sMunicipalityArea.indexOf(iParentCode))
                            {
                                if (code == iParentCode)
                                {
                                    oTempData[code] = value;
                                }
                            }
                            else
                            {
                                oTempData[code] = value;
                            }
                        }
                        else  //区+特殊频道里面筛选出国外子集
                        {
                            var iParentCode = code.substr(0, 4) + '00';

                            if (-1 != jQuery.commonSelect.sForeignArea.indexOf(iParentCode))
                            {
                                oTempData[code] = value;
                            }
                        }
                    });

                    oSettings.data = oTempData;

                    break;

                case '3':  //有省和市, 国外无子集, 有特殊频道: 删除地区 + 国外子集
                    var oTempData = {};


                    $.each(oSettings.data, function (code, value) {
                        if ('00' == code.substr(code.length-2, 2))  //省+市, 要删除直辖市下面的区
                        {
                            var iParentCode    = code.substr(0, 2) + '0000';
                            var iSubParentCode = code.substr(0, 4) + '00';

                            if (-1 != jQuery.commonSelect.sMunicipalityArea.indexOf(iParentCode))
                            {
                                if (code == iParentCode)
                                {
                                    oTempData[code] = value;
                                }
                            }
                            else if ((-1 == jQuery.commonSelect.sForeignArea.indexOf(iSubParentCode)))
                            {
                                oTempData[code] = value;
                            }
                        }
                        else if (-1 != jQuery.commonSelect.sPecialArea.indexOf(code))
                        {
                            oTempData[code] = value;
                        }
                    });

                    oSettings.data = oTempData;
                    break;
            }

            oSettings.getAssociationContent = getAssociationContent;

            // $('#' +  oSettings.text_id).bind('click', function (oEvent) {oEvent.stopPropagation();});

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });


        function getAssociationContent(oSettings, oAssociationData)
        {
            var sContent = '';

            $.each(oAssociationData, function (i, value) {
                sContent += '<span data-value="' + i + '" class="li '+ oSettings.association_each_click + '">' + getTextValue(oSettings, i, value) + '</span>';
            });

            return sContent;
        }


        function getTextValue(oSettings, iCurrentCode, aParentCode)
        {
            var aTextValue = [];

            aParentCode.unshift(iCurrentCode);

            $.each(aParentCode, function (i, value) {
                aTextValue.push(oSettings.data[value]);
            });

            return aTextValue.join(jQuery.commonSelect.oSaveCodeTypeSplit[oSettings.save_code_type]);
        }
    }


    //求职意向-行业/工作经验-行业
    $.fn.indtypeAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'indtype_association',
            'text_id'                   : 'indtype_association_text',
            'code_id'                   : 'indtype_association_code',
            'under_id'                  : 'indtype_association_under',
            'association_id'            : 'indtype_association_id',
            'data'                      : it,
            'data_child_depth'          : '1',
            'data_view_type'            : '1'
        };

        oSelfSettings.data_type = 'indtype';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //求职意向-职能/工作经验-职能
    $.fn.funtypeAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'funtype_association',
            'text_id'                   : 'funtype_association_text',
            'code_id'                   : 'funtype_association_code',
            'under_id'                  : 'funtype_association_under',
            'association_id'            : 'funtype_association_id',
            'data'                      : ft,
            'data_view_type'            : '2',
            'init_class'                : 'udbox',
            'init_sub_class'            : 'ul u3'
        };

        oSelfSettings.data_type = 'funtype';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //教育经历-专业
    $.fn.majorAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'major_association',
            'text_id'                   : 'major_association_text',
            'code_id'                   : 'major_association_code',
            'under_id'                  : 'major_association_under',
            'association_id'            : 'major_association_id',
            'data'                      : major,
            'self_define_data'          : [],
            'data_view_type'            : '2',
            'init_class'                : 'udbox',
            'init_sub_class'            : 'ul u3'
        };

        oSelfSettings.data_type = 'major';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            //自定义输入框上方数据
            if(oSettings.self_define == '1' && oSettings.self_define_data.length == 0)
            {
                $.each(oMajorM, function(k,v){
                    oSettings.self_define_data.push(k);
                });
            }

            oSettings.getSelfDefineDivCode = getSelfDefineDivCode;
            oSettings.saveSelfDefine = saveSelfDefine;

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });

        function getSelfDefineDivCode(oSettings)
        {
            sCode = '<div class="panel_lnp panel_py panel_ct2 Fm" id="' + oSettings.self_define_text_id + '_selfdefine_div">'
                +'<h2><p>' + lang['layer']['self_define'] + lang[oSettings.data_type]['layer_name'] + '</p><a class="layer_close" href="javascript:void(0);"><i></i></a></h2>'
                +'<div class="panel_celt clearfix">'
                +'<div class="celt">'
                +'<div class="tit">' + lang[oSettings.data_type]['self_define_step1'] + '</div>'
                +'<div class="tin clearfix">';

            var bSelectParentType = false;
            $.each(oSettings.self_define_data, function(k,v){
                if($('#' + oSettings.code_id).val() == v)
                {
                    bSelectParentType = true;
                }
                sCode += '<span class="ttag ' + oSettings.association_each_click + ($('#' + oSettings.code_id).val() == v ? ' on' : '') + '" data-value="' + v + '">' + major[v] + '</span>';
            });

            sCode += '</div></div>'
                +'<div class="celt">'
                +'<div class="tit">' + lang[oSettings.data_type]['self_define_step2'] + '</div>'
                +'<div class="txt">'
                +'<input class="ef cursor" type="text" placeholder="' + lang['self_define']['self_define_placeholder1'] + (oSettings.language == 'c' ? oSettings.max_self_define_length/2 : oSettings.max_self_define_length) + lang['self_define']['self_define_placeholder2'] + '" id="' + oSettings.self_define_text_id + '_selfdefine_input" maxlength="' + oSettings.max_self_define_length + '" value="' + $('#' + oSettings.self_define_text_id).val() + '">'
                +'<input type="hidden" id="' + oSettings.self_define_text_id + '_selfdefine_code" value="' + (bSelectParentType ? $('#' + oSettings.code_id).val() : '') + '">'
                +'</div>'
                +'</div>'
                +'<span class="err" id="' + oSettings.self_define_text_id + '_selfdefine_error"></span>'
                +'</div>'
                +'<div class="but_box b2">'
                +'<span class="p_but" id="' + oSettings.self_define_text_id + '_selfdefine_button">' + lang['layer']['save'] + '</span>'
                +'</div></div>';

            return sCode;
        }

        function saveSelfDefine(oEvent){

            oEvent.stopPropagation();

            var oSettings = oEvent.data;

            if($.trim($("#" + oSettings.self_define_text_id + "_selfdefine_code").val()) == '')
            {
                $("#" + oSettings.self_define_text_id + '_selfdefine_error').text(lang[oSettings.data_type]['self_define_error1']).show();
                return;
            }
            else
            {
                if($.trim($("#" + oSettings.self_define_text_id + '_selfdefine_input').val()) == '')
                {
                    $("#" + oSettings.self_define_text_id + '_selfdefine_error').text(lang[oSettings.data_type]['self_define_error2']).show();
                    return;
                }
                else if(jQuery.commonAssociation.strlength($("#" + oSettings.self_define_text_id + '_selfdefine_input').val()) > oSettings.max_self_define_length)
                {
                    $("#" + oSettings.self_define_text_id + '_selfdefine_error').text(lang['self_define']['self_define_error_maxlength1'] + (oSettings.language == 'c' ? oSettings.max_self_define_length/2 : oSettings.max_self_define_length) + lang['self_define']['self_define_error_maxlength2']).show();
                    return;
                }
                else
                {
                    jQuery.FLayer.close(oSettings.self_define_settings);
                    $('#' + oSettings.text_id).val($('#' + oSettings.self_define_text_id + '_selfdefine_input').val());
                    $('#' + oSettings.text_id).attr('pre_value', $('#' + oSettings.self_define_text_id + '_selfdefine_input').val());
                    $('#' + oSettings.self_define_text_id).val($('#' + oSettings.self_define_text_id + '_selfdefine_input').val());
                    $('#' + oSettings.self_define_text_id).attr('pre_value', $('#' + oSettings.self_define_text_id + '_selfdefine_input').val());
                    $('#' + oSettings.code_id).val($('#' + oSettings.self_define_text_id + '_selfdefine_code').val());
                    $('#' + oSettings.code_id).attr('pre_code', $('#' + oSettings.self_define_text_id + '_selfdefine_code').val());
                }
            }
        }
    }


    //技能特长-技能/语言
    $.fn.itskillAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'itskill_association',
            'text_id'                   : 'itskill_association_text',
            'code_id'                   : 'itskill_association_code',
            'under_id'                  : 'itskill_association_under',
            'association_id'            : 'itskill_association_id',
            'data'                      : itskill,
            'data_view_type'            : '2',
            'init_class'                : 'udbox',
            'init_sub_class'            : 'ul u3'
        };

        oSelfSettings.data_type = 'itskill';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //技能特长-证书
    $.fn.certAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'cert_association',
            'text_id'                   : 'cert_association_text',
            'code_id'                   : 'cert_association_code',
            'under_id'                  : 'cert_association_under',
            'association_id'            : 'cert_association_id',
            'data'                      : cert,
            'data_view_type'            : '2',
            'init_class'                : 'udbox',
            'init_sub_class'            : 'ul u3'
        };

        oSelfSettings.data_type = 'cert';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //求职意向-个人标签
    $.fn.personKeyVendorsAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'person_key_vendors_association',
            'text_id'                   : 'person_key_vendors_association_text',
            'code_id'                   : 'person_key_vendors_association_code',
            'under_id'                  : 'person_key_vendors_association_under',
            'association_id'            : 'person_key_vendors_association_id',
            'append_id'                 : 'person_key_vendors_association_append',
            'save_type'                 : '2',
            'save_code_type'            : '2',
            'association_type'          : '2',
            'data_struct_type'          : '2',
            'data_multiple'             : true,
            'data_multiple_max'         : 10,
            'keyup_fn'                  : associationEvent,
            'append_fn'                 : appendEvent,
            'saveEvent'                 : saveEvent
        };

        oSelfSettings.data_type = 'ResumeLabel';  //数据类型: 私有变量, 不可更改

        oSelfSettings.data_max_length = 24;

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.append_id).bind('click', oSettings, oSettings.append_fn);
        });


        function associationEvent(oEvent)
        {
            oEvent.stopPropagation();

            var oSettings = oEvent.data;

            if(!oSettings.upDownSelect(oEvent))
            {
                return;
            }

            if(typeof closeAllFloatDiv === "function")
            {
                closeAllFloatDiv($('#' + oSettings.float_on_id), $('#' + oSettings.float_index_id), $('#' + oSettings.text_id));
            }

            var sContent = '';

            var sTextValue = $('#' + oSettings.text_id).val();

            var sReg = / /g;

            if ((32 == oEvent.keyCode) && sReg.test(sTextValue))
            {
                $('#' + oSettings.text_id).val(sTextValue.replace(sReg, ""));
            }

            jQuery.commonSelect.initCurrentSelected(oSettings);

            oSettings.oLayerSettings = jQuery.commonAssociation.initLayerSettings(oSettings, {});

            oSettings.findData(oSettings, sTextValue);
        }


        function appendEvent(oEvent)
        {
            oEvent.stopPropagation();

            var oSettings = oEvent.data;

            var sContent = '';

            var sTextValue = $.trim($('#' + oSettings.text_id).val());

            jQuery.commonSelect.initCurrentSelected(oSettings);

            oSettings.oLayerSettings = jQuery.commonAssociation.initLayerSettings(oSettings, {});

            if ('' != sTextValue)
            {
                if (jQuery.commonSelect.canAdd(oSettings, sTextValue))
                {
                    if (canAddPersonKey(oSettings, sTextValue))
                    {
                        jQuery.commonSelect.save(oSettings, sTextValue, oSettings.data_struct_type);
                    }
                }
            }
        }


        function saveEvent(oEvent)
        {
            oEvent.stopPropagation();

            var oSettings = oEvent.data;

            var iSelect   = $(this).attr("data-value");

            if (jQuery.commonSelect.canAdd(oSettings, iSelect))
            {
                if (canAddPersonKey(oSettings, iSelect))
                {
                    aRepeatSelected = jQuery.commonSelect.getRepeatSelected(oSettings, iSelect);
                    if (aRepeatSelected.length > 0)
                    {
                        $.each(aRepeatSelected, function (i, value) {
                            jQuery.commonSelect.deleteSelect(oSettings, $('#' + oSettings.under_id + ' [data-value=' +value + ']'));
                        });
                    }

                    jQuery.commonSelect.save(oSettings, iSelect, oSettings.data_struct_type);


                    if (!oSettings.data_multiple)
                    {
                        $('#' + oSettings.float_on_id).removeClass('on').attr('float-on', false);
                        //$('#' + oSettings.float_index_id).css({'z-index':0}).attr('float-index', false);
                        $('#' + oSettings.float_index_id).attr('float-index', false).parents('.flboxwp,.ln,.c,.box').css("z-index", "");
                        oSettings.oLayerSettings.oLayerElement.attr('layer_float_on', false);
                    }
                }
            }
        }


        function canAddPersonKey(oSettings, sTextValue)
        {
            var bCanAddPersonKey = true;

            if (sTextValue.replace(/[^\x00-\xff]/gi,'xx').length > oSettings.data_max_length)
            {
                if (oSettings.data_add_error_alert)
                {
                    alert(lang['int_keywords_maxlength']);
                }

                bCanAddPersonKey = false;
            }

            return bCanAddPersonKey;
        }
    }


    //工作经验-公司
    $.fn.companyVendorsAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'company_vendors_association',
            'text_id'                   : 'company_vendors_association_text',
            'code_id'                   : 'company_vendors_association_code',
            'under_id'                  : 'company_vendors_association_under',
            'association_id'            : 'company_vendors_association_id',
            'association_type'          : '2',
            'data_struct_type'          : '2',
            'data_clear'                : false
        };

        oSelfSettings.data_type = 'Company';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //工作经验-职位名称
    $.fn.jobVendorsAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'job_vendors_association',
            'text_id'                   : 'job_vendors_association_text',
            'code_id'                   : 'job_vendors_association_code',
            'under_id'                  : 'job_vendors_association_under',
            'association_id'            : 'job_vendors_association_id',
            'association_type'          : '2',
            'data_struct_type'          : '2',
            'data_clear'                : false
        };

        oSelfSettings.data_type = 'Job';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //教育经历-学校
    $.fn.schoolVendorsAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'school_vendors_association',
            'text_id'                   : 'school_vendors_association_text',
            'code_id'                   : 'school_vendors_association_code',
            'under_id'                  : 'school_vendors_association_under',
            'association_id'            : 'school_vendors_association_id',
            'association_type'          : '2',
            'data_struct_type'          : '2',
            'data_clear'                : false
        };

        oSelfSettings.data_type = 'School';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }


    //教育经历-自定义专业
    $.fn.majorVendorsAssociation = function (options)
    {
        var oSettings = {};

        var oSelfSettings = {
            'id'                        : 'major_vendors_association',
            'text_id'                   : 'major_vendors_association_text',
            'code_id'                   : 'major_vendors_association_code',
            'under_id'                  : 'major_vendors_association_under',
            'association_id'            : 'major_vendors_association_id',
            'association_type'          : '2',
            'data_struct_type'          : '2',
            'data_clear'                : false
        };

        oSelfSettings.data_type = 'Major';  //数据类型: 私有变量, 不可更改

        return this.each(function () {
            if (options)
            {
                $.extend(oSettings, oDefaultSettings, oSelfSettings, options);
            }

            oSettings = jQuery.commonAssociation.init(oSettings);

            $('#' + oSettings.text_id).bind('keyup', oSettings, oSettings.keyup_fn);

            $('#' + oSettings.text_id).bind('click', oSettings, oSettings.keyup_fn);
        });
    }
})(jQuery);