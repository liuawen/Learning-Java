<template>
  <div>

    <el-col :span="24" class="header">
      <el-col :span="14" class="logo" >
        <img src="/static/images/asset-logoIco-white.png" width="500px" alt="">{{collapsed ? '' : sysName}}
      </el-col>
      <!--<el-col :span="10">
        <div class="tools" @click.prevent="collapse">
          <i class="fa fa-align-justify"></i>
        </div>
      </el-col>-->
      <el-col :span="10" class="userinfo" v-if="this.logined">
        <!--<el-dropdown trigger="hover">
         <span class="el-dropdown-link userinfo-inner"><img :src="this.user.sysUserImg!=null?this.user.sysUserImg:'/static/images/small.jpg'"/> {{user.username}}</span>

          <el-dropdown-menu slot="dropdown">
           <el-dropdown-item>我的消息</el-dropdown-item>
           <el-dropdown-item>设置</el-dropdown-item>
           <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
         </el-dropdown-menu>
       </el-dropdown>-->

        <div class="nav">

            <div class="usermenu" >
              <span class="el-dropdown-link userinfo-inner"><img :src="this.user.sysUserImg!=null?this.user.sysUserImg:'/static/images/small.jpg'"/></span>
              欢迎您：{{user.username}}
              <a href="http://www.xuecheng.com" target="_blank"><i class="el-icon-star-on"></i>首页</a>
              <a href="javascript:;" @click="logout" :loading="editLoading"><i class="el-icon-circle-close"></i>退出</a>
            </div>
          </div>
      </el-col>
    </el-col>
    <!-- 1.0 利用mint-ui中的header组件实现整个系统的头部 -->
    <!-- <mt-header fixed title="传智播客.黑马程序员Vue商城系统">
       <router-link to="/" slot="left">
         <mt-button icon="back">首页</mt-button>
       </router-link>
       <mt-button icon="more" slot="right">
         <router-link to="/login">登录</router-link>|
         <router-link to="/register">注册</router-link>
       </mt-button>
     </mt-header>-->
  </div>
</template>
<script type="text/javascript">
  import jwtDecode from 'jwt-decode'
  import utilApi from '../../common/utils'
  import * as loginApi from '../../module/home/api/home'
  export default {
    data() {
      return {
        editLoading:false,
        sysName: '系统管理中心',
        user:{
          userid:'',
          username: '',
          userimg: ''
        },
        logined:false,
        collapsed: false,


      }
    },
    methods: {

      //退出登录
      logout: function () {
        this.$confirm('确认退出吗?', '提示', {
        }).then(() => {
          //跳转到统一登陆
          window.location = "http://ucenter.xuecheng.com/#/logout"
          /*const loading = this.$loading({
            lock: true,
            text: 'Loading',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
          });
          loginApi.logout({}).then((res) => {
              loading.close();
            if(res.success){
              this.$message('退出成功');
              //跳转到登陆页面
              this.$router.push({ path: '/login'})
            }else{
              this.$message.error('退出失败');
            }
          },
            (res) => {
              loading.close();
            });*/
        }).catch(() => {

        });
      },
      refresh_user:function(){
        let activeUser= utilApi.getActiveUser();

        if(activeUser){
          this.logined = true
          this.user = activeUser;
          //console.log(this.user.username)
        }
      }
    },
    mounted() {
      this.refresh_user()

    }
  }
</script>
<style scoped lang="scss">
  @import '~scss_vars';
  .nav {
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
  }
  .usermenu {
    float: right;
    padding: 0 2em;
    color:#fff;
  }
  .usermenu a {
    text-decoration: none;
    margin: 0 0.2em 0 1em;
    color:inherit;
  }
  .container {
    position: absolute;
    top: 0px;
    bottom: 0px;
    width: 100%;
  .header {
    height: 60px;
    line-height: 60px;
    background: $color-primary;
    color: #fff;
  .userinfo {
    text-align: right;
    padding-right: 15px;
    float: right;
  .userinfo-inner {
    cursor: pointer;
    color: #fff;
  img {
    width: 40px;
    height: 40px;
    border-radius: 20px;
    margin: 10px 8px 10px 10px;
    float: left;
  }
  }
  }
  .logo {
  //width:230px;
    height: 60px;
    font-size: 20px;
    padding-left: 0px;
    padding-right: 20px;
    border-color: rgba(238, 241, 146, 0.3);
    border-right-width: 1px;

  img {
    width: 200px;
    float: left;
    margin: 10px 10px 10px 18px;
  }
  .txt {
    color: #fff;
  }
  }
  .logo-width {
    width: 250px;
  }
  .logo-collapse-width {
    width: 60px
  }
  .tools {
    padding: 0px 23px;
    width: 14px;
    height: 60px;
    line-height: 60px;
    cursor: pointer;
  }
  }
  .main {
    display: flex;
  // background: #324057;
    position: absolute;
    top: 60px;
    bottom: 0px;
    overflow: hidden;
  aside {
    flex: 0 0 230px;
    width: 230px;
  // position: absolute;
  // top: 0px;
  // bottom: 0px;
  .el-menu {
    height: 100%;
  }
  .collapsed {
    width: 60px;
  .item {
    position: relative;
  }
  .submenu {
    position: absolute;
    top: 0px;
    left: 60px;
    z-index: 99999;
    height: auto;
    display: none;
  }

  }
  }
  .menu-collapsed {
    flex: 0 0 60px;
    width: 60px;
  }
  .menu-expanded {
    flex: 0 0 230px;
    width: 230px;
  }
  .content-container {
    background: #fff;
    flex: 1;
  // position: absolute;
  // right: 0px;
  // top: 0px;
  // bottom: 0px;
  // left: 230px;
    overflow-y: scroll;
    padding: 20px;
  .breadcrumb-container {
  //margin-bottom: 15px;
  .title {
    width: 200px;
    float: left;
    color: #475669;
  }
  .breadcrumb-inner {
    float: right;
  }
  }
  .content-wrapper {
    background-color: #fff;
    box-sizing: border-box;
  }
  }
  }
  }
</style>
