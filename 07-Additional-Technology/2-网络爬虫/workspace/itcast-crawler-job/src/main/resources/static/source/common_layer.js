/**
 * @brief   通用弹窗处理类操作
 * @note    通用弹窗处理类操作, 职能, 行业, 居住地, 户口
 * @author  fly.yang
 * @version 1.0
 * @since   2016-06-08
 */
$.extend({
    commonLayer:
        {
            init: function (oSettings)
            {
                var aInit = [
                    'init',
                    'top',
                    'top_message',
                    'multiple',
                    'multiple_selected',
                    'multiple_selected_each',
                    'multiple_error',
                    'center',
                    'center_left',
                    'center_left_each',
                    'center_right',
                    'center_right_list',
                    'center_right_list_category',
                    'center_right_list_sub_category',
                    'center_right_list_sub_category_each',
                    'center_right_list_sub_category_each_all',
                    'center_right_list_sub_category_each_unit',
                    'bottom',
                    'bottom_save',
                    'close',
                    'under_each'
                ];

                $.each(aInit, function (i, value) {
                    oSettings[value] = oSettings.id + '_' + value;
                });

                var oFunctionInit = {
                    'data_init'                  : jQuery.commonLayer.getInitContent,
                    'layer_before_open'          : jQuery.commonLayer.beforeOpen,
                    'layer_after_open'           : jQuery.commonLayer.afterOpen,
                    'data_click'                 : jQuery.commonLayer.chooseEvent,
                    'getTopContent'              : jQuery.commonLayer.getTopContent,
                    'getTopMessageContent'       : jQuery.commonLayer.getTopMessageContent,
                    'getTopMultipleContent'      : jQuery.commonLayer.getTopMultipleContent,
                    'getCenterContent'           : jQuery.commonLayer.getCenterContent,
                    'getCenterLeftContent'       : jQuery.commonLayer.getCenterLeftContent,
                    'getCenterRightContent'      : jQuery.commonLayer.getCenterRightContent,
                    'getCenterRightCenterContent': jQuery.commonLayer.getCenterRightCenterContent,
                    'getBottomContent'           : jQuery.commonLayer.getBottomContent,
                    'getSubContent'              : jQuery.commonLayer.getSubContent
                };

                $.each(oFunctionInit, function (i, value) {
                    if (('' == oSettings[i]) || ('undefined' == typeof oSettings[i])) {
                        oSettings[i] = value;
                    }
                });

                return oSettings;
            },
            chooseEvent: function (oEvent)  //弹窗展示
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                oSettings.oLayerSettings = jQuery.commonLayer.initLayerSettings(oSettings, {});

                if(typeof closeAllFloatDiv === "function")
                {
                    closeAllFloatDiv();
                }

                jQuery.FLayer.setContent(oSettings.oLayerSettings, oSettings.data_init(oSettings));
                jQuery.FLayer.open(oSettings);
            },
            initLayerSettings: function (oSettings, options)  //初始化弹窗配置信息
            {
                if ('undefined' == typeof oSettings.oLayerSettings)
                {
                    var oLayerSettings = {
                        'layer_id'         : oSettings.layer_id,
                        'layer_type'       : '1',
                        'layer_before_open': oSettings.layer_before_open,
                        'layer_after_open' : oSettings.layer_after_open,
                        'layer_after_close': oSettings.layer_after_close,
                        'layer_init'       : true
                    };

                    oLayerSettings = jQuery.FLayer.init(oLayerSettings);
                }
                else
                {
                    oLayerSettings = oSettings.oLayerSettings;
                }

                return oLayerSettings;
            },
            getInitContent: function (oSettings)  //弹窗内容初始化
            {
                jQuery.commonSelect.initCurrentSelected(oSettings);

                var sContent = '<div id="' + oSettings.init + '" class="panel_lnp panel_py ' + oSettings.init_class + '">' + oSettings.getTopContent(oSettings) + oSettings.getCenterContent(oSettings) + oSettings.getBottomContent(oSettings) + '</div>';

                return sContent;
            },
            getTopContent: function (oSettings)  //弹窗内容: 顶部: getTopMessageContent + getMultipleContent
            {
                return (oSettings.getTopMessageContent(oSettings) + oSettings.getTopMultipleContent(oSettings));
            },
            getTopMessageContent: function (oSettings)  //弹窗内容顶部: 消息部分
            {
                var sContent = '<h2 id="' + oSettings.top + '">' + '<p id="' + oSettings.top_message + '">' + lang['layer']['select'] + lang[oSettings.data_type]['layer_name'];

                if (oSettings.data_multiple)
                {
                    sContent += '<span class="sp">（' + lang['layer']['data_max_select'].replace(/{max}/, '<strong>' + oSettings.data_multiple_max + '</strong>') + '）</span>';
                }

                sContent += '</p>' + '<a class="' + oSettings.close + '" href="javascript:void(0);"><i></i></a>' + '</h2>';

                return sContent;
            },
            getTopMultipleContent: function (oSettings)  //弹窗内容顶部: 多选部分
            {
                var sContent = '';

                if (oSettings.data_multiple)
                {
                    var sHideClass = '';

                    if (0 == jQuery.commonSelect.oCurrentSelected[oSettings.data_type].length)
                    {
                        sHideClass = 'element_hide';
                    }

                    sContent = '<div id="' + oSettings.multiple + '" class="panel_tags mk ' + sHideClass + '">' +
                        '<div class="tin" id="' + oSettings.multiple_selected + '">';

                    $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                        sContent += '<span id="' + oSettings.multiple_selected_each + '_' + value + '" class="ttag" data-value="' + value + '"><span>' + oSettings.data[value] + '</span><em></em></span>';
                    });

                    sContent += '</div>' + '<p id="' + oSettings.multiple_error + '" class="error element_hide">' + lang['layer']['data_max_select'].replace(/{max}/, oSettings.data_multiple_max) + '</p>' + '</div>';
                }

                return sContent;
            },
            getCenterContent: function (oSettings)  //弹窗内容中间: getCenterLeftContent + getCenterRightContent
            {
                return '<div id="' + oSettings.center + '" class="panel_selt">' + oSettings.getCenterLeftContent(oSettings) + oSettings.getCenterRightContent(oSettings) + '</div>' ;
            },
            getCenterLeftContent: function (oSettings)  //弹窗内容左侧
            {
                var sContent = '<ul id="' + oSettings.center_left + '" class="sbar">';

                $.each(oSettings.data_navigation, function (i, oInfo) {
                    if ('0' == i)
                    {
                        sSelectedClass = oSettings.selected_class;
                    }
                    else
                    {
                        sSelectedClass = '';
                    }

                    sContent += '<li id="' + oSettings.center_left_each + '_' + oInfo.nav + '" class="' + sSelectedClass+ '" data-value="' + oInfo.nav + '">' + oInfo[oSettings.language] + '<em></em></li>';
                });

                sContent += '</ul>';

                return sContent;
            },
            getCenterRightContent: function (oSettings)  //弹窗内容右侧: getCenterRightCenterContent + 取消浮动
            {
                return '<div id="' + oSettings.center_right + '" class="con">' + oSettings.getCenterRightCenterContent(oSettings, oSettings.data_navigation[0]['nav']) + '<div class="declear"></div>' + '</div><div class="clear"></div>';
            },
            getCenterRightCenterContent: function (oSettings, iNavigationId)  //弹窗内容右侧: 显示与指定导航关联的大类
            {
                var sContent = '<div id="' + oSettings.center_right_list + '_' + iNavigationId + '" class="' + oSettings.center_right_list + ' de d3">' +
                    '<table><tbody>';

                //每行显示3条记录, 不足的补充
                $.each(jQuery.commonLayer.getBigCategoryByNavigation(oSettings, iNavigationId), function (i, value) {
                    if (0 == i%oSettings.data_row_num)
                    {
                        sContent += '<tr>';
                    }

                    sContent += '<td class="js_more" name="0"><em id="' + oSettings.center_right_list_category + '_' + iNavigationId + '_' + value + '" data-value="' + value + '" data-navigation="' + iNavigationId + '" class="' + jQuery.commonLayer.getSelectedClass(oSettings, value) + '">' +　oSettings.data[value] + '</em></td>';

                    if ((oSettings.data_row_num - 1) === i%oSettings.data_row_num)
                    {
                        sContent += '</tr>';
                    }
                });

                sContent +=    '</tbody></table>' +
                    '</div>';

                return sContent;
            },
            getBigCategoryByNavigation: function(oSettings, iNavigationId)  //通过左侧导航获取大类列表
            {
                var aBigCategory = [];

                $.each(oSettings.data_navigation, function (i, value) {
                    if (value.nav == iNavigationId)
                    {
                        aBigCategory = value.category;

                        return;
                    }
                });

                return aBigCategory;
            },
            getBottomContent: function (oSettings)  //弹窗内容底部
            {
                var sContent = '';

                if (oSettings.data_multiple)
                {
                    sContent = '<div id="'+ oSettings.bottom + '" class="but_box">' +
                        '<span class="p_but" id="' + oSettings.bottom_save + '">' + lang['layer']['save'] + '</span><span class="p_but gray ' + oSettings.close + '">' + lang['layer']['cancel'] + '</span>' +
                        '</div>';
                }

                return sContent;
            },
            beforeOpen: function (oSettings)  //弹窗展示之前的处理, 元素绑定事件
            {
                if (oSettings.data_multiple)  //绑定顶部多选元素的事件
                {
                    //绑定已选择元素删除事件
                    $('#' + oSettings.multiple_selected).find('.ttag').bind('click', oSettings, jQuery.commonLayer.deleteSelectEvent);

                    //绑定保存事件
                    $('#' + oSettings.bottom_save).bind('click', oSettings, jQuery.commonLayer.saveEvent);
                }

                //绑定点击左侧导航事件
                $('#' + oSettings.center_left).find('li').bind('click', oSettings, jQuery.commonLayer.showCenterRightCenterEvent);

                //绑定右侧大类点击事件
                $('#' + oSettings.center_right).find('td em').bind('click', oSettings, jQuery.commonLayer.getSelectEvent);

                //绑定取消, 关闭事件
                $('.' + oSettings.close).bind('click', oSettings, jQuery.commonLayer.closeEvent);
            },
            afterOpen: function(oSettings)   //弹窗展示之后的处理，例如异步加载内容等，可在外部重写该方法
            {
                return;
            },
            deleteSelectEvent: function (oEvent)  //删除选中项事件处理
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.commonLayer.deleteSelect(oSettings, $(this).attr("data-value"));
            },
            deleteSelect: function (oSettings, iSelect)
            {
                jQuery.commonSelect.deleteSelect(oSettings, $('#' + oSettings.multiple_selected_each + '_' + iSelect));

                $('#' + oSettings.under_each + '_' + iSelect).remove();

                var oMultiple = $('#' + oSettings.multiple);

                if (0 == oMultiple.find('.ttag').length)
                {
                    oMultiple.hide();
                }
                else
                {
                    $('#' + oSettings.multiple_error).hide();
                }

                jQuery.commonLayer.removeSelectedClass(oSettings, iSelect);
            },
            getSelectedClass: function (oSettings, iSelect)
            {
                var sSelectedClass = '';

                if ('' == oSettings.data_map || 'undefined' == typeof oSettings.data_map[iSelect])  //没有大小类关系/没有小类
                {
                    if($.inArray(iSelect, jQuery.commonSelect.oCurrentSelected[oSettings.data_type].toString().split(",")) > -1)
                    // if (iSelect != "01" && -1 != jQuery.commonSelect.oCurrentSelected[oSettings.data_type].toString().indexOf(iSelect))
                    {
                        sSelectedClass = oSettings.selected_class;
                    }
                }

                return sSelectedClass;
            },
            addSelectedClass: function (oSettings, iSelect, iNavigation)
            {
                $.each($('#' + oSettings.center_right + ' [data-value=' +iSelect + ']'), function (i, value) {
                    $(this).addClass(oSettings.selected_class);
                });
            },
            removeSelectedClass: function (oSettings, iSelect)
            {
                $.each($('#' + oSettings.center_right + ' [data-value=' +iSelect + ']'), function (i, value) {
                    $(this).removeClass(oSettings.selected_class);
                });
            },
            showCenterRightCenterEvent: function (oEvent)  //点击左侧导航, 显示右侧内容
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                var iNavigationId   = $(this).attr('data-value');

                $(this).addClass(oSettings.selected_class);
                $(this).siblings().removeClass(oSettings.selected_class);

                var aCenterRightList = $('#' + oSettings.center_right).find('.' + oSettings.center_right_list);

                aCenterRightList.hide();

                var oCurrentCenterRighList = $('#' + oSettings.center_right_list + '_' + iNavigationId);

                if (oCurrentCenterRighList.length > 0)  //直接显示右边数据
                {
                    oCurrentCenterRighList.show();
                }
                else  //构造数据
                {
                    aCenterRightList.eq(0).after(oSettings.getCenterRightCenterContent(oSettings, iNavigationId));

                    //绑定大类点击事件
                    $('#' + oSettings.center_right_list + '_' + iNavigationId).find('td em').bind('click', oSettings, jQuery.commonLayer.getSelectEvent);
                }
                if(oSettings.data_type == 'area' && iNavigationId == '000000')
                {
                    $('#work_position_special_area_zhusanjiao').show();
                }
                else
                {
                    $('#work_position_special_area_zhusanjiao').hide();
                }

                $('#' + oSettings.center_right).find('.' + oSettings.center_right_list_sub_category).css({'position':'static'}).remove();
            },
            getSelectEvent: function (oEvent)  //大类点击事件: 有小类则显示小类, 没有小类, 则对当前选择项进行处理
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                var iSelect = $(this).attr('data-value');

                var iNavigation = $(this).attr('data-navigation');

                aSub = jQuery.commonLayer.getSub(oSettings, iSelect);

                if (aSub.length > 0)  //有子选项
                {
                    if (!$(this).hasClass(oSettings.center_right_list_sub_category_each_all))  //没有选择'所有'
                    {
                        $('#' + oSettings.center_right).find('.' + oSettings.center_right_list_sub_category).hide();

                        if ($('#' + oSettings.center_right_list_sub_category + '_' + iNavigation + '_' + iSelect).length > 0)  //子选项隐藏起来来, 将子选项显示出来
                        {
                            $('#' + oSettings.center_right_list_sub_category + '_' + iNavigation + '_' + iSelect).show();
                        }
                        else  //创建子选项
                        {
                            $(this).parent().parent().after(oSettings.getSubContent(oSettings, aSub, $(this), iSelect));

                            var oCurrentCenterRightListSubCategory = $('#' + oSettings.center_right_list_sub_category + '_' + iNavigation + '_' + iSelect);

                            if (oSettings.data_parent_click)
                            {
                                oCurrentCenterRightListSubCategory.find('.' + oSettings.center_right_list_sub_category_each_all).bind('click', oSettings, jQuery.commonLayer.getSelectEvent);
                            }

                            oCurrentCenterRightListSubCategory.find('.' + oSettings.center_right_list_sub_category_each_unit).bind('click', oSettings, jQuery.commonLayer.getSelectEvent);
                        }
                    }
                    else
                    {
                        jQuery.commonLayer.setSelect(oSettings, iSelect, iNavigation);
                    }
                }
                else  //没有子选项/选择的是大类, 直接设置
                {
                    jQuery.commonLayer.setSelect(oSettings, iSelect, iNavigation);
                }
            },
            getSub: function (oSettings, iBig)  //获取子类和大类的映射数组
            {
                var aSub = [];

                if ('string' == typeof oSettings.data[iBig]) {
                    if (('' != oSettings.data_map) && ('undefined' != typeof oSettings.data_map[iBig]) && ('' != oSettings.data_map[iBig]))
                    {
                        aSub = oSettings.data_map[iBig].split(',');
                    }
                }

                return aSub;
            },
            getSubContent: function (oSettings, aSub, oJqueryElement, iSelect)  //获取小类内容
            {
                var sContent = '', sSelectedClass = '';

                if (-1 != jQuery.commonSelect.oCurrentSelected[oSettings.data_type].toString().indexOf(iSelect))
                {
                    sSelectedClass = oSettings.selected_class;
                }

                iNavigationId = oJqueryElement.attr('data-navigation');

                sContent += '<tr class="' + oSettings.center_right_list_sub_category + '" id="' + oSettings.center_right_list_sub_category + '_' + iNavigationId + '_' + iSelect + '">'
                    + '<td colspan="' + oSettings.data_row_num + '"><div class="in d0"><font style="left:' + jQuery.commonLayer.getArrowPosition(oJqueryElement) + 'px"></font><div>';
                if(oSettings.data_parent_click)
                {
                    sContent += '<span><em id="' + oSettings.center_right_list_sub_category_each + '_' + iNavigationId + '_' + iSelect + '" class="' + sSelectedClass + ' ' + oSettings.center_right_list_sub_category_each_all + '" data-value="' + iSelect + '" data-navigation="' + iNavigationId + '">' + lang['layer']['all'] + '</em></span>';
                }
                $.each(aSub, function (i, value) {
                    sSelectedClass = '';

                    if (-1 != jQuery.commonSelect.oCurrentSelected[oSettings.data_type].toString().indexOf(value))
                    {
                        sSelectedClass = oSettings.selected_class;
                    }

                    sContent += '<span><em id="' + oSettings.center_right_list_sub_category_each + '_' + iNavigationId + '_' + value + '" class="' + oSettings.center_right_list_sub_category_each_unit + ' ' + sSelectedClass + '" data-value="' + value + '" data-navigation="' + iNavigationId + '">'+ oSettings.data[value] + '</em></span>';
                });
                sContent += '</div></div></td></tr>';

                return sContent;
            },
            getArrowPosition: function (oJqueryElement)  //获取小箭头的位置
            {
                return oJqueryElement.position().left + oJqueryElement.width()/2;
            },
            setSelect: function (oSettings, iSelect, iNavigation)  //设置选择处理
            {
                //1. 判断是添加还是删除
                //2. 如果是添加, 判断是否可以进行添加
                if (oSettings.data_multiple)
                {
                    sOperation = jQuery.commonLayer.getOperation(oSettings, iSelect);

                    switch (sOperation)
                    {
                        case 'add':
                            if (jQuery.commonSelect.canAdd(oSettings, iSelect))
                            {
                                jQuery.commonLayer.add(oSettings, iSelect, iNavigation);
                            }
                            else
                            {
                                $('#' + oSettings.multiple_error).show();
                            }
                            break;

                        case 'delete':
                            jQuery.commonLayer.deleteSelect(oSettings, iSelect);
                            break;
                    }
                }
                else
                {
                    jQuery.commonSelect.replaceCurrentSelected(oSettings, iSelect);
                    jQuery.commonSelect.save(oSettings, iSelect, oSettings.data_struct_type);
                }
            },
            getOperation: function (oSettings, iSelect)  //获取操作类型
            {
                var sOperation = 'add';

                var bFind = false;

                $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                    if (value == iSelect)
                    {
                        bFind = true;

                        return;
                    }
                });

                if (bFind)
                {
                    sOperation = 'delete';
                }

                return sOperation;
            },
            add: function (oSettings, iSelect, iNavigation)  //添加操作
            {
                aRepeatSelected = jQuery.commonSelect.getRepeatSelected(oSettings, iSelect);

                if (aRepeatSelected.length > 0)
                {
                    $.each(aRepeatSelected, function (i, value) {
                        jQuery.commonLayer.deleteSelect(oSettings, value);
                    });
                }

                oMultipleSelectedEach = $('<span id="' + oSettings.multiple_selected_each + '_' + iSelect + '" class="ttag" data-value="' + iSelect + '"><span>' + oSettings.data[iSelect] + '</span><em></em></span>').appendTo($('#' + oSettings.multiple_selected));
                oMultipleSelectedEach.bind('click', oSettings, jQuery.commonLayer.deleteSelectEvent);

                $('#' + oSettings.multiple).show();

                jQuery.commonLayer.addSelectedClass(oSettings, iSelect, iNavigation);

                jQuery.commonSelect.saveCurrentSelected(oSettings, iSelect);
            },
            closeEvent: function (oEvent)  //关闭事件处理
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.commonSelect.initCurrentSelected(oSettings);

                jQuery.FLayer.close(oSettings);

                return false;
            },
            saveEvent: function (oEvent)  //处理保存事件
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.commonSelect.save(oSettings, '', oSettings.data_struct_type);

                jQuery.FLayer.close(oSettings);
            }
        }
});