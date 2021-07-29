import axios from 'axios'
// axios 配置
axios.defaults.timeout = 8000;
axios.defaults.baseURL = 'http://localhost:8086/' // 2、配置基础API

// http request 请求拦截器
axios.interceptors.request.use(config => { // 3、添加拦截器
    console.log('异步交互之前触发--拦截11111');
if(localStorage.getItem('token')){
    console.log(localStorage.getItem('token')+"????");
    config.headers.token=localStorage.getItem('token');
}
    return config;
})

// http response 响应拦截器
axios.interceptors.response.use(res => { // 4、添加拦截器
    console.log('异步交互之后触发--拦截22222');
    console.log(res.headers.authorization);
if(res.headers.authorization){
    console.log("页面存储token成功！"+res.headers.authorization);
 window.localStorage.setItem('token',res.headers.authorization);
}
    return res;
}, e => {

})
export default axios;