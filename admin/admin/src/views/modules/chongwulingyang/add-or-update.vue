<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"borderRadius":"6px","padding":"30px","margin":"30px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="120px"
		>
			<template >
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="宠物名称" prop="chongwumingcheng">
					<el-input v-model="ruleForm.chongwumingcheng" placeholder="宠物名称" clearable  :readonly="ro.chongwumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="宠物名称" prop="chongwumingcheng">
					<el-input v-model="ruleForm.chongwumingcheng" placeholder="宠物名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="宠物分类" prop="chongwufenlei">
					<el-input v-model="ruleForm.chongwufenlei" placeholder="宠物分类" clearable  :readonly="ro.chongwufenlei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="宠物分类" prop="chongwufenlei">
					<el-input v-model="ruleForm.chongwufenlei" placeholder="宠物分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.chongwutupian" label="宠物图片" prop="chongwutupian">
					<file-upload
						tip="点击上传宠物图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.chongwutupian?ruleForm.chongwutupian:''"
						@change="chongwutupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="upload" v-else-if="ruleForm.chongwutupian" label="宠物图片" prop="chongwutupian">
					<img v-if="ruleForm.chongwutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.chongwutupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.chongwutupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="宠物性别" prop="chongwuxingbie">
					<el-input v-model="ruleForm.chongwuxingbie" placeholder="宠物性别" clearable  :readonly="ro.chongwuxingbie"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="宠物性别" prop="chongwuxingbie">
					<el-input v-model="ruleForm.chongwuxingbie" placeholder="宠物性别" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="接种疫苗" prop="jiezhongyimiao">
					<el-input v-model="ruleForm.jiezhongyimiao" placeholder="接种疫苗" clearable  :readonly="ro.jiezhongyimiao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="接种疫苗" prop="jiezhongyimiao">
					<el-input v-model="ruleForm.jiezhongyimiao" placeholder="接种疫苗" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="宠物性情" prop="chongwuxingqing">
					<el-input v-model="ruleForm.chongwuxingqing" placeholder="宠物性情" clearable  :readonly="ro.chongwuxingqing"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="宠物性情" prop="chongwuxingqing">
					<el-input v-model="ruleForm.chongwuxingqing" placeholder="宠物性情" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="领养要求" prop="lingyangyaoqiu">
					<el-input v-model="ruleForm.lingyangyaoqiu" placeholder="领养要求" clearable  :readonly="ro.lingyangyaoqiu"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="领养要求" prop="lingyangyaoqiu">
					<el-input v-model="ruleForm.lingyangyaoqiu" placeholder="领养要求" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="备注" prop="beizhu">
					<el-input v-model="ruleForm.beizhu" placeholder="备注" clearable  :readonly="ro.beizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="备注" prop="beizhu">
					<el-input v-model="ruleForm.beizhu" placeholder="备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="发布日期" prop="faburiqi">
					<el-input v-model="ruleForm.faburiqi" placeholder="发布日期" clearable  :readonly="ro.faburiqi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="发布日期" prop="faburiqi">
					<el-input v-model="ruleForm.faburiqi" placeholder="发布日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="领养申请" prop="lingyangshenqing">
					<el-input v-model="ruleForm.lingyangshenqing" placeholder="领养申请" clearable  :readonly="ro.lingyangshenqing"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="领养申请" prop="lingyangshenqing">
					<el-input v-model="ruleForm.lingyangshenqing" placeholder="领养申请" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="申请备注" prop="shenqingbeizhu">
					<el-input v-model="ruleForm.shenqingbeizhu" placeholder="申请备注" clearable  :readonly="ro.shenqingbeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="申请备注" prop="shenqingbeizhu">
					<el-input v-model="ruleForm.shenqingbeizhu" placeholder="申请备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="date" v-if="type!='info'" label="申请日期" prop="shenqingriqi">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shenqingriqi" 
						type="datetime"
						:readonly="ro.shenqingriqi"
						placeholder="申请日期"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-else-if="ruleForm.shenqingriqi" label="申请日期" prop="shenqingriqi">
					<el-input v-model="ruleForm.shenqingriqi" placeholder="申请日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-if="type!='info'"  label="宠物详情" prop="chongwuxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.chongwuxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0.5% 20px","display":"inline-block"}' v-else-if="ruleForm.chongwuxiangqing" label="宠物详情" prop="chongwuxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#777","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.chongwuxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"linear-gradient(180deg, #DDE2FC 0%, #FCF6E5 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(218, 224, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#777","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(218, 224, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#777","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				chongwumingcheng : false,
				chongwufenlei : false,
				chongwutupian : false,
				chongwuxingbie : false,
				jiezhongyimiao : false,
				chongwuxingqing : false,
				chongwuxiangqing : false,
				lingyangyaoqiu : false,
				beizhu : false,
				faburiqi : false,
				lingyangshenqing : false,
				shenqingbeizhu : false,
				shenqingriqi : false,
				yonghuzhanghao : false,
				xingming : false,
				shouji : false,
				sfsh : false,
				shhf : false,
			},
			
			
			ruleForm: {
				chongwumingcheng: '',
				chongwufenlei: '',
				chongwutupian: '',
				chongwuxingbie: '',
				jiezhongyimiao: '',
				chongwuxingqing: '',
				chongwuxiangqing: '',
				lingyangyaoqiu: '',
				beizhu: '',
				faburiqi: '',
				lingyangshenqing: '',
				shenqingbeizhu: '',
				shenqingriqi: '',
				yonghuzhanghao: '',
				xingming: '',
				shouji: '',
				shhf: '',
			},
		
			
			rules: {
				chongwumingcheng: [
				],
				chongwufenlei: [
				],
				chongwutupian: [
				],
				chongwuxingbie: [
				],
				jiezhongyimiao: [
				],
				chongwuxingqing: [
				],
				chongwuxiangqing: [
				],
				lingyangyaoqiu: [
				],
				beizhu: [
				],
				faburiqi: [
				],
				lingyangshenqing: [
				],
				shenqingbeizhu: [
				],
				shenqingriqi: [
				],
				yonghuzhanghao: [
				],
				xingming: [
				],
				shouji: [
				],
				sfsh: [
				],
				shhf: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.shenqingriqi = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='chongwumingcheng'){
							this.ruleForm.chongwumingcheng = obj[o];
							this.ro.chongwumingcheng = true;
							continue;
						}
						if(o=='chongwufenlei'){
							this.ruleForm.chongwufenlei = obj[o];
							this.ro.chongwufenlei = true;
							continue;
						}
						if(o=='chongwutupian'){
							this.ruleForm.chongwutupian = obj[o];
							this.ro.chongwutupian = true;
							continue;
						}
						if(o=='chongwuxingbie'){
							this.ruleForm.chongwuxingbie = obj[o];
							this.ro.chongwuxingbie = true;
							continue;
						}
						if(o=='jiezhongyimiao'){
							this.ruleForm.jiezhongyimiao = obj[o];
							this.ro.jiezhongyimiao = true;
							continue;
						}
						if(o=='chongwuxingqing'){
							this.ruleForm.chongwuxingqing = obj[o];
							this.ro.chongwuxingqing = true;
							continue;
						}
						if(o=='chongwuxiangqing'){
							this.ruleForm.chongwuxiangqing = obj[o];
							this.ro.chongwuxiangqing = true;
							continue;
						}
						if(o=='lingyangyaoqiu'){
							this.ruleForm.lingyangyaoqiu = obj[o];
							this.ro.lingyangyaoqiu = true;
							continue;
						}
						if(o=='beizhu'){
							this.ruleForm.beizhu = obj[o];
							this.ro.beizhu = true;
							continue;
						}
						if(o=='faburiqi'){
							this.ruleForm.faburiqi = obj[o];
							this.ro.faburiqi = true;
							continue;
						}
						if(o=='lingyangshenqing'){
							this.ruleForm.lingyangshenqing = obj[o];
							this.ro.lingyangshenqing = true;
							continue;
						}
						if(o=='shenqingbeizhu'){
							this.ruleForm.shenqingbeizhu = obj[o];
							this.ro.shenqingbeizhu = true;
							continue;
						}
						if(o=='shenqingriqi'){
							this.ruleForm.shenqingriqi = obj[o];
							this.ro.shenqingriqi = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
				}
				


















			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingming = json.xingming
						this.ro.xingming = true;
					}
					if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shouji = json.shouji
						this.ro.shouji = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `chongwulingyang/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.chongwuxiangqing = this.ruleForm.chongwuxiangqing.replace(reg,'../../../springboot87gha/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.chongwutupian!=null) {
		this.ruleForm.chongwutupian = this.ruleForm.chongwutupian.replace(new RegExp(this.$base.url,"g"),"");
	}































var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "chongwulingyang/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `chongwulingyang/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.chongwulingyangCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `chongwulingyang/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.chongwulingyangCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.chongwulingyangCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    chongwutupianUploadChange(fileUrls) {
	    this.ruleForm.chongwutupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
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
	
	.add-update-preview /deep/ .upload .upload-img {
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
