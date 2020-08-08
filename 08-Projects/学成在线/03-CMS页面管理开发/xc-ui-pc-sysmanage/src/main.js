// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueRouter from 'vue-router'

import routes from './base/router'
import store from './vuex/store'
import Vuex from 'vuex'
import utilApi from './common/utils';
// import Mock from './mock'
// Mock.bootstrap();


Vue.config.productionTip = false

// 在Vue中全局使用mintui
Vue.use(ElementUI)
Vue.use(Vuex)
Vue.use(VueRouter)


//  将vue-resource在vue中绑定，自动在vue对象实例上注入一个$http对象就可以使用ajax方法了
import vueResource from 'vue-resource';
let Base64 = require('js-base64').Base64;
let sysConfig = require('@/../config/sysConfig')
let openAuthenticate = sysConfig.openAuthenticate
let openAuthorize = sysConfig.openAuthorize

Vue.use(vueResource);
/* eslint-disable no-new */
const router = new VueRouter({
  routes:routes
})
/*
router.beforeEach((to, from, next) => {
  if(openAuthenticate){

    // console.log(to)
    // console.log(from)
    //!***********身份校验***************
    let activeUser
    let uid
    try{
      activeUser = utilApi.getActiveUser()
      uid = utilApi.getCookie("uid")
    }catch(e){
      //alert(e)
    }
    if(activeUser && uid && uid == activeUser.uid) {
      next();
    }else if(to.path =='/login' || to.path =='/logout'){
      next();
    }else if(uid){

      //请求获取jwt
      systemApi.getjwt().then((res)=>{
        if(res.success){
          let jwt = res.jwt;
          let activeUser = utilApi.getUserInfoFromJwt(jwt)
          if(activeUser){
            utilApi.setUserSession("activeUser",JSON.stringify(activeUser))
          }
          next();
        }else{
          //跳转到统一登陆
          window.location = "http://ucenter.xuecheng.com/#/login?returnUrl="+ Base64.encode(window.location)
        }
      })
    }else{
      //跳转到统一登陆
      window.location = "http://ucenter.xuecheng.com/#/login?returnUrl="+ Base64.encode(window.location)
    }
  }else{
    next();
  }

});*/
//授权
// router.afterEach((to, from, next) => {
//   if(openAuthorize){
//     let activeUser
//     try{
//       activeUser = utilApi.getActiveUser();
//     }catch(e){
//       //alert(e)
//     }
//     if(activeUser) {
//       //权限校验
//       let requiresAuth = to.meta.requiresAuth;
//       let permission =to.meta.permission;
//       if(requiresAuth && permission){
//         utilApi.checkAuthorities(router,permission);
//       }
//     }
//   }
//
// });

import axios from 'axios'
import { Message } from 'element-ui';

/*// 添加请求拦截器
axios.interceptors.request.use(function (config) {
  // 在发送请求向header添加jwt
  let jwt = utilApi.getJwt()
  if(jwt){
    config.headers['Authorization'] = 'Bearer '+jwt
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});
// 响应拦截
axios.interceptors.response.use(data => {
  console.log("data=")
  console.log(data)
  if(data && data.data){
    if(data.data.code && data.data.code =='10001'){
      //需要登录
      // router.push({
      //   path: '/login',
      //   query: {returnUrl: Base64.encode(window.location)}
      // })
      window.location = "http://ucenter.xuecheng.com/#/login?returnUrl="+ Base64.encode(window.location)
    }else if(data.data.code && data.data.code =='10002'){
      Message.error('您没有此操作的权限，请与客服联系！');
    }else if(data.data.code && data.data.code =='10003'){
      Message.error('认证被拒绝，请重新登录重试！');
    }
  }
  return data
})*/

new Vue({
  el: '#app',
  router,
  store,
  // template: '<App/>',
  // components: { App }
  render: c => c(App)
})
