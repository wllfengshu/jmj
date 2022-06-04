import BaseService from "./BaseService";

export default class HallService extends BaseService {
     private static readonly serverName : string = "jmj-provider-hall";
     public static readonly instance : HallService = new HallService();

     // 获取大厅
     public giveHall(request : GiveHallRequest) : GiveHallResponse {
          return <GiveHallResponse> JSON.parse(super.callInterface(HallService.serverName, "giveHall", request));
     }

}

