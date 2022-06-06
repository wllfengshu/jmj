import BaseService from "./BaseService";

export default class PlayerService extends BaseService {
     private static readonly serverName : string = "jmj-provider-player";
     public static readonly instance : PlayerService = new PlayerService();

     // 注册
     public register(request : RegisterRequest) : RegisterResponse {
          return <RegisterResponse> JSON.parse(super.callInterface(PlayerService.serverName, "register", request));
     }

     // 通过token获取玩家信息
     public givePlayerByToken(request : GivePlayerByTokenRequest) : GivePlayerByTokenResponse {
          return <GivePlayerByTokenResponse> JSON.parse(super.callInterface(PlayerService.serverName, "givePlayerByToken", request));
     }

     // 登出
     public logout(request : LogoutRequest) : LogoutResponse {
          return <LogoutResponse> JSON.parse(super.callInterface(PlayerService.serverName, "logout", request));
     }

     // 登陆
     public login(request : LoginRequest) : LoginResponse {
          return <LoginResponse> JSON.parse(super.callInterface(PlayerService.serverName, "login", request));
     }

}

