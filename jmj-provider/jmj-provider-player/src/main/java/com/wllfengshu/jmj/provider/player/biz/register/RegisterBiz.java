package com.wllfengshu.jmj.provider.player.biz.register;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterRequest;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterResponse;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    protected boolean checkRequest(RegisterRequest request) {
        return request.getUsername().equals(request.getConfirmPassword());
    }

    @Override
    protected RegisterResponse doProcess(RegisterRequest request) {
        // 1查询username是否已经存在

        // 2入库
        PlayerPO po = new PlayerPO();
        po.setUsername(request.getUsername());
        po.setPassword(request.getPassword());
        int affNumber = playerDAO.insert(po);
        if (1 != affNumber) {
            return null;
        }
        // 3返回成功的响应
        RegisterResponse response = new RegisterResponse();
        return new RegisterResponse();
    }
}
