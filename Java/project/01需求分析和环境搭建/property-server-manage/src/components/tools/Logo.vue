<template>
  <div class="logo">
    <img src="~@/assets/logo.png" alt />
  </div>
</template>

<script>
import LogoSvg from '@/assets/logo.svg?inline'

export default {
    name: 'Logo',
    components: {
        LogoSvg
    },
    props: {
        title: {
            type: String,
            default: 'Ant Pro',
            required: false
        },
        showTitle: {
            type: Boolean,
            default: true,
            required: false
        }
    }
}
</script>
