import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/loginPage'
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    component: () => import('../views/LoginPage.vue')
  },
  {
    path: '/indexPage',
    name: 'IndexPage',
    component: () => import('../views/IndexPage.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

// 路由守卫
router.beforeEach(((to, from, next) => {
  if(to.path === "/loginPage") {
    next();
  } else {
    /*判断交互过程中 token登录状态的记录*/
    let token = localStorage.getItem('token');
    if (token === null || token === ''||token===undefined) {
      next('/loginPage');
    } else {
      next();
    }
  }
}))

export default router
