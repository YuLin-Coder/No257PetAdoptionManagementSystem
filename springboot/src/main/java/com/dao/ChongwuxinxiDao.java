package com.dao;

import com.entity.ChongwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwuxinxiVO;
import com.entity.view.ChongwuxinxiView;


/**
 * 宠物信息
 * 
 * @author 
 * @email 
 * @date 2023-03-05 19:42:59
 */
public interface ChongwuxinxiDao extends BaseMapper<ChongwuxinxiEntity> {
	
	List<ChongwuxinxiVO> selectListVO(@Param("ew") Wrapper<ChongwuxinxiEntity> wrapper);
	
	ChongwuxinxiVO selectVO(@Param("ew") Wrapper<ChongwuxinxiEntity> wrapper);
	
	List<ChongwuxinxiView> selectListView(@Param("ew") Wrapper<ChongwuxinxiEntity> wrapper);

	List<ChongwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwuxinxiEntity> wrapper);
	
	ChongwuxinxiView selectView(@Param("ew") Wrapper<ChongwuxinxiEntity> wrapper);
	

}
