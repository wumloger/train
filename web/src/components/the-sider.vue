<template>
  <a-layout-sider width="200" style="background: #fff">
    <a-menu
      v-model:selectedKeys="selectedKeys"
      v-model:openKeys="openKeys"
      mode="inline"
      :style="{ height: '100%', borderRight: 0 }"
    >
        <a-menu-item key="/welcome">
            <router-link to="/welcome"><coffee-outlined/>欢迎</router-link>
        </a-menu-item>
        <a-menu-item key="/passenger">
            <router-link to="/passenger"><user-outlined/>乘车人管理</router-link>
        </a-menu-item>
          <a-menu-item key="/ticket">
            <router-link to="/ticket"><user-outlined/>余票查询</router-link>
        </a-menu-item>
        <a-menu-item key="/my-ticket">
        <router-link to="/my-ticket">
          <idcard-outlined/>
            我的车票
        </router-link>
      </a-menu-item>
      <a-menu-item key="/seat">
        <router-link to="/seat">
          <usergroup-add-outlined/>
            座位销售图
        </router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>

<script setup>
import { ref, watch } from 'vue';
import router from '@/router';


const openKeys = ref(['sub1']);

const selectedKeys = ref([]);

watch(() => router.currentRoute.value.path,
  (newValue) => {
    console.log("watch", newValue);
    selectedKeys.value = [];
    selectedKeys.value.push(newValue);
  },
  { immediate: true })
</script>

<style scoped></style>
