var webpack=require('webpack');
module.exports={
    devServer:{
      // host:"192.168.3.135",
        //port:80,
        /*axios 代理链接全局配置*/
        /*proxy:{
        '/api':{
            target:'http://192.168.3.135:8088/jinrong_api/',//后端地址
            secure:false,// 如果是https接口，需要配置这个参数
            ws:true,//是否代理websockets
            changeOrigin:true,//前端工程化 axios跨域 配置
            pathRewrite:{
                '^/api':''
            }
        }
        }*/
    },
    /*全局支持jquery 以$形式注入jquery*/
    configureWebpack:{
     plugins:[
         // eslint-disable-next-line no-undef
         new webpack.ProvidePlugin({
             $:"jquery",
             jQuery:"jquery",
             "windows.jQuery":"jquery"
         })
     ]

    },
    /*为了方便前端工程化 打包部署的配置*/
    publicPath:'./',
    outputDir: "dist",
    // 静态资源存放的文件夹(相对于ouputDir)
    assetsDir: "assets",
    // eslint-loader 是否在保存的时候检查(果断不用，这玩意儿我都没装)
    lintOnSave:false,
    productionSourceMap: false, // 不需要生产环境的设置false可以减小dist文件大小，加速构建

}