<template>
  <div class="maintain">
    <a-tabs @change="callback" type="card" v-model="activeKey.defaultKey" class="maintainTabs">
      <a-tab-pane tab="住宅信息" key="1">
        <houseinformation :activeKey="activeKey" @set-houseinformation="setHouseinformation"></houseinformation>
      </a-tab-pane>
      <a-tab-pane tab="楼宇信息" key="2">
        <buildinginformation
          :activeKey="activeKey"
          @set-buildinginformation="setBuildinginformation"
        ></buildinginformation>
      </a-tab-pane>
      <a-tab-pane tab="单元信息" key="3">
        <unitinformation :activeKey="activeKey" @set-unitinformation="setUnitinformation"></unitinformation>
      </a-tab-pane>
      <a-tab-pane tab="房间信息" key="4">
        <roominformation :activeKey="activeKey" @set-roominformation="setRoominformation"></roominformation>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>
<script>
import houseinformation from './homemaintenance/houseinformation'
import buildinginformation from './homemaintenance/buildinginformation'
import unitinformation from './homemaintenance/unitinformation'
import roominformation from './homemaintenance/roominformation'
export default {
    data() {
        return {
            houseinformationText: '',
            buildinginformationText: '',
            unitinformationText: '',
            roominformationText: '',
            activeKey: {
                defaultKey: '1'
            }
        }
    },
    created() {
        console.log(this.$route)
    },
    methods: {
        callback(key) {
            this.$route.query.defaultKey = key
        },
        setHouseinformation(text) {
            this.houseinformationText = text
        },
        setBuildinginformation(text) {
            this.buildinginformationText = text
        },
        setUnitinformation(text) {
            this.unitinformationText = text
        },
        setRoominformation(text) {
            this.roominformationText = text
        }
    },
    components: {
        houseinformation,
        buildinginformation,
        unitinformation,
        roominformation
    }
}
</script>

<style lang="less" scoped>
.maintain {
    padding: 30px;
    background-color: #fff;
    .maintainTabs {
        .ant-tabs-bar {
            margin-bottom: 0 !important;
        }
    }
}
</style>
