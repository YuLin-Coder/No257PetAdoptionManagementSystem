<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"center","background":"url(http://localhost:8080/springboot87gha/upload/11.jpg) no-repeat center top / 100% 100%","justifyContent":"center","display":"flex"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"20px 20px 30px","boxShadow":"0px 0px 0px #9cd8da,inset 0px 0px 0px 0px #e0f8e8","margin":"0","borderColor":"#00adb5  #00adb5 #00adb5 #00adb5","borderRadius":"30px","background":"rgba(255,255,255,.0)","borderWidth":"0px","width":"800px","borderStyle":"solid double double double","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 0 10px 0","fontSize":"24px","color":"#3086b9","textAlign":"center","fontWeight":"500"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 auto 20px","borderColor":"#c4deee","color":"#3086b9","textAlign":"center","borderWidth":"4px 0px","width":"80%","fontSize":"22px","lineHeight":"44px","borderStyle":"dotted dashed","fontWeight":"500"}'>宠物领养系统登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#ffa100"}'>账号：</div>
				<input :style='{"border":"0px solid #eacb96","padding":"0 10px","boxShadow":"0px 0px 0px #a0d8db","borderColor":"#c4deee","color":"#999","borderRadius":"0px","background":"#fff","borderWidth":"0 0 2px","width":"100%","fontSize":"14px","borderStyle":"dotted","height":"44px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#ffa100"}'>密码：</div>
				<input :style='{"border":"0px solid #eacb96","padding":"0 10px","boxShadow":"0px 0px 0px #a0d8db","borderColor":"#c4deee","color":"#999","borderRadius":"0px","background":"#fff","borderWidth":"0 0 2px","width":"100%","fontSize":"14px","borderStyle":"dotted","height":"44px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"20px auto","flexWrap":"wrap","textAlign":"center","justifyContent":"center","display":"flex"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #9cdde0","margin":"0 5px","color":"#fff","display":"inline-block","outline":"none","borderRadius":"0px","background":"linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%)","width":"128px","fontSize":"14px","height":"40px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0px solid #bbb","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #ccc","margin":"0 5px","color":"#333","display":"inline-block","outline":"none","borderRadius":"0px","background":"linear-gradient(320deg, rgba(204,204,204,1) 0%, rgba(255,255,255,1) 80%, rgba(204,204,204,1) 100%)","width":"128px","fontSize":"14px","height":"40px"}' @click="resetForm('loginForm')">重置</el-button>
                <el-upload v-if="loginType==2" :action="baseUrl + 'file/upload'" :show-file-list="false" :on-success="faceLogin">
                    <el-button :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"0px 0px 0px #9cdde0","margin":"0 5px","color":"#fff","display":"inline-block","outline":"none","borderRadius":"0px","background":"linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%)","width":"128px","fontSize":"14px","height":"40px"}'>人脸识别登录</el-button>
                </el-upload>
			</el-form-item>
			<div :style='{"width":"80%","margin":"20px auto"}'>
			<router-link :style='{"cursor":"pointer","padding":"4px 10px","margin":"0 10px 4px 0","color":"#3086b9","background":"linear-gradient(320deg, rgba(204,204,204,1) 0%, rgba(255,255,255,1) 80%, rgba(204,204,204,1) 100%)","fontSize":"14px","textDecoration":"none"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"宠物分类","menuJump":"列表","tableName":"chongwufenlei"}],"menu":"宠物分类管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除"],"menu":"宠物信息","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","删除","审核"],"menu":"宠物领养","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"宠物用品","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","修改","回复","删除"],"menu":"留言板","tableName":"messages"}],"menu":"留言板"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"宠物资讯","tableName":"news"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"},{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-circle","buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","物流"],"menu":"已发货订单","tableName":"orders/已发货"},{"appFrontIcon":"cuIcon-rank","buttons":["查看","删除","物流","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","领养申请"],"menu":"宠物信息列表","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除"],"menu":"宠物领养","menuJump":"列表","tableName":"chongwulingyang"}],"menu":"宠物领养管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","领养申请"],"menu":"宠物信息列表","menuJump":"列表","tableName":"chongwuxinxi"}],"menu":"宠物信息模块"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"宠物用品列表","menuJump":"列表","tableName":"chongwuyongpin"}],"menu":"宠物用品模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']

			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20221231/7a3226bd0dfc41549fbee764c9f6552d.jpg) no-repeat center top / 100% 100%;

		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}

		.list-item /deep/ .el-input .el-input__inner {
			border: 0px solid #eacb96;
			border-radius: 0px;
			padding: 0 10px;
			box-shadow: 0px 0px 0px #a0d8db;
			color: #999;
			background: #fff;
			width: 100%;
			font-size: 14px;
			border-color: #c4deee;
			border-width: 0 0 2px;
			border-style: dotted;
			height: 44px;
		}

		.list-code /deep/ .el-input .el-input__inner {
			border: 0px solid #eacb96;
			padding: 0 10px;
			color: #999;
			display: inline-block;
			vertical-align: middle;
			font-size: 14px;
			border-color: #c4deee;
			border-radius: 0px;
			box-shadow: 0px 0px 0px #a0d8db;
			outline: none;
			background: #fff;
			width: calc(100% - 80px);
			border-width: 0 0 2px;
			border-style: dotted;
			height: 44px;
		}

		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #3086b9;
			border-color: #3086b9;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #3086b9;
			font-size: 14px;
		}
	}
</style>
