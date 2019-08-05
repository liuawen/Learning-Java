//rem适配方案
(function(){
  var styleNode = document.createElement('style')
  var width = document.documentElement.clientWidth/16
  styleNode.innerHTML = 'html{font-size:'+width+'px!important}'
  document.head.appendChild(styleNode)
})()