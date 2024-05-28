<template>
  <div>
    <el-form
	  :style='{"borderRadius":"6px","padding":"30px","margin":"30px"}'
      class="add-update-preview"
      ref="ruleForm"
      :rules="rules"
      :model="ruleForm"
      label-width="120px"
    >
      <el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' label="原密码" prop="password">
        <el-input v-model="ruleForm.password" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' label="新密码" prop="newpassword">
        <el-input v-model="ruleForm.newpassword" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' label="确认密码" prop="repassword">
        <el-input v-model="ruleForm.repassword" show-password></el-input>
      </el-form-item>
      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"linear-gradient(180deg, #DDE2FC 0%, #FCF6E5 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">确 定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dialogVisible: false,
      ruleForm: {},
      user: {},
      rules: {
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur"
          }
        ],
        newpassword: [
          {
            required: true,
            message: "新密码不能为空",
            trigger: "blur"
          }
        ],
        repassword: [
          {
            required: true,
            message: "确认密码不能为空",
            trigger: "blur"
          }
        ]
      }
    };
  },
  mounted() {
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.user = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    onLogout() {
      this.$storage.remove("Token");
      this.$router.replace({ name: "login" });
    },
    // 修改密码
    onUpdateHandler() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          var password = "";
          if (this.user.mima) {
            password = this.user.mima;
          } else if (this.user.password) {
            password = this.user.password;
          }
          if (this.user.password) {
            password = this.user.password;
          } else if (this.user.password) {
            password = this.user.password;
          }
          if (this.ruleForm.password != password) {
            this.$message.error("原密码错误");
            return;
          }
          if (this.ruleForm.newpassword != this.ruleForm.repassword) {
            this.$message.error("两次密码输入不一致");
            return;
          }
          this.user.password = this.ruleForm.newpassword;
          this.user.mima = this.ruleForm.newpassword;
          this.$http({
            url: `${this.$storage.get("sessionTable")}/update`,
            method: "post",
            data: this.user
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "修改密码成功,下次登录系统生效",
                type: "success",
                duration: 1500,
                onClose: () => {
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 120px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #BEBEBE;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #777;
	  	  width: 250px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #BEBEBE;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #777;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #BEBEBE;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #777;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #BEBEBE;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #777;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #BEBEBE;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #777;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #BEBEBE;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #777;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
