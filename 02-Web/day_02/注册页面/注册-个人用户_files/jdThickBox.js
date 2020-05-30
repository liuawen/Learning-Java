(function($) {
	$.extend($.browser, {
		client: function() {
			return {
				width: document.documentElement.clientWidth,
				height: document.documentElement.clientHeight,
				bodyWidth: document.body.clientWidth,
				bodyHeight: document.body.clientHeight
			};
		},
		scroll: function() {
			return {
				width: document.documentElement.scrollWidth,
				height: document.documentElement.scrollHeight,
				bodyWidth: document.body.scrollWidth,
				bodyHeight: document.body.scrollHeight,
				left: document.documentElement.scrollLeft + document.body.scrollLeft,
				top: document.documentElement.scrollTop + document.body.scrollTop
			};
		},
		screen: function() {
			return {
				width: window.screen.width,
				height: window.screen.height
			};
		},
		isIE6: $.browser.msie && $.browser.version == 6,
		isMinW: function(val) {
			return Math.min($.browser.client().bodyWidth, $.browser.client().width) <= val;
		},
		isMinH: function(val) {
			return $.browser.client().height <= val;
		}
	})
})(jQuery);
(function(a) {
    a.fn.jdPosition = function(f) {
        var e = a.extend({mode:null}, f || {});
        switch (e.mode) {
            default:
            case"center":
                var c = a(this).outerWidth(),g = a(this).outerHeight();
                var b = a.browser.isMinW(c),d = a.browser.isMinH(g);
                a(this).css({left:a.browser.scroll().left + Math.max((a.browser.client().width - c) / 2, 0) + "px",top:(!a.browser.isIE6) ? (d ? a.browser.scroll().top : (a.browser.scroll().top + Math.max((a.browser.client().height - g) / 2, 0) + "px")) : ((a.browser.scroll().top <= a.browser.client().bodyHeight - g) ? (a.browser.scroll().top + Math.max((a.browser.client().height - g) / 2, 0) + "px") : (a.browser.client().height - g) / 2 + "px")});
                break;
            case"auto":
                break;
            case"fixed":
                break
        }
    }
})(jQuery);
(function(a) {
    a.fn.jdThickBox = function(f, k) {
        if (typeof f == "function") {
            k = f;
            f = {}
        }
        var o = a.extend({type:"text",source:null,width:null,height:null,title:null,_frame:"",_div:"",_box:"",_con:"",_loading:"thickloading",close:false,_close:"",_fastClose:false,_close_val:"\u00d7",_titleOn:true,_title:"",_autoReposi:false,_countdown:false,_thickPadding:10,_thickBorder:1}, f || {});
        var e = (typeof this != "function") ? a(this) : null;
        var c;
        var m = function() {
            clearInterval(c);
            a(".thickframe").add(".thickdiv").hide();
            a(".thickbox").empty().remove();
            if (o._autoReposi) {
                a(window).unbind("resize.jdThickBox").unbind("scroll.jdThickBox")
            }
        };
        if (o.close) {
            m();
            return false
        }
        var d = function(p) {
            if (p != "") {
                return p.match(/\w+/)
            } else {
                return""
            }
        };
        var n = function(p) {
            if (a(".thickframe").length == 0 || a(".thickdiv").length == 0) {
                a("<iframe class='thickframe' id='" + d(o._frame) + "' marginwidth='0' marginheight='0' frameborder='0' scrolling='no'></iframe>").appendTo(a(document.body));
                a("<div class='thickdiv' id='" + d(o._div) + "'></div>").appendTo(a(document.body))
            } else {
                a(".thickframe").add(".thickdiv").show()
            }
            a("<div class='thickbox' id='" + d(o._box) + "'></div>").appendTo(a(document.body));
            if (o._titleOn) {
                h(p)
            }
            a("<div class='thickcon' id='" + d(o._con) + "' style='width:" + o.width + "px;height:" + o.height + "px;'></div>").appendTo(a(".thickbox"));
            if (o._countdown) {
                b()
            }
            a(".thickcon").addClass(o._loading);
            g();
            j();
            l(p);
            if (o._autoReposi) {
                a(window).bind("resize.jdThickBox", g).bind("scroll.jdThickBox", g)
            }
            if (o._fastClose) {
                a(document.body).bind("click.jdThickBox", function(r) {
                    r = r ? r : window.event;
                    var q = r.srcElement ? r.srcElement : r.target;
                    if (q.className == "thickdiv") {
                        a(this).unbind("click.jdThickBox");
                        m()
                    }
                })
            }
        };
        var b = function() {
            var p = o._countdown;
            a("<div class='thickcountdown' style='width:" + o.width + "'><span id='jd-countdown'>" + p + "</span>\u79d2\u540e\u81ea\u52a8\u5173\u95ed</div>").appendTo(a(".thickbox"));
            c = setInterval(function() {
                p--;
                a("#jd-countdown").html(p);
                if (p == 0) {
                    p = o._countdown;
                    m()
                }
            }, 1000)
        };
        var h = function(p) {
            o.title = (o.title == null && p) ? p.attr("title") : o.title;
            a("<div class='thicktitle' id='" + d(o._title) + "' style='width:" + o.width + "'><span>" + o.title + "</span></div>").appendTo(a(".thickbox"))
        };
        var j = function() {
            if (o._close != null) {
                a("<a href='#'  id='closeBox'  class='thickclose' id='" + d(o._close) + "'>" + o._close_val + "</a>").appendTo(a(".thickbox"));
                a(".thickclose").one("click", function() {
                    m();                    
                    return false
                })
            }
        };
        var l = function(p) {
            o.source = (o.source == null) ? p.attr("href") : o.source;
            switch (o.type) {
                default:
                case"text":
                    a(".thickcon").html(o.source);
                    a(".thickcon").removeClass(o._loading);
                    if (k) {
                        k()
                    }
                    break;
                case"html":
                    a(o.source).clone().appendTo(a(".thickcon")).show();
                    a(".thickcon").removeClass(o._loading);
                    if (k) {
                        k()
                    }
                    break;
                case"image":
                    o._index = (o._index == null) ? e.index(p) : o._index;
                    a(".thickcon").append("<img src='" + o.source + "' width='" + o.width + "' height='" + o.height + "'>");
                    o.source = null;
                    a(".thickcon").removeClass(o._loading);
                    if (k) {
                        k()
                    }
                    break;
                case"ajax":
                case"json":
                    if (k) {
                        k(o.source, a(".thickcon"), function() {
                            a(".thickcon").removeClass(o._loading)
                        })
                    }
                    break;
                case"iframe":
                    a("<iframe src='" + o.source + "' marginwidth='0' marginheight='0' frameborder='0' scrolling='no' style='width:" + o.width + "px;height:" + o.height + "px;border:0;'></iframe>").appendTo(a(".thickcon"));
                    a(".thickcon").removeClass(o._loading);
                    if (k) {
                        k()
                    }
                    break
            }
        };
        var g = function() {
            var q = o._thickPadding * 2 + o._thickBorder * 2 + parseInt(o.width),t = (o._titleOn ? a(".thicktitle").outerHeight() : 0) + a(".thickcon").outerHeight();
            a(".thickcon").css({width:o.width,height:o.height,paddingLeft:0,paddingRight:0,borderLeft:o._thickBorder,borderRight:o._thickBorder});
            a(".thickbox").css({width:(q-20 )+ "px",height:t + "px"});
            a(".thickbox").jdPosition({mode:"center"});
            if (a.browser.isIE6) {
                var s = a(".thickbox").outerWidth(),u = a(".thickbox").outerHeight();
                var p = a.browser.isMinW(s),r = a.browser.isMinH(u);
                a(".thickframe").add(".thickdiv").css({width:p ? s : "100%",height:Math.max(a.browser.client().height, a.browser.client().bodyHeight) + "px"})
            }
        };
        if (e != null) {
            e.click(function() {
                n(a(this));
                return false
            })
        } else {
            n()
        }
    };
    a.jdThickBox = a.fn.jdThickBox
})(jQuery);
function jdThickBoxclose() {
    $(".thickclose").trigger("click")
}