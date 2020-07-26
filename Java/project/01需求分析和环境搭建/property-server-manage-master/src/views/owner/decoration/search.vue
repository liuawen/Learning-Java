<template>
  <div class="content">
    <a-form-model :label-col="labelCol" :wrapper-col="wrapperCol">
      <a-row>
        <a-col :span="8">
          <a-form-model-item label="选择楼盘">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="楼宇">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="单元/楼层">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="8">
          <a-form-model-item label="房间">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="状态">
            <a-select>
              <a-select-option value="shanghai">Zone one</a-select-option>
              <a-select-option value="beijing">Zone two</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="申请人">
            <a-input></a-input>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="8">
          <a-form-model-item label="申请日期(自)">
            <a-date-picker type="date" placeholder="Pick a date" style="width: 100%;" />
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="申请日期(至)">
            <a-date-picker type="date" placeholder="Pick a date" style="width: 100%;" />
          </a-form-model-item>
        </a-col>
        <a-col :span="8">
          <a-form-model-item label="装修内容">
            <a-input></a-input>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row class="table-content">
        <a-form-model-item :wrapperCol="{span: 23}">
          <a-row class="setting">
            <a-col class="left">
              <a-button type="primary" icon="search">查询</a-button>
              <a-button type="primary" icon="reload">重置</a-button>
              <a-button type="primary" icon="file-excel">导出</a-button>
            </a-col>
            <a-col class="right">
              <a-input></a-input>
              <a-button type="primary">定位房间</a-button>
            </a-col>
          </a-row>
        </a-form-model-item>
        <my-table :columns="columns" :data="data" :pagination="pagination"></my-table>
      </a-row>
    </a-form-model>
    <add :visibleObj="visibleObj"></add>
  </div>
</template>

<script>
import _ from 'lodash'
import mockjs2 from 'mockjs2'
import add from './enter-add/add'
import myTable from './components/myTable'
const columns = [
    {
        align: 'center',
        title: '编号',
        dataIndex: 'key',
        width: '5%',
        key: 'key',
        fixed: 'left'
    },
    {
        align: 'center',
        title: '房产',
        dataIndex: 'estate',
        width: '8%',
        key: 'estate'
    },
    {
        align: 'center',
        title: '申请人',
        width: '8%',
        dataIndex: 'applicant',
        key: 'applicant'
    },
    {
        align: 'center',
        title: '申请日期',
        width: '8%',
        dataIndex: 'dateofapplication',
        key: 'dateofapplication'
    },
    {
        align: 'center',
        title: '装修保证金',
        width: '8%',
        dataIndex: 'decorationdeposit',
        key: 'decorationdeposit'
    },
    {
        align: 'center',
        title: '违约金',
        width: '8%',
        dataIndex: 'liquidateddamages',
        key: 'liquidateddamages'
    },
    {
        align: 'center',
        title: '状态',
        width: '8%',
        dataIndex: 'status',
        key: 'status',
        scopedSlots: { customRender: 'status' }
    },
    {
        align: 'center',
        title: '装修内容',
        dataIndex: 'decorationcontent',
        key: 'decorationcontent'
    },
    {
        width: '10%',
        align: 'center',
        title: '创建人',
        dataIndex: 'approver',
        key: 'approver'
    },
    {
        align: 'center',
        title: '审批时间',
        width: '8%',
        key: 'processingtime',
        dataIndex: 'processingtime'
    },
    {
        width: '8%',
        align: 'center',
        title: '标识',
        key: 'mark',
        dataIndex: 'mark'
    }
]
const data = []
for (let i = 0; i < 100; i++) {
    data.push({
        key: i + 1,
        estate: '中东首座1号楼1单元103室',
        applicant: mockjs2.Random.cname(),
        dateofapplication: mockjs2.Random.date('yyyy-MM-dd'),
        decorationdeposit: _.random(100000, 999999),
        liquidateddamages: _.random(1000, 50000),
        // status: ['待审批'],
        status: mockjs2.mock({
            'array|1': ['已作废', '待审批', '已验收', '审批通过']
        }),
        // decorationcontent: '将客厅非承重墙打掉，增加采光',
        decorationcontent: _.sample(
            [
                '申请对客厅和卫生间精装修一下',
                '将客厅非承重墙打掉，增加采光',
                '申请对厨房翻修一下',
                '收房后整体装修',
                '打一个隔断和作一个飘窗',
                '申请重新翻修地板'
            ],
            1
        ),
        approver: '物业企业版用户',
        processingtime: mockjs2.Random.datetime(),
        mark: '物业人员录入'
    })
}
console.log(data)
export default {
    data() {
        return {
            labelCol: { lg: { span: 5 }, sm: { span: 5 } },
            wrapperCol: { lg: { span: 16 }, sm: { span: 16 } },
            columns,
            data,
            pagination: {
                defaultPageSize: 10,
                showTotal: total => `共 ${total} 条数据`,
                showQuickJumper: true,
                showSizeChanger: true,
                pageSizeOptions: ['5', '10', '15', '20'],
                onShowSizeChange: (current, pageSize) => (this.pageSize = pageSize)
            },
            visibleObj: {
                addvisible: false
            }
        }
    },
    methods: {
        showAddModal() {
            this.visibleObj.addvisible = true
        }
    },
    components: {
      add,
      myTable
    }
}
</script>

<style lang='less' scoped>
.content {
    background-color: #fff;
    padding: 20px;
    height: 100%;
    .table-content {
    .setting {
        margin: 10px 0;
    }

    button {
        margin-left: 10px;
    }
    .left {
        float: left;
    }
    .right {
        float: right;
        input {
            width: 100px;
        }
    }
}
}
.ant-form-item {
    margin-bottom: 0px;
}
</style>
