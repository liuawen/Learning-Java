<template>
  <div>
    <!-- <a-form-model ref="ruleForm" :model="form2" :label-col="labelCol" :wrapper-col="wrapperCol"> -->
    <a-row class="header">
      楼宇数量:
      <span style="color: blue;font-weight: 700;">12</span>
      单元数量:
      <!-- <a-form-model-item label="单元数量：" prop="region" class="units" :labelCol="labelCol" :wrapperCol="wrapperCol"> -->
      <a-select v-model="form2.region">
        <a-select-option value="1">1</a-select-option>
        <a-select-option value="2">2</a-select-option>
      </a-select>
      <!-- </a-form-model-item> -->
    </a-row>
    <a-row>
      <a-table :columns="columns" :dataSource="data" bordered align="center">
        <template
          v-for="col in [
            'housecount',
            'housename',
            'unitcount',
            'cappeddate',
            'completeddate',
            'presalelicense',
            'buildingpermit',
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
              <a @click="() => save(record.key)">保存</a>
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
import moment from 'moment'
const columns = [
    {
        align: 'center',
        title: '楼宇编码',
        dataIndex: 'housecount',
        width: '6%',
        scopedSlots: { customRender: 'housecount' }
    },
    {
        align: 'center',
        title: '楼宇名称',
        dataIndex: 'housename',
        width: '15%',
        scopedSlots: { customRender: 'housename' }
    },
    {
        align: 'center',
        title: '单元数量',
        dataIndex: 'unitcount',
        width: '6%',
        scopedSlots: { customRender: 'unitcount' }
    },
    {
        align: 'center',
        title: '封顶日期',
        dataIndex: 'cappeddate',
        width: '7%',
        scopedSlots: { customRender: 'cappeddate' }
    },
    {
        align: 'center',
        title: '竣工日期',
        dataIndex: 'completeddate',
        width: '7%',
        scopedSlots: { customRender: 'completeddate' }
    },
    {
        align: 'center',
        title: '预售许可证',
        dataIndex: 'presalelicense',
        width: '7%',
        scopedSlots: { customRender: 'presalelicense' }
    },
    {
        align: 'center',
        title: '建筑许可证',
        dataIndex: 'buildingpermit',
        width: '7%',
        scopedSlots: { customRender: 'buildingpermit' }
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
        width: '6%',
        scopedSlots: { customRender: 'usagearea' }
    },
    {
        align: 'center',
        title: '备注',
        dataIndex: 'remark',
        width: '10%',
        scopedSlots: { customRender: 'remark' }
    },
    {
        align: 'center',
        title: '编辑',
        width: '4%',
        dataIndex: 'operation',
        scopedSlots: { customRender: 'operation' }
    }
]

const data = []
for (let i = 0; i < 10; i++) {
    data.push({
        key: i.toString(),
        housecount: `B-${i + 1}`,
        housename: `第${i + 1}栋`,
        unitcount: `12`,
        cappeddate: moment().format('YYYY-MM-DD'),
        completeddate: moment().format('YYYY-MM-DD'),
        presalelicense: '',
        buildingpermit: '',
        constructionarea: '',
        usagearea: '',
        remark: ''
    })
}
export default {
    name: 'Step2',
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
            // labelCol: { lg: { span: 5 }, sm: { span: 5 } },
            // wrapperCol: { lg: { span: 19 }, sm: { span: 19 } },
            // form: this.$form.createForm(this),
            // loading: false,
            // timer: 0
        }
    },
    methods: {
        nextStep() {
            this.$emit('nextStep')
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
                this.editingKey = ''
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
