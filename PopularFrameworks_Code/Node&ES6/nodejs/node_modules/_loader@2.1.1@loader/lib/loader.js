/**
 * 本文件用于loader的实现
 */

/*!
 * Dependencies
 */
var path = require('path');

/**
 * 静态资源加载器
 * @param js 压缩js路径
 * @param css 压缩css路径
 */
var Loader = function (js, css) {
  if (!(this instanceof Loader)) {
    return new Loader(js, css);
  }

  var target = {};
  if (js) {
    target[path.extname(js)] = js;
  }

  if (css) {
    target[path.extname(css)] = css;
  }

  this.script = {
    assets: [],
    target: target[".js"]
  };
  this.style = {
    assets: [],
    target: target[".css"]
  };
};

/**
 * 加载js文件
 * @param {String} src js文件相对项目根目录的路径
 */
Loader.prototype.js = function (src) {
  this.script.assets.push(src);
  return this;
};

/**
 * 加载css文件
 * @param {String} href css文件相对项目根目录的路径
 */
Loader.prototype.css = function (href) {
  this.style.assets.push(href);
  return this;
};

var timestamp = (new Date()).getTime();

/**
 * 生成开发环境下的标签
 */
Loader.prototype.dev = function (prefix) {
  var html = '';
  prefix = prefix || '';
  var version = '?v=' + timestamp;

  var i;
  for (i = 0; i < this.script.assets.length; i++) {
    html += '<script src="' + prefix + this.script.assets[i] + version + '"></script>\n';
  }
  for (i = 0; i < this.style.assets.length; i++) {
    html += '<link rel="stylesheet" href="' + prefix + this.style.assets[i] + version + '" media="all" />\n';
  }

  return html;
};

/**
 * 生成线上环境下的标签
 * @param {Object} CDNMap 通过Loader.scanDir() => Loader.minify() => Loader.map()得到的map文件
 * @param {String} prefix CDN前缀。如有CDN，可以一键切换文件到CDN中
 */
Loader.prototype.pro = function (CDNMap, prefix) {
  prefix = prefix || '';
  var html = '';
  var scriptTarget = this.script.target;
  if (scriptTarget && CDNMap[scriptTarget]) {
    html += '<script src="' + prefix + CDNMap[scriptTarget] + '"></script>\n';
  }
  var styleTarget = this.style.target;
  if (styleTarget && CDNMap[styleTarget]) {
    html += '<link rel="stylesheet" href="' + prefix + CDNMap[styleTarget]  + '" media="all" />\n';
  }

  return html;
};

/**
 * 根据环境和版本号去生成对应标签
 * 如果env没有传入，将取`process.env.NODE_ENV`作为判断，`production`为产品环境，其余将采用原始版本
 * @param {Object} CDNMap 通过Loader.scanDir() => Loader.minify() => Loader.map()得到的map文件
 * @param {String} prefix CDN前缀。如有CDN，可以一键切换文件到CDN中
 * @param {Boolean} env 是否启用压缩版
 */
Loader.prototype.done = function (CDNMap, prefix, mini) {
  // 优先级：1. 参数传入 2. 全局
  CDNMap = CDNMap || Loader.CDNMap || {};

  // prefix: 1. 参数传入 2. this.prefix 3. 全局
  if (prefix === undefined) { // 可能传入 ''
    prefix = this.prefix;
  }

  if (prefix === undefined) {
    prefix = Loader.prefix;
  }

  if (prefix && prefix.endsWith('/')) {
    prefix = prefix.slice(0, -1);
  }

  // mode
  var mode;
  if (mini !== undefined) { // 可能传入 0
    mode = mini;
  } else if (this.mini !== undefined) {
    mode = this.mini;
  } else if (Loader.mini !== undefined) {
    mode = Loader.mini;
  } else {
    mode = process.env.NODE_ENV === "production";
  }

  return mode ? this.pro(CDNMap, prefix) : this.dev(prefix);
};

var File = function (target) {
  this.target = target;
};

File.prototype.done = function (CDNMap, prefix, hashed) {
  // 优先级：1. 参数传入 2. 全局
  CDNMap = CDNMap || Loader.CDNMap || {};

  // prefix: 1. 参数传入 2. 全局
  if (prefix === undefined) { // 可能传入 ''
    prefix = this.prefix;
  }

  if (prefix === undefined) {
    prefix = Loader.prefix;
  }

  if (prefix && prefix.endsWith('/')) {
    prefix = prefix.slice(0, -1);
  }

  prefix = prefix || '';

  // mode
  var mode;
  if (hashed !== undefined) { // 可能传入 0
    mode = hashed;
  } else if (Loader.mini !== undefined) {
    mode = Loader.mini;
  } else {
    mode = process.env.NODE_ENV === "production";
  }

  return prefix + (mode ? CDNMap[this.target] : this.target);
};

Loader.file = function (target) {
  return new File(target);
};

module.exports = Loader;
