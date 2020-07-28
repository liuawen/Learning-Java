<template>
  <a-card :bordered="false">
    <a-steps class="steps" :current="currentTab">
      <a-step title="选择住宅" />
      <a-step title="维护楼宇信息" />
      <a-step title="维护单元信息" />
      <a-step title="维护房间信息" />
      <a-step title="完成" />
    </a-steps>
    <div class="content">
      <step1 v-if="currentTab === 0" @nextStep="nextStep" />
      <step2 v-if="currentTab === 1" @nextStep="nextStep" @prevStep="prevStep" />
      <step3 v-if="currentTab === 2" @nextStep="nextStep" @prevStep="prevStep" />
      <step4 v-if="currentTab === 3" @nextStep="nextStep" @prevStep="prevStep" />
      <step5 v-if="currentTab === 4" @prevStep="prevStep" @finish="finish" />
    </div>
  </a-card>
</template>

<script>
import Step1 from './Step1'
import Step2 from './Step2'
import Step3 from './Step3'
import Step4 from './Step4'
import Step5 from './Step5'
export default {
    name: 'StepForm',
    components: {
        Step1,
        Step2,
        Step3,
        Step4,
        Step5
    },
    data() {
        return {
            currentTab: 0
        }
    },
    methods: {
        // handler
        nextStep() {
            if (this.currentTab < 4) {
                this.currentTab += 1
            }
        },
        prevStep() {
            if (this.currentTab > 0) {
                this.currentTab -= 1
            }
        },
        finish() {
            this.currentTab = 0
        }
    }
}
</script>

<style lang="less" scoped>
.steps {
    max-width: 1100px;
    margin: 16px auto;
}
</style>
