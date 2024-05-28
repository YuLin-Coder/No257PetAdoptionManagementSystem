<template>
  <div :style='{"width":"calc(100% - 40px)","padding":"30px 20px 40px","margin":"20px auto 0","position":"relative","background":"rgba(255,255,255,.3)"}'>
    <div class="section-title" :style='{"padding":"30px 0 30px","margin":"20px auto 20px","borderColor":"#9dcde9","color":"#333","textAlign":"center","borderRadius":"0px","background":"linear-gradient(320deg, rgba(204,204,204,.0) 0%, rgba(255,255,255,.9) 80%, rgba(204,204,204,.0) 100%)","borderWidth":"6px","width":"100%","fontSize":"30px","lineHeight":"30px","borderStyle":"dotted","fontWeight":"600"}'>宠物资讯</div>
    <div class="section-content">
      <div class="content-title">{{detail.title}}</div>
      <div class="content-sub-title">发布时间：{{detail.addtime}}</div>
      <el-divider></el-divider>
      <div class="content-detail" v-html="detail.content"></div>
    </div>
  </div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        detail: {},
      }
    },
    created() {
      this.detail = Object.assign({}, JSON.parse(this.$route.query.detailObj));
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .section-content {
      margin-top: 30px;
  }
  .content-title {
      text-align: center;
      font-size: 22px;
      font-weight: bold;
  }
  .content-sub-title {
      text-align: center;
      margin-top: 20px;
      color: #888888;
      font-size: 14px;
  }
</style>