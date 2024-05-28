module.exports = {
  lintOnSave: false,
  publicPath: process.env.NODE_ENV === 'development' ? './' : '././',
  outputDir: 'dist',
  devServer: {
    open: true,
    proxy: {
          '/springboot87gha':{
              target:'http://127.0.0.1:8081/',  //跨域的域名
              ws: true,  // 代理 websockets
              changeOrigin: true, //是否开启跨域
              // pathRewrite:{
              //     '^/springboot87gha':'/springboot87gha'  // 重写地址
              // }
          }
      }
  }
}