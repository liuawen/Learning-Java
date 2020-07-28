<template>
  <div id="userLayout" :class="['user-layout-wrapper', device]">
    <div class="container">
      <div class="top">
        <div class="header">
          <!-- <a href="/"> -->
          <img src="~@/assets/logo.png" class="logo" alt="logo" />
          <!-- </a> -->
        </div>
        <div class="desc">Ant Design 是西湖区最具影响力的 Web 设计规范</div>
      </div>

      <route-view></route-view>

      <div class="footer">
        <div class="links">
          <a href="_self">帮助</a>
          <a href="_self">隐私</a>
          <a href="_self">条款</a>
        </div>
        <div class="copyright">Copyright &copy; 2020 马士兵技术组出品</div>
      </div>
    </div>
  </div>
</template>

<script>
import RouteView from './RouteView'
import { mixinDevice } from '@/utils/mixin'

export default {
    name: 'UserLayout',
    components: { RouteView },
    mixins: [mixinDevice],
    data() {
        return {}
    },
    mounted() {
        document.body.classList.add('userLayout')
    },
    beforeDestroy() {
        document.body.classList.remove('userLayout')
    }
}
</script>

<style lang="less" scoped>
#userLayout.user-layout-wrapper {
    height: 100%;
    color: #fff;
    &.mobile {
        .container {
            .main {
                max-width: 368px;
                width: 98%;
            }
        }
    }

    .container {
        width: 100%;
        min-height: 100%;
        background: #374aa7 url(~@/assets/background.svg) no-repeat 50%;
        background-size: 100%;
        padding: 110px 0 144px;
        position: relative;

        a {
            text-decoration: none;
        }

        .top {
            text-align: center;

            .header {
                height: 100px;
                line-height: 44px;

                .badge {
                    position: absolute;
                    display: inline-block;
                    line-height: 1;
                    vertical-align: middle;
                    margin-left: -12px;
                    margin-top: -10px;
                    opacity: 0.8;
                }

                .logo {
                    height: 100px;
                    vertical-align: top;
                    margin-right: 16px;
                    border-style: none;
                }

                .title {
                    font-size: 33px;
                    font-family: Avenir, 'Helvetica Neue', Arial, Helvetica, sans-serif;
                    font-weight: 600;
                    position: relative;
                    top: 2px;
                }
            }
            .desc {
                font-size: 14px;
                margin-top: 12px;
                margin-bottom: 40px;
            }
        }

        .main {
            min-width: 260px;
            width: 368px;
            margin: 0 auto;
        }

        .footer {
            position: absolute;
            width: 100%;
            bottom: 0;
            padding: 0 16px;
            margin: 48px 0 24px;
            text-align: center;

            .links {
                margin-bottom: 8px;
                font-size: 14px;
                a {
                    transition: all 0.3s;
                    &:not(:last-child) {
                        margin-right: 40px;
                    }
                }
            }
            .copyright {
                font-size: 14px;
            }
        }
    }
}
</style>
