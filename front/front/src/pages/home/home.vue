<template>
<div class="home-preview" :style='{"width":"100%","padding":"10px 20px 0","margin":"20px 0 0","flexWrap":"wrap","justifyContent":"center","display":"block"}'>

		
									<div class="news" :style='{"padding":"20px 0","margin":"20px auto 20px","borderColor":"#98c6e2","overflow":"hidden","borderRadius":"0px","background":"none","borderWidth":"0 0 8px","width":"100%","position":"relative","borderStyle":"dotted","height":"auto"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"0","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between"}'>
			<div class="box1" :style='{"width":"1200px","margin":"0 auto","position":"absolute","top":"74px","background":"#08b344","height":"1px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<!-- <div class="title" :style='{"padding":"0","margin":"30px auto 30px","borderRadius":"0px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230101/6c449007e7a54a8892733c2b466c35cb.png) no-repeat center top","width":"100%","lineHeight":"56px","position":"relative","height":"56px"}'>
			<span :style='{"padding":"0","fontSize":"24px","color":"#fff","textShadow":"0px 0px 0px #eee","background":"none"}'>宠物资讯</span>
		</div>
		 -->
			
			
			
			
			<!-- 样式四 -->
		<!-- <div v-if="newsList.length" class="list list4 index-pv1" :style='{"padding":"10px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
		    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"cursor":"pointer","padding":"10px","margin":"0 1% 0 0","textAlign":"center","background":"none","width":"48%","height":"300px","order":"1"}'>
				<div :style='{"padding":"0 20px","margin":"0px","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","borderRadius":"0","textAlign":"left","background":"linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 25%, rgba(48,134,185,1) 100%),#3086b9","fontSize":"14px","lineHeight":"32px","textOverflow":"ellipsis"}' class="new-list-item-title line1">{{newsList[0].title}}</div>
				<div :style='{"padding":"10px","boxShadow":"0px 0px 4px #eee","margin":"0 0 10px","borderColor":"#ffec9d","color":"#666","textAlign":"left","textIndent":"2em","overflow":"hidden","background":"#fff","borderWidth":"0px","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","height":"212px"}' class="descript  line3">{{newsList[0].introduction}}</div>
				<div :style='{"padding":"0px","margin":"0px  auto","color":"#666","borderRadius":"0px","textAlign":"right","background":"none","display":"block","width":"100%","fontSize":"12px"}' class="time">{{newsList[0].addtime}}</div>
		    </div>
		    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"cursor":"pointer","padding":"10px","borderColor":"#9dcde9","margin":"0 1% 0 0","borderRadius":"8px 8px 0 0","background":"rgba(255,255,255,.3)","borderWidth":"8px","width":"48%","borderStyle":"dotted","height":"300px","order":"2"}'>
				<img :style='{"width":"100%","padding":"0px","objectFit":"cover","borderRadius":"0px","height":"100%"}' :src="baseUrl + newsList[0].picture" alt="">
		    </div>
		    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"cursor":"pointer","padding":"10px","margin":"1% 1% 0 0","background":"none","width":"48%","height":"300px","order":"4"}'>
				<div :style='{"padding":"0 20px","margin":"0 0 0px","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","borderRadius":"0 ","textAlign":"left","background":"linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 25%, rgba(48,134,185,1) 100%),#3086b9","fontSize":"14px","lineHeight":"32px","textOverflow":"ellipsis","height":"32px"}' class="new-list-item-title line1">{{newsList[1].title}}</div>
				<div :style='{"padding":"10px","boxShadow":"0px 0px 4px #eee","margin":"0 0 10px","borderColor":"#ffec9d","color":"#666","textIndent":"2em","overflow":"hidden","borderWidth":"0px","background":"#fff","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","height":"212px"}' class="descript  line3">{{newsList[1].introduction}}</div>
				<div :style='{"color":"#666","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[1].addtime}}</div>
		    </div>
		    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"cursor":"pointer","border":"8px dotted #9dcde9","padding":"10px","margin":"0 1% 0 0","borderRadius":"0","background":"#fff","width":"48%","height":"300px","order":"3"}'>
				<img :style='{"width":"100%","padding":"0px","objectFit":"cover","borderRadius":"0px","height":"100%"}' :src="baseUrl + newsList[1].picture" alt="">
		    </div>
		    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"cursor":"pointer","padding":"10px","margin":"1% 1% 0 0","background":"none","width":"48%","height":"300px","order":"5"}'>
				<div :style='{"padding":"0 20px","margin":"0 0 0px","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","borderRadius":"0","textAlign":"left","background":"linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 25%, rgba(48,134,185,1) 100%),#3086b9","fontSize":"14px","lineHeight":"32px","textOverflow":"ellipsis","height":"32px"}' class="new-list-item-title  line1">{{newsList[2].title}}</div>
				<div :style='{"padding":"10px","boxShadow":"0px 0px 4px #eee","margin":"0 0 10px","borderColor":"#ffec9d","overflow":"hidden","color":"#666","borderWidth":"0px","background":"#fff","fontSize":"14px","lineHeight":"24px","borderStyle":"solid","height":"212px"}' class="descript  line3">{{newsList[2].introduction}}</div>
				<div :style='{"color":"#666","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[2].addtime}}</div>
		    </div>
		    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"cursor":"pointer","border":"8px dotted #9dcde9","padding":"10px","margin":"0 1% 0 0","borderRadius":"0","background":"rgba(255,255,255,.3)","width":"48%","height":"300px","order":"6"}'>
				<img :style='{"width":"100%","padding":"0px","objectFit":"cover","borderRadius":"0px","height":"100%"}' :src="baseUrl + newsList[2].picture" alt="">
		    </div>
		</div> -->
			
			
			
			
			
			
			
		<!-- <div @click="moreBtn('news')" :style='{"cursor":"pointer","boxShadow":"0px 0px 0px #ddd5c6,inset 0px 0px 0px 0px #ffa100","padding":"0 20px","margin":"20px auto 40px","borderColor":"#9dcde9","textAlign":"center","display":"block","borderRadius":"0px","background":"#fff","borderWidth":"8px 0px 6px 0px","width":"130px","lineHeight":"40px","borderStyle":"dotted"}'>
			<span :style='{"color":"#333","background":"none","fontSize":"16px"}'>查看更多</span>
			<i v-if="true" :style='{"color":"#333","fontSize":"16px","display":"inline-block"}' class="el-icon-d-arrow-right"></i>
		</div> -->
		
		</div>
				




