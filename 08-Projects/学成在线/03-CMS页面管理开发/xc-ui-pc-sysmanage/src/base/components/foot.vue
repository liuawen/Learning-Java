<template>
  <div id="foot">
    <!-- 3.0 利用mui中的tabbar组件实现系统的底部 -->
    <nav class="mui-bar mui-bar-tab">
      <router-link class="mui-tab-item " to="/">
        <span class="mui-icon mui-icon-home"></span>
        <span class="mui-tab-label">首页</span>
      </router-link>
      <router-link class="mui-tab-item" to="/userinfo">
        <span class="mui-icon mui-icon-email">
				</span>
        <span class="mui-tab-label">会员</span>
      </router-link>
      <router-link class="mui-tab-item" to="/shopcar">
        <span class="mui-icon mui-icon-contact">
					<span class="mui-badge">0</span>
        </span>
        <span class="mui-tab-label">购物车</span>
      </router-link>
      <router-link class="mui-tab-item" to="/search">
        <span class="mui-icon mui-icon-gear"></span>
        <span class="mui-tab-label">搜索</span>
      </router-link>
    </nav>
  </div>
</template>
<script>
export default {
}
</script>
<style scoped>
</style>
