package com.entity.view;

import com.entity.ChongwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-05 19:42:59
 */
@TableName("chongwuxinxi")
public class ChongwuxinxiView  extends ChongwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChongwuxinxiView(){
	}
 
 	public ChongwuxinxiView(ChongwuxinxiEntity chongwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, chongwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
