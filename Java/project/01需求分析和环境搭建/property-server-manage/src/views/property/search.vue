<template>
  <div class="search-house">
    <a-row>
      <a-col :span="4">
        <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol">
          <a-form-model-item label="请选择住宅:">
            <a-select v-model="form.region" placeholder="please select your zone">
              <a-select-option value="1">小区AAA</a-select-option>
              <a-select-option value="2">小区BBB</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-form-model>
        <ul class="mytree">
          <mytree class="item" :item="treeData"></mytree>
        </ul>
      </a-col>
      <a-col :span="20">
        <div>
          <h1 class="housinginformation-header">查看 第1栋 楼宇信息</h1>
          <!-- <housinginformation></housinginformation> -->
          <!-- <buildinginformation></buildinginformation> -->
          <unitinformation></unitinformation>
        </div>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import mytree from './mytree/mytree'
import housinginformation from './searchComp/housinginformation'
import buildinginformation from './searchComp/buildinginformation'
import unitinformation from './searchComp/unitinformation'
export default {
    data() {
        return {
            treeData: {
                name: 'XXX小区',
                children: [
                    {
                        name: '第一栋',
                        children: [
                            {
                                name: '一单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '二单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '三单元',
                                children: [{ name: '101' }, { name: '102' }]
                            }
                        ]
                    },
                    {
                        name: '第二栋',
                        children: [
                            {
                                name: '一单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '二单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '三单元',
                                children: [{ name: '101' }, { name: '102' }]
                            }
                        ]
                    },
                    {
                        name: '第三栋',
                        children: [
                            {
                                name: '一单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '二单元',
                                children: [{ name: '101' }, { name: '102' }]
                            },
                            {
                                name: '三单元',
                                children: [{ name: '101' }, { name: '102' }]
                            }
                        ]
                    }
                ]
            },
            labelCol: { span: 10 },
            wrapperCol: { span: 10 },
            form: {
                name: '',
                region: undefined,
                date1: undefined,
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            }
        }
    },
    components: {
        mytree,
        housinginformation,
        buildinginformation,
        unitinformation
    }
}
</script>

<style scoped>
.search-house {
    background-color: #fff;
    padding: 20px 0;
    min-height: 500px;
}
.mytree {
    margin-top: 15px;
}
</style>
