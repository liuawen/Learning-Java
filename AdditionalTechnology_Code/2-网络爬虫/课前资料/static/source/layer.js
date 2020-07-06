$.extend({
    FLayer: {
        init: function (options)
        {
            var oSettings = {
                'layer_id'               : 'layer_id',
                'layer_class_name'       : 'layer_class',
                'layer_type'             : '1',
                'layer_z_index'          : 1000,
                'layer_append_type'      : '1',
                'layer_close_class'      : 'layer_close',
                'layer_bind_id'          : 'layer_bind_id',
                'oBindElement'           : '',
                'layer_offset'           : 2,
                'layer_before_open'      : '',
                'layer_after_open'       : '',
                'layer_after_close'      : '',
                'layer_back_drop_id'     : 'layer_back_drop',
                'layer_back_drop_class'  : 'layer_back_drop_class',
                'layer_back_drop_z_index': 999,
                'layer_init'             : true
            };

            $.extend(oSettings, options);

            switch (oSettings.layer_type)
            {
                case '2':
                    if ('' === oSettings.oBindElement)
                    {
                        oSettings.oBindElement = $('#' + oSettings.layer_bind_id);
                    }

                    if (0 == $('#' + oSettings.layer_id).length)
                    {
                        switch (oSettings.layer_append_type)
                        {
                            case '1':
                                oSettings.oLayerElement = $('<div />').attr({'id': oSettings.layer_id, 'class': oSettings.layer_class_name}).appendTo(oSettings.oBindElement);
                                break;

                            case '2':
                                oSettings.oLayerElement = $('<div />').insertAttr({'id': oSettings.layer_id, 'class': oSettings.layer_class_name}).insertAfter(oSettings.oBindElement);
                                break;
                        }
                    }
                    else
                    {
                        $('#' + oSettings.layer_id).attr({'class': oSettings.layer_class_name});
                        oSettings.oLayerElement = $('#' + oSettings.layer_id);
                    }
                    break;

                default:
                    if (0 == $('#' + oSettings.layer_id).length)
                    {
                        oSettings.oLayerElement = $('<div />').attr({'id': oSettings.layer_id, 'class': oSettings.layer_class_name, 'init': 'true'}).css({'display': 'none', 'position': 'absolute', 'z-index': oSettings.layer_z_index}).appendTo('body');
                    }
                    else
                    {
                        oSettings.oLayerElement    = $('#' + oSettings.layer_id);
                    }


                    if (0 == $('#' + oSettings.layer_back_drop_id).length)
                    {
                        oSettings.oBackDropElement = $('<div />').attr({'id': oSettings.layer_back_drop_id, 'class': oSettings.layer_back_drop_class}).css({'z-index': oSettings.layer_back_drop_z_index, 'position': 'absolute', 'width':$(document).width() + 'px', 'height':$(document).height() + 'px', 'left': 0, 'top': 0}).appendTo('body');
                    }
                    else
                    {
                        $('#' + oSettings.layer_back_drop_id).css({'height':$(document).height() + 'px'});
                        oSettings.oBackDropElement = $('#' + oSettings.layer_back_drop_id);
                    }

                    oSettings.oBindElement = {};
                    break;
            }

            return oSettings;
        },
        setContent: function (oSettings, sContent)
        {
            oSettings.oLayerElement.html(sContent);
        },
        open: function (oSettings)
        {
            var oLayerSettings = {};

            if ('undefined' != typeof oSettings.oLayerSettings)
            {
                oLayerSettings = oSettings.oLayerSettings;
            }
            else
            {
                oLayerSettings = oSettings;
            }

            switch (oLayerSettings.layer_type)
            {
                case '2':
                    if (oLayerSettings.oLayerElement.is(':hidden'))
                    {
                        if ('function' == typeof oLayerSettings.layer_before_open)
                        {
                            oLayerSettings.layer_before_open(oSettings);
                        }

                        jQuery.FLayer.setPosition(oLayerSettings);
                    }

                    oLayerSettings.oLayerElement.find('.' + oLayerSettings.layer_close_class).bind('click', oSettings, jQuery.FLayer.closeEvent);
                    oLayerSettings.oLayerElement.show();
                    break;

                default:
                    if (oLayerSettings.layer_init)
                    {
                        if ('function' == typeof oLayerSettings.layer_before_open)
                        {
                            oLayerSettings.layer_before_open(oSettings);
                        }

                        jQuery.FLayer.setPosition(oLayerSettings);
                    }
                    else
                    {
                        if (oLayerSettings.oLayerElement.is(':hidden') && ('true' == oLayerSettings.oLayerElement.attr('init')))
                        {
                            if ('function' == typeof oLayerSettings.layer_before_open)
                            {
                                oLayerSettings.layer_before_open(oSettings);
                            }

                            jQuery.FLayer.setPosition(oLayerSettings);
                        }

                        oLayerSettings.oLayerElement.attr('init', 'false');
                    }


                    oLayerSettings.oLayerElement.find('.' + oLayerSettings.layer_close_class).bind('click', oSettings, jQuery.FLayer.closeEvent);
                    oLayerSettings.oLayerElement.show();
                    oLayerSettings.oBackDropElement.show();
                    break;
            }
            
            if ('function' == typeof oLayerSettings.layer_after_open)
            {
                oLayerSettings.layer_after_open(oSettings);
            }
        },
        closeEvent: function (oEvent)
        {
            oEvent.stopPropagation();

            var oSettings = oEvent.data;

            jQuery.FLayer.close(oSettings);

            return false;
        },
        close: function (oSettings)
        {
            var oLayerSettings = {};

            if ('undefined' != typeof oSettings.oLayerSettings)
            {
                oLayerSettings = oSettings.oLayerSettings;
            }
            else
            {
                oLayerSettings = oSettings;
            }

            oLayerSettings.oLayerElement.hide();

            switch (oSettings.layer_type)
            {
                case '1':
                    oLayerSettings.oBackDropElement.hide();
                    break;

                case '2':
                    break;
            }

            if ('function' == typeof oLayerSettings.layer_after_close)
            {
                oLayerSettings.layer_after_close(oSettings);
            }
        },
        setPosition: function (oSettings)
        {
            switch (oSettings.layer_type)
            {
                case '1':
                    jQuery.FLayer.setCenter(oSettings);
                    break;

                case '2':
                    jQuery.FLayer.setBottom(oSettings);
                    break;
            }
        },
        setCenter: function (oSettings)
        {
            //var _isIE6 = !('minWidth' in $('html')[0].style);
            //var _isFixed = !_isIE6;
            //var dl = _isFixed ? 0 : $(document).scrollLeft();
            //var dt = _isFixed ? 0 : $(document).scrollTop();
            var dl = $(document).scrollLeft();
            var dt = $(document).scrollTop();
            var ww = $(window).width();
            var wh = $(window).height();
            var ow = oSettings.oLayerElement.width();
            var oh = oSettings.oLayerElement.height();
            var left = (ww - ow) / 2 + dl;
            var top = (wh - oh) * 382 / 1000 + dt;//黄金比例
            oSettings.oLayerElement.css({'left': Math.max(parseInt(left), dl), 'top': Math.max(parseInt(top), dt)});
        },
        setBottom: function (oSettings)
        {
            //oSettings.oLayerElement.css({'left':oSettings.oBindElement.position().left + oSettings.layer_offset, 'top':oSettings.oBindElement.position().top + oSettings.oBindElement.get(0).offsetHeight - oSettings.layer_offset});
        }
    }
});