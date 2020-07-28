<template>
  <div>
    <a-form style="margin: 40px auto 0;">
      <result title="操作成功" :is-success="true" description="请到查看中查询" style="max-width: 560px;">
        <!-- <div slot="action">
          <a-button type="primary" @click="finish">再转一笔</a-button>
          <a-button style="margin-left: 8px" @click="toOrderList">查看账单</a-button>
        </div>-->
      </result>
    </a-form>
  </div>
</template>

<script>
import { Result } from '@/components'

export default {
    name: 'Step5',
    components: {
        Result
    },
    data() {
        return {}
    },
    methods: {
        finish() {
            this.$emit('finish')
        },
        toOrderList() {
            // this.$router.push('/list/table-list')
        }
    }
}
</script>
<style lang="less" scoped>
.information {
    line-height: 22px;

    .ant-row:not(:last-child) {
        margin-bottom: 24px;
    }
}
.money {
    font-family: 'Helvetica Neue', sans-serif;
    font-weight: 500;
    font-size: 20px;
    line-height: 14px;
}
</style>
