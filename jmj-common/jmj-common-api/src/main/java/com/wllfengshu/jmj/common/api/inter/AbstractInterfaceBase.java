package com.wllfengshu.jmj.common.api.inter;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.common.entity.gateway.enumeration.ResponseStatusEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 所有的接口都必须继承该类（对外提供服务的接口）
 *
 * @author wangll
 * @date 2022-05-21 22:52
 */
@Slf4j
public abstract class AbstractInterfaceBase<Request, Response extends GatewayResponse> {

    /**
     * 获取接口名称，例如：login
     */
    protected abstract String giveActionName();

    /**
     * 校验请求（子类可以重新该方法实现更负责的校验）
     *
     * @param request
     * @return
     */
    protected boolean checkRequest(Request request) {
        return null != request;
    }

    /**
     * 执行业务逻辑（由子类实现）
     *
     * @param request
     * @return
     */
    protected abstract Response doProcess(Request request);

    /**
     * 接口流程控制（外部调用的入口）
     *
     * @param request
     * @return
     */
    public Response process(Request request) {
        try {
            // 1check
            if (!this.checkRequest(request)) {
                log.error("[process-checkRequestIsFalse] actionName = {}, request = {}", this.giveActionName(), request);
                return null;
            }
            // 2run
            Response response = doProcess(request);
            response.setResponseStatusEnum(ResponseStatusEnum.SUCCESS);
            return response;
        }catch (Exception e) {
            log.error("[process-error] actionName = {}", this.giveActionName(), e);
            Response response = (Response) new GatewayResponse();
            response.setResponseStatusEnum(ResponseStatusEnum.FAIL);
            return response;
        }
    }
}
