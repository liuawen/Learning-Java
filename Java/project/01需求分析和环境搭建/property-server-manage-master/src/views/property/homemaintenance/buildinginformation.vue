<template>
  <div>
    <a-table :rowSelection="rowSelection" :columns="columns" :dataSource="data">
      <a slot="name" slot-scope="text">{{ text }}</a>
      <template slot="operation" slot-scope="text, record">
        <a href="javascript:;" @click="seemqintain(text, record)">查看单元</a>
      </template>
    </a-table>
  </div>
</template>

<script>
const columns = [
    {
        title: '楼宇编码',
        dataIndex: 'buildingcode',
        scopedSlots: { customRender: 'buildingcode' }
    },
    {
        title: '楼宇名称',
        dataIndex: 'buildingname'
    },
    {
        title: '建筑面积',
        dataIndex: 'constructionarea'
    },
    {
        title: '使用面积',
        dataIndex: 'usagearea'
    },
    {
        title: '单元数量',
        dataIndex: 'unitcount'
    },
    {
        title: '预售许可证号',
        dataIndex: 'licensenumber'
    },
    {
        title: '竣工日期',
        dataIndex: 'completiondate'
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
        buildingcode: 'B-1',
        buildingname: '楼宇名称1',
        constructionarea: '建筑面积',
        usagearea: '使用面积',
        unitcount: '单元数量',
        licensenumber: '预售许可证号',
        completiondate: '竣工日期'
    },
    {
        key: '2',
        buildingcode: 'B-2',
        buildingname: '楼宇名称2',
        constructionarea: '建筑面积',
        usagearea: '使用面积',
        unitcount: '单元数量',
        licensenumber: '预售许可证号',
        completiondate: '竣工日期'
    },
    {
        key: '3',
        buildingcode: 'B-3',
        buildingname: '楼宇名称3',
        constructionarea: '建筑面积',
        usagearea: '使用面积',
        unitcount: '单元数量',
        licensenumber: '预售许可证号',
        completiondate: '竣工日期'
    }
]

export default {
    namd: 'buildinginformation',
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
        callback(key) {
            console.log(key)
        },
        seemqintain(text, record) {
            this.activeKey.defaultKey = '3'
            this.$emit('set-buildinginformation', record.buildingname)
        }
    }
}
</script>
