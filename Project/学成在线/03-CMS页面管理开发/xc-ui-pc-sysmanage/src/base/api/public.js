require('es6-promise').polyfill()
import axios from 'axios'

axios.defaults.withCredentials = true //跨域
axios.defaults.timeout = 10000
axios.defaults.headers.post['Content-Type'] = 'application/x-www=form-urlencoded'
import utils from '../../common/utils'
if(utils.getJwt()){
  axios.defaults.headers['Authorization'] = 'Bearer '+utils.getJwt()
}
//axios.defaults.headers['Authorization'] = ''
// 请求之前拦截
/*axios.interceptors.request.use(config => {
  // 判断token
  //if (localStorage.token) {
    config.headers.Authorization = 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjEwODA4ODYsInVzZXJfbmFtZSI6IjEyMyIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwianRpIjoiYTNiM2RiYjgtODJkYS00YWI2LWIwZjEtMWMyZDI5ZjM3MjExIiwiY2xpZW50X2lkIjoibWFuYWdlciIsInNjb3BlIjpbIm1hbmFnZXIiXX0.YivH7foaYfSJs9nPBR40TbJ7T0sGXBGaZV2g8Ivktiatdv0Sjkl4PbS3tsjSBtbyqLekYDLoWSojiDLyvgMy5qskeRLefVk4FYpEMzpxfb5JtaxoIRH0o-Re1MC2quq-J7kxRKAL1DUEmr-_GEEmB8zswYJNwYn3vZK0FMQlbsIty4LCfgIwXfH9XnPcUhojUUIBRUDT2W3s8j-qZQ-iKk1y2kesrXloiOtPEL5CljmlOyZ3GED_HNude5b41TqCQyv2VS1baE9DEPo-P0Hb33rSCMILk3rZg-hO7zuDMGfbGWKMQRgY6Fb2uUtqokYa5aLtXyEwW67FKAi2mK2cPA'
  //}
  return config
},error =>{
  alert("参数错误", 'fail')
  return Promise.reject(error)
})*/

export default {
  //get请求
  requestGet (url, params = {}) {
    return new Promise((resolve, reject) => {
      axios.get(url, params).then(res => {
        resolve(res.data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  //get请求不带参数
  requestQuickGet (url) {
    return new Promise((resolve, reject) => {
      axios.get(url).then(res => {
        resolve(res.data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  //post请求
  requestPost (url, params = {}) {
    return new Promise((resolve, reject) => {
      axios.post(url, params).then(res => {
        resolve(res.data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  //post请求
  requestPostForm (url, params = {}) {
    return new Promise((resolve, reject) => {
      axios.post(url, params, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      }).then(res => {
        resolve(res.data)//注意res是axios封装的对象，res.data才是服务端返回的信息
      }).catch(error => {
        reject(error)
      })
    })
  },
  //put请求
  requestPut (url, params = {}) {
    return new Promise((resolve, reject) => {
      axios.put(url, params).then(res => {
        resolve(res.data)
      }).catch(error => {
        reject(error)
      })
    })
  },
  //delete请求
  requestDelete (url, params = {}) {
    return new Promise((resolve, reject) => {
      axios.delete(url, params).then(res => {
        resolve(res.data)
      }).catch(error => {
        reject(error)
      })
    })
  }
}
