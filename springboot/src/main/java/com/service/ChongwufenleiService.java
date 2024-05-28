package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwufenleiView;


/**
 * 宠物分类
 *
 * @author 
 * @email 
 * @date 2023-03-05 19:42:59
 */
public interface ChongwufenleiService extends IService<ChongwufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwufenleiVO> selectListVO(Wrapper<ChongwufenleiEntity> wrapper);
   	
   	ChongwufenleiVO selectVO(@Param("ew") Wrapper<ChongwufenleiEntity> wrapper);
   	
   	List<ChongwufenleiView> selectListView(Wrapper<ChongwufenleiEntity> wrapper);
   	
   	ChongwufenleiView selectView(@Param("ew") Wrapper<ChongwufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwufenleiEntity> wrapper);
   	

}

