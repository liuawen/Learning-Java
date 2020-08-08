<template>

  <section>
    <el-form   :model="pageForm" label-width="150px"  ref="pageForm" >
      <el-form-item label="页面名称" >
          {{pageForm.pageName}}
      </el-form-item>


      <el-form-item label="静态化" prop="htmlValue">
        <!--<el-button type="primary" @click.native="generateHtml" :loading="addLoading">静态化</el-button>-->
        <el-input
          type="textarea"
          :rows="20"
          placeholder="点击 静态化 将根据模版生成静态化页面"
          v-model="pageForm.htmlValue"
         >
        </el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="go_back">返回</el-button>

      <el-button type="primary" @click.native="generateHtml" :loading="addLoading">静态化，并保存</el-button>
    </div>

  </section>
</template>
<script>
  import * as cmsApi from '../api/cms'
  export default{
    data() {
      return {
        addLoading: false,//加载效果标记
        templateForm:{
          templateValue:''
        },
        pageForm: {
          siteId:'',
          pageId:'',
          pageName:'',
          templateId:'',
          pageParams:[],
          htmlValue: ''
        }

     }
    },methods:{
      go_back(){
        this.$router.push({
          path: '/cms/page/list', query: {
            page: this.$route.query.page,
            siteId:this.$route.query.siteId
          }
        })
      },
      //生成静态页面并保存
      generateHtml: function () {
              cmsApi.page_generateHtml(this.pageForm.pageId).then((res) => {
                console.log(res);
                if(res.success){
                  this.addLoading = false;
                  this.$message.success('生成静态化页面成功！')
                  this.pageForm.htmlValue = res.html
                } else if(res.message) {
                  this.addLoading = false;
                  this.$message.error(res.message);
                }else{
                  this.addLoading = false;
                  this.$message.error('生成静态化页面失败！');
                }
              });
      }
    },
    created: function () {
      this.pageId=this.$route.params.pageId;
      //根据主键查询页面信息
      cmsApi.page_get(this.pageId).then((res) => {
        console.log(res);
        if(res.success){
          this.pageForm.pageName = res.cmsPage.pageName;
        }
      });
    },
    mounted(){
      this.pageForm.pageId=this.$route.params.pageId;

      //取出页面信息
      cmsApi.page_getHtml(this.pageForm.pageId).then((res) => {
        console.log(res);
        if(res.success){
          this.pageForm.htmlValue = res.html
        }

      });

    }
  }
</script>
<style scoped>

</style>
