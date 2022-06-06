package com.wllfengshu.jmj.provider.api.room.model.joinroom;

import com.wllfengshu.jmj.common.entity.gateway.GatewayRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-06-05 9:30
 */
@Data
public class JoinRoomRequest extends GatewayRequest {

    @ApiModelProperty("房间号")
    private String roomId;

    @ApiModelProperty("房间密码")
    private String roomPassword;
}
