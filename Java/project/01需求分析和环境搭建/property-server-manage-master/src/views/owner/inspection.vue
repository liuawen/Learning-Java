<template>
  <div class="content">
    <a-row>
      <a-form-model :label-col="labelCol" :wrapper-col="wrapperCol">
        <a-row>
          <a-col :span="4">
            <a-form-model-item label="选择房产">
              <a-select>
                <a-select-option value="1">Zone one</a-select-option>
                <a-select-option value="2">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="4">
            <a-form-model-item label="楼宇">
              <a-select>
                <a-select-option value="1">Zone one</a-select-option>
                <a-select-option value="2">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="4">
            <a-form-model-item label="单元/楼层">
              <a-select>
                <a-select-option value="1">Zone one</a-select-option>
                <a-select-option value="2">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="4">
            <a-form-model-item label="房间">
              <a-select>
                <a-select-option value="1">Zone one</a-select-option>
                <a-select-option value="2">Zone two</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="4">
            <a-form-model-item label="关键词">
              <a-input />
            </a-form-model-item>
          </a-col>
          <a-col :span="8" class="setting">
            <a-button>查询</a-button>
            <a-button>清空</a-button>
            <a-button @click="add">增加</a-button>
            <a-button>导出</a-button>
          </a-col>
        </a-row>
      </a-form-model>
    </a-row>
    <a-row>
      <a-table :columns="columns" :dataSource="data">
        <span slot="estate" slot-scope="text, record">
          <a @click="edit(record)">{{ record.estate }}</a>
        </span>
      </a-table>
    </a-row>
    <edit :editObj="editObj"></edit>
    <add :addObj="addObj"></add>
  </div>
</template>

<script>
import edit from './inspection-dialog/edit'
import add from './inspection-dialog/add'
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
        title: '所属公司',
        dataIndex: 'affiliatedcompany',
        key: 'affiliatedcompany'
    },
    {
        align: 'center',
        title: '房产',
        dataIndex: 'estate',
        key: 'estate',
        scopedSlots: { customRender: 'estate' }
    },
    {
        align: 'center',
        title: '验收合格项',
        dataIndex: 'acceptance',
        key: 'acceptance'
    },
    {
        align: 'center',
        title: '验收合格不项',
        key: 'acceptancefailed',
        dataIndex: 'acceptancefailed'
    }
]
export default {
    data() {
        return {
            labelCol: { span: 8 },
            wrapperCol: { span: 15 },
            columns,
            addObj: {
                addVisible: false
            },
            editObj: {
                editKey: '',
                editVisible: false,
                editrecord: {
                    key: '',
                    affiliatedcompany: '',
                    estate: '',
                    acceptance: null,
                    acceptancefailed: null
                }
            },
            data: [
                {
                    key: '1',
                    affiliatedcompany: '海淀子公司',
                    estate: '中东首座1号楼1单元101室',
                    acceptance: 1,
                    acceptancefailed: 0
                },
                {
                    key: '2',
                    affiliatedcompany: '朝阳子公司',
                    estate: '中东首座1号楼2单元301室',
                    acceptance: 6,
                    acceptancefailed: 8
                }
            ]
        }
    },
    methods: {
        edit(record) {
            this.editObj.editrecord.estate = record.estate
            this.editObj.editVisible = true
        },
        add() {
            this.addObj.addVisible = true
        }
    },
    components: {
        add,
        edit
    }
}
</script>

<style lang="less" scoped>
.content {
    background-color: #fff;
    padding: 20px;
}
.ant-form-item {
    margin-bottom: 0;
}
.setting button {
    margin-top: 4px;
    margin-right: 10px;
}
</style>
