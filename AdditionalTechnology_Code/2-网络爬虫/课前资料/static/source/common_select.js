$.extend({
    commonSelect:
        {
            oCurrentSelected: {},
            oSaveCodeTypeSplit:
                {
                    '1': ',',
                    '2': ' '
                },
            oSaveTextTypeSplit:
                {
                    '1': '+',
                    '2': ' '
                },
            sMunicipalityArea: '010000,020000,040000,050000,060000',
            sForeignArea: '361000,362000,363000,364000,365000,366000',
            sPecialArea: '01',
            initCurrentSelected: function (oSettings)  //将已选择的code, 存储在全局变量oCurrentSelected
            {
                if ('' != $('#' + oSettings.code_id).val())
                {
                    jQuery.commonSelect.oCurrentSelected[oSettings.data_type] = $('#' + oSettings.code_id).val().split(jQuery.commonSelect.oSaveCodeTypeSplit[oSettings.save_code_type]);
                }
                else
                {
                    jQuery.commonSelect.oCurrentSelected[oSettings.data_type] = [];
                }
            },
            saveEvent: function (oEvent)  //处理保存事件
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                var iSelect   = $(this).attr("data-value");

                if (jQuery.commonSelect.canAdd(oSettings, iSelect))
                {
                    jQuery.commonSelect.save(oSettings, iSelect, oSettings.data_struct_type);
                }
            },
            saveRecommendEvent: function (oEvent)
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.commonSelect.save(oSettings, $(this).attr("data-value"), oSettings.data_recommend_struct_type);
            },
            getRepeatSelected: function (oSettings, iSelect)  //获取重复的选项
            {
                var aRepeatSelected = [];

                $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                    switch (oSettings.data_length)
                    {
                        case '1':  //每项数据源长度为4位
                            if (iSelect == iSelect.substr(0, 2) + '00')
                            {
                                if (value.substr(0, 2) == iSelect.substr(0, 2))
                                {
                                    aRepeatSelected.push(value);
                                }
                            }
                            else  //删除已选中里面的大类
                            {
                                if ((value.substr(0, 2) == iSelect.substr(0, 2)) && (value == value.substr(0, 2) + '00'))
                                {
                                    aRepeatSelected.push(value);
                                }
                            }
                            break;

                        case '2':  //每项数据源长度为6位
                            switch (oSettings.data_type)
                            {
                                case 'area':
                                    if(iSelect != "01")
                                    {
                                        if (-1 == jQuery.commonSelect.sMunicipalityArea.indexOf(iSelect.substr(0, 2) + '0000'))  //不是直辖市
                                        {
                                            if (iSelect == iSelect.substr(0, 2) + '0000')  //选中的是省, 删除选中里面的市区
                                            {
                                                if (value.substr(0, 2) == iSelect.substr(0, 2))
                                                {
                                                    aRepeatSelected.push(value);
                                                }
                                            }
                                            else if (iSelect == iSelect.substr(0, 4) + '00')  //选中的是市, 删除已选中里面的省市区
                                            {
                                                if (value.substr(0, 2) == iSelect.substr(0, 2) && (value == value.substr(0, 2) + '0000'))
                                                {
                                                    aRepeatSelected.push(value);
                                                }

                                                if (value.substr(0, 4) == iSelect.substr(0, 4))
                                                {
                                                    aRepeatSelected.push(value);
                                                }
                                            }
                                            else  //选中的是区, 删除已选中里面的省和市
                                            {
                                                if (value.substr(0, 2) == iSelect.substr(0, 2) && (value == value.substr(0, 2) + '0000'))
                                                {
                                                    aRepeatSelected.push(value);
                                                }

                                                if (value.substr(0, 4) == iSelect.substr(0, 4) && (value == value.substr(0, 4) + '00'))
                                                {
                                                    aRepeatSelected.push(value);
                                                }
                                            }
                                        }
                                        else  //是直辖市
                                        {
                                            if (iSelect == iSelect.substr(0, 2) + '0000')
                                            {
                                                if (value != "01" && (value.substr(0, 2) == iSelect.substr(0, 2)))
                                                {
                                                    aRepeatSelected.push(value);
                                                }
                                            }
                                            else  //删除已选中里面的大类
                                            {
                                                if ((value.substr(0, 2) == iSelect.substr(0, 2)) && (value == value.substr(0, 2) + '0000'))
                                                {
                                                    aRepeatSelected.push(value);
                                                }
                                            }
                                        }
                                    }
                                    break;

                                default:
                                    break;
                            }
                            break;
                    }
                });

                return aRepeatSelected;
            },
            canAdd: function (oSettings, iSelect)  //判断是否可以添加
            {
                var bCanAdd = true;

                aRepeatSelected = jQuery.commonSelect.getRepeatSelected(oSettings, iSelect);

                if (0 == aRepeatSelected.length)
                {
                    if (oSettings.data_multiple)  //1. 已有的不能进行添加, 出提示框 2. 没有的超过5项, 不能添加, 出提示框
                    {
                        if (jQuery.commonSelect.oCurrentSelected[oSettings.data_type].length < oSettings.data_multiple_max)
                        {
                            $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                                if ($.trim(value) == $.trim(iSelect)) {
                                    bCanAdd = false;

                                    if (oSettings.data_add_error_alert)
                                    {
                                        alert(lang['layer']['data_added']);
                                    }

                                    return false;
                                }
                            });
                        }
                        else
                        {
                            if (oSettings.data_add_error_alert)
                            {
                                alert(lang['layer']['data_max_select'].replace(/{max}/, oSettings.data_multiple_max));
                            }

                            bCanAdd = false;
                        }
                    }
                }

                return bCanAdd;
            },
            save: function (oSettings, iSelect, sDataStructType)  //保存处理, 关闭弹窗
            {
                if ('' != iSelect)
                {
                    jQuery.commonSelect.saveCurrentSelected(oSettings, iSelect);
                }

                switch (oSettings.save_type)
                {
                    case '1':  //存储在文本框中 + 存储隐藏域
                        jQuery.commonSelect.saveText(oSettings, iSelect, sDataStructType);
                        jQuery.commonSelect.saveCode(oSettings);
                        break;

                    case '2':  //存储在文本框下方 + 存储隐藏域
                        jQuery.commonSelect.saveUnderText(oSettings, iSelect, sDataStructType);
                        jQuery.commonSelect.saveCode(oSettings);
                        break;
                }

                if (!oSettings.data_multiple)
                {
                    jQuery.FLayer.close(oSettings);
                }
                jQuery.commonSelect.setClearDataAttr(oSettings, '3');
            },
            setClearDataAttr: function (oSettings, sSetType)
            {
                if (!oSettings.data_multiple)  //单选才有这样的功能
                {
                    if (('undefined' == typeof oSettings.data_clear) || (true === oSettings.data_clear))  //弹窗选择 || 联想
                    {
                        var oText = $('#' + oSettings.text_id);
                        var oCode = $('#' + oSettings.code_id);

                        switch (sSetType)
                        {
                            case '1':  //刚进入页面, 输入框有值, 设置为true, 否则设置为false
                                oText.attr('pre_value', oText.val());
                                oCode.attr('pre_code', oCode.val());
                                if(oSettings.self_define == '1')
                                {
                                    $("#" + oSettings.self_define_text_id).attr('pre_value', $("#" + oSettings.self_define_text_id).val());
                                }
                                break;

                            case '2':  //输入框里面填写内容发生了变化
                                if (oText.val() != oText.attr('pre_value'))
                                {
                                    oText.attr('pre_value', '');
                                    oCode.attr('pre_code', '');
                                    if(oSettings.self_define == '1')
                                    {
                                        $("#" + oSettings.self_define_text_id).attr('pre_value', '');
                                    }
                                }
                                break;

                            case '3':  //点击下拉列表或弹窗 保存数据
                                oText.attr('pre_value', oText.val());
                                oCode.attr('pre_code', oCode.val());
                                if(oSettings.self_define == '1')
                                {
                                    $("#" + oSettings.self_define_text_id).attr('pre_value', $("#" + oSettings.self_define_text_id).val());
                                }
                                break;
                        }
                    }
                }
            },
            getRealData: function (oSettings, iSelect, sDataStructType)  //返回数据有问题, 是k:v的, 应该是code:value, 是v的, 应该是 value:value
            {
                var oRealData = {};

                switch (sDataStructType)
                {
                    case '1':  //k:v
                        if (oSettings.data_multiple)
                        {
                            $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, code) {
                                oRealData[code] = oSettings.data[code];
                            });
                        }
                        else
                        {
                            oRealData[iSelect] = oSettings.data[iSelect];
                        }
                        break;

                    case '2':  //v
                        $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                            oRealData[value] = value;
                        });
                        break;
                }

                return oRealData;
            },
            saveText: function (oSettings, iSelect, sDataStructType)  //选中的选项存放在文本框中
            {
                var oRealData = jQuery.commonSelect.getRealData(oSettings, iSelect, sDataStructType);

                var aTextValue = [];

                $.each(oRealData, function (code, value) {
                    aTextValue.push(value);
                });

                var oText = $('#' + oSettings.text_id);

                oText.val(aTextValue.join(jQuery.commonSelect.oSaveTextTypeSplit[oSettings.save_text_type]));

                if (oText.hasClass(oSettings.place_holder_class))
                {
                    oText.removeClass(oSettings.place_holder_class);
                }

                if(oSettings.self_define == '1')
                {
                    $('#' + oSettings.self_define_text_id).val('');
                }
            },
            saveUnderText: function (oSettings, iSelect, sDataStructType)  //选中的选项存储在文本框下方
            {
                var oUnderElement = {};

                aRealData = jQuery.commonSelect.getRealData(oSettings, iSelect, sDataStructType);

                $('#' + oSettings.under_id).html('');

                $.each(aRealData, function (i, value) {
                    oUnderElement = $('<span data-value="' + i.replace(/</g, "&lt;").replace(/\"/g, "&quot;") + '" class="ttag"><span title="' + value.replace(/</g, "&lt;").replace(/\"/g, "&quot;") + '">' + value.replace(/</g, "&lt;").replace(/\"/g, "&quot;") + '</span><em></em></span>').appendTo($('#' + oSettings.under_id));

                    oUnderElement.bind('click', oSettings, jQuery.commonSelect.deleteUnderSelectEvent);
                });

                $('#' + oSettings.under_id).append('<div class="clear"></div>');
            },
            getMultipleSelect: function (oSettings)  //获取选中的code值和名称
            {
                var oSelect = {'code': [], 'text': []};
                $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                    oSelect['code'].push(value);
                    oSelect['text'].push(oSettings.data[value]);
                });

                return oSelect;
            },
            saveCurrentSelected: function (oSettings, iSelect)
            {
                if (oSettings.data_multiple)
                {
                    jQuery.commonSelect.oCurrentSelected[oSettings.data_type].push(iSelect);
                }
                else
                {
                    jQuery.commonSelect.oCurrentSelected[oSettings.data_type] = [];
                    jQuery.commonSelect.oCurrentSelected[oSettings.data_type].push(iSelect);
                }
            },
            deleteUnderSelectEvent: function (oEvent)  //删除文本框下方选项
            {
                oEvent.stopPropagation();

                var oSettings = oEvent.data;

                jQuery.commonSelect.deleteSelect(oSettings, $(this));

                switch (oSettings.save_type)
                {
                    case '1':  //存储在文本框中 + 存储隐藏域
                    case '2':  //存储在文本框下方 + 存储隐藏域
                        jQuery.commonSelect.saveCode(oSettings);
                        break;
                }
            },
            saveCode: function (oSettings)  //存储选中的选项的code
            {
                $('#' + oSettings.code_id).val(jQuery.commonSelect.oCurrentSelected[oSettings.data_type].join(jQuery.commonSelect.oSaveCodeTypeSplit[oSettings.save_code_type]));
            },
            deleteSelect: function (oSettings, oJqueryElement)  //弹窗的, 由弹窗自行实现
            {
                if(typeof(oJqueryElement) == "string")
                {
                    jQuery.commonSelect.deleteCurrentSelected(oSettings, oJqueryElement);
                }
                else
                {
                    oJqueryElement.remove();
                    jQuery.commonSelect.deleteCurrentSelected(oSettings, oJqueryElement.attr("data-value"));
                }
            },
            deleteCurrentSelected: function (oSettings, iSelect)  //在全局变量中删除选择项
            {
                var aTempCurrentSelected = [];

                $.each(jQuery.commonSelect.oCurrentSelected[oSettings.data_type], function (i, value) {
                    if (value != iSelect)
                    {
                        aTempCurrentSelected.push(value);
                    }
                });
                jQuery.commonSelect.oCurrentSelected[oSettings.data_type] = aTempCurrentSelected;
            },
            replaceCurrentSelected: function (oSettings, iSelect)  //在全局变量中替换选择项
            {
                jQuery.commonSelect.oCurrentSelected[oSettings.data_type] = [];
                jQuery.commonSelect.oCurrentSelected[oSettings.data_type].push(iSelect);
            },
            getObjectKeys: function (o)
            {
                var aKey = [];

                if (!o.keys)
                {
                    for (var i in o)
                    {
                        if (o.hasOwnProperty(i))
                        {
                            aKey.push(i);
                        }
                    }
                }
                else
                {
                    aKey = Object.keys(o);
                }

                return aKey;
            },
            saveSelfDefineStep1: function (oEvent)  //保存处理, 关闭弹窗
            {
                oEvent.stopPropagation();
                var oSettings = oEvent.data;

                $('#' + oSettings.self_define_text_id + '_selfdefine_div').find('.' + oSettings.association_each_click).removeClass('on')
                $('#' + oSettings.self_define_text_id + '_selfdefine_code').val($(this).attr('data-value'));
                $(this).addClass('on');
            }
        }
});