<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
  <a-button type="primary">测试</a-button>
  <plus-circle-outlined></plus-circle-outlined>

   <a-dropdown :trigger="['click']">
    <a class="ant-dropdown-link" @click.prevent>
      BookType
      <DownOutlined />
    </a>
    <template #overlay>
      <a-menu>
        <a-menu-item key="0">
          <a href="http://www.alipay.com/">BookTypeEnum.WENXUELEI</a>
        </a-menu-item>
        <a-menu-item key="1">
          <a href="http://www.taobao.com/">BookTypeEnum.YINGYUANLEI</a>
        </a-menu-item>
        <a-menu-divider />
        <a-menu-item key="3">BookTypeEnum.ZHENGSHI</a-menu-item>
      </a-menu>
    </template>
  </a-dropdown>
</template>

<script setup>
import * as BookTypeEnum from "@/constant/BookTypeEnum";
const BookTypeEnum = BookTypeEnum;
</script>