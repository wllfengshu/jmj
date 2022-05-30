package com.wllfengshu.jmj.provider.dice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wllfengshu.jmj.provider.api.dice.model.DicePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据库操作-骰子
 *
 * @author wangll
 * @date 2022-05-21 21:24
 */
@Mapper
public interface DiceDAO extends BaseMapper<DicePO> {
}
