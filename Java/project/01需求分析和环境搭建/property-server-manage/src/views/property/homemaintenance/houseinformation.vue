<template>
  <div>
    <a-table :rowSelection="rowSelection" :columns="columns" :dataSource="data">
      <a slot="name" slot-scope="text">{{ text }}</a>
      <template slot="operation" slot-scope="text, record">
        <a href="javascript:;" @click="seemqintain(text, record)">查看楼宇</a>
      </template>
    </a-table>
  </div>
</template>

<script>
const columns = [
    {
        title: '所属公司',
        dataIndex: 'affiliates',
        scopedSlots: { customRender: 'affiliates' }
    },
    {
        title: '住宅编码',
        dataIndex: 'homecode'
    },
    {
        title: '住宅名称',
        dataIndex: 'homename'
    },
    {
        title: '地址',
        dataIndex: 'address'
    },
    {
        align: 'center',
        title: '编辑',
        dataIndex: 'operation',
        scopedSlots: { customRender: 'operation' }
    }
]
const data = [
    {
        key: '1',
        affiliates: 'John Brown',
        homecode: 32,
        homename: 'New York No. 1 Lake Park',
        address: '123123'
    },
    {
        key: '2',
        affiliates: 'John Brown',
        homecode: 32,
        homename: 'New York No. 2 Lake Park',
        address: '123123'
    },
    {
        key: '3',
        affiliates: 'John Brown',
        homecode: 32,
        homename: 'New York No. 3 Lake Park',
        address: '123123'
    },
    {
        key: '4',
        affiliates: 'John Brown',
        homecode: 32,
        homename: 'New York No. 4 Lake Park',
        address: '123123'
    }
]

export default {
    name: 'Houseinformation',
    props: {
        activeKey: {
            type: Object,
            default: () => {
                return {
                    defaultKey: '1'
                }
            }
        }
    },
    data() {
        return {
            data,
            columns
        }
    },
    computed: {
        rowSelection() {
            // eslint-disable-next-line no-unused-vars
            const { selectedRowKeys } = this
            return {
                onChange: (selectedRowKeys, selectedRows) => {
                    console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows)
                }
            }
        }
    },
    methods: {
        seemqintain(text, record) {
            this.activeKey.defaultKey = '2'
            console.log(text, record)
            this.$emit('set-houseinformation', record.homename)
        }
    }
}
</script>
