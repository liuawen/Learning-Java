loader [![Build Status](https://secure.travis-ci.org/JacksonTian/loader.png?branch=master)](http://travis-ci.org/JacksonTian/loader) [![Coverage Status](https://coveralls.io/repos/JacksonTian/loader/badge.png)](https://coveralls.io/r/JacksonTian/loader)
==========================

Node静态资源加载器。该模块通过两个步骤配合完成，代码部分根据环境生成标签。上线时，需要调用minify方法进行静态资源的合并和压缩。

# Usage
## Installation

```sh
$ npm install loader
```

## Example
Controller:

```js
res.render(tpl, {
  Loader: require('loader')
});
```
View:
```html
<%- Loader("/assets/scripts/jqueryplugin.js", "/assets/styles/jqueryplugin.css")
  .js("/assets/scripts/lib/jquery.jmodal.js")
  .js("/assets/scripts/lib/jquery.mousewheel.js")
  .js("/assets/scripts/lib/jquery.tagsphere.js")
  .css("/assets/styles/jquery.autocomplate.css")
  .done(assetsMap, prefix, combo) %>
```

在[loader-builder](https://github.com/JacksonTian/loader-builder)/[loader-connect](https://github.com/JacksonTian/loader-connect)/[loader-koa](https://github.com/JacksonTian/loader-koa)的支持下，`.js`方法也可以加载`.coffee`、`.es`类型的文件，`.css`方法可以加载`.less`、`.styl`文件。

### 环境判别
环境判别由`done`方法的第三个参数决定，如果传入combo值，将决定选用线下版本还是线上版本。如果不传入第三个参数，将由环境变量。如下代码实现：

```js
process.env.NODE_ENV === 'production'
```
如果不传入combo，需要设置环境，通过以下代码实现：

```sh
$ # 生产环境
$ export NODE_ENV="production"
$ # 开发环境
$ export NODE_ENV="dev"
```
可切换进`example`目录运行示例代码：

```sh
$ npm start
```

### 线上输出
线上模式将会输出合并和压缩后的地址，该地址从Loader构造参数中得到。

```html
<script src="/assets/scripts/jqueryplugin.md5_hash.js"></script>
<link rel="stylesheet" href="/assets/styles/jqueryplugin.md5_hash.css" media="all" />
```

如果你有CDN地址，可以传入prefix参数，使得可以一键切换到CDN地址上，实现网络加速。以下为结果示例：

```html
<script src="http://cnodejs.qiniudn.com/assets/scripts/jqueryplugin.md5_hash.js"></script>
<link rel="stylesheet" href="http://cnodejs.qiniudn.com/assets/styles/jqueryplugin.css" media="all" />
```

### 线下输出
线下模式输出为原始的文件地址。

```html
<script src="/assets/scripts/lib/jquery.jmodal.js"></script>
<script src="/assets/scripts/lib/jquery.mousewheel.js"></script>
<script src="/assets/scripts/lib/jquery.tagsphere.js"></script>
<link rel="stylesheet" href="/assets/styles/jquery.autocomplate.css" media="all" />
```

## 构建
上文没有提及的重要值是`assetsMap`，这个值需要通过构建产生，类似如下格式：

```json
{
  "/assets/index.min.js":"/assets/index.min.ecf8427e.js",
  "/assets/index.min.css":"/assets/index.min.f2fdeab1.css"
}
```

如果需要线上执行，需要该对象的传入。而该对象需要通过以下构建脚本（loader-builder）来生成：

```sh
$ builder <views_dir> <output_dir>
$ # 或者
$ ./node_modules/loader-builder/bin/builder <views_dir> <output_dir>
```

以上脚本将会遍历视图目录中寻找`Loader().js().css().done()`这样的标记，然后得到合并文件与实际文件的关系。如以上的`assets/index.min.js`文件并不一定需要真正存在，进行扫描构建后，会将相关的`js`文件进行编译和合并为一个文件。
并且根据文件内容进行md5取hash值，最终生成`/assets/index.min.ecf8427e.js`这样的文件。

遍历完目录后，将这些映射关系生成为`assets.json`文件，这个文件位于`<output_dir>`指定的目录下。使用时请正确引入该文件。具体请参见`example`目录下的代码示例。

## 流程
![流程](./figures/flow.png)

## API
请参见[API文档](http://doxmate.cool/JacksonTian/loader/api.html)。

# License
[MIT license](https://github.com/JacksonTian/loader/blob/master/MIT-License)
