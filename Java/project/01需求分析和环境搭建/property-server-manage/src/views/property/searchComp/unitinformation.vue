<template>
  <div>
    <a-form-model>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="单元编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="单元名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="开始楼层" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="结束楼层" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="开始房号" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="结束房号" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input disabled />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-form-model-item label="备注" :labelCol="{span: 2}" :wrapperCol="{span: 21}">
          <a-input type="textarea" disabled />
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
            wrapperCol: { lg: { span: 18 }, sm: { span: 18 } }
        }
    }
}
</script>

<style scoped>
.ant-form-item {
    margin-bottom: 8px;
}
</style>
