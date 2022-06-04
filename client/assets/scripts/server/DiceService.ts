import BaseService from "./BaseService";

export default class DiceService extends BaseService {
     private static readonly serverName : string = "jmj-provider-dice";
     public static readonly instance : DiceService = new DiceService();

     // 获取骰子
     public giveDice(request : GiveDiceRequest) : GiveDiceResponse {
          return <GiveDiceResponse> JSON.parse(super.callInterface(DiceService.serverName, "giveDice", request));
     }

     // 掷骰子
     public doDice(request : DoDiceRequest) : DoDiceResponse {
          return <DoDiceResponse> JSON.parse(super.callInterface(DiceService.serverName, "doDice", request));
     }

}

