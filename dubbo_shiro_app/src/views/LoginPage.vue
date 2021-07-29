
<template>
<form>
   <label>用户名:<input type="text" v-model="login.userName" ></label><br>
  <label>密码:<input type="password" v-model="login.passWord" ></label><br>
  <input type="button" @click="loginUser();" value="点击登录！">
</form>
  <hr>

</template>

<script>
import axios from "../axios/config.js";
import qs from 'qs/dist/qs.js';
export default {
  name: "LoginPage",
  data(){
    return{
     login:{
       userName:'',
       passWord:''
     },
      userMsg:'',
    }
  },mounted(){

  },methods:{
    loginUser(){
      const  _this=this;
      if(_this.login.userName==''||_this.login.passWord==''){
         alert('用户名或密码暂未填写！！');
       }else {
        axios.post('login', qs.stringify({"username": _this.login.userName, "password": _this.login.passWord}))
            .then(res => {
              let data = res.data;
              if(data.code==200){
          _this.$router.push("/indexPage");
        }else {
          alert(data.message);
        }
            });
      }
    },
  },computed:{

  }
}
</script>

<style scoped>

</style>