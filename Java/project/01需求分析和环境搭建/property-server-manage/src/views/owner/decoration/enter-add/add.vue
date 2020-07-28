<template>
  <div>
    <a-modal title="新增" width="60%" v-model="visibleObj.addvisible">
      <a-form-model
        :label-col="labelCol"
        ref="ruleForm"
        :model="form"
        :rules="rules"
        :wrapper-col="wrapperCol"
      >
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="选择楼盘" prop="chooseestate">
              <a-select v-model="form.chooseestate">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="楼宇名称" prop="buildingname">
              <a-select v-model="form.buildingname" placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="单元/楼层" prop="unitandfloor">
              <a-select v-model="form.unitandfloor">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="房间名称" prop="roomname">
              <a-select v-model="form.roomname" placeholder="please select your zone">
                <a-select-option value="shanghai">Zone one</a-select-option>
                <a-select-option value="beijing">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="申请人" prop="applicant">
              <a-input v-model="form.applicant"></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="联系电话" prop="phonenumber">
              <a-input v-model="form.phonenumber"></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item label="申请时间" prop="applicationtime">
              <a-date-picker
                v-model="form.applicationtime"
                type="date"
                placeholder="Pick a date"
                style="width: 100%;"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item label="状态">
              <a-input disabled v-model="form.status"></a-input>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="24">
            <a-form-model-item
              prop="decorationcontent"
              label="装修内容"
              :labelCol="{span: 3}"
              :wrapperCol="{span: 21}"
            >
              <a-input v-model="form.decorationcontent" type="textarea"></a-input>
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
                chooseestate: [],
                buildingname: [],
                unitandfloor: [],
                roomname: [],
                applicant: '',
                phonenumber: '',
                applicationtime: undefined,
                status: '待审批',
                decorationcontent: ''
            },
            rules: {
                chooseestate: [{ required: true, message: '选择楼盘必须填写', trigger: 'change' }],
                buildingname: [{ required: true, message: '楼宇名称必须填写', trigger: 'change' }],
                unitandfloor: [{ required: true, message: '单元楼层必须填写', trigger: 'change' }],
                roomname: [{ required: true, message: '单元楼层必须填写', trigger: 'change' }],
                applicant: [{ required: true, message: '申请人必须填写', trigger: 'blur' }],
                phonenumber: [{ required: true, message: '联系电话必须填写', trigger: 'blur' }],
                applicationtime: [{ required: true, message: '申请时间必须填写', trigger: 'change' }],
                decorationcontent: [{ required: true, message: '装修内容必须填写', trigger: 'blur' }]
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
