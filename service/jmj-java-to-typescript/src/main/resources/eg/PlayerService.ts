import BaseService from "../base/BaseService";

/**
 * 玩家服务
 */
export default class PlayerServer extends BaseService {

    private static readonly serverName : string = "jmj-provider-player";
    public static readonly instance : PlayerServer = new PlayerServer();

    /**
     * 登陆
     * 
     * @param request 
     * @returns 
     */
    public login(request : LoginRequest) : LoginResponse {
        return <LoginResponse> JSON.parse(super.callInterface(PlayerServer.serverName, "login", request));
    }

}
