/*
  所有api接口
 */

//地址前缀
const prefix = 'https://api.weixin.qq.com/cgi-bin/';

module.exports = {
  accessToken: `${prefix}token?grant_type=client_credential`,
  ticket: `${prefix}ticket/getticket?type=jsapi`,
  menu: {
    create: `${prefix}menu/create?`,
    delete: `${prefix}menu/delete?`
  },
  temporary: {
    upload: `${prefix}media/upload?`,
    get: `${prefix}media/get?`
  },
  permanment: {
    uploadNews: `${prefix}material/add_news?`,
    uploadImg: `${prefix}media/uploadimg?`,
    uploadOthers: `${prefix}material/add_material?`,
    get: `${prefix}material/get_material?`
  }
}