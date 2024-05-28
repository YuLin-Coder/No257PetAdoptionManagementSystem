package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChongwuxinxiDao;
import com.entity.ChongwuxinxiEntity;
import com.service.ChongwuxinxiService;
import com.entity.vo.ChongwuxinxiVO;
import com.entity.view.ChongwuxinxiView;

@Service("chongwuxinxiService")
public class ChongwuxinxiServiceImpl extends ServiceImpl<ChongwuxinxiDao, ChongwuxinxiEntity> implements ChongwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwuxinxiEntity> page = this.selectPage(
                new Query<ChongwuxinxiEntity>(params).getPage(),
                new EntityWrapper<ChongwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwuxinxiEntity> wrapper) {
		  Page<ChongwuxinxiView> page =new Query<ChongwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwuxinxiVO> selectListVO(Wrapper<ChongwuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwuxinxiVO selectVO(Wrapper<ChongwuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwuxinxiView> selectListView(Wrapper<ChongwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwuxinxiView selectView(Wrapper<ChongwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
