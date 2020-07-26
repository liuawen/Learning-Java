<template>
  <a-modal
    title="新增业主信息"
    width="60%"
    v-model="addObj.addVisible"
    okText="保存"
    cancelText="关闭"
    :destroyOnClose="true"
    @ok="() => ok()"
  >
    <a-form-model
      :label-col="labelCol"
      :wrapper-col="wrapperCol"
      ref="ruleForm"
      :model="form"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="选择房产" prop="chooseproperty">
            <a-select v-model="form.chooseproperty">
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="楼宇名称" prop="buildingname">
            <a-select v-model="form.buildingname">
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="单元楼层" prop="unitfloor">
            <a-select v-model="form.unitfloor">
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="房间名称" prop="roomname">
            <a-select v-model="form.roomname">
              <a-select-option value="1">是</a-select-option>
              <a-select-option value="0">否</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="验收项目" prop="acceptanceitems">
            <a-select v-model="form.acceptanceitems">
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="验收日期" prop="acceptancedate">
            <a-date-picker
              v-model="form.acceptancedate"
              type="date"
              placeholder="Pick a date"
              style="width: 100%;"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="确认日期" prop="confirmationdate">
            <a-date-picker
              v-model="form.confirmationdate"
              type="date"
              placeholder="Pick a date"
              style="width: 100%;"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="是否合格" prop="isqualified">
            <a-select v-model="form.isqualified">
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="验收人员" :labelCol="{span: 3}" :wrapperCol="{span: 20}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="补充备注" :labelCol="{span: 3}" :wrapperCol="{span: 20}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="业主意见" :labelCol="{span: 3}" :wrapperCol="{span: 20}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="房管员意见" :labelCol="{span: 3}" :wrapperCol="{span: 20}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
export default {
    props: {
        addObj: {
            type: Object,
            default: () => {
                return {
                    addVisible: false
                }
            }
        }
    },
    data() {
        return {
            labelCol: { lg: { span: 6 }, sm: { span: 6 } },
            wrapperCol: { lg: { span: 16 }, sm: { span: 16 } },
            form: {
                chooseproperty: [],
                buildingname: [],
                unitfloor: [],
                roomname: [],
                acceptanceitems: [],
                acceptancedate: undefined,
                confirmationdate: undefined,
                isqualified: []
            },
            rules: {
                chooseproperty: [{ required: true, message: '选择房产必须填写', trigger: 'change' }],
                buildingname: [{ required: true, message: '楼宇名称必须填写', trigger: 'change' }],
                unitfloor: [{ required: true, message: '单元楼层必须填写', trigger: 'change' }],
                roomname: [{ required: true, message: '房间名称必须填写', trigger: 'change' }],
                acceptanceitems: [{ required: true, message: '验收项目必须填写', trigger: 'change' }],
                acceptancedate: [{ required: true, message: '验收日期必须填写', trigger: 'change' }],
                confirmationdate: [{ required: true, message: '确认日期必须填写', trigger: 'change' }],
                isqualified: [{ required: true, message: '是否合格必须填写', trigger: 'change' }]
            }
        }
    },
    methods: {
        ok() {
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
        }
    }
}
</script>

<style lang="less" scoped>
.ant-form-item {
    margin-bottom: 0px;
}
</style>
