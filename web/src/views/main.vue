<template>
    <a-layout id="components-layout-demo-top-side-2">
      <TheHeaderView></TheHeaderView>
      <a-layout>
        <TheSiderView></TheSiderView>
        <a-layout style="padding: 0 24px 24px; text-align: left;">
            <a-breadcrumb style="margin:16px 0">
              <a-breadcrumb-item>Home</a-breadcrumb-item>
              <a-breadcrumb-item>List</a-breadcrumb-item>
              <a-breadcrumb-item>App</a-breadcrumb-item>
            </a-breadcrumb>
            <a-layout-content
                :style="{
                    background:'#fff',
                    padding:'24px',
                    margin:0,
                    minHeight:'280px'
                }">
                <router-view></router-view>   
            </a-layout-content>
        </a-layout>
      </a-layout>
    </a-layout>
</template>

<script setup>
// import {ref} from 'vue';
import TheHeaderView from '@/components/the-header.vue';
import TheSiderView from '@/components/the-sider.vue';
// import axios from 'axios';

// const count = ref(0);
// axios.get('/member/member/count').then(res => {
//     count.value = res.data;
// });
</script>

<style scoped>
#components-layout-demo-top-side-2 .logo {
    float: left;
    width: 120px;
    height: 31px;
    margin: 16px 24px 16px 0;
    background: rgba(255, 255, 255,0.3);
}
.ant-row-rtl #components-layout-demo-top-side-2 .logo{
    float: right;
    margin: 16px 0 16px 24px;
}

.site-layout-background {
    background: #fff;
}

</style>