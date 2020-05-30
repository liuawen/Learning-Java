/*livequery*/
eval(function(p, a, c, k, e, r) { e = function(c) { return (c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36)) }; if (!''.replace(/^/, String)) { while (c--) r[e(c)] = k[c] || e(c); k = [function(e) { return r[e] } ]; e = function() { return '\\w+' }; c = 1 }; while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]); return p } ('(4($){$.R($.7,{3:4(c,b,d){9 e=2,q;5($.O(c))d=b,b=c,c=z;$.h($.3.j,4(i,a){5(e.8==a.8&&e.g==a.g&&c==a.m&&(!b||b.$6==a.7.$6)&&(!d||d.$6==a.o.$6))l(q=a)&&v});q=q||Y $.3(2.8,2.g,c,b,d);q.u=v;$.3.s(q.F);l 2},T:4(c,b,d){9 e=2;5($.O(c))d=b,b=c,c=z;$.h($.3.j,4(i,a){5(e.8==a.8&&e.g==a.g&&(!c||c==a.m)&&(!b||b.$6==a.7.$6)&&(!d||d.$6==a.o.$6)&&!2.u)$.3.y(a.F)});l 2}});$.3=4(e,c,a,b,d){2.8=e;2.g=c||S;2.m=a;2.7=b;2.o=d;2.t=[];2.u=v;2.F=$.3.j.K(2)-1;b.$6=b.$6||$.3.I++;5(d)d.$6=d.$6||$.3.I++;l 2};$.3.p={y:4(){9 b=2;5(2.m)2.t.16(2.m,2.7);E 5(2.o)2.t.h(4(i,a){b.o.x(a)});2.t=[];2.u=Q},s:4(){5(2.u)l;9 b=2;9 c=2.t,w=$(2.8,2.g),H=w.11(c);2.t=w;5(2.m){H.10(2.m,2.7);5(c.C>0)$.h(c,4(i,a){5($.B(a,w)<0)$.Z.P(a,b.m,b.7)})}E{H.h(4(){b.7.x(2)});5(2.o&&c.C>0)$.h(c,4(i,a){5($.B(a,w)<0)b.o.x(a)})}}};$.R($.3,{I:0,j:[],k:[],A:v,D:X,N:4(){5($.3.A&&$.3.k.C){9 a=$.3.k.C;W(a--)$.3.j[$.3.k.V()].s()}},U:4(){$.3.A=v},M:4(){$.3.A=Q;$.3.s()},L:4(){$.h(G,4(i,n){5(!$.7[n])l;9 a=$.7[n];$.7[n]=4(){9 r=a.x(2,G);$.3.s();l r}})},s:4(b){5(b!=z){5($.B(b,$.3.k)<0)$.3.k.K(b)}E $.h($.3.j,4(a){5($.B(a,$.3.k)<0)$.3.k.K(a)});5($.3.D)1j($.3.D);$.3.D=1i($.3.N,1h)},y:4(b){5(b!=z)$.3.j[b].y();E $.h($.3.j,4(a){$.3.j[a].y()})}});$.3.L(\'1g\',\'1f\',\'1e\',\'1b\',\'1a\',\'19\',\'18\',\'17\',\'1c\',\'15\',\'1d\',\'P\');$(4(){$.3.M()});9 f=$.p.J;$.p.J=4(a,c){9 r=f.x(2,G);5(a&&a.8)r.g=a.g,r.8=a.8;5(14 a==\'13\')r.g=c||S,r.8=a;l r};$.p.J.p=$.p})(12);', 62, 82, '||this|livequery|function|if|lqguid|fn|selector|var|||||||context|each||queries|queue|return|type||fn2|prototype|||run|elements|stopped|false|els|apply|stop|undefined|running|inArray|length|timeout|else|id|arguments|nEls|guid|init|push|registerPlugin|play|checkQueue|isFunction|remove|true|extend|document|expire|pause|shift|while|null|new|event|bind|not|jQuery|string|typeof|toggleClass|unbind|addClass|removeAttr|attr|wrap|before|removeClass|empty|after|prepend|append|20|setTimeout|clearTimeout'.split('|'), 0, {}))
/*query*/
new function(settings) { var $separator = settings.separator || '&'; var $spaces = settings.spaces === false ? false : true; var $suffix = settings.suffix === false ? '' : '[]'; var $prefix = settings.prefix === false ? false : true; var $hash = $prefix ? settings.hash === true ? "#" : "?" : ""; var $numbers = settings.numbers === false ? false : true; jQuery.query = new function() { var is = function(o, t) { return o != undefined && o !== null && (!!t ? o.constructor == t : true) }; var parse = function(path) { var m, rx = /\[([^[]*)\]/g, match = /^(\S+?)(\[\S*\])?$/.exec(path), base = match[1], tokens = []; while (m = rx.exec(match[2])) tokens.push(m[1]); return [base, tokens] }; var set = function(target, tokens, value) { var o, token = tokens.shift(); if (typeof target != 'object') target = null; if (token === "") { if (!target) target = []; if (is(target, Array)) { target.push(tokens.length == 0 ? value : set(null, tokens.slice(0), value)) } else if (is(target, Object)) { var i = 0; while (target[i++] != null); target[--i] = tokens.length == 0 ? value : set(target[i], tokens.slice(0), value) } else { target = []; target.push(tokens.length == 0 ? value : set(null, tokens.slice(0), value)) } } else if (token && token.match(/^\s*[0-9]+\s*$/)) { var index = parseInt(token, 10); if (!target) target = []; target[index] = tokens.length == 0 ? value : set(target[index], tokens.slice(0), value) } else if (token) { var index = token.replace(/^\s*|\s*$/g, ""); if (!target) target = {}; if (is(target, Array)) { var temp = {}; for (var i = 0; i < target.length; ++i) { temp[i] = target[i] } target = temp } target[index] = tokens.length == 0 ? value : set(target[index], tokens.slice(0), value) } else { return value } return target }; var queryObject = function(a) { var self = this; self.keys = {}; if (a.queryObject) { jQuery.each(a.get(), function(key, val) { self.SET(key, val) }) } else { jQuery.each(arguments, function() { var q = "" + this; q = q.replace(/^[?#]/, ''); q = q.replace(/[;&]$/, ''); if ($spaces) q = q.replace(/[+]/g, ' '); jQuery.each(q.split(/[&;]/), function() { var key = decodeURIComponent(this.split('=')[0]); var val = decodeURIComponent(encodeURIComponent(this.split('=')[1])); if (!key) return; if ($numbers) { if (/^[+-]?[0-9]+\.[0-9]*$/.test(val)) val = parseFloat(val); else if (/^[+-]?[0-9]+$/.test(val)) val = parseInt(val, 10) } val = (!val && val !== 0) ? true : val; if (val !== false && val !== true && typeof val != 'number') val = val; self.SET(key, val) }) }) } return self }; queryObject.prototype = { queryObject: true, has: function(key, type) { var value = this.get(key); return is(value, type) }, GET: function(key) { if (!is(key)) return this.keys; var parsed = parse(key), base = parsed[0], tokens = parsed[1]; var target = this.keys[base]; while (target != null && tokens.length != 0) { target = target[tokens.shift()] } return typeof target == 'number' ? target : target || "" }, get: function(key) { var target = this.GET(key); if (is(target, Object)) return jQuery.extend(true, {}, target); else if (is(target, Array)) return target.slice(0); return target }, SET: function(key, val) { var value = !is(val) ? null : val; var parsed = parse(key), base = parsed[0], tokens = parsed[1]; var target = this.keys[base]; this.keys[base] = set(target, tokens.slice(0), value); return this }, set: function(key, val) { return this.copy().SET(key, val) }, REMOVE: function(key) { return this.SET(key, null).COMPACT() }, remove: function(key) { return this.copy().REMOVE(key) }, EMPTY: function() { var self = this; jQuery.each(self.keys, function(key, value) { delete self.keys[key] }); return self }, load: function(url) { var hash = url.replace(/^.*?[#](.+?)(?:\?.+)?$/, "$1"); var search = url.replace(/^.*?[?](.+?)(?:#.+)?$/, "$1"); return new queryObject(url.length == search.length ? '' : search, url.length == hash.length ? '' : hash) }, empty: function() { return this.copy().EMPTY() }, copy: function() { return new queryObject(this) }, COMPACT: function() { function build(orig) { var obj = typeof orig == "object" ? is(orig, Array) ? [] : {} : orig; if (typeof orig == 'object') { function add(o, key, value) { if (is(o, Array)) o.push(value); else o[key] = value } jQuery.each(orig, function(key, value) { if (!is(value)) return true; add(obj, key, build(value)) }) } return obj } this.keys = build(this.keys); return this }, compact: function() { return this.copy().COMPACT() }, toString: function() { var i = 0, queryString = [], chunks = [], self = this; var addFields = function(arr, key, value) { if (!is(value) || value === false) return; var o = [encodeURIComponent(key)]; if (value !== true) { o.push("="); o.push(encodeURIComponent(value)) } arr.push(o.join("")) }; var build = function(obj, base) { var newKey = function(key) { return !base || base == "" ? [key].join("") : [base, "[", key, "]"].join("") }; jQuery.each(obj, function(key, value) { if (typeof value == 'object') build(value, newKey(key)); else addFields(chunks, newKey(key), value) }) }; build(this.keys); if (chunks.length > 0) queryString.push($hash); queryString.push(chunks.join($separator)); return queryString.join("") } }; return new queryObject(location.search, location.hash) } } (jQuery.query || {});
/*cookie*/
eval(function(p, a, c, k, e, r) { e = function(c) { return (c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36)) }; if (!''.replace(/^/, String)) { while (c--) r[e(c)] = k[c] || e(c); k = [function(e) { return r[e] } ]; e = function() { return '\\w+' }; c = 1 }; while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]); return p } ('n.5=v(a,b,c){4(7 b!=\'w\'){c=c||{};4(b===o){b=\'\';c.3=-1}2 d=\'\';4(c.3&&(7 c.3==\'p\'||c.3.q)){2 e;4(7 c.3==\'p\'){e=x y();e.z(e.A()+(c.3*B*r*r*C))}s{e=c.3}d=\';3=\'+e.q()}2 f=c.8?\';8=\'+(c.8):\'\';2 g=c.9?\';9=\'+(c.9):\'\';2 h=c.t?\';t\':\'\';6.5=[a,\'=\',D(b),d,f,g,h].E(\'\')}s{2 j=o;4(6.5&&6.5!=\'\'){2 k=6.5.F(\';\');G(2 i=0;i<k.m;i++){2 l=n.H(k[i]);4(l.u(0,a.m+1)==(a+\'=\')){j=I(l.u(a.m+1));J}}}K j}};', 47, 47, '||var|expires|if|cookie|document|typeof|path|domain|||||||||||||length|jQuery|null|number|toUTCString|60|else|secure|substring|function|undefined|new|Date|setTime|getTime|24|1000|encodeURIComponent|join|split|for|trim|decodeURIComponent|break|return'.split('|'), 0, {}))
/*utility by springChun*/
Function.prototype.overwrite = function(f) {
    var result = f;
    if (!result.original) {
        result.original = this;
    }
    return result;
}
Date.prototype.toString = Date.prototype.toString.overwrite(
function(format) {
    var result = new String();
    if (typeof (format) == "string") {
        result = format;
        result = result.replace(/yyyy|YYYY/, this.getFullYear());
        result = result.replace(/yy|YY/, this.getFullYear().toString().substr(2, 2));
        result = result.replace(/MM/, this.getMonth() >= 9 ? this.getMonth() + 1 : "0" + (this.getMonth() + 1));
        result = result.replace(/M/, this.getMonth());
        result = result.replace(/dd|DD/, this.getDate() > 9 ? this.getDate() : "0" + this.getDate());
        result = result.replace(/d|D/, this.getDate());
        result = result.replace(/hh|HH/, this.getHours() > 9 ? this.getHours() : "0" + this.getHours());
        result = result.replace(/h|H/, this.getHours());
        result = result.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes() : "0" + this.getMinutes());
        result = result.replace(/m/, this.getMinutes());
        result = result.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds() : "0" + this.getSeconds());
        result = result.replace(/s|S/, this.getSeconds());
    }
    return result;
});
String.prototype.format = function() {
    var result = this;
    if (arguments.length > 0) {
        parameters = $.makeArray(arguments);
        $.each(
parameters,
function(i, n) {
    result = result.replace(new RegExp("\\{" + i + "\\}", "g"), n);
});
    }
    return result;
}
function StringBuilder() {
    this.strings = new Array();
    this.length = 0;
}
StringBuilder.prototype.append = function(string) {
    this.strings.push(string);
    this.length += string.length;
}
StringBuilder.prototype.toString = function(start, length) {
    return this.strings.join("").substr(start, length);
};
/*jmsajax*/
(function($) {
    $.jmsajax = function(options) {
        var defaults = { type: "POST", dataType: "msjson", data: {}, beforeSend: function(xhr) { xhr.setRequestHeader("Content-type", "application/json; charset=utf-8"); }, contentType: "application/json; charset=utf-8", error: function(x, s, m) { alert("Status: " + ((x.statusText) ? x.statusText : "Unknown") + "\nMessage: " + msJSON.parse(((x.responseText) ? x.responseText : "Unknown")).Message); } }; var options = $.extend(defaults, options); if (options.method)
            options.url += "/" + options.method; if (options.data) {
            if (options.type == "GET") {
                var data = ""; for (var i in options.data) {
                    if (data != "")
                        data += "&"; data += i + "=" + msJSON.stringify(options.data[i]);
                }
                options.url += "?" + data; data = null; options.data = "{}";
            }
            else if (options.type == "POST") { options.data = msJSON.stringify(options.data); } 
        }
        if (options.success) {
            if (options.dataType) {
                if (options.dataType == "msjson") {
                    var base = options.success; options.success = function(response, status) {
                        var y = dateparse(response); if (options.version) {
                            if (options.version >= 3.5)
                                y = y.d;
                        }
                        else {
                            if (response.indexOf("{\"d\":") == 0)
                                y = y.d;
                        }
                        base(y, status);
                    } 
                } 
            } 
        }
        return $.ajax(options);
    }; dateparse = function(data) {
        try {
            return msJSON.parse(data, function(key, value) {
                var a; if (typeof value === "string") { if (value.indexOf("Date") >= 0) { a = /^\/Date\(([0-9]+)\)\/$/.exec(value); if (a) { return new Date(parseInt(a[1], 10)); } } }
                return value;
            });
        }
        catch (e) { return null; } 
    }
    msJSON = function() {
        function f(n) { return n < 10 ? '0' + n : n; }
        var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, escapeable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, gap, indent, meta = { '\b': '\\b', '\t': '\\t', '\n': '\\n', '\f': '\\f', '\r': '\\r', '"': '\\"', '\\': '\\\\' }, rep; function quote(string) {
            escapeable.lastIndex = 0; return escapeable.test(string) ? '"' + string.replace(escapeable, function(a) {
                var c = meta[a]; if (typeof c === 'string') { return c; }
                return '\\u' + ('0000' + (+(a.charCodeAt(0))).toString(16)).slice(-4);
            }) + '"' : '"' + string + '"';
        }
        function str(key, holder) {
            var i, k, v, length, mind = gap, partial, value = holder[key]; if (value && typeof value === 'object' && typeof value.toJSON === 'function') { value = value.toJSON(key); }
            if (typeof rep === 'function') { value = rep.call(holder, key, value); }
            switch (typeof value) {
                case 'string': return quote(value); case 'number': return isFinite(value) ? String(value) : 'null'; case 'boolean': case 'null': return String(value); case 'object': if (!value) { return 'null'; }
                    if (value.toUTCString) { return '"\\/Date(' + (value.getTime()) + ')\\/"'; }
                    gap += indent; partial = []; if (typeof value.length === 'number' && !(value.propertyIsEnumerable('length'))) {
                        length = value.length; for (i = 0; i < length; i += 1) { partial[i] = str(i, value) || 'null'; }
                        v = partial.length === 0 ? '[]' : gap ? '[\n' + gap +
partial.join(',\n' + gap) + '\n' +
mind + ']' : '[' + partial.join(',') + ']'; gap = mind; return v;
                    }
                    if (rep && typeof rep === 'object') { length = rep.length; for (i = 0; i < length; i += 1) { k = rep[i]; if (typeof k === 'string') { v = str(k, value, rep); if (v) { partial.push(quote(k) + (gap ? ': ' : ':') + v); } } } } else { for (k in value) { if (Object.hasOwnProperty.call(value, k)) { v = str(k, value, rep); if (v) { partial.push(quote(k) + (gap ? ': ' : ':') + v); } } } }
                    v = partial.length === 0 ? '{}' : gap ? '{\n' + gap + partial.join(',\n' + gap) + '\n' +
mind + '}' : '{' + partial.join(',') + '}'; gap = mind; return v;
            } 
        }
        return { stringify: function(value, replacer, space) {
            var i; gap = ''; indent = ''; if (typeof space === 'number') { for (i = 0; i < space; i += 1) { indent += ' '; } } else if (typeof space === 'string') { indent = space; }
            rep = replacer; if (replacer && typeof replacer !== 'function' && (typeof replacer !== 'object' || typeof replacer.length !== 'number')) { throw new Error('JSON.stringify'); }
            return str('', { '': value });
        }, parse: function(text, reviver) {
            var j; function walk(holder, key) {
                var k, v, value = holder[key]; if (value && typeof value === 'object') { for (k in value) { if (Object.hasOwnProperty.call(value, k)) { v = walk(value, k); if (v !== undefined) { value[k] = v; } else { delete value[k]; } } } }
                return reviver.call(holder, key, value);
            }
            cx.lastIndex = 0; if (cx.test(text)) { text = text.replace(cx, function(a) { return '\\u' + ('0000' + (+(a.charCodeAt(0))).toString(16)).slice(-4); }); }
            if (/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, '@').replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']').replace(/(?:^|:|,)(?:\s*\[)+/g, ''))) { j = eval('(' + text + ')'); return typeof reviver === 'function' ? walk({ '': j }, '') : j; }
            throw new SyntaxError('JSON.parse');
        } 
        };
    } ();
})(jQuery);
/*trimpath*/
var TrimPath; (function() {
    if (TrimPath == null)
        TrimPath = new Object();
    if (TrimPath.evalEx == null)
        TrimPath.evalEx = function(src) { return eval(src); };
    var UNDEFINED;
    if (Array.prototype.pop == null)
        Array.prototype.pop = function() {
            if (this.length === 0) { return UNDEFINED; }
            return this[--this.length];
        };
    if (Array.prototype.push == null)
        Array.prototype.push = function() {
            for (var i = 0; i < arguments.length; ++i) { this[this.length] = arguments[i]; }
            return this.length;
        };
    TrimPath.parseTemplate = function(tmplContent, optTmplName, optEtc) {
        if (optEtc == null)
            optEtc = TrimPath.parseTemplate_etc;
        var funcSrc = parse(tmplContent, optTmplName, optEtc);
        var func = TrimPath.evalEx(funcSrc, optTmplName, 1);
        if (func != null)
            return new optEtc.Template(optTmplName, tmplContent, funcSrc, func, optEtc);
        return null;
    }
    try {
        String.prototype.process = function(context, optFlags) {
            var template = TrimPath.parseTemplate(this, null);
            if (template != null)
                return template.process(context, optFlags);
            return this;
        } 
    } catch (e) { }
    TrimPath.parseTemplate_etc = {};
    TrimPath.parseTemplate_etc.statementTag = "forelse|for|if|elseif|else|var|macro";
    TrimPath.parseTemplate_etc.statementDef = {
        "if": { delta: 1, prefix: "if (", suffix: ") {", paramMin: 1 },
        "else": { delta: 0, prefix: "} else {" },
        "elseif": { delta: 0, prefix: "} else if (", suffix: ") {", paramDefault: "true" },
        "/if": { delta: -1, prefix: "}" },
        "for": { delta: 1, paramMin: 3,
            prefixFunc: function(stmtParts, state, tmplName, etc) {
                if (stmtParts[2] != "in")
                    throw new etc.ParseError(tmplName, state.line, "bad for loop statement: " + stmtParts.join(' '));
                var iterVar = stmtParts[1];
                var listVar = "__LIST__" + iterVar;
                return ["var ", listVar, " = ", stmtParts[3], ";",
"var __LENGTH_STACK__;",
"if (typeof(__LENGTH_STACK__) == 'undefined' || !__LENGTH_STACK__.length) __LENGTH_STACK__ = new Array();",
"__LENGTH_STACK__[__LENGTH_STACK__.length] = 0;",
"if ((", listVar, ") != null) { ",
"var ", iterVar, "_ct = 0;",
"for (var ", iterVar, "_index in ", listVar, ") { ",
iterVar, "_ct++;",
"if (typeof(", listVar, "[", iterVar, "_index]) == 'function') {continue;}",
"__LENGTH_STACK__[__LENGTH_STACK__.length - 1]++;",
"var ", iterVar, " = ", listVar, "[", iterVar, "_index];"].join("");
            } 
        },
        "forelse": { delta: 0, prefix: "} } if (__LENGTH_STACK__[__LENGTH_STACK__.length - 1] == 0) { if (", suffix: ") {", paramDefault: "true" },
        "/for": { delta: -1, prefix: "} }; delete __LENGTH_STACK__[__LENGTH_STACK__.length - 1];" },
        "var": { delta: 0, prefix: "var ", suffix: ";" },
        "macro": { delta: 1,
            prefixFunc: function(stmtParts, state, tmplName, etc) {
                var macroName = stmtParts[1].split('(')[0];
                return ["var ", macroName, " = function",
stmtParts.slice(1).join(' ').substring(macroName.length),
"{ var _OUT_arr = []; var _OUT = { write: function(m) { if (m) _OUT_arr.push(m); } }; "].join('');
            } 
        },
        "/macro": { delta: -1, prefix: " return _OUT_arr.join(''); };"}
    }
    TrimPath.parseTemplate_etc.modifierDef = {
        "eat": function(v) { return ""; },
        "escape": function(s) { return String(s).replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;"); },
        "capitalize": function(s) { return String(s).toUpperCase(); },
        "default": function(s, d) { return s != null ? s : d; } 
    }
    TrimPath.parseTemplate_etc.modifierDef.h = TrimPath.parseTemplate_etc.modifierDef.escape;
    TrimPath.parseTemplate_etc.Template = function(tmplName, tmplContent, funcSrc, func, etc) {
        this.process = function(context, flags) {
            if (context == null)
                context = {};
            if (context._MODIFIERS == null)
                context._MODIFIERS = {};
            if (context.defined == null)
                context.defined = function(str) { return (context[str] != undefined); };
            for (var k in etc.modifierDef) {
                if (context._MODIFIERS[k] == null)
                    context._MODIFIERS[k] = etc.modifierDef[k];
            }
            if (flags == null)
                flags = {};
            var resultArr = [];
            var resultOut = { write: function(m) { resultArr.push(m); } };
            try {
                func(resultOut, context, flags);
            } catch (e) {
                if (flags.throwExceptions == true)
                    throw e;
                var result = new String(resultArr.join("") + "[ERROR: " + e.toString() + (e.message ? '; ' + e.message : '') + "]");
                result["exception"] = e;
                return result;
            }
            return resultArr.join("");
        }
        this.name = tmplName;
        this.source = tmplContent;
        this.sourceFunc = funcSrc;
        this.toString = function() { return "TrimPath.Template [" + tmplName + "]"; } 
    }
    TrimPath.parseTemplate_etc.ParseError = function(name, line, message) {
        this.name = name;
        this.line = line;
        this.message = message;
    }
    TrimPath.parseTemplate_etc.ParseError.prototype.toString = function() {
        return ("TrimPath template ParseError in " + this.name + ": line " + this.line + ", " + this.message);
    }
    var parse = function(body, tmplName, etc) {
        body = cleanWhiteSpace(body);
        var funcText = ["var TrimPath_Template_TEMP = function(_OUT, _CONTEXT, _FLAGS) { with (_CONTEXT) {"];
        var state = { stack: [], line: 1 };
        var endStmtPrev = -1;
        while (endStmtPrev + 1 < body.length) {
            var begStmt = endStmtPrev;
            begStmt = body.indexOf("{", begStmt + 1);
            while (begStmt >= 0) {
                var endStmt = body.indexOf('}', begStmt + 1);
                var stmt = body.substring(begStmt, endStmt);
                var blockrx = stmt.match(/^\{(cdata|minify|eval)/);
                if (blockrx) {
                    var blockType = blockrx[1];
                    var blockMarkerBeg = begStmt + blockType.length + 1;
                    var blockMarkerEnd = body.indexOf('}', blockMarkerBeg);
                    if (blockMarkerEnd >= 0) {
                        var blockMarker;
                        if (blockMarkerEnd - blockMarkerBeg <= 0) {
                            blockMarker = "{/" + blockType + "}";
                        } else {
                            blockMarker = body.substring(blockMarkerBeg + 1, blockMarkerEnd);
                        }
                        var blockEnd = body.indexOf(blockMarker, blockMarkerEnd + 1);
                        if (blockEnd >= 0) {
                            emitSectionText(body.substring(endStmtPrev + 1, begStmt), funcText);
                            var blockText = body.substring(blockMarkerEnd + 1, blockEnd);
                            if (blockType == 'cdata') {
                                emitText(blockText, funcText);
                            } else if (blockType == 'minify') {
                                emitText(scrubWhiteSpace(blockText), funcText);
                            } else if (blockType == 'eval') {
                                if (blockText != null && blockText.length > 0)
                                    funcText.push('_OUT.write( (function() { ' + blockText + ' })() );');
                            }
                            begStmt = endStmtPrev = blockEnd + blockMarker.length - 1;
                        } 
                    } 
                } else if (body.charAt(begStmt - 1) != '$' &&
body.charAt(begStmt - 1) != '\\') {
                    var offset = (body.charAt(begStmt + 1) == '/' ? 2 : 1);
                    if (body.substring(begStmt + offset, begStmt + 10 + offset).search(TrimPath.parseTemplate_etc.statementTag) == 0)
                        break;
                }
                begStmt = body.indexOf("{", begStmt + 1);
            }
            if (begStmt < 0)
                break;
            var endStmt = body.indexOf("}", begStmt + 1);
            if (endStmt < 0)
                break;
            emitSectionText(body.substring(endStmtPrev + 1, begStmt), funcText);
            emitStatement(body.substring(begStmt, endStmt + 1), state, funcText, tmplName, etc);
            endStmtPrev = endStmt;
        }
        emitSectionText(body.substring(endStmtPrev + 1), funcText);
        if (state.stack.length != 0)
            throw new etc.ParseError(tmplName, state.line, "unclosed, unmatched statement(s): " + state.stack.join(","));
        funcText.push("}}; TrimPath_Template_TEMP");
        return funcText.join("");
    }
    var emitStatement = function(stmtStr, state, funcText, tmplName, etc) {
        var parts = stmtStr.slice(1, -1).split(' ');
        var stmt = etc.statementDef[parts[0]];
        if (stmt == null) {
            emitSectionText(stmtStr, funcText);
            return;
        }
        if (stmt.delta < 0) {
            if (state.stack.length <= 0)
                throw new etc.ParseError(tmplName, state.line, "close tag does not match any previous statement: " + stmtStr);
            state.stack.pop();
        }
        if (stmt.delta > 0)
            state.stack.push(stmtStr);
        if (stmt.paramMin != null &&
stmt.paramMin >= parts.length)
            throw new etc.ParseError(tmplName, state.line, "statement needs more parameters: " + stmtStr);
        if (stmt.prefixFunc != null)
            funcText.push(stmt.prefixFunc(parts, state, tmplName, etc));
        else
            funcText.push(stmt.prefix);
        if (stmt.suffix != null) {
            if (parts.length <= 1) {
                if (stmt.paramDefault != null)
                    funcText.push(stmt.paramDefault);
            } else {
                for (var i = 1; i < parts.length; i++) {
                    if (i > 1)
                        funcText.push(' ');
                    funcText.push(parts[i]);
                } 
            }
            funcText.push(stmt.suffix);
        } 
    }
    var emitSectionText = function(text, funcText) {
        if (text.length <= 0)
            return;
        var nlPrefix = 0;
        var nlSuffix = text.length - 1;
        while (nlPrefix < text.length && (text.charAt(nlPrefix) == '\n'))
            nlPrefix++;
        while (nlSuffix >= 0 && (text.charAt(nlSuffix) == ' ' || text.charAt(nlSuffix) == '\t'))
            nlSuffix--;
        if (nlSuffix < nlPrefix)
            nlSuffix = nlPrefix;
        if (nlPrefix > 0) {
            funcText.push('if (_FLAGS.keepWhitespace == true) _OUT.write("');
            var s = text.substring(0, nlPrefix).replace('\n', '\\n');
            if (s.charAt(s.length - 1) == '\n')
                s = s.substring(0, s.length - 1);
            funcText.push(s);
            funcText.push('");');
        }
        var lines = text.substring(nlPrefix, nlSuffix + 1).split('\n');
        for (var i = 0; i < lines.length; i++) {
            emitSectionTextLine(lines[i], funcText);
            if (i < lines.length - 1)
                funcText.push('_OUT.write("\\n");\n');
        }
        if (nlSuffix + 1 < text.length) {
            funcText.push('if (_FLAGS.keepWhitespace == true) _OUT.write("');
            var s = text.substring(nlSuffix + 1).replace('\n', '\\n');
            if (s.charAt(s.length - 1) == '\n')
                s = s.substring(0, s.length - 1);
            funcText.push(s);
            funcText.push('");');
        } 
    }
    var emitSectionTextLine = function(line, funcText) {
        var endMarkPrev = '}';
        var endExprPrev = -1;
        while (endExprPrev + endMarkPrev.length < line.length) {
            var begMark = "${", endMark = "}";
            var begExpr = line.indexOf(begMark, endExprPrev + endMarkPrev.length);
            if (begExpr < 0)
                break;
            if (line.charAt(begExpr + 2) == '%') {
                begMark = "${%";
                endMark = "%}";
            }
            var endExpr = line.indexOf(endMark, begExpr + begMark.length);
            if (endExpr < 0)
                break;
            emitText(line.substring(endExprPrev + endMarkPrev.length, begExpr), funcText);
            var exprArr = line.substring(begExpr + begMark.length, endExpr).replace(/\|\|/g, "#@@#").split('|');
            for (var k in exprArr) {
                if (exprArr[k].replace)
                    exprArr[k] = exprArr[k].replace(/#@@#/g, '||');
            }
            funcText.push('_OUT.write(');
            emitExpression(exprArr, exprArr.length - 1, funcText);
            funcText.push(');');
            endExprPrev = endExpr;
            endMarkPrev = endMark;
        }
        emitText(line.substring(endExprPrev + endMarkPrev.length), funcText);
    }
    var emitText = function(text, funcText) {
        if (text == null ||
text.length <= 0)
            return;
        text = text.replace(/\\/g, '\\\\');
        text = text.replace(/\n/g, '\\n');
        text = text.replace(/"/g, '\\"');
        funcText.push('_OUT.write("');
        funcText.push(text);
        funcText.push('");');
    }
    var emitExpression = function(exprArr, index, funcText) {
        var expr = exprArr[index];
        if (index <= 0) {
            funcText.push(expr);
            return;
        }
        var parts = expr.split(':');
        funcText.push('_MODIFIERS["');
        funcText.push(parts[0]);
        funcText.push('"](');
        emitExpression(exprArr, index - 1, funcText);
        if (parts.length > 1) {
            funcText.push(',');
            funcText.push(parts[1]);
        }
        funcText.push(')');
    }
    var cleanWhiteSpace = function(result) {
        result = result.replace(/\t/g, "    ");
        result = result.replace(/\r\n/g, "\n");
        result = result.replace(/\r/g, "\n");
        result = result.replace(/^(\s*\S*(\s+\S+)*)\s*$/, '$1');
        return result;
    }
    var scrubWhiteSpace = function(result) {
        result = result.replace(/^\s+/g, "");
        result = result.replace(/\s+$/g, "");
        result = result.replace(/\s+/g, " ");
        result = result.replace(/^(\s*\S*(\s+\S+)*)\s*$/, '$1');
        return result;
    }
    TrimPath.parseDOMTemplate = function(elementId, optDocument, optEtc) {
        if (optDocument == null)
            optDocument = document;
        var element = optDocument.getElementById(elementId);
        var content = element.value;
        if (content == null)
            content = element.innerHTML;
        content = content.replace(/&lt;/g, "<").replace(/&gt;/g, ">");
        return TrimPath.parseTemplate(content, elementId, optEtc);
    }
    TrimPath.processDOMTemplate = function(elementId, context, optFlags, optDocument, optEtc) {
        return TrimPath.parseDOMTemplate(elementId, optDocument, optEtc).process(context, optFlags);
    } 
})();
/*pagination*/
jQuery.fn.pagination = function(maxentries, opts) {
    opts = jQuery.extend({
        items_per_page: 10,
        num_display_entries: 10,
        current_page: 0,
        num_edge_entries: 0,
        link_to: "#",
        prev_text: "Prev",
        next_text: "Next",
        ellipse_text: "...",
        prev_show_always: true,
        next_show_always: true,
        callback: function() { return false; } 
    }, opts || {});
    return this.each(function() {
        function numPages() {
            return Math.ceil(maxentries / opts.items_per_page);
        }
        function getInterval() {
            var ne_half = Math.ceil(opts.num_display_entries / 2);
            var np = numPages();
            var upper_limit = np - opts.num_display_entries;
            var start = current_page > ne_half ? Math.max(Math.min(current_page - ne_half, upper_limit), 0) : 0;
            var end = current_page > ne_half ? Math.min(current_page + ne_half, np) : Math.min(opts.num_display_entries, np);
            return [start, end];
        }
        function pageSelected(page_id, evt) {
            current_page = page_id;
            drawLinks();
            var continuePropagation = opts.callback(page_id, panel);
            if (!continuePropagation) {
                if (evt.stopPropagation) {
                    evt.stopPropagation();
                }
                else {
                    evt.cancelBubble = true;
                } 
            }
            return continuePropagation;
        }
        function drawLinks() {
            panel.empty();
            var interval = getInterval();
            var np = numPages();
            if (np == 1) {
                $(".Pagination").css({ display: "none" });
            }
            var getClickHandler = function(page_id) {
                return function(evt) { return pageSelected(page_id, evt); } 
            }
            var appendItem = function(page_id, appendopts) {
                page_id = page_id < 0 ? 0 : (page_id < np ? page_id : np - 1);
                appendopts = jQuery.extend({ text: page_id + 1, classes: "" }, appendopts || {});
                if (page_id == current_page) {
                    var lnk = $("<a href='javascript:void(0)' class='current'>" + (appendopts.text) + "</a>");
                }
                else {
                    var lnk = $("<a>" + (appendopts.text) + "</a>")
.bind("click", getClickHandler(page_id))
.attr('href', opts.link_to.replace(/__id__/, page_id));
                }
                if (appendopts.classes) { lnk.addClass(appendopts.classes); }
                panel.append(lnk);
            }
            if (opts.prev_text && (current_page > 0 || opts.prev_show_always)) {
                appendItem(current_page - 1, { text: opts.prev_text, classes: "prev" });
            }
            if (interval[0] > 0 && opts.num_edge_entries > 0) {
                var end = Math.min(opts.num_edge_entries, interval[0]);
                for (var i = 0; i < end; i++) {
                    appendItem(i);
                }
                if (opts.num_edge_entries < interval[0] && opts.ellipse_text) {
                    jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(panel);
                } 
            }
            for (var i = interval[0]; i < interval[1]; i++) {
                appendItem(i);
            }
            if (interval[1] < np && opts.num_edge_entries > 0) {
                if (np - opts.num_edge_entries > interval[1] && opts.ellipse_text) {
                    jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(panel);
                }
                var begin = Math.max(np - opts.num_edge_entries, interval[1]);
                for (var i = begin; i < np; i++) {
                    appendItem(i);
                } 
            }
            if (opts.next_text && (current_page < np - 1 || opts.next_show_always)) {
                appendItem(current_page + 1, { text: opts.next_text, classes: "next" });
            } 
        }
        var current_page = opts.current_page;
        maxentries = (!maxentries || maxentries < 0) ? 1 : maxentries;
        opts.items_per_page = (!opts.items_per_page || opts.items_per_page < 0) ? 1 : opts.items_per_page;
        var panel = jQuery(this);
        this.selectPage = function(page_id) { pageSelected(page_id); }
        this.prevPage = function() {
            if (current_page > 0) {
                pageSelected(current_page - 1);
                return true;
            }
            else {
                return false;
            } 
        }
        this.nextPage = function() {
            if (current_page < numPages() - 1) {
                pageSelected(current_page + 1);
                return true;
            }
            else {
                return false;
            } 
        }
        drawLinks();
    });
};
/*
@Last-Modified:2010/10/26
*/