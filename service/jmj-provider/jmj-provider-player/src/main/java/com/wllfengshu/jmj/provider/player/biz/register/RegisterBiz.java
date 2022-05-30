package com.wllfengshu.jmj.provider.player.biz.register;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.player.enumeration.ProviderEnum;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterRequest;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterResponse;
import com.wllfengshu.jmj.provider.player.constant.ProviderConstant;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author wangll
 * @date 2022-05-21 16:55
 */
@Service
public class RegisterBiz extends AbstractInterfaceBase<RegisterRequest, RegisterResponse> {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    protected String giveActionName() {
        return "register";
    }

    @Override
    protected RegisterResponse doProcess(RegisterRequest request) {
        // 1验证两次密码是否一致
        if (!StringUtils.equals(request.getPassword(), request.getConfirmPassword())) {
            RegisterResponse response = new RegisterResponse();
            response.setBizResponseCode(ProviderEnum.THE_TWO_PASSWORDS_ARE_INCONSISTENT.getCode());
            response.setBizResponseDesc(ProviderEnum.THE_TWO_PASSWORDS_ARE_INCONSISTENT.getDesc());
            return response;
        }
        // 2查询username是否已经存在
        LambdaQueryWrapper<PlayerPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlayerPO::getUsername, request.getUsername());
        List<PlayerPO> oldPlayer = playerDAO.selectList(wrapper);
        if (!CollectionUtils.isEmpty(oldPlayer)) {
            RegisterResponse response = new RegisterResponse();
            response.setBizResponseCode(ProviderEnum.USER_EXISTS.getCode());
            response.setBizResponseDesc(ProviderEnum.USER_EXISTS.getDesc());
            return response;
        }
        // 3save
        PlayerPO po = new PlayerPO();
        po.setUsername(request.getUsername());
        po.setPassword(request.getPassword());
        po.setNickname(StringUtils.defaultIfEmpty(request.getNickname(), request.getUsername()));
        po.setHeadPortraitUrl(StringUtils.defaultIfEmpty(request.getHeadPortraitUrl(), ProviderConstant.REGISTER_HEAD_PORTRAIT_URL));
        int affNumber = playerDAO.insert(po);
        if (NumberUtils.INTEGER_ONE != affNumber) {
            RegisterResponse response = new RegisterResponse();
            response.setBizResponseCode(ProviderEnum.SAVE_USER_FAILED.getCode());
            response.setBizResponseDesc(ProviderEnum.SAVE_USER_FAILED.getDesc());
            return response;
        }
        // 4success
        RegisterResponse response = new RegisterResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        return response;
    }
}
