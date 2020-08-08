(function() {
	//放入cdn上，目前51job用户 
    String.prototype.trim=function(){
        return this.replace(/(^\s*)|(\s*$)/g, "");
    }

    var _tkd = "_tkd";
    function Tracker() {
        var oThis = this;
        oThis.p = {
            push: function () {
                oThis.handleEvent.apply(oThis, arguments);
            }
        };
        oThis.handle();
    }

    Tracker.prototype = {      
        handle:function (){
            var oThis = this;
            try{
                _tracker_ : {
                    var tkd = window[_tkd],isArray = false;
                    if(tkd) {
                        isArray = Object.prototype["toString"].call(Object(tkd)) == "[object Array]";
                        if(!isArray){
                            break _tracker_;
                        }
                        //handle event
                        for (var x = 0; x < tkd.length; x++) {
                            oThis.handleEvent(tkd[x]);
                        }
                    }
                    window[_tkd] = oThis.p;
                }
            }catch(exception){
            }
        },
        handleEvent : function(args){
            switch (args[0]) {
               case "_trackSearch":
                   send("search", args[1]);
                    break;
               case "_trackPageView":
                   send("pageView", args[1]);
                   break;
               case "_trackEvent":
                   send("event", args[1]);
                   break;
            }
         }
    }
    
    //send get request
    function send(logType, params) {
        var win = window;
        var n = '_job_img_' + (+new Date()) + '.r' + Math.floor(Math.random() * 1000),
            img = win[n] = new Image();
        img.onload = img.onerror = function () {
            win[n] = null;
        };
        var q = "https:" == document.location.protocol ? "https:" : "http:";
        img.src = q + "//trace.51jingying.com/logRecord.php?" + params + "&vt=" + new Date().getTime() + "&logType=" + logType;
    }

    new Tracker;
})();
