<template>
    <a-select
        v-model:value="trainCode"
        show-search
        allowClear
        :filterOption="filterTrainCodeOption"
        @change="onChange"
        placeholder="请选择车次"
        :style="'width: ' + _width">
      <a-select-option
        v-for="item in trains"
        :key="item.code"
        :value="item.code"
        :label="item.code + item.start + item.end">
        {{item.code}} | {{item.start}} ~ {{item.end}}

      </a-select-option>
    </a-select>
</template>

<script setup>
import { defineProps, defineEmits, onMounted, ref, watch } from 'vue';
import axios from 'axios';
import { notification } from 'ant-design-vue';
import { ToolFilled } from '@ant-design/icons-vue';
const props = defineProps({
    modelValue: {
        type: String,
        default: ''
    },
    width: {
        type: String,
        default: ''
    }
});
const emit = defineEmits(['update:modelValue', 'change']);
const trainCode = ref();
const trains = ref([]);
const _width = ref(props.width);
if (Tool.isEmpty(props.width)) {
    _width.value = '100%';
}

watch(() => props.modelValue,
    () => {
        console.log('props.modelValue', props.modelValue);
        trainCode.value = props.modelValue;
    }, { immediate: true });

const queryTrainCode = () => {
    axios.get("/business/admin/train/query-all").then((res) => {
        let data = res.data;
        if (data.success) {
            console.log(data.content);
            trains.value = data.content;
        } else {
            notification.error({ description: data.message });
        }
    })
}
const filterTrainCodeOption = (input, option) => {
    console.log(input, option);
    return option.label.toLowerCase().indexOf(input.toLowerCase()) >= 0;
}

const onChange = (value) => {
    emit('update:modelValue', value);
    let train = trains.value.filter((item) => item.code === value)[0];
    if (Tool.isEmpty(train)) {
        train = {};
    }
    emit('change', train);
}

onMounted(() => {
    // queryTrainCode();
    queryAllTrain();
});

const queryAllTrain = () => {
    let list = SessionStorage.get(SESSION_ALL_TRAIN);
    if (Tool.isNotEmpty(list)) {
        console.log("queryAllTrain 读取缓存");
        trains.value = list;
    } else {
        axios.get("/business/admin/train/query-all").then((response) => {
            let data = response.data;
            if (data.success) {
                trains.value = data.content;
                console.log("queryAllTrain 保存缓存");
                SessionStorage.set(SESSION_ALL_TRAIN, trains.value);
            } else {
                notification.error({ description: data.message });
            }
        });
    }
};
</script>

<style scoped>

</style>