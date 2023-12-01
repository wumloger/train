import { createRouter, createWebHistory } from "vue-router";
import store from "@/store";
import { notification } from "ant-design-vue";
const routes = [
  {
    path: "/login",
    component: () => import("../views/login.vue"),
  },
  {
    path: "/",
    component: () => import("../views/main.vue"),
    meta: {
      loginRequired: true,
    },
    children: [
      {
        path: "welcome",
        component: () => import("../views/main/welcome.vue"),
      },
      {
        path: "passenger",
        component: () => import("../views/main/passenger.vue"),
      },
      {
        path: "ticket",
        component: () => import("../views/main/ticket.vue"),
      },
      {
        path: "order",
        component: () => import("../views/main/order.vue"),
      },
      {
        path: "my-ticket",
        component: () => import("../views/main/my-ticket.vue"),
      },
      {
        path: "seat",
        component: () => import("../views/main/seat.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (
    to.matched.some(function (item) {
      console.log(item, "是否需要登录校验：", item.meta.loginRequired || false);
      return item.meta.loginRequired;
    })
  ) {
    const _member = store.state.member;
    console.log("页面登录校验开始：", _member);
    if (!_member.token) {
      console.log("用户未登录或登录超时!");
      notification.error({ description: "用户未登录或登录超时!" });
      next("/login");
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
