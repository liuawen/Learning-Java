function NewScrollText(elementId,dsiplayId,lineHeight,diffHeight,initScrollTop,scrollLine,marqueeDelay) {
    this.elementId = elementId;
    this.dsiplayId = dsiplayId;
    this.lineHeight = lineHeight ? lineHeight : 20;
    this.marqueeContent = new Array();
    this.marqueeInterval = new Array();
    this.marqueeId = 0;
    this.marqueeDelay = marqueeDelay ? marqueeDelay : 3500;//停顿几秒
    this.scrollLine = scrollLine ? scrollLine : 2;//显示几行
    this.marqueeHeight= this.scrollLine*this.lineHeight+(diffHeight?diffHeight:0);
    this.endScrollTop = parseInt(1.5*this.marqueeHeight);
    this.initScrollTop = initScrollTop ? initScrollTop : 8;
}

NewScrollText.prototype.$ = function(element) {
    return document.getElementById(element);
}

NewScrollText.prototype.initMarquee = function() {
    this.marqueeContent= $("#"+this.elementId).children();
    var str=$(this.marqueeContent[0]).html();
    if(this.marqueeContent.length > 1){
        var innerthtml = '<div id="marqueeBox" style="overflow:hidden;height:'+this.marqueeHeight+'px"><div>'+str+'</div></div>';
        this.$(this.dsiplayId).innerHTML = innerthtml;
        this.$(this.dsiplayId).onmouseover = this.GetFunction(this, "stop")
        this.$(this.dsiplayId).onmouseout = this.GetFunction(this, "start");
    }else{
        var innerthtml = '<div id="marqueeBox" style="overflow:hidden;height:'+this.marqueeHeight+'px"><div>'+str+'</div></div>';
        this.$(this.dsiplayId).innerHTML = innerthtml;
    }
    this.marqueeId++;
    if(this.marqueeContent.length > 1){
        this.marqueeInterval[0]=setInterval(this.GetFunction(this, "startMarquee"),this.marqueeDelay);
    }
}

NewScrollText.prototype.stop = function(){
    clearInterval(this.marqueeInterval[0]);
}

NewScrollText.prototype.start = function(){
    this.marqueeInterval[0]=setInterval(this.GetFunction(this, "startMarquee"),this.marqueeDelay);
}

NewScrollText.prototype.startMarquee = function() {
    var str=$(this.marqueeContent[this.marqueeId]).html();
    this.marqueeId++;
    if(this.marqueeId>=this.marqueeContent.length) this.marqueeId=0;
    if(document.getElementById("marqueeBox").childNodes.length==1) {
        var nextLine=document.createElement('DIV');
        nextLine.innerHTML=str;
        document.getElementById("marqueeBox").appendChild(nextLine);
    }
    else{
        document.getElementById("marqueeBox").childNodes[0].innerHTML=str;
        document.getElementById("marqueeBox").appendChild(document.getElementById("marqueeBox").childNodes[0]);
    }
    document.getElementById("marqueeBox").scrollTop=this.initScrollTop;
    clearInterval(this.marqueeInterval[1]);
    this.marqueeInterval[1]=setInterval(this.GetFunction(this, "scrollMarquee"),20);
}

NewScrollText.prototype.scrollMarquee = function() {
    document.getElementById("marqueeBox").scrollTop++;
    if(document.getElementById("marqueeBox").scrollTop==this.endScrollTop){
        clearInterval(this.marqueeInterval[1]);
    }
}

NewScrollText.prototype.GetFunction = function(variable, method, param) {
    return function() {
        variable[method](param);
    }
}