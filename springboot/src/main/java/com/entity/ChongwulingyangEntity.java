package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 宠物领养
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-05 19:42:59
 */
@TableName("chongwulingyang")
public class ChongwulingyangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChongwulingyangEntity() {
		
	}
	
	public ChongwulingyangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 宠物名称
	 */
					
	private String chongwumingcheng;
	
	/**
	 * 宠物分类
	 */
					
	private String chongwufenlei;
	
	/**
	 * 宠物图片
	 */
					
	private String chongwutupian;
	
	/**
	 * 宠物性别
	 */
					
	private String chongwuxingbie;
	
	/**
	 * 接种疫苗
	 */
					
	private String jiezhongyimiao;
	
	/**
	 * 宠物性情
	 */
					
	private String chongwuxingqing;
	
	/**
	 * 宠物详情
	 */
					
	private String chongwuxiangqing;
	
	/**
	 * 领养要求
	 */
					
	private String lingyangyaoqiu;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 发布日期
	 */
					
	private String faburiqi;
	
	/**
	 * 领养申请
	 */
					
	private String lingyangshenqing;
	
	/**
	 * 申请备注
	 */
					
	private String shenqingbeizhu;
	
	/**
	 * 申请日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingriqi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：宠物名称
	 */
	public void setChongwumingcheng(String chongwumingcheng) {
		this.chongwumingcheng = chongwumingcheng;
	}
	/**
	 * 获取：宠物名称
	 */
	public String getChongwumingcheng() {
		return chongwumingcheng;
	}
	/**
	 * 设置：宠物分类
	 */
	public void setChongwufenlei(String chongwufenlei) {
		this.chongwufenlei = chongwufenlei;
	}
	/**
	 * 获取：宠物分类
	 */
	public String getChongwufenlei() {
		return chongwufenlei;
	}
	/**
	 * 设置：宠物图片
	 */
	public void setChongwutupian(String chongwutupian) {
		this.chongwutupian = chongwutupian;
	}
	/**
	 * 获取：宠物图片
	 */
	public String getChongwutupian() {
		return chongwutupian;
	}
	/**
	 * 设置：宠物性别
	 */
	public void setChongwuxingbie(String chongwuxingbie) {
		this.chongwuxingbie = chongwuxingbie;
	}
	/**
	 * 获取：宠物性别
	 */
	public String getChongwuxingbie() {
		return chongwuxingbie;
	}
	/**
	 * 设置：接种疫苗
	 */
	public void setJiezhongyimiao(String jiezhongyimiao) {
		this.jiezhongyimiao = jiezhongyimiao;
	}
	/**
	 * 获取：接种疫苗
	 */
	public String getJiezhongyimiao() {
		return jiezhongyimiao;
	}
	/**
	 * 设置：宠物性情
	 */
	public void setChongwuxingqing(String chongwuxingqing) {
		this.chongwuxingqing = chongwuxingqing;
	}
	/**
	 * 获取：宠物性情
	 */
	public String getChongwuxingqing() {
		return chongwuxingqing;
	}
	/**
	 * 设置：宠物详情
	 */
	public void setChongwuxiangqing(String chongwuxiangqing) {
		this.chongwuxiangqing = chongwuxiangqing;
	}
	/**
	 * 获取：宠物详情
	 */
	public String getChongwuxiangqing() {
		return chongwuxiangqing;
	}
	/**
	 * 设置：领养要求
	 */
	public void setLingyangyaoqiu(String lingyangyaoqiu) {
		this.lingyangyaoqiu = lingyangyaoqiu;
	}
	/**
	 * 获取：领养要求
	 */
	public String getLingyangyaoqiu() {
		return lingyangyaoqiu;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：发布日期
	 */
	public void setFaburiqi(String faburiqi) {
		this.faburiqi = faburiqi;
	}
	/**
	 * 获取：发布日期
	 */
	public String getFaburiqi() {
		return faburiqi;
	}
	/**
	 * 设置：领养申请
	 */
	public void setLingyangshenqing(String lingyangshenqing) {
		this.lingyangshenqing = lingyangshenqing;
	}
	/**
	 * 获取：领养申请
	 */
	public String getLingyangshenqing() {
		return lingyangshenqing;
	}
	/**
	 * 设置：申请备注
	 */
	public void setShenqingbeizhu(String shenqingbeizhu) {
		this.shenqingbeizhu = shenqingbeizhu;
	}
	/**
	 * 获取：申请备注
	 */
	public String getShenqingbeizhu() {
		return shenqingbeizhu;
	}
	/**
	 * 设置：申请日期
	 */
	public void setShenqingriqi(Date shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getShenqingriqi() {
		return shenqingriqi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
