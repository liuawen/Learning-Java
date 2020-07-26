<template>
  <div>
    <a-form-model>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="所属公司"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input v-model="form.affiliates" disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="住宅编码"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input v-model="form.code" disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="住宅名称"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input v-model="form.housename" disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="占地面积(平房米)" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="建筑面积(平房米)" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="绿地面积(平房米)" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="道路面积(平房米)" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="楼宇数量"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input v-model.number="form.housecount" disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="负责人" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-form-model-item label="住宅地址" :labelCol="{span: 3}" :wrapperCol="{span: 20}">
          <a-input disabled/>
        </a-form-model-item>
      </a-row>
      <a-row>
        <div style="text-align:center; height: 40px; line-height: 30px;">----开发商信息----</div>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="公司名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="法人代表" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="联系人" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="联系电话" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled/>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-form-model-item label="备注" :labelCol="{span: 2}" :wrapperCol="{span: 21}">
          <a-input type="textarea" disabled/>
        </a-form-model-item>
      </a-row>
    </a-form-model>
  </div>
</template>

<script>
export default {
    data() {
        return {
            labelCol: { lg: { span: 4 }, sm: { span: 4 } },
            wrapperCol: { lg: { span: 18 }, sm: { span: 18 } },
            form: {
                code: '',
                affiliates: '',
                housename: '',
                housecount: ''
            }
        }
    }
}
</script>

<style lang="less" scoped>
.housinginformation-header{
    height: 50px;
    line-height: 50px;
    color: rgba(0, 0, 0, 0.85);
    text-indent: 10px;
}
.step-form-style-desc {
    padding: 0 56px;
    color: rgba(0, 0, 0, 0.45);

    h3 {
        margin: 0 0 12px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        line-height: 32px;
    }

    h4 {
        margin: 0 0 4px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 14px;
        line-height: 22px;
    }

    p {
        margin-top: 0;
        margin-bottom: 12px;
        line-height: 22px;
    }
}
.ant-form-item {
    margin-bottom: 8px;
}
</style>
