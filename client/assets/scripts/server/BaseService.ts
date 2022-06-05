import ConstantUtil from "../utils/ConstantUtil";
import HttpUtil from "../utils/HttpUtil";

/**
 * 所有服务的基类
 * 说明：所有的外部接口都必须使用该类的子类去调用，不得随意发送http请求
 */
 export default class BaseService {

    /**
     * 调用接口
     * 
     * @param serverName 服务名称（对应后端服务的服务名，会拼接在请求的路径上）
     * @param operationName 操作名称（对应后端服务的接口名，会拼接在请求的路径上）
     * @param params 参数（全部会被转为json字符串后发送）
     */
    public callInterface(serverName : string, operationName : string, params : any) : string {
        let url = ConstantUtil.httpDomain + serverName + "/" + operationName;
        let token =  cc.sys.localStorage.getItem(ConstantUtil.TOKEN);
        return HttpUtil.sendHttpPost(url, params, token);
    }

}
