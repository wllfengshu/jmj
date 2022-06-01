/// <reference path = "./model/LoginRequest.ts" />

import { json } from "stream/consumers";
import LogUtil from "../utils/LogUtil";
import BaseServer from "./BaseServer";
import LoginResponse from "./model/LoginResponse";

const {ccclass, property} = cc._decorator;

/**
 * 玩家服务
 */
export default class PlayerServer extends BaseServer {

    private static readonly serverName : string = "jmj-provider-player";
    public static readonly instance : PlayerServer = new PlayerServer();

    /**
     * 登陆
     * 
     * @param request 
     * @returns 
     */
    public login(request : SomeNameSpaceName.LoginRequest) : LoginResponse {
        return <LoginResponse> JSON.parse(super.callInterface(PlayerServer.serverName, "login", request));
    }

}
