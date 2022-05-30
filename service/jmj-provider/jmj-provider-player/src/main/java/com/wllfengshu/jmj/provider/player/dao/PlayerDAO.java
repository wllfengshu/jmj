package com.wllfengshu.jmj.provider.player.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库操作-玩家
 *
 * @author wangll
 * @date 2022-05-21 21:24
 */
@Mapper
public interface PlayerDAO extends BaseMapper<PlayerPO> {
}
