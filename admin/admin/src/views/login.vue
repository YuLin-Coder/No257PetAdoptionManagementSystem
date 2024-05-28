<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20220718/fc966bb66236436093833a021b5a5511.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>

      <el-form :style='{"width":"1400px","padding":"40px 20px 20px","margin":"50px 0 0","position":"relative","borderRadius":"10px","height":"700px"}'>
        <div v-if="true" :style='{"padding":"0 150px","margin":"30px 0 180px 0","color":"rgba(0, 0, 0, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"30px","fontWeight":"600","height":"auto"}' class="title-container">宠物领养系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"38%","margin":"0 0 25px 5%","alignItems":"center","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>用户名</div>
          <input :style='{"border":"0px solid rgba(64, 158, 255, 1)","padding":"0 20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","color":"#000","outlineOffset":"0px","borderRadius":"40px","width":"100%","fontSize":"18px","height":"60px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"38%","margin":"0 0 25px 5%","alignItems":"center","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
          <input :style='{"border":"0px solid rgba(64, 158, 255, 1)","padding":"0 20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","color":"#000","outlineOffset":"0px","borderRadius":"40px","width":"100%","fontSize":"18px","height":"60px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div :style='{"width":"35%","textAlign":"center","margin":"20px 0 15px 5%"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>
        <div :style='{"padding":"0 10px","margin":"20px auto","alignItems":"center","top":"200px","flexWrap":"wrap","display":"flex","width":"60%","position":"absolute","right":"0","justifyContent":"center","height":"400px"}'>
          <el-button v-if="loginType==1" :style='{"border":"10px solid rgba(255, 255, 255, 1)","cursor":"pointer","padding":"0 24px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","margin":"0 10px","outline":"none","color":"rgba(0, 0, 0, 1)","borderRadius":"100px","background":"linear-gradient(180deg, #DAE0FF 0%, #FFF8E3 100%)","width":"160px","fontSize":"36px","height":"160px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";
export default {
  data() {
    return {
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {
    this.getRandCode()
  },
  destroyed() {
	    },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}

		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/index/" });
			} else {
				this.$message.error(data.msg);
			}
		});
    },
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20220718/fc966bb66236436093833a021b5a5511.png);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 0px solid rgba(64, 158, 255, 1);
		border-radius: 40px;
		padding: 0 20px;
		box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
		color: #000;
		width: 100%;
		font-size: 18px;
		outline-offset: 0px;
		height: 60px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 0px solid rgba(64, 158, 255, 1);
  	  	border-radius: 40px 0 0 40px;
  	  	padding: 0 20px;
  	  	box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3020);
  	  	outline: none;
  	  	color: #000;
  	  	width: 100%;
  	  	font-size: 18px;
  	  	height: 60px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #000;
        border-color: #000;
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #000;
        font-size: 14px;
      }
}
</style>
