package com.wllfengshu.jmj.provider.player.biz.logout;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutRequest;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutResponse;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-21 16:55
 */
@Service
public class LogoutBiz extends AbstractInterfaceBase<LogoutRequest, LogoutResponse> {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    protected String giveActionName() {
        return "logout";
    }

    @Override
    protected boolean checkRequest(LogoutRequest request) {
        return StringUtils.isNoneEmpty(request.getToken());
    }

    @Override
    public LogoutResponse doProcess(LogoutRequest request) {
        LogoutResponse response = new LogoutResponse();
        return response;
    }
}
