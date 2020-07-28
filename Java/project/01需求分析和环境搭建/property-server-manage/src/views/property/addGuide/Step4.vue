<template>
  <div>
    <!-- <a-form-model ref="ruleForm" :model="form2" :label-col="labelCol" :wrapper-col="wrapperCol"> -->
    <a-row class="header">
      选择楼宇:
      <a-select v-model="form2.region">
        <a-select-option value="1">1</a-select-option>
        <a-select-option value="2">2</a-select-option>
      </a-select>选择单元:
      <a-select v-model="form2.region">
        <a-select-option value="1">1</a-select-option>
        <a-select-option value="2">2</a-select-option>
      </a-select>
      建筑面积:
      <a-input style="width: 40px;padding: 0;text-align: center;"></a-input>
      使用面积:
      <a-input style="width: 40px;padding: 0;text-align: center;"></a-input>
    </a-row>
    <a-row>
      <a-table :columns="columns" :dataSource="data" bordered align="center">
        <template
          v-for="col in [
            'floornumber',
            'housecode',
            'constructionarea',
            'usagearea',
            'remark'
          ]"
          :slot="col"
          slot-scope="text, record"
        >
          <div :key="col">
            <a-input
              v-if="record.editable"
              style="margin: -5px 0"
              :value="text"
              @change="e => handleChange(e.target.value, record.key, col)"
            />
            <template v-else>{{ text }}</template>
          </div>
        </template>
        <template slot="operation" slot-scope="text, record">
          <div class="editable-row-operations">
            <span v-if="record.editable">
              <a @click="() => save(record.key)">保存</a>&nbsp;
              <a-popconfirm title="确认取消吗?" @confirm="() => cancel(record.key)">
                <a>取消</a>
              </a-popconfirm>
            </span>
            <span v-else>
              <a :disabled="editingKey !== ''" @click="() => edit(record.key)">编辑</a>
            </span>
          </div>
        </template>
      </a-table>
      <a-row>
        <a-button type="primary" @click="nextStep()">下一步</a-button>
      </a-row>
    </a-row>
  </div>
</template>

<script>
const columns = [
    {
        align: 'center',
        title: '楼层数',
        dataIndex: 'floornumber',
        width: '6%',
        scopedSlots: { customRender: 'floornumber' }
    },
    {
        align: 'center',
        title: '房间编码',
        dataIndex: 'housecode',
        width: '6%',
        scopedSlots: { customRender: 'housecode' }
    },
    {
        align: 'center',
        title: '建筑面积',
        dataIndex: 'constructionarea',
        width: '6%',
        scopedSlots: { customRender: 'constructionarea' }
    },
    {
        align: 'center',
        title: '使用面积',
        dataIndex: 'usagearea',
        width: '7%',
        scopedSlots: { customRender: 'usagearea' }
    },
    {
        align: 'center',
        title: '备注',
        dataIndex: 'remark',
        width: '38%',
        scopedSlots: { customRender: 'remark' }
    },
    {
        align: 'center',
        title: '编辑',
        width: '7%',
        dataIndex: 'operation',
        scopedSlots: { customRender: 'operation' }
    }
]

const data = []
for (let i = 0; i < 10; i++) {
    data.push({
        key: i.toString(),
        floornumber: `B-${i + 1}`,
        housecode: `U-${i + 1}`,
        constructionarea: `${i + 1}单元`,
        usagearea: 1,
        remark: ''
    })
}
export default {
    name: 'Step4',
    data() {
        this.cacheData = data.map(item => ({ ...item }))
        return {
            labelCol: { span: 2 },
            wrapperCol: { span: 1 },
            form2: {
                name: '',
                region: undefined,
                date1: undefined,
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            data,
            columns,
            editingKey: ''
        }
    },
    methods: {
        nextStep() {
            this.$emit('nextStep')
            console.log(33)
        },
        prevStep() {
            // this.$emit('prevStep')
        },
        handleChange(value, key, column) {
            const newData = [...this.data]
            const target = newData.filter(item => key === item.key)[0]
            if (target) {
                target[column] = value
                this.data = newData
            }
        },
        edit(key) {
            const newData = [...this.data]
            const target = newData.filter(item => key === item.key)[0]
            this.editingKey = key
            if (target) {
                target.editable = true
                this.data = newData
            }
        },
        save(key) {
            console.log(key)
            const newData = [...this.data]
            const newCacheData = [...this.cacheData]
            const target = newData.filter(item => key === item.key)[0]
            const targetCache = newCacheData.filter(item => key === item.key)[0]
            if (target && targetCache) {
                delete target.editable
                this.data = newData
                Object.assign(targetCache, target)
                this.cacheData = newCacheData
                this.editingKey = ''
            }
        },
        cancel(key) {
            const newData = [...this.data]
            const target = newData.filter(item => key === item.key)[0]
            this.editingKey = ''
            if (target) {
                Object.assign(target, this.cacheData.filter(item => key === item.key)[0])
                delete target.editable
                this.data = newData
            }
        }
    },
    beforeDestroy() {
        //  clearTimeout(this.timer)
    }
}
</script>

<style lang="less" scoped>
.stepFormText {
    margin-bottom: 24px;

    .ant-form-item-label,
    .ant-form-item-control {
        line-height: 22px;
    }
}
</style>
