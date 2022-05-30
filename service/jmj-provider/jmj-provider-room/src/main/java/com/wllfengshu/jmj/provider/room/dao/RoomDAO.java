package com.wllfengshu.jmj.provider.room.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllfengshu.jmj.provider.api.room.model.RoomPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库操作-房间
 *
 * @author wangll
 * @date 2022-05-21 21:24
 */
@Mapper
public interface RoomDAO extends BaseMapper<RoomPO> {
}
