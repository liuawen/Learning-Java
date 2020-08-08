import http from '@/base/api/public'
import querystring from 'querystring'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;
//测试
export const page_test= id => {
  return http.requestQuickGet(apiUrl+'/cms/user/get/'+id)
}
/*页面列表*/
export const page_list = (page,size,params) => {
  //params为json格式
  //使用querystring将json对象转成key/value串
  let querys = querystring.stringify(params)
  return http.requestQuickGet(apiUrl+'/cms/page/list/'+page+'/'+size+'/?'+querys)
}
/*页面添加*/
export const page_add = params => {
  return http.requestPost(apiUrl+'/cms/page/add',params)
}
/*页面修改*/
export const page_edit = params => {
  return http.requestPut(apiUrl+'/cms/page/edit',params)
}
/*页面查询*/
export const page_get = id => {
  return http.requestQuickGet(apiUrl+'/cms/page/get/'+id)
}
/*页面删除*/
export const page_del = id => {
  return http.requestDelete(apiUrl+'/cms/page/del/'+id)
}
/*生成静态文件 */
export const page_generateHtml= id => {
  return http.requestPost(apiUrl+'/cms/page/generateHtml/'+id)
}
/*取出静态文件 */
export const page_getHtml= id => {
  return http.requestQuickGet(apiUrl+'/cms/page/getHtml/'+id)
}
/*发布页面*/
export const page_postPage= id => {
  return http.requestPost(apiUrl+'/cms/page/postPage/'+id)
}
