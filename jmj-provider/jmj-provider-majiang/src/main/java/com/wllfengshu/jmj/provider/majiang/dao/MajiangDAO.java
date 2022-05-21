package com.wllfengshu.jmj.provider.majiang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllfengshu.jmj.provider.api.majiang.model.MajiangPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库操作-麻将
 *
 * @author wangll
 * @date 2022-05-21 21:24
 */
@Mapper
public interface MajiangDAO extends BaseMapper<MajiangPO> {
}
