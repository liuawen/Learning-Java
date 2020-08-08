import http from './public'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;
/*数据字典 */
export const sys_getDictionary= dType => {
  return http.requestQuickGet(apiUrl+'/sys/dictionary/get/'+dType)
}

/*存储文件元数据*/
export const sys_saveFileMetedata = params => {
  return http.requestPost(apiUrl+'/filesystem/saveFileMetedata',params)
}

/*删除文件*/
export const sys_deleteFile = params => {
  return http.requestPost(apiUrl+'/filesystem/delete',params)
}


