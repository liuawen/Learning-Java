$.extend({
    commonAssociation:
        {
            ParentCategory: {},
            ChildCategory:{},
            ChildChildCategory: {},
            init: function (oSettings)
            {
                var aInit = [
                    'association_each',
                    'parent_association_click',
                    'association_each_click',
                    'under_each'
                ];

                $.each(aInit, function (i, value) {
                    oSettings[value] = oSettings.id + '_' + value;
                });

                var oFunctionInit = {
                    'keyup_fn'                     : jQuery.commonAssociation.associationEvent,
                    'recommend_click_fn'           : jQuery.commonAssociation.associationEvent,
                    'append_fn'                    : jQuery.commonAssociation.appendEvent,
                    'before_open'                  : jQuery.commonAssociation.beforeOpenEvent,
                    'after_close'                  : jQuery.commonAssociation.afterCloseEvent,

                    'getAssociationLayer'          : jQuery.commonAssociation.getAssociationLayer,
                    'findData'                     : jQuery.commonAssociation.findData,
                    'getFindAssociationData'       : jQuery.commonAssociation.getFindAssociationData,
                    'getFindVendorsAssociationData': jQuery.commonAssociation.getFindVendorsAssociationData,
                    'getFindVendorsRecommendData'  : jQuery.commonAssociation.getFindVendorsRecommendData,
                    'getFindContent'               : jQuery.commonAssociation.getFindContent,
                    'getAssociationContent'        : jQuery.commonAssociation.getAssociationContent,
                    'getNoDataContent'             : jQuery.commonAssociation.getNoDataContent,
                    'getSelfDefineContent'         : jQuery.commonAssociation.getSelfDefineContent,
                    'saveEvent'                    : jQuery.commonAssociation.saveEvent,
                    'deleteSelect'                 : jQuery.commonSelect.deleteSelect,
                    'upDownSelect'                 : jQuery.commonAssociation.upDownEvent,
                    'showSelfDefineBox'            : jQuery.commonAssociation.showSelfDefineBox,
                    'getSelfDefineDivCode'         : jQuery.commonAssociation.getSelfDefineDivCode,
                    'saveSelfDefine'               : jQuery.commonAssociation.saveSelfDefine,
                    'saveSelfDefineStep1'          : jQuery.commonSelect.saveSelfDefineStep1
                }

                $.each(oFunctionInit, function (i, value) {
                    if (('undefined' == typeof oSettings[i]) || ('' == oSettings[i])) {
                        oSettings[i] = value;
                    }
                });

                oSettings.ParentCategory     = {};
                oSettings.ChildCategory      = {};
                oSettings.ChildChildCategory = {};

                jQuery.commonSelect.setClearDataAttr(oSettings, '1');

                if("undefined" != typeof oSettings.float_on_id)
                {
                    $('#' + oSettings.float_on_id).attr('float-on', false);
                }

                return oSettings;
            },
            associationEvent: function (oEvent)
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                if(!jQuery.commonAssociation.upDownEvent(oEvent))
                {
                    return;
                }

                if(typeof closeAllFloatDiv === "function")
                {
                    closeAllFloatDiv($('#' + oSettings.float_on_id), $('#' + oSettings.float_index_id), $('#' + oSettings.text_id));
                }

                var sContent = '';

                var oText = $('#' + oSettings.text_id);
                var oCode = $('#' + oSettings.code_id);

                var sTextValue = $.trim(oText.val());

                jQuery.commonSelect.setClearDataAttr(oSettings, '2');

                jQuery.commonSelect.initCurrentSelected(oSettings);

                oSettings.oLayerSettings = jQuery.commonAssociation.initLayerSettings(oSettings, {});

                oSettings.findData(oSettings, sTextValue);
            },
            appendEvent: function (oEvent)
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
                        jQuery.commonSelect.save(oSettings, sTextValue, oSettings.data_struct_type);
                    }
                }
            },
            initLayerSettings: function (oSettings, options)  //初始化弹窗配置信息, 私有函数, 部分数据外部不可更改
            {
                var oLayerSettings = {};

                if ('undefined' == typeof oSettings.oLayerSettings)
                {
                    var oLayerSettings = {
                        'layer_id'              : oSettings.association_id,
                        'layer_class_name'      : oSettings.init_class,
                        'layer_sub_class_name'  : oSettings.init_sub_class,
                        'layer_type'            : '2',
                        'layer_z_index'         : 4,
                        'layer_append_type'     : oSettings.layer_append_type,
                        'layer_bind_id'         : oSettings.id,
                        'layer_offset'          : 0,
                        'layer_before_open'     : oSettings.before_open,
                        'layer_after_close'     : oSettings.after_close
                    };

                    oLayerSettings = jQuery.FLayer.init(oLayerSettings);
                }
                else
                {
                    oLayerSettings = oSettings.oLayerSettings;
                }

                oLayerSettings.oLayerElement.attr('layer_float_on', true);

                return oLayerSettings;
            },
            findData: function (oSettings, sTextValue)
            {
                if (oSettings.recommend && ('' == sTextValue))
                {
                    switch (oSettings.recommend_type)
                    {
                        case '1':  //不调用网才接口
                            oSettings.getFindRecommendData(oSettings, sTextValue);
                            break;

                        case '2':  //调用网才接口
                            oSettings.getFindVendorsRecommendData(oSettings, sTextValue);
                            break;
                    }
                }
                else if ('' != sTextValue)
                {
                    switch (oSettings.association_type)
                    {
                        case '1':  //不调用网才接口
                            oSettings.getFindAssociationData(oSettings, sTextValue);
                            break;

                        case '2':  //调用网才接口
                            oSettings.getFindVendorsAssociationData(oSettings, sTextValue);
                            break;
                    }
                }
                else if ('' == sTextValue)  //鼠标点到输入框上面/输入框内容清空
                {
                    oSettings.oLayerSettings.oLayerElement.hide();
                }
            },
            getFindRecommendData: function (oSettings, sTextValue)  //自行处理
            {
                oFindData = oSettings.data_recommend;

                oSettings.getFindContent(oSettings, oFindData, sTextValue);
            },
            getFindVendorsRecommendData: function (oSettings, sTextValue)  //调用网才接口
            {
            },
            getFindAssociationData: function (oSettings, sTextValue)  //自行处理: 都构造k:v的形式
            {
                switch (oSettings.data_child_depth)
                {
                    case '1':  //一级, 没有子类
                        if (0 == jQuery.commonSelect.getObjectKeys(oSettings.ParentCategory).length)
                        {
                            oSettings.ParentCategory = oSettings.data;
                        }
                        break;
                    case '2':  //二级, 只有一层子类
                        if (0 == jQuery.commonSelect.getObjectKeys(oSettings.ParentCategory).length)
                        {
                            $.each(oSettings.data, function (code, value) {
                                if ('00' == code.substr(2, 2))
                                {
                                    oSettings.ParentCategory[code] = value;
                                }
                                else
                                {
                                    oSettings.ChildCategory[code] = value;
                                }
                            });
                        }

                        break;

                    case '3':  //三级, 有二层子类
                        if (0 == jQuery.commonSelect.getObjectKeys(oSettings.ParentCategory).length)
                        {
                            $.each(oSettings.data, function (code, value) {
                                if ('0000' == code.substr(2, 4))
                                {
                                    switch (oSettings.data_child_type)
                                    {
                                        case '2':
                                            if (code != '360000')
                                            {
                                                oSettings.ParentCategory[code] = value;
                                            }
                                            break;

                                        default:
                                            oSettings.ParentCategory[code] = value;
                                            break;
                                    }
                                }
                                else if ('00' == code.substr(4, 2))
                                {
                                    oSettings.ChildCategory[code] = value;
                                }
                                else
                                {
                                    oSettings.ChildChildCategory[code] = value;
                                }
                            });
                        }
                        break;
                }

                var oFindData = {
                    'parent_category': [],
                    'child_category': [],
                    'childchild_category': []
                };

                sLowerCaseTextValue = sTextValue.toLowerCase();

                //需要增加判断: 根据参数, 从不同的类别里面进行查找
                $.each(oSettings.ParentCategory, function (code, value) {
                    value = value.toLowerCase();

                    if (-1 != value.indexOf(sLowerCaseTextValue) && (-1 == oFindData.parent_category.toString().indexOf(code))) {
                        oFindData.parent_category.push(code);
                    }
                });


                $.each(oSettings.ChildCategory, function (code, value) {
                    value = value.toLowerCase();

                    if (-1 != value.indexOf(sLowerCaseTextValue) && (-1 == oFindData.child_category.toString().indexOf(code))) {
                        oFindData.child_category.push(code);
                    }
                });

                $.each(oSettings.ChildChildCategory, function (code, value) {
                    value = value.toLowerCase();

                    if (-1 != value.indexOf(sLowerCaseTextValue) && (-1 == oFindData.childchild_category.toString().indexOf(code))) {
                        oFindData.childchild_category.push(code);
                    }
                });

                var oAssociationData = {};

                var aDeleteAssociationData = [];

                switch (oSettings.data_child_depth)
                {
                    case '1':  //一级, 没有子类
                        $.each(oFindData.parent_category, function (i, code) {
                            oAssociationData[code] = [];
                        });

                        break;

                    case '2':  //二级, 只有一层子类, 通过小类来查找大类
                        $.each(oFindData.child_category, function (i, code) {
                            if (-1 == aDeleteAssociationData.toString().indexOf(code))
                            {
                                var iParent = code.substr(0, 2) + '00';

                                if ('undefined' == typeof oAssociationData[iParent])
                                {
                                    oAssociationData[iParent] = [];
                                }

                                oAssociationData[iParent].push(code);
                            }
                        });
                        break;

                    case '3':  //三级, 有二层子类
                        //省只有一层
                        $.each(oFindData.parent_category, function (i, code) {
                            if (-1 == aDeleteAssociationData.toString().indexOf(code))
                            {
                                if ('undefined' == typeof oAssociationData[code])
                                {
                                    oAssociationData[code] = [];
                                }
                            }
                        });


                        //市需要去找省
                        $.each(oFindData.child_category, function (i, code) {
                            if (-1 == aDeleteAssociationData.toString().indexOf(code))
                            {
                                var iParent = code.substr(0, 2) + '0000';

                                if ('undefined' == typeof oAssociationData[code])
                                {
                                    oAssociationData[code] = [];
                                }

                                oAssociationData[code].push(iParent);
                            }
                        });


                        //区需要去找市和省
                        $.each(oFindData.childchild_category, function (i, code) {
                            if (-1 == aDeleteAssociationData.toString().indexOf(code))
                            {
                                var iParent = code.substr(0, 4) + '00';

                                var iParentParent = code.substr(0, 2) + '0000';

                                if ('undefined' == typeof oAssociationData[code])
                                {
                                    oAssociationData[code] = [];
                                }

                                oAssociationData[code].push(iParent);
                                oAssociationData[code].push(iParentParent);
                            }
                        });

                        break;
                }

                oSettings.getFindContent(oSettings, oAssociationData, sTextValue);
            },
            getFindVendorsAssociationData: function (oSettings, sTextValue)  //调用网才接口
            {
                var oFindData = {};

                $.ajax({
                    url: 'https://kwdsrv.51job.com/KwdSrvByKey/default.aspx',
                    data: {kwd: sTextValue, src: oSettings.data_type, rand: Math.random()},
                    dataType: 'jsonp',
                    cache: false,
                    async: false,
                    timeout: 1000,
                    success: function (data, statusText, jqXHR)
                    {
                        if ('1' == data.message)
                        {
                            if ('' != data.content)
                            {
                                $.each(unescape(data.content).split("\t"), function (i, value) {
                                    oFindData[i] = value;
                                });
                            }
                        }

                        oSettings.getFindContent(oSettings, oFindData, sTextValue);
                    },
                    error: function (jqXHR, textStatus, errorThrown)
                    {
                        oSettings.getFindContent(oSettings, oFindData, sTextValue);
                    }
                });
            },
            getFindContent: function (oSettings, oFindData, sTextValue)
            {
                var sContent = '';

                if (oSettings.recommend && ('' == sTextValue))
                {
                    sContent = oSettings.getRecommondContent(oSettings);
                }
                else if (jQuery.commonSelect.getObjectKeys(oFindData).length > 0)
                {
                    sContent = oSettings.getAssociationContent(oSettings, oFindData);
                }

                var bEmpty = false;
                if ('' == sContent)
                {
                    sContent = oSettings.getNoDataContent(oSettings);
                    bEmpty = true;
                }

                sContent = '<div class="' + oSettings.init_sub_class + '">' + sContent + '</div>' + oSettings.getSelfDefineContent(oSettings);

                jQuery.FLayer.setContent(oSettings.oLayerSettings, sContent);

                if (!bEmpty)
                {
                    jQuery.FLayer.setContent(oSettings.oLayerSettings, sContent);

                    //这里应该在beforeOpen函数里面
                    if (oSettings.recommend && ('' == sTextValue))
                    {
                        //绑定事件
                        $('#' + oSettings.association_id).find('.' + oSettings.association_each_click).bind('click', oSettings, oSettings.saveRecommendEvent);
                    }
                    else
                    {
                        //绑定事件
                        if (oSettings.data_parent_click)
                        {
                            $('#' + oSettings.association_id).find('.' + oSettings.parent_association_click).bind('click', oSettings, oSettings.saveEvent);
                        }

                        $('#' + oSettings.association_id).find('.' + oSettings.association_each_click).bind('click', oSettings, oSettings.saveEvent);
                    }
                }

                if(oSettings.self_define == '1')
                {
                    $('#' + oSettings.self_define_text_id + '_selfdefine_click').bind('click', oSettings, jQuery.commonAssociation.showSelfDefineBox);
                }

                if(oSettings.self_define == '1' || !bEmpty)
                {
                    jQuery.FLayer.open(oSettings);

                    $('#' + oSettings.float_on_id).addClass('on').attr('float-on', true).parents('.flboxwp,.ln,.c,.box').css("z-index", "4");;
                    //$('#' + oSettings.float_index_id).css({'z-index':4}).attr('float-index', true);
                    $('#' + oSettings.float_index_id).attr('float-index', true).css({'z-index':4});
                }
            },
            getRecommondContent: function (oSettings)
            {
                var sContent = '';

                sContent = '<span class="tl off"><span class="bg b_key">' + lang['layer']['relation_keyword'] + '</span></span>';

                $.each(oSettings.data_recommend, function (i, value) {
                    var sSelectedClass = '', sReal = '';

                    switch (oSettings.data_recommend_struct_type)
                    {
                        case '1':
                            sReal = i;
                            break;

                        case '2':
                            sReal = value;
                            break;
                    }

                    if (!oSettings.data_multiple && (sReal == jQuery.commonSelect.oCurrentSelected[oSettings.data_type].toString()))
                    {
                        sSelectedClass = oSettings.selected_class;
                    }
                    sContent += '<span data-value="' + sReal + '" class="li ' + sSelectedClass + ' ' + oSettings.association_each_click + '">'+ sReal +'</span>';
                });

                return sContent;
            },
            beforeOpenEvent: function (oEvent)
            {
            },
            afterCloseEvent: function (oEvent)
            {
            },
            getAssociationContent: function (oSettings, oAssociationData)
            {
                var sContent = '';

                $.each(oAssociationData, function (i, value) {
                    switch (oSettings.data_view_type)
                    {
                        case '1':  //平级展示
                            switch (oSettings.data_struct_type)
                            {
                                case '1':  //k:v
                                    sContent += '<span data-value="' + i + '" class="li '+ oSettings.association_each_click + '">' + oSettings.data[i] + '</span>';
                                    break;

                                case '2':  //v
                                    sContent += '<span data-value="' + value + '" class="li '+ oSettings.association_each_click + '">' + value + '</span>';
                                    break;
                            }

                            break;

                        case '2':  //层级展示
                            switch (oSettings.data_struct_type)
                            {
                                case '1':  //k:v
                                    if (oSettings.data_parent_click)
                                    {
                                        sContent += '<span class="tl tlw c_333"><span id="' + oSettings.association_each + '_' + i + '" data-value="' + i + '" class="' + oSettings.parent_association_click + '">' + oSettings.data[i] + '</span></span>';
                                    }
                                    else
                                    {
                                        sContent += '<span class="tl tlw off"><span id="' + oSettings.association_each + '_' + i + '" data-value="' + i + '">' + oSettings.data[i] + '</span></span>';
                                    }


                                    $.each(value, function (subIndex, subValue) {
                                        sContent += '<span id="' + oSettings.association_each + '_' + subValue + '" data-value="' + subValue + '" class="li '+ oSettings.association_each_click + '">' + oSettings.data[subValue] + '</span>';
                                    });
                                    break;

                                case '2':  //v, 没有
                                    break;
                            }

                            break;
                    }
                });


                return sContent;
            },
            getNoDataContent: function (oSettings)
            {
                var sContent = '';

                sContent = '<span class="li off">' + lang['layer']['no_data'] + '</span>';

                return sContent;
            },
            saveEvent: function (oEvent)
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                var iSelect   = $(this).attr("data-value");

                if (jQuery.commonSelect.canAdd(oSettings, iSelect))
                {
                    aRepeatSelected = jQuery.commonSelect.getRepeatSelected(oSettings, iSelect);

                    if (aRepeatSelected.length > 0)
                    {
                        switch (oSettings.save_type)
                        {
                            case '1':  //存储在文本框中 + 存储隐藏域
                                $.each(aRepeatSelected, function (i, value) {
                                    jQuery.commonSelect.deleteSelect(oSettings, value);
                                });
                                break;
                            case '2':  //存储在文本框下方 + 存储隐藏域
                                $.each(aRepeatSelected, function (i, value) {
                                    jQuery.commonSelect.deleteSelect(oSettings, $('#' + oSettings.under_id + ' [data-value=' +value + ']'));
                                });
                                break;
                        }
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
            },
            upDownEvent: function(oEvent)
            {
                oEvent.preventDefault();

                var oSettings = oEvent.data;

                if(oEvent.type == "click")
                {
                    return true;
                }
                var key = oEvent.keyCode;

                var listdiv = $("#" + oSettings.association_id);

                var oPreSelected = $("#" + oSettings.association_id).find("span.on");

                switch(key)
                {
                    case 38:
                        if(oPreSelected.length == 0)
                        {
                            listdiv.scrollTop(listdiv.children().length * 30);
                            $("#" + oSettings.association_id).find("span:last").addClass("on");
                        }
                        else
                        {
                            if(oPreSelected.position().top < 0 || oPreSelected.position().top > 180)
                            {
                                listdiv.scrollTop(oPreSelected.prev().position().top);
                            }
                            if(oPreSelected.prev().length == 0)
                            {
                                listdiv.scrollTop(listdiv.children().length * 30);
                                oPreSelected.removeClass("on");
                                $("#" + oSettings.association_id).find("span:last").addClass("on");
                            }
                            else
                            {
                                if(oPreSelected.prev().position().top <0)
                                {
                                    listdiv.scrollTop(listdiv.scrollTop() - 30);
                                }
                                oPreSelected.removeClass("on").prev().addClass("on");
                            }
                        }
                        return false;
                        break;
                    case 40:
                        if(oPreSelected.length == 0)
                        {
                            listdiv.scrollTop(0);
                            $("#" + oSettings.association_id).find("span:first").addClass("on");
                        }
                        else
                        {
                            if(oPreSelected.next().length == 0)
                            {
                                listdiv.scrollTop(0);
                                oPreSelected.removeClass("on");
                                $("#" + oSettings.association_id).find("span:first").addClass("on");
                            }
                            else
                            {
                                if(oPreSelected.position().top<0 || oPreSelected.position().top>180)
                                {
                                    listdiv.scrollTop(oPreSelected.next().position().top);
                                }
                                if(oPreSelected.next().position().top > 180)
                                {
                                    listdiv.scrollTop(listdiv.scrollTop() + 30);
                                }
                                oPreSelected.removeClass("on").next().addClass("on");
                            }
                        }
                        return false;
                        break;
                    case 13:
                        if(oPreSelected.length == 0)
                        {
                            return;
                        }
                        else
                        {
                            if(oPreSelected.hasClass("tl"))
                            {
                                oPreSelected.children().click();
                            }
                            else
                            {
                                oPreSelected.click();
                            }
                        }
                        return false;
                        break;
                    default:
                        return true;
                        break;
                }
            },
            showSelfDefineBox: function(oEvent)
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.FLayer.close(oSettings);

                if($(oSettings.self_define_text_id + '_selfdefine_div').length > 0)
                {
                    $(oSettings.self_define_text_id + '_selfdefine_div').show();
                }
                else
                {
                    oSelfDefineLayerSettings = jQuery.FLayer.init();
                    jQuery.FLayer.setContent(oSelfDefineLayerSettings, oSettings.getSelfDefineDivCode(oSettings));
                    $('#' + oSettings.self_define_text_id + '_selfdefine_input').focus(function(){
                        $(this).parent().addClass("focusinput");
                    }).blur(function(){
                        $(this).parent().removeClass("focusinput");
                    });

                    if(oSettings.self_define == '1')
                    {
                        $('#' + oSettings.self_define_text_id + '_selfdefine_input').val($('#' + oSettings.text_id).val());
                        if(typeof(oSettings.self_define_data) != 'undefined' && oSettings.self_define_data.length != 0)
                        {
                            $('#' + oSettings.self_define_text_id + '_selfdefine_div').find('.' + oSettings.association_each_click).bind('click', oSettings, oSettings.saveSelfDefineStep1);
                        }
                    }

                    oSettings.self_define_settings = oSelfDefineLayerSettings;
                    $("#" + oSettings.self_define_text_id + '_selfdefine_button').bind('click', oSettings, oSettings.saveSelfDefine);

                    jQuery.FLayer.open(oSelfDefineLayerSettings);
                    var selfDefineInput = $('#' + oSettings.self_define_text_id + '_selfdefine_input');
                    var text = selfDefineInput.val();
                    selfDefineInput.val($('#' + oSettings.text_id).val());
                    selfDefineInput.val(text);
                    selfDefineInput.focus();
                }
            },
            getSelfDefineContent: function (oSettings)
            {
                sContent = '';
                if(oSettings.self_define == '1')
                {
                    sContent = '<div class="' + oSettings.init_selfdefine_class + '" id="' + oSettings.self_define_text_id + '_selfdefine_click">' + lang[oSettings.data_type]['self_define_button'] + '</div>';
                }

                return sContent;
            },
            getSelfDefineDivCode: function(oSettings)
            {
                sCode = '<div class="panel_lnp panel_py Fm" id="' + oSettings.self_define_text_id + '_selfdefine_div">'
                    +'<h2><p>' + lang['layer']['self_define'] + lang[oSettings.data_type]['layer_name'] + '</p><a class="layer_close" href="javascript:void(0);"><i></i></a></h2>'
                    +'<div class="pannel_con">'
                    +'<div class="gp8 clearfix">'
                    +'<div class="txt focusinput">'
                    +'<input class="ef cursor" type="text" placeholder="' + lang['self_define']['self_define_placeholder1'] + (oSettings.language == 'c' ? oSettings.max_self_define_length/2 : oSettings.max_self_define_length) + lang['self_define']['self_define_placeholder2'] + '" id="' + oSettings.self_define_text_id + '_selfdefine_input" maxlength="' + oSettings.max_self_define_length + '" value="' + $('#' + oSettings.self_define_text_id).val() + '">'
                    +'</div>'
                    +'<div class="err" id="' + oSettings.self_define_text_id + '_selfdefine_error"></div>'
                    +'</div>'
                    +'</div>'
                    +'<div class="but_box b2">'
                    +'<span class="p_but" id="' + oSettings.self_define_text_id + '_selfdefine_button">' + lang['layer']['save'] + '</span>'
                    +'</div></div>';

                return sCode;
            },
            saveSelfDefine: function(oEvent){

                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                if($.trim($("#" + oSettings.self_define_text_id + '_selfdefine_input').val()) == '')
                {
                    $("#" + oSettings.self_define_text_id + '_selfdefine_error').text(lang[oSettings.data_type]['self_define_error1']).show();
                    return;
                }
                else
                {
                    if(jQuery.commonAssociation.strlength($("#" + oSettings.self_define_text_id + '_selfdefine_input').val()) > oSettings.max_self_define_length)
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
                    }
                }
            },
            strlength: function(str){
                return str.replace(/[^\x00-\xff]/gi,'xx').length;
            }
        }
});