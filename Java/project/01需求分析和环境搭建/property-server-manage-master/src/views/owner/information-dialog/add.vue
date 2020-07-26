<template>
  <div>
    <a-modal title="新增" width="70%" v-model="visibleObj.addvisible">
      <a-form-model
        :label-col="labelCol"
        ref="ruleForm"
        :model="form"
        :rules="rules"
        :wrapper-col="wrapperCol"
      >
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="所属公司" prop="affiliatedcompany">
              <a-select v-model="form.affiliatedcompany">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="业主类型">
              <a-select placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="业主编码" prop="ownercode">
              <a-input v-model="form.ownercode"></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="业主姓名" prop="ownername">
              <a-input v-model="form.ownername"></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="性别">
              <a-radio-group>
                <a-radio value="1">男</a-radio>
                <a-radio value="2">女</a-radio>
              </a-radio-group>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="出生日期">
              <a-date-picker type="date" placeholder="Pick a date" style="width: 100%;" />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="民族">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="学历">
              <a-select placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="国籍">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="籍贯">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="证件类型">
              <a-select placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="证件号码">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="工作单位">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="职务">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="手机号码">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="邮编">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="联系地址" :labelCol="{span: 3}" :wrapperCol="{span: 21}">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="紧急联系人">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="紧急联系人电话">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="紧急联系人地址" :labelCol="{span: 3}" :wrapperCol="{span: 21}">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="银行代扣">
              <a-radio-group>
                <a-radio value="1">男</a-radio>
                <a-radio value="2">女</a-radio>
              </a-radio-group>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="开户行">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="银行账号">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="所在派出所">
              <a-input></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="状态">
              <a-select placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="备注">
              <a-input type="textarea"></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
      <template slot="footer">
        <a-button type="primary" icon="save" @click="saveandnew">保存并新建</a-button>&nbsp;
        <a-button type="primary" icon="issues-close" @click="saveandclose">保存并关闭</a-button>&nbsp;
        <a-button type="primary" icon="close-square" @click="handleCancel">关闭</a-button>
      </template>
    </a-modal>
  </div>
</template>

<script>
export default {
    data() {
        return {
            labelCol: { lg: { span: 6 }, sm: { span: 6 } },
            wrapperCol: { lg: { span: 18 }, sm: { span: 18 } },
            form: {
                affiliatedcompany: [],
                ownercode: '',
                ownername: ''
            },
            rules: {
                affiliatedcompany: [{ required: true, message: '所属公司必须填写', trigger: 'change' }],
                ownercode: [{ required: true, message: '业主编码必须填写', trigger: 'blur' }],
                ownername: [{ required: true, message: '业主姓名必须填写', trigger: 'blur' }]
            }
        }
    },
    props: {
        visibleObj: {
            type: Object,
            default: () => {
                return {
                    addvisible: false
                }
            }
        }
    },
    methods: {
        showModal() {
            this.visible = true
        },
        saveandnew() {
            this.$refs.ruleForm.validate(valid => {
                if (valid) {
                    this.$notification.success({
                        message: '提示',
                        duration: 3,
                        description: '保存成功，请新增下一条记录！！'
                    })
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
        },
        saveandclose() {
            this.$refs.ruleForm.validate(valid => {
                if (valid) {
                    this.visibleObj.addvisible = false
                } else {
                    console.log('error submit!!')
                    return false
                }
            })
        },
        handleCancel(e) {
            console.log(e)
            this.visibleObj.addvisible = false
        }
    }
}
</script>

<style lang='less' scoped>
.add {
    width: 600px;
    height: 500px;
}
.ant-form-item {
    margin-top: 5px;
    margin-bottom: 0px;
}
</style>
