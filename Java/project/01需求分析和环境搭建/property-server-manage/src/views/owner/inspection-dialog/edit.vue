
<template>
  <a-modal
    :title="`修改${editObj.editrecord.estate}业主信息`"
    width="60%"
    v-model="editObj.editVisible"
    okText="保存"
    cancelText="关闭"
    :destroyOnClose="true"
  >
    <a-form-model :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="项目验收">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="验收日期">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="确认日期">
            <a-input />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item label="是否合格">
            <a-select>
              <a-select-option value="1">是</a-select-option>
              <a-select-option value="0">否</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item label="验收人员">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="业主意见" :labelCol="{span: 3}" :wrapperCol="{span: 21}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="房管员意见" :labelCol="{span: 3}" :wrapperCol="{span: 21}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item label="补充备注" :labelCol="{span: 3}" :wrapperCol="{span: 21}">
            <a-input />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item :wrapperCol="{span: 24}">
            <a-table :columns="columns" :dataSource="data" size="small">
              <span slot="modify">
                <a-button icon="edit" type="primary"></a-button>
              </span>
              <span slot="delete">
                <a-button icon="delete" type="danger"></a-button>
              </span>
            </a-table>
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
const columns = [
    {
        align: 'center',
        title: '编号',
        dataIndex: 'key',
        width: '5%',
        key: 'key'
    },
    {
        align: 'center',
        title: '项目验收',
        dataIndex: 'acceptanceitems',
        width: '8%',
        key: 'acceptanceitems'
    },
    {
        align: 'center',
        title: '验收日期',
        dataIndex: 'affiliatedcompany',
        key: 'affiliatedcompany'
    },
    {
        align: 'center',
        title: '合格',
        dataIndex: 'qualified',
        key: 'qualified'
    },
    {
        align: 'center',
        title: '验收人',
        dataIndex: 'acceptor',
        key: 'acceptor'
    },
    {
        align: 'center',
        title: '住户意见',
        dataIndex: 'householdopinions',
        key: 'householdopinions'
    },
    {
        align: 'center',
        title: '房管员意见',
        dataIndex: 'housekeeperopinion',
        key: 'housekeeperopinion'
    },
    {
        align: 'center',
        title: '备注',
        dataIndex: 'remarks',
        key: 'remarks'
    },
    {
        width: '5%',
        align: 'center',
        title: '修改',
        dataIndex: 'modify',
        key: 'modify',
        scopedSlots: { customRender: 'modify' }
    },
    {
        width: '5%',
        align: 'center',
        title: '删除',
        key: 'delete',
        dataIndex: 'delete',
        scopedSlots: { customRender: 'delete' }
    }
]
export default {
    props: {
        editObj: {
            type: Object,
            default: () => {
                return {
                    editKey: '',
                    editVisible: false,
                    editrecord: ''
                }
            }
        }
    },
    data() {
        return {
            labelCol: { lg: { span: 6 }, sm: { span: 6 } },
            wrapperCol: { lg: { span: 16 }, sm: { span: 16 } },
            columns,
            data: [
                {
                    key: '1',
                    acceptanceitems: '窗户',
                    affiliatedcompany: '2008-12-12',
                    qualified: '合格',
                    acceptor: '李XX',
                    householdopinions: '住户同意',
                    housekeeperopinion: '房管员同意',
                    remarks: '备注备注备注备注',
                    modify: '',
                    delete: ''
                }
            ]
        }
    }
}
</script>

<style lang="less" scoped>
.ant-form-item {
    margin-bottom: 0px;
}
</style>
