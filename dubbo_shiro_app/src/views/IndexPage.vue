<template>
 您已登录！！！
  <button @click="getUser();">查看所有用户信息</button><br>
  <textarea class="textBody1">{{main}}</textarea>
</template>

<script>
import axios from "../axios/config.js";
import qs from 'qs/dist/qs.js';
export default {
  name: "IndexPage",
  data(){
    return{
      main:'??',
    }
  },
  methods:{
    getUser(){
      const _this=this;
      axios.get('admin/getUser',qs.stringify({}))
          .then(res=>{
            const data=res.data;
            if(data.code==200){
              _this.main=data.data;
            }else {
              alert(data.message);
            }

          });
    },
  }
}
</script>

<style scoped>
.textBody1{
  width: 100px;
  height: 200px;
}
</style>