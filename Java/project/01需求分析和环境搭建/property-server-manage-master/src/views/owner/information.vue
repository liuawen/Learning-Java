<template>
  <div>
    <a-row>
      <a-form-model :model="form" layout="inline">
        <a-form-model-item label="房间编码">
          <a-input v-model="form.housecode" />
        </a-form-model-item>
        <a-form-model-item label="快速检索">
          <a-select v-model="form.region" placeholder="业主编码" class="select">
            <a-select-option value="1">业主编码</a-select-option>
            <a-select-option value="2">业主姓名</a-select-option>
            <a-select-option value="3">证件号码</a-select-option>
            <a-select-option value="4">工作单位</a-select-option>
            <a-select-option value="5">手机号码</a-select-option>
            <a-select-option value="6">联系地址</a-select-option>
            <a-select-option value="7">银行代扣</a-select-option>
            <a-select-option value="8">银行账号</a-select-option>
            <a-select-option value="9">紧急联系人</a-select-option>
            <a-select-option value="0">备注</a-select-option>
          </a-select>
        </a-form-model-item>
        <a-form-model-item>
          <a-input v-model="form.retrievingcontent"/>
          <a-icon type="search" class="retrievingcontent-icon" />
        </a-form-model-item>
        <a-form-model-item label="快速检索">
          <a-select v-model="form.ownerType" placeholder="全部业主" class="select">
            <a-select-option value="1">全部业主</a-select-option>
            <a-select-option value="2">正式业主</a-select-option>
            <a-select-option value="3">临时业主</a-select-option>
          </a-select>
        </a-form-model-item>
      </a-form-model>
    </a-row>
    <a-row class="setting">
      <a-button type="primary" icon="plus-circle" @click="showAddModal">新增</a-button>&nbsp;
      <a-button type="primary" icon="caret-right" @click="start">启用</a-button>&nbsp;
      <a-button type="primary" icon="pause" @click="disable">禁用</a-button>&nbsp;
      <a-button type="primary" icon="file" @click="showImportExcelModal">导入</a-button>
    </a-row>
    <a-row>
      <a-table
        :columns="columns"
        :dataSource="data"
        @change="paginationChange"
        position="bottom"
        :pagination="pagination"
        :rowSelection="rowSelection"
      >
        <a slot="operating">
          <!-- slot-scope="text, record" -->
          <a>家庭成员(2)</a>
          <a-divider type="vertical" />
          <a>房产登记(2)</a>
        </a>
      </a-table>
    </a-row>
    <add :visibleObj="visibleObj"></add>
    <importexcel :visibleObj="visibleObj"></importexcel>
  </div>
</template>

<script>
import add from './information-dialog/add'
import importexcel from './information-dialog/importexcel'
import _ from 'lodash'
import mockjs2 from 'mockjs2'
const columns = [
    {
        align: 'center',
        title: '编号',
        dataIndex: 'key',
        defaultSortOrder: 'descend',
        sorter: (a, b) => a.key - b.key
    },
    {
        align: 'center',
        title: '所属公司',
        dataIndex: 'affiliatedcompany'
    },
    {
        align: 'center',
        title: '业主编码',
        dataIndex: 'ownercode',
        defaultSortOrder: 'descend',
        sorter: (a, b) => a.ownercode - b.ownercode
    },
    {
        align: 'center',
        title: '姓名',
        dataIndex: 'name'
    },
    {
        align: 'center',
        title: '性别',
        dataIndex: 'sex'
    },
    {
        align: 'center',
        title: '出生日期',
        dataIndex: 'dateofbirth'
    },
    {
        align: 'center',
        title: '证件号码',
        dataIndex: 'idnumber'
    },
    {
        align: 'center',
        title: '手机号码',
        dataIndex: 'phonenumber'
    },
    {
        align: 'center',
        title: '银行代扣',
        dataIndex: 'bankwithholding'
    },
    {
        align: 'center',
        title: '状态',
        dataIndex: 'status'
    },
    {
        align: 'center',
        title: '操作',
        dataIndex: 'operating',
        scopedSlots: { customRender: 'operating' }
    }
]

const data = []
for (let i = 0; i < 200; i++) {
    data.push({
        key: i,
        affiliatedcompany: '海淀子公司',
        ownercode: _.random(100000, 999999),
        name: mockjs2.Random.cname(),
        sex: '男',
        dateofbirth: mockjs2.Random.date('yyyy-MM-dd'),
        idnumber: mockjs2.Random.id(),
        phonenumber: '13811223344',
        bankwithholding: mockjs2.Random.boolean() === true ? '是' : '否',
        status: mockjs2.Random.boolean() === true ? '正常' : '停用',
        operating: 'New York No. 1 Lake Park'
    })
}

export default {
    data() {
        return {
            visibleObj: {
                addvisible: false,
                importexcelvisible: false
            },
            form: {
                housecode: '',
                region: undefined,
                retrievingcontent: '',
                ownerType: undefined
            },
            pagination: {
                defaultPageSize: 10,
                showTotal: total => `共 ${total} 条数据`,
                showQuickJumper: true,
                showSizeChanger: true,
                pageSizeOptions: ['5', '10', '15', '20'],
                onShowSizeChange: (current, pageSize) => (this.pageSize = pageSize)
            },
            data,
            columns,
            selectedRows: []
        }
    },
    computed: {
        rowSelection() {
            return {
                onChange: (selectedRowKeys, selectedRows) => {
                    console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows)
                },
                onSelect: (record, selected, selectedRows) => {
                    console.log(record, selected, selectedRows)
                    // eslint-disable-next-line vue/no-side-effects-in-computed-properties
                    this.selectedRows = selectedRows
                },
                onSelectAll: (selected, selectedRows, changeRows) => {
                    // eslint-disable-next-line vue/no-side-effects-in-computed-properties
                    this.selectedRows = selectedRows
                    console.log(selected, selectedRows, changeRows)
                }
            }
        }
    },
    methods: {
        paginationChange(pagination, filters, sorter) {
            console.log('params', pagination, filters, sorter)
        },
        showAddModal() {
            this.visibleObj.addvisible = true
        },
        showImportExcelModal() {
            this.visibleObj.importexcelvisible = true
        },
        start() {
            console.log(this.selectedRows)
            this.$confirm({
                title: '确认对话框',
                content: `确认要处理选中的${this.selectedRows.length}项记录吗？`,
                onOk() {
                    return new Promise((resolve, reject) => {
                        setTimeout(Math.random() > 0.5 ? resolve : reject, 1000)
                    }).catch(() => console.log('Oops errors!'))
                },
                onCancel() {}
            })
        },
        disable() {
            this.$confirm({
                title: '确认对话框',
                content: `确认要处理选中的${this.selectedRows.length}项记录吗？`,
                onOk() {
                    return new Promise((resolve, reject) => {
                        setTimeout(Math.random() > 0.5 ? resolve : reject, 1000)
                    }).catch(() => console.log('Oops errors!'))
                },
                onCancel() {}
            })
        }
    },
    components: {
        add,
        importexcel
    }
}
</script>

<style lang="less" scoped>
.select {
    width: 110px;
}
.retrievingcontent-icon {
    position: absolute;
    top: 50%;
    right: 10px;
    transform: translateY(-50%);
}
/deep/ input,
/deep/ .ant-select-selection {
    border-radius: 4px;
}
.setting {
    margin: 10px 0;
}
</style>
