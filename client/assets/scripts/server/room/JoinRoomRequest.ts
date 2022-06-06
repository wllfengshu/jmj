interface JoinRoomRequest extends GatewayRequest {
     // 房间号
     roomId?: string;
     // 房间密码
     roomPassword?: string;
}
