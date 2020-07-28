<template>
  <div>
    <!-- <a-form-model ref="ruleForm" :model="form2" :label-col="labelCol" :wrapper-col="wrapperCol"> -->
    <a-row class="header">
      楼层数量:
      <a-input style="width: 30px;padding: 0;text-align: center;"></a-input>开始房号:
      <!-- <a-form-model-item label="单元数量：" prop="region" class="units" :labelCol="labelCol" :wrapperCol="wrapperCol"> -->
      <a-select v-model="form2.region">
        <a-select-option value="1">1</a-select-option>
        <a-select-option value="2">2</a-select-option>
      </a-select>结束房号:
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
            'housecode',
            'unitcode',
            'unitname',
            'startfloor',
            'endfloor',
            'startroomnum',
            'endroomnum',
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
        // 楼宇编码	单元编码	单元名称	开始楼层	结束楼层	开始房号	结束房号
        align: 'center',
        title: '楼宇编码',
        dataIndex: 'housecode',
        width: '6%',
        scopedSlots: { customRender: 'housecode' }
    },
    {
        align: 'center',
        title: '单元编码',
        dataIndex: 'unitcode',
        width: '6%',
        scopedSlots: { customRender: 'unitcode' }
    },
    {
        align: 'center',
        title: '单元名称',
        dataIndex: 'unitname',
        width: '6%',
        scopedSlots: { customRender: 'unitname' }
    },
    {
        align: 'center',
        title: '开始楼层',
        dataIndex: 'startfloor',
        width: '7%',
        scopedSlots: { customRender: 'startfloor' }
    },
    {
        align: 'center',
        title: '结束楼层',
        dataIndex: 'endfloor',
        width: '7%',
        scopedSlots: { customRender: 'endfloor' }
    },
    {
        align: 'center',
        title: '开始房号',
        dataIndex: 'startroomnum',
        width: '7%',
        scopedSlots: { customRender: 'startroomnum' }
    },
    {
        align: 'center',
        title: '结束房号',
        dataIndex: 'endroomnum',
        width: '7%',
        scopedSlots: { customRender: 'endroomnum' }
    },
    {
        align: 'center',
        title: '备注',
        dataIndex: 'remark',
        width: '18%',
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
        housecode: `B-${i + 1}`,
        unitcode: `U-${i + 1}`,
        unitname: `${i + 1}单元`,
        startfloor: 1,
        endfloor: 8,
        startroomnum: 1,
        endroomnum: 2,
        remark: ''
    })
}
export default {
    name: 'Step3',
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
