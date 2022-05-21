package com.wllfengshu.jmj.provider.hall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllfengshu.jmj.provider.api.hall.model.HallPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库操作-大厅
 *
 * @author wangll
 * @date 2022-05-21 21:24
 */
@Mapper
public interface HallDAO extends BaseMapper<HallPO> {
}