<!-- <div class="lists" :style='{"padding":"0px","boxShadow":"0px 0px 0px #eee","margin":"20px auto 20px","borderColor":"#98c6e2","display":"flex","overflow":"hidden","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0 0 8px","width":"100%","position":"relative","borderStyle":"dotted","height":"auto","order":"8"}'>
	<div v-if="false" class="idea" :style='{"padding":"0px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"1200px","position":"absolute","top":"74px","background":"#08b344","height":"1px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"0","margin":"30px auto 30px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230101/6c449007e7a54a8892733c2b466c35cb.png) no-repeat center top","width":"100%","lineHeight":"56px","position":"relative","height":"56px"}'>
	  <span :style='{"padding":"0","fontSize":"24px","color":"#fff","textShadow":"0px 0px 0px #eee","background":"none"}'>宠物信息展示</span>
	</div>
	
	
	
	<div class="list list2 index-pv1" :style='{"width":"100%","padding":"0 10px","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>
		<div :style='{"padding":"10px","boxShadow":"0px 0px 4px #eee","margin":"10px","borderColor":"#eee","display":"flex","flexWrap":"wrap","background":"#fff","borderWidth":"1px","width":"48%","fontSize":"0","position":"relative","borderStyle":"solid","height":"240px"}' v-for="(item,index) in chongwuxinxiList" class="list-item animation-box" :key="index" @click="toDetail('chongwuxinxiDetail', item)">
			<img :style='{"cursor":"pointer","padding":"10px","borderColor":"#9dcde9","objectFit":"cover","borderWidth":"4px","display":"inline-block","width":"48%","borderStyle":"dotted","height":"100%"}' v-if="preHttp(item.chongwutupian)" :src="item.chongwutupian.split(',')[0]" alt="" />
			<img :style='{"cursor":"pointer","padding":"10px","borderColor":"#9dcde9","objectFit":"cover","borderWidth":"4px","display":"inline-block","width":"48%","borderStyle":"dotted","height":"100%"}' v-else :src="baseUrl +  (item.chongwutupian?item.chongwutupian.split(',')[0]:'')" alt="" />
			<div :style='{"width":"48%","padding":"0px 10px","overflow":"hidden","display":"inline-block","height":"100%"}' class="item-info">
				<div class="name line1" :style='{"padding":"0 10px","borderColor":"#9dcde9","margin":"0 0 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderWidth":"0 0 2px","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"dotted"}'>宠物名称:{{item.chongwumingcheng}}</div>
				<div class="name line1" :style='{"padding":"0 10px","borderColor":"#9dcde9","margin":"0 0 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderWidth":"0 0 2px","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"dotted"}'>宠物分类:{{item.chongwufenlei}}</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<div @click="moreBtn('chongwuxinxi')" :style='{"cursor":"pointer","margin":"20px auto 40px","borderColor":"#9dcde9","borderRadius":"0px","textAlign":"center","background":"#fff","borderWidth":"8px 0px 6px 0px","display":"block","width":"auto","lineHeight":"40px","borderStyle":"dotted"}'>
		<span :style='{"padding":"0 0 0 10px","borderColor":"#ccc","margin":"0","color":"#333","background":"none","borderWidth":"0","display":"inline-block","width":"100px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>查看更多</span>
		<i v-if="true" :style='{"padding":"0 20px 0 0","borderColor":"#ccc","margin":"0 0 0 -10px","color":"#333","borderWidth":"0","background":"none","display":"inline-block","width":"40px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div> -->
