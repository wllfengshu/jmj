import BaseService from "./BaseService";

export default class RoomService extends BaseService {
     private static readonly serverName : string = "jmj-provider-room";
     public static readonly instance : RoomService = new RoomService();

     // 获取房间
     public giveRoom(request : GiveRoomRequest) : GiveRoomResponse {
          return <GiveRoomResponse> JSON.parse(super.callInterface(RoomService.serverName, "giveRoom", request));
     }

}

