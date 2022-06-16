import ConstantUtil from "./ConstantUtil";

/**
 * 本地缓存工具类
 */
export default class LocalCacheUtil {

    /**
     * 存缓存
     */
    public static setLocalStorage(key : string, content : any) : void {
        let result : string;
        if(typeof content === "string") {
            result = content;
        }else {
            result = JSON.stringify(content);
        }
        cc.sys.localStorage.setItem(key, result);
    }

    /**
     * 获取token
     */
    public static getToken() {
        return cc.sys.localStorage.getItem(ConstantUtil.TOKEN);
    }
    
    /**
     * 获取玩家信息
     */
     public static getPlayerPO() {
        return <PlayerPO> JSON.parse(cc.sys.localStorage.getItem(ConstantUtil.LOGIN_INFO));
    }
}
