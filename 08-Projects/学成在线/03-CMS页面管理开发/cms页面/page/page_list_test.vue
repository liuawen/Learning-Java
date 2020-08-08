<template>
  <div>
    hello world!
    用户id：{{user.id}},用户名称：{{user.name}}
  </div>
</template>
<script>
  import * as cmsApi from '../api/cms'
  export default{
    data(){
        return {
          user:{}
        }

    },
    created: function () {
      //ajax请求后台接口
      cmsApi.page_test('101').then((res)=>{
          console.log(res)
          this.user = res;
      });
    }
  }
</script>
<style>

</style>
