<template>
  <a-select v-model:value="name" showSearch allowClear :filterOption="filterNameOption" @change="onChange" placeholder="请选择车站" :style="'width:' + _width">
    <a-select-option v-for="item in stations" :key="item.name" :value="item.name" :label="item.name + item.namePinyin + item.namePy">
            {{item.name}} {{item.namePinyin}} ~ {{item.namePy}}
          </a-select-option>
  </a-select>
</template>

<script setup>
import { defineProps, defineEmits, onMounted, ref, watch } from 'vue'
import axios from 'axios'
import { notification } from 'ant-design-vue'

const props = defineProps({
  modelValue: {
    type: String,
    default: ''
  },
  width: {
    type: String,
    default: ''
  }
})

const emit = defineEmits(['update:modelValue', 'change'])
const name = ref([])
const stations = ref([])

const _width = ref(props.width)
if (Tool.isEmpty(props.width)) {
  _width.value = '100%'
}

// 利用watch,动态获取父组件的值，如果放在onMounted或其它方法里，则只有第一次有效
watch(
  () => props.modelValue,
  () => {
    console.log('prop.modelValue', props.modelValue)
    name.value = props.modelValue
  },
  { immediate: true }
)

const queryAllStation = () => {
  axios.get('/business/admin/station/query-all').then((resp) => {
    const data = resp.data
    if (data.success) {
      stations.value = data.content
    } else {
      notification.error({ description: data.message })
    }
  })
}

/**
 * 车次下拉框筛选
 */
const filterNameOption = (input, option) => {
  console.log(input, option)
  return option.label.toLowerCase().indexOf(input.toLowerCase() >= 0)
}

const onChange = (value) => {
  emit('update:modelValue', value)
  let station = stations.value.filter((item) => item.code === value)[0]
  if (Tool.isEmpty(station)) {
    station = {}
  }
  emit('change', station)
}

onMounted(() => {
  queryAllStation()
})
</script>