<!-- <div class="lists" :style='{"padding":"0px","boxShadow":"0px 0px 0px #eee","margin":"20px auto 20px","borderColor":"#98c6e2","display":"flex","overflow":"hidden","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0 0 8px","width":"100%","position":"relative","borderStyle":"dotted","height":"auto","order":"8"}'>
	<div v-if="false" class="idea" :style='{"padding":"0px","margin":"0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"1200px","justifyContent":"space-between"}'>
		<div class="box1" :style='{"width":"1200px","position":"absolute","top":"74px","background":"#08b344","height":"1px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"padding":"0","margin":"30px auto 30px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230101/6c449007e7a54a8892733c2b466c35cb.png) no-repeat center top","width":"100%","lineHeight":"56px","position":"relative","height":"56px"}'>
	  <span :style='{"padding":"0","fontSize":"24px","color":"#fff","textShadow":"0px 0px 0px #eee","background":"none"}'>宠物用品展示</span>
	</div>
	
	
	
	<div class="list list2 index-pv1" :style='{"width":"100%","padding":"0 10px","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>
		<div :style='{"padding":"10px","boxShadow":"0px 0px 4px #eee","margin":"10px","borderColor":"#eee","display":"flex","flexWrap":"wrap","background":"#fff","borderWidth":"1px","width":"48%","fontSize":"0","position":"relative","borderStyle":"solid","height":"240px"}' v-for="(item,index) in chongwuyongpinList" class="list-item animation-box" :key="index" @click="toDetail('chongwuyongpinDetail', item)">
			<img :style='{"cursor":"pointer","padding":"10px","borderColor":"#9dcde9","objectFit":"cover","borderWidth":"4px","display":"inline-block","width":"48%","borderStyle":"dotted","height":"100%"}' v-if="preHttp(item.shangpinfengmian)" :src="item.shangpinfengmian.split(',')[0]" alt="" />
			<img :style='{"cursor":"pointer","padding":"10px","borderColor":"#9dcde9","objectFit":"cover","borderWidth":"4px","display":"inline-block","width":"48%","borderStyle":"dotted","height":"100%"}' v-else :src="baseUrl +  (item.shangpinfengmian?item.shangpinfengmian.split(',')[0]:'')" alt="" />
			<div :style='{"width":"48%","padding":"0px 10px","overflow":"hidden","display":"inline-block","height":"100%"}' class="item-info">
				<div class="name line1" :style='{"padding":"0 10px","borderColor":"#9dcde9","margin":"0 0 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#333","borderWidth":"0 0 2px","lineHeight":"40px","fontSize":"14px","textOverflow":"ellipsis","borderStyle":"dotted"}'>{{item.shangpinmingcheng}}</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	<div @click="moreBtn('chongwuyongpin')" :style='{"cursor":"pointer","margin":"20px auto 40px","borderColor":"#9dcde9","borderRadius":"0px","textAlign":"center","background":"#fff","borderWidth":"8px 0px 6px 0px","display":"block","width":"auto","lineHeight":"40px","borderStyle":"dotted"}'>
		<span :style='{"padding":"0 0 0 10px","borderColor":"#ccc","margin":"0","color":"#333","background":"none","borderWidth":"0","display":"inline-block","width":"100px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}'>查看更多</span>
		<i v-if="true" :style='{"padding":"0 20px 0 0","borderColor":"#ccc","margin":"0 0 0 -10px","color":"#333","borderWidth":"0","background":"none","display":"inline-block","width":"40px","fontSize":"16px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div> -->


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],

        chongwuxinxiList: [],
        chongwuyongpinList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 6,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('chongwuxinxi/list', {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.chongwuxinxiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('chongwuyongpin/list', {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.chongwuyongpinList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				filter: brightness(1);
				transform: scale(0.9);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: all 0.3s ease-in-out 0s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				filter: brightness(1);
				transform: scale(0.9);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: all 0.3s ease-in-out 0s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #08b344;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: #08b344;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: scale(0.9);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				opacity: 1;
				transition: all 0.3s ease-in-out 0s;
			}
		}
	}
</style>
