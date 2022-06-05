package com.wllfengshu.jmj.provider.api.room.model.createroom;

import com.wllfengshu.jmj.common.entity.gateway.GatewayRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-06-05 9:30
 */
@Data
public class CreateRoomRequest extends GatewayRequest {

    @ApiModelProperty("房间密码")
    private String roomPassword;
}
