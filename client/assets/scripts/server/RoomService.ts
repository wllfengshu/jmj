import BaseService from "./BaseService";

export default class RoomService extends BaseService {
     private static readonly serverName : string = "jmj-provider-room";
     public static readonly instance : RoomService = new RoomService();

     // 获取房间
     public giveRoom(request : GiveRoomRequest) : GiveRoomResponse {
          return <GiveRoomResponse> JSON.parse(super.callInterface(RoomService.serverName, "giveRoom", request));
     }

     // 创建房间
     public createRoom(request : CreateRoomRequest) : CreateRoomResponse {
          return <CreateRoomResponse> JSON.parse(super.callInterface(RoomService.serverName, "createRoom", request));
     }

     // 加入房间
     public joinRoom(request : JoinRoomRequest) : JoinRoomResponse {
          return <JoinRoomResponse> JSON.parse(super.callInterface(RoomService.serverName, "joinRoom", request));
     }

}

