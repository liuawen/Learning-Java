<template>
  <a-row>
    <a-table
      :columns="columns"
      :dataSource="data"
      size="small"
      @change="paginationChange"
      :pagination="pagination"
    >
      <span slot="status" slot-scope="status">
        <a-tag
          v-for="tag in status"
          :color="tag==='已作废' ? 'gray': tag === '待审批' ? 'red' : tag === '已验收' ? 'geekblue' : tag === '审批通过' ? 'green' : '' "
          :key="tag"
        >{{ tag }}</a-tag>
      </span>
    </a-table>
    <div class="count">
      <span>合计： {{ marginCount }}</span>
      <span>{{ liquidatedDamagesCount }}</span>
    </div>
  </a-row>
</template>

<script>
export default {
    props: {
        columns: {
            type: Array,
            default: () => {
                return []
            }
        },
        pagination: {
            type: Object,
            default: () => {
                return {}
            }
        },
        data: {
            type: Array,
            default: () => {
                return []
            }
        }
    },
    computed: {
        marginCount() {
            // 装修保证金
            let sum = 0
            this.data.forEach(item => {
                sum += item.decorationdeposit
            })
            return sum
        },
        liquidatedDamagesCount() {
            // 违约金
            let sum = 0
            this.data.forEach(item => {
                sum += item.liquidateddamages
            })
            return sum
        }
    },
    methods: {
        paginationChange(pagination, filters, sorter) {
            console.log('params', pagination, filters, sorter)
        }
    }
}
</script>

<style scoped lang="less">
.table-content {
    .ant-tag {
        margin: 0;
    }
}
.count {
    position: absolute;
    bottom: 1vw;
    left: 27%;
    color: red;
    font-weight: 700;
    overflow: hidden;
    width: 350px;
    span:first-child {
        margin-right: 5%;
        float: left;
        width: 150px;
    }
    span:last-child {
        float: left;
        display: block;width: 100px;
    }
}
</style>
